from collections import defaultdict

def solution(tickets):
    answer = []

    tickets_dict = defaultdict(list)

    for s, e in tickets:
        tickets_dict[s].append(e)

    # 알파벳 역순 정렬
    for key in tickets_dict.keys():
        tickets_dict[key].sort(reverse=True)

    # print(tickets_dict)

    q = ["ICN"]

    while q:
        v = q[-1]

        if v not in tickets_dict or len(tickets_dict[v]) == 0:
            answer.append(q.pop())
        else:
            q.append(tickets_dict[v].pop())

    return answer[::-1]