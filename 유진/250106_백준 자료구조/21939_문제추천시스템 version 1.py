from sys import stdin
from heapq import heappush, heappop
from collections import defaultdict

def solution(N, PL, M, commands):

    minHeap, maxHeap = [], []
    solved = defaultdict(int)

    # [1] 최대힙, 최소힙 초기화
    for p, l in PL:
        heappush(minHeap,(l,p))
        heappush(maxHeap,(-l,-p))

    # [2] 명령어 수행
    for command in commands:
        command = command.split()
        # [3] 문제 번호 출력
        if command[0] == "recommend":
            # [3-1] 가장 어려운 문제
            if command[1] == "1":
                while solved[abs(maxHeap[0][1])] != 0:
                    solved[abs(maxHeap[0][1])] -= 1
                    heappop(maxHeap)
                print(-maxHeap[0][1])
            # [3-2] 가장 어려운 문제
            else:
                while solved[minHeap[0][1]] != 0:
                    solved[minHeap[0][1]] -= 1
                    heappop(minHeap)
                print(minHeap[0][1])
        # [4] 문제 추가
        elif command[0] == "add":
            p, l = int(command[1]), int(command[2])
            heappush(minHeap,(l,p))
            heappush(maxHeap,(-l,-p))
        # [5] 문제 제거
        elif command[0] == "solved":
            solved[int(command[1])] += 1


N = int(stdin.readline())
PL = [list(map(int,stdin.readline().split())) for _ in range(N)]
M = int(stdin.readline())
commands = [stdin.readline().strip() for _ in range(M)]


solution(N, PL, M, commands)