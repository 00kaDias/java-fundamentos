package app;

import dominio.Pessoa;

public class Program {
    static void main(String[] args) {


        Pessoa p1 = new Pessoa(1, "Carlos da silva", "Carlos@gmail.com");
        Pessoa p2 = new Pessoa(2, "Jeremias da Costa", "Jeremias@gmail.com");
        Pessoa p3 = new Pessoa(3, "Selena Souza", "Selena@gmail.com");
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);



    }


}
