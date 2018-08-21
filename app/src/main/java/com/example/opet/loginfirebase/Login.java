package com.example.opet.loginfirebase;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity {

    private EditText editEmail;
    private EditText editSenha;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editEmail  = findViewById(R.id.editEmail);
        editSenha = findViewById(R.id.editSenha);
        mAuth = FirebaseAuth.getInstance();

    }

    public void criar(View v){
        String sEmail = editEmail.getText().toString();
        String sSenha = editSenha.getText().toString();
        mAuth.createUserWithEmailAndPassword(sEmail, sSenha)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(Login.this, "Usuario criado com sucesso!", Toast.LENGTH_SHORT).show();

                            FirebaseUser user = mAuth.getCurrentUser();

                            Bundle bundle = new Bundle();
                            bundle.putString("email", user.getEmail().toString());

                            Intent intent = new Intent(Login.this, TelaInicial.class);
                            intent.putExtras(bundle);

                            startActivity(intent);

                        } else {
                            Toast.makeText(Login.this, "Problemas na criação do usuário.", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }


}