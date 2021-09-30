package bo.edu.ucb.est.flujo;

import bo.edu.ucb.est.Modelo.Cliente;

import java.util.HashMap;

public class NodoMensajeDinamico extends Nodo{

    public NodoMensajeDinamico(String mensaje) {
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
            return this.getNodosSiguientes().get(0); // para que vuelva a NodoSeleccion
        }
        return null; // Analizar el caso para depositar y retirar
    }
}
