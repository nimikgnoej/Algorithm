T = int(input())
for _ in range(T):
    univ_dict = {}
    N = int(input())
    for _ in range(N):
        univ, amount = input().split()
        univ_dict[univ] = int(amount)
    result = sorted(univ_dict, key=lambda x: univ_dict[x], reverse=True)
    print(result[0])