/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelModel;

/**
 * This is a class description of the Person class which is the parent class
 * of the Guest and StaffMember class.
 * This class declares 5 private variables, one string for first name, 
 * one string for last name, one integer for age, 
 * one string for email and one string for phone number.
 *
 * @author Anuk
 */
public abstract class Person implements java.io.Serializable{ //make abstract class
    
    private String firstName;
    private String lastName;
    private int personAge;
    private String personEmail;
    private long personNumber;
    
    public Person() 
    {
    }
    
    /**
     * This is a constructor for the Person Class.
     * This constructor will be invoked when creating a Guest object from the user's input and this 
     * constructor will initialize the Person objects with the provided inputs stored in the variables.
     * @param firstName the firstName variable stores the first name of the person.
     * @param lastName the lastName variable stores the last name of the person.
     * @param personAge the personAge variable stores the age of the person.
     * @param personEmail the personEmail variable stores the contact email address of the person.
     * @param personNumber the personNumber variable stores the contact number of the person.
     */
    
    Person(String firstName, String lastName,int personAge, String personEmail, long personNumber)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.personAge = personAge;
        this.personEmail = personEmail;
        this.personNumber = personNumber;
    }
    
    /**
     * This is another constructor for the Person Class.
     * This constructor will be invoked when creating a StaffMember object from the user's input and this
     * constructor will initialize the Person objects with the provided inputs stored in the variables.
     * @param firstName the firstName variable stores the first name of the person.
     * @param lastName the lastName variable stores the last name of the person.
     * @param personEmail the personEmail variable stores the contact email address of the person.
     * @param personNumber the personNumber variable stores the contact number of the person.
     */
    
    Person(String firstName, String lastName, String personEmail, long personNumber)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.personEmail = personEmail;
        this.personNumber = personNumber;
    }
    
    /**
     * the getPersonEmail method returns the value of the personEmail variable.
     * This idea of the get method also applies to other get methods found in this class aswell.
     * @return personEmail the personEmail variable which stores the contact email address of the person.
     */

    public String getPersonEmail() 
    {
        return personEmail;
    }
    
    /**
     * the setPersonEmail method updates the value of the String personEmail of a person object.
     * This idea of the set method also applies to other set methods found in this class aswell.
     * @param personEmail the personEmail variable which stores the contact email address of the person.
     */

    public void setPersonEmail(String personEmail) 
    {
        this.personEmail = personEmail;
    }

    public long getPersonNumber() 
    {
        return personNumber;
    }

    public void setPersonNumber(int personNumber) 
    {
        this.personNumber = personNumber;
    }
    
    public String getFirstName() 
    {
        return firstName;
    }

    public String getLastName() 
    {
        return lastName;
    }
    
    public void setPersonName(String lastName) 
    {
        this.lastName = lastName;
    }

    public int getPersonAge() 
    {
        return personAge;
    }
    
    public void setPersonAge(int personAge) 
    {
        this.personAge = personAge;
    }
    
    public abstract void personalizedMessage();
}