package org.bjtg.solid.single_responsability.srp;

import java.io.FileWriter;
import java.io.IOException;

public class UserFileManager {
    public void saveToFile(UserSRP userSRP) {
        String savePath = "src/main/java/org/bjtg/solid/single_responsability/srp/" + userSRP.getName() + ".txt";
        try (FileWriter fileWriter = new FileWriter(savePath)) {
            fileWriter.write("Name: " + userSRP.getName() + "\n");
            fileWriter.write("Email: " + userSRP.getEmail() + "\n");
            System.out.println("User data saved to file successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
