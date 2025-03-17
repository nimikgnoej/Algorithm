def solution(people, limit):
    people.sort(reverse=True)
    count = 0
    start = 0
    end = len(people)-1
    
    while True:
        if start > end:
            break
        elif start == end:
            count+=1
            break
        
        if people[start] + people[end] > limit:
            count += 1
            start += 1
        else:
            start += 1
            end -= 1
            count += 1
    return count