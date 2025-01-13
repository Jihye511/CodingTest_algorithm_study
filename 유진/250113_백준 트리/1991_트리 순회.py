import sys

N = int(sys.stdin.readline())
tree = dict()

for _ in range(N):
    root, left, right = sys.stdin.readline().split()
    tree[root] = [left, right]


# 전위 순회 함수 : 루트 > 왼 > 오
def preorder(node):
    if node == '.':
        return
    print(node, end='')
    preorder(tree[node][0])
    preorder(tree[node][1])


# 중위 순회 : 왼 > 루트 > 오
def inorder(node):
    if node == '.':
        return
    inorder(tree[node][0])
    print(node, end='')
    inorder(tree[node][1])


# 후위순회 : 왼 > 오 > 루트
def postorder(node):
    if node == '.':
        return

    postorder(tree[node][0])
    postorder(tree[node][1])
    print(node, end='')

preorder('A')
print()
inorder('A')
print()
postorder('A')
