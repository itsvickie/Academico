package com.vochora.docente;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.vochora.academico.R;

public class MainDocenteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_docente);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuProf = getMenuInflater();
        menuProf.inflate(R.menu.menu_prof, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.menu_turmas:
                Toast.makeText(this, "TURMAS - EM BREVE", Toast.LENGTH_SHORT).show();
            case R.id.menu_config:
                Toast.makeText(this, "EM BREVE", Toast.LENGTH_SHORT).show();
            case R.id.menu_sair:
                Toast.makeText(this, "Saindo da Aplicação", Toast.LENGTH_SHORT).show();
                System.exit(0);
        }
        return super.onOptionsItemSelected(item);
    }
}
