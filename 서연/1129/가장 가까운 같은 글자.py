def solution(s):
    answer = []
    tmp = {}
    for idx, i in enumerate(s):
        # print(i, idx)
        if i not in list(tmp.keys()):
            answer.append(-1)
        else:
            answer.append(idx-tmp[i])
        tmp[i] = idx
        # print(tmp)
    return answer