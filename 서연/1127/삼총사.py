from itertools import combinations

def solution(number):
    answer = 0
    # print(list(combinations(number, 3)))
    for tu in list(combinations(number, 3)):
        if sum(tu) == 0:
            answer += 1
    return answer