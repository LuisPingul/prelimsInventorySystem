import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static HashMap<String, Double> inventory = new HashMap<String, Double>();
    public static ArrayList<Integer> quantity = new ArrayList<Integer>();

    public static void displayMenu(){
        System.out.println("Inventory Management System");
        System.out.println("1. Add Item");
        System.out.println("2. Set Item Quantity");
        System.out.println("3. Display Inventory");
        System.out.println("4. Exit");
        System.out.println();
        System.out.print("Enter your choice: ");
    }

    public static void addItem(){
        System.out.print("Enter the name of the item: ");
        String itemName = scanner.nextLine();
            if(inventory.containsKey(itemName)){
                System.out.println();
                System.out.println("ITEM ALREADY EXISTS IN THE INVENTORY");
                System.out.println();
                return;
            } else {
                System.out.print("Enter Item Price: ");
                int itemPrice = Integer.parseInt(scanner.nextLine());
                inventory.put(itemName, (double)itemPrice);
                System.out.println();
                System.out.println("ITEM ADDED SUCCESSFULLY!");
                System.out.println();
            }

    }

    public static void setItemQuantity(){
        System.out.print("Enter the name of the item: ");
        String itemName = scanner.nextLine();
        if(inventory.containsKey(itemName)){
            System.out.print("Enter the quantity: ");
            int itemQuantity = Integer.parseInt(scanner.nextLine());
            quantity.add(itemQuantity);
            System.out.println();
            System.out.println("QUANTITY UPDATED SUCCESSFULLY!");
            System.out.println();
        } else {
            System.out.println();
            System.out.println("ITEM DOES NOT EXIST IN THE INVENTORY");
            System.out.println();
        }
    }


    public static void displayInventory(){
        System.out.println();
        System.out.println("Inventory:");
        inventory.put("Laptop", 1200.00);
        inventory.put("Mouse", 25.50);
        inventory.put("Keyboard", 50.75);
        quantity.add(10);
        quantity.add(50);
        quantity.add(30);    
        System.out.printf("%-15s %-10s %-10s\n","Item Name","Item Price","Item Quantity");
        System.out.println("---------------------------------------------------");
        int index = 0;
        for(String key: inventory.keySet()){
            System.out.printf("%-15s %-10.2f %-10d\n", key, inventory.get(key), quantity.get(index));
            index++;
        }
    }

    public static void main(String[] args) {

        boolean inventoryManagementSystem = true;
        while(inventoryManagementSystem) {
            displayMenu();
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    addItem();
                    System.out.println();
                break;

                case 2:
                    setItemQuantity();
                    System.out.println();
                break;
                case 3:
                    displayInventory();
                    System.out.println();
                break;
                case 4:
                    inventoryManagementSystem = false;
                    System.out.println("Thank you for using the Inventory Management System");
                    System.out.println("Exiting program...");
                break;
                default:
                    System.out.println("Invalid choice");
                    System.out.println();
            }
        }


        
    }
}