package co.daniel16.pokedex.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.ListenerRegistration;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.gson.Gson;

import java.io.Serializable;
import java.util.ArrayList;

import co.daniel16.pokedex.R;
import co.daniel16.pokedex.comm.HTTPSWebUtilDomi;
import co.daniel16.pokedex.model.Pokemon;
import co.daniel16.pokedex.model.User;
import co.daniel16.pokedex.modelAPI.PokemonAPI;
import co.daniel16.pokedex.modelAPI.Stat;
import co.daniel16.pokedex.modelAPI.Type;
import co.daniel16.pokedex.view.PokemonAdapter;

public class MyPokemonsActivity extends AppCompatActivity implements View.OnClickListener {

    public static final int INVOKED_IN_LOADING = 0;
    public static final int INVOKED_LATER = 1;

    private EditText pokemonToCatchET;
    private Button catchBtn;
    private EditText searchPokemonET;
    private Button searchPokemonBtn;
    private RecyclerView pokemonsListRV;
    private LinearLayoutManager layoutManager;
    private PokemonAdapter adapter;
    private User myUser;
    private FirebaseFirestore db;
    private ListenerRegistration listener;
    private boolean searching;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_pokemons);
        pokemonToCatchET = findViewById(R.id.pokemonToCatchET);
        catchBtn = findViewById(R.id.catchBtn);
        searchPokemonET = findViewById(R.id.searchPokemonET);
        searchPokemonBtn = findViewById(R.id.searchPokemonBtn);
        pokemonsListRV = findViewById(R.id.pokemonsListRV);

        db = FirebaseFirestore.getInstance();
        myUser = (User) getIntent().getExtras().getSerializable("myUser");

        catchBtn.setOnClickListener(this);
        searchPokemonBtn.setOnClickListener(this);

        pokemonsListRV.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        pokemonsListRV.setLayoutManager(layoutManager);
        adapter = new PokemonAdapter();
        adapter.setUser(myUser);
        pokemonsListRV.setAdapter(adapter);

        searching = false;

        subscribeToPokemons();

    }

    private void subscribeToPokemons() {
        Query query = db.collection("users").whereEqualTo("id", myUser.getId());
        listener = query.addSnapshotListener( (data, error) -> {
            for(DocumentSnapshot doc : data.getDocuments()){
                myUser = doc.toObject(User.class);
                adapter.setUser(myUser);
                break;
            }
            if(!searching){
                if(!myUser.getPokemons().isEmpty()){
                    ArrayList<Pokemon> pokemons = new ArrayList<>();
                    Query q = db.collection("pokemons");
                    q.get().addOnCompleteListener(task -> {
                        for(DocumentSnapshot doc : task.getResult()) {
                            Pokemon pokemon = doc.toObject(Pokemon.class);
                            if(myUser.getPokemons().contains(pokemon.getName()))
                                pokemons.add(pokemon);
                        }
                        loadPokemonsInView(pokemons);
                    });
                } else {
                    loadPokemonsInView(new ArrayList<>());
                }
            }
        });
    }

    /*@Override
    protected void onResume() {
        if(!searching){
            if(!myUser.getPokemons().isEmpty()){
                ArrayList<Pokemon> pokemons = new ArrayList<>();
                Query q = db.collection("pokemons");
                q.get().addOnCompleteListener(task -> {
                    for(DocumentSnapshot doc : task.getResult()) {
                        Pokemon pokemon = doc.toObject(Pokemon.class);
                        if(myUser.getPokemons().contains(pokemon.getName()))
                            pokemons.add(pokemon);
                    }
                    loadPokemonsInView(pokemons);
                });
            } else {
                loadPokemonsInView(new ArrayList<>());
            }
        }
        super.onResume();
    }*/

    @Override
    protected void onDestroy() {
        listener.remove();
        super.onDestroy();
    }

    private void loadPokemonsInView(ArrayList<Pokemon> pokemons) {
        adapter.getPokemons().clear();
        adapter.addPokemons(pokemons);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.catchBtn:
                String name = pokemonToCatchET.getText().toString()
                        .toLowerCase()
                        .replaceAll(" ", "-")
                        .trim();
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
                                    db.collection("users").document(myUser.getId()).set(myUser);
                                    Toast.makeText(this, "Has atrapado a " + pokemon.getName() + "!", Toast.LENGTH_SHORT).show();
                                    break;
                                }
                            } else
                                getPokemonFromAPI(name);
                        } else
                            Toast.makeText(this, "Hubo un error al buscar este pokemon!", Toast.LENGTH_SHORT).show();
                    });
                }
                break;
            case R.id.searchPokemonBtn:
                if(searchPokemonBtn.getText().equals(">")){
                    searching = true;
                    String search = searchPokemonET.getText().toString()
                            .toLowerCase()
                            .replaceAll(" ", "-")
                            .trim();
                    searchPokemonBtn.setText("X");
                    searchPokemonET.setEnabled(false);
                    Query q = db.collection("pokemons").whereEqualTo("name", search);
                    q.get().addOnCompleteListener(task-> {
                        if (task.getResult().size() > 0) {
                            for (DocumentSnapshot doc : task.getResult()) {
                                Pokemon pokemon = doc.toObject(Pokemon.class);
                                ArrayList<Pokemon> pokList = new ArrayList<>();
                                pokList.add(pokemon);
                                loadPokemonsInView(pokList);
                                if (myUser.getPokemons().contains(pokemon.getName()))
                                    Toast.makeText(this, "Tienes a este pokemon!", Toast.LENGTH_LONG).show();
                                else
                                    Toast.makeText(this, "Aun no tienes a este pokemon!", Toast.LENGTH_LONG).show();
                                break;
                            }
                        } else
                            searchPokemonInAPI(search);
                    });
                } else {
                    searching = false;
                    searchPokemonET.setEnabled(true);
                    searchPokemonBtn.setText(">");
                    searchPokemonET.setText("");
                    if(!myUser.getPokemons().isEmpty()){
                        ArrayList<Pokemon> pokemons = new ArrayList<>();
                        Query q = db.collection("pokemons");
                        q.get().addOnCompleteListener(task -> {
                            for(DocumentSnapshot doc : task.getResult()) {
                                Pokemon pokemon = doc.toObject(Pokemon.class);
                                if(myUser.getPokemons().contains(pokemon.getName()))
                                    pokemons.add(pokemon);
                            }
                            loadPokemonsInView(pokemons);
                        });
                    } else
                        loadPokemonsInView(new ArrayList<>());
                }
        }
    }

    private void searchPokemonInAPI(String name) {
        if(!name.equals(""))
            new Thread(() -> {
                HTTPSWebUtilDomi https = new HTTPSWebUtilDomi();
                Gson gson = new Gson();
                String json = https.GETrequest("https://pokeapi.co/api/v2/pokemon/" + name + "/");
                PokemonAPI pokemon = gson.fromJson(json, PokemonAPI.class);
                if (pokemon != null) {
                    ArrayList<String> types = new ArrayList<>();
                    for (Type type : pokemon.getTypes())
                        types.add(type.getType().getName());
                    String sprite = pokemon.getSprites().getFrontDefault();
                    int def = pokemon.getStats().get(2).getBaseStat(),
                            attack = pokemon.getStats().get(1).getBaseStat(),
                            speed = pokemon.getStats().get(5).getBaseStat(),
                            life = pokemon.getStats().get(0).getBaseStat();
                    Pokemon pok = new Pokemon(name, types, sprite, def, attack, speed, life);
                    db.collection("pokemons").document(name).set(pok);
                    ArrayList<Pokemon> pokList = new ArrayList<>();
                    pokList.add(pok);
                    runOnUiThread(()->loadPokemonsInView(pokList));
                } else
                    runOnUiThread(() -> Toast.makeText(this, "Este pokemon no existe!", Toast.LENGTH_LONG).show());
            }).start();
        else
            Toast.makeText(this, "Este pokemon no existe!", Toast.LENGTH_LONG).show();
    }

    public void getPokemonFromAPI(String name) {
        if(!name.equals(""))
            new Thread(()->{
                HTTPSWebUtilDomi https = new HTTPSWebUtilDomi();
                Gson gson = new Gson();
                String json = https.GETrequest("https://pokeapi.co/api/v2/pokemon/" + name + "/");
                PokemonAPI pokemon = gson.fromJson(json, PokemonAPI.class);
                if(pokemon != null) {
                    ArrayList<String> types = new ArrayList<>();
                    for(Type type : pokemon.getTypes())
                        types.add(type.getType().getName());
                    String sprite = pokemon.getSprites().getFrontDefault();
                    int def = pokemon.getStats().get(2).getBaseStat(),
                        attack = pokemon.getStats().get(1).getBaseStat(),
                        speed = pokemon.getStats().get(5).getBaseStat(),
                        life = pokemon.getStats().get(0).getBaseStat();
                    Pokemon pok = new Pokemon(name, types, sprite, def, attack, speed, life);
                    myUser.getPokemons().add(pok.getName());
                    db.collection("pokemons").document(name).set(pok);
                    db.collection("users").document(myUser.getId()).set(myUser);
                    runOnUiThread(()->Toast.makeText(this, "Has atrapado a " + name + "!", Toast.LENGTH_SHORT).show());
                } else
                    runOnUiThread(()->Toast.makeText(this, "Este pokemon no existe!", Toast.LENGTH_LONG).show());
            }).start();
        else
            Toast.makeText(this, "Este pokemon no existe!", Toast.LENGTH_LONG).show();
    }

}