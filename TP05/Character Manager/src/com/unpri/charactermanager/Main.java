
package com.unpri.charactermanager;

import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterType;
import com.unpri.charactermanager.view.MainWindow;

import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {

        CharacterManager manager = new CharacterManager();

        // Lima karakter awal
        manager.addCharacter(
                new Character("Arka", 10, CharacterType.WARRIOR)
        );

        manager.addCharacter(
                new Character("Luna", 8, CharacterType.MAGE)
        );

        manager.addCharacter(
                new Character("Raka", 6, CharacterType.WARRIOR)
        );

        manager.addCharacter(
                new Character("Nara", 5, CharacterType.HEALER)
        );

        manager.addCharacter(
                new Character("Kirana", 12, CharacterType.ARCHER)
        );

        // Dua karakter baru untuk hasil sesudah
        manager.addCharacter(
                new Character("Bima", 15, CharacterType.WARRIOR)
        );

        manager.addCharacter(
                new Character("Maya", 14, CharacterType.MAGE)
        );

        // Menampilkan jendela Swing
        SwingUtilities.invokeLater(() -> {
            MainWindow window = new MainWindow(manager);
            window.setVisible(true);
        });
    }
}
