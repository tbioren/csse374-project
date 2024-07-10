import java.util.ArrayList;

public class DependentsIterator implements IteratorInterface {
    ArrayList<String> dependents;
    int index;

    public DependentsIterator(ArrayList<String> dependents) {
        this.dependents = dependents;
        index = 0;
    }

    public boolean hasNext() {
        return index < dependents.size();
    }

    public String next() {
        return dependents.get(index++);
    }
}