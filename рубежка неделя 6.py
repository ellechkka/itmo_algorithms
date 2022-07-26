class Node:
    def __init__(self, k, l, r):
        self.key = k
        self.left = l
        self. right = r


tree = []

def max_key(i):
    maxi = i
    while tree[maxi].right != 0:
        maxi = tree[maxi].right
    return tree[maxi].key
        

def min_key(i):
    mini = i
    while tree[mini].left != 0:
        mini = tree[mini].left
    return tree[mini].key


def is_correct_tree(i):
    current = tree[i]
    c_left, c_right = True, True
    if current.left != 0:
        if max_key(current.left) >= current.key:
            return False
        c_left = is_correct_tree(current.left)
    if current.right != 0:
        if min_key(current.right) <= current.key:
            return False
        c_right = is_correct_tree(current.right)
    return c_left and c_right


file_input = open('input.txt')
input_data = file_input.readlines()
file_input.close()

n = int(input_data[0])

tree = [None] * (n + 1)

for i in range(1, n + 1):
    key, left, right = list(map(int, input_data[i].split()))
    tree[i] = Node(key, left, right)

file_output = open('output.txt', 'w')
if n != 0:
    if is_correct_tree(1):
        file_output.write('YES')
    else:
        file_output.write('NO')
else:
    file_output.write('YES')
file_output.close()