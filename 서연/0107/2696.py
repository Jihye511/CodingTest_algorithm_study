# # 방법 1
# import sys, math

# t = int(sys.stdin.readline())

# for _ in range(t):
#     n = int(sys.stdin.readline())
    
#     cnt = math.ceil(n/2)
#     lst = []
#     while len(lst) != n:
#         lst.extend(list(map(int, sys.stdin.readline().split())))

#     result = []
#     for i in range(1, n+1, 2):
#         new_lst = sorted(lst[:i])
#         result.append(new_lst[i//2])

#     print(cnt)

    
#     # 10개씩 출력
#     for i in range(0, len(result), 10):
#         print(*result[i:i+10])


# 방법 2
import sys
import heapq

t = int(sys.stdin.readline())
for _ in range(t):
    
    n = int(sys.stdin.readline())
    sequence = []
    while len(sequence) != n:
        sequence.extend(list(map(int, sys.stdin.readline().split())))

    heapleft = []
    heapright = []
    mid = []

    ## 양쪽 힙의 길이가 같으면 왼쪽에 heappush, 아니면 오른쪽에 heappush
    for i in range(len(sequence)):
        if len(heapleft) == len(heapright):
            heapq.heappush(heapleft, -sequence[i])
        else:
            heapq.heappush(heapright, sequence[i])

        ## 만약 왼쪽의 최댓값이 오른쪽의 최솟값보다 크면 자리 바꾸기
        if heapright and -heapleft[0] > heapright[0]:
            big = heapq.heappop(heapleft)
            small = heapq.heappop(heapright)
            heapq.heappush(heapleft, -small)
            heapq.heappush(heapright, -big)

        if (i+1)%2 == 1:
            mid.append(-heapleft[0])


    length = len(mid)

    print(length)

    # 10개씩 출력
    for i in range(0, len(mid), 10):
        print(*mid[i:i+10])