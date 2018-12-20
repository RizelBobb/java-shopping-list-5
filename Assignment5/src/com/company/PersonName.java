package com.company;

import java.util.Scanner;

public class PersonName {

    private String personName;

    public String getPersonName() {
        return personName;
    }

    public void printUsersName() throws NoNumsException {
        //if the person's name includes numbers, throw exception
        Printing print = new Printing();
        print.askPersonName();
        Scanner person = new Scanner(System.in);
        personName = person.nextLine();

        if (!personName.matches("^[a-zA-Z_'&-]+( [a-zA-Z_'&-]+)*$")) {
            throw new NoNumsException("letters only!");
        }
    }
}
