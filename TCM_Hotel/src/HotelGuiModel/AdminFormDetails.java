/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HotelGuiModel;

/**
 * This is a description of the AdminFormDetails Model Class. This class will
 * declare 5 attributes which will be used in conjunction with getter and setter
 * methods in order to store the data of each administrator person object.
 *
 * @author Anuk
 */
public class AdminFormDetails {

    private String adminFirstName;
    private String adminLastName;
    private String adminJobTitle;
    private long adminPhoneNumber;
    private String adminEmailAddress;

    /**
     * This is the default constructor for the AdminFormDetails Model Class.
     * This constructor will be invoked when creating an object of the AdminFormDetails Model class.
     * @author Anuk
     */
    public AdminFormDetails() {
        this.adminFirstName = adminFirstName;
        this.adminLastName = adminLastName;
        this.adminJobTitle = adminJobTitle;
        this.adminPhoneNumber = adminPhoneNumber;
        this.adminEmailAddress = adminEmailAddress;
    }

    /**
     * the getAdminFirstName method returns the value of the adminFirstName
     * variable. This idea of the get method also applies to other get methods
     * found in this class aswell.
     *
     * @return adminFirstName the adminFirstName variable which stores the first
     * name of the admin.
     * @author Anuk
     */
    public String getAdminFirstName() {
        return adminFirstName;
    }

    /**
     * the setAdminFirstName method updates the value of the String
     * adminFirstName of an admin object. This idea of the set method also
     * applies to other set methods found in this class aswell.
     *
     * @param adminFirstName the adminFirstName variable which stores the first
     * name of an admin.
     * @author Anuk
     */
    public void setAdminFirstName(String adminFirstName) {
        this.adminFirstName = adminFirstName;
    }

    public String getAdminLastName() {
        return adminLastName;
    }

    public void setAdminLastName(String adminLastName) {
        this.adminLastName = adminLastName;
    }

    public String getAdminJobTitle() {
        return adminJobTitle;
    }

    public void setAdminJobTitle(String adminJobTitle) {
        this.adminJobTitle = adminJobTitle;
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
