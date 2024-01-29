package manager;

import io.AccountIO;
import model.Account;
import model.Role;
import validate.ValidateAccount;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ManagerAccount {
    ArrayList<Account> accounts = new ArrayList<>();
    ArrayList<Role> roles = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public ManagerAccount() {
    readRole();
    }

    public void writeRole() {
        try {
            File roles = new File("roles.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(roles));
            for (Role r : this.roles) {
                bufferedWriter.write(r.getId() + "," + r.getName());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("lỗi ghi file");
        }
    }

    public void readRole() {
        try {
            File roles = new File("roles.txt");
            BufferedReader bufferedReader = new BufferedReader(new FileReader(roles));
            String str = null;
            while ((str = bufferedReader.readLine()) != null) {
                String[] arr = str.split(",");
                this.roles.add(new Role(Integer.parseInt(arr[0]), arr[1]));
            }
            bufferedReader.close();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("loi doc file");
        }
    }

    public void writeAccount() {
        AccountIO.writerAccount(accounts);
    }

    public void readAccount(){
        AccountIO.readAccount();
    }

    public void add(Account account) {
        accounts.add(account);
        writeAccount();
    }

    public Role choiceRole() {
        System.out.println("Danh sách quyền trong hệ thống");
        for (int i = 0; i < roles.size(); i++) {
            System.out.println(i+1 + " - " + roles.get(i).getName());
        }
        int choice = Integer.parseInt(scanner.nextLine());
        return roles.get(choice-1);
    }

    public Account createAccount() {
        String username = ValidateAccount.validateUsername();
        String password = ValidateAccount.validatePassword();
        Role role = choiceRole();
        int idEnd = 0;
        try {
            idEnd = accounts.get(accounts.size() - 1).getId();
        } catch (Exception e) {

        }
        return new Account(idEnd + 1, username,password,role);

    }

    public  Account checkLogin(String username, String password) {
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getUsername().equals(username)
                    && accounts.get(i).getPassword().equals(password)) {
                return accounts.get(i);
            }
        }
        return null;
    }
}
