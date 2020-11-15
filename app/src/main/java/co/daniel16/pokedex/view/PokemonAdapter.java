package co.daniel16.pokedex.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import co.daniel16.pokedex.R;
import co.daniel16.pokedex.activities.MyPokemonsActivity;
import co.daniel16.pokedex.model.Pokemon;
import co.daniel16.pokedex.model.User;

public class PokemonAdapter extends RecyclerView.Adapter<PokemonView> {

    private ArrayList<Pokemon> pokemons;
    private User user;

    public PokemonAdapter(){
        this.pokemons = new ArrayList<>();
    }

    public PokemonAdapter(ArrayList<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    public void addPokemons(ArrayList<Pokemon> pokemons){
        this.pokemons.addAll(pokemons);
        this.notifyDataSetChanged();
    }

    public void addPokemon(Pokemon pokemon){
        this.pokemons.add(pokemon);
        this.notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PokemonView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View row = inflater.inflate(R.layout.pokemonrow, parent, false);
        ConstraintLayout rowroot = (ConstraintLayout) row;
        PokemonView pokemonView = new PokemonView(rowroot);
        return pokemonView;
    }

    @Override
    public void onBindViewHolder(@NonNull PokemonView holder, int position) {
        holder.setPokemon(pokemons.get(position));
        holder.setUser(user);
        holder.loadMedia();
    }

    @Override
    public int getItemCount() {
        return pokemons.size();
    }

    public ArrayList<Pokemon> getPokemons() {
        return pokemons;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
