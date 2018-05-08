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
//Problem 8.
//        Write unit tests to ensure that your above implementation is correct.
//        Legal Galaxies. A Galaxy is said to be legal if it satisfies the following properties:
//       The center system must have exactly one planet named Mecatol Rex.
//       Every planet belongs to at most one system.
//       Every system has at most three planets.
//       If system A is to the north of system B then the system B is to the south of A.
//        Similarly for the other five compass directions.
//
//Problem 9.
//        Write a method to verify that the above properties are satisfies by a Galaxy.
//        For each property, introduce an exception to be thrown, if that property is violated.

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class MainTest {
    Galaxy galaxy;

    public MainTest() throws Exception {
        galaxy  = Main.configuration();
    }

    @Test
    public void test1() {
        boolean truth = false;

        GameSystem gameSystem = galaxy.getSystems().get("Center");

        if (gameSystem.getPlanets().get("Mecatol Rex") != null){
            truth = true;
        }

        Assert.assertTrue(truth);
    }

    @Test
    public void test2(){
        ArrayList <Planet> checkPlanets = new ArrayList<>();
        checkPlanets.addAll(galaxy.getPlanets().values());
        Set<Planet> set = new HashSet<>(checkPlanets);
        Assert.assertTrue(checkPlanets.size() == set.size());
    }

    @Test
    public void test3(){
        boolean truth = true;

        for (GameSystem gameSystem: galaxy.getSystems().values()) {
            if(gameSystem.getPlanets().size() > 3 ){
                truth = false;
                break;
            }
        }
        Assert.assertTrue(truth);
    }

    @Test
    public void test4() throws Exception {
        boolean truth = false;

        for (GameSystem gameSystem : galaxy.getSystems().values()) {
            for (String neighbour : gameSystem.getNeighbours()){
                truth = false;
                for (String neighboursNeighbour : galaxy.getSystems().get(neighbour).getNeighbours()) {
                    if (gameSystem.getName().equals(neighboursNeighbour)){
                        truth = true;
                        break;
                    }
                }
                if (truth == false){
                    break;
                }
            }
            if (truth == false){
                break;
            }
        }
        Assert.assertTrue(truth);
    }
}