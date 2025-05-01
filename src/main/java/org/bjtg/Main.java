package org.bjtg;

import org.bjtg.solid.single_responsability.no_srp.UserNoSRP;
import org.bjtg.solid.single_responsability.srp.UserFileManager;
import org.bjtg.solid.single_responsability.srp.UserSRP;

public class Main {
    public static void main(String[] args) {
        solidPrincipal();
    }

    private static void solidPrincipal() {
        /**********************************************
         Single Responsibility Principle
         **********************************************/
        // No SRP
        UserNoSRP userNoSRP = new UserNoSRP("John Doe", "john.doe@example.com");
        userNoSRP.saveToFile();

        // No SRP
        UserSRP user = new UserSRP("Bryam Talledo", "bryam.talledo@example.com");
        UserFileManager fileManager = new UserFileManager();
        fileManager.saveToFile(user);
    }
}