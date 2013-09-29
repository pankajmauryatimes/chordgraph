from flask import Flask
app = Flask(__name__)

allNotes = ["c","csharp","d","dsharp","e","f","fsharp","g","gsharp","a","asharp","b"]
# TTSTTTS
gapMajor = [0, 2, 2, 1, 2, 2, 2, 1]
# TSTTSTT
gapMinor = [0, 2, 1, 2, 2, 1, 2, 2]

@app.route('/<rootNote>/<type>')
@app.route('/')
def getNotesForScale(rootNote=None, type=None):
  if (type=="major"):
    return str(getNotesForMajorScale(rootNote))
  if (type=="minor"):
    return str(getNotesForMinorScale(rootNote))

  return 'Hello World!' + rootNote + type

def getNotesForMinorScale(rootNote):
  """ If minor TSTTSTT starting at rootNote and ending
  at rootNote.
  """
  rootIndex = allNotes.index(rootNote)
  notes = []
  current = 0
  for gap in gapMinor:
    notes.append(allNotes[(gap + current + rootIndex) % len(allNotes)])
    current = current + gap;
  return notes;

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
