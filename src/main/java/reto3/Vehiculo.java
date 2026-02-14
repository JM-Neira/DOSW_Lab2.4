public abstract class Vehiculo {
    protected String modelo;
    protected int precio;
    protected int velocidadMaxima;

    public Vehiculo(String modelo, int precio, int velocidadMaxima) {
        this.modelo = modelo;
        this.precio = precio;
        this.velocidadMaxima = velocidadMaxima;
    }

    public String getModelo() {
        return modelo;
    }

    public int getPrecio() {
        return precio;
    }

    public int getVelocidadMaxima() {
        return velocidadMaxima;
    }

    public abstract String getTipo();
}