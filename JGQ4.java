import java.util.*;
interface MealPlan {
    String getCategory();
    List<String> getItems();
}
class VegetarianMeal implements MealPlan {
    public String getCategory() {
        return "Vegetarian";
    }

    public List<String> getItems() {
        return Arrays.asList("Grilled Vegetables", "Lentil Soup", "Fruit Salad");
    }
}
class VeganMeal implements MealPlan {
    public String getCategory() {
        return "Vegan";
    }

    public List<String> getItems() {
        return Arrays.asList("Tofu Stir Fry", "Quinoa Bowl", "Avocado Toast");
    }
}
class KetoMeal implements MealPlan {
    public String getCategory() {
        return "Keto";
    }

    public List<String> getItems() {
        return Arrays.asList("Grilled Chicken", "Cauliflower Rice", "Boiled Eggs");
    }
}
class HighProteinMeal implements MealPlan {
    public String getCategory() {
        return "High-Protein";
    }

    public List<String> getItems() {
        return Arrays.asList("Steak", "Greek Yogurt", "Protein Shake");
    }
}
class Meal<T extends MealPlan> {
    private T plan;

    public Meal(T plan) {
        this.plan = plan;
    }

    public void displayMeal() {
        System.out.println("Category: " + plan.getCategory());
        System.out.println("Items: " + plan.getItems());
    }

    public T getMealPlan() {
        return plan;
    }
}
class MealPlanner {
    public static <T extends MealPlan> Meal<T> generateMealPlan(T mealType) {
        System.out.println("Generating meal plan for: " + mealType.getCategory());
        return new Meal<>(mealType);
    }
}
class PersonalizedMealGenerator {
    public static void main(String[] args) {
        Meal<VegetarianMeal> vegetarian = MealPlanner.generateMealPlan(new VegetarianMeal());
        vegetarian.displayMeal();

        System.out.println();

        Meal<VeganMeal> vegan = MealPlanner.generateMealPlan(new VeganMeal());
        vegan.displayMeal();

        System.out.println();

        Meal<KetoMeal> keto = MealPlanner.generateMealPlan(new KetoMeal());
        keto.displayMeal();

        System.out.println();

        Meal<HighProteinMeal> highProtein = MealPlanner.generateMealPlan(new HighProteinMeal());
        highProtein.displayMeal();
    }
}