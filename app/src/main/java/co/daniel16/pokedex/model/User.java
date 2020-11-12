package co.daniel16.pokedex.model;

import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable {

    private String id;
    private String username;
    private ArrayList<String> pokemons;

    public User() {
    }

    public User(String id, String username) {
        this.id = id;
        this.username = username;
        this.pokemons = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public ArrayList<String> getPokemons() {
        return pokemons;
    }

    public void setPokemons(ArrayList<String> pokemons) {
        this.pokemons = pokemons;
    }
}
