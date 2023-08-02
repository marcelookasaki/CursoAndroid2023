package dev.omy.appgaseta.View;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import dev.omy.appgaseta.Controller.CombustivelController;
import dev.omy.appgaseta.Model.Combustivel;
import dev.omy.appgaseta.R;
import dev.omy.appgaseta.Utils.UtilGasEta;

public class GasEtaActivity extends AppCompatActivity {

    // Declarar controller
    CombustivelController controller;

    // Declarar classe
    Combustivel combustivelGasolina;
    Combustivel combustivelEtanol;

    // Declarar componentes da tela
    EditText etGasolina;
    EditText etEtanol;
    TextView tvResultado;

    Button btnCalcular;
    Button btnLimpar;
    Button btnSalvar;
    Button btnFinalizar;

    Double precoGasolina;
    Double precoEtanol;
    String resultado;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Instanciar componentes
        etGasolina = findViewById(R.id.etGasolina);
        etEtanol = findViewById(R.id.etEtanol);
        tvResultado = findViewById(R.id.tvResultado);
        btnCalcular = findViewById(R.id.btnCalcular);
        btnLimpar = findViewById(R.id.btnLimpar);
        btnSalvar = findViewById(R.id.btnSalvar);
        btnFinalizar = findViewById(R.id.btnFinalizar);

        // Instancia do objeto controller
        controller = new CombustivelController(GasEtaActivity.this);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                boolean isDadosOK = true;

                if(TextUtils.isEmpty(etGasolina.getText())){
                    etGasolina.setError("* Campo obrigatório!");
                    etGasolina.requestFocus();
                    isDadosOK = false;
                }

                if(TextUtils.isEmpty(etEtanol.getText())){
                    etEtanol.setError("* Campo obrigatório!");
                    etEtanol.requestFocus();
                    isDadosOK = false;
                }

                if(isDadosOK){
                    precoGasolina = Double.parseDouble(etGasolina.getText().toString());
                    precoEtanol = Double.parseDouble(etEtanol.getText().toString());
                    resultado = UtilGasEta.calcularMelhorOpcao(precoGasolina, precoEtanol);
                    tvResultado.setText(resultado);
                    btnSalvar.setEnabled(true);
                    btnSalvar.setVisibility(View.VISIBLE);
                }else {
                    Toast.makeText(GasEtaActivity.this,
                            "Preencha os campos obrigatórios!",
                            Toast.LENGTH_LONG).show();
                    btnSalvar.setEnabled(false);
                    btnSalvar.setVisibility(View.GONE);
                }

            }
        });

        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                etEtanol.setText("");
                etGasolina.setText("");
                btnSalvar.setEnabled(false);

                controller.limpar();

            }
        });

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                combustivelEtanol = new Combustivel();
                combustivelGasolina = new Combustivel();

                combustivelEtanol.setNomeCombustivel("Etanol");
                combustivelEtanol.setPrecoCombustivel(precoEtanol);
                combustivelGasolina.setNomeCombustivel("Gasolina");
                combustivelGasolina.setPrecoCombustivel(precoGasolina);

                combustivelGasolina.setResultado(UtilGasEta.calcularMelhorOpcao(
                        precoGasolina, precoEtanol));
                combustivelEtanol.setResultado(UtilGasEta.calcularMelhorOpcao(
                        precoGasolina, precoEtanol));

                controller.salvar(combustivelEtanol);
                controller.salvar(combustivelGasolina);

            }
        });

        btnFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(GasEtaActivity.this,
                        "Boa economia!",
                        Toast.LENGTH_LONG).show();
                finish();
            }
        });
    }
}
