/*
 *
 * -------------------------------------------------------
 * Name:             Tummas Jóhan Sigvardsen
 * Email:            tsigva16@student.aau.dk
 * Student number:   20164825
 * Course:           Objektorienteret Programmering (OOP) (DAT2, SW2, IxD4, MAT-tilvalg) - AAL - F18
 * Education:        Interaktionsdesign
 * Semester:         4. semester
 * -------------------------------------------------------
 *
 */

//ASSIGNMENT
//Planets
//        A planet has a name and a resource production. Examples of planets are:
//        Velnor, Mirage, Perimeter, Vega Minor, Vega Major, Hope's End, Rigel II, and Industrex.
//        A planet can produce between zero and six resources.
//
//        Problem 4. Write a class to represent a planet.

import java.lang.*;
import java.util.Random;

public class Planets {
    private String name;
    private int resource;

    public Planets(String name, int resource) {
        this.name = name;
        this.resource = resource;
        int randomResource = 0;

        // Checks if any of the planets have more than six and less than 0.
        // If not, it will randomly generate the information.
        if(resource >= 7 || < 0){
            new Random();
            randomResource = Random.nextInt(6);
        } else {
            System.out.println("This is not possible. A planet can only produce between zero and six resources.");
        }

        // Constructs the planets and prints the information it has created.
        Planets =  new Planets("Velnor", randomResource);
            System.out.println(name + " has been created, and has gotten the resource value of" + resource + ".");

        Planets =  new Planets("Mirage", randomResource);
            System.out.println(name + " has been created, and has gotten the resource value of" + resource + ".");

        Planets =  new Planets("Perimeter", randomResource);
            System.out.println(name + " has been created, and has gotten the resource value of" + resource + ".");

        Planets =  new Planets("Vega Minor", randomResource);
            System.out.println(name + " has been created, and has gotten the resource value of" + resource + ".");

        Planets =  new Planets("Vega Major", randomResource);
            System.out.println(name + " has been created, and has gotten the resource value of" + resource + ".");

        Planets =  new Planets("Hope's End", randomResource);
            System.out.println(name + " has been created, and has gotten the resource value of" + resource + ".");

        Planets =  new Planets("Rigel II", randomResource);
            System.out.println(name + " has been created, and has gotten the resource value of" + resource + ".");

        Planets =  new Planets("Industrex", randomResource);
            System.out.println(name + " has been created, and has gotten the resource value of" + resource + ".");
    }
}

