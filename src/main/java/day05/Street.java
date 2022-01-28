package day05;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Street {

    private String pathString;
    Path path;

    public Street(String pathString) {
        path = Path.of(pathString);
    }

    public List<String> readFile() {
        List<String> lines = null;
        try {
            lines = Files.readAllLines(path);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return lines;
    }

    public Map<String, List<Integer>> getHouses() {
        List<String> lines = readFile();
        Map<String, List<Integer>> houses = new HashMap<>();
        for (String line: lines) {
            String[] parts = line.split(" ");
            String streetName = parts[0];
            houses.put(streetName, selectStreet(streetName));
        }
        return houses;
    }

    public List<Integer> selectStreet(String streetName) {
        List<String> lines = readFile();
        List<String> selectedStreet = lines.stream().filter(line -> line.split(" ")[0].equals(streetName)).toList();
        int evens = selectedStreet.stream().filter(line -> line.split(" ")[1].equals("0")).toList().size();
        int odds = selectedStreet.size() - evens;
        List<Integer> evensInt = createList(evens, 0);
        List<Integer> oddsInt = createList(odds, 1);
        List<Integer> sum = new ArrayList<>(evensInt);
        sum.addAll(oddsInt);
        return sum;
    }

    public List<Integer> createList(int nums, int zero) {
        List<Integer> newList = new ArrayList<>();
        for (int i = zero == 0 ? 2 : 1; i <= nums * 2; i += 2) {
            newList.add(i);
        }
        return newList;
    }

//    utcanév alapján páros házszámok darabszámát?
}
