package controller;

import model.Arbol;
import model.Persona;

public class Controller {

    Arbol arbolito = new Arbol();

    public void run(){

        datosBase();
        arbolito.preorden();

    }

    public void datosBase(){        

        Persona Alex = new Persona("Alex", 0);
        arbolito.insertar(Alex);

        arbolito.insertar(Alex, new Persona("Karina", 0));
        arbolito.insertar(new Persona("Carlos", 0));
        arbolito.insertar(new Persona("Ana", 0));
        arbolito.insertar(new Persona("Luis", 0));
        arbolito.insertar(new Persona("María", 0));
        arbolito.insertar(new Persona("José", 0));
        arbolito.insertar(new Persona("Laura", 0));
        arbolito.insertar(new Persona("Juan", 0));
        arbolito.insertar(new Persona("Paula", 0));

    }

}
