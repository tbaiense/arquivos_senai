l = min, max, = 1, 100
while l:
    usr_in = int(input("Insira um número para verificar:\n>>> "))

    def p():
        """Descrição: utiliza a função print() para exibir a string Número inválido!
Autor: Thiago M. Baiense"""
        print("Número inválido!")

    match usr_in:
        case 100:
            print("Parabéns! É cem")
        case 0:
            p()
        case -1:
            l = 0
        case _:
            if (0 > usr_in or usr_in > max):
               p()
            else:
                print(f"O número digitado foi {usr_in}")
