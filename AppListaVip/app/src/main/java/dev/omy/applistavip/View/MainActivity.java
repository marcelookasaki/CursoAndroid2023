package dev.omy.applistavip.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import dev.omy.applistavip.Controller.PessoaController;
import dev.omy.applistavip.Model.Pessoa;
import dev.omy.applistavip.R;

public class MainActivity extends AppCompatActivity {

    // Declarar componentes da tela
    EditText etPrimeiroNome;
    EditText etSobrenome;
    EditText etCursoDesejado;
    EditText etTelefone;

    Button btnLimpar;
    Button btnSalvar;
    Button btnFinalizar;

    // Declara classe pessoa controller e cria objeto
    PessoaController pessoaController;

    // Declara classe pessoa e cria objeto
    Pessoa pessoa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Instanciar componentes
        etPrimeiroNome = findViewById(R.id.etPrimeiroNome);
        etSobrenome = findViewById(R.id.etSobrenome);
        etCursoDesejado = findViewById(R.id.etCursoDesejado);
        etTelefone = findViewById(R.id.etTelefone);
        btnLimpar = findViewById(R.id.btnLimpar);
        btnSalvar = findViewById(R.id.btnSalvar);
        btnFinalizar = findViewById(R.id.btnFinalizar);

        // Instancia do objeto pessoa controller
        pessoaController = new PessoaController();

        // Instancia do objeto pessoa
        pessoa = new Pessoa();

        // Inserir valores ao objeto
        pessoa.setPrimeiroNome("Marcelo");
        pessoa.setSobreNome("Okasaki");
        pessoa.setCursoDesejado("Android");
        pessoa.setTelefoneContato("11 97187-5153");



        Log.i("POOAndroid", "Objeto pessoa: " + pessoa.toString());

        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etPrimeiroNome.setText("");
                etSobrenome.setText("");
                etCursoDesejado.setText("");
                etTelefone.setText("");
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
                pessoa.setCursoDesejado(etCursoDesejado.getText().toString());
                pessoa.setTelefoneContato(etTelefone.getText().toString());

                Toast.makeText(MainActivity.this,
                                "Salvo! " + pessoa.toString(),
                                Toast.LENGTH_LONG).show();

                pessoaController.salvar(pessoa);
            }
        });

    }
}