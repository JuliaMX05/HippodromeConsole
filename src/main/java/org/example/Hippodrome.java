package org.example;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {
    private List<Horse> horses;

    public List<Horse> getHorses() {
        return horses;
    }

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public static Hippodrome game;

    public void run() throws InterruptedException {
        for (int i = 1; i < 101; i++) {
            move();
            print();
            Thread.sleep(200);

        }
        printWinner();
    }
    public void move(){
        for (Horse hs : horses) {
            hs.move();
        }
    }
    public void print(){
        for (Horse hs : horses) {
            hs.print();
        }
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }

    public Horse getWinner() {
        Horse result = horses.get(0);
        for (Horse horse : horses) {
            if (horse.getDistance() > result.getDistance())
                result = horse;
        }
        return result;
    }

    public void printWinner() {
        System.out.println("Winner is " + getWinner().getName() +"!");
    }

    public static void main(String[] args) throws InterruptedException {

        game = new Hippodrome(new ArrayList<Horse>() {{
            add(new Horse("Plotva", 3, 0));
            add(new Horse("Kukuruza", 3, 0));
            add(new Horse("Knopka", 3, 0));
        }});

        game.run();
    }
}
