public class OrderItem {
    private final IceCreamFlavor flavor;
    private final int scoops;

    public OrderItem(IceCreamFlavor flavor, int scoops) {
        if (scoops <= 0) {
            throw new IllegalArgumentException("Number of scoops must be positive");
        }
        this.flavor = flavor;
        this.scoops = scoops;
    }

    public double getPrice() {
        return flavor.getPricePerScoop() * scoops;
    }

    public IceCreamFlavor getFlavor() {
        return flavor;
    }

    public int getScoops() {
        return scoops;
    }
}
