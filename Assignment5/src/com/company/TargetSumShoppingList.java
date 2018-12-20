package com.company;

import java.lang.*;
import java.util.*;

//inheriting properties from the ShoppingList Class
public class TargetSumShoppingList extends ShoppingList {
    public void sortItems() {

        System.out.print("Press Y to sort list (Y): ");

        Scanner scan = new Scanner(System.in);
        String userResponse = scan.nextLine();
        if (userResponse.equalsIgnoreCase("Y")) {
            Collections.sort(alItems, new ShoppingListItem.Sortbypriority());
        }
        int arraySize = alItems.size();
        //selection sort
        //will sort by priority then price, but not using this anymore
        //            for (int i = 0; i < arraySize - 1; i++) {
        //                int min_idx = i;
        //                for (int j = i + 1; j < arraySize; j++) {
        //                    if (alItems.get(j).getPriority() < alItems.get(min_idx).getPriority())
        //                        min_idx = j;
        //                }
        //                ShoppingListItem temp = alItems.get(min_idx);
        //                alItems.set(min_idx, alItems.get(i));
        //                alItems.set(i, temp);


        System.out.println("\nSorted by priority and price");
        for (int y = 0; y < arraySize; ++y) {
            System.out.println(alItems.get(y).getName() + " $" + Math.floor(alItems.get(y).getPrice()) + " priority " + alItems.get(y).getPriority());

        }
    }


    public void goShopping() {
        //ask user for how much money they have
        System.out.print("What is your budget? ");
        Scanner scan = new Scanner(System.in);
        double newSum = 0;
        double bankAccount = scan.nextDouble();
        System.out.println("You currently have $" + bankAccount + "in your account");

        System.out.println("\nthe list we are choosing from for prices");
        for (int j = 0; j < alItems.size(); j++) {
            System.out.println(alItems.get(j).getName() + " $" + Math.floor(alItems.get(j).getPrice()) + " priority " + alItems.get(j).getPriority());
        }

        for (int i = 0; i < alItems.size(); i++) {
            //if the item price is less than budget, add them together
            if (alItems.get(i).getPrice() < bankAccount) {
                newSum += alItems.get(i).getPrice();
                //purchase from top to bottom..first on the list with the first priority
            } else if (alItems.get(i).getPrice() > bankAccount) {
                //if the item price is greater than bank account, don't add them together. These items are rejected
                System.out.println("You did not buy " + alItems.get(i).getName() + " $" + Math.floor(alItems.get(i).getPrice()) + " priority " + alItems.get(i).getPriority());
                continue;
            }
            if (newSum <= bankAccount) {
                //if the new added items are less than bank account, then print the items
                System.out.println("You did buy " + alItems.get(i).getName() + " for  $" + Math.floor(alItems.get(i).getPrice()) + " priority " + alItems.get(i).getPriority());

            } else if (newSum > bankAccount) {
                //if the new added items are greater than bank account, then print the items
                newSum -= alItems.get(i).getPrice();

                System.out.println("You did not buy " + alItems.get(i).getName() + " $" + Math.floor(alItems.get(i).getPrice()) + " priority " + alItems.get(i).getPriority());


            }


        }
        //return how much the user paid and how much they have in their bank account
        System.out.println("You paid $" + newSum);
        double leftOver = bankAccount - newSum;
        System.out.println("You have $" + leftOver + " left in your account!");


    }


}
