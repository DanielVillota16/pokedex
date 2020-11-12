package co.daniel16.pokedex.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;

import java.util.ArrayList;
import java.util.UUID;

import co.daniel16.pokedex.R;
import co.daniel16.pokedex.model.User;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText usernameET;
    private Button loginBtn;
    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameET = findViewById(R.id.usernameET);
        loginBtn = findViewById(R.id.loginBtn);
        loginBtn.setOnClickListener(this);

        db = FirebaseFirestore.getInstance();
    }


    @Override
    public void onClick(View view) {
        String username = usernameET.getText().toString();
        CollectionReference usersRef = db.collection("users");
        Query query = usersRef.whereEqualTo("username", username);
        query.get().addOnCompleteListener(
                task -> {
                    if (task.isSuccessful()) {
                        if (task.getResult().size() > 0) {
                            for(QueryDocumentSnapshot document : task.getResult()){
                                User dbUser = document.toObject(User.class);
                                goToMyPokemonActivity(dbUser);
                                break;
                            }
                        } else {
                            User user = new User(UUID.randomUUID().toString(), username, new ArrayList<>());
                            db.collection("users").document(user.getId()).set(user);
                            goToMyPokemonActivity(user);
                        }
                    }
                }
        );
    }

    private void goToMyPokemonActivity(User user) {
        Intent intent = new Intent(this, MyPokemonsActivity.class);
        intent.putExtra("username", user);
        startActivity(intent);
    }
}