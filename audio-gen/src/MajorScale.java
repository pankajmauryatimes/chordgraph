

import java.util.ArrayList;
import java.util.List;

import jm.music.data.Note;

public class MajorScale {
	
	private int root;
	private double duration;

	public MajorScale(int root, double duration) {
		this.root = root;
		this.duration = duration;
	}

	List<Note> getNotes() {
		List<Note> notes = new ArrayList<Note>();
		
		// Major scale formula:
		// T T S T T T S
		int current = root;
		int[] gaps = {0, 2, 2, 1, 2, 2, 2, 1};
		for (int i = 0; i < gaps.length; i++) {
			notes.add(new Note(current + gaps[i], duration));
			current = current + gaps[i];
		}
		return notes;
	}
}
