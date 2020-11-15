package co.daniel16.pokedex.view;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import co.daniel16.pokedex.R;
import co.daniel16.pokedex.activities.SelectedPokemonActivity;
import co.daniel16.pokedex.model.Pokemon;
import co.daniel16.pokedex.model.User;

public class PokemonView extends RecyclerView.ViewHolder implements View.OnClickListener{

    private ConstraintLayout root;
    private ImageView pokeImg;
    private TextView pokeName;
    private Pokemon pokemon;
    private User user;

    public PokemonView(@NonNull ConstraintLayout root) {
        super(root);
        this.root = root;
        this.root.setOnClickListener(this);
        pokeImg = root.findViewById(R.id.pokeImg);
        pokeName = root.findViewById(R.id.pokeNameTV);
    }

    public void setPokemon(Pokemon pokemon) {
        this.pokemon = pokemon;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void loadMedia(){
        if(pokemon != null) {
            pokeName.setText(pokemon.getName());
            Glide.with(root).load(pokemon.getSprite()).into(pokeImg);
        } else Toast.makeText(root.getContext(), "No se ha podido cargar la imagen de: " + pokemon.getName(), Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==root.getId()){
            Intent intent = new Intent(root.getContext(), SelectedPokemonActivity.class);
            intent.putExtra("pokemon", pokemon);
            intent.putExtra("user", user);
            root.getContext().startActivity(intent);
        }
    }
}
