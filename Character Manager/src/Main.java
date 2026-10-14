
import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterType;

public class Main {
    public static void main(String[] args) {
        Character warrior = new Character(
            "Aragorn", CharacterType.WARRIOR
        );

        Character mage = new Character(
            "Gandalf", CharacterType.MAGE, 3
        );

        Character archer = new Character(
            "Legolas", CharacterType.ARCHER
        );

        System.out.println("=== CHARACTER MANAGER ===");
        System.out.println(warrior);
        System.out.println(mage);
        System.out.println(archer);

        System.out.println("\n=== DEMO LEVEL UP ===");
        System.out.println("Sebelum level up: " + warrior);
        warrior.setLevel(warrior.getLevel() + 1);
        System.out.println("Sesudah level up: " + warrior);

        System.out.println("\n=== MINI-CHALLENGE ===");
        Character necromancer = new Character(
            "Morgana", CharacterType.MAGE, 5
        );

        necromancer.setMana(120);

        System.out.println(necromancer);
        System.out.println(
            "Morgana masih hidup? " + necromancer.isAlive()
        );

        // Demonstrasi validasi; sengaja tidak dijalankan.
        // necromancer.setMana(-10);
    }
}
