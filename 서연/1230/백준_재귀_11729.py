# # 방법 1
# import sys

# n = int(sys.stdin.readline())

# def hanoi(n, one, three) :
#     if n == 1 :
#         print(one, three)
#         return
       
#     hanoi(n-1, one, 6-one-three) # 1단계
#     print(one, three) # 2단계
#     hanoi(n-1, 6-one-three, three) # 3단계
    
# print(2**n-1)
# hanoi(n, 1, 3)

# 방법 2
import sys

n = int(sys.stdin.readline())

def hanoi(n, a, b, c):
    if n == 1:
        print(a, c)
    else:
        hanoi(n-1, a, c, b) 
        print(a, c)
        hanoi(n-1, b, a, c)

print(2**n-1)
hanoi(n, 1, 2, 3)