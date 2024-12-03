# # 방법 1 - BFS
# from collections import Counter

# def solution(numbers, target):
#     tot = [0]
#     for num in numbers: # 4, 1, 2, 1
#         tmp = []
#         for a in tot:
#             tmp.append(a + num)
#             tmp.append(a - num)
#         tot = tmp
#     # print(tot)

#     return Counter(tot)[target]

# 방법 2 - DFS
def solution(numbers, target):
    n = len(numbers)
    answer = 0

    def dfs(idx, result):
        if idx == n:
            if result == target:
                nonlocal answer
                answer += 1
            return
        else:
            dfs(idx + 1, result + numbers[idx])
            dfs(idx + 1, result - numbers[idx])

    dfs(0, 0)
    return answer

solution([4, 1, 2, 1], 4)
