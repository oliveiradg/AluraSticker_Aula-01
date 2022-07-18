import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandler;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
      

        // fazer uma conexação HTTP e buscar os Top 250 filmes do IMDB
        String url = "https://imdb-api.com/en/API/Top250Movies/k_tzg04d16";
        HttpClient client = HttpClient.newHttpClient();
        URI endereço = URI.create(url);
        var cliente = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder().uri(endereço).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();
        System.out.println(body);
        
        // Extrair os dados dos filmes (título, poster, nota, link) = Parsear os dados

        var Parser = new JsonParser();
        List<Map<String, String>> ListaFilmes = Parser.Parse(body);
        



        // Exibir e mainupalr os dados dos filmes no console

        for (Map<String,String> filme : ListaFilmes) {
            System.out.println(filme.get("title"));
            System.out.println(filme.get("image"));
            System.out.println(filme.get("imDbRating"));
            System.out.println();
            System.out.println("------------EU SO U O REI DO MUNDO!!---------------------");
            
        }
    }
}

