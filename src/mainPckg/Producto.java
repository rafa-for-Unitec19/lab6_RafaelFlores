/*
    Clase de Productos
 */
package mainPckg;

public class Producto {
    private int codigo, cantAzucar, cantAlcohol, numLote, cantidad;
    private String marca, nombre, colorantes, vence;
    private double precio;
    private boolean Nacional;

    public Producto() {
    }

    public Producto(int codigo, int cantAzucar, int cantAlcohol, int numLote, int cantidad, String marca, String nombre, String colorantes, double precio, String vence, boolean Nacional) {
        this.codigo = codigo;
        this.cantAzucar = cantAzucar;
        this.cantAlcohol = cantAlcohol;
        this.numLote = numLote;
        this.cantidad = cantidad;
        this.marca = marca;
        this.nombre = nombre;
        this.colorantes = colorantes;
        this.precio = precio;
        this.vence = vence;
        this.Nacional = Nacional;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setCantAzucar(int cantAzucar) {
        this.cantAzucar = cantAzucar;
    }

    public void setCantAlcohol(int cantAlcohol) {
        this.cantAlcohol = cantAlcohol;
    }

    public void setNumLote(int numLote) {
        this.numLote = numLote;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setColorantes(String colorantes) {
        this.colorantes = colorantes;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setVence(String vence) {
        this.vence = vence;
    }

    public void setNacional(boolean Nacional) {
        this.Nacional = Nacional;
    }

    public int getCodigo() {
        return codigo;
    }

    public int getCantAzucar() {
        return cantAzucar;
    }

    public int getCantAlcohol() {
        return cantAlcohol;
    }

    public int getNumLote() {
        return numLote;
    }

    public int getCantidad() {
        return cantidad;
    }

    public String getMarca() {
        return marca;
    }

    public String getNombre() {
        return nombre;
    }

    public String getColorantes() {
        return colorantes;
    }

    public double getPrecio() {
        return precio;
    }

    public String getVence() {
        return vence;
    }

    public boolean isNacional() {
        return Nacional;
    }

    @Override
    public String toString() {
        //Regresa aqui wey
        
        return nombre;
    }
    
    
}
