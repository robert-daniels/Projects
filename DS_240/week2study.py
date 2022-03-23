'''week2 review'''

cityGreet = "hello Boston"

print(cityGreet[0:4])
print(cityGreet[2:])

print((cityGreet[0:5] * 3) + cityGreet[6:] )

x = y = z = 10

print(x)
print(y)
del y # not something I've seen as of yet, good to know! a bit like unset

try:
    print(y)
except: 
    print("can no longer print y")

a = None
print(type(a))