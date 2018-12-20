package com.company;

import java.util.Comparator;

public class ShoppingListItem {

    //constructor class

    private String name;
    private double price;
    private int priority;
    private double total;
    private int quantity;

    public ShoppingListItem(String name, int priority, int quantity, double price, double total) {
        //constructor class
        this.name = name;
        this.priority = priority;
        this.quantity = quantity;
        this.price = price;
        this.total = total;

    }

    public ShoppingListItem(String line) {
        //constructor class
        String input[] = line.split("\\s*,\\s*");
        this.name = input[0];
        this.priority = Integer.parseInt(input[1]);
        this.quantity = Integer.parseInt(input[2]);
        this.price = Double.parseDouble(input[3]);
    }


    ShoppingListItem() {
        //my default constructor class
        name = "";
        priority = 0;
        quantity = 0;
        price = 0;
        total = 0;
    }

    //using the copy method
    ShoppingListItem(ShoppingListItem original) {
        name = original.name;
        priority = original.priority;
        price = original.price;
        total = original.total;
        quantity = original.quantity;
    }

    //getters and setters
    public String getName() {

        return name;
    }

    public double getPrice() {

        return price;
    }

    public int getPriority() {

        return priority;
    }

    public int getQuantity() {

        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


    public double getTotal() {
        return total;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ShoppingListItem) {
            ShoppingListItem listItem = (ShoppingListItem) obj;
            return name.equals(listItem.name) && priority == listItem.priority && quantity == listItem.quantity;
        }
        return false;
    }


    @Override

    public String toString() {
//will print as name, priority, quantity
        return new StringBuffer(this.name).append(", ").append(this.priority).append(", ").append(this.quantity).append(", ").append(this.price).toString();

    }


    public static class Sortbypriority implements Comparator<ShoppingListItem> {
        // Used for sorting in ascending order of priority
        public int compare(ShoppingListItem a, ShoppingListItem b) {
            int ret = a.priority - b.priority;
            //if the priority is the same
            if (ret == 0) {
                //then sort by price low to high
                return (int) (a.price - b.price);
            } else {
                return ret;
            }

        }
    }
}

