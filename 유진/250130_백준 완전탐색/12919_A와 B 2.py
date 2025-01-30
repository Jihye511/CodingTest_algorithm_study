import sys
S=list(input())
T=list(input())


def dfs(t): # 문자열 T 리스트를 입력받아
    if t==S:
        print(1)
        sys.exit()
    if len(t)==0:
        return 0
    if t[-1]=='A':
        dfs(t[:-1])
    if t[0]=='B':
        dfs(t[1:][::-1])
dfs(T)
print(0)