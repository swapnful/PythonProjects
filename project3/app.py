# from flask import Flask
# from flask_sqlalchemy import SQLAlchemy

# from datetime import datetime 

# app = Flask(__name__)
# app.config['SQLALCHEMY_DATABASE_URI'] = 'sqlite:///bug_tracker.db'
# db = SQLAlchemy(app)

from flask import Flask, session, redirect, url_for, request, render_template
from datetime import timedelta

credentials = {
    'swapnil': '1234',
    'alice': 'password123',
    'bob': 'securepwd',
    
}

app = Flask(__name__)
app.secret_key = '123456789'  # Set a secret key for session encryption
app.permanent_session_lifetime = timedelta(minutes=5)  # Set session expiration time (optional)

@app.route('/')
def index():
    return render_template('index.html')


@app.route('/contactus')
def contact():
    return render_template("w2.html")

@app.route('/login', methods=['GET', 'POST'])
def login():
    if request.method == 'POST':
        username = request.form['username']
        password = request.form['password']
        if username in credentials and credentials[username] == password:
            # Store username in session
            session['username'] = username
            return redirect(url_for('profile'))
        else:
            # Credentials do not match, redirect back to login page with error message
            return redirect(url_for('login'))
    return render_template('login.html')

@app.route('/logout')
def logout():
    session.pop('username', None)  # Remove username from session
    return redirect(url_for('index'))

@app.route('/profile')
def profile():
    if 'username' in session:
        return render_template('profile.html', username=session['username'])
    return redirect(url_for('login'))

if __name__ == '__main__':
    app.run(debug=True)
