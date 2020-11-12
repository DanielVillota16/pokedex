package co.daniel16.pokedex.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

import co.daniel16.pokedex.R;

public class MyPokemonsActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText pokemonToCatchET;
    private Button catchBtn;
    private EditText searchPokemonET;
    private Button searchPokemonBtn;
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
        catchBtn.setOnClickListener(this);
        searchPokemonBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.catchBtn:
                String name = pokemonToCatchET.getText().toString();
                CollectionReference usersRef = db.collection("pokemons");
                Query query = usersRef.whereEqualTo("name", name);

                break;
        }
    }
}