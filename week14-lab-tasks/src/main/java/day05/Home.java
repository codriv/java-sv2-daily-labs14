package day05;

public class Home extends Building {

    public static final int SQUARE_METERS_NEED_PER_PERSON = 20;

    public Home(int area, int levels, Address address) {
        super(area, levels, address);
        validateLevels(levels);
    }

    public Home(int area, Address address) {
        super(area, address);
    }

    private void validateLevels(int levels) {
        if (levels > 3) {
            throw new IllegalArgumentException("Maximum 3 levels!");
        }
    }

    public int calculateNumberOfPeopleCanFit() {
        return (getArea() * getLevels()) / SQUARE_METERS_NEED_PER_PERSON;
    }
}