package mockExam03;

import java.io.IOException;

public class MyFileNotFoundException extends IOException {

    public MyFileNotFoundException(String message) {
        super(message);
    }
}
