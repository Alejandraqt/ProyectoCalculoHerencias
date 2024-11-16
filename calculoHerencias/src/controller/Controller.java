package controller;

import java.util.Map;

import model.Arbol;
import model.Persona;
import view.View;

public class Controller {

    Arbol arbolito = new Arbol();

    public void run() {
        View.imprimirMensajeLn("\n\n\n\n\n\n\n\n\n\n");
        View.imprimirMensajeLn("Bienvenido al Cálculo de herencias\nLa herencia se debe distribuir de la siguiente manera: \n");

        datosBase();

        arbolito.calcularHerenciaInicial(100);

        arbolito.imprimirArbol();

        View.imprimirMensajeLn("");
    }

    public void datosBase() {

        //Padre
        arbolito.insertar(crearDiccionario(new Persona("Elio")));

        // Hijos de Elio
        arbolito.insertar(arbolito.getRaiz(), crearDiccionario(new Persona("Karina")));
        arbolito.insertar(arbolito.getRaiz(), crearDiccionario(new Persona("Alex")));

        // Hijos de Karina
        arbolito.insertar(arbolito.getRaiz().getIzquierda(), crearDiccionario(new Persona("Valentina")));
        arbolito.insertar(arbolito.getRaiz().getIzquierda(), crearDiccionario(new Persona("José")));

            // Hijos de Valentina
            arbolito.insertar(arbolito.getRaiz().getIzquierda().getIzquierda(), crearDiccionario(new Persona("Laura")));
            arbolito.insertar(arbolito.getRaiz().getIzquierda().getIzquierda(), crearDiccionario(new Persona("Juan")));

        // Hijos de Alex
        arbolito.insertar(arbolito.getRaiz().getDerecha(), crearDiccionario(new Persona("Camilo")));
        arbolito.insertar(arbolito.getRaiz().getDerecha(), crearDiccionario(new Persona("María")));

            // Hijos de Camilo
            arbolito.insertar(arbolito.getRaiz().getDerecha().getIzquierda(), crearDiccionario(new Persona("Felipe")));

                // Hijos Felipe
                arbolito.insertar(arbolito.getRaiz().getDerecha().getIzquierda().getIzquierda(), crearDiccionario(new Persona("Rodri")));

                    // Hijos Rodri
                    arbolito.insertar(arbolito.getRaiz().getDerecha().getIzquierda().getIzquierda().getIzquierda(), crearDiccionario(new Persona("Ruby")));

                        // Hijos Ruby
                        arbolito.insertar(arbolito.getRaiz().getDerecha().getIzquierda().getIzquierda().getIzquierda().getIzquierda(), crearDiccionario(new Persona("Daniel")));

                            // Hijos Daniel
                            arbolito.insertar(arbolito.getRaiz().getDerecha().getIzquierda().getIzquierda().getIzquierda().getIzquierda().getIzquierda(), crearDiccionario(new Persona("Ximena")));
    }

    private Map<String, Object> crearDiccionario(Persona persona) {
        return persona.toDictionary();
    }
}
