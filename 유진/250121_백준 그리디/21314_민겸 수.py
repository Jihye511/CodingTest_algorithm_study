import sys

S = int(sys.stdin.readline().strip())


m = 0
max = ''
min = ''

for i in S:
    if i == 'M':
        m += 1
    else: # i가 k일 경우
        if m>0:
            max += str(5*(10**m))
            min += str(10**m + 5)
        else:
            max += '5'
            min += '5'
        m = 0

# 'M'으로 끝날 경우
if m > 0:
    max += '1' * m
    min += str(10**(m-1))

print(max)
print(min)