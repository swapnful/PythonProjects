from flask import Flask, session, redirect, render_template, request


credentials = {
    'swapnil': '1234',
    'alice': 'password123',
    'admin': 'admin',
    
}
app = Flask(__name__)




if __name__ == '__main__':
    app.run(debug=True)