# ---

**08/2024** 

# ---

**Especificação de Requisitos de Software**

**NOME DO PROJETO AQUI** 

**Versão 1.2**

**HISTÓRICO DA REVISÃO**   
 

| Data  | Versão  | Descrição  | Autor |
| ----- | ----- | ----- | ----- |
| 31/08/2024  | 1.0  | Introdução ao Projeto  | Thiago e Vanderson |
| 06/09/2024  | 1.1  | Adicionados descrição inicial e requisitos funcionais | Thiago e Vanderson |
| 07/09/2024  | 1.2  | Adicionados requisitos RF07 a RF10 | Valentin e Franquilei |
| dd/mm/2024  | 1.x  | Atividade  | Responsável |

**TABELA DE CONTEÚDO**  

[**1\. INTRODUÇÃO	5**](#introdução)

[1.1. FINALIDADE	5](#finalidade)

[1.2. ESCOPO	5](#escopo)

[1.3. DEFINIÇÕES, ACRÔNIMOS, E ABREVIAÇÕES (modificado\!)	5](#definições,-acrônimos,-e-abreviações-\(modificado!\))

[**2\. DESCRIÇÃO GERAL	6**](#descrição-geral)

[2.1. FATORES GERAIS QUE AFETAM O PROJETO E SEUS REQUISITOS	6](#fatores-gerais-que-afetam-o-projeto-e-seus-requisitos)

[2.1.1. Perfil de necessidade de acesso	6](#perfil-de-necessidade-de-acesso)

[2.1.2. Perfil de usuário	6](#perfil-de-usuário)

[2.1.3. Modelo de negócio alvo	7](#modelo-de-negócio-alvo)

[**3\. REQUISITOS ESPECÍFICOS	7**](#requisitos-específicos)

[3.1. REQUISITOS FUNCIONAIS	7](#requisitos-funcionais)

[3.1.1. \[RF 01\] Cadastro de clientes (modificado\!)	7](#[rf-01]-cadastro-de-clientes-\(modificado!\))

[3.1.2. \[RF 02\] Alteração do cadastro de clientes (novo\!)	7](#[rf-02]-alteração-do-cadastro-de-clientes-\(novo!\))

[3.1.3. \[RF 03\] Gestão de produtos	8](#[rf-03]-gestão-de-produtos)

[3.1.4. \[RF 04\] Processo de cadastro de pedidos	8](#[rf-04]-processo-de-cadastro-de-pedidos)

[3.1.5. \[RF 05\] Informações de entrega dos pedidos (novo\!)	8](#[rf-05]-informações-de-entrega-dos-pedidos-\(novo!\))

[3.1.6. \[RF 06\] Informações do solicitante dos pedidos (novo\!)	8](#[rf-06]-informações-do-solicitante-dos-pedidos-\(novo!\))

[3.1.7. \[RF 07\] Informações dos produtos dos pedidos (novo\!)	9](#[rf-07]-informações-dos-produtos-dos-pedidos-\(novo!\))

[3.1.8. \[RF 08\] Controle de estado de pedido (modificado\!)	9](#[rf-08]-controle-de-estado-de-pedido-\(modificado!\))

[3.1.9. \[RF 09\] Controle de pagamento de pedidos (novo\!)	9](#[rf-09]-controle-de-pagamento-de-pedidos-\(novo!\))

[3.1.10. \[RF 10\] Alteração de pedidos (modificado\!)	9](#[rf-10]-alteração-de-pedidos-\(modificado!\))

[3.1.11. \[RF 11\] Pesquisa de pedidos	10](#[rf-11]-pesquisa-de-pedidos)

[3.1.12. \[RF 12\] Gestão promocional	10](#[rf-12]-gestão-promocional)

[3.1.13. \[RF 13\] Relatórios	10](#[rf-13]-relatórios)

[3.1.14. \[RF 14\] Requisito de cópia (novo\!)	10](#[rf-14]-requisito-de-cópia-\(novo!\))

[3.1.15. \[RF 15\] Gerenciamento de usuários (novo\!)	10](#[rf-15]-gerenciamento-de-usuários-\(novo!\))

[3.1.16. \[RF 16\] Visualização organizada de pedidos (novo\!)	10](#[rf-16]-visualização-organizada-de-pedidos-\(novo!\))

[3.1.17. \[RF 17\] Cadastro/Login de usuários (novo\!)	11](#[rf-17]-cadastro/login-de-usuários-\(novo!\))

[3.1.18. \[RF 18\] Registro de intercorrência (novo\!)	11](#[rf-18]-registro-de-intercorrência-\(novo!\))

[3.2. REQUISITOS DE PERFORMANCE	11](#requisitos-de-performance)

[3.2.1. \[RNF 01\] Título requisito	11](#[rnf-01]-título-requisito)

[3.2.2. \[RNF 02\] Título requisito	11](#[rnf-02]-título-requisito)

[3.3. REQUISITOS DE SEGURANÇA	11](#requisitos-de-segurança)

[3.3.1. \[RNF n\] Controle de alteração de dados (novo\!)	11](#[rnf-n]-controle-de-alteração-de-dados-\(novo!\))

[3.3.2. \[RNF n\] Pedidos pagos/entregues (novo\!)	11](#[rnf-n]-pedidos-pagos/entregues-\(novo!\))

[3.3.3. \[RNF n\] Requisitos de Segurança 3	12](#[rnf-n]-requisitos-de-segurança-3)

[3.3.4. \[RNF n\] Requisitos de Segurança 4	12](#[rnf-n]-requisitos-de-segurança-4)

[3.4. OUTROS REQUISITOS	12](#outros-requisitos)

[3.4.1. \[RNF n\] Navegação por atalhos de teclado (novo\!)	12](#[rnf-n]-navegação-por-atalhos-de-teclado-\(novo!\))

[3.4.2. \[RNF n\] Requisitos de Usabilidade	12](#[rnf-n]-requisitos-de-usabilidade)

[3.4.3. \[RNF n\] Requisitos de Confiabilidade	12](#[rnf-n]-requisitos-de-confiabilidade)

[**4\. MODELO DE ENTIDADE E RELACIONAMENTO LÓGICO	12**](#modelo-de-entidade-e-relacionamento-lógico)

[**5\. DIAGRAMA DE CLASSES	12**](#diagrama-de-classes)

[**6\. CASO DE USO	12**](#caso-de-uso)

[6.1. CASO 1	13](#caso-1)

[6.2. CASO 2	14](#caso-2)

[**7\. DICIONÁRIO DE DADOS:	15**](#dicionário-de-dados:)

[7.1. ATRIBUTOS	15](#atributos)

[7.2. OUTRA COISA	15](#outra-coisa)

[**8\. PROTOTIPAGEM	15**](#prototipagem)

[9\. REFERÊNCIAS	15](#referências)

# **Especificação de Requisitos de Software**  

1. # **INTRODUÇÃO**   {#introdução}

Este documento aborda os principais aspectos do funcionamento do **NOME DO SISTEMA**, uma solução para gestão de pedidos. Adiante serão apresentados os pontos fundamentais que a solução deverá conter para cumprir sua finalidade, detalhando os requisitos funcionais e não funcionais da sua implementação, além dos diagramas complementares necessários ao entendimento e desenvolvimento do projeto.

1. ## FINALIDADE  {#finalidade}

A finalidade deste projeto é de proporcionar uma solução capaz de auxiliar micro e pequenas empresas a gerenciar o cadastro e o controle dos pedidos recebidos de seus clientes, proporcionando mais eficiência nos processos e diminuindo desperdícios de tempo associados ao gerenciamento manual de pedidos.

2. ## ESCOPO  {#escopo}

A solução proposta tem como escopo atender às necessidades de micro e pequenas empresas que exercem suas atividades por meio de geração de pedidos, como salgaderias, confeitarias, padarias, lanchonetes, restaurantes, além de outros segmentos não relacionados à alimentação, como vendedores autônomos e representantes comerciais. 

3. ## DEFINIÇÕES, ACRÔNIMOS, E ABREVIAÇÕES **(modificado\!)** {#definições,-acrônimos,-e-abreviações-(modificado!)}

* **Micro e pequenas empresas** – empresas consideradas de pequeno porte, seguindo o critério de classificação por número de funcionários do IBGE para empresas com atividades relacionadas ao comércio e serviços;

* **Cliente** – Aquele que solicita o pedido;

* **Pedido** — Registro formal da solicitação do cliente, contendo informações do(s)  produto(s) que será(ão) fornecido(s), de entrega (se aplicável), do cliente solicitante e do destinatário;

* **Destinatário** – Responsável pelo recebimento dos produtos do pedido no ato da entrega;

* **Entrega** – Ato do fornecimento dos produtos ao destinatário, seja por meio de transporte dos produtos até o endereço do destinatário ou com o destinatário recebendo os produtos no local de preparo dos pedidos;

* **Usuário** – Aquele que usa a solução com algum nível de permissão, de acordo com os cargos atribuídos a este;

* **Administrador** – Cargo de usuário com todas as permissões concedidas;

* **Atendente** – Cargo de usuário com permissão para cadastrar, visualizar, pesquisar e alterar pedidos, além de cadastrar, visualizar, pesquisar e alterar informações de clientes;

* **Gestor de pedidos** – Cargo de usuário com permissões de alteração dos pedidos e de gerenciamento do estado dos pedidos;

* **Gerente** – Cargo de usuário com permissões para cadastrar, visualizar, pesquisar e alterar produtos, e alterar o cadastro de clientes e pedidos.

2. # **DESCRIÇÃO GERAL**   {#descrição-geral}

   1. ## FATORES GERAIS QUE AFETAM O PROJETO E SEUS REQUISITOS {#fatores-gerais-que-afetam-o-projeto-e-seus-requisitos}

      1. ### **Perfil de necessidade de acesso** {#perfil-de-necessidade-de-acesso}

* Atender preferencialmente micro e pequenos empreendedores;

* Uma solução de fácil uso a ser utilizada por funcionários e empresários diretamente;

* Solução baseada em software para computador.

  2. ### **Perfil de usuário** {#perfil-de-usuário}

Foi considerado que os usuários deste sistema tenham conhecimentos de informática o suficiente para manipular arquivos no sistema de arquivos do sistema operacional, conectar-se e navegar na internet, ler emails de forma online e executar aplicativos instalados em seu computador. Sendo assim, espera-se habilidades básicas de uso de computadores.

3. ###  **Modelo de negócio alvo** {#modelo-de-negócio-alvo}

As necessidades que os requisitos funcionais e não funcionais seguintes buscam cumprir são os de um público alvo onde usuários cadastrem pedidos de venda de produtos e forneçam-os por meio de entrega ou com o cliente buscando no local de operação da empresa.

3. # **REQUISITOS ESPECÍFICOS**   {#requisitos-específicos}

Nos tópicos a seguir serão apresentados os requisitos específicos que devem ser implementados para que este projeto cumpra os objetivos mencionados anteriormente e proporcione benefícios reais ao seu utilizador.

1. ## REQUISITOS FUNCIONAIS {#requisitos-funcionais}

Dentre os requisitos da solução, destacam-se os funcionais, responsáveis por especificar as funcionalidades primordiais da solução que sustentarão sua utilidade e aplicabilidade reais.

1. ### **\[RF 01\] Cadastro de clientes (modificado\!)** {#[rf-01]-cadastro-de-clientes-(modificado!)}

Nesta funcionalidade, o Atendente poderá realizar o cadastro de clientes. Caso o cliente seja pessoa jurídica, deverá ser informado: nome empresarial, nome fantasia, CNPJ, telefone de cobrança, email e as informações de entrega. Para cadastro de pessoas físicas, deverá ser informado o nome do cliente, telefone de contato e as informações de entrega.

Em ambos os cadastros, as informações de entrega consistirão do CEP, rua, número da residência, bairro, cidade, estado e país. Ainda nas informações de entrega, poderá ser fornecido as informações do Destinatário, contendo o nome, telefone de e opcionalmente informações adicionais de entrega em um campo reservado.

2. ### **\[RF 02\] Alteração do cadastro de clientes (novo\!)** {#[rf-02]-alteração-do-cadastro-de-clientes-(novo!)}

Os Atendentes poderão alterar somente as informações de entrega dos clientes e dos possíveis destinatários incluídos.

Os Gerentes poderão alterar todas as informações dos clientes.

3. ### **\[RF 03\] Gestão de produtos** {#[rf-03]-gestão-de-produtos}

A solução deverá permitir uma gestão simplificada de produtos. Nesta funcionalidade, o operador da solução poderá incluir, alterar, desativar os itens/produtos, adicionar ou subtrair suas respectivas quantidades. Os atributos existentes nesta funcionalidade são: código do item, nome do produto, categoria, quantidade, preço de custo, preço de venda, unidade de medida e descrição.

4. ### **\[RF 04\] Processo de cadastro de pedidos** {#[rf-04]-processo-de-cadastro-de-pedidos}

O cadastro de pedidos pelo Atendente deverá conter as o cliente solicitante, informações da entrega e dos produtos solicitados. Ao finalizar o cadastro, a solução deverá marcar automaticamente o pedido como “em aberto” ([RF 04](#[rf-08]-controle-de-estado-de-pedido-\(modificado!\))) e registrar sua data de criação.

5. ### **\[RF 05\] Informações de entrega dos pedidos (novo\!)** {#[rf-05]-informações-de-entrega-dos-pedidos-(novo!)}

Nas informações de entrega dos pedidos o Atendente deverá selecionar o tipo da entrega entre as opções “remota” ou “presencial” e especificar os detalhes da entrega, conforme o tipo da entrega selecionado. 

Sendo a entrega remota, o Atendente deverá fornecer o dia, o horário da entrega e o endereço de entrega, consistindo do CEP, rua, número da residência, bairro, cidade, estado, país e opcionalmente informações adicionais de entrega em um campo reservado. Para pedidos de entrega presencial, deverá ser fornecido dia e horário. 

Além disso, em ambos os casos deverá ser informado o Destinatário, contendo nome e telefone.

6. ### **\[RF 06\] Informações do solicitante dos pedidos (novo\!)** {#[rf-06]-informações-do-solicitante-dos-pedidos-(novo!)}

Sobre as informações do cliente solicitante no registro dos pedidos, o Atendente deverá informar, caso o cliente seja pessoa jurídica: nome empresarial, nome fantasia, CNPJ, telefone de cobrança e email. Para clientes pessoa física, deverá ser informado o nome do cliente e telefone de contato.

 Opcionalmente, poderá ser informado o nome e telefone de um segundo contato que poderá ser acionado no ato da entrega caso haja alguma dificuldade de se encontrar o cliente solicitante ou tenha sido definido este segundo contato como responsável pelo recebimento do pedido.

7. ### **\[RF 07\] Informações dos produtos dos pedidos (novo\!)** {#[rf-07]-informações-dos-produtos-dos-pedidos-(novo!)}

Com relação aos produtos do pedido, o Atendente deverá selecionar os produtos disponíveis cadastrados na solução e adicioná-los ao pedido especificando sua quantidade. Alternativamente, o Atendente poderá descrever o produto manualmente e informar a quantidade requerida. 

Como opcional, o usuário poderá fornecer informações adicionais a respeito dos itens do pedido para, por exemplo, adicionar ou retirar ingredientes de acordo com a necessidade do cliente.

8. ### **\[RF 08\] Controle de estado de pedido (modificado\!)** {#[rf-08]-controle-de-estado-de-pedido-(modificado!)}

A solução deverá manter informações sobre o estado atual dos pedidos cadastrados, tendo os seguintes estados possíveis: “em aberto”, “aguardando pagamento”, “pagamento em atraso”, “pago”, “em preparo/separação”, “aguardando envio/retirada”, “saiu para entrega”, “concluído” e “cancelado”. 

O Gestor de Pedidos poderá alterar o estado dos pedidos conforme achar necessário, podendo alterar diretamente de “em aberto” para “concluído”, por exemplo. Os pedidos cancelados serão mantidos na base de dados da solução. Caso ocorra o cancelamento de um pedido, deverá haver uma forma de se adicionar uma justificativa no mesmo.

9. ### **\[RF 09\] Controle de pagamento de pedidos (novo\!)** {#[rf-09]-controle-de-pagamento-de-pedidos-(novo!)}

Quando um pedido for marcado com o estado de “aguardando pagamento”, o Gestor de Pedidos terá a opção de definir uma data e horário limite para considerar o pagamento como dentro do prazo caso deseje. Excedido este prazo, o sistema deverá avançar o estado do pedido para “pagamento em atraso” de forma automática e contabilizar há quantos dias, horas e minutos se passaram desde que o pagamento venceu. 

10. ### **\[RF 10\] Alteração de pedidos (modificado\!)** {#[rf-10]-alteração-de-pedidos-(modificado!)}

O Atendente poderá modificar as 

Gestor dos pedidos poderá alterar

O Gerente poderá alterar

11. ### **\[RF 11\] Pesquisa de pedidos** {#[rf-11]-pesquisa-de-pedidos}

A solução deverá manter um registro dos pedidos cadastrados, permitindo que o usuário pesquise pedidos com base em critérios de filtragem. As opções de pesquisa deverão permitir filtrar pedidos com base na data de criação do pedido ou status do pedido ou do cliente associado ao pedido. Durante a consulta, o usuário poderá visualizar o pedido em detalhe e editá-lo (conforme [RF 05](#[rf-10]-alteração-de-pedidos-\(modificado!\))), caso seja necessário. Também deve ser possível, visualizar uma consolidação dos dados, tais como: total faturado e lucro. 

12. ### **\[RF 12\] Gestão promocional** {#[rf-12]-gestão-promocional}

A solução deverá permitir o cadastro e gerenciamento de promoções e descontos aplicáveis a produtos ou pedidos específicos. O usuário poderá aplicar essas promoções manualmente.

13. ### **\[RF 13\] Relatórios** {#[rf-13]-relatórios}

A solução deverá gerar relatórios de desempenho, como números de pedidos por período, produtos mais vendidos, valores faturados, lucro e intercorrências. Deverá também exibir gráficos para visualização mais rápida.

14. ### **\[RF 14\] Requisito de cópia (novo\!)** {#[rf-14]-requisito-de-cópia-(novo!)}

Na solução talvez seja necessário permitir uma cópia da primeira via do pedido já existente com as mesmas informações, para o cliente acompanhar o pedido.  

15. ###   **\[RF 15\] Gerenciamento de usuários (novo\!)** {#[rf-15]-gerenciamento-de-usuários-(novo!)}

A solução deverá ter um gerenciador de usuários, onde dará certas permissões ao usuário, por base de funções, hierarquia e necessidades organizacionais.

16. ###  **\[RF 16\] Visualização organizada de pedidos (novo\!)** {#[rf-16]-visualização-organizada-de-pedidos-(novo!)}

A solução deverá permitir a fácil visualização dos pedidos por meio de uma interface gráfica automatizada, que exiba os pedidos ordenando-os com base nos parâmetros de priorização definidos pelo usuário.


17. ###  **\[RF 17\] Cadastro/Login de usuários (novo\!)** {#[rf-17]-cadastro/login-de-usuários-(novo!)}

O usuário com o maior cargo deverá cadastrar os demais usuários com seus respectivos cargos e permissões, criando um login e senha de acesso único à solução para cada.

18. ###  **\[RF 18\] Registro de intercorrência (novo\!)** {#[rf-18]-registro-de-intercorrência-(novo!)}

Deverá ser possível registrar uma intercorrência “se houver” em um pedido, este registro deverá estar relacionado diretamente a um pedido, facilitando a identificação de problemas decorrentes do processo tais como : Atraso na entrega, avaria na entrega, falta de item do pedido apontado no ato da entrega, cliente ausente para receber o pedido, devolução de pedido ou algum outro tipo de problema interno que tenha impacto no pedido.

2. ## REQUISITOS DE PERFORMANCE {#requisitos-de-performance}

   1. ### **\[RNF 01\] Título requisito** {#[rnf-01]-título-requisito}

Descrição do requisito

2. ### **\[RNF 02\] Título requisito** {#[rnf-02]-título-requisito}

Descrição do requisito

3. ## REQUISITOS DE SEGURANÇA {#requisitos-de-segurança}

   1. ### **\[RNF n\] Controle de alteração de dados (novo\!)** {#[rnf-n]-controle-de-alteração-de-dados-(novo!)}

Sempre que um usuário modificar algum registro no cadastro de clientes, produtos ou pedidos, deverá ser registrado na base de dados da solução o usuário autor da alteração, a data e horário da alteração.

2. ### **\[RNF n\] Pedidos pagos/entregues (novo\!)** {#[rnf-n]-pedidos-pagos/entregues-(novo!)}

Pedidos com status de “Pago” apenas podem ser alterados por um usuário de cargo gerente ou superior. Pedidos com status “Entregue” não poderão ser alterados por nenhum usuário.

3. ### **\[RNF n\] Requisitos de Segurança 3** {#[rnf-n]-requisitos-de-segurança-3}

Descrição

4. ### **\[RNF n\] Requisitos de Segurança 4** {#[rnf-n]-requisitos-de-segurança-4}

Descrição

4. ## OUTROS REQUISITOS  {#outros-requisitos}

Descrição

1. ### **\[RNF n\] Navegação por atalhos de teclado (novo\!)** {#[rnf-n]-navegação-por-atalhos-de-teclado-(novo!)}

A solução deve permitir a transição entre suas funcionalidades por meio de combinações de teclas do teclado padrões da solução ou definidas pelo usuário.

2. ### **\[RNF n\] Requisitos de Usabilidade**  {#[rnf-n]-requisitos-de-usabilidade}

Descrição

3. ### **\[RNF n\] Requisitos de Confiabilidade**  {#[rnf-n]-requisitos-de-confiabilidade}

Descrição

4. # **MODELO DE ENTIDADE E RELACIONAMENTO LÓGICO** {#modelo-de-entidade-e-relacionamento-lógico}

Descrição

Imagens

5. # **DIAGRAMA DE CLASSES** {#diagrama-de-classes}

Descrição

Imagens

6. # **CASO DE USO**  {#caso-de-uso}

Descrição  
Imagens

1. ## CASO 1 {#caso-1}

Descrição do caso de uso 1

Imagens do caso individual

| Nome do caso de uso  |  |
| ----- | :---- |
| **Atores envolvidos**  |  |
| **Descrição**  |  |
| **Pré-Condições**  |  |
| **Pós-Condições**  |  |
| **Fluxo Básico** |  |
| **Ações do Ator** | fazer tal coisa |
|  | fazer tal coisa |
|  | fazer tal coisa |
| **Fluxo Básico** |  |
|  |  |

**Tabela 1 \- Descrição do Caso de Uso “TAL”.** 

2. ## CASO 2 {#caso-2}

Imagens do caso individual

| Nome do caso de uso  |  |
| ----- | :---- |
| **Atores envolvidos**  |  |
| **Descrição**  |  |
| **Pré-Condições**  |  |
| **Pós-Condições**  |  |
| **Fluxo Básico** |  |
| **Ações do Ator** | fazer tal coisa |
|  | fazer tal coisa |
|  | fazer tal coisa |
| **Fluxo exceção** |  |
|  |  |

**Tabela 2 \- Descrição do Caso de Uso “TAL”.** 

7. # **DICIONÁRIO DE DADOS:**  {#dicionário-de-dados:}

   1. ## ATRIBUTOS {#atributos}

Imagem

2. ## OUTRA COISA {#outra-coisa}

Imagem

8. # **PROTOTIPAGEM** {#prototipagem}

9. # **REFERÊNCIAS** {#referências}

   

**A diferença entre ser empreendedor e ser empresário** [https://sebrae.com.br/sites/PortalSebrae/artigos/a-diferenca-entre-ser-empreendedor-e-ser-empresario,59634dbf5f5c5810VgnVCM1000001b00320aRCRD](https://sebrae.com.br/sites/PortalSebrae/artigos/a-diferenca-entre-ser-empreendedor-e-ser-empresario,59634dbf5f5c5810VgnVCM1000001b00320aRCRD)

**Micro, pequena, média ou grande: como definir o porte de uma empresa?**

[https://exame.com/invest/btg-insights/como-definir-o-porte-de-uma-empresa/](https://exame.com/invest/btg-insights/como-definir-o-porte-de-uma-empresa/)

**O que faz um operador de logística**

[https://br.indeed.com/conselho-de-carreira/encontrando-emprego/o-que-faz-operador-logistica](https://br.indeed.com/conselho-de-carreira/encontrando-emprego/o-que-faz-operador-logistica)

**Operador logístico: o que faz, importância e salário**

[https://www.totvs.com/blog/gestao-logistica/operador-logistico/](https://www.totvs.com/blog/gestao-logistica/operador-logistico/)

