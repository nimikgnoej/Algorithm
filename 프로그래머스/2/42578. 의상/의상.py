from collections import Counter

def solution(clothes):
    cnt = Counter(cloth_type for _, cloth_type in clothes)
    result = 1
    for c in cnt.values():
        result *= (c + 1)
    return result - 1