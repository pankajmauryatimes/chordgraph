from flask import Flask
app = Flask(__name__)

allNotes = ["c","c#","d","d#","e","f","f#","g","g#","a","a#","b"]
# TTSTTTS
gapMajor = [0, 2, 2, 1, 2, 2, 2, 1]

@app.route('/<rootNote>/<type>')
@app.route('/')
def getNotesForScale(rootNote=None, type=None):
  if (type=="major"):
    return str(getNotesForMajorScale(rootNote))

  return 'Hello World!' + rootNote + type

def getNotesForMajorScale(rootNote):
  """ If major TTSTTTS starting at rootNote and ending
  at rootNote.
  """
  rootIndex = allNotes.index(rootNote)
  notes = []
  current = 0
  for gap in gapMajor:
    notes.append(allNotes[(gap + current + rootIndex) % len(allNotes)])
    current = current + gap;
  return notes;

if __name__ == '__main__':
  app.debug = True
  app.run()
