package validate;


import model.Staff;

import java.util.List;
import java.util.Scanner;

public class ValidateStaff {
    static Scanner scanner = new Scanner(System.in);
    public static String name(List<Staff> staffs) {
        while(true) {
            System.out.println("Nhập tên nhân viên");
            String name = scanner.nextLine();
            boolean check = true;
            for (Staff s : staffs) {
                if (s.getName().equals(name)) {
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

    public static int phone(List<Staff> staffs) {
        while(true) {
            try {
                System.out.println("Nhập số điện thọai của nhân viên");
                return Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.err.println("Nhập sai rồi.");
            }
        }
    }

    public static int id(List<Staff> staffs) {
        int idMax = 0;
        for (Staff s : staffs) {
            if (s.getId()> idMax) {
                idMax = s.getId();
            }
        }
        return idMax + 1;
    }

    public static int date(List<Staff> staffs) {
        while(true) {
            try {
                System.out.println("Nhập số ngày công của nhân viên");
                return Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.err.println("Nhập sai rồi.");
            }
        }
    }

    public static int coefficient(List<Staff> staffs) {
        while(true) {
            try {
                System.out.println("Nhập hệ số lương của nhân viên");
                return Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.err.println("Nhập sai rồi.");
            }
        }
    }

    public static int session(List<Staff> staffs) {
        while(true) {
            try {
                System.out.println("Nhập số buổi của nhân viên");
                return Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.err.println("Nhập sai rồi.");
            }
        }
    }

}
