import org.apache.commons.math3.fraction.Fraction;

import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);

    static Fraction f(double d) { return new Fraction(d); }
    public static void main(String[] args) throws Exception {
        String input = "C6H12O6 + O2 -> H2O + CO2";
        System.out.print("Input: \t\t");
        System.out.println(input);

        Reaction reaction = new Reaction(input);

        System.out.println(reaction.isValid());

        Reaction balanced = reaction.balanced();

        System.out.print("balanced: \t");
        System.out.println(balanced);

        System.out.println("Reactants: ");
        System.out.println(balanced.getMolarWeightsAsString(false));
        System.out.println("Products: ");
        System.out.println(balanced.getMolarWeightsAsString(true));
    }
}
