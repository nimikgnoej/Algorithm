def solution(nums):
    select_count = len(nums) // 2
    data = {}
    for n in nums:
        if n in data:
            data[n] += 1
        else:
            data[n] = 1
    if select_count <= len(data):
        return select_count
    else:
        return len(data)
        