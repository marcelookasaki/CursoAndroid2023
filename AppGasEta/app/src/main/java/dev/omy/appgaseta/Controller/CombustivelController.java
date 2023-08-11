package dev.omy.appgaseta.Controller;

import android.content.ContentValues;
import android.content.SharedPreferences;

import java.util.List;

import dev.omy.appgaseta.Database.GasEtaDB;
import dev.omy.appgaseta.Model.Combustivel;
import dev.omy.appgaseta.View.GasEtaActivity;

public class CombustivelController extends GasEtaDB {

    SharedPreferences preferences;

    SharedPreferences.Editor dadosPreferences;

    public static final String NOME_PREFERENCES = "pref_gaseta";

    // Construtor
    public CombustivelController(GasEtaActivity gasEtaActivity){
        super(gasEtaActivity);

        preferences = gasEtaActivity.getSharedPreferences(NOME_PREFERENCES, 0);

        dadosPreferences = preferences.edit();

    }

    public void salvar(Combustivel combustivel){

        ContentValues dados = new ContentValues();

        dadosPreferences.putString("combustivel", combustivel.getNomeCombustivel());
        dadosPreferences.putFloat("precoDoCombustivel", (float) combustivel.getPrecoCombustivel());
        dadosPreferences.putString("resultado", combustivel.getResultado());
        dadosPreferences.apply();

        dados.put("nomeDoCombustivel", combustivel.getNomeCombustivel());
        dados.put("precoDoCombustivel", combustivel.getPrecoCombustivel());
        dados.put("resultado", combustivel.getResultado());

        salvarObjeto("Combustivel", dados);
    }

    public List<Combustivel> getListaDeDados(){

        return listarDados();

    }

    public void alterar(Combustivel combustivel){

        ContentValues dados = new ContentValues();

        dados.put("id", combustivel.getId());
        dados.put("nomeDoCombustivel", combustivel.getNomeCombustivel());
        dados.put("precoDoCombustivel", combustivel.getPrecoCombustivel());
        dados.put("resultado", combustivel.getResultado());
    }

    public void deletar(int id){

        deletarObjeto("Combustivel", id);

    }

    public void limpar(){

        dadosPreferences.clear();
        dadosPreferences.apply();

    }

}
