package model;

public class StaffFullTime extends Staff {
    private int date;
    private double coefficient;

    public StaffFullTime() {
    }


    public StaffFullTime(int id, String name, String address, int phone, int date, double coefficient) {
        super(id, name, address, phone);
        this.date = date;
        this.coefficient = coefficient;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public double getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(double coefficient) {
        this.coefficient = coefficient;
    }

    @Override
    public double salary() {
        return coefficient*date*200000;
    }

    @Override
    public String toString() {
        return date + coefficient + super.toString();
    }
}
