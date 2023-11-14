// Trabalho 1 - Backtracking
// Algoritmo Força Bruta para resolver o problema da soma dos subconjuntos
// Alunos: Arthur Santiago Loschi Ruiz e Daniel Gomes Benevides
// Professor: Daniel Capanema
// Disciplina: Projeto e Análise de Algoritmos
// Última modificação: 13/11/2023


import java.util.Arrays;

public class ForcaBruta {

    static Boolean flag = false;

    public static void main(String[] args) {
        int[] conjunto = { 5, 34, 9, 14, 95, 62, 23, 41, 49, 63, 58, 50, 35, 11, 44, 26, 54, 31, 45, 43, 94, 17, 77, 47, 70, 76, 2, 93, 69, 33, 55, 8, 99, 86, 57, 10, 83, 98, 7, 60, 73, 48, 100, 28, 4, 22, 72, 65, 39, 79 };
        int somaDesejada = 120;

        long tempoInicio = System.nanoTime();
        somaSubconjuntos(conjunto, somaDesejada);
        long tempoFinal = System.nanoTime();
        Double tempo = ((tempoFinal - tempoInicio) / 1000000.0);
        System.out.println("Tempo Força Bruta: " + tempo + " milisegundos");
    }

    // Método para encontrar os subconjuntos com a soma desejada usando força bruta
    static void imprimirSubconjunto(int[] conjunto, int[] incluido) {
        System.out.print("{ ");
        for (int i = 0; i < incluido.length; i++) {
            if (incluido[i] == 1) {
                System.out.print(conjunto[i] + " ");
            }
        }
        System.out.println("}");
    }

    static void somaSubconjuntos(int[] conjunto, int somaDesejada) {
        Arrays.sort(conjunto); // Ordena o conjunto para evitar duplicatas
        int[] incluido = new int[conjunto.length];
        subconjuntosForcaBruta(conjunto, 0, incluido, 0, somaDesejada);
    }

    static void subconjuntosForcaBruta(int[] conjunto, int indice, int[] incluido, int somaAtual, int somaDesejada) {
        if (flag == false) {
            if (somaAtual == somaDesejada) {
                flag = true;
                imprimirSubconjunto(conjunto, incluido);
                return;
            }

            for (int i = indice; i < conjunto.length; i++) {
                if (flag == false) {
                    incluido[i] = 1;
                    subconjuntosForcaBruta(conjunto, i + 1, incluido, somaAtual + conjunto[i], somaDesejada);
                    incluido[i] = 0;
    
                    // Pular elementos duplicados
                    while (i < conjunto.length - 1 && conjunto[i] == conjunto[i + 1]) {
                        i++;
                    }
                } else {
                    return;
                }
            }
        }
    }
}