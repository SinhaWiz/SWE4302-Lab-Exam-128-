package Task_2;

public class ToppingItem {
    private final Topping topping;
    private final int quantity;
    public ToppingItem(Topping topping, int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Topping quantity must be positive");
        }
        this.topping = topping;
        this.quantity = quantity;
    }

    public double getPrice() {
        return topping.getPrice() * quantity;
    }

    public Topping getTopping() {
        return topping;
    }

    public int getQuantity() {
        return quantity;
    }
}