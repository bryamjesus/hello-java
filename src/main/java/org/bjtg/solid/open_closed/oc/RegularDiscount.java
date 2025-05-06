package org.bjtg.solid.open_closed.oc;

public class RegularDiscount extends Discount {
    @Override
    public double calculate(double amount) {
        return amount * 0.1;
    }
}
