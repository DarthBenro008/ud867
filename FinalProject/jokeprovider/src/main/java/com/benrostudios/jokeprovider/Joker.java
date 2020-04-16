package com.benrostudios.jokeprovider;

import java.util.Random;

public class Joker {

    private String[] jokeList = new String[]{
            "Q : Why did the picture go to jail? \n\nA : Because it was framed",
            "Q : Why did the banker quit his job? \n\nA : He lost interest!",
            "Q : Which horse runs the city? \n\nA : The mare, of course",
            "Q : What do you get if you divide the circumference of a pumpkin by its diameter? \n\nA : Pumpkin pi",
            "Q : What kind of music do bunnies like best? \n\nA : Hip Hop",
            "Q : Why did the astronaut feel claustrophobic? \n\nA : She needed some space",
            "Q : What did the tree say to the lumberjack? \n\nA : I'm falling for you",
            "Q : How did the vacuum cleaner die? \n\nA : It bit the dust.",
            "Q : Did you hear about the quarry that went out of business? \n\nA : They hit rock bottom",
            "Q : Did you hear about the two antennas that got married? \n\nA : The ceremony was okay, but the reception was great!"
    };

    public String getRandomJoke(){
        Random random = new Random();
        return jokeList[random.nextInt(jokeList.length)];
    }
}
