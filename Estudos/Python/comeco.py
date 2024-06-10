nome = ""
peso = 56
altura = 1.96
nome = input("Digite seu nome:\n>>> ")
print("Eae", nome, "só de boa?") #comment

if (peso > 80):
    print("peso maior que 80")
elif (peso == 80):
    print("peso igual 80")
else:
    print("peso menor que 80")

print("acaboou")
if (type(nome) == str):
    print("É string")

for x in range(1, -10, -2):
    print(x,"- Eu sou o melhor")

i = 0
while (i<20):
    print("estou aqui no laço while")
    i = i + 1



def quadrado(nome=1):
    if (nome == 1):
        print("chamei a funcao quadrado")
    else:
        print("diferente de 1")

quadrado(2)
