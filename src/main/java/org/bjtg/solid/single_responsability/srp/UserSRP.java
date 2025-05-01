package org.bjtg.solid.single_responsability.srp;

public class UserSRP {
    private String name;
    private String email;

    public UserSRP(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
