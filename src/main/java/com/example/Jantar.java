package com.example;

import com.github.tomaslanger.chalk.Chalk;

public class Jantar {

    public static void main(String[] args) {

        try {
            Filosofo f1 = new Filosofo(Chalk.on("Leonardo da Vinci").yellow(), 1);
            Filosofo f2 = new Filosofo(Chalk.on("Platao").blue(), 2);
            Filosofo f3 = new Filosofo(Chalk.on("Piton").green(), 3);
            Filosofo f4 = new Filosofo(Chalk.on("Aristoteles").red(), 4);
            Filosofo f5 = new Filosofo(Chalk.on("Leonardo da Vinci").cyan(), 5);

            f1.start();
            f2.start();
            f3.start();
            f4.start();
            f5.start();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}