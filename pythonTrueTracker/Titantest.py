shoppingcart = [2,2,2,1,1]
total_price = 0
min_price = -1
while max(shoppingcart) > 0:
    num_books = 0
    price = 0
    for i in range(len(shoppingcart)):
        if shoppingcart[i]>0:
            shoppingcart[i]-=1
            num_books+=1
        else:
            continue
        price = num_books*100
        if num_books>3:
            price = price*(1-num_books*0.05)
        elif num_books>1:
            price = price*(1-(num_books-1)*0.05)
    total_price += price
print(total_price)

