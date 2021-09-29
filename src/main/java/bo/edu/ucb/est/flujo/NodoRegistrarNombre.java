package bo.edu.ucb.est.flujo;

import bo.edu.ucb.est.Modelo.Cliente;

import java.util.HashMap;

public class NodoRegistrarNombre extends Nodo {
    public NodoRegistrarNombre(String mensaje) {
        super(mensaje);
    }

    @Override
    public Nodo run(HashMap parametros) {
        String telegramId = (String)parametros.get("telegramId");
        String inputMessage = (String)parametros.get("inputMessage");
        HashMap mapaClientes = (HashMap)parametros.get("mapaClientes");
        Cliente nuevoCliente = new Cliente(telegramId,inputMessage,null); //PIN null ya que solo es el mensaje de inicioi
        mapaClientes.put(nuevoCliente.getIdCliente(),nuevoCliente);



        return this.nodosSiguientes.get(0);
    }
}
