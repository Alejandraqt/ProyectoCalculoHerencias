package model;

import java.util.HashMap;
import java.util.Map;

public class Persona {

    private String nombre;
    private double porcentaje;
    private double porcentajeNeto;

    public Persona(String nombre) {
        this.nombre = nombre;
        this.porcentaje = 0;
        this.porcentajeNeto = 0;
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

    public double getPorcentajeNeto() {
        return porcentajeNeto;
    }

    public void setPorcentajeNeto(double porcentajeNeto) {
        this.porcentajeNeto = porcentajeNeto;
    }

    public Map<String, Object> toDictionary() {
        Map<String, Object> personaDict = new HashMap<>();
        personaDict.put("nombre", this.nombre);
        personaDict.put("porcentaje", this.porcentaje);
        personaDict.put("porcentajeNeto", this.porcentajeNeto);
        return personaDict;
    }

}
