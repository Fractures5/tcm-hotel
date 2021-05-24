/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelModel;

import java.util.ArrayList;
import project2hotelapp.GuestsBookingCart;

/**
 *
 * @author Siddarath
 */
public class HotelBookingDates 
{
    private int checkInDay;
    private String checkInMonth;
    private int checkInYear;
    private int checkOutDay;
    private String checkOutMonth;
    private int checkOutYear;
    
    private ArrayList<GuestsBookingCart> bookedDates = null;
    
    public HotelBookingDates()
    {
        
    }

    public void setDatesBooked(ArrayList<GuestsBookingCart> bookedDates)
    {
        this.bookedDates = bookedDates;
    }
    
    public ArrayList<GuestsBookingCart> getDatesBooked()
    {
        return bookedDates;
    }
    
    /*public int getCheckInDay() 
    {
        return checkInDay;
    }

    public void setCheckInDay(int checkInDay) 
    {
        this.checkInDay = checkInDay;
    }

    public String getCheckInMonth() 
    {
        return checkInMonth;
    }

    public void setCheckInMonth(String checkInMonth) 
    {
        this.checkInMonth = checkInMonth;
    }

    public int getCheckInYear() 
    {
        return checkInYear;
    }

    public void setCheckInYear(int checkInYear) 
    {
        this.checkInYear = checkInYear;
    }

    public int getCheckOutDay() 
    {
        return checkOutDay;
    }

    public void setCheckOutDay(int checkOutDay) 
    {
        this.checkOutDay = checkOutDay;
    }

    public String getCheckOutMonth() 
    {
        return checkOutMonth;
    }

    public void setCheckOutMonth(String checkOutMonth) 
    {
        this.checkOutMonth = checkOutMonth;
    }

    public int getCheckOutYear() 
    {
        return checkOutYear;
    }

    public void setCheckOutYear(int checkOutYear) 
    {
        this.checkOutYear = checkOutYear;
    }*/
    
    
    
}
