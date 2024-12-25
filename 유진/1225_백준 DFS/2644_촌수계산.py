# 입력받기
n = int(input())
ppl1, ppl2 = map(int, input().split())
m = int(input())
parents_list = [list(map(int, input().split())) for _ in range(m)]

# 연결된 사람들에 따라서 node 그래프 생성
parents_node = [list() for _ in range(n+1)]
for i in range(m):
    parents_node[parents_list[i][0]].append(parents_list[i][1])
    parents_node[parents_list[i][1]].append(parents_list[i][0])
# print(parents_node)

visited = [0 for _ in range(n+1)]
ans = []

def dfs(ppl_num, cnt):
    visited[ppl_num] = 1
    cnt += 1
    if(ppl_num == ppl2):
        ans.append(cnt)

    for node in parents_node[ppl_num]:
        if(visited[node] == 0):
            dfs(node, cnt)

dfs(ppl1, 0)

if(ans):
    print(ans[0]-1)
else:
    print(-1)