import sys

n = int(sys.stdin.readline())

visited = [0] * n

dic = {}
for _ in range(n):
    root, left, right = map(str, sys.stdin.readline().split())
    dic[root] = [left, right]

# print(dic) # {'A': ['B', 'C'], 'B': ['D', '.'], 'C': ['E', 'F'], 'E': ['.', '.'], 'F': ['.', 'G'], 'D': ['.', '.'], 'G': ['.', '.']}

def prefix(root):
    if root != '.':
        print(root, end='')  # root
        prefix(dic[root][0])  # left
        prefix(dic[root][1])  # right

def infix(root):
    if root != '.':
        infix(dic[root][0])  # left
        print(root, end='')  # root
        infix(dic[root][1])  # right

def postfix(root):
    if root != '.':
        postfix(dic[root][0])  # left
        postfix(dic[root][1])  # right
        print(root, end='')  # root

prefix('A')
print()
infix('A')
print()
postfix('A')
