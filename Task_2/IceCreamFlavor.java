package Task_2;

public enum IceCreamFlavor {
    MINT_CHOCOLATE_CHIP(2.80),
    CHOCOLATE_FUDGE(3.00),
    STRAWBERRY_SWIRL(2.75),
    PISTACHIO_DELIGHT(3.25);
    private final double pricePerScoop;
    IceCreamFlavor(double pricePerScoop) {
        this.pricePerScoop = pricePerScoop;
    }
    public double getPricePerScoop() {
        return pricePerScoop;
    }
}