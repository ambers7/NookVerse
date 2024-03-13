# pip install flask
# pip install flask-WTF


# set FLASK_APP=home.py
# $env:FLASK_APP = "home.py"
# flask run

# for MAC
# export FLASK_APP=home
# flask run

import pyrebase

from flask import Flask, session, render_template, flash, request, redirect, url_for
from flask_session import Session
from flask_wtf import FlaskForm
from fileinput import filename 
from wtforms import FileField, SubmitField
from wtforms.validators import InputRequired
from werkzeug.utils import secure_filename
import os

#import { initializeApp } from "firebase/app";
#import { getDatabase } from "firebase/database";

config = {
    'apiKey': "AIzaSyBkHzS3hze-aUnLhmZIHkhdSR3rhxC_-PA",
    'authDomain': "nookverse-11997.firebaseapp.com",
    'projectId': "nookverse-11997",
    'storageBucket': "nookverse-11997.appspot.com",
    'messagingSenderId': "87736587036",
    'appId': "1:87736587036:web:4f79786abbe46d2a62a0d9",
    'measurementId': "G-L8XKX841Q3",
    'databaseURL': "https://console.firebase.google.com/u/0/project/nookverse-11997/database/nookverse-11997-default-rtdb/data/~2F"
}

app = Flask(__name__)
app.config['SECRET_KEY'] = 'supersecretkey'
app.config['UPLOAD_FOLDER'] = 'static/files'

# class UploadFileForm(FlaskForm):
#     file = FileField("File", validators=[InputRequired()])
#     submit = SubmitField("Upload File")

#initialize firebase
firebase = pyrebase.initialize_app(config)
auth = firebase.auth()
db = firebase.database()
#db = getDatabase(firebase)
storage=firebase.storage()

#Initialze person as dictionary
person = {"is_logged_in": False, "name": "", "email": "", "uid": ""}

@app.route("/",methods=['GET','POST'])
def home():
    return render_template('home.html')

@app.route('/book_bubble')
def book_bubble():
    return render_template('book_bubble.html')
    
@app.route('/book', methods = ['POST'])   
def book():   
    if request.method == 'POST':   
        f = request.files['file'] 
        f.save(os.path.join(os.path.dirname(os.path.abspath(__file__)),app.config['UPLOAD_FOLDER'],secure_filename(f.filename)))
        return render_template("book.html", name = f.filename)   

@app.route('/read_together', methods=['GET',"POST"])
def read_together():
    return render_template('read_together.html')

@app.route('/see_data', methods = ['POST'])
def see_data():
    if request.method == 'POST':   
        f = request.files['file'] 
        f.save(os.path.join(os.path.dirname(os.path.abspath(__file__)),app.config['UPLOAD_FOLDER'],secure_filename(f.filename)))
        return render_template("see_data.html", name=f.filename)

@app.route('/upload_data',methods=['GET','POST'])
def upload_data():
    return render_template("upload_data.html")

@app.route('/login', methods=["POST", "GET"])
def login():
    message = ""
    if "user" in session:
        return redirect(url_for('account'))
    if request.method == "POST":
        name = request.form.get("name")
        email = request.form.get('email')
        password = request.form.get('password')
        try:
            user = auth.sign_in_with_email_and_password(email, password)
            session["user"] = name
            session["is_logged_in"] = True
            #user = auth.refresh(user['refreshToken'])
            #user_id = user['idToken']
            return redirect(url_for('account'))
        except:
            message = "Incorrect email and/or password!"
    return render_template("login.html",message=message)

@app.route("/signup", methods=["POST", "GET"])
def signup():
    message = ""
    if "user" in session:
        return redirect(url_for('account'))
    if request.method == "POST":         
        email = request.form.get("email")
        password = request.form.get("password")
        name = request.form.get("name")
        try:
            auth.create_user_with_email_and_password(email, password)
            user = auth.sign_in_with_email_and_password(email, password)
            session["user"] = name
            return redirect(url_for('account'))
        except:
            message = "Failed to create account!"
    return render_template("signup.html",message=message)

@app.route('/account')
def account():
    if "user" in session:
        return render_template("account.html",name=session["user"])
    return redirect(url_for('login'))
    
@app.route('/logout')
def logout():
    if "user" in session:
        session.pop("user")
        auth.current_user = None
    return redirect('/login')

if __name__ == "_main_":
    app.run()


