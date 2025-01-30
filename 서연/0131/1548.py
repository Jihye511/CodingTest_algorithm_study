import sys

N = int(sys.stdin.readline().strip()) # 7
numList = list(map(int, sys.stdin.readline().split())) # 2 3 4 1 3 4 5

result = 0

# 숫자의 개수가 3 미만인 경우 -> N 반환
if N < 3:
    result = N

else:
    numList.sort() # 오름차순 정렬, 1 2 3 3 4 4 5

    # # 방법 1
    # for i in range(N-1): # 0 ~ 5
    #     x = numList[i]
    #     y = numList[i+1]

    #     for j in range(1, N): # 1 ~ 6
    #         z = numList[-j]

    #         if x + y > z:
    #             result = max(result, N - j - i + 1)
    #             break

    # 방법 2
    for x in range(N-2): # 0 ~ 4
        for z in range(N-1, -1, -1): # 6 ~ 0
            if x + 1 > z:
                continue
            if numList[x] + numList[x+1] > numList[z]:
                result = max(result, z - x + 1)
                break

print(result)