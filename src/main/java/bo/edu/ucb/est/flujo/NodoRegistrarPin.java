package bo.edu.ucb.est.flujo;

import bo.edu.ucb.est.Modelo.Cliente;

import java.util.HashMap;
import java.util.Iterator;

public class NodoRegistrarPin extends Nodo{

    public NodoRegistrarPin(String mensaje) {
        super(mensaje);
    }

    @Override
    public Nodo run(HashMap parametros) {
        String telegramId = (String)parametros.get("telegramId");
        String inputMessage = (String)parametros.get("inputMessage");
        HashMap<String, Cliente> mapaClientes = (HashMap<String,Cliente>)parametros.get("mapaClientes");
        Cliente cliente ;
        Iterator it = mapaClientes.values().iterator();
        while (it.hasNext()) {
            Object obj = it.next();
            System.out.println("obj:"+ obj);

            cliente = (Cliente)obj;
            if (telegramId.equals(cliente.getTelegramId())) {
                cliente.setPin(inputMessage);
                return null; // nodo existe cliente
            }
        }
        return null;

    }
}