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

import org.w3c.dom.Text;

public class CadastroActivity extends AppCompatActivity {
    com.vochora.aluno.Aluno dadosAluno = new Aluno();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        Button cadastrarBtn = findViewById(R.id.cadastrarBtn);
        final TextView matriculaUser = findViewById(R.id.matriculaTxt);
        final TextView loginUser = findViewById(R.id.usernameTxt);
        final TextView senhaUser = findViewById(R.id.passwordTxt);

        cadastrarBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (matriculaUser.getText().toString().equals("Matrícula") || matriculaUser.getText().toString().equals("")){
                    Toast.makeText(CadastroActivity.this, "Matrícula Obrigatório!", Toast.LENGTH_LONG).show();
                } else if (loginUser.getText().toString().equals("Login")|| loginUser.getText().toString().equals("")){
                    Toast.makeText(CadastroActivity.this, "Login Obrigatório!", Toast.LENGTH_LONG).show();
                } else if (senhaUser.getText().toString().equals("Senha") || senhaUser.getText().toString().equals("")){
                    Toast.makeText(CadastroActivity.this, "Senha Obrigatório!", Toast.LENGTH_LONG).show();
                } else {
                    dadosAluno.setAlunoMatricula(Integer.parseInt(matriculaUser.getText().toString()));
                    dadosAluno.setAlunoLogin(loginUser.getText().toString());
                    dadosAluno.setAlunoSenha(senhaUser.getText().toString());
                    Toast.makeText(CadastroActivity.this, "Cadastro Efetuado com Sucesso!", Toast.LENGTH_LONG).show();
                }
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
