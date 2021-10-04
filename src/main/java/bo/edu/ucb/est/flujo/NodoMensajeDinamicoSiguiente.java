package bo.edu.ucb.est.flujo;

import bo.edu.ucb.est.Modelo.Cliente;

import java.util.HashMap;

public class NodoMensajeDinamicoSiguiente extends Nodo{

    public NodoMensajeDinamicoSiguiente(String mensaje) {
        super(mensaje);
    }

    @Override
    public Nodo run(HashMap parametros) {
        String telegramId = (String)parametros.get("telegramId");
        String inputMessage = (String)parametros.get("inputMessage");
        HashMap mapaClientes = (HashMap)parametros.get("mapaClientes");
        Nodo nodoAnterior =  (Nodo)parametros.get("nodoAnterior");
        Cliente cliente = (Cliente) parametros.get("cliente");
        if (cliente == null) {
            return null; //Termina el flujo
        }
        if ("0".equals(inputMessage)) {
            System.err.println("PRESIONASTE CERO");
            return this.getNodosSiguientes().get(0); // Esta clase muestra el mensaje y va siempre al nodo siguiente
        }
        return null; // Analizar el caso para depositar y retirar
    }
}