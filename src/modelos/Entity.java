package modelos;

public abstract class Entity {
    protected String user;
    protected String password;

    public Entity() {
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }
}
