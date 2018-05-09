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
//Unit.
//        In baby Twilight, each player commands a fleet of spaceships.
//        A spaceship has a type, a combat value, a resource cost, a movement speed,
//        and capacity. Every spaceship, in the game, belongs to a specific player.
//        The spaceships are:
//
//        -----------------------------------------------------------------------------------------
//        Type          Resource Cost       Combat Value       Movement Speed        Capacity
//        -----------------------------------------------------------------------------------------
//        Destroyer                 1                  9                    2               0
//        Cruiser                   2                  7                    2               0
//        Carrier                   3                  9                    1               6
//        Dreadnought               5                  5                    1               0
//        -----------------------------------------------------------------------------------------
//
//        Briefly, the attributes of a spaceship can be understood as follows: the resource cost is
//        how much the ship costs to produce, the combat value is a measure of how good the ship
//        is at fighting,, the movement speed is a measure how many systems the ship can move,
//        and finally the capacity is a measure of how many troops can be aboard.
//
//        Problem 2. Write an interface for units. The interface should have getters to retrieve
//        the resource cost, combat value, movement speed, capacity, and the player who owns it.

    // I've made it so, that the Unit interface extends the Comparable,
    // so I can sort the Units after combat value and after cost value.
public interface Unit extends Comparable<Unit>{
    // Getter for each unit-class, so you can see who player owns the unit.
    String getPlayer();

    // Getter for each unit-class, so you can see what type of unit it is.
    String getType();

    // Getter for each unit-class, so you can see the cost of the unit.
    int getCost();

    // Getter for each unit-class, so you can the combat value of the unit.
    int getCombat();

    // Getter for each unit-class, so you can the speed value of the unit.
    int getSpeed();

    // Getter for each unit-class, so you can the capacity value of the unit.
    int getCapacity();
}