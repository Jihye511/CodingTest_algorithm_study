def solution(s):
    appear = {}
    answer = []
    for i in range(len(s)):
        # 출현한 적 없을 때
        if s[i] not in appear:
            appear[s[i]] = i
            answer.append(-1)

        # 출현한 적 있을 때
        elif s[i] in appear:
            answer.append(i - appear[s[i]])
            appear[s[i]] = i

    return answer