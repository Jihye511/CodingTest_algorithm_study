M, m = {}, {}

def solution(arr):
    nums = [int(x) for x in arr[::2]]
    ops = [x for x in arr[1::2]]

    for i in range(len(nums)):
        M[(i, i)] = nums[i]
        m[(i, i)] = nums[i]

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