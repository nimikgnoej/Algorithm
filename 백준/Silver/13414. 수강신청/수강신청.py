limit, length = map(int, input().split(" "))
dict = {}

for i in range(length):
    serial_num = input()
    dict[serial_num] = i+1

sorted_list = sorted(dict, key=lambda x:dict[x])

calculated_limit = min(limit, len(sorted_list))

for k in range(calculated_limit):
    print(sorted_list[k])