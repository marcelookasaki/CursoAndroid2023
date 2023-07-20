package dev.omy.applistavip.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

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

        // Instancia do objeto pessoa
        pessoa = new Pessoa();

        // Inserir valores ao objeto
        pessoa.setPrimeiroNome("Marcelo");
        pessoa.setSobreNome("Okasaki");
        pessoa.setCursoDesejado("Android");
        pessoa.setTelefoneContato("11 97187-5153");

        // Capturar dados
        etPrimeiroNome.setText(pessoa.getPrimeiroNome());
        etSobrenome.setText(pessoa.getSobreNome());
        etCursoDesejado.setText(pessoa.getCursoDesejado());
        etTelefone.setText(pessoa.getTelefoneContato());

        Log.i("POOAndroid", "Objeto pessoa: " + pessoa.toString());

    }
}