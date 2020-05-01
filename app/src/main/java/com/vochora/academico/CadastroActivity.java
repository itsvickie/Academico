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
import android.widget.Toast;

import com.vochora.aluno.Aluno;
import com.vochora.api.Mascaras;
import com.vochora.docente.Docente;
import com.vochora.firebase.Database;

import java.util.Random;

public class CadastroActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    private EditText txtFullname;
    private EditText txtEmail;
    private EditText txtPhone;
    private EditText txtBirthdate;
    private EditText txtUser;
    private Button btnCadastrar;
    private Spinner users;
    private String user;
    private Mascaras mascara;
    private Database database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        //Instâncias do Layout
        txtFullname = findViewById(R.id.txtFullname);
        txtEmail = findViewById(R.id.txtEmail);
        txtPhone = findViewById(R.id.txtPhone);
        txtBirthdate = findViewById(R.id.txtBirthdate);
        btnCadastrar = findViewById(R.id.btnCadastrar);
        txtUser = findViewById(R.id.txtLogin);

        //Iniciando o Firebase
        database = new Database();
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

        //Cadastro
        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (user.equals("Discente")){
                    Aluno aluno = new Aluno();
                    aluno.setId(Integer.toString(numeroRandomico()));
                    aluno.setNomeCompleto(txtFullname.getText().toString());
                    aluno.setUser(txtUser.getText().toString());
                    aluno.setEmail(txtEmail.getText().toString());
                    aluno.setBirthdate(txtBirthdate.getText().toString());
                    aluno.setTelefone(txtPhone.getText().toString());
                    aluno.setSenha(aluno.getBirthdate());

                    database.insertAluno("aluno", aluno.getId(), aluno);
                    Toast.makeText(CadastroActivity.this, "Aluno cadastrado com sucesso!\nUsuário: " + aluno.getUser() + "\nSenha: " + aluno.getSenha(), Toast.LENGTH_LONG).show();
                    limparCampos();
                }

                if (user.equals("Docente")){
                    Docente docente = new Docente();
                    docente.setId(Integer.toString(numeroRandomico()));
                    docente.setNomeCompleto(txtFullname.getText().toString());
                    docente.setUser(txtUser.getText().toString());
                    docente.setEmail(txtEmail.getText().toString());
                    docente.setTelefone(txtPhone.getText().toString());
                    docente.setEmail(txtEmail.getText().toString());
                    docente.setBirthdate(txtBirthdate.getText().toString());

                    database.insertProfessor("docente", docente.getId(), docente);
                    Toast.makeText(CadastroActivity.this, "Professor cadastrado com sucesso!\nUsuário: " + docente.getUser() + "\nSenha: " + docente.getBirthdate(), Toast.LENGTH_LONG).show();
                    limparCampos();
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

    private void limparCampos(){
        txtFullname.setText("");
        txtUser.setText("");
        txtEmail.setText("");
        txtPhone.setText("");
        txtBirthdate.setText("");
    }
}