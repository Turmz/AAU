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
//Galaxy.
//        A collection of systems, a grid of hexagons, make up the Galaxy.
//
//        Problem 6. Write a class to represent the Galaxy. Add methods to and all (a) systems,
//        (b) ships, and (c) planets in the Galaxy.

import java.util.ArrayList;
import java.util.HashMap;

public class Galaxy {
    // Values for the planets
    private HashMap<String, GameSystem> systems = new HashMap<>();

    // Method for adding a system to a galaxy
    public void addSystem(String key, GameSystem system){
        systems.put(key, system);
    }

    // Getter for retrieveing systems in a galaxy
    public HashMap<String, GameSystem> getSystems() {
        return systems;
    }

    // Getter for retrieveing units in a system
    public ArrayList<Unit> getShips(){
        ArrayList<Unit> ships = new ArrayList<>();

        // Foreach loop, for going through all systems in a galaxy
        // and adding all the units into an ArrayList
        for (GameSystem system: systems.values()) {
            ships.addAll(system.getShips());
        }
        return ships;
    }

    // Getter for retrieveing all planets in a system, in a galaxy
    public HashMap<String, Planet> getPlanets(){
        HashMap<String, Planet> planets = new HashMap<>();

        // Foreach loop, for going through all systems in a galaxy
        // and adding all the planets into an ArrayList
        for (GameSystem system: systems.values()) {
            planets.putAll(system.getPlanets());
        }
        return planets;
    }
}
