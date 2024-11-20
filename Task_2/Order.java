package Task_2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Order {
    private final List<OrderItem> iceCreamItems;
    private final List<ToppingItem> toppingItems;
    private final Container container;

    public Order(Container container) {
        this.container = container;
        this.iceCreamItems = new ArrayList<>();
        this.toppingItems = new ArrayList<>();
    }

    public void addIceCream(IceCreamFlavor flavor, int scoops) {
        iceCreamItems.add(new OrderItem(flavor, scoops));
    }
    public void addTopping(Topping topping, int quantity) {
        toppingItems.add(new ToppingItem(topping, quantity));
    }

    public List<OrderItem> getIceCreamItems() {
        return Collections.unmodifiableList(iceCreamItems);
    }

    public List<ToppingItem> getToppingItems() {
        return Collections.unmodifiableList(toppingItems);
    }

    public Container getContainer() {
        return container;
    }
}