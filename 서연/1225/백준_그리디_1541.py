import sys

inputs = sys.stdin.readline().strip().split('-')

result = []
for input in inputs:
    tot = 0
    nums = input.split('+')

    for num in nums:
        tot += int(num)

    result.append(tot)

answer = result[0]
for i in range(1, len(result)):
    answer -= result[i]

print(answer)