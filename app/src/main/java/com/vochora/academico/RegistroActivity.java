package com.vochora.academico;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.vochora.aluno.Aluno;
import com.vochora.docente.Docente;
import com.vochora.database.Database;

public class RegistroActivity extends AppCompatActivity {
    private TextView txtBoasVindas;
    private EditText txtCPF;
    private EditText txtRG;
    private EditText txtEndRua;
    private EditText txtEndNum;
    private EditText txtEndBairro;
    private EditText txtEndCidade;
    private EditText txtEndComplemento;
    private EditText txtEndEstado;
    private Button btnCadastro;
    private LoginActivity loginActivity;
    private Database database;
    private Aluno aluno;
    private Docente docente;
    private Bundle extra;
    private String usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        txtBoasVindas = findViewById(R.id.txtBoasVindas);
        txtCPF = findViewById(R.id.txtCPF);
        txtRG = findViewById(R.id.txtRG);
        txtEndRua = findViewById(R.id.txtRua);
        txtEndNum = findViewById(R.id.txtNum);
        txtEndBairro = findViewById(R.id.txtBairro);
        txtEndCidade = findViewById(R.id.txtCidade);
        txtEndComplemento = findViewById(R.id.txtComplemento);
        txtEndEstado = findViewById(R.id.txtEstado);
        btnCadastro = findViewById(R.id.btnRegistro);
        extra = getIntent().getExtras();

        if (extra != null){
            usuario = extra.getString("tipoUser");
        }

        if(usuario == "aluno") txtBoasVindas.setText(aluno.getNomeCompleto() + " seja bem-vindo ao Acadêmico!\n\nPreencha abaixo com suas informações");
        if(usuario == "docente") txtBoasVindas.setText(docente.getNomeCompleto() + " seja bem-vindo ao Acadêmico!\n\nPreencha abaixo com suas informações");

        database = new Database();
        database.inicializarDatabase(this);

        btnCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(usuario.equals("aluno")){
                    aluno.setCPF(Integer.parseInt(txtCPF.getText().toString()));
                    aluno.setRG(Integer.parseInt(txtRG.getText().toString()));
                    aluno.setEndRua(txtEndRua.getText().toString());
                    aluno.setEndNumero(Integer.parseInt(txtEndNum.getText().toString()));
                    aluno.setEndBairro(txtEndBairro.getText().toString());
                    aluno.setEndCidade(txtEndCidade.getText().toString());
                    aluno.setEndComplemento(txtEndComplemento.getText().toString());
                    aluno.setEndEstado(txtEndEstado.getText().toString());

                    database.insertAluno("aluno", aluno.getId(), aluno);
                }
            }
        });
    }
}
