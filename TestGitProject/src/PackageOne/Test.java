package PackageOne;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {

    private static Container smallContainer;
    private static Container bigContainer;

    public static void main(String[] args) {
        // Create containers
        smallContainer = new Container(2.59, 2.43, 6.06);
        smallContainer.setPrice(1000);

        bigContainer = new Container(2.59, 2.43, 12.01);
        bigContainer.setPrice(1800);

        // Read the order
        List<Items> itemsList = readOrder();

        // Compute the total volume and weight of the shipment
        double totalVolume = Items.totalVolume(itemsList);
        double totalWeight = Items.totalWeight(itemsList);

        // Select the suitable container type
        Container selectedContainer = selectContainer(totalVolume);

        // Compare and calculate the shipping cost
        double shippingCost = calculateShippingCost(selectedContainer, totalWeight);

        System.out.println("Total Volume of the Shipment: " + totalVolume + " cubic cm");
        System.out.println("Total Weight of the Shipment: " + totalWeight + " kg");
        System.out.println("Selected Container: " + (selectedContainer == smallContainer ? "Small Container" : "Big Container"));
        System.out.println("Shipping Cost: " + shippingCost + " Euro");
    }

    private static List<Items> readOrder() {
        List<Items> itemsList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of orders:");
        int numOrders = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        for (int i = 1; i <= numOrders; i++) {
            System.out.println("Enter item " + i + " name:");
            String name = scanner.nextLine();

            System.out.println("Enter item " + i + " box size (length width height, separated by spaces):");
            String[] boxSize = scanner.nextLine().split(" ");
            double boxLength = Double.parseDouble(boxSize[0]);
            double boxWidth = Double.parseDouble(boxSize[1]);
            double boxHeight = Double.parseDouble(boxSize[2]);

            System.out.println("Enter item " + i + " weight (in kg):");
            double weight = scanner.nextDouble();

            System.out.println("Enter the quantity of item " + i + ":");
            int quantity = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            for (int j = 0; j < quantity; j++) {
                Items item = new Items(name, boxLength, boxWidth, boxHeight, weight);
                itemsList.add(item);
            }
        }

        scanner.close();
        return itemsList;
    }

    private static double computeTotalVolume(List<Items> itemsList) {
        double totalVolume = 0;
        for (Items item : itemsList) {
            totalVolume += item.volume();
        }
        return totalVolume;
    }

    private static double computeTotalWeight(List<Items> itemsList) {
        double totalWeight = 0;
        for (Items item : itemsList) {
            totalWeight += item.getWeight();
        }
        return totalWeight;
    }

    private static Container selectContainer(double totalVolume) {
        return totalVolume <= 38139822 ? smallContainer : bigContainer;
    }

    private static double calculateShippingCost(Container container, double totalWeight) {
        if (container == smallContainer) {
            if (totalWeight <= 500) {
                return container.getPrice();
            } else {
                return container.getPrice() + 200;
            }
        } else { // bigContainer
            return container.getPrice();
        }
    }
}
