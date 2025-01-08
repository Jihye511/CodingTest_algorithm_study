import sys

n = sys.stdin.readline().rstrip()
nums = list(n)

visited = dict()
answer = 0

def solution(case, left, right, seque):
    if case == n and seque not in visited:
        visited[seque] = 0
        global answer
        answer += 1

    else:
        if left > 0:
            solution(nums[left-1]+case, left-1, right, seque+case)  
            
        if right < len(nums)-1:
            solution(case+nums[right+1], left, right+1, seque+case) 

for i in range(len(nums)):
    solution(nums[i], i, i, nums[i])
    
print(answer)