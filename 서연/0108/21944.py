import sys
import heapq

class Algorithm():
    def __init__(self, num):
        self.num = num
        self.min_heap = []
        self.max_heap = []
    
    def insert(self, pb_num, diff):
        heapq.heappush(self.min_heap, (diff, pb_num))
        heapq.heappush(self.max_heap, (-diff, -pb_num))
    
    def find_heap(self, flag):
        result = []
        if flag > 0:
            if self.max_heap:
                while (-self.max_heap[0][1] not in number_set) or number_level_g_dict[-self.max_heap[0][1]][0] != self.num or number_level_g_dict[-self.max_heap[0][1]][1] != -self.max_heap[0][0]:
                    heapq.heappop(self.max_heap)
                    if not self.max_heap:
                        break
            if self.max_heap:
                result = [-self.max_heap[0][0],-self.max_heap[0][1]]
        else:
            if self.min_heap:
                while (self.min_heap[0][1] not in number_set) or number_level_g_dict[self.min_heap[0][1]][0] != self.num or number_level_g_dict[self.min_heap[0][1]][1] != self.min_heap[0][0]:
                    heapq.heappop(self.min_heap)
                    if not self.min_heap:
                        break
            if self.min_heap:
                result = self.min_heap[0]
        return result
 
class Difficulty():
    def __init__(self, num):
        self.num = num
        self.min_heap = []
        self.max_heap = []
 
    def insert(self, pb_num):
        heapq.heappush(self.min_heap, pb_num)
        heapq.heappush(self.max_heap, -pb_num)

    def find_heap(self, x):
        result = []
        if x > 0:
            if self.min_heap:
                while self.min_heap[0] not in number_set or (number_level_g_dict[self.min_heap[0]][1]) != self.num:
                    heapq.heappop(self.min_heap)
                    if not self.min_heap:
                        break
            if self.min_heap:
                result = self.min_heap[0]
 
        else:
            if self.max_heap:
                while -self.max_heap[0] not in number_set or (number_level_g_dict[-self.max_heap[0]][1]) != self.num:
                    heapq.heappop(self.max_heap)
                    if not self.max_heap:
                        break
            if self.max_heap:
                result = -self.max_heap[0]
        return result

g_set = set()
level_set = set()
g_dict = {}
level_dict = {}
number_set = set()
number_level_g_dict = {} # key = 문제 번호, value = [알고리즘, 난이도]

N = int(sys.stdin.readline())
for _ in range(N):
    number, level, g = map(int,sys.stdin.readline().split())
    
    if g not in g_set:
        g_dict[g] = Algorithm(g)
        g_set.add(g) # 알고리즘 set
    
    if level not in level_set:
        level_dict[level] = Difficulty(level)
        level_set.add(level) # 난이도 set
    
    g_dict[g].insert(number, level)
    level_dict[level].insert(number)
    
    number_level_g_dict[number] = [g, level]
    number_set.add(number) # 문제 번호 set

M = int(sys.stdin.readline())
for i in range(M):
    command, *arg = sys.stdin.readline().split()
    
    if command == 'recommend':
        G, x = map(int, arg)
        print(g_dict[G].find_heap(x)[1])
    
    elif command == 'recommend2':
        x = int(arg[0])
        
        diff_check = 0 if x == 1 else float('inf')
        pb_num_check = -1
        
        for algo_num in g_dict:
            ch = g_dict[algo_num].find_heap(x)
            if not ch: continue
            if x == 1:
                if ch[0] >diff_check:
                    diff_check = ch[0]
                    pb_num_check = ch[1]
                elif ch[0] == diff_check:
                    if pb_num_check < ch[1]:
                        pb_num_check = ch[1]
            else:
                if ch[0] < diff_check:
                    diff_check = ch[0]
                    pb_num_check = ch[1]
                elif ch[0] == diff_check:
                    if pb_num_check > ch[1]:
                        pb_num_check = ch[1]
        print(pb_num_check)
    
    elif command == 'recommend3':
        flag, L_num = map(int, arg)
        
        result = -1
        if flag == -1:
            L_num = L_num + flag
        
        while 0<=L_num<=100:
            if L_num in level_set:
                ch = level_dict[L_num].find_heap(flag)
                if not ch:
                    L_num = L_num + flag
                    continue
                result = ch
                print(ch)
                break
            L_num = L_num + flag
        
        if result == -1:
            print(-1)
 
    elif command == 'solved':
        pb_num = int(arg[0])
        number_set.remove(pb_num)
        del number_level_g_dict[pb_num]
    
    else: # add
        pb_num, diff_num, algo_num = map(int, arg)
        
        if algo_num not in g_set:
            g_dict[algo_num] = Algorithm(algo_num)
            g_set.add(algo_num)
        
        if diff_num not in level_set:
            level_dict[diff_num] = Difficulty(diff_num)
            level_set.add(diff_num)
        
        g_dict[algo_num].insert(pb_num,diff_num)
        level_dict[diff_num].insert(pb_num)
        
        number_level_g_dict[pb_num] = [algo_num,diff_num]
        number_set.add(pb_num)