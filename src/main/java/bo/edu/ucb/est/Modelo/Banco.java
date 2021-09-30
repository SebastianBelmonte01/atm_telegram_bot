package bo.edu.ucb.est.Modelo;

import bo.edu.ucb.est.utilidades.Mensaje;

import java.util.HashMap;
import java.util.Map;

public class Banco {
    private String nombre;
    private String sigla;
    private  String nit;
    private String direccion;
    private HashMap <String,Cliente> clientes;

    /**
     * Métdo para agragar clientes en un banco dentro del mapa de tipo cliente
     * @return
     */
    public void agregarCliente(Cliente cliente){
        this.clientes.put(cliente.getIdCliente(),cliente);
    }

    public Banco(String nombre, String sigla, String nit, String direccion) {
        this.nombre = nombre;
        this.sigla = sigla;
        this.nit = nit;
        this.direccion = direccion;
        this.clientes = new HashMap<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Map<String, Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(HashMap<String, Cliente> clientes) {
        this.clientes = clientes;
    }


    public Mensaje busquedaClienteId(String idCliente) {
        Cliente clienteActual = clientes.get(idCliente); //Se obtiene el cliente mediante el id de telegram
        Mensaje m = new Mensaje();
        if (clienteActual != null) {
                m.setEstado("OK");
                m.setEntidad(clienteActual);
                return m;
        } else {
            m.setEstado("NOK");
            m.setMensaje("Cliente no encontrado.");
            return m;
        }
    }
    public Mensaje busquedaCliente(String idCliente, String pin) {
        Cliente clienteActual = clientes.get(idCliente); //Se obtiene el cliente mediante el id de telegram
        Mensaje m = new Mensaje();
        if (clienteActual != null) {
            if (clienteActual.getPin().equals(pin)) {

                m.setEstado("OK");
                m.setEntidad(clienteActual);
                return m;
            } else {

                m.setEstado("NOK");
                m.setMensaje("PIN incorrecto");
                return m;
            }

        } else {
            m.setEstado("NOK");
            m.setMensaje("Cliente no encontrado.");
            return m;
        }
    }

}
