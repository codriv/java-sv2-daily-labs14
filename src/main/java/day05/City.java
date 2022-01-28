package day05;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class City {

    private String name;
    private long fullArea;
    private List<Building> buildings = new ArrayList<>();

    public City(String name, long fullArea) {
        this.name = name;
        this.fullArea = fullArea;
    }

    public String getName() {
        return name;
    }

    public long getFullArea() {
        return fullArea;
    }

    public List<Building> getBuildings() {
        return new ArrayList<>(buildings);
    }

    public void addBuilding(Building building) {
//        if (building == null) {throw new IllegalArgumentException("parameter can't be null!");}
        if ((building.getArea() + getAreaOfAllBuildings()) <= fullArea) {
            buildings.add(building);
        } else {
            throw new IllegalArgumentException("City can't be larger than " + getFullArea());
        }
    }

    private int getAreaOfAllBuildings() {
        int areaOfAllBuildings = 0;
        for (Building building: buildings) {
            areaOfAllBuildings += building.getArea();
        }
        return areaOfAllBuildings;
    }

    public Building findHighestBuilding() {
        if (buildings.size() == 0) {
            throw new IllegalArgumentException("There is no building in the city!");
        }
        Building highestBuilding = buildings.get(0);
        for (Building building: buildings) {
            if (building.getLevels() > highestBuilding.getLevels()) {
                highestBuilding = building;
            }
        }
        return buildings.stream()
                .max(Comparator.comparingInt(Building::getLevels))
                .orElseThrow(()->new IllegalArgumentException("No building"));
    }

//    public Building findHighestBuilding() {
//        if (buildings.size() == 0) {
//            throw new IllegalArgumentException("There is no building in the city!");
//        }
//        Building highestBuilding = buildings.get(0);
//        for (Building building: buildings) {
//            if (building.getLevels() > highestBuilding.getLevels()) {
//                highestBuilding = building;
//            }
//        }
//        return highestBuilding;
//    }

    public List<Building> findBuildingsByStreet(String street) {
        List<Building> buildingsByStreet = new ArrayList<>();
        for (Building building: buildings) {
            if (building.getAddress().getStreet().equals(street)) {
                buildingsByStreet.add(building);
            }
        }
        return buildings.stream()
                .filter(building -> building.getAddress().getStreet().equals(street))
                .toList();
    }
//    public List<Building> findBuildingsByStreet(String street) {
//        List<Building> buildingsByStreet = new ArrayList<>();
//        for (Building building: buildings) {
//            if (building.getAddress().getStreet().equals(street)) {
//                buildingsByStreet.add(building);
//            }
//        }
//        return buildingsByStreet;
//    }

    public boolean isThereBuildingWithMorePeopleThan(int numberOfPeople) {
        for (Building building: buildings) {
            if (building.calculateNumberOfPeopleCanFit() > numberOfPeople) {
                return true;
            }
        }
        return buildings.stream()
                .anyMatch(building -> building.calculateNumberOfPeopleCanFit() > numberOfPeople);
    }
//    public boolean isThereBuildingWithMorePeopleThan(int numberOfPeople) {
//        for (Building building: buildings) {
//            if (building.calculateNumberOfPeopleCanFit() > numberOfPeople) {
//                return true;
//            }
//        }
//        return false;
//    }
}
