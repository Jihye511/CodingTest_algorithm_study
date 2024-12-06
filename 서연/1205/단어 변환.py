from collections import deque

def solution(begin, target, words):
    answer = 0
    n = len(words[0])

    if target not in words:
        return 0

    q = deque([(begin, 0)])
    # print(q) # deque([('hit', 0)])
    # print(q.popleft()) # ('hit', 0)

    visited = set()

    while q:
        w, cnt = q.popleft()

        if w == target:
            return cnt

        for word in words:
            tmp = 0
            for i in range(n):
                if word[i] != w[i]:
                    tmp += 1
            if tmp == 1 and word not in visited:  # 1개만 다르고, 접근하지 않은 단어인 경우
                q.append((word, cnt+1))
                visited.add(word)