package dev.omy.applistavip.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
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

    // Declarar Shared Preferences
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor listaVIP;

    public static final String NOME_PREFERENCES = "pref_listaVIP";

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

        // Instancia Shared Preferences e configurar para edição
        sharedPreferences = getSharedPreferences(NOME_PREFERENCES, 0);
        listaVIP = sharedPreferences.edit();

        // Instancia do objeto pessoa controller
        pessoaController = new PessoaController();

        // Instancia do objeto pessoa
        pessoa = new Pessoa();

        // Recupera dados do shared preferences
        pessoa.setPrimeiroNome(sharedPreferences.getString(
                        "primeiroNome", "Nome"));
        pessoa.setSobreNome(sharedPreferences.getString(
                "sobreNome", "Sobrenome"));
        pessoa.setCursoDesejado(sharedPreferences.getString(
                "cursoDesejado", "Curso"));
        pessoa.setTelefoneContato(sharedPreferences.getString(
                        "telefoneContato", "NumTel"));

        // Joga na tela os dados recuperados
        etPrimeiroNome.setText(pessoa.getPrimeiroNome().toString());
        etSobrenome.setText(pessoa.getSobreNome().toString());
        etCursoDesejado.setText(pessoa.getCursoDesejado().toString());
        etTelefone.setText(pessoa.getTelefoneContato().toString());


        Log.i("POOAndroid", "Objeto pessoa: " + pessoa.toString());

        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etPrimeiroNome.setText("");
                etSobrenome.setText("");
                etCursoDesejado.setText("");
                etTelefone.setText("");

                // Limpar shared preferences
                listaVIP.clear();
                listaVIP.apply();
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
                // Salva em shared preferences
                listaVIP.putString("primeiroNome", pessoa.getPrimeiroNome());
                listaVIP.putString("sobreNome", pessoa.getSobreNome());
                listaVIP.putString("cursoDesejado", pessoa.getCursoDesejado());
                listaVIP.putString("telefoneContato", pessoa.getTelefoneContato());
                listaVIP.apply();

                pessoaController.salvar(pessoa);
            }
        });

    }
}