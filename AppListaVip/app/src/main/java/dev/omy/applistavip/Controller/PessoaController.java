package dev.omy.applistavip.Controller;

import android.content.SharedPreferences;
import android.util.Log;

import androidx.annotation.NonNull;

import dev.omy.applistavip.Model.Pessoa;
import dev.omy.applistavip.View.MainActivity;

public class PessoaController {
    
    // Declarar Shared Preferences
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor listaVIP;

    public static final String NOME_PREFERENCES = "pref_listaVIP";

    public PessoaController(MainActivity mainActivity) {
        // Instancia Shared Preferences e configurar para edição
        sharedPreferences  = mainActivity.getSharedPreferences(NOME_PREFERENCES, 0);
        listaVIP = sharedPreferences.edit();
    }

    @NonNull
    @Override
    public String toString() {

        Log.d("MVC_Controller", "PessoaController iniciada...");

        return super.toString();
    }
    
    public void salvar(Pessoa pessoa) {

        Log.d("MVC_Controller", "Salvo " + pessoa.toString());

        // Salva em shared preferences
        listaVIP.putString("primeiroNome", pessoa.getPrimeiroNome());
        listaVIP.putString("sobreNome", pessoa.getSobreNome());
        listaVIP.putString("cursoDesejado", pessoa.getCursoDesejado());
        listaVIP.putString("telefoneContato", pessoa.getTelefoneContato());
        listaVIP.apply();
    }

    public void recuperar(Pessoa pessoa){
        // Recupera dados do shared preferences
        pessoa.setPrimeiroNome(sharedPreferences.getString(
                        "primeiroNome", ""));
        pessoa.setSobreNome(sharedPreferences.getString(
                "sobreNome", ""));
        pessoa.setCursoDesejado(sharedPreferences.getString(
                "cursoDesejado", ""));
        pessoa.setTelefoneContato(sharedPreferences.getString(
                        "telefoneContato", ""));
    }

    public void limpar(){
        // Limpar shared preferences
        listaVIP.clear();
        listaVIP.apply();
        
    }

}
