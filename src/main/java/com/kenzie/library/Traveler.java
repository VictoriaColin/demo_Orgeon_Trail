package com.kenzie.library;

public class Traveler {
    protected String name;
    protected int food;
    protected boolean isHealthy;

    public Traveler(){

        this.name = "";
        this.food = 1;
        this.isHealthy = true;
    }

    public Traveler(String name){

        this.name = name;
        this.food = 1;
        this.isHealthy = true;
    }

    public void setName (String name){

        this.name = name;
    }

    public void setFood(int numOfFood){

        this.food = numOfFood;
    }

    public void setIsHealthy(boolean isHealthy){

        this.isHealthy = isHealthy;
    }

    public String getName(){

        return this.name;
    }

    public int getFood(){

        return this.food;
    }

    public boolean getIsHealthy(){

        return this.isHealthy;
    }

    public void hunt(){

        this.food += 2;
    }

    public void eat(){

        if(food >= 1){
            this.food -= 1;
        } else {
            this.isHealthy = false;
        }
    }
}

class Doctor extends Traveler{
    public Doctor(){

        super();
    }

    public Doctor(String name){

        super(name);
    }

    public boolean heal(Traveler traveler){

        traveler.setIsHealthy(true);

        return traveler.getIsHealthy();
    }
}

class Hunter extends Traveler {

    public Hunter(){

        super();
        this.food = 2;
    }

    public Hunter(String name){

        super(name);
        this.food = 2;
    }

    public void hunt(){

        this.food += 5;
    }

    public void eat(){

        if(this.food >= 2){
            this.food -= 2;
        } else if (this.food == 1) {
            this.food -= 1;
            this.isHealthy = false;
        } else {
            this.isHealthy = false;
        }
    }

    public void giveFood(Traveler traveler, int numOfFoodUnits){

        if(Hunter.this.food >= numOfFoodUnits){
            traveler.food += numOfFoodUnits;
            Hunter.this.food -= numOfFoodUnits;
        }

    }



  
  
}

