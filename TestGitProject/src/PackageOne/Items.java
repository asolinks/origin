package PackageOne;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Items {
	private String name;
    private double length;
    private double width;
    private double height;
    private double weight;

    public Items(String name, double length, double width, double height, double weight) {
        this.name = name;
        this.length = length;
        this.width = width;
        this.height = height;
        this.weight = weight;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double boxLength) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double volume() {
        return length * width * height;
    }

    public static double totalVolume(List<Items> itemsList) {
        double totalVolume = 0;
        for (Items item : itemsList) {
            totalVolume += item.volume();
        }
        return totalVolume;
    }

    public static double totalWeight(List<Items> itemsList) {
        double totalWeight = 0;
        for (Items item : itemsList) {
            totalWeight += item.getWeight();
        }
        return totalWeight;
    }
}