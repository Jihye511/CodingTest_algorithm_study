def solution(cards1, cards2, goal):
    answer = ''

    for word in goal:
        # print(word)
        if len(cards1) != 0 and word == cards1[0]:
            cards1.remove(word)
        elif len(cards2) != 0 and word == cards2[0]:
            cards2.remove(word)
        else:
            return "No"
    return "Yes"