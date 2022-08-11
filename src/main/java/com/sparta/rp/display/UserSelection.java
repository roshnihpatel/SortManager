package com.sparta.rp.display;

import java.util.Scanner;

public  class UserSelection {

    public static int makeSorterSelection( Scanner userInput) {
        System.out.println("Please select an option");
        System.out.println("1: Bubble Sort \n3: Quit");
        int option = userInput.nextInt();

        return option;

    }

    public static int makeArrayLengthSelection(Scanner userInput) {
        System.out.println("Select length of array to sort");
        return userInput.nextInt();

    }
}
