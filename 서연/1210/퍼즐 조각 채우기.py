# game_board의 빈칸, table의 블럭 찾는 함수
def finding(board, num):
    arr = []

    n = len(board)
    dr, dc = [0, 0, 1, -1], [1, -1, 0, 0]  # 상하우좌

    visit = [[0] * n for _ in range(n)]

    for i in range(n):
        for j in range(n):
            # 현재 찾는 게 아니고 방문했다면 무시
            if board[i][j] != num or visit[i][j]:
                continue

            q = [[i, j]]
            visit[i][j] = 1
            k = 0
            while k < len(q):
                r, c = q[k]
                for d in range(4):
                    nr, nc = r + dr[d], c + dc[d]
                    if 0 <= nr < n and 0 <= nc < n:
                        if not visit[nr][nc] and board[nr][nc] == num:
                            q.append([nr, nc])
                            visit[nr][nc] = 1
                k += 1

            # 도형 추가
            arr.append(q)
    return arr

# 도형 위치 인덱스를 1개의 문자열로 이어서 반환 - 좌상 정렬
def hashing(group):
    # 해당 도형 위치의 가장 왼쪽 모서리
    min_r, min_c = 50, 50
    for r, c in group:
        min_r = min(min_r, r)
        min_c = min(min_c, c)

    # 정렬
    for i in range(len(group)):
        group[i][0] -= min_r
        group[i][1] -= min_c

    # 최선 행, 차선 열 오름차순으로 정렬
    group.sort()

    # 문자열로 바꿔주고 return
    arr = []
    for r, c in group:
        arr.append(str(r))
        arr.append(str(c))

    return ''.join(arr)

# 빈칸의 위치를 90도 회전시키는 함수
def rotate(shape):
    for i in range(len(shape)):
        r, c = shape[i]
        shape[i] = [c, -r]

def solution(game_board, table):
    answer = 0

    # 블럭과 빈칸 찾음
    block = finding(table, 1)
    blank = finding(game_board, 0)

    # 블럭들 문자열로 해싱후 딕셔너리에 저장
    for i in range(len(block)):
        block[i] = hashing(block[i])

    temp = dict()
    for i in block:
        temp[i] = temp.get(i, 0) + 1
    block = temp

    # 빈칸들을 순회하면서
    # 해당 빈칸을 4번 90도 회전하며, 맞는 블럭이 있는지 탐색
    # 있으면 블럭 딕셔너리에 개수 -1
    for i in range(len(blank)):
        for _ in range(4):
            rotate(blank[i])
            hash_blank = hashing(blank[i])
            if block.get(hash_blank):
                block[hash_blank] -= 1

                # 인덱스가 행열행열....식으로 들어가기 때문에
                # 문자열의 길이 //2 해서 answer에 추가
                answer += len(hash_blank) // 2
                break

    return answer