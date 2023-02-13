package mockExam03;

import java.io.*;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class DataFileReader {

    public static void main(String[] args) {
        File file = null; // TODO: Get the file object, referencing 'inventory'.
        try {
            List<String> lines = readFile(file);
            SimpleList<Item> inventory = processItems(lines);
            System.out.println("the inventory has these items: " + inventory);
            int count = countItems(inventory);
            System.out.println("there are " + count + " total items in the inventory");
        } catch (MyFileNotFoundException e) {
            System.out.println("inventory could not be read");
        }
    }

    public static List<String> readFile(File file) throws MyFileNotFoundException {
        List<String> lines = new ArrayList<>();
        // TODO: Read the contents of 'file' and store its lines in 'lines'.
        return lines;
    }

    public static SimpleList<Item> processItems(List<String> lines) {
        SimpleList<Item> items = new SimpleListImpl<>();
        // TODO: Create the items with respective parameters according to the contents of each line.
        return items;
    }

    public static int countItems(SimpleList<Item> items) {
        int count = 0;
        for (int i = 0; i < items.size(); i++) {
            count += items.get(i).count();
        }
        return count;
    }
}
