import sys

inputs = sys.stdin.readline().rstrip().split('-')

result = 0
for idx, input in enumerate(inputs):
    if idx == 0:
        result += sum(map(int, input.split('+')))
    else:
        result -= sum(map(int, input.split('+')))

print(result)