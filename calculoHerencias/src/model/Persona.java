package model;

import java.util.HashMap;
import java.util.Map;

public class Persona {

    private String nombre;
    private double porcentaje;

    public Persona(String nombre, double porcentaje) {
        this.nombre = nombre;
        this.porcentaje = porcentaje;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(double porcentaje) {
        this.porcentaje = porcentaje;
    }

    public Map<String, Object> toDictionary() {
        Map<String, Object> personaDict = new HashMap<>();
        personaDict.put("nombre", this.nombre);
        personaDict.put("porcentaje", this.porcentaje);
        return personaDict;
    }

}
