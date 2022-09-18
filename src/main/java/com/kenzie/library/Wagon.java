package com.kenzie.library;

import java.sql.Array;
import java.util.Arrays;

public class Wagon {
    private int capacity;
    private Traveler[] passengers;

    public Wagon(int capacity) {

        this.capacity = capacity;
        this.passengers = new Traveler[this.capacity];
    }

    public void setCapacity(int capacity) {

        this.capacity = capacity;
    }

    public void setPassengers(Traveler[] travelers) {

        this.passengers = travelers;
    }

    public int getCapacity() {

        return this.capacity;
    }

    public Traveler[] getPassengers() {

        return this.passengers;
    }

    public int getAvailableSeatCount() {

        int unoccupied = 0;

        for(Traveler passenger : this.passengers) {
            if (passenger == null) {
                unoccupied++;
            }
        }
        return unoccupied;
    }

    public void join(Traveler traveler) {

        for(int index = 0; index < this.passengers.length; index++){
            if(this.passengers[index] == null){
                this.passengers[index] = traveler;
                break;
            }
        }
    }

    public boolean shouldQuarantine() {

        int isNotHealthy = 0;

        for(Traveler passenger : this.passengers) {
            if (passenger != null && !passenger.getIsHealthy()) {
                isNotHealthy++;
            } else if (passenger == null) {
                break;
            }
        }

        return isNotHealthy > 0;
    }

    public int totalFood(){

        int totalFood = 0;

        for(Traveler passenger : this.passengers) {
            if(passenger != null){
            totalFood += passenger.getFood();
            } else if (passenger == null) {
                break;
            }
        }

        return totalFood;
    }

    public void loadWagon(int numTravelers, int numHunters, int numDoctors){

        while(numTravelers > 0 && getAvailableSeatCount() > 0){
            Traveler traveler = new Traveler();
            this.join(traveler);
            numTravelers --;
        }

        while(numHunters > 0 && getAvailableSeatCount() > 0) {
            Hunter hunter = new Hunter();
            this.join(hunter);
            numHunters--;
        }

        while(numDoctors > 0 && getAvailableSeatCount() > 0){
            Doctor doctor = new Doctor();
            this.join(doctor);
            numDoctors --;
        }
    }

}
