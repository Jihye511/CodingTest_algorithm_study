# 유니온 파인드가 떠올랐다.
# 진실을 아는 사람과 함께 파티에 참여하게된다면 그 사람도 진실을 알게되기 때문에
# 반복적으로 진실을 알게되는 사람이 생기면 계속 유니온해줘야 한다.

import sys

# 입력 받기
n, m = map(int, sys.stdin.readline().split())
know_truth_person_num, *know_truth_person_list = map(int, sys.stdin.readline().split())
know_truth_person_set = set(know_truth_person_list)
parties = [set(map(int, sys.stdin.readline().split()[1:])) for _ in range(m)]

# 진실을 아는 사람이 없으면 모든 파티에서 거짓말 가능
if know_truth_person_num == 0:
    print(m)
    exit()

for _ in range(m):
    for party in parties:
        if party.intersection(know_truth_person_set):
            know_truth_person_set = know_truth_person_set.union(party)


# 최종 연산
# result: 진실을 아는 사람이 한 명도 없는 파티 구하기
result = 0
for party in parties:
    if party.intersection(know_truth_person_set):
        continue
    result += 1

print(result)