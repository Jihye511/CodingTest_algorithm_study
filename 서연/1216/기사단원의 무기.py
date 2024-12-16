def check(num):
    answer = 0
    for i in range(1, int(num**0.5)+1):
        if num % i == 0:
            answer += 1
            
            if num // i != i: # 제곱 수
                answer += 1
    return answer

def solution(number, limit, power):
    answer = 0
    
    for i in range(1, number+1):
        tmp = check(i)
        if tmp > limit:
            answer += power
        else:
            answer += tmp        
    return answer