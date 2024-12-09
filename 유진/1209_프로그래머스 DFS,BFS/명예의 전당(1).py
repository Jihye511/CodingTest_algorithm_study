def solution(k, score):
    arr = []
    answer = []
    for i in range(len(score)):
        arr.append(score[i])
        arr.sort(reverse=True)
        top = arr[:k]
        answer.append(min(top))

    return answer
