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
//Systems.
//        A system is a hexagonal region of space that contains planets and ships. A
//        system has up to six neighboring systems. A system may have less than six neighbors if
//        it is on the outer rim. We can identify the neighbors by their position: We have a system
//        to the north, to the north-east, to the south-east, to the south, to the south-west, and
//        nally to the north-west. A system has between zero and three planets. The planets in a
//        system never change. Ships, on the other hand, may enter and leave a system. Figure 1
//        shows an example of a Galaxy with systems and planets (ships not shown).
//
//        Problem 5. Write a class to represent a system. Add an appropriate constructor and
//        methods for ships to enter and leave the system. Add a method to retrieve all the ships
//        currently in the system.

import java.util.ArrayList;

public class GameSystem {
    private ArrayList<Planet> planets = new ArrayList<>();
    private ArrayList<Unit> ships;
    private ArrayList<String> neighbours;
    private String hexName;

    public String getName(){
        return hexName;
    }

    public GameSystem(String hexName, Planet... inputPlanet) throws Exception {
        if (inputPlanet.length > 3){
            throw new Exception("Illegal amount of planets!");
        }

        for (Planet planet : inputPlanet) {
            planets.add(planet);
        }

        this.ships = new ArrayList<>();
        this.hexName = hexName;
        this.neighbours = getNeighbours();
    }

    private ArrayList<String> getNeighbours() throws Exception {
        ArrayList<String> neighbours = new ArrayList<>();

        switch (this.hexName){
            case "North" :
                neighbours.add("North-East");
                neighbours.add("North-West");
                neighbours.add("Center");
                break;

            case "North-East" :
                neighbours.add("North");
                neighbours.add("South-East");
                neighbours.add("Center");
                break;

            case "South-East" :
                neighbours.add("North-East");
                neighbours.add("South");
                neighbours.add("Center");
                break;

            case "South" :
                neighbours.add("South-East");
                neighbours.add("South-West");
                neighbours.add("Center");
                break;

            case "South-West" :
                neighbours.add("North-West");
                neighbours.add("South");
                neighbours.add("Center");
                break;

            case "North-West" :
                neighbours.add("South-West");
                neighbours.add("North");
                neighbours.add("Center");
                break;

            case "Center" :
                neighbours.add("North");
                neighbours.add("North-East");
                neighbours.add("South-East");
                neighbours.add("South");
                neighbours.add("South-West");
                neighbours.add("North-West");
                break;

            default: throw new Exception("Illegal system.");
        }
        return neighbours;
    }

    public void addShip(Unit ship){
        ships.add(ship);
    }

    public void removeShip(String type, String player){
        for (Unit ship : ships) {
            if(ship.getType().equals(type) && ship.getPlayer().equals(player)){
                ships.remove(ship);
                break;
            }
        }
    }

    public ArrayList<Unit> getShips() {
        return ships;
    }

    public ArrayList<Planet> getPlanets() {
        return planets;
    }
}
