// Trabalho 1 - Backtracking
// Algoritmo Backtracking para resolver o problema da soma dos subconjuntos
// Alunos: Arthur Santiago Loschi Ruiz e Daniel Gomes Benevides
// Professor: Daniel Capanema
// Disciplina: Projeto e Análise de Algoritmos
// Última modificação: 12/11/2023

import java.util.ArrayList;
import java.util.List;

public class Backtracking {
    public static void main(String[] args) {
        int lista[] = {5, 191, 140, 81, 34, 184, 185, 83, 13, 43, 137, 146, 113, 180, 123, 166, 60, 74, 46, 2, 94, 30, 31, 6, 17, 93, 27, 167, 198, 65, 91, 159, 182, 19, 78, 130, 148, 126, 88, 160, 174, 55, 54, 118, 161, 49, 72, 80, 169, 158, 127, 42, 155, 124, 119, 199, 69, 102, 162, 135, 85, 173, 56, 51, 25, 28, 195, 16, 53, 82, 38, 144, 32, 59, 36, 61, 37, 175, 63, 145, 149, 112, 11, 26, 24, 129, 64, 176, 20, 186, 21, 121, 117, 109, 10, 189, 114, 197, 128, 1};
        List<Integer> subconjunto = new ArrayList<Integer>();
        int alvo = 784;
        long tempoInicioBT = System.nanoTime();
        subconjuntosBacktracking(lista, 0, 0, alvo, subconjunto);
        long tempoFinalBT = System.nanoTime();

        System.out.println("Tempo Backtracking: " + ((tempoFinalBT - tempoInicioBT) / 1000000.0) + " milisegundos");
    }

    // Método para encontrar os subconjuntos com a soma desejada usando backtracking
    static void subconjuntosBacktracking(int list[], int soma, int posicaoInicial, int somaAlvo, List<Integer> subconjunto) 
    { 
        // Imprime o subconjunto se a soma for igual ao somaAlvo
        if( somaAlvo == soma ) { 
            System.out.println(subconjunto);
            if (subconjunto.size() > 0) {
                subconjunto.remove(subconjunto.size() - 1);
            }
            // Encontra o próximo elemento do subconjunto
            if(posicaoInicial < list.length) {
                subconjuntosBacktracking(list, soma - list[posicaoInicial-1], posicaoInicial, somaAlvo, subconjunto);
                subconjunto.add(list[posicaoInicial-1]);
            }
        } 
        // Se a soma for maior que o somaAlvo, remove o último elemento do subconjunto
        else if (somaAlvo < soma) {
            if (subconjunto.size() > 0) {
                subconjunto.remove(subconjunto.size() - 1);
            }
        } 
        // 
        else { 
            for( int i = posicaoInicial; i < list.length; i++ ) 
            { 
                subconjunto.add(list[i]);
                subconjuntosBacktracking(list, soma + list[i], i + 1, somaAlvo, subconjunto);
            } 
            if (subconjunto.size() > 0) {
                subconjunto.remove(subconjunto.size() - 1);
            }
        } 
    } 
}
