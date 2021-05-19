/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project2hotelapp;

/**
 * This enumerated type class named RoomAvailableType maintains the
 * six different types of rooms quantity each hotel has along. This is used in the 
 * rooms available menu when the guest selects to choose the rooms they would like to book.
 * This enumerated type also contains the private instance variable count which represents the rooms 
 * available and the get and set methods to access/modify the rooms available.
 * @author Siddarath
 */
public enum RoomAvailableType {
    
    STANDARD_QUANTITY(10),DELUXE_QUANTITY(10),TWIN_QUANTITY(10),QUEEN_QUANTITY(10),FAMILY_QUANTITY(10),COUPLES_QUANTITY(0); 
    
    private int count;
    
    /**
     * This is a constructor for the RoomAvailableType enumeration and it contains the
     * input for all instance variables to initialize the RoomAvailableType objects.
     * @param count the integer variable represents the number of rooms available to each room available type.
     * @author Siddarath
     */
    private RoomAvailableType(int count)
    {
        this.count = count;
    }

    /**
     * This get method returns the instance variable count.
     * This is used to retrieve the number of rooms available for each room type.
     * @return count the integer variable.
     * @author Siddarath
     */
    public int getCount() 
    {
        return count;
    }

    /**
     * This set method will update the instance variable count.
     * @param count the integer parameter which is received from the guest menu class.
     * @author Siddarath
     */
    public void setCount(int count) 
    {
        this.count = count;
    }
}
