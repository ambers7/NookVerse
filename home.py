# pip install flask
# pip install flask-WTF


# set FLASK_APP=home.py
# $env:FLASK_APP = "home.py"
# flask run

from flask import Flask, render_template, flash, request, redirect, url_for
from flask_wtf import FlaskForm
from wtforms import FileField, SubmitField
from wtforms.validators import InputRequired
from werkzeug.utils import secure_filename

app = Flask(__name__)
app.config['SECRET_KEY'] = 'supersecretkey'
app.config['UPLOAD_FOLDER'] = 'static/files'

class UploadFileForm(FlaskForm):
    file = FileField("File", validators=[InputRequired()])
    submit = SubmitField("Upload File")

@app.route("/")
def home():
    return render_template('home.html')

@app.route('/login')
def login():
    return render_template('login.html')

@app.route('/book_bubble')
def book_bubble():
    return render_template('book_bubble.html')
# @app.route('/home', methods=['GET',"POST"])
# def home():
#     form = UploadFileForm()
#     if form.validate_on_submit():
#         file = form.file.data # First grab the file
#         file.save(os.path.join(os.path.abspath(os.path.dirname(__file__)),app.config['UPLOAD_FOLDER'],secure_filename(file.filename))) # Then save the file
#         return render_template('results.html', results = asl_recognizer.recognize_image(file.filename), filename = file.filename)
#     return render_template('index.html', form=form)

@app.route('/read_together')#, methods=['GET',"POST"])
def read_together():
    # form = UploadFileForm()
    # if form.validate_on_submit():
    #     file = form.file.data #first grab the file 
    #     file.save(os.path.join(os.path.abspath(os.path.dirname(__file__)),app.config['UPLOAD_FOLDER'],secure_filename(file.filename))) # Then save the file
    #     return render_template('book.html')#,results=file.filename) #pdf here 
    return render_template('read_together.html')

@app.route('/see_data')
def see_data():
    return render_template('see_data.html')

if __name__ == "_main_":
    app.run()
