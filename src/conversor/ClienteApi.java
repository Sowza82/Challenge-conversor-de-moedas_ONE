package conversor;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class ClienteApi {

    public static String getCotacoes(String base) throws Exception {
        if (base == null || !base.matches("[A-Z]{3}")) {
            throw new IllegalArgumentException("Código da moeda base inválido: " + base);
        }

        String apiKey = lerApiKeyDeArquivo("api_key.txt");

        if (apiKey == null || apiKey.isEmpty()) {
            throw new IllegalArgumentException("A chave da API está vazia ou não foi encontrada no arquivo.");
        }

        String endpoint = "https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/" + base;

        HttpURLConnection conn = null;

        try {
            URL url = new URL(endpoint);
            conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("GET");
            conn.setRequestProperty("User-Agent", "Mozilla/5.0");
            conn.setRequestProperty("Accept", "application/json");
            conn.setConnectTimeout(5000);
            conn.setReadTimeout(5000);

            int responseCode = conn.getResponseCode();

            if (responseCode != HttpURLConnection.HTTP_OK) {
                String erroDetalhado = lerStream(conn.getErrorStream());
                throw new IOException("Erro na requisição: HTTP " + responseCode + "\n" + erroDetalhado);
            }

            return lerStream(conn.getInputStream());

        } finally {
            if (conn != null) {
                conn.disconnect();
            }
        }
    }

    private static String lerApiKeyDeArquivo(String caminho) throws IOException {
        File arquivo = new File(caminho);
        if (!arquivo.exists()) {
            throw new FileNotFoundException("Arquivo de chave da API não encontrado: " + caminho);
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(arquivo))) {
            return reader.readLine().trim();
        }
    }

    private static String lerStream(InputStream stream) throws IOException {
        if (stream == null) return "";

        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(stream, "UTF-8"))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                sb.append(linha);
            }
        }
        return sb.toString();
    }
}
