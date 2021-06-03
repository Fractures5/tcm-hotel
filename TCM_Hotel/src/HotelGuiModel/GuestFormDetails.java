/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HotelGuiModel;

import java.util.ArrayList;
import HotelDataFiles.Guest;

/**
 * This is a description of the GuestFormDetails Model Class. This class will
 * declare 7 attributes which will be used in conjunction with getter and setter
 * methods in order to store the data of each guest person object.
 *
 * @author Anuk
 */
public class GuestFormDetails {
    
    private String guestFirstName;
    private String guestLastName;
    private int guestAge;
    private long guestPhoneNumber;
    private String guestEmail;
    private String guestAccountNumber;
    private String guestAccountPin;
    
    private ArrayList<Guest> hotelGuest = new ArrayList<>();

    public ArrayList<Guest> getHotelGuest() {
        return hotelGuest;
    }

    public void setHotelGuest(ArrayList<Guest> hotelGuest) {
        this.hotelGuest = hotelGuest;
    }
    
    /**
     * This is the default constructor for the GuestFormDetails Model Class.
     * This constructor will be invoked when creating an object of the
     * GuestFormDetails Model class.
     *
     * @author Anuk
     */
    public GuestFormDetails(){
        this.guestFirstName = guestFirstName;
        this.guestLastName = guestLastName;
        this.guestAge = guestAge;
        this.guestPhoneNumber = guestPhoneNumber;
        this.guestEmail = guestEmail;
        this.guestAccountNumber = guestAccountNumber;
        this.guestAccountPin = guestAccountPin;
        this.hotelGuest = hotelGuest;
    }

    /**
     * the getGuestFirstName method returns the value of the guestFirstName
     * variable. This idea of the get method also applies to other get methods
     * found in this class aswell.
     *
     * @return guestFirstName the guestFirstName variable which stores the first
     * name of the guest.
     * @author Anuk
     */
    public String getGuestFirstName() {
        return guestFirstName;
    }
    
    /**
     * the setGuestFirstName method updates the value of the String
     * guestFirstName of a guest object. This idea of the set method also
     * applies to other set methods found in this class aswell.
     *
     * @param guestFirstName the guestFirstName variable which stores the first
     * name of a guest.
     * @author Anuk
     */
    public void setGuestFirstName(String guestFirstName) {
        this.guestFirstName = guestFirstName;
    }

    public String getGuestLastName() {
        return guestLastName;
    }

    public void setGuestLastName(String guestLastName) {
        this.guestLastName = guestLastName;
    }

    public int getGuestAge() {
        return guestAge;
    }

    public void setGuestAge(int guestAge) {
        this.guestAge = guestAge;
    }

    public long getGuestPhoneNumber() {
        return guestPhoneNumber;
    }

    public void setGuestPhoneNumber(long guestPhoneNumber) {
        this.guestPhoneNumber = guestPhoneNumber;
    }

    public String getGuestEmail() {
        return guestEmail;
    }

    public void setGuestEmail(String guestEmail) {
        this.guestEmail = guestEmail;
    }

    public String getGuestAccountNumber() {
        return guestAccountNumber;
    }

    public void setGuestAccountNumber(String guestAccountNumber) {
        this.guestAccountNumber = guestAccountNumber;
    }

    public String getGuestAccountPin() {
        return guestAccountPin;
    }

    public void setGuestAccountPin(String guestAccountPin) {
        this.guestAccountPin = guestAccountPin;
    }
}
