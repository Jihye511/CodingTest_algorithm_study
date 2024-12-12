def solution(distance, rocks, n):
    answer = 0

    left = 1
    right = distance

    rocks.sort()
    rocks.append(distance)

    while left <= right:
        mid = (left + right) // 2  # 최종적으로 답이 될 값(최소값 중 최대값)

        remove = 0
        prev_rock = 0  # 이전 바위 위치

        for rock in rocks:
            dist = rock - prev_rock

            if dist < mid:
                remove += 1

                if remove > n:
                    break
            else:
                prev_rock = rock

        if remove > n:
            right = mid - 1
        else:
            answer = mid
            left = mid + 1
    return answer