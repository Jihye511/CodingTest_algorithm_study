import heapq

def solution(k, score):
    answer = []

    hall_of_fame = []

    for i in score:
        heapq.heappush(hall_of_fame, i)

        if len(hall_of_fame) > k:
            heapq.heappop(hall_of_fame)

        answer.append(hall_of_fame[0])
    # print(hall_of_fame)
    return answer