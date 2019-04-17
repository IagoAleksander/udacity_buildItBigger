package com.iaz.javajoker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Joker {

    private final ArrayList <String> jokesList = new ArrayList<>(
            Arrays.asList("A programmer is told to go to hell, he finds the worst part of that statement is the GO TO",
                    "How many programmers does it take to screw in a light bulb? None. It's a hardware problem.",
                    "A programmer puts two glasses on his bedside table before going to sleep. A full one, in case he gets thirsty, and an empty one, in case he doesn’t.",
                    "A SQL statement walks into a bar and sees two tables. It approaches, and asks “may I join you?"));

    public String tellAJoke() {

        Random r = new Random();
        return jokesList.get(r.nextInt(jokesList.size()));
    }
}
