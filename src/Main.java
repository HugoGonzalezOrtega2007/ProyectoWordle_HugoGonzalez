import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        // LISTA DE PALABRAS POSIBLES
        String[] palabras = {"manzana","arbol","coche","gato","perro","cielo","sol","luna","estrella","mar",
                "montana","rio","playa","arena","nube","lluvia","trueno","relampago","viento","fuego",
                "agua","tierra","flor","hoja","piedra","camino","puente","casa","puerta","ventana",
                "silla","mesa","libro","lapiz","pluma","papel","computadora","teclado","raton","pantalla",
                "carta","reloj","telefono","zapato","camisa","pantalon","sombrero","calcetin","guante","bufanda",
                "periodico","revista","radio","television","cine","pelicula","musica","cancion","instrumento","piano",
                "guitarra","bateria","violin","flauta","cuchara","tenedor","cuchillo","plato","vaso","taza",
                "pan","queso","leche","huevo","fruta","verdura","carne","pescado","pollo","arroz",
                "pasta","sopa","ensalada","helado","pastel","chocolate","dulce","azucar","sal","pimienta",
                "tren","avion","barco","bicicleta","moto","autobus","camion","metro","taxi","carretera"};

        int partidasAcertadas = 0;

        // MENSAJE DE BIENVENIDA
        System.out.println("BIENVENIDO AL WORDLE");
        System.out.println("Indice -- ✅: La letra está en la posicion exacta en la que la has colocado / ⚠️: La letra está en la palabra pero no en" +
                "esa posicion / ❌: La letra no está en la palabra");

        // BUCLE DE 10 PARTIDAS
        for (int partida = 1; partida <= 10; partida++) {
            System.out.println("---- PARTIDA " + partida + " ----");

            // SELECCIONAR PALABRA ALEATORIA
            String palabraSecreta = palabras[rand.nextInt(palabras.length)];
            int longitud = palabraSecreta.length();

            System.out.println("La palabra tiene " + longitud + " letras.");

            boolean acierto = false;
            int intentosMaximos = 5;
            String[][] intentosMatriz = new String[intentosMaximos][longitud];
            int intentosHechos = 0;

            // BUCLE DE INTENTOS HASTA ACERTAR O AGOTAR MAXIMOS
            while (!acierto && intentosHechos < intentosMaximos) {
                System.out.print("Introduce tu intento número " + (intentosHechos + 1) + ": ");
                String intento = sc.nextLine();

                if (intento.length() != longitud) {
                    System.out.println("El intento debe tener " + longitud + " letras.");
                    continue;
                }

                String[] resultado = new String[longitud];

                // COMPROBAR CADA LETRA DEL INTENTO
                for (int i = 0; i < longitud; i++) {
                    char letraIntento = intento.charAt(i);
                    char letraSecreta = palabraSecreta.charAt(i);

                    if (letraIntento == letraSecreta) {
                        resultado[i] = "✅";
                    } else if (palabraSecreta.indexOf(letraIntento) != -1) {
                        resultado[i] = "⚠️";
                    } else {
                        resultado[i] = "❌";
                    }

                    intentosMatriz[intentosHechos][i] = String.valueOf(letraIntento);
                }

                intentosHechos++;

                // IMPRIMIR RESULTADO DEL INTENTO
                for (int i = 0; i < resultado.length; i++) {
                    if (resultado[i] != null) {
                        System.out.print(resultado[i]);
                    } else System.out.print("");
                }
                System.out.println();

                // COMPROBAR SI EL JUGADOR ACERTÓ LA PALABRA
                if (intento.equals(palabraSecreta)) {
                    acierto = true;
                    partidasAcertadas++;
                    System.out.println("¡Felicidades! Has acertado la palabra.");
                }
            }

            // MOSTRAR PALABRA SI FALLÓ EL JUGADOR
            if (!acierto) {
                System.out.println("Has fallado, la palabra era: " + palabraSecreta);
            }
        }

        System.out.println("\n--- FIN DE LAS 10 PARTIDAS ---");
        System.out.println("Has acertado " + partidasAcertadas + " de 10 palabras.");
    }
}
