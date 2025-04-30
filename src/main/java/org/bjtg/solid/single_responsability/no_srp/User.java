package org.bjtg.solid.single_responsability.no_srp;

import java.io.FileWriter;
import java.io.IOException;

public class User {
    private String name;
    private String email;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    // Bad practice: Handling file storage within the User class
    public void saveToFile() {
        String savePath = "src/main/java/org/bjtg/solid/single_responsability/no_srp/" + name + ".txt";
        try (FileWriter fileWriter = new FileWriter(savePath)) {
            fileWriter.write("Name: " + name + "\n");
            fileWriter.write("Email: " + email + "\n");
            System.out.println("User data saved to file successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
