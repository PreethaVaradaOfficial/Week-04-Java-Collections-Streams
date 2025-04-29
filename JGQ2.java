import java.util.*;
interface Category {
    String getCategoryName();
}
class BookCategory implements Category {
    public String getCategoryName() {
        return "Book";
    }
}

class ClothingCategory implements Category {
    public String getCategoryName() {
        return "Clothing";
    }
}

class GadgetCategory implements Category {
    public String getCategoryName() {
        return "Gadget";
    }
}
abstract class Product<T extends Category> {
    private String name;
    private double price;
    private T category;

    public Product(String name, double price, T category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public double getPrice() { return price; }
    public void setPrice(double newPrice) { this.price = newPrice; }
    public String getName() { return name; }
    public T getCategory() { return category; }

    public abstract String getDetails();
}
class Book extends Product<BookCategory> {
    private String author;

    public Book(String name, double price, BookCategory category, String author) {
        super(name, price, category);
        this.author = author;
    }

    @Override
    public String getDetails() {
        return "Book: " + getName() + " by " + author + " ($" + getPrice() + ")";
    }
}

class Clothing extends Product<ClothingCategory> {
    private String size;

    public Clothing(String name, double price, ClothingCategory category, String size) {
        super(name, price, category);
        this.size = size;
    }

    @Override
    public String getDetails() {
        return "Clothing: " + getName() + " (Size: " + size + ", $" + getPrice() + ")";
    }
}

class Gadget extends Product<GadgetCategory> {
    private String brand;

    public Gadget(String name, double price, GadgetCategory category, String brand) {
        super(name, price, category);
        this.brand = brand;
    }

    @Override
    public String getDetails() {
        return "Gadget: " + getName() + " (Brand: " + brand + ", $" + getPrice() + ")";
    }
}
class MarketplaceUtils {
    public static <T extends Product<?>> void applyDiscount(T product, double percentage) {
        double oldPrice = product.getPrice();
        double newPrice = oldPrice * (1 - percentage / 100);
        product.setPrice(newPrice);
    }
    public static void showCatalog(List<? extends Product<?>> catalog) {
        for (Product<?> p : catalog) {
            System.out.println(p.getDetails());
        }
    }
}
class OnlineMarketplace {
    public static void main(String[] args) {
        List<Product<?>> catalog = new ArrayList<>();

        Book book = new Book("Java Basics", 39.99, new BookCategory(), "John Doe");
        Clothing shirt = new Clothing("Denim Shirt", 25.0, new ClothingCategory(), "M");
        Gadget phone = new Gadget("Smartphone", 599.99, new GadgetCategory(), "TechBrand");

        catalog.add(book);
        catalog.add(shirt);
        catalog.add(phone);

        System.out.println("=== Catalog Before Discount ===");
        MarketplaceUtils.showCatalog(catalog);
        MarketplaceUtils.applyDiscount(book, 10);
        MarketplaceUtils.applyDiscount(shirt, 20);
        MarketplaceUtils.applyDiscount(phone, 5);

        System.out.println("\n=== Catalog After Discount ===");
        MarketplaceUtils.showCatalog(catalog);
    }
}