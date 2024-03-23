# pip install flask
# pip install flask-WTF


# set FLASK_APP=home.py
# $env:FLASK_APP = "home.py"
# flask run

from flask import Flask, render_template, flash, request, redirect, url_for
from flask_wtf import FlaskForm
from fileinput import filename 
from wtforms import FileField, SubmitField
from wtforms.validators import InputRequired
from werkzeug.utils import secure_filename
import os


app = Flask(__name__)
app.config['SECRET_KEY'] = 'supersecretkey'
app.config['UPLOAD_FOLDER_PDF'] = 'static/files/pdf'
app.config['UPLOAD_FOLDER_CSV'] = 'static/files/csv'

# class UploadFileForm(FlaskForm):
#     file = FileField("File", validators=[InputRequired()])
#     submit = SubmitField("Upload File")

@app.route("/",methods=['GET','POST'])
def home():
    return render_template('home.html')

@app.route('/login')
def login():
    return render_template('login.html')

@app.route('/book_bubble')
def book_bubble():
    return render_template('book_bubble.html')
    
@app.route('/book', methods = ['POST'])   
def book():   
    if request.method == 'POST':   
        f = request.files['file'] 
        f.save(os.path.join(os.path.dirname(os.path.abspath(__file__)),app.config['UPLOAD_FOLDER_PDF'],secure_filename(f.filename)))
        return render_template("book.html", name = f.filename)   

@app.route('/read_together', methods=['GET',"POST"])
def read_together():
    return render_template('read_together.html')

@app.route('/test_readpdf')
def test_readpdf():
    return render_template('test_readpdf.html')

@app.route('/see_data', methods = ['POST'])
def see_data():
    if request.method == 'POST':   
        f = request.files['file'] 
        f.save(os.path.join(os.path.dirname(os.path.abspath(__file__)),app.config['UPLOAD_FOLDER_CSV'],secure_filename(f.filename)))
        return render_template("see_data.html", name=f.filename)

@app.route('/upload_data',methods=['GET','POST'])
def upload_data():
    return render_template("upload_data.html")

if __name__ == "_main_":
    app.run()
