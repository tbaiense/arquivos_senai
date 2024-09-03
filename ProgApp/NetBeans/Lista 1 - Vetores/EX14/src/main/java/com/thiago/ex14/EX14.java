package com.thiago.ex14;

/** ALUNO: Thiago Moura Baiense
 *  14. Faça um algoritmo para ler e armazenar em um vetor a temperatura média de todos 
 *  os dias do ano. Calcular e escrever: a) Menor temperatura do ano b) Maior temperatura do 
 *  ano c) Temperatura média anual d) O número de dias no ano em que a temperatura foi 
 *  inferior a média anual.
 */
public class EX14 {

    public static void main(String[] args) {
        int menorTemp = 0; // Indice do dia com menor temperatura
        int maiorTemp = 0; // Indice do dia com menor temperatura
        int vezesMenor = 0;
        float mediaTemp = 0;
        double somaTemp = 0;
        
        float[] temperaturas = new float[365];
        final float TEMP_MIN = 10.0f;
        final float TEMP_MAX = 50.0f;
        
        for(int i=0; i < temperaturas.length; ++i) {
            somaTemp += temperaturas[i] = Math.round(TEMP_MIN + Math.random() * (TEMP_MAX - TEMP_MIN));
            if (temperaturas[i] < temperaturas[menorTemp])
                menorTemp = i;
            if (temperaturas[i] > temperaturas[maiorTemp])
                maiorTemp = i;
        }
        mediaTemp = (float)(somaTemp / 365);
        
        for (float temp : temperaturas)
            if (temp < mediaTemp)
                ++vezesMenor;
        
        System.out.printf("""
            a) Menor temperatura do ano: %2.1f
            b) Maior temperatura do ano: %2.1f
            c) Temperatura media anual: %2.1f
            d) O numero de dias no ano em que a temperatura foi inferior a media anual: %d
                          """, temperaturas[menorTemp], temperaturas[maiorTemp], mediaTemp, vezesMenor);
    }
}
