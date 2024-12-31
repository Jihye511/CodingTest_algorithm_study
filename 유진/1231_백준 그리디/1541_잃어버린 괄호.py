import sys

fomular = sys.stdin.readline().strip().split('-')
num = []

for i in fomular:
    sum = 0
    temp = i.split('+')
    for j in temp:
        sum += int(j)

    num.append(sum)

result = num[0]

for i in range(1, len(num)):
    result -= num[i]

print(result)
