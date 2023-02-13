package mockExam03;

public class MyIndexOutOfBoundsException extends RuntimeException {

    public MyIndexOutOfBoundsException(int index, int size) {
        super("The index: %s is out of bounds (size: %s)".formatted(index, size));
    }
}
