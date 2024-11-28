# # 방법 1
# def solution(s, n):
#     answer = ''
#     # print(ord('a'), ord('z'), ord('A'), ord('Z')) # 97 122 65 90

#     for i in s:
#         if i == ' ':
#             answer += ' '
#         else:
#             if ord('a') <= ord(i) <= ord('z') and ord(i) + n > ord('z'):
#                 answer += chr(96 + ord(i) + n - ord('z'))
#             elif ord('A') <= ord(i) <= ord('Z') and ord(i) + n > ord('Z'):
#                 answer += chr(64 + ord(i) + n - ord('Z'))
#             else:
#                 answer += chr(ord(i) + n)
#     return answer

# # 방법 2
# def solution(s, n):
#     answer = ''
#     for i in s:
#         if i >= 'A' and i <= 'Z':
#             answer += chr((ord(i) - ord('A') + n) % 26 + ord('A'))
#         elif i >= 'a' and i <= 'z':
#             answer += chr((ord(i) - ord('a') + n) % 26 + ord('a'))
#         else: 
#             answer += ' '
#     return answer

# 방법 3
def solution(s, n):
    s = list(s)
    # print(s)

    for i in range(len(s)):
        if s[i].isupper():
            s[i]=chr((ord(s[i])-ord('A')+ n)%26+ord('A'))
        elif s[i].islower():
            s[i]=chr((ord(s[i])-ord('a')+ n)%26+ord('a'))

    return "".join(s)