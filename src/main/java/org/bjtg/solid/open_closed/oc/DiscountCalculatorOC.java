package org.bjtg.solid.open_closed.oc;

public class DiscountCalculatorOC {
    public double calculateDiscount(Discount discount, double amount) {
        return discount.calculate(amount);
    }
}
