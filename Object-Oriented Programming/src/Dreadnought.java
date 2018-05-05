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
// Unit
//        Problem 3. Write classes, which extend the interface, for each type of unit.

public class Dreadnought implements Unit {
    private String player;
    public Dreadnought(String name) {
        this.player = name;
    }

    private String type = "Dreadnought";
    private int cost = 5;
    private int combat  = 5;
    private int speed = 1;
    private int capacity = 0;

    @Override
    public String getType() {
        return type;
    }

    @Override
    public int getCost() {
        return cost;
    }

    @Override
    public int getCombat() {
        return combat;
    }

    @Override
    public int getSpeed() {
        return speed;
    }

    @Override
    public int getCapacity() {
        return capacity;
    }

    @Override
    public String getPlayer() {
        return player;
    }
}
