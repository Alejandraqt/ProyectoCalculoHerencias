package model;

public class Arbol {

    private Nodo raiz;
    private boolean primeraVez;
    private double porcentajeParaHijos;
    private double porcentajePorHijo;

    public Arbol() {
       this.raiz = new Nodo();
    }

    public Nodo getRaiz() {
        return raiz;
    }

    public void setRaiz(Nodo raiz) {
        this.raiz = raiz;
    }

    public boolean isPrimeraVez() {
        return primeraVez;
    }

    public void setPrimeraVez(boolean primeraVez) {
        this.primeraVez = primeraVez;
    }

    public double getPorcentajeParaHijos() {
        return porcentajeParaHijos;
    }

    public void setPorcentajeParaHijos(double porcentajeParaHijos) {
        this.porcentajeParaHijos = porcentajeParaHijos;
    }

    public double getPorcentajePorHijo() {
        return porcentajePorHijo;
    }

    public void setPorcentajePorHijo(double porcentajePorHijo) {
        this.porcentajePorHijo = porcentajePorHijo;
    }

}
 

