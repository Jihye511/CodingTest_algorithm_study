import sys

N = int(sys.stdin.readline())
nums = sorted(list(map(int, sys.stdin.readline().split())))

if N > 2:
    result = 2
    for start in range(N-2):
        end = start + 2
        while True:
            if nums[start] + nums[start+1] > nums[end]:
                result = max(result, end-start+1)
                end += 1
                if end == N:
                    break

            else:
                break
    print(result)

else:
    print(N)