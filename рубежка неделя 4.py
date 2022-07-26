inp = open("input.txt").readlines()
a = inp[1].split()

operations = ['+', '-', '*']
stack = []

for el in a:
    if el in operations:
        n = len(stack)
        f, s = stack[n-2:n]
        answer = None
        if el == '+':
            answer = f + s
        if el == '-':
            answer = f - s
        if el == '*':
            answer = f * s
        del stack[-1]
        del stack[-1]
        stack.append(answer)
    else:
        stack.append(int(el))
open("output.txt", "w").write(str(stack[0]))
