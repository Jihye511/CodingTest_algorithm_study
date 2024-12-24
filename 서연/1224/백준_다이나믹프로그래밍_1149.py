import sys

n = int(sys.stdin.readline())

colorPrice = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]

# print(colorPrice)

for i in range(1,n):
    # 다음으로 칠하는 색이 R일 때
    colorPrice[i][0] += min(colorPrice[i-1][1], colorPrice[i-1][2])

    # 다음으로 칠하는 색이 G일 때
    colorPrice[i][1] += min(colorPrice[i-1][0], colorPrice[i-1][2])

    # 다음으로 칠하는 색이 B일 때
    colorPrice[i][2] += min(colorPrice[i-1][0], colorPrice[i-1][1])

print(min(colorPrice[n-1]))