package com.kenzie.library;

import java.util.Random;
import java.util.Arrays;
import java.lang.Class;

public class RandomEvent{ //will happen every 5 days during journey. will be rated from 1 - 7, 1 being most rare
    private int roll;

    private Wagon wagon = new Wagon(Main.WAGON_SIZE);

    public RandomEvent(Wagon wagon){

        this.wagon = wagon;

        Random roll = new Random();
        this.roll = roll.nextInt(13);

        if (this.roll <= 6) {
            BARD();
        } else if (this.roll > 6 && this.roll < 9) {
            HIGHWAYMAN();
        } else if (this.roll > 9 && this.roll < 13) {
            BROKEN_WAGON();
        }
    }

    public void BARD(){

        Random bardRoll = new Random();
        int activateBard = bardRoll.nextInt(7);

        Traveler[] travelers = this.wagon.getPassengers();

        String bardIntro = "The bard looks happy to see you. He regales you with a tale. He strums his guitar and begins.";
        String travelerBoredOutro = "The travelers look at each other, then sneak away.";
        String travelerInterestedOutro = "The travelers gather around the campfire, amused by the story.";

        String storyOne = "\"Tonight I have the most interesting tale to share...of the mighty hunter Jane! As " +
                "the story was told, she was a world class hunter, a sharpshooter, a hunting fiend! One day she " +
                "shot at a great grizzly bear and down it went!" + "\n" + "She stomped into the woods, the ground quaking " +
                "as she stepped and grabbed the bear by its feet to drag it home. But huzzah! the bear never " +
                "died! It faked it's death. It roared as loud as it could and swung one mighty paw at her. It " +
                "missed!" + "\n" + "She ducked and swung one mighty fist! That missed too! The fight went on for years " +
                "as some say. No one really knows what came of Jane and the bear." + "\n" + "Some say they both died in " +
                "those woods. Others say they became great friends and live in the woods together to this day.\"";
        String storyTwo = "\"There are rumors going about that dragons are back. An old woman just past" +
                " Santa Fe said that she's seen the old dragons flying about in the sky! No one believed" + "\n" +
                " her but her eldest son rode as fast as he could to her home to see for himself." +
                " Turns out, it was just dragonflies. I guess she wasn't wrong.\"";
        String storyThree = "\"Some say that the old fortune teller in Oregon saw the future! I'll tell" +
                " ya what they said. \"In the distant future, the road to and from Oregon will be smooth as" +
                " honey and will have loud, metal wagons that move without horses!\" Can you imagine that?\"";

        String nonStoryOptionOne = "The bard came running down the hill, tripped, and broke his guitar. He cried.";
        String nonStoryOptionTwo = "The bard is in a mood today, he doesn't want to tell a story.";
        String nonStoryOptionThree = "The bard doesn't want to tell a story today. Instead, he strums a nice song on " +
                "his guitar.";

        String defaultStatement = "The bard is sleeping. A traveler shakes him, but he continues snoring.";

        switch (activateBard) { //Intellij helped me out with formatting here.
            case 1 -> {
                System.out.println(bardIntro);
                System.out.println(storyOne);
                System.out.println(travelerInterestedOutro);
                //good stories bolsters health. Health fully restored.
                for(Traveler traveler : travelers){
                    traveler.setIsHealthy(true);
                }
            }
            case 2 -> {
                System.out.println(bardIntro);
                System.out.println(storyTwo);
                System.out.println(travelerBoredOutro);
            }
            case 3 -> {
                System.out.println(bardIntro);
                System.out.println(storyThree);
                System.out.println(travelerInterestedOutro);
                for(Traveler traveler : travelers) {
                    traveler.setIsHealthy(true);
                }
            }
            case 4 -> {
                System.out.println(nonStoryOptionOne);
            }
            case 5 -> {
                System.out.println(nonStoryOptionTwo);
            }
            case 6 -> {
                System.out.println(nonStoryOptionThree);
                //Travelers enjoy music. Health restored.
                for(Traveler traveler : travelers){
                    traveler.setIsHealthy(true);
                }
            }
            default -> {
                System.out.println(defaultStatement);
            }
        }
    }

    public int HIGHWAYMAN(){

        Random highwaymanRoll = new Random();
        int foodRoll = highwaymanRoll.nextInt(10);

        this.wagon.getPassengers();


        int totalFood = this.wagon.totalFood();

        System.out.println("A highwayman appears! He demands " + foodRoll + " food!");

        if(foodRoll < this.wagon.totalFood()) {
            totalFood = this.wagon.totalFood() - foodRoll;
        }

        return totalFood;
    }

    public int BROKEN_WAGON(){

        Random brokenWagon = new Random();
        int loot = brokenWagon.nextInt(20) + 1;

        System.out.println("The travelers come by a broken wagon with a large hole in the side. They investigate and " +
                "find " + loot + " food.");

        return this.wagon.totalFood() + loot;
    }
}
