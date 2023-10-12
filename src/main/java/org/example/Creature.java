package org.example;

import java.util.Random;

abstract class Creature {
    private String name;
    private int attack;
    private int defense;
    private int maxHealth;
    private int health;
    private int[] damageRange;

    public Creature(String name, int attack, int defense, int maxHealth, int[] damageRange) {
        this.name = name;
        this.attack = attack;
        this.defense = defense;
        this.maxHealth = maxHealth;
        this.health = maxHealth;
        this.damageRange = damageRange;
    }

    public String getName() {
        return name;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getHealth() {
        return health;
    }

    public int[] getDamageRange() {
        return damageRange;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setDamageRange(int[] damageRange) {
        this.damageRange = damageRange;
    }

    public void takeDamage(int damage) {
        health -= damage;
        if (health < 0) {
            health = 0;
        }
    }

    public boolean isAlive() {
        return health > 0;
    }

    public void heal() {
        if (health > 0) {
            int maxHeal = (int) (maxHealth * 0.3);
            int healAmount = new Random().nextInt(maxHeal) + 1;
            health += healAmount;
            if (health > maxHealth) {
                health = maxHealth;
            }
        }
    }

    public int calculateModifier(Creature target) {
        int modifier = attack - target.defense + 1;
        return modifier > 1 ? modifier : 1;
    }

    public boolean attackTarget(Creature target) {
        int modifier = calculateModifier(target);
        boolean attackSuccessful = false;
        for (int i = 0; i < modifier; i++) {
            if (new Random().nextInt(6) + 1 >= 5) {
                attackSuccessful = true;
                break;
            }
        }

        if (attackSuccessful) {
            int damage = new Random().nextInt(damageRange[1] - damageRange[0] + 1) + damageRange[0];
            target.takeDamage(damage);
        }

        return attackSuccessful;
    }
}
