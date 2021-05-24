/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project2hotelapp;

/**
 * The purpose of this abstract class is to maintain the protected instance variables for hotel products
 * and these variables are the product title, price, location type, room type, guest type,
 * vacancy type, extra features type, rating type, room availability type and the check in and out
 * dates. These variables are used in the menu output and the guest booking cart process.
 * This is a super class/parent class so the sub classes FeaturesMenu, GuestsTypeMenu,
 * LocationMenu, GuestsBookingCart and RoomMenu will inherit certain characteristics from it.
 * This class also has get and set methods for each variable so its accessible from outside this
 * class. This class also contains the abstract method for displaying a special banner message for each inherited class.
 * @author Siddarath
 */
public abstract class Products {
    
    protected String title;
    protected Double price;
    protected LocationType locationType;
    protected RoomType roomType;
    protected GuestType guestType;
    protected VacancyType vacancyType;
    protected ExtraFeatureTypes featureType;
    protected RatingType ratingType;
    protected RoomAvailableType availabilityType;
    protected int checkInDay, checkInYear;
    protected int checkOutDay, checkOutYear;
    protected String checkInMonth, checkOutMonth;
    
    /**
     * This is a default constructor.
     * It has no parameters and returns nothing.
     * @author Siddarath
     */
    public Products() 
    {
    }

    /**
     * This is a constructor for the Products class which contains input for specific variables 
     * that will only be used for the location menu class to initialize the Product objects.
     * @param title the parameter represents the title of selection, in this case it would be the hotel location name.
     * @param locationType the parameter represents the location type of the hotel.
     * @param ratingType the parameter represents the rating type of the hotel.
     * @param vacancyType the parameter represents the vacancy type status of the hotel.
     * @author Siddarath
     */
    public Products(String title, LocationType locationType, RatingType ratingType, VacancyType vacancyType)
    {
        this.title = title;
        this.locationType = locationType;
        this.ratingType = ratingType;
        this.vacancyType = vacancyType;
    }
    
    /**
     * This is a constructor for the Products class which contains input for specific variables 
     * that will only be used for the rooms available menu class to initialize the Product objects.
     * @param title the parameter represents the title of selection, in this case it would be the title of the room selected.
     * @param roomType the parameter represents the enumerated type RoomType which holds the different types of rooms the guests can book.
     * @param price the parameter in this constructor represents the price of the type of rooms selected by the guest.
     * @param availabilityType the parameter represents the enumerated type AvailabilityType which holds the number of rooms available to the specific room type.
     * @author Siddarath
     */
    public Products(String title, RoomType roomType, Double price)
    {
        this.title = title;
        this.roomType = roomType;
        this.price = price;
    }
    
    /**
     * This is a constructor for the Products class which contains input for specific variables 
     * that will only be used for the guest type menu class to initialize the Product objects.
     * @param title the parameter represents the title of selection, in this case it would be the title of the chosen guest type.
     * @param guestType the parameter represents the enumerated type GuestType which holds the different types of guests that be can booked.
     * @param price the parameter in this constructor represents the price of the type of guest selected to be booked.
     * @author Siddarath
     */
    public Products(String title, GuestType guestType, Double price)
    {
        this.title = title;
        this.guestType = guestType;
        this.price = price;
    }
    
    /**
     * This is a constructor for the Products class which contains input for specific variables 
     * that will only be used for the extra features menu class to initialize the Product objects.
     * @param title the parameter represents the title of selection, in this case it would be the title of the extra feature selected.
     * @param featureType the parameter represents the enumerated type FeatureType which holds the different types of extra hotel features.
     * @param price the parameter in this constructor represents the price of the selected extra feature pass.
     * @author Siddarath
     */
    public Products(String title,  ExtraFeatureTypes featureType, Double price)
    {
        this.title = title;
        this.featureType = featureType;
        this.price = price;
    }
    
    /**
     * This is a constructor for the Products class which contains input for specific variables 
     * that will only be used for the check in and out in the guest booking cart to initialize the Product objects.
     * @param checkInDay the parameter represents the check in day of the guest.
     * @param checkInMonth the parameter represents the check out month of the guest.
     * @param checkInYear the parameter represents the check out year of the guest.
     * @param checkOutDay the parameter represents the check out day of the guest.
     * @param checkOutMonth the parameter represents the check out month of the guest.
     * @param checkOutYear the parameter represents the check out year of the guest.
     * @author Siddarath
     */
    public Products(int checkInDay, String checkInMonth, int checkInYear, int checkOutDay, String checkOutMonth, int checkOutYear)
    {
        this.checkInDay = checkInDay;
        this.checkInMonth = checkInMonth;
        this.checkInYear = checkInYear;
        this.checkOutDay = checkOutDay;
        this.checkOutMonth = checkOutMonth;
        this.checkOutYear= checkOutYear;
    }
    
    /**
     * This getTitle method will return the instance variable title.
     * The same concept applies to all the other get methods below.
     * @return title the instance variable.
     * @author Siddarath
     */
    public String getTitle() 
    {
        return title;
    }

    /**
     * This setTitle method update the value of the instance variable title.
     * The same concept applies to all the other set methods below.
     * @param title the parameter represents the particular selections title name.
     * @author Siddarath
     */
    public void setTitle(String title) 
    {
        this.title = title;
    }

    public Double getPrice() 
    {
        return price;
    }

    public void setPrice(Double price) 
    {
        this.price = price;
    }

    public LocationType getLocationType() 
    {
        return locationType;
    }

    public void setLocationType(LocationType locationType) 
    {
        this.locationType = locationType;
    }

    public RoomType getRoomType() 
    {
        return roomType;
    }

    public void setRoomType(RoomType roomType) 
    {
        this.roomType = roomType;
    }

    public GuestType getGuestType() 
    {
        return guestType;
    }

    public void setGuestType(GuestType guestType) 
    {
        this.guestType = guestType;
    }

    public VacancyType getVacancyType() 
    {
        return vacancyType;
    }

    public void setVacancyType(VacancyType vacancyType) 
    {
        this.vacancyType = vacancyType;
    }
    
    public ExtraFeatureTypes getFeatureType() 
    {
        return featureType;
    }

    public void setFeatureType(ExtraFeatureTypes featureType) 
    {
        this.featureType = featureType;
    }

    public RatingType getRatingType() 
    {
        return ratingType;
    }

    public void setRatingType(RatingType ratingType) 
    {
        this.ratingType = ratingType;
    }

    public RoomAvailableType getAvailabilityType() 
    {
        return availabilityType;
    }

    public void setAvailabilityType(RoomAvailableType availabilityType) 
    {
        this.availabilityType = availabilityType;
    }

    public int getCheckInDay() 
    {
        return checkInDay;
    }

    public void setCheckInDay(int checkInDate) 
    {
        this.checkInDay = checkInDate;
    }

    public String getCheckInMonth() 
    {
        return checkInMonth;
    }

    public void setCheckInMonth(String checkInMonth) 
    {
        this.checkInMonth = checkInMonth;
    }

    public int getCheckInYear() {
        return checkInYear;
    }

    public void setCheckInYear(int checkInYear) {
        this.checkInYear = checkInYear;
    }

    public int getCheckOutDay() 
    {
        return checkOutDay;
    }

    public void setCheckOutDate(int checkOutDate) 
    {
        this.checkOutDay = checkOutDate;
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
    }
    
    /**
     * The menuBanner method below is an abstract method which will be
     * overridden by the sub classes (menu classes) with a special banner graphics.
     * @author Siddarath
     */
    public abstract void menuBanner();
}
