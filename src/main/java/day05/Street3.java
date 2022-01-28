package day05;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Street3 {

    public List<String> readFile(Path path) {
        List<String> lines = null;
        try {
            lines = Files.readAllLines(path);
        } catch (IOException ioe) {
            throw new IllegalStateException("File not found!", ioe);
        }
        return lines;
    }

    public Map<String, List<Integer>> getStreetsWithHouses(Path path) {
        List<String> lines = readFile(path);
        Map<String, List<Integer>> houses = new HashMap<>();
        for (String line: lines) {
            String streetName = line.split(" ")[0];
            if (!houses.containsKey(streetName)) {
                houses.put(streetName, getHouses(lines, streetName));
            }
        }
        return houses;
    }

    public List<Integer> getHouses(List<String> lines, String streetName) {
        Deque<Integer> evens = new LinkedList<>();
        Deque<Integer> odds = new LinkedList<>();
        lines.stream().filter(line -> line.split(" ")[0].equals(streetName)).forEach(line -> {
            boolean isEven = line.split(" ")[1].equals("0");
            Deque<Integer> list = isEven ? evens : odds;
            list.addLast(list.isEmpty() ? (isEven ? 2 : 1) : list.peekLast() + 2);
        });
        evens.addAll(odds);
        return new ArrayList<>(evens);
    }
}