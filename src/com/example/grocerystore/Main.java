package com.example.grocerystore;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static final ArrayList<Person> people = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        people.add(new Customer("C001", "Aliya", 150, "BASIC"));
        people.add(new Employee("E001", "Nurlan", "CASHIER", 250000));

        while (true) {
            System.out.println("\n=== GROCERY STORE MENU ===");
            System.out.println("1) Add Customer");
            System.out.println("2) Add Employee");
            System.out.println("3) View All");
            System.out.println("4) Demonstrate Polymorphism (work())");
            System.out.println("5) Show VIP Customers (instanceof + casting)");
            System.out.println("0) Exit");
            System.out.print("Choose: ");

            int choice = readInt(sc);

            switch (choice) {
                case 1 -> addCustomer(sc);
                case 2 -> addEmployee(sc);
                case 3 -> viewAll();
                case 4 -> demonstratePolymorphism();
                case 5 -> showVIPCustomers();
                case 0 -> {
                    System.out.println("Program finished.");
                    sc.close();
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    private static void addCustomer(Scanner sc) {
        System.out.print("Customer ID: ");
        String id = sc.nextLine();

        System.out.print("Name: ");
        String name = sc.nextLine();

        System.out.print("Loyalty points (int): ");
        int points = readInt(sc);

        System.out.print("Membership (BASIC/SILVER/GOLD): ");
        String level = sc.nextLine();

        Customer c = new Customer(id, name, points, level);
        people.add(c);
        System.out.println("✅ Customer added: " + c);
    }

    private static void addEmployee(Scanner sc) {
        System.out.print("Employee ID: ");
        String id = sc.nextLine();

        System.out.print("Name: ");
        String name = sc.nextLine();

        System.out.print("Position: ");
        String position = sc.nextLine();

        System.out.print("Salary (double): ");
        double salary = readDouble(sc);

        Employee e = new Employee(id, name, position, salary);
        people.add(e);
        System.out.println("✅ Employee added: " + e);
    }

    private static void viewAll() {
        System.out.println("\n=== VIEW ALL (ArrayList<Person>) ===");
        if (people.isEmpty()) {
            System.out.println("No data.");
            return;
        }
        for (Person p : people) {
            System.out.println(p);
        }
    }

    private static void demonstratePolymorphism() {
        System.out.println("\n=== POLYMORPHISM DEMO ===");
        System.out.println("Calling work() for each Person in ArrayList<Person>:");
        for (Person p : people) {
            p.work();
        }
    }

    private static void showVIPCustomers() {
        System.out.println("\n=== VIP CUSTOMERS (instanceof + casting) ===");
        boolean found = false;

        for (Person p : people) {
            if (p instanceof Customer) {
                Customer c = (Customer) p;
                if (c.isVIP()) {
                    found = true;
                    System.out.println("VIP: " + c.getName() + " | points=" + c.getLoyaltyPoints()
                            + " | level=" + c.getMembershipLevel());
                }
            }
        }

        if (!found) System.out.println("No VIP customers yet.");
    }

    private static int readInt(Scanner sc) {
        while (true) {
            String line = sc.nextLine();
            try {
                return Integer.parseInt(line.trim());
            } catch (Exception e) {
                System.out.print("Enter a valid integer: ");
            }
        }
    }

    private static double readDouble(Scanner sc) {
        while (true) {
            String line = sc.nextLine();
            try {
                return Double.parseDouble(line.trim());
            } catch (Exception e) {
                System.out.print("Enter a valid number: ");
            }
        }
    }
}
