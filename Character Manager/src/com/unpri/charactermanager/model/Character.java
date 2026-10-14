package com.unpri.charactermanager.model;

public class Character {
    private String name;
    private CharacterType type;
    private int level;
    private int hitPoints;
    private int attack;
    private int mana;

    // Constructor 1: nilai awal ditentukan berdasarkan tipe.
    public Character(String name, CharacterType type) {
        this.name = name;
        this.type = type;
        this.level = 1;

        updateStats();
        this.mana = 0;
    }

    // Constructor 2: nilai awal level diberikan oleh pemanggil.
    public Character(String name, CharacterType type, int level) {
        this.name = name;
        this.type = type;
        this.level = level;

        updateStats();
        this.mana = 0;
    }

    private void updateStats() {
        switch (type) {
            case WARRIOR:
                hitPoints = 100 + (level - 1) * 20;
                attack = 15 + (level - 1) * 5;
                break;
            case MAGE:
                hitPoints = 70 + (level - 1) * 10;
                attack = 25 + (level - 1) * 4;
                break;
            case ARCHER:
                hitPoints = 80 + (level - 1) * 15;
                attack = 20 + (level - 1) * 4;
                break;
            case HEALER:
                hitPoints = 90 + (level - 1) * 15;
                attack = 10 + (level - 1) * 3;
                break;
            default:
                throw new IllegalArgumentException(
                    "Tipe karakter tidak valid"
                );
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CharacterType getType() {
        return type;
    }

    public void setType(CharacterType type) {
        this.type = type;
        updateStats();
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        if (level < 1) {
            throw new IllegalArgumentException(
                "Level harus minimal 1"
            );
        }

        this.level = level;
        updateStats();
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        if (hitPoints < 0) {
            throw new IllegalArgumentException(
                "Hit points tidak boleh negatif"
            );
        }

        this.hitPoints = hitPoints;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        if (attack < 0) {
            throw new IllegalArgumentException(
                "Attack tidak boleh negatif"
            );
        }

        this.attack = attack;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        if (mana < 0) {
            throw new IllegalArgumentException(
                "Mana tidak boleh negatif"
            );
        }

        this.mana = mana;
    }

    public boolean isAlive() {
        return hitPoints > 0;
    }

    @Override
    public String toString() {
        return "Character{" +
                "name='" + name + '\'' +
                ", type=" + type +
                ", level=" + level +
                ", hitPoints=" + hitPoints +
                ", attack=" + attack +
                ", mana=" + mana +
                '}';
    }
}