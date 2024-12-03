# # 방법 1
# def solution(s):

#     dic = {'zero':'0', 'one':'1', 'two':'2', 'three':'3', 'four':'4', 'five':'5', 'six':'6', 'seven':'7', 'eight':'8', 'nine':'9'}

#     for key, value in dic.items():
#         s = s.replace(key, value)

#     return int(s)

# 방법 2
def solution(s):
    words = ['zero', 'one', 'two', 'three', 'four', 'five', 'six', 'seven', 'eight', 'nine']

    for idx, i in enumerate(words):
        s = s.replace(i, str(idx))

    return int(s)

