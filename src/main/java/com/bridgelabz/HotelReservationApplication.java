package com.bridgelabz;

import java.util.*;

/**
 * Ability to add Hotel in a Hotel Reservation System with Name and rates for Regular Customer
 */

public class HotelReservationApplication {

    /**
     * Creating an ArrayList for storing list of hotels and its information
     */
    public List<Hotel> hotelList = new ArrayList<>();
    /**
     * Creating scanner class to take input from user
     */
    public static Scanner scanner = new Scanner(System.in);

    /**
     * Main method to perform modification on Hotel Reservation System
     * @param args - default java param
     */
    public static void main(String[] args) {
        /**
         * Printing a welcome message
         */
        System.out.println("Welcome to the Hotel Reservation System");

        HotelReservationApplication reservationApplication = new HotelReservationApplication();
        String userChoice;
        do {
            reservationApplication.readUserInput(scanner);
            System.out.println("Do you want to continue(Y/N) ?");
            userChoice = scanner.next();
        } while (userChoice.equalsIgnoreCase("Y"));
        System.out.println("Thank you!");
    }

    /**
     * Creating addHotelDetails to add all the details of the hotel into list which are given by user
     */
    public void readHotelDetails() {
        System.out.println("Please enter the Hotel Name: ");
        String hotelName = scanner.next();

        System.out.println("Please enter the rating: ");
        int rating = scanner.nextInt();

        System.out.println("Please enter the weekday rate for regular customer: ");
        double weekDayRate = scanner.nextDouble();

        System.out.println("Please enter the weekend rate for regular customer: ");
        double weekEndRate = scanner.nextDouble();
        /**
         * Creating a Hotel object and adding all the details into hotelList
         */
        this.addHotel(new Hotel(hotelName, rating, weekDayRate, weekEndRate));
    }

    public boolean addHotel(Hotel hotel) {
        return this.hotelList.add(hotel);
    }

    /**
     * Creating readUserInput to read input from the user and continue according to it
     * @param scanner - taking scanner as input
     */
    public void readUserInput(Scanner scanner) {
        System.out.println("Please select one option: ");
        System.out.println("1. Add Hotel Details\n2. Print Hotel Information");
        int option = scanner.nextInt();
        switch (option) {
            case 1:
                readHotelDetails();
                break;
            case 2:
                printHotelInformation();
                break;
            default:
                System.out.println("Invalid option. Please select valid");
        }
    }

    /**
     * Creating printHotelInformation to print the Hotel information list
     */
    public void printHotelInformation() {
        hotelList.stream().forEach(System.out::println);
    }
}
