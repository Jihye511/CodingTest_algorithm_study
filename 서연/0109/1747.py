import sys

n = int(sys.stdin.readline())

def check(n):
    for i in range(2, int(n**0.5) + 1):
        if n % i == 0:
            return False
    return True

def is_palindrome(num):
    num = str(num)
    return num[::-1] == num

while True:
    if n == 1:
        n += 1
        continue

    if is_palindrome(n) and check(n):
        print(n)
        exit()
    n += 1