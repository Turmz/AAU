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

public class Galaxy {
    private ArrayList<GameSystem> systems = new ArrayList<>();

    public void addSystem(GameSystem system){
        systems.add(system);
    }

    public ArrayList<GameSystem> getSystems() {
        return systems;
    }

    public ArrayList<Unit> getShips(){
        ArrayList<Unit> ships = new ArrayList<>();
        for (GameSystem system: systems) {
            ships.addAll(system.getShips());
        }
        return ships;
    }

    public ArrayList<Planet> getPlanets(){
        ArrayList<Planet> planets = new ArrayList<>();
        for (GameSystem system: systems) {
            planets.addAll(system.getPlanets());
        }
        return planets;
    }

}
