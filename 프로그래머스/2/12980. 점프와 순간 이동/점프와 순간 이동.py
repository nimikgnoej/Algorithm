def solution(n):
    energy = 1
    while n>1:
        if n%2==0:
            n = n//2
        else:
            n -= 1
            energy += 1
    return energy