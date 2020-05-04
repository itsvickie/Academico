package com.vochora.academico;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
import com.vochora.aluno.Aluno;
import com.vochora.database.ConfigDatabase;
import com.vochora.docente.Docente;

import java.util.Map;
import java.util.Random;

public class CadastroActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    private EditText txtNomeCadastro;
    private EditText txtUsernameCadastro;
    private EditText txtEmailCadastro;
    private EditText txtTelefoneCadastro;
    private EditText txtNascimentoCadastro;
    private EditText txtSenhaCadastro;
    private Spinner users;
    private String user;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        //Instanciando os campos
        txtNomeCadastro = findViewById(R.id.txtNomeCadastro);
        txtUsernameCadastro = findViewById(R.id.txtUsernameCadastro);
        txtEmailCadastro = findViewById(R.id.txtEmailCadastro);
        txtTelefoneCadastro = findViewById(R.id.txtTelefoneCadastro);
        txtNascimentoCadastro = findViewById(R.id.txtNascimentoCadastro);
        txtSenhaCadastro = findViewById(R.id.txtSenhaCadastro);
        users = findViewById(R.id.spinnerUsers);

        //Spinner
        criacaoSpinner();
    }

    //Criação do Usuário na Autenticação do Firebase
    public void authCadastro(String email, String senha){
        auth = ConfigDatabase.getFirebaseAuth();
        auth.createUserWithEmailAndPassword(email, senha).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Toast.makeText(CadastroActivity.this, "O usuário foi cadastrado", Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    String exception = "";
                    try {
                        throw task.getException();
                    } catch (FirebaseAuthWeakPasswordException e){
                        Toast.makeText(CadastroActivity.this, "Senha muito fraca!", Toast.LENGTH_SHORT).show();
                    } catch (FirebaseAuthInvalidCredentialsException e){
                        Toast.makeText(CadastroActivity.this, "E-mail inválido!", Toast.LENGTH_SHORT).show();
                    } catch (FirebaseAuthUserCollisionException e){
                        Toast.makeText(CadastroActivity.this, "Usuário já cadastrado!", Toast.LENGTH_SHORT).show();
                    } catch (Exception e){
                        exception = "Erro ao cadastrar!";
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    //Cadastro do Usuário ao Firebase
    public void cadastrarUsuario(View view){
        String email = txtEmailCadastro.getText().toString();
        String senha = txtSenhaCadastro.getText().toString();

        if (!email.isEmpty()){
            if (!senha.isEmpty()){
                if (user.equals("Discente")){
                    Aluno aluno = new Aluno();
                    aluno.setEmail(email);
                    aluno.setSenha(senha);
                    authCadastro(aluno.getEmail(), aluno.getSenha());

                } else if (user.equals("Docente")){
                    Docente docente = new Docente();
                    docente.setEmail(email);
                    docente.setSenha(senha);
                    authCadastro(docente.getEmail(), docente.getSenha());
                }
            } else {
                Toast.makeText(this, "Senha não preenchido!", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "E-mail não preenchido!", Toast.LENGTH_SHORT).show();
        }
    }

    //Criação do Menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuCriado = getMenuInflater();
        menuCriado.inflate(R.menu.menu_principal, menu);
        return true;
    }

    //Opções dos Itens
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.config_menu:
                Toast.makeText(this, "Em breve", Toast.LENGTH_LONG).show();
                return true;
            case R.id.sair_menu:
                System.exit(0);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String usuario = parent.getItemAtPosition(position).toString();
        user = usuario;
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    //Spinner
    public void criacaoSpinner(){
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.users, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        users.setAdapter(adapter);
        users.setOnItemSelectedListener(this);
    }
}