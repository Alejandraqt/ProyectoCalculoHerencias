package model;

import java.util.Map;

import view.View;

public class Arbol {

    private Nodo raiz;
    private boolean primeraVez;
    double porcentajeParaHijos;
    double porcentajePorHijo;

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
            
            // Muestra el porcentaje recibido y el neto (porcentaje recibido menos lo que se reparte)
            double porcentajeRecibido = (double) nodo.getPersonita().get("porcentaje");
            double porcentajeNeto = (double) nodo.getPersonita().get("porcentajeNeto");
            
            View.imprimirMensajeLn(nodo.getPersonita().get("nombre") + " (" + porcentajeRecibido + "% - Neto: " + porcentajeNeto + "%)");
            
            // Construir el prefijo para los nodos hijos
            prefijo += esUltimo ? "    " : "│   ";
            
            // Llamada recursiva para los hijos izquierdo y derecho
            imprimirArbolRecursivo(nodo.getIzquierda(), prefijo, nodo.getDerecha() == null);
            imprimirArbolRecursivo(nodo.getDerecha(), prefijo, true);
        }
    }

    public void calcularHerenciaInicial(double porcentajeInicial) {
        if (raiz != null) {
            if(primeraVez){
                // El porcentaje para los hijos es la herencia inicial completa
                porcentajeParaHijos = porcentajeInicial;
                primeraVez = false;
            }
            // la raiz no conserva nada, su porcentaje se reparte entre sus hijos
            raiz.getPersonita().put("porcentaje", 0.0);
            
            // Reparte el 50% entre los hijos de la raiz
            repartirEntreHijos(raiz, porcentajeInicial);
        }
    }
    
    private void repartirEntreHijos(Nodo nodo, double porcentajePadre) {
        if (nodo == null) {
            return;
        }
    
        int numHijos = 0;
    
        // Cuenta los hijos del nodo actual
        if (nodo.getIzquierda() != null) numHijos++;
        if (nodo.getDerecha() != null) numHijos++;
    
        // Si el nodo tiene hijos, distribuye la herencia entre ellos
        if (numHijos > 0) {
            // Los hijos reciben la mitad de la herencia del padre
            double porcentajeParaHijos = porcentajePadre; // 100% de la herencia de la raiz
            double porcentajePorHijo = porcentajeParaHijos / numHijos; // Divide la herencia entre los hijos
    
            // Asigna el porcentaje a los hijos
            if (nodo.getIzquierda() != null) {
                nodo.getIzquierda().getPersonita().put("porcentaje", porcentajePorHijo);
                // Calcula el porcentaje neto del hijo
                double porcentajeNeto = porcentajePorHijo / 2;
                nodo.getIzquierda().getPersonita().put("porcentajeNeto", porcentajeNeto);
                // Llama a repartir la herencia entre los nietos
                repartirEntreNietos(nodo.getIzquierda(), porcentajePorHijo);
            }
    
            if (nodo.getDerecha() != null) {
                nodo.getDerecha().getPersonita().put("porcentaje", porcentajePorHijo);
                // Calcula el porcentaje neto del hijo
                double porcentajeNeto = porcentajePorHijo / 2;
                nodo.getDerecha().getPersonita().put("porcentajeNeto", porcentajeNeto);
                // Llama a repartir la herencia entre los nietos
                repartirEntreNietos(nodo.getDerecha(), porcentajePorHijo);
            }
        }
    }
    
    // Método para distribuir la mitad de lo que reciben los hijos entre sus hijos (los nietos)
    private void repartirEntreNietos(Nodo nodo, double porcentajePadre) {
        if (nodo == null) {
            return;
        }
    
        int numHijos = 0;
    
        // Cuenta los hijos del nodo actual
        if (nodo.getIzquierda() != null) numHijos++;
        if (nodo.getDerecha() != null) numHijos++;
    
        // Si el nodo tiene hijos, distribuye la herencia entre ellos
        if (numHijos > 0) {
            // La mitad de lo que recibe el hijo se reparte entre los nietos
            double porcentajeParaNietos = porcentajePadre / 2; // Solo la mitad se reparte entre los nietos
            double porcentajePorNieto = porcentajeParaNietos / numHijos; // Divide entre los nietos
    
            // Asigna el porcentaje a los nietos y calcula el porcentaje neto
            if (nodo.getIzquierda() != null) {
                nodo.getIzquierda().getPersonita().put("porcentaje", porcentajePorNieto);
                // El porcentaje neto para el nieto es la mitad de lo que recibe
                double porcentajeNetoNieto = porcentajePorNieto / 2;
                nodo.getIzquierda().getPersonita().put("porcentajeNeto", porcentajeNetoNieto);
                // Llama recursivamente para repartir entre los nietos de los nietos (si los hay)
                repartirEntreNietos(nodo.getIzquierda(), porcentajePorNieto);
            }
    
            if (nodo.getDerecha() != null) {
                nodo.getDerecha().getPersonita().put("porcentaje", porcentajePorNieto);
                // El porcentaje neto para el nieto es la mitad de lo que recibe
                double porcentajeNetoNieto = porcentajePorNieto / 2;
                nodo.getDerecha().getPersonita().put("porcentajeNeto", porcentajeNetoNieto);
                // Llama recursivamente para repartir entre los nietos de los nietos (si los hay)
                repartirEntreNietos(nodo.getDerecha(), porcentajePorNieto);
            }
        } else {
            // Si el nodo no tiene hijos, se asigna el porcentaje sin dividirlo
            nodo.getPersonita().put("porcentajeNeto", porcentajePadre);
            nodo.getPersonita().put("porcentaje", porcentajePadre);
        }
    }
}
 

