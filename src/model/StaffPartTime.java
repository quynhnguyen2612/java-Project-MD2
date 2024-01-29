package model;

public class StaffPartTime extends Staff {
    private int session;

    public StaffPartTime() {
    }

    public StaffPartTime(int id, String name, String address, int phone, int session) {
        super(id, name, address, phone);
        this.session = session;
    }

    public int getSession() {
        return session;
    }

    public void setSession(int session) {
        this.session = session;
    }

    @Override
    public double salary() {
        return session*4*30000;
    }

    @Override
    public String toString() {
        return session + super.toString();
    }
}
