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

//  Planetary Control.
//  A planet is said to be under the control of a player if he or she has
//  a ship in the system that contains the planet, and moreover no other player has a ship in
//  the same system.
//
//  Problem 11.
//  Write a method that creates a text file containing a list of players and
//  the planets they control. For example, the output could be:
//
//  Blue Player (Emirates of Hacan)
//  Mecatol Rex
//
//  Red Player (Federation of Sol)
//  Vega Minor
//  Vega Major

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class printTextToFile {
    public static void printTextfile() throws Exception {
        // Creates a writer, to start writing to a file
        BufferedWriter writer = null;

        // Creates an empty string, for use later
        String name = "";

        // Creates a directory, for players.
        HashMap<String, ArrayList<GameSystem>> players = new HashMap<>();

        // A foreach loop, that goes through all the systems in the galaxy created in Problem 7.
        for (GameSystem gameSystem : Main.configuration().getSystems().values()) {
            // The empty string from before.
            name = "";
            // A foreach loop, that goes through all the systems in the galaxy created in Problem 7.
            for (Unit unit : gameSystem.getShips()) {
                // If-statement that asks, if the string is empty, then give it the player of a unit.
                if (name.equals("")) {
                    // Adds a player to the empty string.
                    name = unit.getPlayer();
                    // If-statement that asks, if the player is the same as before, and if not,
                    // it should break, after setting the name to empty.
                } else if (!name.equals(unit.getPlayer())) {
                    // Empties name.
                    name = "";
                    break;
                }
            }
            // If-statement that asks, if the name is not empty.
            if (!name.equals("")) {
                // If-statement that asks, if the players name is not null,
                // then put the name into the new ArrayList, named "players".
                // Then it gets the name, and adds it to the loop.
                // If not, it just adds "" to the loop.
                if (players.get(name) == null) {
                    players.put(name, new ArrayList<>());
                    players.get(name).add(gameSystem);
                } else {
                    players.get(name).add(gameSystem);
                }
            }
        }

        try {
            // Creates a file, and gives it the name "TwilightImperium" and the filetype ".txt"
            File file = new File("TwilightImperium.txt");

            // Defines, that the writer should write on the newly created file.
            writer = new BufferedWriter(new FileWriter(file));

            // Forloop, that goes through the systems, and looks for players.
            // It also writes the file.
            for (Map.Entry<String, ArrayList<GameSystem>> entry : players.entrySet()) {
                writer.write("Player: ");
                writer.newLine();
                // Gets the player.
                writer.write(entry.getKey().toString());
                writer.newLine();
                writer.newLine();
                writer.write("Planets: ");
                writer.newLine();
                // Gets the players planets.
                for (GameSystem gameSystem : entry.getValue()) {
                    for (Planet planet : gameSystem.getPlanets().values()) {
                        writer.write(planet.getName());
                        writer.newLine();
                    }
                }
                writer.write("------------");
                writer.newLine();
            }

            // Cathces any errors, and displays an error message/exception.
        } catch (Exception e) {
            e.printStackTrace();

            // Closes the writer, and outputs the file.
        } finally {
            System.out.println("--- A textfile with all the players and their planets have been outputted. ---");
            writer.close();
        }
    }
}
