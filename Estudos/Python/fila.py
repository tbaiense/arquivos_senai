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
    
#Menu principal
def menu():
    #necessário para acessar em outras funcoes
    global opcEscolhida
    opcEscolhida = 1
    os.system('cls')
    while (opcEscolhida > 0 or opcEscolhida < 3):
        mostrarUltSenhas()
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
        
        if opcEscolhida == 1:
            escolheTipoSenha()
        elif opcEscolhida == 2:
            retirarSenha()
        elif opcEscolhida == 3:
            finalizar()
        else:
            os.system('cls')
            print('Por favor, digite uma opção válida.')
            input('Pressione qualquer tecla para continuar\n')
            os.system('cls')
            
def finalizar():
    os.system('cls')
    print('Obrigado por utilizar nosso serviço')
    input('Pressione qualquer tecla para continuar')
    os.system(0)

menu()
