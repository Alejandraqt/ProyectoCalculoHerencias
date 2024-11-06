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

        arbolito.insertar(new Persona("Alex", 0));
        arbolito.insertar(new Persona("Karina", 0));
        arbolito.insertar(new Persona("Carlos", 0));
        arbolito.insertar(new Persona("Ana", 0));
        arbolito.insertar(new Persona("Luis", 0));
        arbolito.insertar(new Persona("María", 0));
        arbolito.insertar(new Persona("José", 0));
        arbolito.insertar(new Persona("Laura", 0));
        arbolito.insertar(new Persona("Juan", 0));
        arbolito.insertar(new Persona("Paula", 0));
        arbolito.insertar(new Persona("Pedro", 0));
        arbolito.insertar(new Persona("Carmen", 0));
        arbolito.insertar(new Persona("Sofía", 0));
        arbolito.insertar(new Persona("Miguel", 0));
        arbolito.insertar(new Persona("Andrea", 0));
        arbolito.insertar(new Persona("Javier", 0));
        arbolito.insertar(new Persona("Rosa", 0));
        arbolito.insertar(new Persona("Alberto", 0));
        arbolito.insertar(new Persona("Raquel", 0));
        arbolito.insertar(new Persona("Fernando", 0)); 

    }

}
