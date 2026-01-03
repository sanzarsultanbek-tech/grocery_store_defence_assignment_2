package com.example.grocerystore;

public class Customer extends Person {
    private int loyaltyPoints;
    private String membershipLevel;

    public Customer(String id, String name, int loyaltyPoints, String membershipLevel) {
        super(id, name);  
        setLoyaltyPoints(loyaltyPoints);
        setMembershipLevel(membershipLevel);
        updateMembership();
    }

    public Customer() {
        this("C000", "Guest", 0, "BASIC");
    }

    public int getLoyaltyPoints() { return loyaltyPoints; }
    public String getMembershipLevel() { return membershipLevel; }

    public void setLoyaltyPoints(int loyaltyPoints) {
        if (loyaltyPoints < 0) {
            this.loyaltyPoints = 0;
        } else {
            this.loyaltyPoints = loyaltyPoints;
        }
        updateMembership();
    }

    public void setMembershipLevel(String membershipLevel) {
        if (membershipLevel == null) {
            this.membershipLevel = "BASIC";
            return;
        }
        String lvl = membershipLevel.trim().toUpperCase();
        if (lvl.equals("BASIC") || lvl.equals("SILVER") || lvl.equals("GOLD")) {
            this.membershipLevel = lvl;
        } else {
            this.membershipLevel = "BASIC";
        }
    }

    public void addLoyaltyPoints(int points) {
        if (points > 0) {
            this.loyaltyPoints += points;
            updateMembership();
        }
    }

    public boolean isVIP() {
        return loyaltyPoints >= 1000 || membershipLevel.equals("GOLD");
    }

    private void updateMembership() {
        if (loyaltyPoints >= 2000) membershipLevel = "GOLD";
        else if (loyaltyPoints >= 500) membershipLevel = "SILVER";
        else membershipLevel = "BASIC";
    }

    @Override
    public String getRole() {
        return "Customer";
    }

    @Override
    public void work() {
        System.out.println(name + " is shopping. Points: " + loyaltyPoints + ", Level: " + membershipLevel);
    }

    @Override
    public String toString() {
        return super.toString() + ", points=" + loyaltyPoints + ", level=" + membershipLevel;
    }
}
