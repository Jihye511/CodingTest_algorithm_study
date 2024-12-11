def solution(n, times):
    start = 1
    end = max(times) * n

    while start <= end:
        mid = (start+ end) // 2

        people = 0   # 심사 완료된 사람 수

        for time in times:
            people += mid // time

            if people >= n:
                break


        if people >= n:   # n명 이상 심사
            answer = mid
            end = mid - 1
        else:             # n 명 미만 심사
            start = mid + 1

    return answer