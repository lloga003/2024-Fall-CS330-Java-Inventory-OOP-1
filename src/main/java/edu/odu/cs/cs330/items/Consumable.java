package edu.odu.cs.cs330.items;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

////////////////
/**
 * This class represents one Consumable Item--as found in most video games.
 * This includes food.
 *
 * Consumable Items must be stackable.
 */
public class Consumable extends Item {
    protected String effect;
    protected int uses;

    public Consumable() {
        super("", true); // Initialize name and set stackable to true
        this.effect = "";
        this.uses = 0;
    }

    public Consumable(Consumable src) {
        super(src.name, true); // Copy name and stackable value
        this.effect = src.effect;
        this.uses = src.uses;
    }

    public String getEffect() {
        return this.effect;
    }

    public void setEffect(String newEff) {
        this.effect = newEff;
    }

    public int getNumberOfUses() {
        return this.uses;
    }

    public void setNumberOfUses(int allowed) {
        this.uses = allowed;
    }

    @Override
    public void read(Scanner snr) {
        try {
            System.out.print("Enter name: ");
            this.name = snr.next();

            System.out.print("Enter effect: ");
            this.effect = snr.next();

            System.out.print("Enter number of uses: ");
            if (snr.hasNextInt()) {
                this.uses = snr.nextInt();
            } else {
                System.out.println("Invalid input for number of uses.");
                snr.next(); // Clear invalid input
            }
        } catch (NoSuchElementException e) {
            System.err.println("Input error: " + e.getMessage());
            snr.nextLine(); // Clear scanner buffer
        }
    }
    
    //////
    //////
    @Override
    public String toString() {
        return String.format("  Nme: %s\n"
                           + "  Eft: %s\n"
                           + "  Use: %d\n", this.name, this.effect, this.uses);
    }


    @Override
    public Item clone() {
        return new Consumable(this);
    }

   
}



