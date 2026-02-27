package State;

public class Character {
    private String name;
    private int xp;
    private int hp;

    public Character(String name) {
        this.name = name;
        this.xp = 0;
        this.hp = 100;
    }

    public void train() {

    }

    public void meditate() {

    }

    public void fight() {

    }

    public String getName() {
        return this.name;
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
