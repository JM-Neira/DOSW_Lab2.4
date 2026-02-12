public interface ConversorMoneda {
    Moneda convertir(Moneda origen, String codigoDestino);
    double obtenerTasa(String codigoOrigen, String codigoDestino);
}
