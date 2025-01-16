import sys
sys.setrecursionlimit(10**9)

lst = []
while True:
    try:
        v = int(sys.stdin.readline())
        lst.append(v)
    except:
        break

# print(lst) # [50, 30, 24, 5, 28, 45, 98, 52, 60]

# 방법 1
def sol1(lst):
    if len(lst) == 0:
        return
    
    lst_left, lst_right = [], []
    for i in range(1, len(lst)):
        if lst[i] > lst[0]:
            lst_left = lst[1:i]
            lst_right = lst[i:]
            break
    else:
        lst_left = lst[1:]

    sol1(lst_left)
    sol1(lst_right)
    print(lst[0])

# 방법 2
def sol2(start, end):
    if start > end:
        return
    
    mid = end + 1
    for i in range(start + 1, end + 1):
        if lst[i] > lst[start]:
            mid = i
            break
    sol2(start + 1, mid - 1) #왼쪽 트리
    sol2(mid, end) #오른쪽 트리
    print(lst[start]) #루트 노드

# sol1(lst)
sol2(0, len(lst) - 1)