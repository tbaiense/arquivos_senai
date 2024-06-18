'''
Sistema de gerenciamento de senhas.
Data: 11/06/2024
'''

import os
import sys

senhas = []
senhasRetiradas = []
senhaAtualN = 0
senhaAtualP = 0
senhaPraAdicionar = 0
ultimaSenhaAdicionada = ultimaSenhaChamada = 'Nenhuma'

def mostrarUltSenhas():
    """Mostrar lista de senhas chamadas"""
    print('---------------------------------')
    print(f'Senhas chamadas: {senhasRetiradas}')
    print('---------------------------------')

#mostrar lista de senhas futuras
def mostrarProxSenhas():
    print('--------------')
    print(f'Próximas senhas são: {senhas}')
    print('--------------')

#mostrar ultima senha adicionada
def mostrarUltimaSenhaAdicionada():
    print('--------------')
    print(f'Ultima senha adicionada: {ultimaSenhaAdicionada}')
    print('--------------')

#mostrar ultima senha chamada
def mostrarUltimaSenhaChamada():
    print('--------------')
    print(f'Ultima senha chamada: {ultimaSenhaChamada}')
    print('--------------')

#adiciona uma senha preferencial na posição correta
def adicionarPreferencial(senha):
    pronto = False
    i = 1
    while pronto == False:
        if senhas[i].find("P") == -1:
            pronto = True
        else:
            i = i + 1
    senhas.insert(i, senha)

#chamar senha
def chamarSenha():
    os.system('cls')
    try:
        global ultimaSenhaChamada
        ultimaSenha = senhas[0]
        senhasRetiradas.append(ultimaSenha)
        senhas.pop(0)
        print(f'Senha: {ultimaSenha}')
        print('Se dirija ao caixa.')
        menu()
    except:
        os.system('cls')
        print('Não há senhas para chamar no painel')
        input('Pressione qualquer tecla para continuar.')
        menu()

#adiciona mais uma senha a lista de senhas de acordo com a prioridade
def adicionarSenha(senhaDaVez, prioridade):
    os.system('cls')
    senhaDaVez = str(senhaDaVez)
    if prioridade == 1:
        senhaDaVez = 'N' + senhaDaVez
        tipoSenha = 'Normal'
        senhas.append(senhaDaVez)
    else:
        senhaDaVez = 'P' + senhaDaVez
        tipoSenha = 'Preferencial'
        if (len(senhas) == 0):
            senhas.append(senhaDaVez)
        else:
            adicionarPreferencial(senhaDaVez)
        

    global ultimaSenha
    ultimaSenha = senhaDaVez
    print(f'Senha {senhaDaVez} do tipo {tipoSenha} foi adicionada na lista de espera')
    input('Pressione qualquer tecla para continuar')
    os.system('cls')
    
#escolhe tipo de senha
def escolheTipoSenha():
    global opcEscolhida
    os.system('cls')
    print("""/
Escolha o tipo de senha que deseja:
1- Normal
2- Preferencial""")
    try:
        opcEscolhida = int(input("Digite sua escolha (1 ou 2): "))
        if opcEscolhida == 1:
            global senhaAtualN
            senhaAtualN += 1
            adicionarSenha(senhaAtualN, opcEscolhida)
        elif opcEscolhida == 2:
            global senhaAtualP
            senhaAtualP += 1
            adicionarSenha(senhaAtualP, opcEscolhida)
        else:
            os.system('cls')
            print('Por favor, digite uma opção válida.')
            input('Pressione qualquer tecla para continuar\n')
            escolheTipoSenha()
    except:
        os.system('cls')
        print('Por favor, digite apenas números.')
        input('Pressione qualquer tecla para continuar\n')
        escolheTipoSenha()

#Menu principal
def menu():
    #necessário para acessar em outras funcoes
    global opcEscolhida
    opcEscolhida = 1
    os.system('cls')
    while (opcEscolhida > 0 or opcEscolhida < 3):
        mostrarUltSenhas()
        mostrarProxSenhas()
        mostrarUltimaSenhaAdicionada()
        mostrarUltimaSenhaChamada()
        print("""\
Escolha o que deseja fazer:
1- Retirar senha
2- Chamar uma senha no painel
3- Sair do sistema

>>> 
        """)
        
        try:
            opcEscolhida = int(input())
        except:
            opcEscolhida = -1
            os.system('cls')
            print('Por favor, digite apenas números.')
            input('Pressione qualquer tecla para continuar\n')
            os.system('cls')
            
        if opcEscolhida == 1:
            escolheTipoSenha()
        elif opcEscolhida == 2:
            chamarSenha()
        elif opcEscolhida == 3:
            finalizar()
        else:
            print('Por favor, digite uma opção válida.')
            input('Pressione qualquer tecla para continuar\n')
            os.system('cls')
            
def finalizar():
    os.system('cls')
    print('Obrigado por utilizar nosso serviço')
    input('Pressione qualquer tecla para continuar')
    os.system('0')

menu()
