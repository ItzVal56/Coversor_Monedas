import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class Conversor {

    // ▶️  Pega tu API-KEY aquí
    private static final String API_KEY = "b9249a0d88ede94a4fed35e5";
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/";

    /**
     * Convierte una cantidad usando la API.
     * @param from   Código ISO de la moneda origen (ej. "USD").
     * @param to     Código ISO de la moneda destino (ej. "ARS").
     * @param amount Monto a convertir.
     * @return valor convertido; 0 si falla.
     */
    public double convertir(String from, String to, double amount) {
        try {
            String urlStr = BASE_URL + API_KEY + "/pair/" + from + "/" + to + "/" + amount;
            URL url = new URL(urlStr);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            BufferedReader br = new BufferedReader(
                    new InputStreamReader(conn.getInputStream())
            );
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) sb.append(line);
            br.close();

            JSONObject json = new JSONObject(sb.toString());
            return json.getDouble("conversion_result");

        } catch (Exception e) {
            System.out.println("Error al conectar con la API: " + e.getMessage());
            return 0;
        }
    }
}
