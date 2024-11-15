package model;

import java.util.Map;

import view.*;

public class Nodo {
    
    private Map<String, Object> personita;
    private Nodo izquierda, derecha;

    public Nodo(Map<String, Object> personita) {
        this.personita = personita;
        izquierda=null;
        derecha=null;
    }

    public Map<String, Object> getPersonita() {
        return personita;
    }

    public void setPersonita(Map<String, Object> personita) {
        this.personita = personita;
    }

    public Nodo getIzquierda() {
        return izquierda;
    }

    public void setIzquierda(Nodo izquierda) {
        this.izquierda = izquierda;
    }

    public Nodo getDerecha() {
        return derecha;
    }

    public void setDerecha(Nodo derecha) {
        this.derecha = derecha;
    }
   
    public void imprimirPersonita() {
        String nombre = (String) personita.get("nombre");
        double porcentaje = (double) personita.get("porcentaje");
        View.imprimirMensajeLn(nombre + " (" + porcentaje + "%)");
    }
    
}
