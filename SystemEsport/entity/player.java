package SystemEsport.entity;

import java.util.HashSet;
import java.util.Set;

public class player {

    private String id;
    private String role;
    private String namePlayer;

    private Set<player> dataTim = new HashSet<>();

    public player(String id, String role, String namePlayer) {
        this.id = id;
        this.role = role;
        this.namePlayer = namePlayer;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getNamePlayer() {
        return namePlayer;
    }

    public void setNamePlayer(String namePlayer) {
        this.namePlayer = namePlayer;
    }

}
 
