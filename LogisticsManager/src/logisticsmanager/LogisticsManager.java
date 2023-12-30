package logisticsmanager;

import javax.swing.JOptionPane;
import java.util.Date;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;

/*------------------------------------------------------start------------------------------------------------------*/
//Java application that allows a user to select a town, weight category, and a relevant courier company
public class LogisticsManager {
    
    /*------------------------------------------main method start------------------------------------------*/
    public static void main(String args[]) {
        // Create an instance of Delivery_Details
        Delivery_Details deliveryDetails = new Delivery_Details();

        // Get user input for town
        String town = getUserInput("Select the town the parcel will be delivered to \n 1) Cape Town \n 2) Pretoria \n 3) Durban");
        if (town == null) {
            JOptionPane.showMessageDialog(null, "Application cancelled.");
            System.exit(0);
        }
        switch (town) {
            case "1":
                deliveryDetails.setTown("Cape Town");
                break;
            case "2":
                deliveryDetails.setTown("Pretoria");
                break;
            case "3":
                deliveryDetails.setTown("Durban");
                break;
            default:
                JOptionPane.showMessageDialog(null, "Invalid town selection.");
                System.exit(0);
        }

        // Get user input for weight category
        String category = getUserInput("Select the weight category of the parcel to be delivered to: " + deliveryDetails.getTown() + "\n 1) 0kg - 4kg \n 2) 5kg - 9kg \n 3) Over 10kg");
        if (category == null) {
            JOptionPane.showMessageDialog(null, "Application cancelled.");
            System.exit(0);
        }
        switch (category) {
            case "1":
                deliveryDetails.setWeight("0kg - 4kg");
                deliveryDetails.setPrice(300);
                break;
            case "2":
                deliveryDetails.setWeight("5kg - 9kg");
                deliveryDetails.setPrice(500);
                break;
            case "3":
                deliveryDetails.setWeight("Over 10kg");
                deliveryDetails.setPrice(700);
                break;
            default:
                JOptionPane.showMessageDialog(null, "Invalid weight category selection.");
                System.exit(0);
        }

        // Get user input for courier company
        String courier = getUserInput("Select the courier company to deliver the parcel weight of " + deliveryDetails.getWeight() + " to " + deliveryDetails.getTown() + "\n 1) ABC Couriers \n 2) Fast Track \n 3) Rest Assured");
        if (courier == null) {
            JOptionPane.showMessageDialog(null, "Application cancelled.");
            System.exit(0);
        }
        switch (courier) {
            case "1":
                deliveryDetails.setDeliveryCompany("ABC Couriers");
                break;
            case "2":
                deliveryDetails.setDeliveryCompany("Fast Track");
                break;
            case "3":
                deliveryDetails.setDeliveryCompany("Rest Assured");
                break;
            default:
                JOptionPane.showMessageDialog(null, "Invalid courier company selection.");
                System.exit(0);
        }

        // Generate and print the delivery report
        printDeliveryReport(deliveryDetails);
    }
    /*-------------------------------------------main method end-------------------------------------------*/ 

    // Helper method to get user input using JOptionPane
    private static String getUserInput(String message) {
        return JOptionPane.showInputDialog(null, message);
    }

    // Static method to print the delivery report
    public static void printDeliveryReport(Delivery_Details deliveryDetails) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date dateObject = new Date();

        // Use DecimalFormatSymbols to set the decimal separator to a period
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setDecimalSeparator('.');
        DecimalFormat decimalFormat = new DecimalFormat("R #,##0.00", symbols);

        System.out.println("DELIVERY REPORT - Created on " + dateFormat.format(dateObject));
        System.out.println("************************************************");
        System.out.printf("%-20s %s\n", "TOWN:", deliveryDetails.getTown());
        System.out.printf("%-20s %s\n", "WEIGHT:", deliveryDetails.getWeight());
        System.out.printf("%-20s %s\n", "PRICE:", decimalFormat.format(deliveryDetails.getPrice()));
        System.out.printf("%-20s %s\n", "VAT (14%):", decimalFormat.format(deliveryDetails.getPrice() * 0.14));
        System.out.printf("%-20s %s\n", "TOTAL DUE:", decimalFormat.format(deliveryDetails.getPrice() + deliveryDetails.getPrice() * 0.14));
        System.out.printf("%-20s %s\n", "COURIER:", deliveryDetails.getDeliveryCompany());
        System.out.println("************************************************");
    }
}
/*-------------------------------------------------------end-------------------------------------------------------*/
