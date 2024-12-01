package controller;

import java.util.Map;

import model.Arbol;
import model.Nodo;
import model.Persona;
import view.View;

public class Controller {

    Arbol arbolito = new Arbol();
    Nodo raiz;
    Map<String, Object> datosPersona;
    Map<String, Nodo> hijos;
    int cedulaHijoSeleccionado;


    public void run() {
        View.imprimirMensajeLn("\n\n\n\n\n\n\n\n\n\n");
        View.imprimirMensajeLn("Bienvenido al Cálculo de herencias\nLa herencia se debe distribuir de la siguiente manera: \n");

        raiz = arbolito.getRaiz();
        datosPersona = raiz.getDatosPersona();
        hijos = raiz.getHijos();
        
        datosBase();

        View.imprimirMensajeLn(" <> FIN <>");
    }

    public void crearHijo(){
        String nombre = "";
        String cedula = "";
        
        Persona persona = new Persona(nombre, cedula);
        persona.crearDiccionario();
        

        raiz.getHijos();

    }

    public void insertarDatospersona(){

    }
    
    public void datosBase() {


        
    }

}
