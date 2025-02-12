def BackTracking(start):

    global Answer
    if start==N:
        total=0
        for i in range(N):
            if egg[i][0]<=0:
                total+=1

        Answer=max(Answer,total)
        return

    if egg[start][0]<=0:
        BackTracking(start+1)
        return

    check=True
    for i in range(N):
        if i==start:
            continue
        if egg[i][0]>0:
            check=False
            break

    if check: #다 깨져있는 경우
        Answer=max(Answer , N-1) #자기빼고 전부다니깐 N-1
        return

    for i in range(N):
        if i==start or egg[i][0]<=0:
            continue
        egg[start][0]-=egg[i][1]
        egg[i][0]-=egg[start][1]
        BackTracking(start+1)
        egg[start][0]+=egg[i][1]
        egg[i][0]+=egg[start][1]


N=int(input())
egg=[ list(map(int,input().split())) for _ in range(N) ] #내구도와 무게
Answer=0
BackTracking(0)

print(Answer)