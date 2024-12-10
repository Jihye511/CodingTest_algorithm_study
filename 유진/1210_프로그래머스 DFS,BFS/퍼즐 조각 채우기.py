from collections import deque

dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]


# board와 puzzle의 각각 빈공간과 블럭을 찾는 함수 (BFS)
def find_block(board, f):
    empty_board_list = []
    visited = [[False] * len(board[0]) for _ in range(len(board))]

    for i in range(len(board)):
        for j in range(len(board[i])):
            if not visited[i][j] and board[i][j] == f:
                queue = deque([(i, j)])
                board[i][j] = f ^ 1
                visited[i][j] = True
                lst = [(i, j)]

                while queue:
                    x, y = queue.popleft()
                    for _ in range(4):
                        nx, ny = x + dx[_], y + dy[_]
                        if nx < 0 or nx > len(board) - 1 or ny < 0 or ny > len(board) - 1:
                            continue
                        elif board[nx][ny] == f:
                            queue.append((nx, ny))
                            board[nx][ny] = f ^ 1
                            visited[nx][ny] = True
                            lst.append((nx, ny))
                empty_board_list.append(lst)

    return empty_board_list


# block의 인덱스들로 table을 만드는 함수
def make_table(block):
    x, y = zip(*block)
    c, r = max(x) - min(x) + 1, max(y) - min(y) + 1
    table = [[0] * r for _ in range(c)]

    for i, j in block:
        i, j = i - min(x), j - min(y)
        table[i][j] = 1
    return table


# 오른쪽으로 90도 회전하는 함수
def rotate(puzzle):
    rotate = [[0] * len(puzzle) for _ in range(len(puzzle[0]))]
    count = 0
    for i in range(len(puzzle)):
        for j in range(len(puzzle[i])):
            if puzzle[i][j] == 1:
                count += 1
            rotate[j][len(puzzle) - 1 - i] = puzzle[i][j]
    return rotate, count


def solution(game_board, table):
    answer = 0
    empty_blocks = find_block(game_board, 0)
    puzzles = find_block(table, 1)

    for empty in empty_blocks:
        filled = False
        table = make_table(empty)

        for puzzle_origin in puzzles:
            if filled == True:
                break

            puzzle = make_table(puzzle_origin)
            for i in range(4):
                puzzle, count = rotate(puzzle)

                if table == puzzle:
                    answer += count
                    puzzles.remove(puzzle_origin)
                    filled = True
                    break

    return answer