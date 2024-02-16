package edu.uncc.assignment04;

public class Response {
    private String name;
    private String email;
    private String role;

    // Default constructor
    public Response() {
    }

    // Parameterized constructor
    public Response(String name, String email, String role) {
        this.name = name;
        this.email = email;
        this.role = role;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for email
    public String getEmail() {
        return email;
    }

    // Setter for email
    public void setEmail(String email) {
        this.email = email;
    }

    // Getter for role
    public String getRole() {
        return role;
    }

    // Setter for role
    public void setRole(String role) {
        this.role = role;
    }
}

