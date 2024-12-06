def solution(a, b, n):
    mart = 0  # 총 마트에서 받은 콜라병

    while n >= a:
        temp = (n // a) * b  # 현재 마트에서 받을 수 있는 콜라의 개수
        n = temp + (n % a)  # 현재 남아있는 콜라의 개수
        mart += temp  # 총 마트에서 받은 콜라병

    return mart 