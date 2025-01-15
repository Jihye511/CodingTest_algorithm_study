import sys

def dfs(num, arr):
    arr[num] = -2    # 노드 삭제
    for i in range(len(arr)):
        if num == arr[i]:
            dfs(i, arr)

N = int(sys.stdin.readline())
arr = list(map(int, sys.stdin.readline().split()))
D = int(sys.stdin.readline())  # 지울 노드 번호


dfs(D, arr)

count = 0
for i in range(len(arr)):
    if arr[i] != -2 and i not in arr:
        count += 1

print(count)


