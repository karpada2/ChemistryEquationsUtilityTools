import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Molecule {
    public ElementInMolecule[] composition;

    public Molecule(ElementInMolecule... elements) {
        this.composition = elements;
    }

    public Molecule(String molecule) throws Element.ElementDoesNotExistException {
        List<ElementInMolecule> elements = new ArrayList<>();
        StringBuilder currentElement = new StringBuilder();
        currentElement.append(molecule.charAt(0));
        int currentCount = -1;

        for (int i = 1; i < molecule.length(); i++) {
            if (Utils.isNumeric(molecule.charAt(i))) {
                if (currentCount == -1) {
                    currentCount = molecule.charAt(i) - '0';
                }
                else {
                    currentCount *= 10;
                    currentCount += molecule.charAt(i) - '0';
                }
            }
            else if (Utils.isUppercase(molecule.charAt(i))) {
                elements.addLast(new ElementInMolecule(Element.getElement(currentElement.toString()), currentCount == -1 ? 1 : currentCount));
                currentCount = -1;
                currentElement = new StringBuilder();
                currentElement.append(molecule.charAt(i));
            }
            else if (Utils.isAlphabet(molecule.charAt(i))) {
                currentElement.append(molecule.charAt(i));
            }
        }

        elements.addLast(new ElementInMolecule(Element.getElement(currentElement.toString()), currentCount == -1 ? 1 : currentCount));

        this.composition = elements.toArray(new ElementInMolecule[0]);
    }

    public ElementInMolecule[] getComposition() {
        return composition;
    }

    public Element[] getElements() {
        Element[] out = new Element[composition.length];
        for (int i = 0; i < composition.length; i++) {
            out[i] = composition[i].getElement();
        }
        return out;
    }

    public double getMolarWeight() {
        double sum = 0;
        for (int i = 0; i < composition.length; i++) {
            sum += composition[i].getMolarWeight();
        }
        return sum;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < composition.length; i++) {
            builder.append(composition[i].toString());
        }
        return builder.toString();
    }
}
