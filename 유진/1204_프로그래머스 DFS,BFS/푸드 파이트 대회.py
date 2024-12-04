def solution(food):
    temp = ''
    for i in range(1, len(food)):
        if food[i] >= 2:
            cnt = food[i] // 2
            temp += str(i) * cnt
    reverse_temp = list(temp)
    reverse_temp.reverse()

    return temp + str(0) + ''.join(reverse_temp)
