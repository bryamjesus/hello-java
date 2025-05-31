package org.bjtg;

import org.bjtg.poo.POO;
import org.bjtg.solid.open_closed.no_oc.DiscountCalculatorNoOC;
import org.bjtg.solid.open_closed.oc.Discount;
import org.bjtg.solid.open_closed.oc.DiscountCalculatorOC;
import org.bjtg.solid.open_closed.oc.PremiumDiscount;
import org.bjtg.solid.open_closed.oc.RegularDiscount;
import org.bjtg.solid.single_responsability.no_srp.UserNoSRP;
import org.bjtg.solid.single_responsability.srp.UserFileManager;
import org.bjtg.solid.single_responsability.srp.UserSRP;

public class Main {
    public static void main(String[] args) {
        solidPrinciples();

        POO.principles();
    }

    private static void solidPrinciples() {
        // singleResponsabilityPrinciple();
        // openClosedPrinciple();
    }

    private static void singleResponsabilityPrinciple() {
        /**********************************************
         Single Responsibility Principle
         **********************************************/
        System.out.println("=========Single Responsibility Principle=========");

        // No SRP
        System.out.println("No SRP");
        UserNoSRP userNoSRP = new UserNoSRP("John Doe", "john.doe@example.com");
        userNoSRP.saveToFile();

        // SRP
        System.out.println("SRP");
        UserSRP user = new UserSRP("Bryam Talledo", "bryam.talledo@example.com");
        UserFileManager fileManager = new UserFileManager();
        fileManager.saveToFile(user);

        System.out.println();
    }

    private static void openClosedPrinciple(){
        /**********************************************
         Open/Closed Principle
         **********************************************/
        System.out.println("=========Open/Closed Principle=========");

        // No OC
        System.out.println("No OC");
        DiscountCalculatorNoOC calculatorNoOC = new DiscountCalculatorNoOC();
        double regularDiscountNoOC = calculatorNoOC.calculateDiscount("Regular", 100);
        double premiumDiscountNoOC = calculatorNoOC.calculateDiscount("Premium", 100);

        System.out.println("Regular Discount: " + regularDiscountNoOC);
        System.out.println("Premium Discount: " + premiumDiscountNoOC);

        // OC
        System.out.println("OC");
        Discount regularDiscount = new RegularDiscount();
        Discount premiumDiscount = new PremiumDiscount();

        DiscountCalculatorOC calculator = new DiscountCalculatorOC();

        double regularDiscountAmount = calculator.calculateDiscount(regularDiscount, 100);
        double premiumDiscountAmount = calculator.calculateDiscount(premiumDiscount, 100);

        System.out.println("Regular Discount: " + regularDiscountAmount);
        System.out.println("Premium Discount: " + premiumDiscountAmount);

        System.out.println();
    }
}