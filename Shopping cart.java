public class ShoppingCart {
    Map<String, Double> priceMap = new HashMap<>();
    LinkedHashMap<String, Integer> cart = new LinkedHashMap<>();
    TreeMap<Double, List<String>> priceSortedItems = new TreeMap<>();

    public void addProduct(String item, double price) {
        priceMap.put(item, price);
        cart.put(item, cart.getOrDefault(item, 0) + 1);
        priceSortedItems.computeIfAbsent(price, k -> new ArrayList<>()).add(item);
    }

    public void displayCartOrder() {
        System.out.println("Cart Order (LinkedHashMap): " + cart);
    }

    public void displayItemsByPrice() {
        System.out.println("Sorted by Price (TreeMap): " + priceSortedItems);
    }
}