import sys
from itertools import combinations

formular = list(sys.stdin.readline().strip())
left = []
brackets = []
answer = set()

# 괄호 쌍 찾기 - ')'가 나오면 마지막 '('와 짝을 이룸
for i in range(len(formular)):
    if formular[i] == '(':
        left.append(i)
    elif formular[i] == ')':
        brackets.append((left.pop(), i))


for i in range(len(brackets)):
    for comb in combinations(brackets, i+1):
        temp = formular[:]
        for idx in comb: # 선택된 괄호쌍의 위치를 빈 문자열로 변경
            temp[idx[0]] = temp[idx[1]] = ''
        answer.add(''.join(temp))

for item in sorted(list(answer)):
    print(item)