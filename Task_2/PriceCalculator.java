package Task_2;

public class PriceCalculator {
    private static final double TAX_RATE = 0.08;
    public double calculateSubtotal(Order order) {
        double subtotal = order.getContainer().getPrice();
        for (OrderItem item : order.getIceCreamItems()) {
            subtotal += item.getPrice();
        }
        for (ToppingItem topping : order.getToppingItems()) {
            subtotal += topping.getPrice();
        }
        return subtotal;
    }
    public double calculateTax(double subtotal) {
        return subtotal * TAX_RATE;
    }

    public double calculateTotal(double subtotal, double tax) {
     return subtotal + tax;
    }
}