package bo.edu.ucb.est.flujo;
import bo.edu.ucb.est.Modelo.Cliente;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Iterator;

public class Nodo {
    //idNodo
    private int idNodo;
    //nombre del nodo
    private String nombre;
    //Mensaje que muestra el nodo
    private String mensaje;
    //Nodos siguientes
    HashMap<Integer,Nodo> nodosSiguientes;

    public Nodo() {
        //creamos el mapa para asignar los nodos siguientes
        nodosSiguientes = new HashMap<Integer,Nodo>();
    }

    public Nodo(String mensaje) {
        this.mensaje = mensaje;
        nodosSiguientes = new HashMap<Integer,Nodo>();
    }

    public Nodo run(HashMap parametros) {
        return null;
    }

    public int getIdNodo() {
        return idNodo;
    }

    public void setIdNodo(int idNodo) {
        this.idNodo = idNodo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMensaje(String...parametros) {
        if(parametros!=null){
            return MessageFormat.format(this.mensaje,parametros);
        }
        else{
            return mensaje;
        }
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public HashMap<Integer, Nodo> getNodosSiguientes() {
        return nodosSiguientes;
    }

    public void setNodo(HashMap<Integer, Nodo> nodos) {
        this.nodosSiguientes = nodos;
    }

    public Cliente buscarCliente(HashMap mapaClientes,String telegramId) {
        Cliente cliente ;
        Iterator it = mapaClientes.values().iterator();
        while (it.hasNext()) {
            cliente = (Cliente)it.next();
            if (telegramId.equals(cliente.getTelegramId())) {
                return cliente; // Existe cliente
            }
        }
        return null; // No existe cliente
    }
}