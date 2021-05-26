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
    
    public ViewRecords(String adminFName, String adminLName, String adminJobTitle, String adminPhoneNum, String adminEmail){
        
        this.adminFName = adminFName;
        this.adminLName = adminLName;
        this.adminJobTitle = adminJobTitle;
        this.adminPhoneNum = adminPhoneNum;
        this.adminEmail = adminEmail;
        
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
    
    
    
}
