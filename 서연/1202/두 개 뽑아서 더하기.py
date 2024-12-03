from itertools import combinations

def solution(numbers):
    answer = []
    
    for a, b in list(combinations(list(range(len(numbers))), 2)):
        hap = numbers[a] + numbers[b]
        if hap not in answer:
            answer.append(hap)
    answer.sort()
          
    return answer