import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URI;
import java.util.Scanner;

public class CurrencyConverter {

    private static final String API_KEY = "2366d857ef8847525f92dbde"; // Coloque sua chave da ExchangeRate API
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/";

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        HttpClient client = HttpClient.newHttpClient();

        System.out.println("===== Conversor de Moedas =====");

        while (true) {
            System.out.println("\nEscolha a conversão:");
            System.out.println("1 - USD → BRL");
            System.out.println("2 - BRL → USD");
            System.out.println("3 - EUR → BRL");
            System.out.println("4 - BRL → EUR");
            System.out.println("5 - USD → EUR");
            System.out.println("6 - EUR → USD");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");
            int opcao = scanner.nextInt();

            if (opcao == 0) {
                System.out.println("Encerrando...");
                break;
            }

            System.out.print("Digite o valor: ");
            double valor = scanner.nextDouble();

            String from = "";
            String to = "";

            switch (opcao) {
                case 1 -> { from = "USD"; to = "BRL"; }
                case 2 -> { from = "BRL"; to = "USD"; }
                case 3 -> { from = "EUR"; to = "BRL"; }
                case 4 -> { from = "BRL"; to = "EUR"; }
                case 5 -> { from = "USD"; to = "EUR"; }
                case 6 -> { from = "EUR"; to = "USD"; }
                default -> {
                    System.out.println("Opção inválida.");
                    continue;
                }
            }

            // Montar URL da API
            String url = API_URL + API_KEY + "/latest/" + from;

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Usar Gson para ler o JSON
            Gson gson = new Gson();
            JsonObject jsonResponse = gson.fromJson(response.body(), JsonObject.class);

            if (!jsonResponse.has("conversion_rates")) {
                System.out.println("Erro ao obter dados da API.");
                continue;
            }

            double taxa = jsonResponse.getAsJsonObject("conversion_rates").get(to).getAsDouble();
            double convertido = valor * taxa;

            System.out.printf("%.2f %s = %.2f %s\n", valor, from, convertido, to);
        }

        scanner.close();
    }
}

