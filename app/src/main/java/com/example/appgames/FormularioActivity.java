package com.example.appgames;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class FormularioActivity extends AppCompatActivity {

    private EditText etNome;
    private Spinner spCategorias;
    private Button btSalvar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        etNome = findViewById(R.id.etNome);
        spCategorias = findViewById(R.id.spCategoria);
        btSalvar = findViewById(R.id.btSalvar);

        btSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                salvar();
            }
        });
    }



    private void salvar(){
        String nome = etNome.getText().toString();

        if(nome.isEmpty() || spCategorias.getSelectedItemPosition() == 0){
            Toast.makeText(this, "tu deves preencher todos os campos!", Toast.LENGTH_LONG).show();
        }else{
            Game jogo = new Game();
            jogo.setNome( nome );
            jogo.setCategoria(spCategorias.getSelectedItem().toString());

            GameDAO.inserir(this, jogo);
            etNome.setText("");
            spCategorias.setSelection(0, true);
        }
    }
}