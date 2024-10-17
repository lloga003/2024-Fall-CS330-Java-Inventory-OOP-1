package edu.odu.cs.cs330.items;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/////
/////
/**
 * This class represents one piece of armour--as found in most video games.
 * This includes boots and helmets.
 *
 * Armour may not be stacked.
 */
public class Armour extends Item {
    protected int durability;
    protected int defense;
    protected String material;
    protected String modifier;
    protected int modifierLevel; // Fixed typo here
    protected String element;

    public Armour() {
        super("", false); // Initialize name and stackable in parent constructor
        this.durability = 0;
        this.defense = 0;
        this.material = "";
        this.modifier = "";
        this.modifierLevel = 0;
        this.element = "";
    }

    public Armour(Armour src) {
        super(src.name, false); // Copy name from src and set stackable as false
        this.durability = src.durability;
        this.defense = src.defense;
        this.material = src.material;
        this.modifier = src.modifier;
        this.modifierLevel = src.modifierLevel; // Fixed typo
        this.element = src.element;
    }

    public int getDurability() {
        return this.durability;
    }

    public void setDurability(int dur) {
        this.durability = dur;
    }

    public int getDefense() {
        return this.defense;
    }

    public void setDefense(int def) {
        this.defense = def;
    }

    public String getMaterial() {
        return this.material;
    }

    public void setMaterial(String mat) {
        this.material = mat;
    }

    public String getModifier() {
        return this.modifier;
    }

    public void setModifier(String mod) {
        this.modifier = mod;
    }

    public int getModifierLevel() {
        return this.modifierLevel;
    }

    public void setModifierLevel(int level) {
        this.modifierLevel = level;
    }

    public String getElement() {
        return this.element;
    }

    public void setElement(String ele) {
        this.element = ele;
    }

    @Override
    public boolean isStackable() {
        return this.stackable;
    }

    @Override
    public void read(Scanner snr) {
        try {
            System.out.print("Enter name: ");
            this.name = snr.next();

            System.out.print("Enter material: ");
            this.material = snr.next();

            System.out.print("Enter durability: ");
            if (snr.hasNextInt()) {
                this.durability = snr.nextInt();
            } else {
                System.out.println("Invalid input for durability.");
                snr.next(); // Clear invalid input
            }

            System.out.print("Enter defense: ");
            if (snr.hasNextInt()) {
                this.defense = snr.nextInt();
            } else {
                System.out.println("Invalid input for defense.");
                snr.next(); // Clear invalid input
            }

            System.out.print("Enter modifier: ");
            this.modifier = snr.next();

            System.out.print("Enter modifier level: ");
            if (snr.hasNextInt()) {
                this.modifierLevel = snr.nextInt();
            } else {
                System.out.println("Invalid input for modifier level.");
                snr.next(); // Clear invalid input
            }

            System.out.print("Enter element: ");
            this.element = snr.next();
        } catch (NoSuchElementException e) {
            System.err.println("Input error: " + e.getMessage());
            snr.nextLine(); // Clear scanner buffer
        }
    }

    @Override
    public Item clone() {
        return new Armour(this);
    }

    @Override
    public String toString() {
        return String.format(
            "  Nme: %s\n"
          + "  Dur: %d\n"
          + "  Def: %d\n"
          + "  Mtl: %s\n"
          + "  Mdr: %s (Lvl %d)\n"
          + "  Emt: %s\n",
          this.name, this.durability, this.defense, this.material, this.modifier, this.modifierLevel, this.element
        );
    }




}
