

import java.util.ArrayList;
import java.util.List;

import jm.music.data.Note;

public class MinorScale {
	
	private int root;
	private double duration;

	public MinorScale(int root, double duration) {
		this.root = root;
		this.duration = duration;
	}

	List<Note> getNotes() {
		List<Note> notes = new ArrayList<Note>();
		
		// Major scale formula:
		// Root T S T T S T T
		int current = root;
		int[] gaps = {0, 2, 1, 2, 2, 1, 2, 2};
		for (int i = 0; i < gaps.length; i++) {
			notes.add(new Note(current + gaps[i], duration));
			current = current + gaps[i];
		}
		return notes;
	}
}
