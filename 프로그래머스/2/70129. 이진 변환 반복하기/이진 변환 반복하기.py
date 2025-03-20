def solution(s):
    zero = 0
    count = 0
    while True:
        if s == "1":
            break
        zero += s.count("0")
        s = s.replace("0","")
        length = len(s)
        s = bin(length)[2:]
        count+=1
    return [count,zero]
    
    
        