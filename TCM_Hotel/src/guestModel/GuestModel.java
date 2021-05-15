/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guestModel;

/**
 *
 * @author Anuk
 */
public class GuestModel {
    
    private String inputFirstName;
    private String inputLastName;
    private int guestAge = 0;
    private String inputPhoneNumber;
    private String inputEmail;
    private String inputAccountNumber;
    private String inputAccountPin;
    private boolean validAge = false;
    private boolean validEmail = false;
    private boolean validAccountNumber = false;

    public String getInputFirstName() {
        return inputFirstName;
    }

    public void setInputFirstName(String inputFirstName) {
        this.inputFirstName = inputFirstName;
    }

    public String getInputLastName() {
        return inputLastName;
    }

    public void setInputLastName(String inputLastName) {
        this.inputLastName = inputLastName;
    }

    public int getGuestAge() {
        return guestAge;
    }

    public void setGuestAge(int guestAge) {
        this.guestAge = guestAge;
    }

    public String getInputPhoneNumber() {
        return inputPhoneNumber;
    }

    public void setInputPhoneNumber(String inputPhoneNumber) {
        this.inputPhoneNumber = inputPhoneNumber;
    }

    public String getInputEmail() {
        return inputEmail;
    }

    public void setInputEmail(String inputEmail) {
        this.inputEmail = inputEmail;
    }

    public String getInputAccountNumber() {
        return inputAccountNumber;
    }

    public void setInputAccountNumber(String inputAccountNumber) {
        this.inputAccountNumber = inputAccountNumber;
    }

    public String getInputAccountPin() {
        return inputAccountPin;
    }

    public void setInputAccountPin(String inputAccountPin) {
        this.inputAccountPin = inputAccountPin;
    }

    public boolean isValidAge() {
        return validAge;
    }

    public void setValidAge(boolean validAge) {
        this.validAge = validAge;
    }

    public boolean isValidEmail() {
        return validEmail;
    }

    public void setValidEmail(boolean validEmail) {
        this.validEmail = validEmail;
    }

    public boolean isValidAccountNumber() {
        return validAccountNumber;
    }

    public void setValidAccountNumber(boolean validAccountNumber) {
        this.validAccountNumber = validAccountNumber;
    }

}
