from flask import Flask, render_template

app = Flask(__name__)

lib_books = {
    "Ram": 2,
    "Krishna": 3,
    "Laxman": 1,
    "Sita": 4
}

@app.route('/')
def index():
    return render_template('index.html')

@app.route('/borrow/')
def borrow_book(book_title):
    if book_title in lib_books:
        if lib_books[book_title] > 0:
            lib_books[book_title] -= 1
            return f"{book_title} is assigned to you"
        else:
            return "Out of stock"
    else:
        return "Book not available"

@app.route('/return/')
def return_book(book_title):
    if book_title in lib_books:
        lib_books[book_title] += 1
        return f"You have returned {book_title}"
    else:
        return "Book not found"

@app.route('/view-count')
def view_count():
    book_info = "All books are:\n"
    for book, copy in lib_books.items():
        book_info += f"Book name is {book} and QTY is: {copy}\n"
    return book_info

if __name__ == '__main__':
    app.run(debug=True)
