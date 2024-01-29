package validate;

import model.Book;

import java.util.List;
import java.util.Scanner;

public class ValidateBook {

    static Scanner scanner = new Scanner(System.in);
    public static String name(List<Book> books) {
        while(true) {
            System.out.println("Nhập tên sách");
            String name = scanner.nextLine();
            boolean check = true;
            for (Book b : books) {
                if (b.getName().equals(name)) {
                    System.err.println("Trùng tên rồi");
                    check = false;
                    break;
                }
            }
            if (check) {
                return name;
            }
        }
    }


}
