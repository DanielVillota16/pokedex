package co.daniel16.pokedex.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.firebase.firestore.FirebaseFirestore;

import co.daniel16.pokedex.R;
import co.daniel16.pokedex.model.Pokemon;
import co.daniel16.pokedex.model.User;

public class SelectedPokemonActivity extends AppCompatActivity implements View.OnClickListener {

    private Pokemon pokemon;
    private User user;
    private Button freeBtn;
    private ImageView pokemonImg;
    private TextView nameTV;
    private TextView typeTV;
    private TextView defenseTV;
    private TextView attackTV;
    private TextView speedTV;
    private TextView lifeTV;
    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected_pokemon);

        freeBtn = findViewById(R.id.freeBtn);
        pokemonImg = findViewById(R.id.pokemonImg);
        nameTV = findViewById(R.id.nameTV);
        typeTV = findViewById(R.id.typeTV);
        defenseTV = findViewById(R.id.defenseTV);
        attackTV = findViewById(R.id.attackTV);
        speedTV = findViewById(R.id.speedTV);
        lifeTV = findViewById(R.id.lifeTV);

        pokemon = (Pokemon) getIntent().getExtras().getSerializable("pokemon");
        user = (User) getIntent().getExtras().getSerializable("user");
        db = FirebaseFirestore.getInstance();

        freeBtn.setOnClickListener(this);
        String url = pokemon.getSprite();
        Glide.with(this).load(url).fitCenter().into(pokemonImg);
        nameTV.setText(pokemon.getName());
        typeTV.setText(pokemon.getType().toString().replace("[", "").replace("]",""));
        defenseTV.setText(pokemon.getDefense()+"");
        attackTV.setText(pokemon.getAttack()+"");
        speedTV.setText(pokemon.getSpeed()+"");
        lifeTV.setText(pokemon.getLife()+"");

    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.freeBtn) {
            boolean removed = user.getPokemons().remove(pokemon.getName());
            if(removed){
                db.collection("users").document(user.getId()).set(user);
                Toast.makeText(this, pokemon.getName() + " ha sido liberado!", Toast.LENGTH_LONG).show();
                freeBtn.setClickable(false);
            } else Toast.makeText(this, "No se puede soltar porque no tienes a este pokemon!", Toast.LENGTH_LONG).show();
        }
    }

}