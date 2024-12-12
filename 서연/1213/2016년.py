# # 방법 1
# def solution(a, b):
#     answer = ''

#     result = dict(zip(list(range(7)), ["FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"]))
#     # print(result) # {0: 'FRI', 1: 'SAT', 2: 'SUN', 3: 'MON', 4: 'TUE', 5: 'WED', 6: 'THU'}

#     year_list = [31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]

#     past_days = sum(year_list[:a-1]) + b - 1 # 1월 1일을 기준으로 지난 일자

#     answer = result[past_days % 7]
#     return answer

# 방법 2 - 함수 사용
import datetime

def solution(a, b):
    day_of_the_week = 'MON TUE WED THU FRI SAT SUN'.split()
    # print(day_of_the_week)

    return day_of_the_week[datetime.datetime(2016, a, b).weekday()]