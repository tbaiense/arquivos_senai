A = int(input())
M = int(input())
Max = 50

if (1 <= A <= Max and 1 <= M <= Max):
    if (A + M <= Max):
        print("S")
    else:
        print("N")
