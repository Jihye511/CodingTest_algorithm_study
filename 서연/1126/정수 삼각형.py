# # 방법 1
# def solution(triangle):
#     for i in range(len(triangle)-2,-1,-1):
#         for j in range(i+1):
#             triangle[i][j]+=max(triangle[i+1][j],triangle[i+1][j+1])

#     answer = triangle[0][0]
#     return answer

# 방법 2
def solution(triangle):
    dp = []
    for t in range(1, len(triangle)):
        for i in range(t+1):
            if i == 0:
                triangle[t][0] += triangle[t-1][0]
            elif i == t:
                triangle[t][-1] += triangle[t-1][-1]
            else:
                triangle[t][i] += max(triangle[t-1][i-1], triangle[t-1][i])
    return max(triangle[-1])