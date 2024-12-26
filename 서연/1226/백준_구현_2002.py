# # 방법 1
# import sys
#
# N = int(sys.stdin.readline())
# Entry = {sys.stdin.readline().strip() : i for i in range(N)}
# Exit = [Entry[sys.stdin.readline().rstrip()] for _ in range(N)]
#
# res = 0
# for i in range(N):
#     for j in range(i, N):
#         if Exit[i] > Exit[j]:
#             res += 1
#             break
# print(res)

# 방법 2
import sys
from collections import deque

N = int(sys.stdin.readline())
q = deque()

res = 0
for i in range(N*2):
    if i < N: # 입차
        q.append(sys.stdin.readline().strip())
    else:
        out = sys.stdin.readline().strip()
        if out != q[0]:
            q.remove(out)
            res += 1
        else:
            q.popleft()
print(res)