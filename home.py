from flask import Flask, redirect, url_for

app = Flask(__name__)

@app.route("/")
def home():
    return "<h1>Welcome to NookVerse</h1>"

@app.route("/<name>")
def user(name):
    return f"Hello {name}!"

@app.route("/admin")
def admin():
    # redirect back to home page
    return redirect(url_for("home")) # function name goes inside of url_for()

if __name__ == "__main__":
    app.run()