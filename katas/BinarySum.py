def count_bits(n):
    '''convert non-negative int n to binary and sum the numbers. spits out reverse binary, but order is irrelevent for sum.'''
    
    count = 0
    
    while n != 0:
        count += (n % 2)
        n = n // 2
        

        
    return count

print(count_bits(4))