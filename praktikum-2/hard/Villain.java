public class Villain extends Character implements Behaviour {
    private int count = 0;                 // jumlah pemakaian spesial skill (maksimal 1)
    private boolean doubleDamage = false;

    public Villain(String name, int health, int attack) {
        super(name, health, attack);
    }

    public void attack(Character target) {
        int damage = getAttack();

        if (getHealth() < 50 && count == 0) {
            spesialSkill();
            if (doubleDamage) {
                damage = getAttack() * 2;
                doubleDamage = false;
            } else {
                return;                    // healing memakai giliran ini
            }
        } else {
            System.out.println(getName() + " hit you with normal attack!");
        }

        if (target.isDodge()) {
            System.out.println("you dodge " + getName() + " attack");
        } else {
            target.setHealth(target.getHealth() - damage);
        }
    }

    @Override
    public void spesialSkill() {
        count++;
        if (Math.random() < 0.5) {
            setHealth(getHealth() + 30);
            System.out.println(getName() + " Use special skill, Healing");
        } else {
            doubleDamage = true;
            System.out.println(getName() + " Use special skill, Double Damage");
        }
    }

    @Override
    public void dead() {
        System.out.println("Hero wins!!!, Villain " + getName() + " Defeated");
    }

    @Override
    public void showCharacter() {
        System.out.println("Villain : " + getName() + " | Health : " + getHealth()
                + " | Attack : " + getAttack());
    }
}