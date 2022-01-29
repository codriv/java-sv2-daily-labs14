package day05;

public class Office extends Building{

    private String company;
    private int numberOfTablesPerLevel;

    public Office(int area, int levels, Address address, String company, int numberOfTablesPerLevel) {
        super(area, levels, address);
        this.company = company;
        this.numberOfTablesPerLevel = numberOfTablesPerLevel;
        validateNumberOfTablesPerLevel(area);
    }

    public String getCompany() {
        return company;
    }

    public int getNumberOfTablesPerLevel() {
        return numberOfTablesPerLevel;
    }

    private void validateNumberOfTablesPerLevel(int area) {
        if (numberOfTablesPerLevel * 5 < area || area < numberOfTablesPerLevel * 2) {
            throw new IllegalArgumentException("Number of tables per level is not correct!");
        }
    }

    public int calculateNumberOfPeopleCanFit() {
        return (getLevels() - 1) * numberOfTablesPerLevel;
    }
}