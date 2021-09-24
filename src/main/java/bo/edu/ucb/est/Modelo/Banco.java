package bo.edu.ucb.est.Modelo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Banco {
    private String nombre;
    private String sigla;
    private  String nit;
    private String direccion;
    private HashMap <String,Cliente> clientes;

    /**
     * Métdo para agragar clientes en un banco
     * @return
     */
    public void agrgarCliente(Cliente cliente){
        this.clientes.put(cliente.getTelegramId(),cliente);
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

    public Cliente busquedaClienteId(String idCliente, String pin){
        Cliente clienteActual = clientes.get(idCliente); //Se obtiene el cliente mediante el id de telegram
        if(clienteActual.getPin() == pin){
            return clienteActual;
        }
        else{
            return null;
        }

    }
}
