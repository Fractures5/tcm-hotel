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
    
    public ViewRecords(String adminFName, String adminLName, String adminJobTitle, String adminPhoneNum, String adminEmail){
        
        this.adminFName = adminFName;
        this.adminLName = adminLName;
        this.adminJobTitle = adminJobTitle;
        this.adminPhoneNum = adminPhoneNum;
        this.adminEmail = adminEmail;
        
    }
    
    public ViewRecords(String guestFName, String guestLName, String guestAge, String guestPhoneNum, String guestEmailAddress, String guestAccountNumber, String guestTotalPaid) {

        this.guestFName = guestFName;
        this.guestLName = guestLName;
        this.guestAge = guestAge;
        this.guestPhoneNum = guestPhoneNum;
        this.guestEmailAddress = guestEmailAddress;
        this.guestAccountNumber = guestAccountNumber;
        this.guestTotalPaid = guestTotalPaid;
    }
    
    public ViewRecords(String guestAccountNumber, String guestFName, String locationTitle, LocationType location) {
        
        this.guestAccountNumber = guestAccountNumber;
        this.guestFName = guestFName;
        this.locationTitle = locationTitle;
        this.location = location;
    }
    
    public ViewRecords(String guestAccountNumber, String guestFName, String roomTitle, RoomType roomType) {
        
        this.guestAccountNumber = guestAccountNumber;
        this.guestFName = guestFName;
        this.roomTitle = roomTitle;
        this.roomType = roomType;
    }
    
    public ViewRecords(String guestAccountNumber, String guestFName, String featureTitle, ExtraFeatureTypes featureType) {
        
        this.guestAccountNumber = guestAccountNumber;
        this.guestFName = guestFName;
        this.featureTitle = featureTitle;
        this.featureType = featureType;
    }
    
    public ViewRecords(String guestAccountNumber, String guestFName, String guestTitle, GuestType guestType) {
        
        this.guestAccountNumber = guestAccountNumber;
        this.guestFName = guestFName;
        this.guestTitle = guestTitle;
        this.guestType = guestType;
    }
    
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
