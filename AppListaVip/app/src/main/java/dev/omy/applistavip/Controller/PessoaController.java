package dev.omy.applistavip.Controller;

import android.util.Log;

import androidx.annotation.NonNull;

import dev.omy.applistavip.Model.Pessoa;

public class PessoaController {


    @NonNull
    @Override
    public String toString() {

        Log.d("MVC_Controller", "PessoaController iniciada...");

        return super.toString();
    }

    public void salvar(Pessoa pessoa) {

        Log.d("MVC_Controller", "Salvo " + pessoa.toString());
    }
}
