package State;

import java.util.Random;

public class Character {
    private static final Random RANDOM = new Random();

    private static final int[] LEVEL_THRESHOLDS = {0, 25, 50, 100};

    private String name;
    private int xp;
    private int hp;
    private int maxHp;

    public Character() {
        this.xp = 0;
        this.hp = 100;
        this.maxHp = 100;
    }

    public void train() {
        int xpGained = RANDOM.nextInt(10) + 1;
        this.gainXp(xpGained);
        System.out.println(this.name + " trained and gained " + xpGained + " XP!");
    }

    public void meditate() {
        int hpGained = RANDOM.nextInt(10) + 1;
        this.heal(Math.min(hpGained, this.maxHp - this.hp)); // cannot exceed max hp
        System.out.println(this.name + " meditated and gained " + hpGained + " HP!");
    }

    public void fight() {
        if (this.getLevel() < 3) {
            System.out.println(this.name + " is not experienced enough yet to fight.");
            return;
        }

        int hpLost = RANDOM.nextInt(25) + 1;
        int xpGained = RANDOM.nextInt(20) + 1;

        this.takeDamage(hpLost);
        this.gainXp(xpGained);

        System.out.println(this.name + " fought and lost " + hpLost + " HP but gained " + xpGained + " XP!");

        if (this.hp <= 0) {
            System.out.println(this.name + " has been defeated and lost all XP!");
            this.hp = this.maxHp;
            this.xp = 0;
        }
    }

    public int getLevel() {
        int level = 1;
        for (int i = 1; i < LEVEL_THRESHOLDS.length; i++) {
            if (this.xp >= LEVEL_THRESHOLDS[i]) {
                level = i + 1;
            }
        }
        return level;
    }

    public String toString() {
        return String.format("%dHP | %s | %dXP", this.hp, this.name, this.xp);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getXp() {
        return this.xp;
    }

    public void gainXp(int xp) {
        this.xp += xp;
    }

    public int getHp() {
        return this.hp;
    }

    public void takeDamage(int hp) {
        this.hp -= hp;
    }

    public void heal(int hp) {
        this.hp += hp;
    }
}
