package com.vochora.academico;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.vochora.aluno.MainAlunoActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button botaoCadastrar = (Button) findViewById(R.id.cadastrarBtn);
        Button botaoLogin = (Button) findViewById(R.id.loginBtn);
        final TextView loginUser = findViewById(R.id.txtEmail);
        final TextView senhaUser = findViewById(R.id.txtBirthdate);

        botaoCadastrar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent cadastroTela = new Intent(MainActivity.this, CadastroActivity.class);
                startActivity(cadastroTela);
            }
        });

        botaoLogin.setOnClickListener(new View.OnClickListener() {
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
                Toast.makeText(MainActivity.this, "Em Breve", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.sair_menu:
                System.exit(0);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
