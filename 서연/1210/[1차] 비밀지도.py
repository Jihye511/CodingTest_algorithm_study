# # 방법 1
# def solution(n, arr1, arr2):
#     answer = []

#     # 2진 변환
#     for i in range(n):
#         arr1[i] = format(arr1[i], 'b')
#         if len(arr1[i]) != n:
#             arr1[i] = '0' * (n - len(arr1[i])) + arr1[i]

#     for i in range(n):
#         arr2[i] = format(arr2[i], 'b')
#         if len(arr2[i]) != n:
#             arr2[i] = '0' * (n - len(arr2[i])) + arr2[i]

#     # 합치기
#     for a, b in zip(arr1, arr2):
#         tmp = ''
#         for i in range(n):
#             if int(a[i]) or int(b[i]):
#                 tmp += '#'
#             else:
#                 tmp += ' '
#         answer.append(tmp)
#     # print(answer)

#     return answer

# 방법 2
def solution(n, arr1, arr2):
    answer = []
    for i, j in zip(arr1, arr2):
        a12 = bin(i | j)[2:]
        # a12 = a12.rjust(n,'0')
        a12 = a12.zfill(n)
        a12 = a12.replace('1', '#')
        a12 = a12.replace('0', ' ')
        answer.append(a12)
    return answer