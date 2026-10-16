package com.unpri.charactermanager;

import java.util.ArrayList;

import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterType;

public class CharacterManager {

    private final ArrayList<Character> characters = new ArrayList<>();

    public boolean addCharacter(Character character) {
        if (character == null || character.getName() == null) {
            return false;
        }

        if (findByName(character.getName()) != null) {
            return false;
        }

        characters.add(character);
        return true;
    }

    public Character findByName(String name) {
        if (name == null) {
            return null;
        }

        for (Character c : characters) {
            if (c.getName() != null
                    && c.getName().equalsIgnoreCase(name)) {
                return c;
            }
        }

        return null;
    }

    public boolean removeCharacter(String name) {
        Character c = findByName(name);

        if (c == null) {
            return false;
        }

        characters.remove(c);
        return true;
    }

    public int getTotalCharacters() {
        return characters.size();
    }

    public ArrayList<Character> getAllCharacters() {
        return new ArrayList<>(characters);
    }

    public double getAverageLevel() {
        if (characters.isEmpty()) {
            return 0.0;
        }

        int total = 0;

        for (Character c : characters) {
            total += c.getLevel();
        }

        return (double) total / characters.size();
    }

    public ArrayList<Character> findByType(CharacterType type) {
        ArrayList<Character> result = new ArrayList<>();

        if (type == null) {
            return result;
        }

        for (Character c : characters) {
            if (c.getType() == type) {
                result.add(c);
            }
        }

        return result;
    }

    /**
     * Menghitung jumlah karakter berdasarkan tipe.
     * @param type tipe karakter yang dihitung
     * @return jumlah karakter dengan tipe tersebut
     */
    public int countByType(CharacterType type) {
        int count = 0;

        if (type == null) {
            return count;
        }

        for (Character c : characters) {
            if (c.getType() == type) {
                count++;
            }
        }

        return count;
    }
}