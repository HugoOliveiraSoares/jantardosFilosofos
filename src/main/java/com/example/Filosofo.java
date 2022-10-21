package com.example;

import java.util.concurrent.Semaphore;

import com.github.tomaslanger.chalk.Ansi;
import com.github.tomaslanger.chalk.Chalk;

public class Filosofo extends Thread {

    private int id;
    private Chalk nome;
    private static Semaphore hashis[] = new Semaphore[6];

    public Filosofo(Chalk nome, int id) {
        for (int i = 1; i <= 5; i++) {
            hashis[i] = new Semaphore(1);
        }
        this.nome = nome;
        this.id = id;
    }

    public void pegarHashi() throws InterruptedException {
        hashis[id].acquire();
        System.out.println("o filosofo " +  nome+"("+id+")" + " pegou o hashi " + id);

        if (id < 5) {
            hashis[id +1].acquire();
            System.out.println("o filosofo " + nome+"("+id+")" + " pegou o hashi " + (id + 1));
        }else { // o "ultimo" filosofo pega o primeiro hashi
            hashis[1].acquire();
            System.out.println("o filosofo " + nome+"("+id+")" + " pegou o hashi " + 1);
        }
    }

    public void soltarHashi() throws InterruptedException {
        hashis[id].release();
        System.out.println("o filosofo " + nome+"("+id+")" + " soltou o hashi " + id);
        if (id < 5) {
            hashis[id + 1].release();
            System.out.println("o filosofo " + nome+"("+id+")" + " soltou o hashi " + (id + 1));
        } else {
            hashis[1].release();
            System.out.println("o filosofo " + nome+"("+id+")" + " soltou o hashi " + 1);
        }
    }

    public void comer() throws InterruptedException {
        sleep((long) (Math.random() * 1000));
        System.out.println(nome + " esta comendo ...");
    }

    public void pensar() throws InterruptedException {
        sleep((long) (Math.random() * 1000));
        System.out.println(nome + " esta pensando ...");
    }

    public void faminto() throws InterruptedException {
        sleep((long) (Math.random() * 1000));
        System.out.println(nome + " esta faminto ...");
    }

    public void run() {

        while (true) {
            try {
                faminto();
                pegarHashi();
                comer();
                soltarHashi();
                pensar();
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public Chalk getNome() {
        return nome;
    }

    public void setNome(Chalk nome) {
        this.nome = nome;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static Semaphore[] getHashis() {
        return hashis;
    }

    public static void setHashis(Semaphore[] hashis) {
        Filosofo.hashis = hashis;
    }
}