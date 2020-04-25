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
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.vochora.aluno.Aluno;
import com.vochora.api.Mascaras;
import com.vochora.docente.Docente;
import com.vochora.firebase.inicializarBD;

import java.util.Random;
import java.util.UUID;

public class CadastroActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    //Instâncias Globais
    private EditText txtFullname;
    private EditText txtEmail;
    private EditText txtPhone;
    private EditText txtPhoneF;
    private EditText txtBirthdate;

    private Spinner users;

    private Button btnCadastrar;

    private String user;

    private Mascaras mascara;

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

        //inicializando Firebase
        final inicializarBD database = new inicializarBD();
        database.inicializarDatabase(this);

        //Spinner
        users = findViewById(R.id.spinnerUsers);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.users, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        users.setAdapter(adapter);
        users.setOnItemSelectedListener(this);

        //Aplicação de Máscaras
        mascara = new Mascaras();
        txtPhone = mascara.formatarTelefone(txtPhone);
        txtBirthdate = mascara.formatarData(txtBirthdate);

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (user.equals("Discente")){
                    Aluno aluno = new Aluno();
                    aluno.setId(UUID.randomUUID().toString());
                    aluno.setNomeCompleto(txtFullname.getText().toString());
                    aluno.setEmail(txtEmail.getText().toString());
                    aluno.setBirthdate(txtBirthdate.getText().toString());
                    aluno.setTelefone(txtPhone.getText().toString());

                    database.insertAluno("aluno", aluno.getId(), aluno);
                    Toast.makeText(CadastroActivity.this, "Aluno cadastrado com sucesso!\nMatrícula: " + numeroRandomico() + "\nSenha: " + aluno.getBirthdate(), Toast.LENGTH_LONG).show();
                }

                if (user.equals("Docente")){
                    Docente professor = new Docente();
                    professor = new Docente();
                    professor.setId(UUID.randomUUID().toString());
                    professor.setNomeCompleto(txtFullname.getText().toString());
                    professor.setEmail(txtEmail.getText().toString());
                    professor.setTelefone(txtPhone.getText().toString());
                    professor.setEmail(txtEmail.getText().toString());
                    professor.setBirthdate(txtBirthdate.getText().toString());

                    database.insertProfessor("professor", professor.getId(), professor);
                    Toast.makeText(CadastroActivity.this, "Professor cadastrado com sucesso!\nMatrícula: " + numeroRandomico() + "\nSenha: " + professor.getBirthdate(), Toast.LENGTH_LONG).show();
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

    private int numeroRandomico(){
        Random random = new Random();
        int numeroRandomico = random.nextInt(999999999);
        return numeroRandomico;
    }
}