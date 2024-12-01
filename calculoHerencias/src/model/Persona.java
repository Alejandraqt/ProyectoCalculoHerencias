package model;

import java.util.HashMap;
import java.util.Map;

public class Persona {

    private String nombre;
    private String cedula;
    private double porcentaje;
    private double porcentajeNeto;

    public Persona(String nombre, String cedula) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.porcentaje = 0;
        this.porcentajeNeto = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
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

    public Map<String, Object> crearDiccionario() {
        Map<String, Object> datosPersona = new HashMap<>();
        datosPersona.put("nombre", this.nombre);
        datosPersona.put("cedula", this.cedula);
        datosPersona.put("porcentaje", this.porcentaje);
        datosPersona.put("porcentajeNeto", this.porcentajeNeto);
        return datosPersona;
    }

}
