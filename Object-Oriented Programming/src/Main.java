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

import java.util.*;

class Main {
    public static void main(String[] args) {
        System.out.println("Problem 1: SOLVED");
        System.out.println("You can find this under 'Player.java'");
        System.out.println("");
        System.out.println("Problem 2: SOLVED");
        System.out.println("You can find this under 'Unit.java'");
        System.out.println("");
        System.out.println("Problem 3: SOLVED");
        System.out.println("You can find this under 'Destroyer.java', 'Cruiser.java', 'Carrier.java' and 'Dreadnought.java'");
        System.out.println("");
        System.out.println("Problem 4: SOLVED");
        System.out.println("You can find this under 'Planet.java'");
        System.out.println("");
        System.out.println("Problem 5: SOLVED");
        System.out.println("You can find this under 'GameSystem.java'");
        System.out.println("");
        System.out.println("Problem 6: SOLVED");
        System.out.println("You can find this under 'Galaxy.java'");
        System.out.println("");
        System.out.println("Problem 7: SOLVED");
        System.out.println("You can find this under 'Main.java // configuration()'");
        System.out.println("");
        System.out.println("Problem 8: SOLVED");
        System.out.println("You can find this under '../Test/MainTest.java'");
        System.out.println("");
        System.out.println("Problem 9: SOLVED");
        System.out.println("You can find this under pretty much all of them. I tried to make Exceptions as I went along.");
        System.out.println("");
        System.out.println("Problem 10: SOLVED");
        System.out.println("You can find this under 'Main.java // returnSortedUnit()' and under all the units.");
        System.out.println("");
        System.out.println("Problem 11: SOLVED");
        System.out.println("You can find this under 'printTextToFile.java'");
        System.out.println("");
        System.out.println("Problem 12: STARTED, BUT NOT SOLVED");
        System.out.println("You can find this under 'RandomGalaxyGen.java'");
        System.out.println("");
        System.out.println("Problem 13: NOT SOLVED");
        System.out.println("");
        System.out.println("Problem 14: SOLVED");
    }

    public static Galaxy configuration() throws Exception {
//  Problem 7.
//  Write a method which returns a Galaxy with the following conguration.
//  The Galaxy has two players: Crassus playing The Emirates of Hacan and Pompey playing
//  the Federation of Sol. Crassus is blue, Pompey is red. The Galaxy has the systems:
//  At the center is a system that contains the planet Mecatol Rex.
//  To the north is system that contains the planets Vega Minor and Vega Major.
//  To the north-east is an empty system.
//  To the south-east is a system that contains the planet Industrex.
//  To the south is a system that contains the planets Rigel I and Rigel II.
//  To the south-west is an empty system.
//  To the nort-west is a system that contains the planet Mirage.
//
//  The Galaxy contains the following ships:
//  In the Mecatol Rex system there are two Dreadnoughts and a Destroyer owned by
//  the blue player.
//  In the Vega Minor and Vega Major system there are two Cruisers and a Carrier
//  owned by the red player.
//
//  You decide on the unspecified properties of the Galaxy, e.g. planet resources.

        // Adds player to the galaxy, with their respected race and colour
        Player crassus = new Player("Crassus", "The Emirates of Hacan", "Blue");
        Player pompey = new Player("Pompey", "The Federation of Sol", "Red");

        // Creates a new galaxy
        Galaxy galaxy = new Galaxy();

        // Adds systems to the galaxy, and their respected planets
        galaxy.addSystem("Center", new GameSystem("Center", new Planet("Mecatol Rex", 6)));
        galaxy.addSystem("North", new GameSystem("North", new Planet("Vega Minor", 1), new Planet("Vega Major", 2)));
        galaxy.addSystem("North-East", new GameSystem("North-East"));
        galaxy.addSystem("South-East", new GameSystem("South-East", new Planet("Industrex", 3)));
        galaxy.addSystem("South", new GameSystem("South", new Planet("Rigel I", 1), new Planet("Rigel II", 2)));
        galaxy.addSystem("South-West", new GameSystem("South-West"));
        galaxy.addSystem("North-West", new GameSystem("North-West", new Planet("Mirage", 4)));

        // Goes through all the system and gets their values, for later assigning the units to a player
        for (GameSystem system : galaxy.getSystems().values()) {
            // Adds units to a system and assigns them to a player
            if (system.getName().equals("Center")) {
                system.addShip(new Dreadnought("Crassus"));
                system.addShip(new Dreadnought("Crassus"));
                system.addShip(new Destroyer("Crassus"));
            }
            // Adds units to a system and assigns them to a player
            if (system.getName().equals("North")) {
                system.addShip(new Cruiser("Pompey"));
                system.addShip(new Cruiser("Pompey"));
                system.addShip(new Carrier("Pompey"));
            }
        }
        // Returns the galaxy
        return galaxy;
    }

    public static ArrayList returnSortedUnit(String player) throws Exception {
//  Problem 10.
//  Write a method that returns all ships owned by a player in the Galaxy.
//  The ships must be returned in sorted order by combat value, e.g. a Dreadnought must
//  appear before a Carrier in the returned list. If two ships share the same combat value,
//  the more expensive one must appear first.

        ArrayList<Unit> allUnits = new ArrayList<>();
        // Foreach loop, that goes through all systems in the galaxy
        for (GameSystem gameSystem : configuration().getSystems().values()) {
            // Foreach loop, that goes through all systems in the galaxy
            for (Unit unit : gameSystem.getShips()) {
                // If-statement that adds a unit to a player.
                if (unit.getPlayer().equals(player))
                    allUnits.add(unit);
            }
        }
        // Sorts the units, with the help of the "public int compareTo(Unit unit) {"
        // methods under every unit.
        allUnits.sort(Comparable::compareTo);

        // Returns the sorted units.
        return allUnits;
    }
}

