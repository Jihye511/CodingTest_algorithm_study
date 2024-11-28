# # 방법 1
# def solution(arr):
#     arr = ''.join(arr).split('-') # ['5+1', '3+1+2', '1', '4+2']
#     a0 = sum([*map(int, arr[0].split('+'))]) # 6 (초항 합계)

#     min_tail, max_tail = 0, 0
#     for a in arr[:0:-1]: ### ['4+2', '1', '3+1+2'] 초항 제외 역순
#         sub = [*map(int, a.split('+'))] # [4,2] --> [1] --> [3,1,2]
#         min_sub = -sum(sub)             # -6,  --> -1  --> -6 (전체 음수인 합계)
#         max_sub = -2*sub[0] - min_sub    # -2,  --> -1  -->  0 (첫항만 음수인 합계)

#         max_tail = max(max_sub + max_tail, min_sub - min_tail)
#         min_tail = min(min_sub + min_tail, min_sub - max_tail)

#     return a0 + max_tail

# 방법 2
def solution(arr):
    nums = [int(x) for x in arr[::2]]
    ops = [x for x in arr[1::2]]

    # M[(i, j)]: nums[i] 부터 nums[j]까지 연산했을 때 나올 수 있는 최댓값
    # m[(i, j)]: nums[i] 부터 nums[j]까지 연산했을 때 나올 수 있는 최솟값
    M, m = {}, {}
    for i in range(len(nums)):
        M[(i, i)] = nums[i]
        m[(i, i)] = nums[i]

    # print(M, m)

    for d in range(1, len(nums)):
        for i in range(len(nums)):
            j = i + d
            if j >= len(nums):
                continue

            maxcandidates, mincandidates = [], []
            for k in range(i + 1, j + 1):
                if ops[k - 1] == '-':
                    mx = M[(i, k - 1)] - m[(k, j)]
                    mn = m[(i, k - 1)] - M[(k, j)]
                    maxcandidates.append(mx)
                    mincandidates.append(mn)
                else:
                    mx = M[(i, k - 1)] + M[(k, j)]
                    mn = m[(i, k - 1)] + m[(k, j)]
                    maxcandidates.append(mx)
                    mincandidates.append(mn)

            M[(i, j)] = max(maxcandidates)
            m[(i, j)] = min(mincandidates)

    return M[(0, len(nums) - 1)]