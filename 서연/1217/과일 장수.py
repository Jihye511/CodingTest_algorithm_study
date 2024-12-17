def solution(k, m, score):
    answer = 0
    
    score.sort()
    start = len(score) % m
    
    answer = sum(score[start::m])
    
    return answer * m