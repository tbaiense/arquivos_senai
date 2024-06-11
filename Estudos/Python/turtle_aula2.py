import turtle

t = turtle.Turtle()
tela = turtle.Screen() #Atalho para tela


t.speed('fastest')
t.shape('turtle')
t.pencolor('white')
t.pensize(3)
tela.bgcolor('black')

t.fillcolor('green')
t.begin_fill()
for x in range(4):
    t.forward(100)
    t.right(90)

t.end_fill()
