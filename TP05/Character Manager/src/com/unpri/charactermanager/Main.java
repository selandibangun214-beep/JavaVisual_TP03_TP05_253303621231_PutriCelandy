
package com.unpri.charactermanager;

import java.util.ArrayList;

import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterType;

public class Main {

    public static void main(String[] args) {

        CharacterManager manager = new CharacterManager();

        // 1. Menambahkan karakter
        Character c1 = new Character("Regnar", 10, CharacterType.WARRIOR);
        Character c2 = new Character("Elara", 15, CharacterType.MAGE);
        Character c3 = new Character("Kael", 8, CharacterType.ARCHER);
        Character c4 = new Character("Freya", 12, CharacterType.MAGE);

        System.out.println("===== TAMBAH KARAKTER =====");
        System.out.println("Regnar: " + manager.addCharacter(c1));
        System.out.println("Elara: " + manager.addCharacter(c2));
        System.out.println("Kael: " + manager.addCharacter(c3));
        System.out.println("Freya: " + manager.addCharacter(c4));

        // 2. Menguji duplikat
        System.out.println("\n===== TES DUPLIKAT =====");
        Character duplicate = new Character("REGNAR", 20, CharacterType.HEALER);

        System.out.println("Duplikat ditambahkan: "
                + manager.addCharacter(duplicate));

        // 3. Menampilkan semua karakter
        System.out.println("\n===== SEMUA KARAKTER =====");
        for (Character character : manager.getAllCharacters()) {
            System.out.println(character);
        }

        // 4. Mencari karakter
        System.out.println("\n===== CARI KARAKTER =====");
        Character found = manager.findByName("Elara");

        if (found != null) {
            System.out.println("Ditemukan: " + found);
        } else {
            System.out.println("Karakter tidak ditemukan.");
        }

        // 5. Menghitung jumlah dan rata-rata level
        System.out.println("\n===== MINI CHALLENGE =====");
        System.out.println("Total karakter: "
                + manager.getTotalCharacters());

        System.out.println("Rata-rata level: "
                + manager.getAverageLevel());

        // 6. Mencari berdasarkan tipe
        System.out.println("\n===== CARI BERDASARKAN TIPE =====");
        ArrayList<Character> mages =
                manager.findByType(CharacterType.MAGE);

        System.out.println("Jumlah Mage: " + mages.size());

        for (Character mage : mages) {
            System.out.println(mage);
        }

        // 7. Fitur analitik tambahan
        System.out.println("\n===== ANALITIK =====");
        System.out.println("Jumlah Warrior: "
                + manager.countByType(CharacterType.WARRIOR));

        System.out.println("Jumlah Mage: "
                + manager.countByType(CharacterType.MAGE));

        // 8. Menguji defensive copy
        System.out.println("\n===== TES DEFENSIVE COPY =====");
        ArrayList<Character> copy = manager.getAllCharacters();

        System.out.println("Jumlah salinan awal: " + copy.size());

        copy.clear();

        System.out.println("Jumlah salinan setelah clear: " + copy.size());
        System.out.println("Jumlah manager: "
                + manager.getTotalCharacters());

        // 9. Menguji equals
        System.out.println("\n===== TES EQUALS =====");
        Character sameName =
                new Character("REGNAR", 5, CharacterType.MAGE);

        System.out.println("Regnar equals REGNAR: "
                + c1.equals(sameName));

        // 10. Menguji reference
        System.out.println("\n===== TES REFERENCE =====");
        Character a = new Character("Test", 5, CharacterType.WARRIOR);
        Character b = a;

        b.setLevel(8);

        System.out.println("Level a: " + a.getLevel());
        System.out.println("Level b: " + b.getLevel());
        System.out.println("a == b: " + (a == b));

        // Membuat objek independen
        Character independent =
                new Character(a.getName(), a.getLevel(), a.getType());

        independent.setLevel(2);

        System.out.println("Level a: " + a.getLevel());
        System.out.println("Level independent: " + independent.getLevel());

        // 11. Menghapus karakter
        System.out.println("\n===== HAPUS KARAKTER =====");
        System.out.println("Elara dihapus: "
                + manager.removeCharacter("Elara"));

        System.out.println("Merlin dihapus: "
                + manager.removeCharacter("Merlin"));

        System.out.println("Total setelah penghapusan: "
                + manager.getTotalCharacters());

        // 12. Menguji manager kosong
        System.out.println("\n===== TES LIST KOSONG =====");
        CharacterManager emptyManager = new CharacterManager();

        System.out.println("Total karakter kosong: "
                + emptyManager.getTotalCharacters());

        System.out.println("Rata-rata level kosong: "
                + emptyManager.getAverageLevel());

        System.out.println("Mage pada list kosong: "
                + emptyManager.findByType(CharacterType.MAGE).size());

        // 13. Total objek yang pernah dibuat
        System.out.println("\n===== TOTAL OBJEK =====");
        System.out.println("Total objek dibuat: "
                + Character.getTotalCharacterCreated());

        System.out.println("\n===== PROGRAM SELESAI =====");
    }
}
