package com.thiago.projeto_14_thiago;

import java.io.DataInputStream;
import java.io.IOException;

public class PROJETO_14_THIAGO {

    public static void main(String[] args) throws IOException {
        final int TAM = 5;
        int[][] matriz = new int[TAM][TAM];
        int somaLinhas[] = new int[TAM];
        int somaColunas[] = new int[TAM];
        int somaDiag[] = new int[2];
        
        // Preenchimento do vetor
        for(int l=0,i=0; l < TAM; ++l) {
            for(int c=0; c < TAM; ++c) {
                System.out.print((l+1)+" - "+(c+1)+". num: ");
                while (true) {
                    try {
                        DataInputStream in = new DataInputStream(System.in);
                        matriz[l][c] = Integer.parseInt(in.readLine());
                        //System.out.println(matriz[l][c] = (int)Math.round(Math.random() * 200));
                        break;
                    } catch (NumberFormatException e ) {
                        System.out.println("ERRO: numero invalido. Tente novamente: ");
                    }
                }
            } 
        }
        // Exibição do vetor
        System.out.println("\n# MATRIZ ORIGINAL --------------------");
        for(int l=0; l<TAM; ++l) {
            for(int c=0; c<TAM; ++c) {
                int n = matriz[l][c];
                System.out.printf("%3d ",n);
            }
            System.out.println("");
        }
        
        // Ordenacao selecao
        for(int fl=TAM-1, fc=TAM-1; fl>=0; /*controle no final*/) {
            
            // Selecionar o maior número
            int lMaior=0, cMaior=0;
            for(int posL=0, posC=0; posL<=fl;) {
                if (matriz[posL][posC] > matriz[lMaior][cMaior]) {
                    lMaior = posL;
                    cMaior = posC;
                }
                //Controle de posicao
                ++posC;
                if (posL < fl && posC >= TAM || posL == fl && posC > fc|| fl == 0 && posC > fc) {
                    posC=0;
                    ++posL;
                }
            }
            
            // Posiciona o maior numero nas posicoes finais
            int copia = matriz[fl][fc];
            matriz[fl][fc] = matriz[lMaior][cMaior];
            matriz[lMaior][cMaior] = copia;
            
            //Controle de final
            --fc;
            if(fc < 0) {
                --fl;
                fc = TAM-1;
            }
        }
        
        System.out.println("\n# MATRIZ ORDENADA --------------------");
        int[][] repeticoes = new int[2][TAM*TAM]; // Armazena os números repetidos ([0][n] > numeros, [1][n] > qnt repeticao
        int qntRegistrados=0;
        for(int l=0; l<TAM; ++l) {
            for(int c=0; c<TAM; ++c) {
                int n = matriz[l][c];
                somaLinhas[l] += n;
                somaColunas[c] += n;
                System.out.printf("%3d ",n);
                // Verificação de numeros repetidos
                boolean encontrado=false;
                for(int rn = 0; rn < repeticoes[0].length || rn < qntRegistrados; ++rn) { // Procura se o número já foi registrado antes
                    
                    if (repeticoes[0][rn] == n && repeticoes[1][rn] != 0) {
                        ++qntRegistrados;
                        encontrado = true;
                        ++repeticoes[1][rn]; // Incrementa vezes
                        break;
                    }   
                }
                
                if(!encontrado) {          
                    repeticoes[0][qntRegistrados] = n;
                    repeticoes[1][qntRegistrados] = 1;
                    ++qntRegistrados;
                }
            }
            System.out.println("");
        }
        
        
        // Soma de cada linha e cada coluna da matriz, e exibir essas somas
        System.out.println("\n# SOMA DE LINHAS E COLUNAS --------------------\nCol.:");
        for(int c : somaColunas)
            System.out.printf("%3d ", c);
        System.out.println("\nLinhas:");
        for(int l : somaLinhas)
            System.out.printf("%3d\n",l);
        System.out.println("\n# NUMERO DE REPETICOES --------------------");
        for(int c=0; c < TAM*TAM; ++c) {
            if(repeticoes[1][c] > 1) {
                System.out.println(repeticoes[0][c] + ": " + (repeticoes[1][c]-1));
            }
        }
        System.out.println("\n# SOMA DE DIAGONAIS --------------------");
        if (TAM % 2 != 0) {
            for (int idp=0, ids=TAM-1; idp>=0 && ids>=0; idp++, ids--) {
                somaDiag[0] += matriz[idp][idp];
                somaDiag[1] += matriz[idp][ids];
            }
        } else {
            System.out.println("ERRO: SOMA INDISPONIVEL");
        }
        System.out.println("PRIMARIA: " + somaDiag[0]);
        System.out.println("SEGUNDARIA: " + somaDiag[1]);
        
        //Substituicao de primos por -1
        System.out.println("\n# NOVA MATRIZ (PRIMOS -> -1) --------------------");
        for(int l=0; l<TAM; ++l) {
            for(int c=0; c<TAM; ++c) {
                int n = matriz[l][c];
                boolean ePrimo=true;
                if (n % 2 != 0 && n > 2) { // Se for par, não é primo. Exceto 2
                    for(int d=n-2; d > 1; --d) {
                        if (n % d == 0) {
                            ePrimo =false;
                            break;
                        }
                    }
                    if(ePrimo) {
                        matriz[l][c] = -1;
                    } 
                } else if (n == 2) {
                    matriz[l][c] = -1;
                }
                System.out.printf("%3d ",matriz[l][c]);
            }
            System.out.println("");
        }
    }
}
