import sys

n = int(sys.stdin.readline())

graph = {}
for _ in range(n):
    root, left, right = sys.stdin.readline().strip().split()

    graph[root] = [left, right]

# print(graph)
# {'A': ['B', 'C'], 'B': ['D', '.'], 'C': ['E', 'F'], 'E': ['.', '.'], 'F': ['.', 'G'], 'D': ['.', '.'], 'G': ['.', '.']}

def prefix(root):
    if root != '.':
        print(root, end='')  # root
        prefix(graph[root][0])  # left
        prefix(graph[root][1])  # right

def infix(root):
    if root != '.':
        infix(graph[root][0])  # left
        print(root, end='')  # root
        infix(graph[root][1])  # right


def postfix(root):
    if root != '.':
        postfix(graph[root][0])  # left
        postfix(graph[root][1])  # right
        print(root, end='')  # root


prefix('A')
print()
infix('A')
print()
postfix('A')
