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
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.vochora.aluno.Aluno;
import com.vochora.docente.Docente;

public class CadastroActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    private TextView txtFullname;
    private TextView txtEmail;
    private TextView txtPhone;
    private TextView txtBirthdate;
    private Spinner users;
    private Button btnCadastrar;
    private String user;
    private Aluno aluno;
    private Docente professor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        //Iniciando botões e campos
        txtFullname = findViewById(R.id.txtFullname);
        txtEmail = findViewById(R.id.txtEmail);
        txtPhone = findViewById(R.id.txtPhone);
        txtBirthdate = findViewById(R.id.txtBirthdate);
        btnCadastrar = findViewById(R.id.btnCadastrar);

        //Spinner
        users = findViewById(R.id.spinnerUsers);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.users, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        users.setAdapter(adapter);
        users.setOnItemSelectedListener(this);

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (user.equals("Discente")){
                    aluno.setNomeCompleto(txtFullname.getText().toString());
                    aluno.setEmail(txtEmail.getText().toString());
                    aluno.setTelefone(Integer.parseInt(txtPhone.getText().toString()));
                    aluno.setEmail(txtEmail.getText().toString());
                    aluno.setBirthdate(txtBirthdate.getText().toString());
                    Toast.makeText(CadastroActivity.this, "feito", Toast.LENGTH_SHORT).show();
                } else if (user == "Docente"){
                    professor.setNomeCompleto(txtFullname.getText().toString());
                    professor.setEmail(txtEmail.getText().toString());
                    professor.setTelefone(Integer.parseInt(txtPhone.getText().toString()));
                    professor.setEmail(txtEmail.getText().toString());
                    professor.setBirthdate(txtBirthdate.getText().toString());
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

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String usuario = parent.getItemAtPosition(position).toString();
        user = usuario;
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

}
