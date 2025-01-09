import sys
from itertools import permutations  

K, M = map(int, sys.stdin.readline().split())  
nums = []  
# K자리 숫자로 만들수 있는 최대 값  
max_val = 98765 // 10 ** (5 - K)  
decimal = [True] * (max_val + 1)  
decimal[0] = False  
decimal[1] = False  
for i in range(2, max_val):  
    if decimal[i]:  
        nums.append(i)  
    j = 2  
    while i * j <= max_val:  
        decimal[i * j] = False  
        j += 1

length = len(nums)  
sum_value = set()  
multiply = set()  

# 덧셈 구해주기  
for i in range(length-1):  
    for j in range(i+1, length):  
        if nums[i] + nums[j] > max_val:  
            break  
        sum_value.add(nums[i] + nums[j])  

# 곱셈 구해주기  
for i in range(length):  
    for j in range(i, length):  
        if nums[i] * nums[j] > max_val:  
            break  
        multiply.add(nums[i] * nums[j])  

result = 0  
for k in permutations(range(10), K):  
    if k[0] == 0:  
        continue  
        # 숫자로 만들어주기  
    val = int(''.join(list(map(str, k))))  
    t = val  
    # 조건 1 만족하는 수  
    if val in sum_value:  
        # 조건 2 만족하는 수  
        while t % M == 0:
            t //= M  
        if t in multiply:  
            result += 1  
print(result)