package conversor;

import java.util.Scanner;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.print("Digite a moeda base (ex: USD): ");
                String moedaBase = scanner.nextLine().toUpperCase().trim();
                if (!validarMoeda(moedaBase)) {
                    System.out.println("Código inválido. Deve conter 3 letras (ex: USD). Tente de novo.");
                    continue;
                }

                System.out.print("Digite a moeda de destino (ex: BRL): ");
                String moedaDestino = scanner.nextLine().toUpperCase().trim();
                if (!validarMoeda(moedaDestino)) {
                    System.out.println("Código inválido. Deve conter 3 letras (ex: BRL). Tente de novo.");
                    continue;
                }

                System.out.print("Digite o valor a ser convertido: ");
                if (!scanner.hasNextDouble()) {
                    System.out.println("Valor inválido. Digite um número válido.");
                    scanner.nextLine(); // limpa entrada errada
                    continue;
                }
                double valor = scanner.nextDouble();
                scanner.nextLine(); // limpa buffer

                String json = ClienteApi.getCotacoes(moedaBase);
                double valorConvertido = ConversorMoeda.converter(json, moedaDestino, valor);

                // Pega Locale certo pra moeda destino
                Locale localeMoedaDestino = localePorMoeda(moedaDestino);

                // Formata valor com símbolo e padrão local
                NumberFormat nf = NumberFormat.getCurrencyInstance(localeMoedaDestino);
                String valorFormatado = nf.format(valorConvertido);

                System.out.printf("Valor convertido: %s (%s → %s)%n", valorFormatado, moedaBase, moedaDestino);

            } catch (Exception e) {
                System.err.println("Erro: " + e.getMessage());
            }

            System.out.print("Quer fazer outra conversão? (s/n): ");
            String opcao = scanner.nextLine().trim().toLowerCase();
            if (!opcao.equals("s")) {
                System.out.println("Programa finalizado. Até a próxima!");
                break;
            }
        }

        scanner.close();
    }

    private static boolean validarMoeda(String moeda) {
        return moeda.matches("[A-Z]{3}");
    }

    private static Locale localePorMoeda(String moeda) {
        switch (moeda) {
            case "USD": return Locale.US;
            case "BRL": return new Locale("pt", "BR");
            case "EUR": return Locale.GERMANY;  // Alemanha, padrão Euro
            case "GBP": return Locale.UK;
            case "JPY": return Locale.JAPAN;
            case "AUD": return new Locale("en", "AU");
            case "CAD": return new Locale("en", "CA");
            case "CHF": return new Locale("de", "CH");
            default: return Locale.US; // fallback, só pra não quebrar
        }
    }
}
