# # 방법 1
# import sys
# S = list(sys.stdin.readline().strip())
# T = list(sys.stdin.readline().strip())

# def dfs(t):
#     if t == S:
#         print(1)
#         sys.exit()
    
#     if len(t) == 0:
#         return 0
    
#     if t[-1] == 'A': # 마지막이 A이면
#         dfs(t[:-1])
    
#     if t[0] == 'B': # 처음이 B이면
#         dfs(t[1:][::-1])
        
# dfs(T)
# print(0)

# 방법 2
import sys
S = sys.stdin.readline().strip()
T = sys.stdin.readline().strip()

answer = 0
def dfs(t):
    global answer
    
    if t == S:
        answer = 1
        return
    
    if len(t) == 0:
        return
    
    if t[-1] == 'A':
        dfs(t[:-1])
    
    if t[0] == 'B':
        dfs(t[:0:-1])

dfs(T)
print(answer)