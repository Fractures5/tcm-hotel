/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project2hotelapp;

/**
 * This enumerated type named VacancyType maintains the
 * two different vacancy type status each different hotel can
 * have. This is displayed in the guest menu when they are shown the
 * hotels location menu. If the rooms vacancy type for that hotel locations
 * is yes then the guest is able to access rooms to see otherwise if the vacancy 
 * type is no, then the user will be prompted to choose another hotel to stay at.
 * @author Siddarath
 */
public enum VacancyType {
    
    YES, NO;
}
