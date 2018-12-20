package com.company;

public class Printing implements PrintOutput {
    //handling print outs, implemented by interface
    //need to refractor, not a good way of doing this, so I didn't add other print outs to this, but I do understand how to
    public void askPersonName() {
        System.out.println("What is your name?");
    }

    public void numOfItems() {
        System.out.println("How many items will you shop for today?");
    }

}
