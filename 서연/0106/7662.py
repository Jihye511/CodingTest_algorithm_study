import sys
import heapq

t = int(sys.stdin.readline())
for _ in range(t):
    k = int(sys.stdin.readline())
    minQ, maxQ = [], [] # 내림차순, 오름차순
    # 각 노드의 id에 대해 삭제되었는지 아닌지를 저장
    
    check = [True] * k  # 처음에는 아무 값도 없으므로 모두 삭제된 것으로 간주
    for i in range(k): # i = 0 ~ k-1
        operation, n = sys.stdin.readline().split()
        n = int(n)

        if operation == 'I':
            heapq.heappush(minQ, (n, i))
            heapq.heappush(maxQ, (-n, i))
            check[i] = False # 여기는 값이 들어갔으므로 삭제되지 않은 것으로 간주
        else:
            if n == 1:
                while maxQ and check[maxQ[0][1]]:
                    heapq.heappop(maxQ)
                if maxQ:
                    check[maxQ[0][1]] = True
                    heapq.heappop(maxQ)
            else:
                while minQ and check[minQ[0][1]]:
                    heapq.heappop(minQ)
                if minQ:
                    check[minQ[0][1]] = True
                    heapq.heappop(minQ)

    # 연산이 끝난 후 삭제된 값들 제거
    while minQ and check[minQ[0][1]]:
        heapq.heappop(minQ)
    while maxQ and check[maxQ[0][1]]:
        heapq.heappop(maxQ)
    
    if minQ and maxQ:
        print(-maxQ[0][0], minQ[0][0])
    else:
        print('EMPTY')