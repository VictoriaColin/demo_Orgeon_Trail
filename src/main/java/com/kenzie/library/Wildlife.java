package com.kenzie.library;

import java.util.Random;

public class Wildlife {
    private int roll;
    public enum WildlifeOfTheDay {
        RAT(1),
        RABBIT(2),
        DEER(4),
        ELK(5),
        BISON(8),
        BEAR(12);

        private int foodQuantity;

        private WildlifeOfTheDay(int foodQuantity) {
            this.foodQuantity = foodQuantity;
        }

        public int getFoodQuantity() {
            return this.foodQuantity;
        }
    }


    public int getDayRoll() {

        Random roll = new Random();
        this.roll = roll.nextInt(7);

        return this.roll;
    }

    public Wildlife() {

        getDayRoll();

        switch (roll) {
            case 1: {
                System.out.println("There's only one rat for today's hunt.");
                Main.huntOfTheDay = WildlifeOfTheDay.RAT.getFoodQuantity();
            }
            case 2: {
                System.out.println("Caught a rabbit today.");
                Main.huntOfTheDay = WildlifeOfTheDay.RABBIT.getFoodQuantity();
            }
            case 3: {
                System.out.println("Hunted a deer for dinner.");
                Main.huntOfTheDay = WildlifeOfTheDay.DEER.getFoodQuantity();
            }
            case 4: {
                System.out.println("Got an elk today.");
                Main.huntOfTheDay = WildlifeOfTheDay.ELK.getFoodQuantity();
            }
            case 5: {
                System.out.println("Needed help getting the bison. We'll eat well tonight.");
                Main.huntOfTheDay = WildlifeOfTheDay.BISON.getFoodQuantity();
            }
            case 6: {
                System.out.println("Can't believe we got a bear today. We'll have full tummies 'til the next moon.");
                Main.huntOfTheDay = WildlifeOfTheDay.BEAR.getFoodQuantity();
            }
        }
    }
}


