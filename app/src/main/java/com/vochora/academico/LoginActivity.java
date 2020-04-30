package com.vochora.academico;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.vochora.aluno.Aluno;
import com.vochora.aluno.MainAlunoActivity;

import org.w3c.dom.Text;

public class LoginActivity extends AppCompatActivity {
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
    private Button btnCadastrar;
    private Button btnLogin;
    private EditText loginUser;
    private TextView senhaUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Instâncias do Layout
        btnCadastrar = findViewById(R.id.cadastrarBtn);
        btnLogin = findViewById(R.id.loginBtn);
        loginUser = findViewById(R.id.txtUser);
        senhaUser = findViewById(R.id.txtSenha);

        FirebaseApp.initializeApp(LoginActivity.this);
        databaseReference = FirebaseDatabase.getInstance().getReference("aluno");


        //Botão Cadastro -> Tela Cadastro
        btnCadastrar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent cadastroTela = new Intent(LoginActivity.this, CadastroActivity.class);
                startActivity(cadastroTela);
            }
        });

        //AuthLogin
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
                    public void onClick(View v) {

            }
        });
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
