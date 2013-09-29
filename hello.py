from flask import Flask
app = Flask(__name__)



@app.route('/<rootNote>/<type>')
@app.route('/')
def getNotesForScale(rootNote=None, type=None):
    """ If major TTSTTTS starting at rootNote and ending
    at rootNote.
    """

    return 'Hello World!' + rootNote + type

if __name__ == '__main__':
    app.debug = True
    app.run()
