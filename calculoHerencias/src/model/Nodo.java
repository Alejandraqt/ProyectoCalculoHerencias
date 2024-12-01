package model;

import java.util.HashMap;
import java.util.Map;

public class Nodo {
    
    private Map<String, Object> datosPersona;
    private Map <String, Nodo> hijos;

    public Nodo() {
        this.datosPersona = new HashMap<>();
        this.hijos = new HashMap<>();
    }

    public Map<String, Object> getDatosPersona() {
        return datosPersona;
    }

    public void setDatosPersona(Map<String, Object> datosPersona) {
        this.datosPersona = datosPersona;
    }

    public Map<String, Nodo> getHijos() {
        return hijos;
    }

    public void setHijos(Map<String, Nodo> hijos) {
        this.hijos = hijos;
    }
    
}
