package Task_2;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;

public class InvoiceGenerator {
        private final PriceCalculator priceCalculator;
        private static final DecimalFormat PRICE_FORMAT = new DecimalFormat("$#,##0.00");
        public InvoiceGenerator(PriceCalculator priceCalculator) {
            this.priceCalculator = priceCalculator;
        }
        public void generateInvoice(Order order, String filename) throws IOException {
            double subtotal = priceCalculator.calculateSubtotal(order);
            double tax = priceCalculator.calculateTax(subtotal);
            double total = priceCalculator.calculateTotal(subtotal, tax);
            try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
                writer.println("Ice Cream Shop Invoice");
                writer.println("--------------------");
                if (order.getContainer() == Container.WAFFLE_CONE) {
                    writer.printf("Waffle Cone: %s%n", PRICE_FORMAT.format(order.getContainer().getPrice()));
                }
                for (OrderItem item : order.getIceCreamItems()) {
                    writer.printf("%s - %d scoop(s): %s%n",
                            formatEnumName(item.getFlavor().name()),
                            item.getScoops(),
                            PRICE_FORMAT.format(item.getPrice()));
                }
                for (ToppingItem item : order.getToppingItems()) {
                    writer.printf("%s - %d time(s): %s%n",
                            formatEnumName(item.getTopping().name()),
                            item.getQuantity(),
                            PRICE_FORMAT.format(item.getPrice()));
                }
                writer.println("--------------------");
                writer.printf("Subtotal: %s%n", PRICE_FORMAT.format(subtotal));
                writer.printf("Tax: %s%n", PRICE_FORMAT.format(tax));
                writer.printf("Total Amount Due: %s%n", PRICE_FORMAT.format(total));
            }
        }
        private String formatEnumName(String name) {
            return name.replace('_', ' ').toLowerCase();
        }
    }
