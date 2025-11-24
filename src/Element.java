public class Element {
    public static class ElementDoesNotExistException extends Exception {
        public ElementDoesNotExistException() {
            super("Element does not exist!");
        }

        public ElementDoesNotExistException(String elementSymbol) {
            super("Element " + elementSymbol + " does not exist!");
        }

        public ElementDoesNotExistException(Throwable cause) {
            super("Element does not exist!", cause);
        }

        public ElementDoesNotExistException(String elementSymbol, Throwable cause) {
            super("Element " + elementSymbol + " does not exist!", cause);
        }
    }

    private static Element[] elements = new Element[]{
        null,
        new Element("H", "Hydrogen", 1, 1.008),
        new Element("He", "Helium", 2, 4.0026),
        new Element("Li", "Lithium", 3, 6.94),
        new Element("Be", "Beryllium", 4, 9.0122),
        new Element("B", "Boron", 5, 10.81),
        new Element("C", "Carbon", 6, 12.011),
        new Element("N", "Nitrogen", 7, 14.007),
        new Element("O", "Oxygen", 8, 15.999),
        new Element("F", "Fluorine", 9, 18.998),
        new Element("Ne", "Neon", 10, 20.18),
        new Element("Na", "Sodium", 11, 22.99),
        new Element("Mg", "Magnesium", 12, 24.305),
        new Element("Al", "Aluminium", 13, 26.982),
        new Element("Si", "Silicon", 14, 28.085),
        new Element("P", "Phosphorus", 15, 30.974),
        new Element("S", "Sulfur", 16, 32.06),
        new Element("Cl", "Chlorine", 17, 35.45),
        new Element("Ar", "Argon", 18, 39.95),
        new Element("K", "Potassium", 19, 39.098),
        new Element("Ca", "Calcium", 20, 40.078),
        new Element("Sc", "Scandium", 21, 44.956),
        new Element("Ti", "Titanium", 22, 47.867),
        new Element("V", "Vanadium", 23, 50.942),
        new Element("Cr", "Chromium", 24, 51.996),
        new Element("Mn", "Manganese", 25, 54.938),
        new Element("Fe", "Iron", 26, 55.845),
        new Element("Co", "Cobalt", 27, 58.933),
        new Element("Ni", "Nickel", 28, 58.693),
        new Element("Cu", "Copper", 29, 63.546),
        new Element("Zn", "Zinc", 30, 65.38),
        new Element("Ga", "Gallium", 31, 69.723),
        new Element("Ge", "Germanium", 32, 72.63),
        new Element("As", "Arsenic", 33, 74.922),
        new Element("Se", "Selenium", 34, 78.971),
        new Element("Br", "Bromine", 35, 79.904),
        new Element("Kr", "Krypton", 36, 83.798),
        new Element("Rb", "Rubidium", 37, 85.468),
        new Element("Sr", "Strontium", 38, 87.62),
        new Element("Y", "Yttrium", 39, 88.906),
        new Element("Zr", "Zirconium", 40, 91.224),
        new Element("Nb", "Niobium", 41, 92.906),
        new Element("Mo", "Molybdenum", 42, 95.95),
        new Element("Tc", "Technetium", 43, 97.0),
        new Element("Ru", "Ruthenium", 44, 101.07),
        new Element("Rh", "Rhodium", 45, 102.91),
        new Element("Pd", "Palladium", 46, 106.42),
        new Element("Ag", "Silver", 47, 107.87),
        new Element("Cd", "Cadmium", 48, 112.41),
        new Element("In", "Indium", 49, 114.82),
        new Element("Sn", "Tin", 50, 118.71),
        new Element("Sb", "Antimony", 51, 121.76),
        new Element("Te", "Tellurium", 52, 127.6),
        new Element("I", "Iodine", 53, 126.9),
        new Element("Xe", "Xenon", 54, 131.29),
        new Element("Cs", "Caesium", 55, 132.91),
        new Element("Ba", "Barium", 56, 137.33),
        new Element("La", "Lanthanum", 57, 138.91),
        new Element("Ce", "Cerium", 58, 140.12),
        new Element("Pr", "Praseodymium", 59, 140.91),
        new Element("Nd", "Neodymium", 60, 144.24),
        new Element("Pm", "Promethium", 61, 145.0),
        new Element("Sm", "Samarium", 62, 150.36),
        new Element("Eu", "Europium", 63, 151.96),
        new Element("Gd", "Gadolinium", 64, 157.25),
        new Element("Tb", "Terbium", 65, 158.93),
        new Element("Dy", "Dysprosium", 66, 162.5),
        new Element("Ho", "Holmium", 67, 164.93),
        new Element("Er", "Erbium", 68, 167.26),
        new Element("Tm", "Thulium", 69, 168.93),
        new Element("Yb", "Ytterbium", 70, 173.05),
        new Element("Lu", "Lutetium", 71, 174.97),
        new Element("Hf", "Hafnium", 72, 178.49),
        new Element("Ta", "Tantalum", 73, 180.95),
        new Element("W", "Tungsten", 74, 183.84),
        new Element("Re", "Rhenium", 75, 186.21),
        new Element("Os", "Osmium", 76, 190.23),
        new Element("Ir", "Iridium", 77, 192.22),
        new Element("Pt", "Platinum", 78, 195.08),
        new Element("Au", "Gold", 79, 196.97),
        new Element("Hg", "Mercury", 80, 200.59),
        new Element("Tl", "Thallium", 81, 204.38),
        new Element("Pb", "Lead", 82, 207.2),
        new Element("Bi", "Bismuth", 83, 208.98),
        new Element("Po", "Polonium", 84, 209.0),
        new Element("At", "Astatine", 85, 210.0),
        new Element("Rn", "Radon", 86, 222.0),
        new Element("Fr", "Francium", 87, 223.0),
        new Element("Ra", "Radium", 88, 226.0),
        new Element("Ac", "Actinium", 89, 227.0),
        new Element("Th", "Thorium", 90, 232.04),
        new Element("Pa", "Protactinium", 91, 231.04),
        new Element("U", "Uranium", 92, 238.03),
        new Element("Np", "Neptunium", 93, 237.0),
        new Element("Pu", "Plutonium", 94, 244.0),
        new Element("Am", "Americium", 95, 243.0),
        new Element("Cm", "Curium", 96, 247.0),
        new Element("Bk", "Berkelium", 97, 247.0),
        new Element("Cf", "Californium", 98, 251.0),
        new Element("Es", "Einsteinium", 99, 252.0),
        new Element("Fm", "Fermium", 100, 257.0),
        new Element("Md", "Mendelevium", 101, 258.0),
        new Element("No", "Nobelium", 102, 259.0),
        new Element("Lr", "Lawrencium", 103, 266.0),
        new Element("Rf", "Rutherfordium", 104, 267.0),
        new Element("Db", "Dubnium", 105, 268.0),
        new Element("Sg", "Seaborgium", 106, 267.0),
        new Element("Bh", "Bohrium", 107, 270.0),
        new Element("Hs", "Hassium", 108, 271.0),
        new Element("Mt", "Meitnerium", 109, 278.0),
        new Element("Ds", "Darmstadtium", 110, 281.0),
        new Element("Rg", "Roentgenium", 111, 282.0),
        new Element("Cn", "Copernicium", 112, 285.0),
        new Element("Nh", "Nihonium", 113, 286.0),
        new Element("Fl", "Flerovium", 114, 289.0),
        new Element("Mc", "Moscovium", 115, 290.0),
        new Element("Lv", "Livermorium", 116, 293.0),
        new Element("Ts", "Tennessine", 117, 294.0),
        new Element("Og", "Oganesson", 118, 294.0),
    };

    public static Element getElement(String symbol) throws ElementDoesNotExistException {
        switch (symbol) {
            case "h", "H", "hydrogen", "Hydrogen":
                return elements[1];
            case "he", "He", "helium", "Helium":
                return elements[2];
            case "li", "Li", "lithium", "Lithium":
                return elements[3];
            case "be", "Be", "beryllium", "Beryllium":
                return elements[4];
            case "b", "B", "boron", "Boron":
                return elements[5];
            case "c", "C", "carbon", "Carbon":
                return elements[6];
            case "n", "N", "nitrogen", "Nitrogen":
                return elements[7];
            case "o", "O", "oxygen", "Oxygen":
                return elements[8];
            case "f", "F", "fluorine", "Fluorine":
                return elements[9];
            case "ne", "Ne", "neon", "Neon":
                return elements[10];
            case "na", "Na", "sodium", "Sodium":
                return elements[11];
            case "mg", "Mg", "magnesium", "Magnesium":
                return elements[12];
            case "al", "Al", "aluminium", "Aluminium":
                return elements[13];
            case "si", "Si", "silicon", "Silicon":
                return elements[14];
            case "p", "P", "phosphorus", "Phosphorus":
                return elements[15];
            case "s", "S", "sulfur", "Sulfur":
                return elements[16];
            case "cl", "Cl", "chlorine", "Chlorine":
                return elements[17];
            case "ar", "Ar", "argon", "Argon":
                return elements[18];
            case "k", "K", "potassium", "Potassium":
                return elements[19];
            case "ca", "Ca", "calcium", "Calcium":
                return elements[20];
            case "sc", "Sc", "scandium", "Scandium":
                return elements[21];
            case "ti", "Ti", "titanium", "Titanium":
                return elements[22];
            case "v", "V", "vanadium", "Vanadium":
                return elements[23];
            case "cr", "Cr", "chromium", "Chromium":
                return elements[24];
            case "mn", "Mn", "manganese", "Manganese":
                return elements[25];
            case "fe", "Fe", "iron", "Iron":
                return elements[26];
            case "co", "Co", "cobalt", "Cobalt":
                return elements[27];
            case "ni", "Ni", "nickel", "Nickel":
                return elements[28];
            case "cu", "Cu", "copper", "Copper":
                return elements[29];
            case "zn", "Zn", "zinc", "Zinc":
                return elements[30];
            case "ga", "Ga", "gallium", "Gallium":
                return elements[31];
            case "ge", "Ge", "germanium", "Germanium":
                return elements[32];
            case "as", "As", "arsenic", "Arsenic":
                return elements[33];
            case "se", "Se", "selenium", "Selenium":
                return elements[34];
            case "br", "Br", "bromine", "Bromine":
                return elements[35];
            case "kr", "Kr", "krypton", "Krypton":
                return elements[36];
            case "rb", "Rb", "rubidium", "Rubidium":
                return elements[37];
            case "sr", "Sr", "strontium", "Strontium":
                return elements[38];
            case "y", "Y", "yttrium", "Yttrium":
                return elements[39];
            case "zr", "Zr", "zirconium", "Zirconium":
                return elements[40];
            case "nb", "Nb", "niobium", "Niobium":
                return elements[41];
            case "mo", "Mo", "molybdenum", "Molybdenum":
                return elements[42];
            case "tc", "Tc", "technetium", "Technetium":
                return elements[43];
            case "ru", "Ru", "ruthenium", "Ruthenium":
                return elements[44];
            case "rh", "Rh", "rhodium", "Rhodium":
                return elements[45];
            case "pd", "Pd", "palladium", "Palladium":
                return elements[46];
            case "ag", "Ag", "silver", "Silver":
                return elements[47];
            case "cd", "Cd", "cadmium", "Cadmium":
                return elements[48];
            case "in", "In", "indium", "Indium":
                return elements[49];
            case "sn", "Sn", "tin", "Tin":
                return elements[50];
            case "sb", "Sb", "antimony", "Antimony":
                return elements[51];
            case "te", "Te", "tellurium", "Tellurium":
                return elements[52];
            case "i", "I", "iodine", "Iodine":
                return elements[53];
            case "xe", "Xe", "xenon", "Xenon":
                return elements[54];
            case "cs", "Cs", "caesium", "Caesium":
                return elements[55];
            case "ba", "Ba", "barium", "Barium":
                return elements[56];
            case "la", "La", "lanthanum", "Lanthanum":
                return elements[57];
            case "ce", "Ce", "cerium", "Cerium":
                return elements[58];
            case "pr", "Pr", "praseodymium", "Praseodymium":
                return elements[59];
            case "nd", "Nd", "neodymium", "Neodymium":
                return elements[60];
            case "pm", "Pm", "promethium", "Promethium":
                return elements[61];
            case "sm", "Sm", "samarium", "Samarium":
                return elements[62];
            case "eu", "Eu", "europium", "Europium":
                return elements[63];
            case "gd", "Gd", "gadolinium", "Gadolinium":
                return elements[64];
            case "tb", "Tb", "terbium", "Terbium":
                return elements[65];
            case "dy", "Dy", "dysprosium", "Dysprosium":
                return elements[66];
            case "ho", "Ho", "holmium", "Holmium":
                return elements[67];
            case "er", "Er", "erbium", "Erbium":
                return elements[68];
            case "tm", "Tm", "thulium", "Thulium":
                return elements[69];
            case "yb", "Yb", "ytterbium", "Ytterbium":
                return elements[70];
            case "lu", "Lu", "lutetium", "Lutetium":
                return elements[71];
            case "hf", "Hf", "hafnium", "Hafnium":
                return elements[72];
            case "ta", "Ta", "tantalum", "Tantalum":
                return elements[73];
            case "w", "W", "tungsten", "Tungsten":
                return elements[74];
            case "re", "Re", "rhenium", "Rhenium":
                return elements[75];
            case "os", "Os", "osmium", "Osmium":
                return elements[76];
            case "ir", "Ir", "iridium", "Iridium":
                return elements[77];
            case "pt", "Pt", "platinum", "Platinum":
                return elements[78];
            case "au", "Au", "gold", "Gold":
                return elements[79];
            case "hg", "Hg", "mercury", "Mercury":
                return elements[80];
            case "tl", "Tl", "thallium", "Thallium":
                return elements[81];
            case "pb", "Pb", "lead", "Lead":
                return elements[82];
            case "bi", "Bi", "bismuth", "Bismuth":
                return elements[83];
            case "po", "Po", "polonium", "Polonium":
                return elements[84];
            case "at", "At", "astatine", "Astatine":
                return elements[85];
            case "rn", "Rn", "radon", "Radon":
                return elements[86];
            case "fr", "Fr", "francium", "Francium":
                return elements[87];
            case "ra", "Ra", "radium", "Radium":
                return elements[88];
            case "ac", "Ac", "actinium", "Actinium":
                return elements[89];
            case "th", "Th", "thorium", "Thorium":
                return elements[90];
            case "pa", "Pa", "protactinium", "Protactinium":
                return elements[91];
            case "u", "U", "uranium", "Uranium":
                return elements[92];
            case "np", "Np", "neptunium", "Neptunium":
                return elements[93];
            case "pu", "Pu", "plutonium", "Plutonium":
                return elements[94];
            case "am", "Am", "americium", "Americium":
                return elements[95];
            case "cm", "Cm", "curium", "Curium":
                return elements[96];
            case "bk", "Bk", "berkelium", "Berkelium":
                return elements[97];
            case "cf", "Cf", "californium", "Californium":
                return elements[98];
            case "es", "Es", "einsteinium", "Einsteinium":
                return elements[99];
            case "fm", "Fm", "fermium", "Fermium":
                return elements[100];
            case "md", "Md", "mendelevium", "Mendelevium":
                return elements[101];
            case "no", "No", "nobelium", "Nobelium":
                return elements[102];
            case "lr", "Lr", "lawrencium", "Lawrencium":
                return elements[103];
            case "rf", "Rf", "rutherfordium", "Rutherfordium":
                return elements[104];
            case "db", "Db", "dubnium", "Dubnium":
                return elements[105];
            case "sg", "Sg", "seaborgium", "Seaborgium":
                return elements[106];
            case "bh", "Bh", "bohrium", "Bohrium":
                return elements[107];
            case "hs", "Hs", "hassium", "Hassium":
                return elements[108];
            case "mt", "Mt", "meitnerium", "Meitnerium":
                return elements[109];
            case "ds", "Ds", "darmstadtium", "Darmstadtium":
                return elements[110];
            case "rg", "Rg", "roentgenium", "Roentgenium":
                return elements[111];
            case "cn", "Cn", "copernicium", "Copernicium":
                return elements[112];
            case "nh", "Nh", "nihonium", "Nihonium":
                return elements[113];
            case "fl", "Fl", "flerovium", "Flerovium":
                return elements[114];
            case "mc", "Mc", "moscovium", "Moscovium":
                return elements[115];
            case "lv", "Lv", "livermorium", "Livermorium":
                return elements[116];
            case "ts", "Ts", "tennessine", "Tennessine":
                return elements[117];
            case "og", "Og", "oganesson", "Oganesson":
                return elements[118];
            case null:
                return null;
            default:
                throw new ElementDoesNotExistException(symbol);
        }
    }

    private String symbol;
    private String name;
    private int atomicNumber;
    private double atomicWeight;

    private Element(String symbol, String name, int atomicNumber, double atomicWeight) {
        this.symbol = symbol;
        this.name = name;
        this.atomicNumber = atomicNumber;
        this.atomicWeight = atomicWeight;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getName() {
        return name;
    }

    public int getAtomicNumber() {
        return atomicNumber;
    }

    public double getAtomicWeight() {
        return atomicWeight;
    }

    @Override
    public String toString() {
        return symbol;
    }
}