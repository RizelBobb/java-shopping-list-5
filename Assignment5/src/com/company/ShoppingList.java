package com.company;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;


abstract class ShoppingList implements Shop {

    public ArrayList<ShoppingListItem> alItems;
    private String nameInput = null;
    private int qtyInput = 0;
    private int priorityInput = 0;
    private double sum = 0;

    private ArrayList<ShoppingListItem> getShoppingListItems() {
        return alItems;
    }

    private void setItems(ArrayList<ShoppingListItem> items) {
        this.alItems = items;
    }

    //for nameInput to will return true or false boolean if the nameinput contains numbers or not
    private boolean isValid(String nameInput) {
        if (!nameInput.matches("^[a-zA-Z_'&-]+( [a-zA-Z_'&-]+)*$")) {
            System.out.println("Try again");
            return false;
        } else return true;
    }

    public void askUserForItems() {
        Printing print = new Printing();
        //handled by printout interface
        print.numOfItems();
        Scanner scan = new Scanner(System.in);
        //ask user how many items they want to buy
        int num_Items = scan.nextInt();
        ArrayList<ShoppingListItem> items = new ArrayList<ShoppingListItem>();

        for (int i = 0; i < num_Items; i++) {

            do {
                //if the item name includes numbers, ask the user to enter item name
                System.out.print("Please enter item name: ");
                nameInput = scan.next();
            } while (!isValid(nameInput));
            //for priority
            System.out.print("Please enter item Priority: ");
            priorityInput = scan.nextInt();

            //for quantity
            System.out.print("Please enter item Quantity: ");
            qtyInput = scan.nextInt();

            //randomly generates the price and multiply it by the num of items
            double priceGenerated = (Math.round(Math.random() * 100) / 100) * qtyInput;
            //format the price to only have one or two decimal points
            double formattedPrice = Math.floor(priceGenerated);

            if (sum < 100) {
                //divide the remainder by the number of items
                double remainder = Math.round((100 - sum) / num_Items * 100) / 100;
                //add it to each item
                formattedPrice += remainder;
            }
            sum += Math.floor(formattedPrice);
            //create the new item with constructor
            ShoppingListItem newItem = new ShoppingListItem(nameInput, priorityInput, qtyInput, formattedPrice, sum);
            //add to the array list
            ShoppingListItem findItemName = findItemByName(nameInput, items);
            if (findItemName != null) {
                findItemName.setQuantity(qtyInput + findItemName.getQuantity());
            } else {
                items.add(newItem);
            }


            //print out what was added
            System.out.println(qtyInput + " " + nameInput + "(s)" + " with priority " + priorityInput + " for $" + formattedPrice + " has been added to the list");
            System.out.println("The current total is: " + sum);


            setItems(items);

        }

        //print out the shopping list
        System.out.println("\nInitial Shopping List");
        for (ShoppingListItem item : items) {
            System.out.println("Item Quantity: " + item.getQuantity() + " ,Item Name: " + item.getName() + ", Item Price: " + item.getPrice() + " priority " + item.getPriority());
            System.out.println(item.getTotal());
        }

    }

    public ShoppingListItem findItemByName(String name, List<ShoppingListItem> items) {
        for (ShoppingListItem item : items) {
            // compare the name of each item to the "name" argument
            if (item.getName().equalsIgnoreCase(name)) {
                // if you find a match, return the matching ShoppingListItem
                return item;
            }
        }
        return null;


    }

    public void readListFromFile() {

        try {
            //create file reader and buffer reader
            FileReader fr = new FileReader("shopping.txt");
            BufferedReader br = new BufferedReader(fr);
            String line = null;
            ArrayList<ShoppingListItem> items = new ArrayList<ShoppingListItem>();
            //reading the object by each line
            while ((line = br.readLine()) != null) {
                ShoppingListItem newItem = new ShoppingListItem(line);
                items.add(newItem);
                System.out.println(newItem);

            }
            setItems(items);

        } catch (IOException e) {
            System.out.println("Cannot read file" + e);

        }
    }

    public void writeListToFile() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("shopping.txt"));
            //print out each line and create it to a string
            for (ShoppingListItem item : getShoppingListItems()) {
                writer.write(item.toString());
                writer.newLine();

            }
            //  close the writer
            writer.close();
            //catch the error
        } catch (IOException e) {
            System.out.println("Cannot read file" + e);

        }
    }

}