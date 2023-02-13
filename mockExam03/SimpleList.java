package mockExam03;

public interface SimpleList<T> {

    void add(T element);

    T set(int index, T element);

    T get(int index);

    T remove(int index);

    T remove(T element);

    int indexOf(T element);

    int size();

    boolean isEmpty();
}
