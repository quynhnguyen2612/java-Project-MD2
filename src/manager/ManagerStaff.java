package manager;
import io.StaffIO;
import model.Staff;
import model.StaffFullTime;
import model.StaffPartTime;
import validate.ValidateStaff;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class ManagerStaff {
    private  Date lastCheckInDate;
    ArrayList<Staff> staffs = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);


    public void displayStaff() {
        for (Staff s : staffs) {
            System.out.println(s);
        }
    }

    public void addStaff(Staff staff) {
        staffs.add(staff);
    }

    public void editStaff(int index, Staff staff) {
        staff.setId(staffs.get(index).getId());
        staffs.set(index, staff);
    }

    public void deleteStaff(int index) {
        staffs.remove(index);
    }

    public ArrayList<Staff> findAllByName(String name) {
        ArrayList<Staff> findStaff = new ArrayList<>();
        for (Staff s : staffs) {
            if (s.getName().contains(name)) {
                findStaff.add(s);
            }
        }
        return findStaff;
    }

    public int findIndexByName(String name) {
        for (int i = 0; i < staffs.size(); i++) {
            if (staffs.get(i).getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    public Staff createStaff(boolean isFullTime) {
        int id = ValidateStaff.id(staffs);
        String name = ValidateStaff.name(staffs);
        System.out.println("Nhập địa chỉ nhân viên");
        String address = scanner.nextLine();
        int phone = ValidateStaff.phone(staffs);
        if (isFullTime) {
           int date = ValidateStaff.date(staffs);
           int coefficient = ValidateStaff.coefficient(staffs);
            return new StaffFullTime(id,name,address,phone,date,coefficient);
        } else {
            int session = ValidateStaff.session(staffs);
            return new StaffPartTime(id,name,address,phone,session);
        }
    }

    public void salaryFull() {
        for (Staff s : staffs) {
            if (s instanceof StaffFullTime) {
                System.out.println(s.salary());
            }
        }
    }
    public void salaryPart() {
        for (Staff s : staffs) {
            if (s instanceof StaffFullTime) {
                System.out.println(s.salary());
            }
        }
    }

    public void writeStaff() {
        StaffIO.writerStaff(staffs);
    }

    public void readStaff(){
        StaffIO.readStaff();
    }

    public  void checkIn() {
        System.out.println("nhập tên");
        String name = scanner.nextLine();
        if (timed()) {
            System.err.println("Bạn đã chấm công hôm nay rồi.");
        } else {
            timekeeping(name);
            System.out.println("Chấm công thành công!");
        }
    }

    public  boolean timed() {
        if (lastCheckInDate == null) {
            return false;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String today = sdf.format(new Date());
        String lastDay = sdf.format(lastCheckInDate);

        return today.equals(lastDay);
    }

    public  void timekeeping (String name) {
        lastCheckInDate = new Date();
    }

    public Date getLastCheckInDate() {
        return lastCheckInDate;
    }

    public void setLastCheckInDate(Date lastCheckInDate) {
        this.lastCheckInDate = lastCheckInDate;
    }
}
