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

public class Planet {
    // Values for the planet
    private String name;
    private int resources;

    // Constructor of the planet
    public Planet(String name, int resources) throws Exception {
        this.name = name;
        // Checks if a planet, has more than 6 or less than 0 resources.
        if (resources > 6 || resources < 0) {
            throw new Exception("Illegal amount of resources!");
        } else {
            this.resources = resources;
        }
    }

    // Getter for a planets resources
    public int getResource() {
        return resources;
    }

    // Getter for a planets name
    public String getName() {
        return name;
    }
}

