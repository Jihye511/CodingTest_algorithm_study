def solution(number, limit, power):
    yak = []

    for i in range(1, number + 1):
        cnt = 0
        # 제곱근까지만 확인
        for j in range(1, int(i ** 0.5) + 1):
            if i % j == 0:
                if j * j == i:  # 제곱수인 경우
                    cnt += 1
                else:  # 제곱수가 아닌 경우 약수 2개 추가
                    cnt += 2

            if cnt > limit:
                cnt = power
                break

        yak.append(cnt)

    return sum(yak)



