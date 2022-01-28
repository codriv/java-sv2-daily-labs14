package day05;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class Street3Test {

    @Test
    void getHouses() {
        Street3 street3 = new Street3();
        System.out.println(street3.getStreetsWithHouses(Path.of("src/test/resources/streets.txt")));
    }
}