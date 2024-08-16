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
        int horasFunc1, horasFunc2, horasFunc3, horasFunc4, horasFunc5; // Horas em que os funcionários trabalharam em uma tarefa
        final int diasSimulacao = 7;
        int diasPassados = 0; // Controla quanto dias já foram concluidos
        int qntTarefasFunc1, qntTarefasFunc2, qntTarefasFunc3, qntTarefasFunc4, qntTarefasFunc5;
        int concluidasFunc1, concluidasFunc2, concluidasFunc3, concluidasFunc4, concluidasFunc5;
            concluidasFunc1 = concluidasFunc2 = concluidasFunc3 = concluidasFunc4 = concluidasFunc5 = 0;
        int prazoTarefa1, prazoTarefa2, prazoTarefa3, prazoTarefa4, prazoTarefa5; // Controle de prazo para cada funcionário
        int duracaoTarefa1, duracaoTarefa2, duracaoTarefa3, duracaoTarefa4, duracaoTarefa5;
            prazoTarefa1 = prazoTarefa2 = prazoTarefa3 = prazoTarefa4 = prazoTarefa5 = 0;
            duracaoTarefa1 = duracaoTarefa2 = duracaoTarefa3 = duracaoTarefa4 = duracaoTarefa5 = 0;
        int tarefaAtual = 0; // Determina o número da tarefa sendo executada
        int tarefaMenorPrazo = 0; // Identifica a tarefa que deve ser executada com base na prioridade (proximidade do prazo)
        int qntTarefas = 20; // Número de tarefas a serem distribuidas
        int qntFuncionarios = 5;
        int maxPrazo = 7;
        int minPrazo = 1;
        int maxDuracao = 45;
        int minDuracao = 1;
        int prazoSorteado;
        int duracaoSorteada;
        int tarefasRestantes = qntTarefas;
        int qntFuncRestantes = qntFuncionarios;
        int restoDuracaoTarefa = 0; // Armazena a quantidade de horas restantes no dia apos finalizar uma tarefa
        double x = 0; // Usada para determinar se a quantidade de tarefas sorteado para o funcionário foi válida
        int qntTarefasSorteadas = 0; //Armazena a quantidade de tarefas que o funcionário foi sorteado
        boolean qntTarefasValidas; // Controla a distribuição de tarefas. Se o número de tarefas que foi distribuido para o funcionario em questão é válido

        // Simulação
        int maxTarefasFunc = 5; //Determina quantas tarefas cada funcionário pode ter ao máximo
        int minTarefasFunc = 1; 
        for(int f = 1; f <= qntFuncionarios; ++f) {  // Simula o progresso de cada funcionário individualmente
            qntFuncRestantes = qntFuncionarios - f;
            qntTarefasValidas = false; // Teste
          
            // Distribui a quantidade de tarefas para um funcionário
            while(!qntTarefasValidas) { 
                if (qntFuncRestantes > 0) { // Calcula se o número de tarefas gerado pode ser usado, enquanto não for o último funcionário
                    qntTarefasSorteadas = (int) Math.floor(minTarefasFunc + Math.random() * (maxTarefasFunc - minTarefasFunc + 1) );
                    tarefasRestantes -= qntTarefasSorteadas;
                    x = (tarefasRestantes / qntFuncRestantes) + (double)(tarefasRestantes % qntFuncRestantes) / qntFuncRestantes; // Número de tarefas que os restantes funcionarios precisam obter caso o funcionário atual receba a quantidade de tarefas sorteado
                    // Verifica se o número de tarefas sorteado não atrapalha a geração das tarefas dos funcionários seguintes
                    if(x < minTarefasFunc) {
                      --maxTarefasFunc;
                      tarefasRestantes += qntTarefasSorteadas;
                    } else if(x > maxTarefasFunc) {
                      ++minTarefasFunc;
                      tarefasRestantes += qntTarefasSorteadas;
                    } else
                     qntTarefasValidas = true;
                } else { // Se for o último funcionário, recebe as tarefas restantes
                    qntTarefasSorteadas = tarefasRestantes;
                    break;
                }
            }
            
            switch(f) {
                case 1 -> {
                    qntTarefasFunc1 = qntTarefasSorteadas;
                }
                case 2 -> {
                    qntTarefasFunc2 = qntTarefasSorteadas;
                }
                case 3 -> {
                    qntTarefasFunc3 = qntTarefasSorteadas;
                }
                case 4 -> {
                    qntTarefasFunc4 = qntTarefasSorteadas;
                }
                case 5 -> {
                    qntTarefasFunc5 = qntTarefasSorteadas;
                }
            }
            System.out.println("TAREFAS FUNCIONÁRIO " + qntTarefasSorteadas);
            prazoTarefa1 = prazoTarefa2 = prazoTarefa3 = prazoTarefa4 = prazoTarefa5 = -1;
            duracaoTarefa1 = duracaoTarefa2 = duracaoTarefa3 = duracaoTarefa4 = duracaoTarefa5 = -1;
            prazoSorteado = 0;
            duracaoSorteada = 0;
            // Sorteio de prazo e duração das tarefas de cada funcionário
            for(int t=1; t <= qntTarefasSorteadas; t++) { // Itera entre as tarefas disponíveis e sorteia prazo e duração
                prazoSorteado = (int) Math.floor(minPrazo + Math.random() * (maxPrazo - minPrazo + 1) );
                duracaoSorteada = (int) Math.floor(minDuracao + Math.random() * (maxDuracao - minDuracao + 1) );
                switch(t) { // Distribui prazos e duração aleatórios entre tarefas
                    case 1 -> {
                        prazoTarefa1 = prazoSorteado;
                        duracaoTarefa1 = duracaoSorteada;
                    }
                    case 2 -> {
                        prazoTarefa2 = prazoSorteado;
                        duracaoTarefa2 = duracaoSorteada;
                    }
                    case 3 -> {
                        prazoTarefa3 = prazoSorteado;
                        duracaoTarefa3 = duracaoSorteada;
                    }
                    case 4 -> {
                        prazoTarefa4 = prazoSorteado;
                        duracaoTarefa4 = duracaoSorteada;
                    }
                    case 5 -> {
                        prazoTarefa5 = prazoSorteado;
                        duracaoTarefa5 = duracaoSorteada;
                    }
                }
            }
            System.out.printf("PRAZO SORTEADAS:   %d\t%d\t%d\t%d\t%d\n", prazoTarefa1, prazoTarefa2, prazoTarefa3, prazoTarefa4, prazoTarefa5);
            System.out.printf("DURACAO SORTEADAS: %d\t%d\t%d\t%d\t%d\n", duracaoTarefa1, duracaoTarefa2, duracaoTarefa3, duracaoTarefa4, duracaoTarefa5);
          
            tarefaMenorPrazo = prazoTarefa1;
            int tarefaAnterior = 0;
            int tarefaVerificada = 0;
            restoDuracaoTarefa = 0;
            while(diasPassados < diasSimulacao) { // Ciclo de 7 dias para cada funcionário
                System.out.printf("while\n");
                //Verifica se não tem tarefa ou se a anterior foi concluida ou cancelada (tarefaAtual = 0) e seleciona a próxima
                if(tarefaAtual == 0) {
                    //Verifica a tarefa com menor prazo disponível
                    for(int t=2; t <= qntTarefasSorteadas; t++) {
                        switch(t) { // Determina as tarefas que serão comparadas
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
                        if (tarefaVerificada < tarefaAnterior && tarefaVerificada != -1) { // Encontra a tarefa com menor prazo ainda ativa
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
                
                // Diminuir a duração da tarefa
                switch(tarefaAtual) {
                  case 1 -> {
                      if (duracaoTarefa1 > 8) {
                        duracaoTarefa1 -= 8;
                        restoDuracaoTarefa = 0; // Finaliza o dia
                      } else { // Duraçao igual ou menor a 8h
                        restoDuracaoTarefa = 8 - duracaoTarefa1; // Calcula o restante de horas restante no dia depois de concluir uma tarefa
                        duracaoTarefa1 = 0;
                      }

                      if (prazoTarefa1 > 0)
                          --prazoTarefa1;

                      if (prazoTarefa1 >= 0 && duracaoTarefa1 == 0) { // Tarefa concluida no prazo
                          concluidasFunc1++;
                          tarefaAtual = 0; // Define que é necessário procura a proxima
                      } else if (prazoTarefa1 == 0 && duracaoTarefa1 > 0) { // Tarefa fora do prazo
                          prazoTarefa1 = -1; // Exclui ela da verificação pra próxima tarefa
                          tarefaAtual = 0;
                      }
                  }
                  case 2 -> {

                  }
                  case 3 -> {

                  }
                  case 4 -> {

                  }
                  case 5 -> {

                  }
                }
                if (restoDuracaoTarefa == 0) {
                  diasPassados++;
                }
            System.out.printf("FUNC: %d - DIA: %d - TAREFA ATUAL: %d - PRAZO:   %d\t%d\t%d\t%d\t%d\n", f, diasPassados, tarefaAtual, prazoTarefa1, prazoTarefa2, prazoTarefa3, prazoTarefa4, prazoTarefa5);
            System.out.printf("DURACAO SORTEADAS: %d\t%d\t%d\t%d\t%d\n\n", duracaoTarefa1, duracaoTarefa2, duracaoTarefa3, duracaoTarefa4, duracaoTarefa5);
            }
        }
    }
}
