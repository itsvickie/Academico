package com.vochora.adm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.vochora.academico.R;
import com.vochora.aluno.Aluno;
import com.vochora.firebase.inicializarBD;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.UUID;

public class AdmActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private Spinner spinnerCursos;
    private TextView nomeAluno;
    private TextView cpfAluno;
    private TextView telefoneAluno;
    private TextView matriculaAluno;
    private Button cadastrarBtn;
    private String cursoNome;
    private inicializarBD database;

    private ArrayList<Aluno> listAluno = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adm);

        //Iniciando os campos e botão
        cadastrarBtn = findViewById(R.id.botaoCadastrar);
        nomeAluno = findViewById(R.id.nomeTxt);
        cpfAluno = findViewById(R.id.cpfTxt);
        telefoneAluno = findViewById(R.id.telefoneTxt);
        matriculaAluno = findViewById(R.id.matriculaTxt);

        //Iniciando o Firebase
        database = new inicializarBD();
        database.inicializarDatabase(this);

        //Criação do Spinner
        spinnerCursos = findViewById(R.id.spinnerCursos);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.cursos, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCursos.setAdapter(adapter);
        spinnerCursos.setOnItemSelectedListener(this);

        cadastrarBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Aluno dadosAluno = new Aluno();

                //Settando os Dados
                dadosAluno.setId(UUID.randomUUID().toString());
                dadosAluno.setAlunoNome(nomeAluno.getText().toString());
                dadosAluno.setAlunoCPF(Integer.parseInt(cpfAluno.getText().toString()));
                dadosAluno.setAlunoTelefone(Integer.parseInt(telefoneAluno.getText().toString()));
                dadosAluno.setAlunoMatricula(Integer.parseInt(matriculaAluno.getText().toString()));
                dadosAluno.setAlunoCurso(cursoNome);

                //Enviando ao banco de Dados
                database.insertAluno("aluno", dadosAluno.getId(), dadosAluno);
                //database.databaseReference.child("aluno").child(dadosAluno.getId()).setValue(dadosAluno);
                Toast.makeText(AdmActivity.this, "Aluno Cadastrado com Sucesso!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String curso =  parent.getItemAtPosition(position).toString();
        cursoNome = curso;
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
