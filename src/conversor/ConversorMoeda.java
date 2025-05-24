package conversor;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class ConversorMoeda {
    public static double converter(String json, String moedaDestino, double valor) {
        JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();

        if (!jsonObject.has("conversion_rates")) {
            throw new IllegalArgumentException("Resposta da API inválida: 'conversion_rates' ausente.");
        }

        JsonObject taxas = jsonObject.getAsJsonObject("conversion_rates");

        if (!taxas.has(moedaDestino)) {
            throw new IllegalArgumentException("Moeda de destino não encontrada na resposta da API: " + moedaDestino);
        }

        double taxa = taxas.get(moedaDestino).getAsDouble();
        return valor * taxa;
    }
}
