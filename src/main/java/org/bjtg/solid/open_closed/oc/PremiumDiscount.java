package org.bjtg.solid.open_closed.oc;

public class PremiumDiscount extends Discount {
    @Override
    public double calculate(double amount) {
        return amount * 0.2;
    }
}
