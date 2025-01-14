import sys

n = int(sys.stdin.readline())
lst = list(map(int, sys.stdin.readline().split()))
del_num = int(sys.stdin.readline())

def dfs(num):
    lst[num] = -2
    for i in range(n):
        if lst[i] == num:
            dfs(i)

dfs(del_num)
# print(lst)
result = 0

for i in range(n):
    if lst[i] != -2:
        if i not in lst:
            result += 1

print(result)