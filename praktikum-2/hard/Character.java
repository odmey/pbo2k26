public abstract class Character {
    private String name;
    private int health;
    private int attack;

    public Character(String name, int health, int attack) {
        this.name = name;
        this.health = health;
        this.attack = attack;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setHealth(int health) {
        if (health < 0) {
            health = 0;
        }
        this.health = health;
    }

    public int getHealth() {
        return health;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getAttack() {
        return attack;
    }

    // peluang menghindar 25% setiap kali diserang
    public boolean isDodge() {
        return Math.random() < 0.25;
    }

    public abstract void showCharacter();
}