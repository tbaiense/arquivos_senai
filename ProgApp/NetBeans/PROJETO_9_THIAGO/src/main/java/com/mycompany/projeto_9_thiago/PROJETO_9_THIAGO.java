package com.mycompany.projeto_9_thiago;
import java.util.Scanner;

public class PROJETO_9_THIAGO {

    public static void main(String[] args) {
        // Declaração e inicialização de variáveis
        short TEMPO_SIMULACAO = 600;
        short TEMPO_VERDE = 30;      // |
        short TEMPO_AMARELO = 5;     // | Tempo limite de cada estado do semáforo em segundos. 
        short TEMPO_VERMELHO = 45;   // | Ao chegar em 0, o semáforo muda de estado
        short estadoSem1, estadoSem2, estadoSem3; // Armazena o estado do semáforo. 1 = verde, 0 = amarelo, -1 = vermelho
            estadoSem1 = estadoSem2 = estadoSem3 = 1;
        short tempoSem1, tempoSem2, tempoSem3; // Armazena o tempo restante do semáforo no estado atual
            tempoSem1 = tempoSem2 = tempoSem3 = TEMPO_VERDE;
        short filaSem1, filaSem2, filaSem3;
            filaSem1 = filaSem2 = filaSem3 = 8;
        short carrosForaSem1, carrosForaSem2, carrosForaSem3;
            carrosForaSem1 = carrosForaSem2 = carrosForaSem3= 0;
        int totalCarrosInt1, totalCarrosInt2, totalCarrosInt3; // Total de carros que passaram por cada interseção, adicionado em um a cada carro que passa pelo semáforo
            totalCarrosInt1 = totalCarrosInt2 = totalCarrosInt3= 0;
        int esperaTotalFila1, esperaTotalFila2, esperaTotalFila3; // Armazena a soma total de tempo de espera em segundos
            esperaTotalFila1 = esperaTotalFila2 = esperaTotalFila3 = 0;
        int esperaMediaFila1, esperaMediaFila2, esperaMediaFila3; // Armazena a media do tempo de espera em segundos de cada fila
        short MAX_CARROS_FILA = 10; // Determina a quantidade máxima de carros que podem estar na fila de um semáforo. Os excedentes ficarão fora da interseção (armazenados em "carrosForaSem1", 2 e 3)
        short INTERVALO_CARROS_CHEGANDO = 15; // Determina de quanto em quanto tempo carros novos devem ser adicionados à fila (sorteado entre 0 e 8)
        short MIN_CARROS_CHEGANDO = 0; 
        short MAX_CARROS_CHEGANDO = 10;
        String estado;
        
        // Controle de simulação semáforo 1
        for(short segPassados = 0; segPassados < TEMPO_SIMULACAO; segPassados++) {
            // Simulação carros passando semáforo
            if (estadoSem1 == 1) {
                while(filaSem1 >= 1 && tempoSem1 > 0 && segPassados < TEMPO_SIMULACAO) {
                    esperaTotalFila1 += filaSem1 - 1; /* Quando o sinal está aberto, a soma das esperas, em segundos, 
                                                        depende de quantos carros estão na fila. A espera de cada 
                                                        carro depende de quantos carros estão na sua frente, 
                                                        considerando que cada carro leva 1 segundo para atravessar 
                                                        o sinal ou avançar uma posição na fila. */
                    
                    // Adiciona carros fora da interseção a cada intervalo especificado
                    if (segPassados % INTERVALO_CARROS_CHEGANDO == 0) {
                        carrosForaSem1 += (short)(Math.round( MIN_CARROS_CHEGANDO + Math.random() * (MAX_CARROS_CHEGANDO - MIN_CARROS_CHEGANDO) ));
                    }
                    if(carrosForaSem1 >= 1 && filaSem1 < MAX_CARROS_FILA) {
                        --carrosForaSem1;
                    } else {
                        --filaSem1;
                    }
                    
                    ++totalCarrosInt1;
                    --tempoSem1;
                    ++segPassados;
                    
                    System.out.printf("%d SEM1: VERDE\n", segPassados);
                }
            }
            
            //Controle de semáforo 1
            if (tempoSem1 > 0) {// Ainda resta tempo em semáforo 1
                esperaTotalFila1 += filaSem1;
                // Adiciona carros fora da interseção a cada intervalo especificado
                if (segPassados % INTERVALO_CARROS_CHEGANDO == 0) {
                    carrosForaSem1 += (short)(Math.round( MIN_CARROS_CHEGANDO + Math.random() * (MAX_CARROS_CHEGANDO - MIN_CARROS_CHEGANDO) ));
                }
                if(carrosForaSem1 >= 1 && filaSem1 < MAX_CARROS_FILA) {
                    ++filaSem1;
                    --carrosForaSem1;
                }
                --tempoSem1;
                
                estado = switch(estadoSem1) {
                    case 1 -> {
                        yield "VERDE";
                    }
                    case 0 -> {
                        yield "AMARELO";
                    }
                    default -> {
                        yield "VERMELHO";
                    }
                };
                System.out.printf("%d SEM1: %s\n", segPassados, estado);
            } else { // Tempo acabou e é preciso mudar o estado
                estadoSem1 = switch(estadoSem1) {
                    case 1 -> { // Se verde
                        tempoSem1 = TEMPO_AMARELO;
                        yield 0; // Muda para amarelo
                    }
                    case 0 -> { // Se amarelo
                        tempoSem1 = TEMPO_VERMELHO;
                        yield -1; // Muda para vermelho
                    }
                    default -> { // Se vermelho
                        tempoSem1 = TEMPO_VERDE;
                        yield 1; // Muda para verde
                    }
                };
            } 
        }
        // Controle de simulação semáforo 2
        for(short segPassados = 0; segPassados < TEMPO_SIMULACAO; segPassados++) {
            // Simulação carros passando semáforo
            if (estadoSem2 == 1) {
                while(filaSem2 >= 1 && tempoSem2 > 0 && segPassados < TEMPO_SIMULACAO) {
                    esperaTotalFila2 += filaSem2 - 1; /* Quando o sinal está aberto, a soma das esperas, em segundos, 
                                                        depende de quantos carros estão na fila. A espera de cada 
                                                        carro depende de quantos carros estão na sua frente, 
                                                        considerando que cada carro leva 1 segundo para atravessar 
                                                        o sinal ou avançar uma posição na fila. */
                    
                    // Adiciona carros fora da interseção a cada intervalo especificado
                    if (segPassados % INTERVALO_CARROS_CHEGANDO == 0) {
                        carrosForaSem2 += (short)(Math.round( MIN_CARROS_CHEGANDO + Math.random() * (MAX_CARROS_CHEGANDO - MIN_CARROS_CHEGANDO) ));
                    }
                    if(carrosForaSem2 >= 1 && filaSem2 < MAX_CARROS_FILA) {
                        --carrosForaSem2;
                    } else {
                        --filaSem2;
                    }
                    
                    ++totalCarrosInt2;
                    --tempoSem2;
                    ++segPassados;
                    System.out.printf("%d SEM2: VERDE\n", segPassados);
                }
            }
            
            //Controle de semáforo 2
            if (tempoSem2 > 0) {// Ainda resta tempo em semáforo 2
                esperaTotalFila2 += filaSem2;
                // Adiciona carros fora da interseção a cada intervalo especificado
                if (segPassados % INTERVALO_CARROS_CHEGANDO == 0) {
                    carrosForaSem2 += (short)(Math.round( MIN_CARROS_CHEGANDO + Math.random() * (MAX_CARROS_CHEGANDO - MIN_CARROS_CHEGANDO) ));
                }
                if(carrosForaSem2 >= 1 && filaSem2 < MAX_CARROS_FILA) {
                    ++filaSem2;
                    --carrosForaSem2;
                }
                --tempoSem2;
                estado = switch(estadoSem2) {
                    case 1 -> {
                        yield "VERDE";
                    }
                    case 0 -> {
                        yield "AMARELO";
                    }
                    default -> {
                        yield "VERMELHO";
                    }
                };
                System.out.printf("%d SEM2: %s\n", segPassados, estado);
            } else { // Tempo acabou e é preciso mudar o estado
                estadoSem2 = switch(estadoSem2) {
                    case 1 -> { // Se verde
                        tempoSem2 = TEMPO_AMARELO;
                        yield 0; // Muda para amarelo
                    }
                    case 0 -> { // Se amarelo
                        tempoSem2 = TEMPO_VERMELHO;
                        yield -1; // Muda para vermelho
                    }
                    default -> { // Se vermelho
                        tempoSem2 = TEMPO_VERDE;
                        yield 1; // Muda para verde
                    }
                };
            } 
        }
        // Controle de simulação semáforo 3
        for(short segPassados = 0; segPassados < TEMPO_SIMULACAO; segPassados++) {
            // Simulação carros passando semáforo
            if (estadoSem3 == 1) {
                while(filaSem3 >= 1 && tempoSem3 > 0 && segPassados < TEMPO_SIMULACAO) {
                    esperaTotalFila3 += filaSem3 - 1; /* Quando o sinal está aberto, a soma das esperas, em segundos, 
                                                        depende de quantos carros estão na fila. A espera de cada 
                                                        carro depende de quantos carros estão na sua frente, 
                                                        considerando que cada carro leva 1 segundo para atravessar 
                                                        o sinal ou avançar uma posição na fila. */
                    
                    // Adiciona carros fora da interseção a cada intervalo especificado
                    if (segPassados % INTERVALO_CARROS_CHEGANDO == 0) {
                        carrosForaSem3 += (short)(Math.round( MIN_CARROS_CHEGANDO + Math.random() * (MAX_CARROS_CHEGANDO - MIN_CARROS_CHEGANDO) ));
                    }
                    if(carrosForaSem3 >= 1 && filaSem3 < MAX_CARROS_FILA) {
                        --carrosForaSem3;
                    } else {
                        --filaSem3;
                    }
                    
                    ++totalCarrosInt3;
                    --tempoSem3;
                    ++segPassados;
                    System.out.printf("%d SEM3: VERDE\n", segPassados);
                }
            }
            
            //Controle de semáforo 3
            if (tempoSem3 > 0) {// Ainda resta tempo em semáforo 3
                esperaTotalFila3 += filaSem3;
                // Adiciona carros fora da interseção a cada intervalo especificado
                if (segPassados % INTERVALO_CARROS_CHEGANDO == 0) {
                    carrosForaSem3 += (short)(Math.round( MIN_CARROS_CHEGANDO + Math.random() * (MAX_CARROS_CHEGANDO - MIN_CARROS_CHEGANDO) ));
                }
                if(carrosForaSem3 >= 1 && filaSem3 < MAX_CARROS_FILA) {
                    ++filaSem3;
                    --carrosForaSem3;
                }
                --tempoSem3;
                
                estado = switch(estadoSem3) {
                    case 1 -> {
                        yield "VERDE";
                    }
                    case 0 -> {
                        yield "AMARELO";
                    }
                    default -> {
                        yield "VERMELHO";
                    }
                };
                System.out.printf("%d SEM3: %s\n", segPassados, estado);
                
            } else { // Tempo acabou e é preciso mudar o estado
                estadoSem3 = switch(estadoSem3) {
                    case 1 -> { // Se verde
                        tempoSem3 = TEMPO_AMARELO;
                        yield 0; // Muda para amarelo
                    }
                    case 0 -> { // Se amarelo
                        tempoSem3 = TEMPO_VERMELHO;
                        yield -1; // Muda para vermelho
                    }
                    default -> { // Se vermelho
                        tempoSem3 = TEMPO_VERDE;
                        yield 1; // Muda para verde
                    }
                };
            } 
        }
        
        System.out.printf("\n\nRELATÓRIO FINAL ---------------------------------------\nSEM 1 >>> CARROS PASSADOS: %d | Tempo médio de espera: %1.3f seg.| CARROS CONGESTIONADOS: %d\n", totalCarrosInt1, ((float) esperaTotalFila1 / totalCarrosInt1),carrosForaSem1);
        System.out.printf("SEM 2 >>> CARROS PASSADOS: %d | Tempo médio de espera: %1.3f seg.| CARROS CONGESTIONADOS: %d\n", totalCarrosInt2, ((float) esperaTotalFila2 / totalCarrosInt2),carrosForaSem2);
        System.out.printf("SEM 3 >>> CARROS PASSADOS: %d | Tempo médio de espera: %1.3f seg.| CARROS CONGESTIONADOS: %d\n", totalCarrosInt3, ((float) esperaTotalFila3 / totalCarrosInt3),carrosForaSem3);
        
    }
}
