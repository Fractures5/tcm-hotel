/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcm.hotel;

/**
 *
 * @author Anuk
 */
public class ViewRecords {
    
    private String adminFName = "";
    private String adminLName = "";
    private String adminJobTitle = "";
    private String adminPhoneNum = "";
    private String adminEmail = "";
    
    private String guestFName = "";
    private String guestLName = "";
    private String guestAge = "";
    private String guestPhoneNum = "";
    private String guestEmailAddress = "";
    private String guestAccountNumber = "";
    
    public ViewRecords(String adminFName, String adminLName, String adminJobTitle, String adminPhoneNum, String adminEmail){
        
        this.adminFName = adminFName;
        this.adminLName = adminLName;
        this.adminJobTitle = adminJobTitle;
        this.adminPhoneNum = adminPhoneNum;
        this.adminEmail = adminEmail;
        
    }
    
    public ViewRecords(String guestFName, String guestLName, String guestAge, String guestPhoneNum, String guestEmailAddress, String guestAccountNumber) {

        this.guestFName = guestFName;
        this.guestLName = guestLName;
        this.guestAge = guestAge;
        this.guestPhoneNum = guestPhoneNum;
        this.guestEmailAddress = guestEmailAddress;
        this.guestAccountNumber = guestAccountNumber;
    }

    public String getAdminFName() {
        return adminFName;
    }

    public void setAdminFName(String adminFName) {
        this.adminFName = adminFName;
    }

    public String getAdminLName() {
        return adminLName;
    }

    public void setAdminLName(String adminLName) {
        this.adminLName = adminLName;
    }

    public String getAdminJobTitle() {
        return adminJobTitle;
    }

    public void setAdminJobTitle(String adminJobTitle) {
        this.adminJobTitle = adminJobTitle;
    }

    public String getAdminPhoneNum() {
        return adminPhoneNum;
    }

    public void setAdminPhoneNum(String adminPhoneNum) {
        this.adminPhoneNum = adminPhoneNum;
    }

    public String getAdminEmail() {
        return adminEmail;
    }

    public void setAdminEmail(String adminEmail) {
        this.adminEmail = adminEmail;
    }

    public String getGuestFName() {
        return guestFName;
    }

    public void setGuestFName(String guestFName) {
        this.guestFName = guestFName;
    }

    public String getGuestLName() {
        return guestLName;
    }

    public void setGuestLName(String guestLName) {
        this.guestLName = guestLName;
    }

    public String getGuestAge() {
        return guestAge;
    }

    public void setGuestAge(String guestAge) {
        this.guestAge = guestAge;
    }

    public String getGuestPhoneNum() {
        return guestPhoneNum;
    }

    public void setGuestPhoneNum(String guestPhoneNum) {
        this.guestPhoneNum = guestPhoneNum;
    }

    public String getGuestEmailAddress() {
        return guestEmailAddress;
    }

    public void setGuestEmailAddress(String guestEmailAddress) {
        this.guestEmailAddress = guestEmailAddress;
    }

    public String getGuestAccountNumber() {
        return guestAccountNumber;
    }

    public void setGuestAccountNumber(String guestAccountNumber) {
        this.guestAccountNumber = guestAccountNumber;
    }
    
    
}
