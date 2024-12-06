# 방법 1
def solution(strings, n):
    answer = []

    ls = [(string[n], string) for idx, string in enumerate(strings)]
    ls.sort()
    # print(ls)

    for a, b in ls:
        answer.append(b)

    return answer

# # 방법 2
# def solution(strings, n):

#     return sorted(sorted(strings), key=lambda x: x[n])