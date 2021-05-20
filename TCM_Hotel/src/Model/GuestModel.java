/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import tcm.hotel.Guest;

/**
 *
 * @author Anuk
 */
public class GuestModel {
    
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
    
    public GuestModel(){
        this.guestFirstName = guestFirstName;
        this.guestLastName = guestLastName;
        this.guestAge = guestAge;
        this.guestPhoneNumber = guestPhoneNumber;
        this.guestEmail = guestEmail;
        this.guestAccountNumber = guestAccountNumber;
        this.guestAccountPin = guestAccountPin;
        this.hotelGuest = hotelGuest;
    }

    public String getGuestFirstName() {
        return guestFirstName;
    }

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
