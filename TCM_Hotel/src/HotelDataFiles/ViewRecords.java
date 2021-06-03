/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HotelDataFiles;

import HotelEnums.ExtraFeatureTypes;
import HotelEnums.GuestType;
import HotelEnums.LocationType;
import HotelEnums.RoomType;

/**
 * The is a description of the ViewRecords class. The ViewRecords class will
 * store all the fetched data from the derby tables into String datatypes except
 * the data which are an enumerated type where such data will be stored into a
 * variable where the datatype will be of its respective enumerated type class.
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
    private String guestTotalPaid = "";
    
    private String locationTitle = "";
    private LocationType location;
    
    private String roomTitle = "";
    private RoomType roomType;
    
    private String featureTitle = "";
    private ExtraFeatureTypes featureType;
    
    private String guestTitle = "";
    private GuestType guestType;
    
    private String checkInDay = "";
    private String checkInMonth = "";
    private String checkInYear = "";
    private String checkOutDay = "";
    private String checkOutMonth = "";
    private String checkOutYear = "";
    
    /**
     * This is the constructor that will be invoked when the getStaffRecords
     * method is making objects of the fetched data from the database tables row
     * by row. For each row of the table data, this constructor will be invoked
     * setting the data of the ViewRecord objects being created in the
     * getStaffRecords method.
     *
     * @param adminFName the adminFName variable will set the first name of the
     * admin ViewRecords object with the data fetched from the table.
     * @param adminLName the adminLName variable will set the last name of the
     * admin ViewRecords object with the data fetched from the table.
     * @param adminJobTitle the adminJobTitle variable will set the job title of
     * the admin ViewRecords object with the data fetched from the table.
     * @param adminPhoneNum the adminPhoneNum variable will set the phone number
     * of the admin ViewRecords object with the data fetched from the table.
     * @param adminEmail the adminEmail variable will set the email address of
     * the admin ViewRecords object with the data fetched from the table.
     * @author Anuk
     */
    public ViewRecords(String adminFName, String adminLName, String adminJobTitle, String adminPhoneNum, String adminEmail){
        
        this.adminFName = adminFName;
        this.adminLName = adminLName;
        this.adminJobTitle = adminJobTitle;
        this.adminPhoneNum = adminPhoneNum;
        this.adminEmail = adminEmail;
        
    }
    
    /**
     * This is the constructor that will be invoked when the getGuestRecords
     * method is making objects of the fetched data from the database tables row
     * by row. For each row of the table data, this constructor will be invoked
     * setting the data of the ViewRecord objects being created in the
     * getGuestRecords method.
     *
     * @param guestFName the guestFName variable will set the first name of the
     * guest ViewRecords object with the data fetched from the table.
     * @param guestLName the guestLName variable will set the last name of the
     * guest ViewRecords object with the data fetched from the table.
     * @param guestAge the guestAge variable will set the age of the guest
     * ViewRecords object with the data fetched from the table.
     * @param guestPhoneNum the guestPhoneNum variable will set the phone number
     * of the guest ViewRecords object with the data fetched from the table.
     * @param guestEmailAddress the guestEmailAddress variable will set the
     * email address of the guest ViewRecords object with the data fetched from
     * the table.
     * @param guestAccountNumber the guestAccountNmber variable will set the
     * account number of the guest ViewRecords object with the data fetched from
     * the table.
     * @param guestTotalPaid the guestTotalPaid variable will set the total paid
     * price of the guest ViewRecords object with the data fetched from the
     * table.
     * @author Anuk
     */
    public ViewRecords(String guestFName, String guestLName, String guestAge, String guestPhoneNum, String guestEmailAddress, String guestAccountNumber, String guestTotalPaid) {

        this.guestFName = guestFName;
        this.guestLName = guestLName;
        this.guestAge = guestAge;
        this.guestPhoneNum = guestPhoneNum;
        this.guestEmailAddress = guestEmailAddress;
        this.guestAccountNumber = guestAccountNumber;
        this.guestTotalPaid = guestTotalPaid;
    }
    
    /**
     * This is the constructor that will be invoked when the getGuestRecords
     * method is making objects of the fetched data from the database tables row
     * by row. For each row of the table data, this constructor will be invoked
     * setting the data of the ViewRecord objects being created in the
     * getLocationsBookedRecords method.
     *
     * @param guestAccountNumber the guestAccountNmber variable will set the
     * account number of the guest ViewRecords object with the data fetched from
     * the table.
     * @param guestFName the guestFName variable will set the first name of the
     * guest ViewRecords object with the data fetched from the table.
     * @param locationTitle the locationTitle variable will set the location
     * title of the guest ViewRecords object with the data fetched from the
     * table.
     * @param location the location variable will set the location of the guest
     * ViewRecords object with the data fetched from the table.
     * @author Anuk
     */
    public ViewRecords(String guestAccountNumber, String guestFName, String locationTitle, LocationType location) {
        
        this.guestAccountNumber = guestAccountNumber;
        this.guestFName = guestFName;
        this.locationTitle = locationTitle;
        this.location = location;
    }
    
    /**
     * This is the constructor that will be invoked when the getGuestRecords
     * method is making objects of the fetched data from the database tables row
     * by row. For each row of the table data, this constructor will be invoked
     * setting the data of the ViewRecord objects being created in the
     * getRoomsBookedRecords method.
     *
     * @param guestAccountNumber the guestAccountNmber variable will set the
     * account number of the guest ViewRecords object with the data fetched from
     * the table.
     * @param guestFName the guestFName variable will set the first name of the
     * guest ViewRecords object with the data fetched from the table.
     * @param roomTitle the roomTitle variable will set the room title of the
     * guest ViewRecords object with the data fetched from the table.
     * @param roomType the roomType variable will set the room type of the guest
     * ViewRecords object with the data fetched from the table.
     * @author Anuk
     */
    public ViewRecords(String guestAccountNumber, String guestFName, String roomTitle, RoomType roomType) {
        
        this.guestAccountNumber = guestAccountNumber;
        this.guestFName = guestFName;
        this.roomTitle = roomTitle;
        this.roomType = roomType;
    }
    
    /**
     * This is the constructor that will be invoked when the getGuestRecords
     * method is making objects of the fetched data from the database tables row
     * by row. For each row of the table data, this constructor will be invoked
     * setting the data of the ViewRecord objects being created in the
     * getFeaturesBookedRecords method.
     *
     * @param guestAccountNumber the guestAccountNmber variable will set the
     * account number of the guest ViewRecords object with the data fetched from
     * the table.
     * @param guestFName the guestFName variable will set the first name of the
     * guest ViewRecords object with the data fetched from the table.
     * @param featureTitle the featureTitle variable will set the feature title
     * of the guest ViewRecords object with the data fetched from the table.
     * @param featureType the featureType variable will set the feature type of
     * the guest ViewRecords object with the data fetched from the table.
     * @author Anuk
     */
    public ViewRecords(String guestAccountNumber, String guestFName, String featureTitle, ExtraFeatureTypes featureType) {
        
        this.guestAccountNumber = guestAccountNumber;
        this.guestFName = guestFName;
        this.featureTitle = featureTitle;
        this.featureType = featureType;
    }
    
    /**
     * This is the constructor that will be invoked when the getGuestRecords
     * method is making objects of the fetched data from the database tables row
     * by row. For each row of the table data, this constructor will be invoked
     * setting the data of the ViewRecord objects being created in the
     * getGuestTypesRecords method.
     *
     * @param guestAccountNumber the guestAccountNmber variable will set the
     * account number of the guest ViewRecords object with the data fetched from
     * the table.
     * @param guestFName the guestFName variable will set the first name of the
     * guest ViewRecords object with the data fetched from the table.
     * @param guestTitle the guestTitle variable will set the guest title of the
     * guest ViewRecords object with the data fetched from the table.
     * @param guestType the guestType variable will set the guest type of the
     * guest ViewRecords object with the data fetched from the table.
     */
    public ViewRecords(String guestAccountNumber, String guestFName, String guestTitle, GuestType guestType) {
        
        this.guestAccountNumber = guestAccountNumber;
        this.guestFName = guestFName;
        this.guestTitle = guestTitle;
        this.guestType = guestType;
    }
    
    /**
     * This is the constructor that will be invoked when the getGuestRecords
     * method is making objects of the fetched data from the database tables row
     * by row. For each row of the table data, this constructor will be invoked
     * setting the data of the ViewRecord objects being created in the
     * getDatesBookedRecords method.
     *
     * @param guestAccountNumber the guestAccountNmber variable will set the
     * account number of the guest ViewRecords object with the data fetched from
     * the table.
     * @param guestFName the guestFName variable will set the first name of the
     * guest ViewRecords object with the data fetched from the table.
     * @param location the location variable will set the location of the guest
     * ViewRecords object with the data fetched from the table.
     * @param checkInDay the checkInDay variable will set the check in day of
     * the guest ViewRecords object with the data fetched from the table.
     * @param checkInMonth the checkInMonth variable will set the check in month
     * of the guest ViewRecords object with the data fetched from the table.
     * @param checkInYear the checkInYear variable will set the check in year of
     * the guest ViewRecords object with the data fetched from the table.
     * @param checkOutDay the checkOutDay variable will set the check out day of
     * the guest ViewRecords object with the data fetched from the table.
     * @param checkOutMonth the checkOutMonth variable will set the check out
     * month of the guest ViewRecords object with the data fetched from the
     * table.
     * @param checkOutYear the checkOutYear variable will set the check out year
     * of the guest ViewRecords object with the data fetched from the table.
     */
    public ViewRecords(String guestAccountNumber, String guestFName, LocationType location, String checkInDay,
            String checkInMonth, String checkInYear, String checkOutDay, String checkOutMonth, String checkOutYear) {
        
        this.guestAccountNumber = guestAccountNumber;
        this.guestFName = guestFName;
        this.location = location;
        this.checkInDay = checkInDay;
        this.checkInMonth = checkInMonth;
        this.checkInYear = checkInYear;
        this.checkOutDay = checkOutDay;
        this.checkOutMonth = checkOutMonth;
        this.checkOutYear = checkOutYear;
    }

    /**
     * This is the getter method for the guestTotalPaid variable. This method
     * will return the value stored in the guestTotalPaid variable. The idea of
     * this getter method applies to all other getter methods found in the
     * ViewRecords class.
     *
     * @return guestTotalPaid the guestTotalPaid variable stores the value of
     * how much the guest has paid for their booking
     * @author Anuk
     */
    public String getGuestTotalPaid() {
        return guestTotalPaid;
    }
    
    public String getCheckInDay() {
        return checkInDay;
    }

    public String getCheckInMonth() {
        return checkInMonth;
    }

    public String getCheckInYear() {
        return checkInYear;
    }

    public String getCheckOutDay() {
        return checkOutDay;
    }

    public String getCheckOutMonth() {
        return checkOutMonth;
    }

    public String getCheckOutYear() {
        return checkOutYear;
    }

    public ExtraFeatureTypes getFeatureType() {
        return featureType;
    }

    public String getGuestTitle() {
        return guestTitle;
    }

    public GuestType getGuestType() {
        return guestType;
    }
    
    public String getFeatureTitle() {
        return featureTitle;
    }

    public ExtraFeatureTypes getfeatureType() {
        return featureType;
    }

    public String getRoomTitle() {
        return roomTitle;
    }

    public RoomType getRoomType() {
        return roomType;
    }
    
    public String getLocationTitle() {
        return locationTitle;
    }

    public LocationType getLocation() {
        return location;
    }

    public String getAdminFName() {
        return adminFName;
    }

    /**
     * the setAdminFName method updates the value of the String adminFName of a
     * ViewRecords object. This idea of the set method also applies to other set
     * methods found in the ViewRecords class.
     *
     * @param adminFName the adminFName variable which stores the admin first
     * name.
     */
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
