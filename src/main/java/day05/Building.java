package day05;

public abstract class Building {

    private int area;
    private int levels;
    private Address address;

    public Building(int area, int levels, Address address) {
        this.area = area;
        this.levels = levels;
        this.address = address;
    }

    public Building(int area, Address address) {
        this.area = area;
        this.address = address;
        levels = 1;
    }

    public int getArea() {
        return area;
    }

    public int getLevels() {
        return levels;
    }

    public Address getAddress() {
        return address;
    }

    public double getFullArea() {
        return area * levels;
    }

    public void setLevels(int levels) {
        this.levels = levels;
    }

    public abstract int calculateNumberOfPeopleCanFit();
}

