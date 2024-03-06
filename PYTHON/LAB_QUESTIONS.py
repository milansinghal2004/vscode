'''#Q1 wap to show that tuple are unchangable
t = ("Hello", "Hi")
t(1) = 0
print(t)


#Q2 wap to delete a tuple using dell
t = (1,2,3,4,5)
print(t)
del(t)


#Q3 Creat a list from a tuple and vice versa
l = [1, 2, 3]
t = (4, 5, 6)
print(tuple(l)+t)
print(list(t)+l)


#Q4 wap to show the use of neasted tuples
t1 = (1,2)
t2 = ('a', 'b')
print(t1)
print(t2)
t3 = ("HELLO", t1, "You", t2)
print(t3)
'''
'''
#Q5 wap to print the naeme of the toper and her marks in 4 sub where in marks are spasified as a list in tuple
x = []
for i in range(0, 4):
    name = input("Enter name : ")
    for j in range(0, 4):
        a = int(input("Enter marks : "))
'''


'''
#Q6 wap to demonstrate the use of index method
str = ("An apple a day, keeps the doctor away")
print("Your tuple is : ", str)
print("Index of first 'p' is : ", str.index('p'))


#Q7 wap to count the letter x appears in a string
str = input("Enter a string : ")
i = 0
count  = 0
for i in str:
    if i == 'x':
        count = count + 1
print("No. of times 'x' occourd is : ", count)
'''

#Q8 wap to sort the tuple of values
t = (3, 2, 1, 5, 6, 4)
print(t)
#sorted(t)
print(sorted(t))