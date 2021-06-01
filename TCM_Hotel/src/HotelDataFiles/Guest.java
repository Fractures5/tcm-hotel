/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HotelDataFiles;

/**
 * This is a description of the Guest Class.
 * In the Guest class which extends the Person parent class, 
 * it declares 2 private variables one String for the bank account number
 * and one integer for the bank account pin.
 * Also, using the user's input, a guest object will be created
 * that will be used for the booking system.
 * 
 * @author Anuk
 */

import java.io.Serializable;

public class Guest extends Person implements Serializable
{

    private String bankAccountNo;
    private String bankAccountPin;
    
    /**
     * This is the constructor for the Guest class.
     * This constructor is used to initialize guest objects with the instanced variables which
     * store the guest's details.
     * This constructor also uses super to invoke the appropriate constructor in the Person class.
     * @param firstName the firstName represents the first name of the guest.
     * @param lastName the lastName represents the last name of the guest.
     * @param personAge the personAge represents the age of the guest.
     * @param personEmail the personEmail represents the contact email address of the guest.
     * @param personNumber the personNumber represents the contact phone number of the guest.
     * @param bankAccountNo the bankAccountNo represents the bank account number of the guest.
     * @param bankAccountPin the bankAccountPin represents the guest's bank account pin number for their bank account.
     */
    
    public Guest(String firstName, String lastName, int personAge, String personEmail, long personNumber, String bankAccountNo, String bankAccountPin) 
    {
        super(firstName, lastName, personAge, personEmail, personNumber);
        this.bankAccountNo = bankAccountNo;
        this.bankAccountPin = bankAccountPin;
    }
    
    public Guest() 
    {
    }
    /**
     * the getBankAccountNo method returns the value of the bankAccountNo variable.
     * This idea of the get method also applies to other get methods found in this class aswell.
     * @return bankAccountNo the bankAccountNo variable which stores the bank account number of the guest.
     */

    public String getBankAccountNo() 
    {
        return bankAccountNo;
    }
    
    /**
     * the setBankAccountNo method updates the value of the String bankAccountNo of a guest object.
     * This idea of the set method also applies to other set methods found in this class aswell.
     * @param bankAccountNo the bankAccountNo variable which stores the bank account number of the guest.
     */
    public void setBankAccountNo(String bankAccountNo) 
    {
        this.bankAccountNo = bankAccountNo;
    }

    public String getBankAccountPin() 
    {
        return bankAccountPin;
    }

    public void setBankAccountPin(String bankAccountPin)
    {
        this.bankAccountPin = bankAccountPin;
    }
    
    /**
     * The toString method returns the values of the bankAccountNo in String so it displays when the System.out.println() statement is used.
     * @return bankAccountNo the bankAccountNo variable which stores the bank account number of the guest.
     */
    public String toString()
    {
        return bankAccountNo;
    }
    
    @Override
    public void personalizedMessage() 
    {
        System.out.println("\n-----------------------------------------------------------------");
        System.out.println("               Opening the customer booking page....               ");
        System.out.println("-----------------------------------------------------------------\n");
    }
}
