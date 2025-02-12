import sys

def check(eggs):
    cnt = 0

    for egg in eggs:
        if egg[0] <= 0:
            cnt += 1
    
    return cnt

def solution(depth):
    global answer
    
    if depth == n:
        answer = max(answer, check(eggs))
        return
    
    # 현재 들고있는 계란이 깨졌을때
    if eggs[depth][0] <= 0:
        solution(depth + 1)
    else:
        is_all_broken = True
        for i in range(n):
            if depth != i and eggs[i][0] > 0:
                is_all_broken = False
                eggs[depth][0] -= eggs[i][1]
                eggs[i][0] -= eggs[depth][1]
                solution(depth + 1)
                # 복구
                eggs[depth][0] += eggs[i][1]
                eggs[i][0] += eggs[depth][1]
        
        if is_all_broken:
            answer = max(answer, check(eggs))
            return

# 입력 받기
n = int(sys.stdin.readline())
eggs = [list(map(int, sys.stdin.readline().split())) for _ in range(n)] # 내구도, 무게

answer = 0
solution(0)
print(answer)