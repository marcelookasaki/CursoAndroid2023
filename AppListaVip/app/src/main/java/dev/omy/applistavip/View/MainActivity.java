package dev.omy.applistavip.View;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

import dev.omy.applistavip.Controller.CursoController;
import dev.omy.applistavip.Controller.PessoaController;
import dev.omy.applistavip.Model.Pessoa;
import dev.omy.applistavip.R;

public class MainActivity extends AppCompatActivity {

    // Declarar componentes da tela
    EditText etPrimeiroNome;
    EditText etSobrenome;
    EditText etTelefone;

    Button btnLimpar;
    Button btnSalvar;
    Button btnFinalizar;

    Spinner spinner;

    // Declara classe controller e cria objeto
    PessoaController pessoaController;
    CursoController cursoController;

    // Declara lista de cursos
    List<String> nomesDosCursos;

    // Declara classe pessoa e cria objeto
    Pessoa pessoa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_spinner);

        // Instanciar componentes
        etPrimeiroNome = findViewById(R.id.etPrimeiroNome);
        etSobrenome = findViewById(R.id.etSobrenome);
        etTelefone = findViewById(R.id.etTelefone);
        btnLimpar = findViewById(R.id.btnLimpar);
        btnSalvar = findViewById(R.id.btnSalvar);
        btnFinalizar = findViewById(R.id.btnFinalizar);
        spinner = findViewById(R.id.spinner);


        // Instancia do objeto pessoa controller
        pessoaController = new PessoaController(MainActivity.this);
        cursoController = new CursoController(MainActivity.this);

        // Adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_1, cursoController.listaSpinner());
        // Configura o dropdown como comportanento
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_1);
        // Configura o spinner com o adapter
        spinner.setAdapter(adapter);

        // Instancia do objeto pessoa
        pessoa = new Pessoa();

        // Instancia método recuperar pessoa
        pessoaController.recuperar(pessoa);

        // Instancia método recuperar listaCursos
        nomesDosCursos = cursoController.listaSpinner();


        // Joga na tela os dados recuperados
        etPrimeiroNome.setText(pessoa.getPrimeiroNome());
        etSobrenome.setText(pessoa.getSobreNome());
        etTelefone.setText(pessoa.getTelefoneContato());

        Log.i("POOAndroid", "Objeto pessoa: " + pessoa.toString());

        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etPrimeiroNome.setText("");
                etSobrenome.setText("");
                etTelefone.setText("");

                pessoaController.limpar();
            }
        });

        btnFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,
                                "Volte sempre!",
                                Toast.LENGTH_LONG).show();
                finish();
            }
        });

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Capturar dados
                pessoa.setPrimeiroNome(etPrimeiroNome.getText().toString());
                pessoa.setSobreNome(etSobrenome.getText().toString());
                pessoa.setTelefoneContato(etTelefone.getText().toString());

                Toast.makeText(MainActivity.this,
                                "Salvo! " + pessoa.toString(),
                                Toast.LENGTH_LONG).show();

                pessoaController.salvar(pessoa);
            }
        });

    }
}