def solution(n, times):
    left = min(times)  # 최소 시간
    right = max(times) * n  # 가능한 최대 시간

    while left <= right:
        mid = (left + right) // 2

        people = 0  # 심사한 사람 수

        for time in times:
            # 해당 심사대에서 주어진 시간동안 심사 받은 수 더하기
            people += mid // time

            # 중간에라도 이미 n명보다 많이 심사했다면 break
            if people >= n:
                break

        if people >= n:
            answer = mid
            right = mid - 1
        else:
            left = mid + 1

    return answer