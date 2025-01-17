import sys
from collections import defaultdict

n, w = map(int, sys.stdin.readline().split())

tree = defaultdict(list)
for _ in range(n-1):
    u, v = map(int, sys.stdin.readline().split())
    tree[u].append(v)
    tree[v].append(u)

# print(tree) # defaultdict(<class 'list'>, {5: [3], 3: [5, 4, 1], 4: [3], 2: [1], 1: [2, 3]})

leaf_count = 0
for root, nodes in tree.items():
    if root != 1 and len(nodes) == 1:
        leaf_count += 1

print(w / leaf_count)
