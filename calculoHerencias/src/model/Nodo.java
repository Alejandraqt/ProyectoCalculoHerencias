package model;

public class Nodo {
    
    private Persona personita;
    private Nodo izquierda, derecha;

    public Nodo(Persona personita) {
        this.personita = personita;
        izquierda=null;
        derecha=null;
    }

    public Persona getPersonita() {
        return personita;
    }

    public void setPersonita(Persona personita) {
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
        System.out.println(this.getPersonita());
    }
    
}
