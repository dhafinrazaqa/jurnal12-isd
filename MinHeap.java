import java.util.ArrayList;

public class MinHeap<T extends Comparable<T>> {
    ArrayList<T> elements;

    public MinHeap() {
        elements = new ArrayList<>();
        elements.add(null);
    }

    public int getLeftChildIndex(int i) {
        return 2 * i;
    }
    public int getRightChildIndex(int i) {
        return 2 * i + 1;
    }
    public int getParentIndex(int i) {
        return i / 2;
    }
    public T getLeftChild(int i) {
        return elements.get(2 * i);
    }
    public T getRightChild(int i) {
        return elements.get(2 * i + 1);
    }
    public T getParent(int i) {
        return elements.get(i / 2);
    }

    public void add(T newElement) {
        elements.add(null);
        int index = elements.size() - 1;

        while (index > 1 && getParent(index).compareTo(newElement) > 0) {
            elements.set(index, getParent(index));
            index = getParentIndex(index);
        }
            
        elements.set(index, newElement);
    }

    public T peek() {
        return elements.get(1);
    }

    public T remove() {
        T minimum = elements.get(1);

        int lastIndex = elements.size() - 1;
        T last = elements.remove(lastIndex);

        if (lastIndex > 1) {
            elements.set(1, last);
            fixHeap();
        }

        return minimum;
    }

    public void fixHeap() {
        T root = elements.get(1);

        int lastIndex = elements.size() - 1;

        int index = 1;
        boolean more = true;
        while (more) {
            int childIndex = getLeftChildIndex(index);
            if (childIndex <= lastIndex) {
                T child = getLeftChild(index);
                if (getRightChildIndex(index) <= lastIndex && getRightChild(index).compareTo(child) < 0) {
                    childIndex = getRightChildIndex(index);
                    child = getRightChild(index);
                }

                if (child.compareTo(root) < 0) {
                    elements.set(index, child);
                    index = childIndex;
                } else {
                    more = false;
                }
            } else {
                more = false;
            }
        }

        elements.set(index, root);
    }

    public int size() {
        return elements.size() - 1;
    }
}