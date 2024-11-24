package Task_2;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
public class Main {
    public static void main(String[] args) {
        try {

            demonstrateBasicOrder();
            demonstrateComplexOrder();


            System.out.println("\nReading generated invoice files:");
            System.out.println("Basic Order Invoice:");
            System.out.println(Files.readString(Paths.get("basic_order_invoice.txt")));
            System.out.println("\nComplex Order Invoice:");
            System.out.println(Files.readString(Paths.get("complex_order_invoice.txt")));

        } catch (IOException e) {
            System.err.println("Error processing orders: " + e.getMessage());
        }
    }

    private static void demonstrateBasicOrder() throws IOException {
        System.out.println("Creating basic order...");

        // Create a basic order with paper cup
        Order basicOrder = new Order(Container.PAPER_CUP);
        basicOrder.addIceCream(IceCreamFlavor.CHOCOLATE_FUDGE, 1);
        basicOrder.addIceCream(IceCreamFlavor.MINT_CHOCOLATE_CHIP, 1);
        basicOrder.addTopping(Topping.CHOCOLATE_CHIPS, 1);
        basicOrder.addTopping(Topping.FRESH_STRAWBERRIES, 2);


        PriceCalculator calculator = new PriceCalculator();
        double subtotal = calculator.calculateSubtotal(basicOrder);
        double tax = calculator.calculateTax(subtotal);
        double total = calculator.calculateTotal(subtotal, tax);

        System.out.printf("Subtotal: $%.2f%n", subtotal);
        System.out.printf("Tax: $%.2f%n", tax);
        System.out.printf("Total: $%.2f%n", total);

        InvoiceGenerator invoiceGenerator = new InvoiceGenerator(calculator);
        invoiceGenerator.generateInvoice(basicOrder, "basic_order_invoice.txt");
        System.out.println("Basic order invoice generated to 'basic_order_invoice.txt'\n");
    }

    private static void demonstrateComplexOrder() throws IOException {
        System.out.println("Creating complex order...");

        Order complexOrder = new Order(Container.WAFFLE_CONE);
        complexOrder.addIceCream(IceCreamFlavor.PISTACHIO_DELIGHT, 2);
        complexOrder.addIceCream(IceCreamFlavor.STRAWBERRY_SWIRL, 1);
        complexOrder.addTopping(Topping.SPRINKLES, 1);
        complexOrder.addTopping(Topping.MARSHMALLOW, 2);
        complexOrder.addTopping(Topping.CRUSHED_OREO, 1);

        PriceCalculator calculator = new PriceCalculator();
        double subtotal = calculator.calculateSubtotal(complexOrder);
        double tax = calculator.calculateTax(subtotal);
        double total = calculator.calculateTotal(subtotal, tax);
        System.out.printf("Subtotal: $%.2f%n", subtotal);
        System.out.printf("Tax: $%.2f%n", tax);
        System.out.printf("Total: $%.2f%n", total);

        InvoiceGenerator invoiceGenerator = new InvoiceGenerator(calculator);
        invoiceGenerator.generateInvoice(complexOrder, "complex_order_invoice.txt");
        System.out.println("Complex order invoice generated to 'complex_order_invoice.txt'\n");
    }
}