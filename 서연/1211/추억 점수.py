# # 방법 1
# def solution(name, yearning, photo):
#     answer = []

#     for arr in photo:
#         tmp = 0
#         for person in arr:
#             if person in name:
#                 tmp += yearning[name.index(person)]
#         answer.append(tmp)
#     return answer

# 방법 2 -> 훨씬 빠름
def solution(name, yearning, photo):
    dictionary = dict(zip(name, yearning))
    # print(dictionary)

    answer = []
    for pt in photo:
        score = 0
        for person in pt:
            score += dictionary.get(person, 0)
            # if person in dictionary:
            #     score += dictionary[person]
        answer.append(score)
    return answer