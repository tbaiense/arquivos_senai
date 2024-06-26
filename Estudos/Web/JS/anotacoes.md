# spread syntax
Distribui coisas de acordo com o contexto:
- let objeto = {...arrayDeNumeros} >> obj {0: 1, 1: 10, 2: 4} >> as propriedades são nomeadas pelo índice
- let array = [[Object.keys()],[]]

# objetos:
- buscam propriedades dentro deles primeiramente e em seu protótipo (e seus sub-protótipos) recursivamente
- é possivel atribuir propriedades que existam no protótipo, mas no objeto principal, causando shadowing
## Criação:
1. todo objeto possui um prototipo
2. todo construtor possui uma propriedade 'prototype' que é herdada pelo novo objeto que é criado
3. todo protótipo é um objeto que pode ou nao herdar propriedades de outros protótipos

# primitivos:
- number, bigint, string, boolean, unspecified, null, symbol
- number >> precisão de 53 bits (2^53-1)
- bigint >> precisão absurdamente grande (NAO ACEITA FLOATING POINT)

# complexos:
- objetos, arrays --> possuem propriedades e metodos

# tipos de conversão:
- implicita --> let a = 10 + "10" >> javascript vai preferir transformar o resultado em string
			--> let b = 40 - "10" >> javascript vai preferir transformar o resultado em number
			
- usando construtores --> Number(), BigInt(), String(), Boolean()
- usando operador unário --> +"10", -"10"

# metodos comuns de array:
- minhaArray.slice(param1, param2) --> retorna uma array contendo os elementos selecionados
- minhaArray.length --> retorna a quantidade de elementos contido na array, incluindo posições vazias
- minhaArray.pop() --> remove o último elemento da array e retorna
- minhaArray.shift() --> remove o primeiro elemento da array e o retorna
- minhaArray.push(VALOR) --> insere o valor na última posição da array
- minhaArray.unshift(VALOR) --> insere o valor na primeira posição da array
- minhaArray[1].length --> se o elemento for uma string, retorna a quantidade caracteres contidos no elemento
- minhaArray.concat(array) --> concatena as arrays
- minhaArray.forEach(callback); >> executa a callback em todos os elementos preenchidos da array. em uma array esparça, os elementos vazios são desconsiderados
- minhaArray.map(callbackFn) --> executa o callback em uma cópia da array que é retornada
- minhaArray.join("separator") --> concatena elementos string de uma array, adicionando o separador especificado

# funcoes:
- parametros opcionais : (param=1) => (param === 1) ? "SUCCESS": "FAILED";

*funcoes for..in for..of
- for..in --> itera sobre as propriedades de um objeto
- for..of --> itera sobre todos os elementos de uma array, se for uma array esparça, os elementos vazios serão contabilizados

# operadores:
- VARIAVEL instanceof CLASSE
- typeof VARIAVEL
- delete meuObjeto.meuField --> o field meuField será removido do objetos


# metodos comuns de string:
- str.slice(start, end)
- str.split(separator, limit)
- str.charAt(index)
- str.toUpperCase(string)
- str.toLowerCase(string)
- str.replace('substring', 'new_str')
- str.replaceAll(pattern, replacement) >> retorna string modificada
## retorno de Number
- str.indexOf("substring");
- str.lastIndexOf('substring')
- str.length

## booleanos
- str.startsWith('substring')
- str.endsWith('substring')
- str.includes('strings')


# modificar HTML com JS:
- let elem = document.querySelector(REFERENCIA AO ELEMENTO>> ID, CLASS)

# regEx:
- /[abcd]/ >> matches any of the enclosed characters

# Math Object:
- Math.random() >> 0-1 em float, sendo 1 exclusive e zero inclusive

# event handlers uteis
- onchange >> select
- onclick >> 

# objetos html
- object.style.propriety >> mudar css dentro do js

# for loops :
- continue
- break