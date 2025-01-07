# import sys
# from collections import defaultdict

# def calc(a, b): # 반납한 날, 빌린 날
#     month1, day1, hour1, minute1 = a
#     month2, day2, hour2, minute2 = b
#     time = 0
#     time += (month1 - month2) * 30 * 24 * 60
#     time += (day1 - day2) * 24 * 60
#     time += (hour1 - hour2) * 60
#     time += (minute1 - minute2)
#     return time

# n, l, f = sys.stdin.readline().rstrip().split()
# l = l.replace(':', '/')
# ddd, hh, mm = map(int, l.split('/'))

# # 기간 -> 분
# rental_period = mm + hh * 60 + ddd * 24 * 60
# # print(rental_period)

# days = [0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]

# dic = {}
# result = defaultdict(int)
# for _ in range(int(n)):
#     hear, month, day, hour, minute, P, M = sys.stdin.readline().rstrip().replace('-', ' ').replace(':', ' ').split()
#     month, day, hour, minute = map(int, [month, day, hour, minute])

#     if (M, P) not in dic.keys():
#         dic[(M, P)] = [month, day, hour, minute]
#     else:
#         time = calc([month, day, hour, minute], dic[(M, P)]) # 반납한 날, 빌린 날
#         if time > rental_period:
#             money = time - rental_period
#             result.append([M, money * int(f)])


# if result:
#     result = sorted(result, key=lambda x: x[0])
#     for i in result:
#         print(i[0], i[1])
# else:
#     print(-1)



from collections import defaultdict
from datetime import datetime, timedelta

# 입력 받기
n, l, f = input().split()
n = int(n)
f = int(f)

days, hours, minutes = map(int, l.replace(':', '/').split('/'))
rental_period = timedelta(days=days, hours=hours, minutes=minutes)

logs = [input().strip().split(maxsplit=3) for _ in range(n)]

# 대여 기록과 벌금 계산 결과
borrow_records = {}
penalty_results = defaultdict(int)

for log in logs:
    timestamp, part, member = log[0] + ' ' + log[1], log[2], log[3]
    action_time = datetime.strptime(timestamp, "%Y-%m-%d %H:%M")

    if (member, part) in borrow_records:
        # 반납 처리
        borrow_time = borrow_records.pop((member, part))
        overdue = action_time - borrow_time - rental_period

        if overdue > timedelta(0):
            penalty_results[member] += overdue.total_seconds() // 60 * f
    else:
        # 대여 처리
        borrow_records[(member, part)] = action_time

# 출력 처리
if penalty_results:
    for member, penalty in sorted(penalty_results.items()):
        print(member, int(penalty))
else:
    print(-1)