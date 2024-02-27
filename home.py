# pip install flask
# pip install flask-WTF


# set FLASK_APP=home.py
# $env:FLASK_APP = "home.py"
# flask run

# for MAC
# export FLASK_APP=home
# flask run

import pyrebase

from flask import Flask, render_template, flash, request, redirect, url_for
from flask_wtf import FlaskForm
from fileinput import filename 
from wtforms import FileField, SubmitField
from wtforms.validators import InputRequired
from werkzeug.utils import secure_filename
import os

import { initializeApp } from "firebase/app";
import { getDatabase } from "firebase/database";

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
storage=firebase.storage()

#Initialze person as dictionary
person = {"is_logged_in": False, "name": "", "email": "", "uid": ""}

@app.route("/",methods=['GET','POST'])
def home():
    return render_template('home.html')

@app.route('/login')
def login():
    return render_template('login.html')

@app.route("/signup")
def signup():
    return render_template("signup.html")

@app.route("/account")
def account():
    if person["is_logged_in"]==True:
        return render_template("account.html", email=person["email"], name=person["name"])
    else:
        return redirect(url_for('login'))

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

@app.route('/see_data')
def see_data():
    return render_template('see_data.html')

# click login
@app.route("/result", methods = ["POST", "GET"])
def result():
    if request.method == "POST":        #Only if data has been posted
        result = request.form           #Get the data
        email = result["email"]
        password = result["pass"]
        try:
            #Try signing in the user with the given information
            user = auth.sign_in_with_email_and_password(email, password)
            #Insert the user data in the global person
            global person
            person["is_logged_in"] = True
            person["email"] = user["email"]
            person["uid"] = user["localId"]
            #Get the name of the user
            data = db.child("users").get()
            person["name"] = data.val()[person["uid"]]["name"]
            return redirect(url_for('account'))
        except:
            #If there is any error, redirect back to login
            return redirect(url_for('login'))
    else:
        if person["is_logged_in"] == True:
            return redirect(url_for('account'))
        else:
            return redirect(url_for('login'))

# click register
@app.route("/register", methods = ["POST", "GET"])
def register():
    if request.method == "POST":        #Only listen to POST
        result = request.form           #Get the data submitted
        email = result["email"]
        password = result["pass"]
        name = result["name"]
        try:
            #Try creating the user account using the provided data
            auth.create_user_with_email_and_password(email, password)
            #Login the user
            user = auth.sign_in_with_email_and_password(email, password)
            #Add data to global person
            global person
            person["is_logged_in"] = True
            person["email"] = user["email"]
            person["uid"] = user["localId"]
            person["name"] = name
            #Append data to the firebase realtime database
            data = {"name": name, "email": email}
            db.child("users").child(person["uid"]).set(data)
            #Go to welcome page
            return redirect(url_for('account'))
        except:
            #If there is any error, redirect to register
            return redirect(url_for('signup'))

    else:
        if person["is_logged_in"] == True:
            return redirect(url_for('account'))
        else:
            return redirect(url_for('signup'))



if __name__ == "_main_":
    app.run()


