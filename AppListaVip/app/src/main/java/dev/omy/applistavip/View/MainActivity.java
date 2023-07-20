package dev.omy.applistavip.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

import dev.omy.applistavip.Model.Pessoa;
import dev.omy.applistavip.R;

public class MainActivity extends AppCompatActivity {

    // Declarar componentes da tela
    EditText etPrimeiroNome;
    EditText etSobrenome;
    EditText etCursoDesejado;
    EditText etTelefone;

    // Declara classe pessoa e cria objeto
    Pessoa pessoa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Instancia do objeto pessoa
        pessoa = new Pessoa();

        Log.i("POOAndroid", "Objeto pessoa: " + pessoa.toString());

    }
}