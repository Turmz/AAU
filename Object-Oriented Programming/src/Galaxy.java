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
    private HashMap<String, GameSystem> systems = new HashMap<>();

    public void addSystem(String key, GameSystem system){
        systems.put(key, system);
    }

    public HashMap<String, GameSystem> getSystems() {
        return systems;
    }

    public ArrayList<Unit> getShips(){
        ArrayList<Unit> ships = new ArrayList<>();
        for (GameSystem system: systems.values()) {
            ships.addAll(system.getShips());
        }
        return ships;
    }

    public HashMap<String, Planet> getPlanets(){
        HashMap<String, Planet> planets = new HashMap<>();
        for (GameSystem system: systems.values()) {
            planets.putAll(system.getPlanets());
        }
        return planets;
    }

}
