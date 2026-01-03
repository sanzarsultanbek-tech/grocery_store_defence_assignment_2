package com.example.grocerystore;

public class Person {
    protected String id;
    protected String name;

    public Person(String id, String name) {
        setId(id);
        setName(name);
    }

    public Person() {
        this("P000", "Unknown");
    }

    public String getId() { return id; }
    public String getName() { return name; }

    public void setId(String id) {
        if (id == null || id.trim().isEmpty()) {
            this.id = "P000";
        } else {
            this.id = id.trim();
        }
    }

    public void setName(String name) {
        if (name == null || name.trim().length() < 2) {
            this.name = "Unknown";
        } else {
            this.name = name.trim();
        }
    }

    public String getRole() {
        return "Person";
    }

    public void work() {
        System.out.println(name + " does general activities.");
    }

    public String toString() {
        return getRole() + "[id=" + id + ", name=" + name + "]";
    }
}

