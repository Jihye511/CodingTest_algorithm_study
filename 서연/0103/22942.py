import sys

N = int(sys.stdin.readline())
circles = []

for i in range(N):
    x, r = map(int, sys.stdin.readline().split())
    circles.append((x-r, i)) # 왼
    circles.append((x+r, i)) # 오

circles.sort()
# print(circles)

stk = []
for c in circles:
    if stk:
        if stk[-1][1] == c[1]:
            stk.pop()
        else:
            stk.append(c)
    else:
        stk.append(c) 
    
if stk:
    print('NO')
else:
    print('YES')