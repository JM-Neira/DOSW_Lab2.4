
=======
# DOSW_Lab2.4
implementacion del reto 4 con la ayuda de la herramienta maven 
grupo de trabajo: Juan Neira, Daniel Ahumada, Juan torres

# RETO 4: La Estafa de la Casa de Cambio

**Patrón de Diseño:** Adapter  

---

## Objetivo

Implementar el patrón Adapter para adaptar un servicio antiguo de conversión de monedas (con interfaz incompatible) a un nuevo sistema estándar

---

## Patrón Adapter

### Componentes:

1. **Target (Interfaz objetivo):** `ConversorMoneda`
   - Define la interfaz que el cliente espera usar

2. **Adaptee (Servicio antiguo):** `ServicioTasasCambio`
   - Servicio existente con interfaz incompatible

3. **Adapter:** `AdaptadorConversorMoneda`
   - Adapta ServicioTasasCambio a ConversorMoneda
   - Traduce llamadas entre interfaces

4. **Client:** `CasaCambio`
   - Usa la interfaz ConversorMoneda
   - Desconoce la implementación subyacente

### Problema resuelto:
El antiguo dueño "El Gringo" usaba una sola tasa para todas las conversiones (estafa). Ahora cada par de monedas tiene su tasa real y correcta.

---

