/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Anuk
 */
public class AdminModel {

    private String adminFirstName;
    private String adminLastName;
    private String adminStaffTitle;
    private long adminPhoneNumber;
    private String adminEmailAddress;

    public AdminModel() {
        this.adminFirstName = adminFirstName;
        this.adminLastName = adminLastName;
        this.adminStaffTitle = adminStaffTitle;
        this.adminPhoneNumber = adminPhoneNumber;
        this.adminEmailAddress = adminEmailAddress;
    }

    public String getAdminFirstName() {
        return adminFirstName;
    }

    public void setAdminFirstName(String adminFirstName) {
        this.adminFirstName = adminFirstName;
    }

    public String getAdminLastName() {
        return adminLastName;
    }

    public void setAdminLastName(String adminLastName) {
        this.adminLastName = adminLastName;
    }

    public String getAdminStaffTitle() {
        return adminStaffTitle;
    }

    public void setAdminStaffTitle(String adminStaffTitle) {
        this.adminStaffTitle = adminStaffTitle;
    }

    public long getAdminPhoneNumber() {
        return adminPhoneNumber;
    }

    public void setAdminPhoneNumber(long adminPhoneNumber) {
        this.adminPhoneNumber = adminPhoneNumber;
    }

    public String getAdminEmailAddress() {
        return adminEmailAddress;
    }

    public void setAdminEmailAddress(String adminEmailAddress) {
        this.adminEmailAddress = adminEmailAddress;
    }

}
