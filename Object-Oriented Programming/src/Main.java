import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Main {
    public static void main(String[] args) throws Exception {
        Player crassus = new Player("Crassus", "The Emirates of Hacan", "Blue");
        Player pompey = new Player("Pompey", "The Federation of Sol", "Red");

        Galaxy galaxy = new Galaxy();

        galaxy.addSystem(new GameSystem("Center", new Planet("Mecatol Rex", 6)));
        galaxy.addSystem(new GameSystem("North", new Planet("Vega Minor", 1), new Planet("Vega Major", 2)));
        galaxy.addSystem(new GameSystem("North-East"));
        galaxy.addSystem(new GameSystem("South-East", new Planet("Industrex", 3)));
        galaxy.addSystem(new GameSystem("North", new Planet("Rigel I", 1), new Planet("Rigel II", 2)));
        galaxy.addSystem(new GameSystem("South-West"));
        galaxy.addSystem(new GameSystem("North-West", new Planet("Mirage", 4)));

        for (GameSystem system:galaxy.getSystems()) {
            if(system.getName().equals("Center")){
                system.addShip(new Dreadnought("Crassus"));
                system.addShip(new Dreadnought("Crassus"));
                system.addShip(new Destroyer("Crassus"));
            }
            if(system.getName().equals("North")){
                system.addShip(new Cruiser("Pompey"));
                system.addShip(new Cruiser("Pompey"));
                system.addShip(new Carrier("Pompey"));
            }
        }
    }
}
