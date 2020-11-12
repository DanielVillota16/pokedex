package co.daniel16.pokedex.model;

import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable {

    private String id;
    private String username;
    private ArrayList<Pokemon> pokemons;

    public User() {
    }

    public User(String id, String username, ArrayList<Pokemon> pokemons) {
        this.id = id;
        this.username = username;
        this.pokemons = pokemons;
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

    public ArrayList<Pokemon> getPokemons() {
        return pokemons;
    }

    public void setPokemons(ArrayList<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }
}
