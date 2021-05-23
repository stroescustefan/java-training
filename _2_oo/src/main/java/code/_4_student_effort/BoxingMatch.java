package code._4_student_effort;

public class BoxingMatch {
    private Fighter fighter1;
    private Fighter fighter2;

    public BoxingMatch(Fighter boxer1, Fighter boxer2) {
        this.fighter1 = boxer1;
        this.fighter2 = boxer2;
    }

    public BoxingMatch() {
        this(null, null);
    }

    public String fight() {
        while (fighter1.getHealth() > 0 && fighter2.getHealth() > 0) {
            fighter1.attack(fighter2);
            fighter2.attack(fighter1);
        }

        if (fighter1.getHealth() <= 0 && fighter2.getHealth() <= 0) {
            return "Tie match.";
        } else if (fighter1.getHealth() <= 0) {
            return fighter2.getName() + " has won the match.";
        } else {
            return fighter1.getName() + " has won the match.";
        }
    }

    public static void main(String[] args) {
        Fighter f1 = new Fighter("John", 200, 20);
        Fighter f2 = new Fighter("Stamate", 150, 20);
        BoxingMatch boxingMatch = new BoxingMatch(f1, f2);
        System.out.println(boxingMatch.fight());
    }
}

class Fighter {
    private String name;
    private int health;
    private int damagePerAttack;

    public Fighter(String name, int health, int damagePerAttack) {
        this.name = name;
        this.health = health;
        this.damagePerAttack = damagePerAttack;
    }

    public Fighter() {
        this("", 0, 0);
    }

    public void attack(Fighter opponent) {
        opponent.health -= damagePerAttack;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDamagePerAttack() {
        return damagePerAttack;
    }

    public void setDamagePerAttack(int damagePerAttack) {
        this.damagePerAttack = damagePerAttack;
    }
}
