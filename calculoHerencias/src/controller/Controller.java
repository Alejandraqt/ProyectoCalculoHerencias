package controller;

import java.util.Map;

import model.Arbol;
import model.Persona;
import view.View;

public class Controller {

    Arbol arbolito = new Arbol();

    public void run() {

        View.imprimirMensajeLn("\nBienvenido al Cálculo de herencias\nLa herencia se debe distribuir de la siguiente manera: \n");

        datosBase();

        arbolito.calcularHerenciaInicial(100);

        arbolito.imprimirArbol();

        View.imprimirMensajeLn("");
    }

    public void datosBase() {

        //Padre
        arbolito.insertar(crearDiccionario(new Persona("Elio", 0)));

        // Hijos de Elio
        arbolito.insertar(arbolito.getRaiz(), crearDiccionario(new Persona("Karina", 0)));
        arbolito.insertar(arbolito.getRaiz(), crearDiccionario(new Persona("Alex", 0)));

        // Hijos de Karina
        arbolito.insertar(arbolito.getRaiz().getIzquierda(), crearDiccionario(new Persona("Valentina", 0)));
        arbolito.insertar(arbolito.getRaiz().getIzquierda(), crearDiccionario(new Persona("José", 0)));

        // Hijos de Alex
        arbolito.insertar(arbolito.getRaiz().getDerecha(), crearDiccionario(new Persona("Camilo", 0)));
        arbolito.insertar(arbolito.getRaiz().getDerecha(), crearDiccionario(new Persona("María", 0)));

        // Hijos de Valentina
        arbolito.insertar(arbolito.getRaiz().getIzquierda().getIzquierda(), crearDiccionario(new Persona("Laura", 0)));
        arbolito.insertar(arbolito.getRaiz().getIzquierda().getIzquierda(), crearDiccionario(new Persona("Juan", 0)));

        // Hijos de Camilo
        arbolito.insertar(arbolito.getRaiz().getDerecha().getIzquierda(), crearDiccionario(new Persona("Felipe", 0)));
    }

    private Map<String, Object> crearDiccionario(Persona persona) {
        return persona.toDictionary();
    }
}
