
import instruments.TriangleInst;
import jm.JMC;
import jm.audio.Instrument;
import jm.music.data.CPhrase;
import jm.music.data.Part;
import jm.music.data.Score;
import jm.util.Write;

public class ChordExample implements JMC {
	//----------------
	// Class Attributes
	//----------------
	// setup instruments.
	private int sampleRate = 5000;
	private Instrument[] insts = {new TriangleInst(sampleRate)};

	private Score s = new Score("chords demo");	
	private Part part = new Part("Chords", 0 /* index of instrument */);

	// Common used chord arrays declared here.
	int[] cMajorUp = {c3,e3,g3};
	int[] cMajorDown = {c3,e2,g3};
	int[] gMajorUp = {b2,d3,g3};
	int[] gMajorDown = {g3, b3, d3};
	int[] fMajorUp = {f3, a2, c3};
	int[] fMajorDown = {f3, a3, c3};

	public static void main(String[] args) {
		new ChordExample();
	}

	public ChordExample() {
		makeChords();
		s.addPart(part);
		renderAudio();
	}

	private void makeChords() {
		// create a CPhrase
		CPhrase cp = new CPhrase(0.0);
		addBar(cp, cMajorUp, cMajorDown);
		addBar(cp, cMajorUp, cMajorDown);
		addBar(cp, cMajorUp, cMajorDown);
		addBar(cp, cMajorUp, cMajorDown);

		addBar(cp, fMajorUp, fMajorDown);
		addBar(cp, fMajorUp, fMajorDown);

		addBar(cp, cMajorUp, cMajorDown);
		addBar(cp, cMajorUp, cMajorDown);

		addBar(cp, gMajorUp, gMajorDown);
		addBar(cp, fMajorUp, fMajorDown);

		addBar(cp, cMajorUp, cMajorDown);
		addBar(cp, cMajorUp, cMajorDown);

		part.addCPhrase(cp);
	}

	private void addBar(CPhrase cp, int[] chordArrayUpStroke, int[] chordArrayDownStroke) {
		cp.addChord(chordArrayDownStroke, Q);
		cp.addChord(chordArrayUpStroke, Q);
		cp.addChord(chordArrayDownStroke, Q);
		cp.addChord(chordArrayUpStroke, Q);
	}

	//save as an au audio file
	private void renderAudio() {
		Write.au(s, "chord_example.au", insts); 
	}
}
