import sys
sys.setrecursionlimit(10**9)

arr = []

while True:
    try:
        num = int(sys.stdin.readline())
        arr.append(num)
    except:
        break

def solution(tree):
    if len(tree) == 0:
        return

    tempL, tempR = [], []
    mid = tree[0]  # 첫 번째 값이 루트 노드

    # 루트 노드보다 커지면
    for i in range(1, len(tree)):
        if tree[i] > mid:
            tempL = tree[1:i]   # 루트보다 작은 값
            tempR = tree[i:]    # 루트보다 큰 값
            break

    else: # 모두 mid보다 작은 경우
        tempL = tree[1:]

    solution(tempL)
    solution(tempR)
    print(mid)

solution(arr)

