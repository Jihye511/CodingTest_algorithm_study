def solution(a, b, n):
    answer = 0
    
    while n >= a:
        ahrt = n // a # 몫
        skajwl = n % a # 나머지

        n = (ahrt*b) + skajwl
        answer += ahrt*b
    
    return answer