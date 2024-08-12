/*
TAREFAS:
    20, máximo 5 por funcionário
    duração e prazo
    concluida ou falha
    prazo determina prioridade
FUNCIONÁRIOS:
    5, tarefas sorteadas
    trabalha até 8h/por dia
    1 tarefa por vez
SIMULAÇÃO:
    uma semana
    for - cria e atribui tarefa
    while - progresso tarefas (7 dias)
        if- ordenacao das tarefas
RELATÓRIO:
    concluida, falhas, horas trabalhadas, eficiencia
*/

package com.mycompany.projeto_10_thiago;

public class PROJETO_10_THIAGO {
    public static void main(String[] args) {
        int horasFunc1, horasFunc2, horasFunc3, horasFunc4, horasFunc5;
        int diasSimulacao = 7;
        int diasPassados = 0; 
        int qntTarefasFunc1, qntTarefasFunc2, qntTarefasFunc3, qntTarefasFunc4, qntTarefasFunc5;
            qntTarefasFunc1 = qntTarefasFunc2 =  qntTarefasFunc3 = qntTarefasFunc4 = qntTarefasFunc5 = 0;
        int concluidasFunc1, concluidasFunc2, concluidasFunc3, concluidasFunc4, concluidasFunc5;
            concluidasFunc1 = concluidasFunc2 = concluidasFunc3 = concluidasFunc4 = concluidasFunc5 = 0;
        int prazoTarefa1, prazoTarefa2, prazoTarefa3, prazoTarefa4, prazoTarefa5;
        int duracaoTarefa1, duracaoTarefa2, duracaoTarefa3, duracaoTarefa4, duracaoTarefa5;
            prazoTarefa1 = prazoTarefa2 = prazoTarefa3 = prazoTarefa4 = prazoTarefa5 = 0;
            duracaoTarefa1 = duracaoTarefa2 = duracaoTarefa3 = duracaoTarefa4 = duracaoTarefa5 = 0;
        int tarefaAtual = 0;
        int tarefaMenorPrazo = 0;
        int qntTarefas = 20;
        int qntFuncionarios = 5;
        int maxTarefasFunc = 5; //Determina quantas tarefas cada funcionário pode ter
        int minTarefasFunc = 1; 
        int maxPrazo = 7;
        int minPrazo = 0;
        int maxDuracao = 45;
        int minDuracao = 1;
        int tarefasRestantes = qntTarefas;
        int qntFuncRestantes = qntFuncionarios;
        double x = 0; // Usada para determinar se a quantidade de tarefas sorteado para o funcionário foi válida
        int qntTarefasSorteadas = 0; //Armazena a quantidade de tarefas que o funcionário foi sorteado
        boolean qntTarefasValidas;
        
        //Distribui a quantidade de tarefas para um funcionário
        for(int f = 1; f <= qntFuncionarios; ++f) {
            qntFuncRestantes = qntFuncionarios - f;
            qntTarefasValidas = false;
            while(!qntTarefasValidas) { 
                if (qntFuncRestantes > 0) {
                    qntTarefasSorteadas = (int) Math.floor(minTarefasFunc + Math.random() * (maxTarefasFunc - minTarefasFunc + 1) );
                    tarefasRestantes -= qntTarefasSorteadas;
                    x = (tarefasRestantes / qntFuncRestantes) + (double)(tarefasRestantes % qntFuncRestantes) / qntFuncRestantes;
                    //System.out.println(x);
                } else {
                    qntTarefasSorteadas = tarefasRestantes;
                    break;
                }         
                if(x < minTarefasFunc) {
                    --maxTarefasFunc;
                    tarefasRestantes += qntTarefasSorteadas;
                } else if(x > maxTarefasFunc) {
                    ++minTarefasFunc;
                    tarefasRestantes += qntTarefasSorteadas;
                } else
                   qntTarefasValidas = true;
            }  
            switch(f) {
                case 1 -> qntTarefasFunc1 = qntTarefasSorteadas;
                case 2 -> qntTarefasFunc2 = qntTarefasSorteadas;
                case 3 -> qntTarefasFunc3 = qntTarefasSorteadas;
                case 4 -> qntTarefasFunc4 = qntTarefasSorteadas;
                case 5 -> qntTarefasFunc5 = qntTarefasSorteadas;
            }
            
            prazoTarefa1 = prazoTarefa2 = prazoTarefa3 = prazoTarefa4 = prazoTarefa5 = 0;
            duracaoTarefa1 = duracaoTarefa2 = duracaoTarefa3 = duracaoTarefa4 = duracaoTarefa5 = 0;
            for(int t=1; t <= qntTarefasSorteadas; t++) {
                switch(f) {
                    case 1 -> {
                        prazoTarefa1 = (int) Math.floor(minPrazo + Math.random() * (maxPrazo - minPrazo + 1) );
                        duracaoTarefa1 = (int) Math.floor(minDuracao + Math.random() * (maxDuracao - minDuracao + 1) );
                    }
                    case 2 -> {
                        prazoTarefa2 = (int) Math.floor(minPrazo + Math.random() * (maxPrazo - minPrazo + 1) );
                        duracaoTarefa2 = (int) Math.floor(minDuracao + Math.random() * (maxDuracao - minDuracao + 1) );
                    }
                    case 3 -> {
                        prazoTarefa3 = (int) Math.floor(minPrazo + Math.random() * (maxPrazo - minPrazo + 1) );
                        duracaoTarefa3 = (int) Math.floor(minDuracao + Math.random() * (maxDuracao - minDuracao + 1) );
                    }
                    case 4 -> {
                        prazoTarefa4 = (int) Math.floor(minPrazo + Math.random() * (maxPrazo - minPrazo + 1) );
                        duracaoTarefa4 = (int) Math.floor(minDuracao + Math.random() * (maxDuracao - minDuracao + 1) );
                    }
                    case 5 -> {
                        prazoTarefa5 = (int) Math.floor(minPrazo + Math.random() * (maxPrazo - minPrazo + 1) );
                        duracaoTarefa5 = (int) Math.floor(minDuracao + Math.random() * (maxDuracao - minDuracao + 1) );
                    }
                }
            }
            tarefaMenorPrazo = prazoTarefa1;
            int tarefaAnterior = 0;
            int tarefaVerificada = 0;
            while(diasPassados++ < diasSimulacao) { // Ciclo de 7 dias para cada funcionário
                //Verifica se não tem tarefa ou se a anterior foi concluida (tarefaAtual = 0) e seleciona a próxima
                if(tarefaAtual == 0) {
                    //Verifica a tarefa com menor prazo disponível
                    for(int t=2; t <= qntTarefasSorteadas; t++) {
                        switch(t) {
                            case 2 -> {
                                tarefaAnterior = prazoTarefa1;
                                tarefaVerificada = prazoTarefa2;
                            }
                            case 3 -> {
                                tarefaAnterior = prazoTarefa2;
                                tarefaVerificada = prazoTarefa3;
                            }
                            case 4 -> {
                                tarefaAnterior = prazoTarefa3;
                                tarefaVerificada = prazoTarefa4;
                            }
                            case 5 -> {
                                tarefaAnterior = prazoTarefa4;
                                tarefaVerificada = prazoTarefa5;
                            }
                        }
                        if (tarefaVerificada < tarefaAnterior && tarefaVerificada != -1) {
                            switch(t) {
                                case 2 -> {
                                    tarefaMenorPrazo = 2;
                                }
                                case 3 -> {
                                    tarefaMenorPrazo = 3;
                                }
                                case 4 -> {
                                    tarefaMenorPrazo = 4;
                                }
                                case 5 -> {
                                    tarefaMenorPrazo = 5;
                                }
                            }
                        }
                            
                    }
                }
            }
            diasPassados = 0;
            tarefaAtual = 0;
            tarefaMenorPrazo = 0;
        }
        
        
        System.out.printf("%d  %d  %d  %d  %d (TOTAL: %d)\n", qntTarefasFunc1, qntTarefasFunc2, qntTarefasFunc3, qntTarefasFunc4, qntTarefasFunc5, (qntTarefasFunc1 + qntTarefasFunc2 +  qntTarefasFunc3 + qntTarefasFunc4 + qntTarefasFunc5));
    }
}
