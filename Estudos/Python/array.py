lista = [1, 'mariana', 2.8, 'lucas']

lista.append('fabio') #adiciona ao final da lista
lista.insert(1, 'lucas') #adiciona em determinado index da lista
lista.insert(1,[1,2])
print(lista[1][1])
lista.remove(2.8) # remove um elemento na lista, que exista
lista.pop(3) #remove um índice

for e in lista:
    print(e, end=', ')

print('deposi')
lista.clear() #apaga os elementos da lista, sem apagar a variavel
print(lista)
