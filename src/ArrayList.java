import java.util.Arrays;
import java.util.Collection;

public class ArrayList <T extends Comparable<T>> {

    private int size;
    private Object[] somes;

    public ArrayList() {
        somes = new Object[size];
        size = 0;
    }

    public boolean add(T some) {
        ensureCapacity(size + 1);
        somes[size++] = some;
        return true;
    }

    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        T oldValue = (T) somes[index];
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(somes, index + 1, somes, index, numMoved);
        }
        somes[--size] = null;
        return oldValue;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return (T) somes[index];
    }

    public boolean addAll(Collection<? extends T> collection) {
        ensureCapacity(size + collection.size());
        for (T some : collection) {
            somes[size++] = some;
        }
        return true;
    }

    private void ensureCapacity(int minCapacity) {
        if (minCapacity > somes.length) {
            int newCapacity = somes.length * 2;
            somes = java.util.Arrays.copyOf(somes, newCapacity);
        }
    }

    public int size() {
        return this.size;
    }

    public void sort() {
        boolean swap;
        for (int i = 0; i < size - 1; i++) {
            swap = false;
            for (int j = 0; j < size - i - 1; j++) {
                if (((T) somes[j]).compareTo((T) somes[j + 1]) > 0) {
                    T temp = (T) somes[j];
                    somes[j] = somes[j + 1];
                    somes[j + 1] = temp;
                    swap = true;
                }
            }
            if (!swap) {
                break;
            }
        }
    }
}
