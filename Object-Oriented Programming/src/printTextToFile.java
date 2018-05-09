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

        BufferedWriter writer = null;
        String name = "";

        HashMap<String, ArrayList<GameSystem>> players = new HashMap<>();
        for (GameSystem gameSystem : Main.configuration().getSystems().values()) {
            name = "";
            for (Unit unit : gameSystem.getShips()) {
                if (name.equals("")) {
                    name = unit.getPlayer();
                } else if (!name.equals(unit.getPlayer())) {
                    name = "";
                    break;
                }
            }
            if (!name.equals("")) {
                if (players.get(name) == null) {
                    players.put(name, new ArrayList<>());
                    players.get(name).add(gameSystem);
                } else {
                    players.get(name).add(gameSystem);
                }
            }
        }

        try {
            File file = new File("TwilightImperium.txt");

            writer = new BufferedWriter(new FileWriter(file));

            for (Map.Entry<String, ArrayList<GameSystem>> entry : players.entrySet()) {
                writer.write("Player: ");
                writer.newLine();
                writer.write(entry.getKey().toString());
                writer.newLine();
                writer.newLine();
                writer.write("Planets: ");
                writer.newLine();
                for (GameSystem gameSystem : entry.getValue()) {
                    for (Planet planet : gameSystem.getPlanets().values()) {
                        writer.write(planet.getName());
                        writer.newLine();
                    }
                }
                writer.write("------------");
                writer.newLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("--- A textfile with all the players and their planets have been outputted. ---");
            writer.close();
        }
    }
}
