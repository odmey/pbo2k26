public class MainHard {
    public static void tampilkanStatus(Character a, Character b) {
        System.out.println(a.getName() + " | " + a.getHealth());
        System.out.println(b.getName() + " | " + b.getHealth());
        System.out.println();
    }

    public static void main(String[] args) {
        Hero hero = new Hero("As'ad Sakai", 100, 15);
        Villain villain = new Villain("Zhafran Khan", 100, 15);

        Character[] peserta = {hero, villain};
        for (Character c : peserta) {
            c.showCharacter();            // dynamic binding
        }
        System.out.println();

        while (hero.getHealth() > 0 && villain.getHealth() > 0) {
            hero.attack(villain);
            tampilkanStatus(hero, villain);
            if (villain.getHealth() <= 0) {
                break;
            }

            villain.attack(hero);
            tampilkanStatus(hero, villain);
        }

        if (villain.getHealth() <= 0) {
            villain.dead();
        } else {
            hero.dead();
        }
    }

}
