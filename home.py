from flask import Flask, render_template

app = Flask(__name__)

@app.route("/")
def home():
    return render_template('home.html')

@app.route('/login')
def login():
    return render_template('login.html')

@app.route('/book_bubble')
def book_bubble():
    return render_template('book_bubble.html')

@app.route('/read_together')
def read_together():
    return render_template('read_together.html')

@app.route('/see_data')
def see_data():
    return render_template('see_data.html')

if __name__ == "_main_":
    app.run()
