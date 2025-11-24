import java.util.*;

import org.apache.commons.math3.fraction.Fraction;

public class Reaction {
    private Molecule[] reactants;
    private Molecule[] products;
    private int[] reactantsCoefficients;
    private int[] productsCoefficients;

    // expects a reaction formatted like "X{molecule} + X{molecule} -> X{molecule} + X{molecule}". spaces are important! X reflects the coefficient, and can be non-existent
    public Reaction(String reactionString) throws Element.ElementDoesNotExistException {
        List<Molecule> moleculeAccumulator = new ArrayList<>();
        List<Integer> coefficientsAccumulator = new ArrayList<>();
        String[] seperated = reactionString.split(" ");

        for (int moleculeIndex = 0; moleculeIndex < seperated.length; moleculeIndex++) {
            if (seperated[moleculeIndex].equals("->")) {
                moleculeIndex++;
                reactants = moleculeAccumulator.toArray(new Molecule[0]);
                reactantsCoefficients = Utils.integerArrayToPrimitive(coefficientsAccumulator.toArray(new Integer[0]));
                moleculeAccumulator.clear();
                coefficientsAccumulator.clear();
            }

            if (seperated[moleculeIndex].equals("+")) {
                moleculeIndex++;
            }

            String molecule = seperated[moleculeIndex];

            int coefficientTemp = -1;

            int i = 0;

            for (; Utils.isNumeric(molecule.charAt(i)); i++) {
                if (coefficientTemp == -1) {
                    coefficientTemp = molecule.charAt(i) - '0';
                }
                else {
                    coefficientTemp *= 10;
                    coefficientTemp += molecule.charAt(i) - '0';
                }
            }

            if (coefficientTemp == 0) {
                break;
            }
            else if (coefficientTemp == -1) {
                coefficientsAccumulator.addLast(1);
            }
            else {
                coefficientsAccumulator.addLast(coefficientTemp);
            }

            moleculeAccumulator.addLast(new Molecule(molecule.substring(i)));
        }

        products = moleculeAccumulator.toArray(new Molecule[0]);
        productsCoefficients = Utils.integerArrayToPrimitive(coefficientsAccumulator.toArray(new Integer[0]));
    }

    private Reaction() {

    }

    // returns whether the counts of the elements in the reactants and in the products
    public boolean isBalanced() {
        Map<Element, Integer> reactantCounter = new HashMap<>();
        List<Element> usedKeys = new ArrayList<>();

        for (int reactantIndex = 0; reactantIndex < reactants.length; reactantIndex++) {
            for (int elementIndex = 0; elementIndex < reactants[reactantIndex].composition.length; elementIndex++) {
                ElementInMolecule currElement = reactants[reactantIndex].composition[elementIndex];
                if (!reactantCounter.containsKey(currElement.getElement())) {
                    reactantCounter.put(currElement.getElement(), currElement.getCount());
                    usedKeys.add(currElement.getElement());
                }
                else {
                    reactantCounter.replace(currElement.getElement(), reactantCounter.get(currElement.getElement())+currElement.getCount());
                }
            }
        }

        for (int productIndex = 0; productIndex < products.length; productIndex++) {
            for (int elementIndex = 0; elementIndex < products[productIndex].composition.length; elementIndex++) {
                ElementInMolecule currElement = products[productIndex].composition[elementIndex];
                if (!reactantCounter.containsKey(currElement.getElement())) {
                    return false;
                }
                else {
                    reactantCounter.replace(currElement.getElement(), reactantCounter.get(currElement.getElement())-currElement.getCount());
                }
            }
        }


        for (int i = 0; i < usedKeys.size(); i++) {
            if (reactantCounter.get(usedKeys.get(i)) != 0) {
                return false;
            }
        }
        return true;
    }

    // returns whether all elements that appear in the reactants also appear in the products and vice-versa
    public boolean isValid() {
        Set<Element> reactantsElements = new HashSet<>();
        Set<Element> productsElements = new HashSet<>();

        for (int i = 0; i < reactants.length; i++) {
            for (int j = 0; j < reactants[i].composition.length; j++) {
                reactantsElements.add(reactants[i].composition[j].getElement());
            }
        }

        for (int i = 0; i < products.length; i++) {
            for (int j = 0; j < products[i].composition.length; j++) {
                productsElements.add(products[i].composition[j].getElement());
            }
        }

        return reactantsElements.equals(productsElements);
    }

    public Reaction balanced() throws Exception {
        if (!isValid()) {
            throw new Exception("Reaction cannot be balanced");
        }
        Reaction balanced = new Reaction();

        if (isBalanced()) {
            balanced.reactants = reactants;
            balanced.products = products;
            balanced.reactantsCoefficients = reactantsCoefficients;
            balanced.productsCoefficients = productsCoefficients;

            return balanced;
        }

        balanced.reactants = reactants;
        balanced.products = products;
        balanced.reactantsCoefficients = new int[reactantsCoefficients.length];
        balanced.productsCoefficients = new int[productsCoefficients.length];

        Set<Element> allElementsSet = new HashSet<>();
        for (int i = 0; i < reactants.length; i++) {
            allElementsSet.addAll(Arrays.asList(reactants[i].getElements()));
        }
        for (int i = 0; i < products.length; i++) {
            allElementsSet.addAll(Arrays.asList(products[i].getElements()));
        }

        Element[] allElementsArray = allElementsSet.toArray(new Element[1]);

        Map<Element, Integer>[] reactantsAsMaps = new HashMap[reactants.length];
        Map<Element, Integer>[] productsAsMaps = new HashMap[products.length];

        for (int i = 0; i < reactants.length; i++) {
            reactantsAsMaps[i] = new HashMap<>();
            ElementInMolecule[] currentComposition = reactants[i].getComposition();
            for (int j = 0; j < currentComposition.length; j++) {
                reactantsAsMaps[i].put(currentComposition[j].getElement(), currentComposition[j].getCount());
            }
        }
        for (int i = 0; i < products.length; i++) {
            productsAsMaps[i] = new HashMap<>();
            ElementInMolecule[] currentComposition = products[i].getComposition();
            for (int j = 0; j < currentComposition.length; j++) {
                productsAsMaps[i].put(currentComposition[j].getElement(), currentComposition[j].getCount());
            }
        }

        double[][] coefficients = new double[allElementsArray.length][reactants.length + products.length];
        for (int elementIndex = 0; elementIndex < allElementsArray.length; elementIndex++) {
            Element element = allElementsArray[elementIndex];
            for (int i = 0; i < reactants.length; i++) {
                coefficients[elementIndex][i] = reactantsAsMaps[i].getOrDefault(element, 0);
            }
            for (int i = 0; i < products.length; i++) {
                coefficients[elementIndex][i + reactants.length] = -productsAsMaps[i].getOrDefault(element, 0);
            }
        }

        Fraction[][] A = new Fraction[coefficients.length][coefficients[0].length];

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                A[i][j] = ExactBalancer.f(coefficients[i][j]);
            }
        }

        long[] result = ExactBalancer.balance(A);

        for (int i = 0; i < balanced.reactantsCoefficients.length; i++) {
            balanced.reactantsCoefficients[i] = (int)(result[i]);
        }
        for (int i = 0; i < balanced.productsCoefficients.length; i++) {
            balanced.productsCoefficients[i] = (int)(result[i + balanced.reactantsCoefficients.length]);
        }

        return balanced;
    }

    public Map<String, Double> getMolarWeights(boolean isProducts) {
        Molecule[] partsToUse = isProducts ? products : reactants;

        Map<String, Double> molarWeights = new HashMap<>(partsToUse.length);
        for (int i = 0; i < partsToUse.length; i++) {
            molarWeights.put(partsToUse[i].toString(), partsToUse[i].getMolarWeight());
        }

        return molarWeights;
    }

    public Map<String, Double> getReactantsMolarWeights() {
        return getMolarWeights(false);
    }

    public Map<String, Double> getProductsMolarWeights() {
        return getMolarWeights(true);
    }

    public String getMolarWeightsAsString(boolean isProducts) {
        Molecule[] partsToUse = isProducts ? products : reactants;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < partsToUse.length; i++) {
            builder.append(partsToUse[i].toString()).append(": ").append(partsToUse[i].getMolarWeight()).append("\n");
        }
        return builder.toString();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < reactants.length; i++) {
            if (reactantsCoefficients[i] != 1) {
                builder.append(reactantsCoefficients[i]);
            }
            builder.append(reactants[i].toString());
            builder.append(" ");
            if (i != reactants.length - 1) {
                builder.append("+");
            }
            else {
                builder.append("->");
            }
            builder.append(" ");
        }

        for (int i = 0; i < products.length; i++) {
            if (productsCoefficients[i] != 1) {
                builder.append(productsCoefficients[i]);
            }
            builder.append(products[i].toString());
            if (i != products.length - 1) {
                builder.append(" + ");
            }
        }

        return builder.toString();
    }
}
