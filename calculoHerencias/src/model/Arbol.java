package model;

import treestring.NodoCadena;

public class Arbol {

    private Nodo raiz;

    public Arbol() {
       this.raiz = null;
    }

    public boolean existe(Persona busqueda) {
        return existe(this.raiz, busqueda);
    }

    private boolean existe(Nodo nodito, Persona busqueda) {

        if (nodito == null) {
            return false;
        }
        if (nodito.getPersonita() == busqueda) {
            return true;
        } else if (busqueda.equals(nodito.getIzquierda().getPersonita())) {
            return existe(nodito.getIzquierda(), busqueda);
        } else if (busqueda.equals(nodito.getDerecha().getPersonita())) {
            return existe(nodito.getDerecha(), busqueda);
        }else{
            return false;
        }

    }

    public void insertar(Persona personita) {
        if (this.raiz == null) {
            this.raiz = new Nodo(personita);
        } else {
            insertar(this.raiz, personita);
        }
    }

    private void insertar(Nodo padre, Persona personita) {
        if (padre.getIzquierda() == null) {
            padre.setIzquierda(new Nodo(personita));
        } else if (padre.getDerecha() == null) {
            padre.setDerecha(new Nodo(personita));
        } else {
            insertar(padre.getIzquierda(), personita);
        }
    }

    private void preOrden(Nodo n) {
        if (n != null) {
            n.imprimirPersonita();
            preOrden(n.getIzquierda());
            preOrden(n.getDerecha());
        }
    }

    private void inOrden(Nodo n) {
        if (n != null) {
            inOrden(n.getIzquierda());
            n.imprimirPersonita();
            inOrden(n.getDerecha());
        }
    }

    private void postOrden(Nodo n) {
        if (n != null) {
            postOrden(n.getIzquierda());
            postOrden(n.getDerecha());
            n.imprimirPersonita();
        }
    }

    public void preorden() {
        this.preOrden(this.raiz);
    }

    public void inorden() {
        this.inOrden(this.raiz);
    }

    public void postorden() {
        this.postOrden(this.raiz);
    }
}
 

