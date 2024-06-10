import turtle

t = turtle.Turtle()
t.speed("fastest")
t.pensize(1)
t.pencolor("yellow")
turtle.bgcolor("green")
for x in range(1000):
    t.circle(x)
    t.right(1)
    t.forward(5)

