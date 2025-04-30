package org.bjtg;

import org.bjtg.solid.single_responsability.no_srp.User;

public class Main {
    public static void main(String[] args) {
        solidPrincipal();
    }

    private static void solidPrincipal() {
        /*
        Single Responsibility Principle
         */
        // No SRP
        User user = new User("John Doe", "john.doe@example.com");
        user.saveToFile();
    }
}