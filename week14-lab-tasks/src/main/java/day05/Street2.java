package day05;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Street2 {
    private String pathString;
    Path path;

    public Street2(String pathString) {
        path = Path.of(pathString);
    }

    public List<String> readFile() {
        List<String> lines = null;
        try {
            lines = Files.readAllLines(path);//
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return lines;
    }

    public Map<String, List<Integer>> getStreets() {
        List<String> lines = readFile();
        Map<String, List<Integer>> streets = new HashMap<>();
        lines.forEach((line) -> {
            String streetName = getPart(line, 0);
            if (!streets.containsKey(streetName)) {
                streets.put(streetName, getHouses(lines, streetName));
            }
        });
        return streets;
    }

    private String getPart(String line, int num) {
        String parts[] = line.split(" ");
        return parts[num];
    }

    private List<Integer> getHouses(List<String> lines, String streetName) {
        List<String> selectedStreet = lines.stream().filter(line -> streetName.equals(getPart(line, 0))).toList();
        int evens = selectedStreet.stream().filter(line -> getPart(line, 1).equals("0")).toList().size();
        int odds = selectedStreet.size() - evens;
        List<Integer> evensInt = createList(evens, 0);
        List<Integer> oddsInt = createList(odds, 1);
        List<Integer> fullList = new ArrayList<>(evensInt);
        fullList.addAll(oddsInt);
        return fullList;
    }

    public List<Integer> createList(int nums, int zero) {
        List<Integer> newList = new ArrayList<>();
        for (int i = zero == 0 ? 2 : 1; i <= nums * 2; i += 2) {
            newList.add(i);
        }
        return newList;
    }
}
