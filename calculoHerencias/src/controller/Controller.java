package controller;

import model.Nodo;
import model.Arbol;
import model.Persona;

public class Controller {

    Arbol arbolito = new Arbol();

    public void run(){

        datosBase();

        arbolito.calcularHerenciaInicial(100);

        arbolito.imprimirArbol();
    }

    public void datosBase(){        

        arbolito.insertar(new Persona("Elio", 0));
        
        //Hijos
        arbolito.insertar(arbolito.getRaiz(), new Persona("Karina", 0));
        arbolito.insertar(arbolito.getRaiz(), new Persona("Alex", 0));

        //Hijos de Karina
        arbolito.insertar(arbolito.getRaiz().getIzquierda(), new Persona("Valentina", 0));
        arbolito.insertar(arbolito.getRaiz().getIzquierda(), new Persona("José", 0));

        //Hijos de Alex
        arbolito.insertar(arbolito.getRaiz().getDerecha(), new Persona("Camilo", 0));
        arbolito.insertar(arbolito.getRaiz().getDerecha(), new Persona("María", 0));

        //Hijos de Ana
        arbolito.insertar(arbolito.getRaiz().getIzquierda().getIzquierda(), new Persona("Laura", 0));
        arbolito.insertar(arbolito.getRaiz().getIzquierda().getIzquierda(), new Persona("Juan", 0));
        
        //Hijos de Luis
        arbolito.insertar(arbolito.getRaiz().getDerecha().getIzquierda(), new Persona("Paula", 0));

    }

}
