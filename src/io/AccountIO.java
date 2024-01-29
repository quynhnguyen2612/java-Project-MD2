package io;

import model.Account;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AccountIO {
    static File file = new File("account.txt");
    public static void writerAccount(List<Account> accounts){
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            for (Account a : accounts) {
                bufferedWriter.write(a.toString());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Account> readAccount() {
        ArrayList<Account> accounts = new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader( new FileReader(file));
            String str = "";
            while ((str = bufferedReader.readLine()) !=null) {
                String[] arr = str.split(",");
                Account account = new Account(
                        Integer.parseInt(arr[0]), arr[1], arr[2], arr[3]);
                accounts.add(account);
            }
            bufferedReader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return accounts;
    }
}
