package co.daniel16.pokedex.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.HashMap;

import co.daniel16.pokedex.R;
import co.daniel16.pokedex.comm.HTTPSWebUtilDomi;
import co.daniel16.pokedex.model.Pokemon;
import co.daniel16.pokedex.model.User;
import co.daniel16.pokedex.modelAPI.PokemonAPI;

public class MyPokemonsActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText pokemonToCatchET;
    private Button catchBtn;
    private EditText searchPokemonET;
    private Button searchPokemonBtn;
    private User myUser;
    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_pokemons);
        pokemonToCatchET = findViewById(R.id.pokemonToCatchET);
        catchBtn = findViewById(R.id.catchBtn);
        searchPokemonET = findViewById(R.id.searchPokemonET);
        searchPokemonBtn = findViewById(R.id.searchPokemonBtn);
        db = FirebaseFirestore.getInstance();
        myUser = (User) getIntent().getExtras().getSerializable("myUser");
        catchBtn.setOnClickListener(this);
        searchPokemonBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.catchBtn:
                String name = pokemonToCatchET.getText().toString().toLowerCase();
                boolean alreadyCaught = myUser.getPokemons().contains(name);
                if (alreadyCaught) {
                    Toast.makeText(this, "Ya tienes a este Pokemon!", Toast.LENGTH_LONG).show();
                } else {
                    Query query = db.collection("pokemons").whereEqualTo("name", name);
                    query.get().addOnCompleteListener(task -> {
                        if (task.isSuccessful()) {
                            if (task.getResult().size() > 0) {
                                for(QueryDocumentSnapshot document : task.getResult()){
                                    Pokemon pokemon = document.toObject(Pokemon.class);
                                    myUser.getPokemons().add(pokemon.getName());
                                    break;
                                }
                            } else {
                                getPokemonFromAPI(name);
                            }
                        }
                    });
                }
                break;
        }
    }

    public void getPokemonFromAPI(String name) {
        new Thread(()->{
            HTTPSWebUtilDomi https = new HTTPSWebUtilDomi();
            Gson gson = new Gson();
            String json = https.GETrequest("https://pokeapi.co/api/v2/pokemon/" + name);
            Type type = new TypeToken<HashMap<String, String>>(){}.getType();
            PokemonAPI pokemon = gson.fromJson(json, PokemonAPI.class);
            if(pokemon != null) Log.e(">>>", pokemon.getName() + " >> " + pokemon.getTypes());
            else Log.e("ERROR >>>", "pokemon not found, problem when trying to GET " + name + " Pokemon object");
        }).start();
    }

}