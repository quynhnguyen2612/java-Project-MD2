package validate;

import manager.ManagerAccount;
import model.Account;

import java.util.ArrayList;
import java.util.Scanner;

public class ValidateAccount {
    static ArrayList<Account> accounts = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    public static String validateUsername() {
        while (true) {
            System.out.println("Nhập username");
            String username = scanner.nextLine();
            if (checkUsername(username)) {
                System.out.println("username đã trùng");
            } else {
                return username;
            }
        }
    }

    public static String validatePassword() {
        while (true) {
            System.out.println("Nhập password");
            String password = scanner.nextLine();
            System.out.println("Nhập lại password");
            String rePassword = scanner.nextLine();
            if (password.equals(rePassword)) {
                return password;
            } else {
                System.err.println("pass không trùng nhập lại");
            }
        }
    }

    public  static boolean checkUsername(String username ) {
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }
}
