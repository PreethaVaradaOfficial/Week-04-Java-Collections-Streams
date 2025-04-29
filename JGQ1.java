import java.util.*;
abstract class WarehouseItem {
    private String name;

    public WarehouseItem(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract String getDetails();
}
class Electronics extends WarehouseItem {
    private String brand;

    public Electronics(String name, String brand) {
        super(name);
        this.brand = brand;
    }

    @Override
    public String getDetails() {
        return "Electronics: " + getName() + " (Brand: " + brand + ")";
    }
}

class Groceries extends WarehouseItem {
    private String expiryDate;

    public Groceries(String name, String expiryDate) {
        super(name);
        this.expiryDate = expiryDate;
    }

    @Override
    public String getDetails() {
        return "Groceries: " + getName() + " (Expires: " + expiryDate + ")";
    }
}

class Furniture extends WarehouseItem {
    private String material;

    public Furniture(String name, String material) {
        super(name);
        this.material = material;
    }

    @Override
    public String getDetails() {
        return "Furniture: " + getName() + " (Material: " + material + ")";
    }
}
class Storage<T extends WarehouseItem> {
    private List<T> items = new ArrayList<>();

    public void addItem(T item) {
        items.add(item);
    }

    public List<T> getItems() {
        return items;
    }

    public void showAllItems() {
        for (T item : items) {
            System.out.println(item.getDetails());
        }
    }
}
class WarehouseUtils {
    public static void displayItems(List<? extends WarehouseItem> items) {
        for (WarehouseItem item : items) {
            System.out.println(item.getDetails());
        }
    }
}
class SmartWarehouseSystem {
    public static void main(String[] args) {
        Storage<Electronics> electronicsStorage = new Storage<>();
        electronicsStorage.addItem(new Electronics("Laptop", "Dell"));
        electronicsStorage.addItem(new Electronics("Phone", "Samsung"));

        Storage<Groceries> groceriesStorage = new Storage<>();
        groceriesStorage.addItem(new Groceries("Milk", "2025-05-01"));
        groceriesStorage.addItem(new Groceries("Bread", "2025-04-20"));

        Storage<Furniture> furnitureStorage = new Storage<>();
        furnitureStorage.addItem(new Furniture("Chair", "Wood"));
        furnitureStorage.addItem(new Furniture("Table", "Metal"));

        System.out.println("=== Electronics ===");
        electronicsStorage.showAllItems();

        System.out.println("\n=== Groceries ===");
        groceriesStorage.showAllItems();

        System.out.println("\n=== Furniture ===");
        furnitureStorage.showAllItems();

        System.out.println("\n=== Display using wildcard method ===");
        WarehouseUtils.displayItems(electronicsStorage.getItems());
        WarehouseUtils.displayItems(groceriesStorage.getItems());
        WarehouseUtils.displayItems(furnitureStorage.getItems());
    }
}
