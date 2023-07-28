package dev.omy.appgaseta.Utils;

public class UtilGasEta {

    public static String calcularMelhorOpcao(double gasolina, double etanol){

        double precoIdeal = gasolina * 0.7;
        String mensagemDeRetorno;

        if(etanol<=precoIdeal){
            mensagemDeRetorno = "Abastecer com etanol";
        }else {
            mensagemDeRetorno = "Abastecer com gasolina";
        }
        return mensagemDeRetorno;
    }

}
