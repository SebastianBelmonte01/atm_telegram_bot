package bo.edu.ucb.est.flujo;

import bo.edu.ucb.est.Modelo.Cliente;

import java.util.HashMap;

public class NodoRaiz extends Nodo{

    public NodoRaiz(String mensaje) {
        super(mensaje);
    }
    public NodoRaiz() {
        super();
    }

    @Override
    public Nodo run(HashMap parametros) {
        String telegramId = (String)parametros.get("telegramId");
        HashMap mapaClientes = (HashMap)parametros.get("mapaClientes");
        Cliente cliente = super.buscarCliente(mapaClientes,telegramId);
        if (cliente == null) {
            return this.getNodosSiguientes().get(0); // Nodo NO existe cliente
        } else {
            return this.getNodosSiguientes().get(1); // Nodo existe cliente
        }
    }
}