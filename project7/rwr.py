lib_books = {"Ram":2,
              "Krishna":3,
                "Laxman":1,
                  "Sita":4 }

def display_book():
   print("All books are : ") 
   for book, copy in lib_books.items():
       print(f" Book name is {book} and QTY is: {copy}")

def borrow_book(book_title):
        print("your book name is {book_title} : ")
        if book_title in lib_books:
            if lib_books[book_title]>0:
                print(f"{book_title} is assigned to you")
                lib_books[book_title] -= 1
            else:
                 print("Out of stock")
        else:
                 print("Book Not available ")

def return_book(book_title):
        print("your return book name is {book_title} : ")
        if book_title in lib_books:                          
                lib_books[book_title] += 1
                print(f"{book_title} is returned")
        else:
                 print("Book Not available ")                 
     
def main():
    print("this is liberary")
    while True:
        print("Menu:")
        print("press 1 for show all books")
        print("press 2 for borrow books")
        print("press 3 for return books")
        print("press 4 for exit books")
        choice = input("your choice: ")   

        if choice=="1": 
            display_book()
        elif choice=="2":
            book_title=input("enter book name to borrow : ")
            borrow_book(book_title)
        elif choice=="3":
            book_title=input("enter book name to return : ")
            return_book(book_title)
        elif choice=="4":
            print("thnaks ")     
            break
                
        else:
            print("Invalid choice. Please enter a valid option.")

if __name__ == "__main__":
    main()              




        