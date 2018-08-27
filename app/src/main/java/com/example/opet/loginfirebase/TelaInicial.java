package com.example.opet.loginfirebase;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * Created by opet on 21/08/2018.
 */

public class TelaInicial extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private ProgressBar pbSalvar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_inicial);
        pbSalvar = findViewById(R.id.pbSalvar);

        mAuth = FirebaseAuth.getInstance();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        String emailCurrent = currentUser.getEmail();

        TextView emailUser = findViewById(R.id.email);
        emailUser.setText("Bem vindo, " + emailCurrent);

    }

    public void salvarCarro(View view){
        Carro c = new Carro("Audi", "A4", 2018);

        FirebaseDatabase mDatabase = FirebaseDatabase.getInstance();
        DatabaseReference mRef = mDatabase.getReference("carros");

        pbSalvar.setVisibility(ProgressBar.VISIBLE);
        mRef.setValue(c);

        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Toast.makeText(TelaInicial.this, "Carro salvo", Toast.LENGTH_SHORT).show();
                pbSalvar.setVisibility(ProgressBar.GONE);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(TelaInicial.this, "Erro ao salvar", Toast.LENGTH_SHORT).show();
                pbSalvar.setVisibility(ProgressBar.GONE);
            }
        });
    }

    public void Sair(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}

