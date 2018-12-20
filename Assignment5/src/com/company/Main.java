package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws NoNumsException {
        int choiceEntry;
        PersonName name = new PersonName();
        Scanner scan = new Scanner(System.in);
        name.printUsersName();
        System.out.println("Welcome " + name.getPersonName() + "! It's time to shop!");
        ShoppingList list = new TargetSumShoppingList();
        //menu
        String mainMenu = "MENU 1: WRITE LIST | 2: READ LIST | 3: GO SHOPPING | 4: EXIT";
        //after every menu chapter is done, prompt user to choose next chapter, unless they choose to exit program
        do {
            System.out.println(mainMenu);
            choiceEntry = scan.nextInt();
            switch (choiceEntry) {
                case 1:
                    list.askUserForItems();
                    list.writeListToFile();
                    break;
                case 2:
                    System.out.println("Here's what you plan to buy");
                    list.readListFromFile();
                    break;
                case 3:
                    list.sortItems();
                    list.goShopping();
                    break;
                case 4:
                    //exit the program
                    System.exit(0);
                default:
                    System.out.println("Wrong input");
            }

        } while (choiceEntry < 4 && choiceEntry > 0);

    }

}