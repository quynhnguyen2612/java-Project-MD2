package menu;

import manager.ManagerAccount;
import manager.ManagerBook;
import manager.ManagerStaff;
import model.Account;
import model.Book;
import model.Staff;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuAccount {
    static Scanner scanner = new Scanner(System.in);
    static ManagerAccount managerAccount = new ManagerAccount();
    static ManagerBook managerBook = new ManagerBook();
    static ManagerStaff managerStaff = new ManagerStaff();

    public static void menuMain() {
        while (true) {
            System.out.println("Xin chào");
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("Chọn chức năng:");
            int choice = choice();
            switch (choice) {
                case 1:
                    login();
                    break;
                case 2:
                    Account account = managerAccount.createAccount();
                    managerAccount.add(account);
                    break;

                default:
                    System.err.println("Nhập sai vui lòng nhập lại");
            }
        }
    }
    public static void login() {
        System.out.println("Nhập username");
        String username = scanner.nextLine();
        System.out.println("Nhập password");
        String password = scanner.nextLine();
        Account account = managerAccount.checkLogin(username,password);
        if (account != null) {
            if (account.getRole().getName().equals("Admin")) {
                System.out.println("Chào mừng Admin");
                System.out.println("1. Quản lý nhân viên");
                System.out.println("2. Quản lý sách");
                System.out.println("Chọn chức năng: ");
                int choice = choice();
                switch (choice) {
                    case 1:
                        menuAdminStaff();
                        break;
                    case 2:
                        menuAdminBook();
                        break;
                    default:
                        System.err.println("Nhập sai vui lòng nhập lại");
                }
            } else {
                menuUser();
            }
        } else {
            System.err.println("Bạn đã đăng nhập lỗi");
        }
    }



    public static void menuAdminBook() {
        while (true) {
            System.out.println("Quản lý sách");
            System.out.println("1. Hiển thi sách");
            System.out.println("2. Thêm sách");
            System.out.println("3. Xóa sách");
            System.out.println("4. Sửa sách");
            System.out.println("5. Tìm kiếm sách theo tên");
            System.out.println("6. Ghi file");
            System.out.println("7. Đọc file");
            System.out.println("8. logout");
            int choice = choice();
            switch (choice) {
                case 1:
                    managerBook.displayBook();
                    break;
                case 2:
                    managerBook.addBook(managerBook.create());
                    break;
                case 3:
                    System.out.println("Nhập name cần xóa");
                    String nameDelete = scanner.nextLine();
                    managerBook.deleteBook(managerBook.findIndexByName(nameDelete));
                    break;
                case 4:
                    System.out.println("Nhập name cần sửa");
                    String nameEdit = scanner.nextLine();
                    int index = managerBook.findIndexByName(nameEdit);
                    Book book = managerBook.create();
                    managerBook.editBook(index, book);
                    break;
                case 5:
                    System.out.println("Nhập name cần tim");
                    String nameFind = scanner.nextLine();
                    ArrayList<Book> books = managerBook.findAllByName(nameFind);
                    for (Book b : books) {
                        System.out.println(b);
                    }
                    break;
                case 6:
                    managerBook.writeBook();
                    break;
                case 7:
                    managerBook.readBook();
                    break;
                case 8:
                    return;
                default:
                    System.err.println("Nhập sai vui lòng nhập lại");
            }
        }
    }
    public static void menuAdminStaff() {
        while (true) {
            System.out.println("Quản lý nhân viên");
            System.out.println("1. Hiển thị nhân viên");
            System.out.println("2. Thêm nhân viên");
            System.out.println("3. Tính lương nhân viên");
            System.out.println("4. Sửa nhân viên");
            System.out.println("5. Xóa nhân viên");
            System.out.println("6. Ghi file");
            System.out.println("7. Đọc file");
            System.out.println("8. Thoát");
            int choice = choice();
            switch (choice) {
                case 1:
                    managerStaff.displayStaff();
                    break;
                case 2:
                    menuAddStaff();
                    break;
                case 3:
                    menuSalaryStaff();
                    break;
                case 4:
                    System.out.println("Nhập name cần sửa");
                    String nameEdit = scanner.nextLine();
                    int index = managerStaff.findIndexByName(nameEdit);
                    Staff staff = managerStaff.createStaff(true);
                    managerStaff.editStaff(index, staff);
                    break;
                case 5:
                    System.out.println("Nhập name cần xóa");
                    String nameDelete = scanner.nextLine();
                    managerStaff.deleteStaff(managerStaff.findIndexByName(nameDelete));
                    break;
                case 6:
                    managerStaff.writeStaff();
                    break;
                case 7:
                    managerStaff.readStaff();
                    break;
                case 8:
                    return;
                default:
                    System.err.println("Nhập sai vui lòng nhập lại");


            }
        }
    }

    public static void menuUser() {
        while (true) {
            System.out.println("Chào mừng User");
            System.out.println("1. Chấm công");
            System.out.println("2. Hiển thi sách");
            System.out.println("3. Tìm kiếm sách theo tên");
            System.out.println("4. logout");
            int choice = choice();
            switch (choice) {
                case 1:
                    managerStaff.checkIn();
                    break;
                case 2:
                    managerBook.displayBook();
                    break;
                case 3:
                    System.out.println("Nhập name cần tìm");
                    String name = scanner.nextLine();
                    ArrayList<Book> books = managerBook.findAllByName(name);
                    for (Book b : books) {
                        System.out.println(b);
                    }
                    break;
                case 4:
                    return;
                default:
                    System.err.println("Nhập sai");
            }
        }
    }
    public static void menuAddStaff() {
        while (true) {
            System.out.println("1. Nhân viên fullTime");
            System.out.println("2. Nhân viên PartTime");
            System.out.println("3. Quay lại");
            int choice = choice();
            switch (choice) {
                case 1:
                    Staff fullTime = managerStaff.createStaff(true);
                    managerStaff.addStaff(fullTime);
                    break;
                case 2:
                    Staff partTime = managerStaff.createStaff(false);
                    managerStaff.addStaff(partTime);
                    break;
                case 3:
                    return;
                default:
                    System.err.println("Nhập số không đúng vui lòng nhập lại ");

            }
        }
    }

    public static void menuSalaryStaff() {
        while (true) {
            System.out.println("1. Nhân viên fullTime");
            System.out.println("2. Nhân viên PartTime");
            System.out.println("3. Quay lại");
            int choice = choice();
            switch (choice) {
                case 1:
                    managerStaff.salaryFull();
                    break;
                case 2:
                    managerStaff.salaryPart();
                    break;
                case 3:
                    return;
                default:
                    System.err.println("Nhập số không đúng vui lòng nhập lại");
            }
        }
    }

    public static int choice() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());

            } catch (Exception e) {
                e.printStackTrace();
                System.err.println("Mù à nhập số");
            }
        }
    }
}


