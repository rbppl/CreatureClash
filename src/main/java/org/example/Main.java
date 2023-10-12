package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Player player = new Player("Player", 10, 5, 100, new int[]{5, 15});
        Monster monster = new Monster("Monster", 8, 4, 80, new int[]{3, 10});

        while (player.isAlive() && monster.isAlive()) {
            if (player.attackTarget(monster)) {
                System.out.println(player.getName() + " attacks " + monster.getName() + " successfully!");
            } else {
                System.out.println(player.getName() + " misses the attack on " + monster.getName() + ".");
            }
            if (monster.isAlive()) {
                if (monster.attackTarget(player)) {
                    System.out.println(monster.getName() + " attacks " + player.getName() + " successfully!");
                } else {
                    System.out.println(monster.getName() + " misses the attack on " + player.getName() + ".");
                }
            }
        }

        if (player.isAlive()) {
            System.out.println(player.getName() + " wins!");
        } else {
            System.out.println(monster.getName() + " wins!");
        }
    }
}