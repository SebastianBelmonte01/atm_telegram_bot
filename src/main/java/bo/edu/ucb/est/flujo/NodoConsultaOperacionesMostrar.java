package bo.edu.ucb.est.flujo;

import bo.edu.ucb.est.Modelo.Cliente;

import java.util.HashMap;

public class NodoConsultaOperacionesMostrar extends Nodo{
    public NodoConsultaOperacionesMostrar(String mensaje) {
        super(mensaje);
    }

    @Override
    public Nodo run(HashMap parametros) {
        String telegramId = (String) parametros.get("telegramId");
        String inputMessage = (String) parametros.get("inputMessage");
        HashMap mapaClientes = (HashMap) parametros.get("mapaClientes");
        Cliente cliente = (Cliente) parametros.get("cliente");

        return null; //VOLVER A MENU PRINCIPAL

    }
}




