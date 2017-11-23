import java.util.ArrayList;

/**
 * BowlingGame Score calculator
 *
 * @author CDT414 Student:
 * @version 1.0
 * @date 2016-11-24
 */
public class BowlingGame {

	ArrayList<Integer> frames;

	public BowlingGame(String game) {
		this.frames = this.parse(game);

	}

	public boolean isStrike(Integer a, Integer b) {
		return this.getType(a, b) == "strike";
	}

	public boolean isSpare(Integer a, Integer b) {
		return this.getType(a, b) == "spare";
	}

	public boolean isOpen(Integer a, Integer b) {
		return this.getType(a, b) == "open";
	}

	public String getType(Integer a, Integer b) {
		if (a == 10) {
			return "strike";
		}
		if (a + b == 10) {
			return "spare";
		}
		if (a + b < 10 && a + b >= 0) {
			return "open";
		}
		return "error";
	}

	public ArrayList<Integer> parse(String game) {
		String[] strFrames = game.trim().split("]");
		ArrayList<Integer> frames = new ArrayList<Integer>();
		for (String frame : strFrames) {
			frame = frame.substring(1);
			if (frame.contains(",")) {
				for (String framePart : frame.split(",")) {
					frames.add(Integer.parseInt(framePart));
				}
			} 
			else {
				frames.add(Integer.parseInt(frame));
				frames.add(Integer.parseInt("0"));
			}

		}
		return frames;
	}

	public int getNext(int num, int pos) {
		int ret = 0;
		for (int i = pos; i < pos + num && i < this.frames.size(); i++) {
			if(this.frames.get(i) == 0 && this.frames.get(i-1) == 10) {
				num++;
				continue;				
			}
			ret += this.frames.get(i);
		}
		return ret;
	}

	public int getScore() {
		int score = 0;
		if (!this.isFrameCountCorrect()) {
			return -1;
		}
		for (int i = 0; i < 20; i += 2) {
			int a = this.frames.get(i);
			int b = this.frames.get(i + 1);
			int lastStrike = score;
			String type = this.getType(a, b);
			if (type == "error") {
				return -1;
			}

			if (type == "open") {
				score += a + b;
			}

			if (type == "strike") {
				score += a + b + this.getNext(2, i + 2);
			}

			if (type == "spare") {
				score += a + b + this.getNext(1, i + 2);
			}
			int djasnjdajd = 5;
			djasnjdajd = 10;
		}

		return score;
	}

	public boolean isFrameCountCorrect() {
		int frameCount = frames.size() / 2;

		if (frameCount < 10) {
			return false;
		}
		String lastFrameType = this.getType(18, 19);
		if ((lastFrameType == "open" && frameCount != 20) || (lastFrameType == "spare" && frameCount != 22)
				|| (lastFrameType == "strike" && frameCount != 23)) {
			return false;
		}
		return true;
	}

}
