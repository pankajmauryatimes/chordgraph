

import java.util.List;

import instruments.TriangleInst;
import jm.JMC;
import jm.audio.Instrument;
import jm.music.data.Note;
import jm.music.data.Part;
import jm.music.data.Phrase;
import jm.music.data.Score;
import jm.util.Write;
 
public class CMinorScaleExample implements JMC {
	
	public static void main(String[] args) {
		new CMinorScaleExample();
	}
	
	public CMinorScaleExample() {
		
		//declare an instance of the triangle wave instrument
		TriangleInst tri = new TriangleInst(8000);
		//Put the instrument(s) into an array called ensemble
		Instrument[] ensemble = {tri};
		
		Score s = new Score("C Minor Scale");
		// The third argument to the Part constructor
		//specifies an element in the instrument array
		Part p = new Part("Melody", 0);
		Phrase phr = new Phrase();
		
		List<Note> notes = new MinorScale(C4, C).getNotes();
		for(Note n : notes){
			phr.addNote(n);
		}
		
		p.addPhrase(phr);
		s.addPart(p);
		
		Write.au(s, "CMinor.au", ensemble);
	}
}