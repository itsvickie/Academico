package com.vochora;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthInvalidUserException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.vochora.academico.R;
import com.vochora.aluno.Aluno;
import com.vochora.aluno.MainAlunoActivity;
import com.vochora.database.Database;
import com.vochora.docente.Docente;
import com.vochora.docente.MainDocenteActivity;
import com.vochora.helper.Base64Custom;

public class LoginActivity extends AppCompatActivity {
    private EditText txtEmail;
    private TextView txtSenha;
    private Switch switchUser;
    private FirebaseAuth auth;
    private FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Instâncias do Layout
        txtEmail = findViewById(R.id.txtEmailLogin);
        txtSenha = findViewById(R.id.txtSenhaLogin);
        switchUser = findViewById(R.id.switchUser);
    }

    /*public void onStart(){
        super.onStart();
        FirebaseUser usuarioAtual = auth.getCurrentUser();
        if (usuarioAtual != null){
            telaPrincipalAluno();
        }
    }*/

    //Autenticação do Login
    public void authLogin(String email, String senha){
        final Boolean switchStatus = switchUser.isChecked();
        auth = Database.getFirebaseAuth();
        final String id = Base64Custom.codificarBase64(email);

        FirebaseApp.initializeApp(this);
        final FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        final DatabaseReference databaseReference = firebaseDatabase.getReference();

        auth.signInWithEmailAndPassword(email, senha).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    user = FirebaseAuth.getInstance().getCurrentUser();
                    if (switchStatus){
                        databaseReference.child("docente").child(id).addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                Docente docente = dataSnapshot.getValue(Docente.class);
                            }
                            @Override
                            public void onCancelled(@NonNull DatabaseError databaseError) {

                            }
                        });
                        telaPrincipalDocente();
                        finish();
                    } else {
                        databaseReference.child("aluno").child(id).addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                Aluno aluno = dataSnapshot.getValue(Aluno.class);
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError databaseError) {

                            }
                        });
                        telaPrincipalAluno();
                        finish();
                    }
                } else {
                    String excecao = "";
                    try {
                        throw task.getException();
                    } catch (FirebaseAuthInvalidUserException e){
                        Toast.makeText(LoginActivity.this, "Usuário não cadastrado!", Toast.LENGTH_SHORT).show();
                    } catch (FirebaseAuthInvalidCredentialsException e){
                        Toast.makeText(LoginActivity.this, "E-mail ou senha inválidos!", Toast.LENGTH_SHORT).show();
                    } catch (Exception e){
                        excecao = "Erro ao realizar login!" + e.getMessage();
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    //Login do Usuário
    public void logarUsuario(View view){
        String email = txtEmail.getText().toString();
        String senha = txtSenha.getText().toString();
        
        if (!email.isEmpty()){
            if (!senha.isEmpty()){
                    authLogin(email, senha);
            } else {
                Toast.makeText(this, "Digite sua senha!", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Digite seu e-mail!", Toast.LENGTH_SHORT).show();
        }
    }

    //Tela Login -> Tela Cadastro
    public void telaCadastro(View view){
        Intent telaCadastro = new Intent(this, CadastroActivity.class);
        startActivity(telaCadastro);
    }

    //Tela Login -> Tela Principal do Aluno
    public void telaPrincipalAluno(){
        Intent telaPrincipal = new Intent(this, MainAlunoActivity.class);
        startActivity(telaPrincipal);
    }

    //Tela Login -> Tela Principal do Docente
    public void telaPrincipalDocente(){
        Intent telaDocente = new Intent(this, MainDocenteActivity.class);
        startActivity(telaDocente);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuCriado = getMenuInflater();
        menuCriado.inflate(R.menu.menu_principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()) {
            case R.id.config_menu:
                Toast.makeText(LoginActivity.this, "Em Breve", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.sair_menu:
                System.exit(0);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
