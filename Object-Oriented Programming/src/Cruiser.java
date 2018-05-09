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

public class Cruiser implements Unit {
    // The player, who will own the unit
    private String player;

    // Constructor for the unit
    public Cruiser(String name) {
        this.player = name;
    }

    // Units values
    private String type = "Cruiser";
    private int cost = 2;
    private int combat  = 7;
    private int speed = 2;
    private int capacity = 0;

    // Returns the player.
    @Override
    public String getPlayer() {
        return player;
    }
    // Returns the type of unit.
    @Override
    public String getType() {
        return type;
    }

    // Returns the cost of the unit.
    @Override
    public int getCost() {
        return cost;
    }

    // Returns the combat value of the unit.
    @Override
    public int getCombat() {
        return combat;
    }

    // Returns the speed of the unit.
    @Override
    public int getSpeed() {
        return speed;
    }

    // Returns the capacity of the unit.
    @Override
    public int getCapacity() {
        return capacity;
    }

    // Problem 10.
    // Because the units first needed to be sorted with the combat value, and if their combat
    // value was the same as another unit, it should be sorted with the cost value, I saw it
    // as the easiest thing, just to sort them under their own class.
    @Override
    public int compareTo(Unit unit) {
        if (this.combat == unit.getCombat()){
            return Integer.compare(unit.getCost(),this.cost);
        } else {
            return Integer.compare(unit.getCombat(),this.combat);
        }
    }
}
