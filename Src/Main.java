import java.text.NumberFormat;
import java.util.*;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static final Conversor conversor = new Conversor();
    private static final List<String> historial = new ArrayList<>();

    // Mapa de locales para formatear según la moneda
    private static final Map<String, Locale> LOCALES = Map.of(
            "USD", Locale.US,
            "ARS", new Locale("es", "AR"),
            "BRL", new Locale("pt", "BR"),
            "EUR", Locale.GERMANY      // buen separador para €, se puede cambiar
    );

    public static void main(String[] args) {

        int opcion;

        do {
            mostrarMenu();
            opcion = leerEntero("Seleccione una opción: ");

            if (opcion >= 1 && opcion <= 5) {
                double valor = leerDouble("Ingrese el valor que desea convertir: ");
                procesarConversion(opcion, valor);
            } else if (opcion == 6) {
                System.out.println("¡Gracias por usar el conversor!");
            } else {
                System.out.println("Opción no válida.");
            }

        } while (opcion != 6);

        mostrarHistorial();
        scanner.close();
    }

    // ---------- Métodos auxiliares ----------

    private static void mostrarMenu() {
        System.out.println("\n--- Conversor de Monedas ---");
        System.out.println("1. Dólar (USD) → Peso Argentino (ARS)");
        System.out.println("2. Peso Argentino (ARS) → Dólar (USD)");
        System.out.println("3. Dólar (USD) → Real Brasileño (BRL)");
        System.out.println("4. Real Brasileño (BRL) → Dólar (USD)");
        System.out.println("5. Euro (EUR) → Dólar (USD)");
        System.out.println("6. Salir");
    }

    private static void procesarConversion(int opcion, double monto) {
        String from = "", to = "";

        switch (opcion) {
            case 1 -> { from = "USD"; to = "ARS"; }
            case 2 -> { from = "ARS"; to = "USD"; }
            case 3 -> { from = "USD"; to = "BRL"; }
            case 4 -> { from = "BRL"; to = "USD"; }
            case 5 -> { from = "EUR"; to = "USD"; }
        }

        double resultado = conversor.convertir(from, to, monto);

        NumberFormat nfFrom = NumberFormat.getCurrencyInstance(LOCALES.get(from));
        NumberFormat nfTo   = NumberFormat.getCurrencyInstance(LOCALES.get(to));

        String mensaje = String.format(
                "%s equivalen a %s",
                nfFrom.format(monto),
                nfTo.format(resultado)
        );

        System.out.println(mensaje);
        historial.add(mensaje);
    }

    // Lectura segura de entero
    private static int leerEntero(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("⚠️  Debe ingresar un número entero.");
            }
        }
    }

    // Lectura segura de double
    private static double leerDouble(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Double.parseDouble(scanner.nextLine().replace(',', '.'));
            } catch (NumberFormatException e) {
                System.out.println("⚠️  Debe ingresar un número válido (ej. 1234.56).");
            }
        }
    }

    private static void mostrarHistorial() {
        if (historial.isEmpty()) return;
        System.out.println("\n--- Historial de conversiones ---");
        historial.forEach(System.out::println);
    }
}
