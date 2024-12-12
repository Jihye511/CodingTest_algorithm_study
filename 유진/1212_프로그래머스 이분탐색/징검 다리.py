# 만약 현재위치에서 다음 바위까지 거리가 mid보다 작다면
# 이 바위를 제거해서 더 긴 거리를 만들어야 함
# 그래서 바위를 제거하고 현재위치 유지


# 만약 현재위치에서 다음 바위까지 거리가 mid 이상이라면

# 이미 원하는 최소 거리(mid)를 만족
# 그래서 이 바위는 유지하고 현재위치를 여기로 옮김

# 제거된 바위가 n개보다 많으면 mid가 너무 큰 것
# n개보다 적으면 mid를 더 키워볼 수 있다는 것


def solution(distance, rocks, n):
    answer = 0

    rocks.append(distance)
    rocks.sort()  # 이분탐색을 위해 정렬

    start = 1
    end = distance

    while start <= end:
        mid = (start + end) // 2

        previous = 0  # 현재 위치
        count = 0

        for rock in rocks:
            if rock - previous < mid:
                count += 1
                if count > n:
                    break
            else:
                previous = rock

        if count > n:
            end = mid - 1
        else:
            answer = mid
            start = mid + 1

    return answer

