import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Array;
import java.nio.Buffer;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        configuration();
        printTextfile();
    }

    public static Galaxy configuration() throws Exception {
        Player crassus = new Player("Crassus", "The Emirates of Hacan", "Blue");
        Player pompey = new Player("Pompey", "The Federation of Sol", "Red");

        Galaxy galaxy = new Galaxy();

        galaxy.addSystem("Center", new GameSystem("Center", new Planet("Mecatol Rex", 6)));
        galaxy.addSystem("North", new GameSystem("North", new Planet("Vega Minor", 1), new Planet("Vega Major", 2)));
        galaxy.addSystem("North-East", new GameSystem("North-East"));
        galaxy.addSystem("South-East", new GameSystem("South-East", new Planet("Industrex", 3)));
        galaxy.addSystem("South", new GameSystem("South", new Planet("Rigel I", 1), new Planet("Rigel II", 2)));
        galaxy.addSystem("South-West", new GameSystem("South-West"));
        galaxy.addSystem("North-West", new GameSystem("North-West", new Planet("Mirage", 4)));

        for (GameSystem system : galaxy.getSystems().values()) {
            if (system.getName().equals("Center")) {
                system.addShip(new Dreadnought("Crassus"));
                system.addShip(new Dreadnought("Crassus"));
                system.addShip(new Destroyer("Crassus"));
            }

            if (system.getName().equals("North")) {
                system.addShip(new Cruiser("Pompey"));
                system.addShip(new Cruiser("Pompey"));
                system.addShip(new Carrier("Pompey"));
            }
        }
        return galaxy;
    }

    public static ArrayList returnSortedUnit(String player) throws Exception {
        ArrayList<Unit> allUnits = new ArrayList<>();
        for (GameSystem gameSystem : configuration().getSystems().values()) {
            for (Unit unit : gameSystem.getShips()) {
                if (unit.getPlayer().equals(player))
                    allUnits.add(unit);
            }
        }
        allUnits.sort(Comparable::compareTo);
        return allUnits;
    }

    public static void printTextfile() throws Exception {
        BufferedWriter writer = null;
        String name = "";

        HashMap<String, ArrayList<GameSystem>> players = new HashMap<>();
        for (GameSystem gameSystem : configuration().getSystems().values()) {
            name = "";
            for (Unit unit: gameSystem.getShips()){
                if (name.equals("")){
                    name = unit.getPlayer();
                } else if (!name.equals(unit.getPlayer())){
                    name = "";
                    break;
                }
            }
            if (!name.equals("")){
                if (players.get(name) == null){
                    players.put(name, new ArrayList<>());
                    players.get(name).add(gameSystem);
                } else{
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
            writer.close();
        }
    }
}