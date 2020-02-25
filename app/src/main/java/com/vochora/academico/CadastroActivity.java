package com.vochora.academico;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.vochora.aluno.Aluno;
import com.vochora.firebase.inicializarBD;

import java.util.UUID;

public class CadastroActivity extends AppCompatActivity {
    private Aluno dadosAluno;
    private TextView matriculaUser;
    private TextView loginUser;
    private TextView senhaUser;
    private Button botaoCadastrar;
    private inicializarBD database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        dadosAluno = new Aluno();
        matriculaUser = findViewById(R.id.matriculaTxt);
        loginUser = findViewById(R.id.usernameTxt);
        senhaUser = findViewById(R.id.passwordTxt);
        botaoCadastrar = (Button) findViewById(R.id.cadastrarBtn);
        database = new inicializarBD();

        database.inicializarDatabase(this);

        botaoCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Aluno aluno = new Aluno();
                aluno.setId(UUID.randomUUID().toString());
                aluno.setAlunoLogin(loginUser.getText().toString());
                aluno.setAlunoSenha(loginUser.getText().toString());
                database.databaseReference.child("aluno").child(aluno.getId()).setValue(aluno);
                limparCampos();
            }

            private void limparCampos() {
                loginUser.setText("");
                senhaUser.setText("");
                matriculaUser.setText("");
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
}
