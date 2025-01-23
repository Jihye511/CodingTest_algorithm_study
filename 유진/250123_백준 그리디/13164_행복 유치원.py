import sys

N, K = map(int, sys.stdin.readline().split())

student = list(map(int, sys.stdin.readline().split()))


cha = []
for i in range(1, N):
    cha.append(student[i] - student[i-1])  # 옆 아이와의 키차이


cost = 0
cha.sort()  # 오름차순
for i in range(N-K):
    cost += cha[i]

print(cost)

