package bo.edu.ucb.est.Modelo;

public class Usuario {
    private String telegramId;
    private String name;

    public Usuario(String telegramId, String name) {
        this.telegramId = telegramId;
        this.name = name;
    }

    public String getTelegramId() {
        return telegramId;
    }

    public void setTelegramId(String telegramId) {
        this.telegramId = telegramId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
