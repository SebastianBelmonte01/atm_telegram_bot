package bo.edu.ucb.est.utilidades;

public class Mensaje {
    private String estado;
    private String mensaje;

    private Object entidad;

    public Object getEntidad() {
        return entidad;
    }

    public void setEntidad(Object entidad) {
        this.entidad = entidad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public String toString() {
        return "Mensaje{" +
                "estado='" + estado + '\'' +
                ", mensaje='" + mensaje + '\'' +
                ", entidad=" + entidad +
                '}';
    }
}
