from flask import Flask

app = Flask(_main_)

@app.route("/")
def home():
    return "<h1>Welcome to NookVerse</h1>"

if _name_ == "_main_":
    app.run()