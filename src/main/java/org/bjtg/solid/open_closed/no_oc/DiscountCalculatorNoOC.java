package org.bjtg.solid.open_closed.no_oc;

public class DiscountCalculatorNoOC {
    public double calculateDiscount(String customerType, double amount) {
        if (customerType.equals("Regular")) {
            return amount * 0.1;
        } else if (customerType.equals("Premium")) {
            return amount * 0.2;
        }
        return 0;
    }
}
