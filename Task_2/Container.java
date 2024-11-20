package Task_2;

public enum Container {
    PAPER_CUP(0.00),
    WAFFLE_CONE(5.00);

    private final double price;

    Container(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}
