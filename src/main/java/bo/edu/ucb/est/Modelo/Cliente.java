package bo.edu.ucb.est.Modelo;

import bo.edu.ucb.est.utilidades.Mensaje;

import java.util.HashMap;


//Cliente extiende de la clase Usuario
public class Cliente extends Usuario{
    private String pin;

    private HashMap<String,Cuenta> cuentas;
    private String idCliente;
    private static int indice = 10000;

    public Cliente(String idTelegram, String name, String pin) {
        super(idTelegram, name);
        idCliente = "IDC"+(indice++);
        this.pin = pin;
        this.cuentas = new HashMap<>();
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public HashMap<String, Cuenta> getCuentas() {
        return cuentas;
    }

    public void setCuentas(HashMap<String, Cuenta> cuentas) {
        this.cuentas = cuentas;
    }

    /**
     * Método para agregar cuentas con un mapa mediante el número de cuenta
     * @return
     */




    public void agregarCuenta(Cuenta cuenta){
        cuentas.put(cuenta.getNumero(),cuenta);
    }

    public Mensaje busquedaCuentaId(String idCuenta){

        Cuenta cuentaActual = cuentas.get(idCuenta);
        Mensaje m = new Mensaje();
        if(cuentaActual != null){
                m.setEstado("OK");
                m.setEntidad(cuentaActual);
                return m;
        }
        else{
            m.setEstado("NOK");
            m.setMensaje("Cuenta no encontrada.");
            return m;
        }

    }


    @Override
    public String toString() {
        return "Cliente{" +
                "pin='" + pin + '\'' +
                ", cuentas=" + cuentas +
                ", idCliente='" + idCliente + '\'' +
                '}';
    }
}
