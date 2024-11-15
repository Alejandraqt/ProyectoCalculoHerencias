package model;

import java.util.Map;

import view.View;

public class Arbol {

    private Nodo raiz;

    public Arbol() {
       this.raiz = null;
    }

    public boolean existe(Persona busqueda) {
        return existe(this.raiz, busqueda);
    }

    public boolean existe(Nodo nodito, Persona busqueda) {

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

    public void insertar(Map<String, Object> personita ) {
        if (this.raiz == null) {
            this.raiz = new Nodo(personita);
        } else {
            insertar(this.raiz, personita);
        }
    }

    public void insertar(Nodo padre, Map<String, Object> personita) {
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

    public Nodo getRaiz() {
        return raiz;
    }

    public void setRaiz(Nodo raiz) {
        this.raiz = raiz;
    }

    public void imprimirArbol() {
        imprimirArbolRecursivo(raiz, "", true);
    }
    
    private void imprimirArbolRecursivo(Nodo nodo, String prefijo, boolean esUltimo) {

        if (nodo != null) {
            View.imprimirMensajeNoLn(prefijo);
    
            // Cambia el prefijo para mostrar una línea si no es el último nodo
            View.imprimirMensajeNoLn(esUltimo ? "└── " : "├── ");
            View.imprimirMensajeLn(nodo.getPersonita().get("nombre") + " (" + nodo.getPersonita().get("porcentaje") + "%)");
    
            // Construir el prefijo para los nodos hijos
            prefijo += esUltimo ? "    " : "│   ";
    
            // Llamada recursiva para los hijos izquierdo y derecho
            imprimirArbolRecursivo(nodo.getIzquierda(), prefijo, nodo.getDerecha() == null);
            imprimirArbolRecursivo(nodo.getDerecha(), prefijo, true);
        }
    }

    public void calcularHerenciaInicial(double porcentajeInicial) {
        if (raiz != null) {
            raiz.getPersonita().put("porcentaje", porcentajeInicial); //Establece el porcentaje de la raíz
            calcularHerencia(raiz);
        }
    }

    private void calcularHerencia(Nodo nodo) {
        if (nodo == null) {
            return;
        }
        
        int numHijos = 0;
        if (nodo.getIzquierda() != null) numHijos++;
        if (nodo.getDerecha() != null) numHijos++;
        
        if (numHijos > 0) {
            double porcentajePorHijo = (double) nodo.getPersonita().get("porcentaje")/ numHijos;
            
            if (nodo.getIzquierda() != null) {
                nodo.getIzquierda().getPersonita().put("porcentaje", porcentajePorHijo);
                calcularHerencia(nodo.getIzquierda());
            }
    
            if (nodo.getDerecha() != null) {
                nodo.getDerecha().getPersonita().put("porcentaje", porcentajePorHijo);
                calcularHerencia(nodo.getDerecha());
            }
            
        }
    }   
}
 

