
package encapsulation_access_control.assigment_problems;

public class Character {

    private int health;
    private final int maxHealth;

    Character(int maxHealth) {
        if (maxHealth < 0) {
            maxHealth = 0;
        }

        this.maxHealth = maxHealth;
        this.health = maxHealth;
    }

    void takeDamage(int amount) {
        if (amount <= 0) {
            return;
        }

        health -= amount;

        if (health < 0) {
            health = 0;
        }
    }

    void heal(int amount) {
        if (amount <= 0) {
            return;
        }

        health += amount;

        if (health > maxHealth) {
            health = maxHealth;
        }
    }

    int getHealth() {
        return health;
    }

    public static void main(String[] args) {

        Character c = new Character(100);

        c.takeDamage(30);
        System.out.println("Health after damage: " + c.getHealth());

        c.heal(50);
        System.out.println("Health after healing: " + c.getHealth());

        c.takeDamage(150);
        System.out.println("Health after extra damage: " + c.getHealth());
    }
}
