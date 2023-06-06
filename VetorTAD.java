package projeto;

class VetorTAD<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] array;
    private int size;

    public VetorTAD() {
        this(DEFAULT_CAPACITY);
    }

    public VetorTAD(int capacity) {
        array = new Object[capacity];
        size = 0;
    }

    private int hashFunction(T element) {
        return element.hashCode() % array.length;
    }

    public void inserir(T element) {
        int index = hashFunction(element);
        while (array[index] != null) {
            index = (index + 1) % array.length;
        }
        array[index] = element;
        size++;
    }

    public boolean buscar(T element) {
        int index = hashFunction(element);
        while (array[index] != null) {
            if (array[index].equals(element)) {
                return true;
            }
            index = (index + 1) % array.length;
        }
        return false;
    }

    public void remover(T element) {
        int index = hashFunction(element);
        while (array[index] != null) {
            if (array[index].equals(element)) {
                array[index] = null;
                size--;
                rehash();
                return;
            }
            index = (index + 1) % array.length;
        }
    }

    private void rehash() {
        Object[] newArray = new Object[array.length];
        int newIndex;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null) {
                newIndex = hashFunction((T) array[i]);
                while (newArray[newIndex] != null) {
                    newIndex = (newIndex + 1) % newArray.length;
                }
                newArray[newIndex] = array[i];
            }
        }
        array = newArray;
    }

    public void mostrar() {
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null) {
                System.out.println(array[i]);
            }
        }
    }
}
