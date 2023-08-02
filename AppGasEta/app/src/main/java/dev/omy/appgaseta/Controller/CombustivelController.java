package dev.omy.appgaseta.Controller;

import android.content.SharedPreferences;

import dev.omy.appgaseta.Model.Combustivel;
import dev.omy.appgaseta.View.GasEtaActivity;

public class CombustivelController {

    SharedPreferences preferences;

    SharedPreferences.Editor dadosPreferences;

    public static final String NOME_PREFERENCES = "pref_gaseta";

    // Construtor
    public CombustivelController(GasEtaActivity gasEtaActivity){

        preferences = gasEtaActivity.getSharedPreferences(NOME_PREFERENCES, 0);

        dadosPreferences = preferences.edit();

    }

    public void salvar(Combustivel combustivel){

        dadosPreferences.putString("combustivel", combustivel.getNomeCombustivel());
        dadosPreferences.putFloat("precoDoCombustivel", (float) combustivel.getPrecoCombustivel());
        dadosPreferences.putString("recomendacao", combustivel.getResultado());
        dadosPreferences.apply();

    }

    public void limpar(){

        dadosPreferences.clear();
        dadosPreferences.apply();

    }

}
