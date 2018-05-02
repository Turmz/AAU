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
// Units
//        Problem 3. Write classes, which extend the interface, for each type of unit.

public class Destroyer extends Units {
    private int cost = 0;
    private int combat = 0;
    private int speed = 0;
    private int capacity = 0;

    public int setCost(int cost) {
        this.cost = cost;
        return cost;
    }

    public int setCombat(int combat) {
        this.combat = combat;
        return combat;
    }

    public int setSpeed(int speed) {
        this.speed = speed;
        return speed;
    }

    public int setCapacity(int capacity) {
        this.capacity = capacity;
        return capacity;
    }
}
