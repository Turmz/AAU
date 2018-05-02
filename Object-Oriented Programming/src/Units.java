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
//Units.
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

public interface Units {
    int getCost();

    int getCombat();

    int getSpeed();

    int getCapacity();

    String getName();
}