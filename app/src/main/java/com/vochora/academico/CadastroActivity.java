package com.vochora.academico;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.vochora.aluno.Aluno;
import com.vochora.database.AlunoDAO;

public class CadastroActivity extends AppCompatActivity {
    private Aluno dadosAluno;
    private AlunoDAO dao;
    private TextView matriculaUser;
    private TextView loginUser;
    private TextView senhaUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        dadosAluno = new Aluno();
        dao = new AlunoDAO(this);
        matriculaUser = findViewById(R.id.matriculaTxt);
        loginUser = findViewById(R.id.usernameTxt);
        senhaUser = findViewById(R.id.passwordTxt);
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

    public void salvar(View view){
        dadosAluno = new Aluno();
        dadosAluno.setAlunoLogin(loginUser.getText().toString());
        dadosAluno.setAlunoSenha(senhaUser.getText().toString());
        long id  = dao.inserir(dadosAluno);
        Toast.makeText(this, "ID " + id, Toast.LENGTH_LONG).show();
    }
}
