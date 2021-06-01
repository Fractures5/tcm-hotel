/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HotelDataFiles;

/**
 * This is a description of the staffMember class.
 * The staffMember class will extend the Person class and it will
 * declare 2 private variables, one integer for staff identification number
 * and one string for the job title of the staff member.
 * Also, using the user's input, a staff member object will be created
 * that will be used for the admin functionalities of the booking system.
 * 
 * @author Anuk
 */

public class StaffMember extends Person
{
    private String jobTitle;
    
    public StaffMember()
    {
    }
    
    /**
     * This is the constructor for the StaffMember class.
     * This constructor is used to initialize staff member objects with the instanced variables which
     * store the staff member's details.
     * This constructor also uses super to invoke the appropriate constructor in the Person class.
     * @param firstName the firstName represents the first name of the staff member.
     * @param lastName the lastName represents the last name of the staff member.
     * @param jobTitle the jobTitle represents the position or title of the staff member.
     * @param personNumber the personNumber represents the contact phone number of the staff member.
     * @param personEmail the personEmail represents the contact email address of the staff member
     */
    
    public StaffMember(String firstName, String lastName, String jobTitle, long personNumber, String personEmail) 
    {
        super(firstName, lastName, personEmail, personNumber);
        this.jobTitle = jobTitle;
    }
    
    /**
     * the getJobTitle method returns the value of the jobTitle variable.
     * @return jobTitle the jobTitle variable which stores the job title or position of the staff member.
     */
    
    public String getJobTitle() 
    {
        return jobTitle;
    }
    
    /**
     * the setJobTitle method updates the value of the String jobTitle of a staff member object.
     * @param jobTitle the jobTitle variable which stores the job title or position of the staff member.
     */

    public void setJobTitle(String jobTitle) 
    {
        this.jobTitle = jobTitle;
    }    

    @Override
    public void personalizedMessage() 
    {
        System.out.println("\n-----------------------------------------------------------------");
        System.out.println("             Opening Admin menu - PRIVATE ACCESS!                  ");
        System.out.println("-----------------------------------------------------------------\n"); 
    }
}
