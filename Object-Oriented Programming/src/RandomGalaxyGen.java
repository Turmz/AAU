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
//        Problem 12.
//        Write a method that constructs a random Galaxy with the Mecatol Rex
//        system in the center and with one layer of systems around it. The systems should
//        randomly have between zero and three planets. At least two systems should contain
//        ships belonging to at least two players.

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class RandomGalaxyGen {
    public static Galaxy randomGalaxy() throws Exception {
        Galaxy raGalaxy = new Galaxy();
        Random random = new Random();
        int resourcesGenerator = random.nextInt(6) + 1;
        int planetGenerator = random.nextInt(3);
        int numb1 = 1;
        int numb2 = 2;
        int numb3 = 3;

        // Creates a list from all the Systems in the game.
        ArrayList<GameSystem> ListOfSystems = new ArrayList<>();
        ListOfSystems.addAll(Main.configuration().getSystems().values());

        // Creates a list from all the Planets in the game.
        ArrayList<Planet> ListOfPlanets = new ArrayList<>();
        ListOfPlanets.addAll(Main.configuration().getPlanets().values());

        // Creates a list, that contains the numbers 0,1,2,3,4,5,6 and shuffles them.
        // This helps me later, when I need to add a random system, to the galaxy.
        ArrayList<Integer> ListOfNumbers = new ArrayList<Integer>(7);
        ListOfNumbers.add(0); ListOfNumbers.add(1);  ListOfNumbers.add(2);
        ListOfNumbers.add(3); ListOfNumbers.add(4); ListOfNumbers.add(5);
        ListOfNumbers.add(6); Collections.shuffle(ListOfNumbers);

        // Adds the "Center" system.
        raGalaxy.addSystem("Center", new GameSystem("Center", new Planet("Mecatol Rex", resourcesGenerator)));

        System.out.println("New system added to game: " + raGalaxy.getSystems().get("Center").getName() + ".");
        System.out.println("Number of Planets in ListOfPlanets: " + ListOfPlanets.size());
        System.out.println("Number of Systems in ListOfSystems: " + ListOfSystems.size());

        createSystem(raGalaxy, resourcesGenerator, planetGenerator, numb1, numb2, numb3, ListOfSystems, ListOfPlanets, ListOfNumbers);
        createSystem(raGalaxy, resourcesGenerator, planetGenerator, numb1, numb2, numb3, ListOfSystems, ListOfPlanets, ListOfNumbers);
        createSystem(raGalaxy, resourcesGenerator, planetGenerator, numb1, numb2, numb3, ListOfSystems, ListOfPlanets, ListOfNumbers);
        createSystem(raGalaxy, resourcesGenerator, planetGenerator, numb1, numb2, numb3, ListOfSystems, ListOfPlanets, ListOfNumbers);
        createSystem(raGalaxy, resourcesGenerator, planetGenerator, numb1, numb2, numb3, ListOfSystems, ListOfPlanets, ListOfNumbers);
        createSystem(raGalaxy, resourcesGenerator, planetGenerator, numb1, numb2, numb3, ListOfSystems, ListOfPlanets, ListOfNumbers);
        createSystem(raGalaxy, resourcesGenerator, planetGenerator, numb1, numb2, numb3, ListOfSystems, ListOfPlanets, ListOfNumbers);
        System.out.println("Number of elements in ListOfSystems: " + ListOfSystems.size());
        System.out.println("Number of elements in ListOfPlanets: " + ListOfPlanets.size());
        return raGalaxy;
    }

    private static void createSystem(Galaxy raGalaxy, int resourcesGenerator, int planetGenerator, int numb1, int numb2, int numb3, ArrayList<GameSystem> listOfSystems, ArrayList<Planet> listOfPlanets, ArrayList<Integer> listOfNumbers) throws Exception {
        if (planetGenerator == 0) {
            raGalaxy.addSystem(listOfSystems.get(listOfNumbers.get(1)).getName(), new GameSystem(listOfSystems.get(listOfNumbers.get(1)).getName()));

            // Prints out the name of the system, and amount of planets, and their respected names.
            System.out.println("New system added to game: " + listOfSystems.get(listOfNumbers.get(numb1)).getName() + ".");
            System.out.println("No planets were added to " + listOfSystems.get(listOfNumbers.get(numb1)).getName() + ".");

            // CHECKS IF THE PLANETGENERATOR IS 1, IF IT IS,
            // THIS IF-STATEMENT WILL GET EXECUTED, AND WILL
            // GENERATE ONE PLANET.
        } else if (planetGenerator == 1) {
            raGalaxy.addSystem(listOfSystems.get(listOfNumbers.get(numb1)).getName(),
            new GameSystem(listOfSystems.get(listOfNumbers.get(numb1)).getName(),
            new Planet(listOfPlanets.get(listOfNumbers.get(numb1)).getName(), resourcesGenerator)));

            // Prints out the name of the system, and amount of planets, and their respected names.
            System.out.println("New system added to game: " + listOfSystems.get(listOfNumbers.get(numb1)).getName() + ".");
            System.out.println("A planet was added to " + listOfSystems.get(listOfNumbers.get(numb1)).getName() + ": ");
            System.out.println(listOfPlanets.get(listOfNumbers.get(numb1)).getName());

            // Removes the "used" system from the ListOfSystems-list.
            listOfSystems.remove(listOfSystems.get(listOfNumbers.get(numb1)));

            // Removes the "used" planets from the ListOfPlanets-list.
            listOfPlanets.remove((listOfPlanets.get(listOfNumbers.get(numb1))));

        } else if (planetGenerator == 2) {
            raGalaxy.addSystem(listOfSystems.get(listOfNumbers.get(numb1)).getName(),
            new GameSystem(listOfSystems.get(listOfNumbers.get(numb1)).getName(),
            new Planet(listOfPlanets.get(listOfNumbers.get(numb1)).getName(), resourcesGenerator),
            new Planet(listOfPlanets.get(listOfNumbers.get(numb2)).getName(), resourcesGenerator)));

            // Prints out the name of the system, and amount of planets, and their respected names.
            System.out.println("New system added to game: " + listOfSystems.get(listOfNumbers.get(numb1)).getName() + ".");
            System.out.println("Two planets were added to " + listOfSystems.get(listOfNumbers.get(numb1)).getName() + ".");
            System.out.println(listOfPlanets.get(listOfNumbers.get(numb1)).getName());
            System.out.println(listOfPlanets.get(listOfNumbers.get(numb2)).getName());

            // Removes the "used" system from the ListOfSystems-list.
            listOfSystems.remove(listOfSystems.get(listOfNumbers.get(numb1)));

            // Removes the "used" planets from the ListOfPlanets-list.
            listOfPlanets.remove((listOfPlanets.get(listOfNumbers.get(numb1))));
            listOfPlanets.remove((listOfPlanets.get(listOfNumbers.get(numb2))));

        } else if (planetGenerator == 3) {
            raGalaxy.addSystem(listOfSystems.get(listOfNumbers.get(numb1)).getName(),
            new GameSystem(listOfSystems.get(listOfNumbers.get(numb1)).getName(),
            new Planet(listOfPlanets.get(listOfNumbers.get(numb1)).getName(), resourcesGenerator),
            new Planet(listOfPlanets.get(listOfNumbers.get(numb2)).getName(), resourcesGenerator),
            new Planet(listOfPlanets.get(listOfNumbers.get(numb3)).getName(), resourcesGenerator)));

            // Prints out the name of the system, and amount of planets, and their respected names.
            System.out.println("New system added to game: " + listOfSystems.get(listOfNumbers.get(numb1)).getName() + ".");
            System.out.println("Two planets were added to " + listOfSystems.get(listOfNumbers.get(numb1)).getName() + ".");
            System.out.println(listOfPlanets.get(listOfNumbers.get(numb1)).getName());
            System.out.println(listOfPlanets.get(listOfNumbers.get(numb2)).getName());

            // Removes the "used" system from the ListOfSystems-list.
            listOfSystems.remove(listOfSystems.get(listOfNumbers.get(numb1)));


            // Removes the "used" planets from the ListOfPlanets-list.
            listOfPlanets.remove((listOfPlanets.get(listOfNumbers.get(numb1))));
            listOfPlanets.remove((listOfPlanets.get(listOfNumbers.get(numb2))));
            listOfPlanets.remove((listOfPlanets.get(listOfNumbers.get(numb3))));

        } else {
            throw new Exception("No system or planet created!");
        }
    }
}