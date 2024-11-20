package Task_2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

    public class IceCreamTest {
        private final PriceCalculator calculator = new PriceCalculator();
        @Test
        public void testCalculatePrice() {
            Order order ;
        }
        @Test
        public void testToppingLessOrderCalculation() {
            Order order = new Order(Container.PAPER_CUP);
            order.addIceCream(IceCreamFlavor.CHOCOLATE_FUDGE, 1);
            order.addTopping(Topping.SPRINKLES, 1);
            double subtotal = calculator.calculateSubtotal(order);
            assertEquals(3.30, subtotal, 0.01);
        }

        @Test
        public void testWaffleConeOrder() {
            Order order = new Order(Container.WAFFLE_CONE);
            order.addIceCream(IceCreamFlavor.MINT_CHOCOLATE_CHIP, 2);
            double subtotal = calculator.calculateSubtotal(order);
            assertEquals(10.60, subtotal, 0.01);
        }

        @Test
        public void testMultipleToppings() {
            Order order = new Order(Container.PAPER_CUP);
            order.addIceCream(IceCreamFlavor.PISTACHIO_DELIGHT, 1);
            order.addTopping(Topping.CHOCOLATE_CHIPS, 1);
            order.addTopping(Topping.FRESH_STRAWBERRIES, 2);
            double subtotal = calculator.calculateSubtotal(order);
            assertEquals(5.75, subtotal);
        }

        @Test
        public void testTaxCalculation() {
            Order order = new Order(Container.PAPER_CUP);
            order.addIceCream(IceCreamFlavor.STRAWBERRY_SWIRL, 1);

            double subtotal = calculator.calculateSubtotal(order);
            double tax = calculator.calculateTax(subtotal);

            assertEquals(0.22, tax, 0.01); // $2.75 * 0.08
        }
        @Test
        public void testToppingCalculation() {
            Order order  = new Order(Container.PAPER_CUP);
            order.addIceCream(IceCreamFlavor.STRAWBERRY_SWIRL, 1);
            order.addTopping(Topping.CHOCOLATE_CHIPS, 1);
        }
        @Test
        public void testInvalidScoopCount() {
            assertThrows(IllegalArgumentException.class, () -> {
                new OrderItem(IceCreamFlavor.CHOCOLATE_FUDGE, 0);
            });
        }
        @Test
        public void testinvoiceGenerator() {
            Order order = new Order(Container.PAPER_CUP);
        }
    }

