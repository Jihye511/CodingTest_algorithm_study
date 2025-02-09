import sys

n, m = map(int, sys.stdin.readline().split())
arr = sorted(list(set(map(int, sys.stdin.readline().split()))))
# print(arr)

result = []

def backtracking(idx):
    global result
    
    if len(result) == m : # result에 들어간 숫자 개수가 m과 같아지면 출력
        print(*result)
        return
        
    for i in range(idx, len(arr)): # 시작 인덱스부터 끝까지 반복한다
        result.append(arr[i]) # 순서대로 해당 숫자를 result에 넣음
        backtracking(i) 
        result.pop() # 다른 조합도 확인하기 위하여 현재 숫자는 pop
        
backtracking(0)