public class ElementInMolecule {
    private Element element;
    private int count;

    public ElementInMolecule(Element element, int count) {
        this.element = element;
        this.count = count;
    }

    public double getMolarWeight() {
        return element.getAtomicWeight()*count;
    }

    public Element getElement() {
        return element;
    }

    public int getCount() {
        return count;
    }

    @Override
    public String toString() {
        if (count == 1) {
            return element.toString();
        }
        return element.toString() + count;
    }
}
