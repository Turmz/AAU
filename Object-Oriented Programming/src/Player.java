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
//Players
//        A game of baby Twilight is played between two to six players. Each player
//        has a name, a unique race, and a unique color. The game has sixteen races such as: The
//        Barony of Letnev, The Clan of Saar, The Emirates of Hacan, and The Federation of Sol.
//
//        Problem 1. Write a class to represent a player. The class should have an appropriate
//        constructor and appropriate getters. Implement the equals, hashCode, and toString
//        methods for the class.

import java.util.Objects;
import java.lang.*;

public class Player {
    private String name;
    private String race;
    private String colour;

    public Player(String name, String race, String colour) {
        this.name = name;
        this.race = race;
        this.colour = colour;
    }

    public String getName() {
        return name;
    }

    public String getRace() {
        return race;
    }

    public String getColour() {
        return colour;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(name, player.name) &&
                Objects.equals(race, player.race) &&
                Objects.equals(colour, player.colour);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, race, colour);
    }

    @Override
    public String toString() {

        return "Player{" +
                "name='" + name + '\'' +
                ", race='" + race + '\'' +
                ", colour='" + colour + '\'' +
                '}';
    }
}

