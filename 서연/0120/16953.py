import sys

start, end = map(int, sys.stdin.readline().split())

cnt = 1
while end > start:
    # print(end)
    if end % 2 == 0:
        end //= 2
        cnt += 1
    elif end % 10 == 1:
        # end //= 10
        end = int(str(end)[:-1])
        cnt += 1
    else:
        print(-1)
        exit()
        break
    
if end == start:
    print(cnt)
else:
    print(-1)