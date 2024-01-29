package io;

import model.Book;
import model.Staff;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StaffIO {
    static File file = new File("staff.txt");
    public static void writerStaff(List<Staff> staffs){
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            for (Staff s : staffs) {
                bufferedWriter.write(s.toString());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Staff> readStaff() {
        ArrayList<Staff> staffs = new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader( new FileReader(file));
            String str = "";
            while ((str = bufferedReader.readLine()) !=null) {
                String[] arr = str.split(",");
                Staff staff = new Staff(
                        Integer.parseInt(arr[0]),
                        arr[1], arr[2], Integer.parseInt(arr[3]));

                staffs.add(staff);
            }
            bufferedReader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return staffs;
    }
}
