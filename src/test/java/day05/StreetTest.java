package day05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StreetTest {

    @Test
    void getHouses() {

        Street street = new Street("src/test/resources/streets.txt");
        System.out.println(street.getHouses());
        Street2 street2 = new Street2("src/test/resources/streets.txt");
        System.out.println(street2.getStreets());
    }
}