package bo.edu.ucb.est.flujo;

import bo.edu.ucb.est.Modelo.Cliente;

import java.util.HashMap;
import java.util.Iterator;

public class NodoVerificarPin extends Nodo {
    public NodoVerificarPin(String mensaje) {
        super(mensaje);
    }

    @Override
    public Nodo run(HashMap parametros) {
        String telegramId = (String)parametros.get("telegramId");
        String inputMessage = (String)parametros.get("inputMessage");
        HashMap mapaClientes = (HashMap)parametros.get("mapaClientes");
        Cliente cliente;
        Iterator it = mapaClientes.values().iterator();
        while (it.hasNext()) {
            cliente = (Cliente)it.next();
            if (telegramId.equals(cliente.getTelegramId())) {
                if (inputMessage.equals(cliente.getPin())) {
                    return this.getNodosSiguientes().get(0); // pin es correcto
                }
                return this.getNodosSiguientes().get(1); // pin incorrecto
            }
        }



        return this.nodosSiguientes.get(0);
    }

}
