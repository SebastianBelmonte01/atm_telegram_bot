package bo.edu.ucb.est.Modelo;

import java.util.HashMap;


//Cliente extiende de la clase Usuario
public class Cliente extends Usuario{
    private String pin;
    //private Map<String,Cuenta> cuentas;
    private HashMap<String,Cuenta> cuentas;

    public Cliente(String telegramId, String name, String pin) {
        super(telegramId, name);
        this.pin = pin;
        this.cuentas = new HashMap<>();
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
        System.out.println(cuenta.getNumero());

        cuentas.put(cuenta.getNumero(),cuenta);
    }






}
