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

	public String getType(Integer a, Integer b) throws Exception {
		if (a == 10) {
			return "strike";
		}
		if (a + b == 10) {
			return "spare";
		}
		if (a + b < 10 && a >= 0 && b >= 0) {
			return "open";
		}
		throw new Exception();
	}

	public ArrayList<Integer> parse(String game) {
		String[] strFrames = game.trim().split("]");
		ArrayList<Integer> frames = new ArrayList<Integer>();
		for (int i=  0; i < strFrames.length; i++) {
			String frame =  strFrames[i];
			frame = frame.substring(1);
			if (frame.contains(",")) {
				for (String framePart : frame.split(",")) {
					frames.add(Integer.parseInt(framePart));
				}
			} else if (i == strFrames.length -1){
				frames.add(Integer.parseInt(frame));
			} else {
				return null;
			}

		}
		return frames;
	}

	public int getNext(int num, int pos) {
		int ret = 0;
		for (int i = pos; i < pos + num && i < this.frames.size(); i++) {
			if (this.frames.get(i) == 0 && this.frames.get(i - 1) == 10) {
				num++;
				continue;
			}
			ret += this.frames.get(i);
		}
		if ((num == 1 && ret > 10) || (num == 2 && ret > 20)) {
			return -1;
		}
		return ret;
	}

	public int getScore() {
		try {
			int score = 0;
			if (this.frames == null || !this.isFrameCountCorrect()) {
				return -1;
			}
			for (int i = 0; i < 20; i += 2) {
				int a = this.frames.get(i);
				int b = this.frames.get(i + 1);
				int lastStrike = score;
				String type = this.getType(a, b);
				

				if (type == "open") {
					score += a + b;
				}

				if (type == "strike") {
					int add = this.getNext(2, i + 2);
					if (add < 0)
						return -1;
					score += a + b + add;
				}

				if (type == "spare") {
					int add = this.getNext(1, i + 2);
					if (add < 0)
						return -1;
					score += a + b + add;
				}
			}

			return score;
		} catch (Exception e) {
			return -1;
		}
	}

	public boolean isFrameCountCorrect() throws Exception {
		int frameCount = frames.size();

		if (frameCount < 20) {
			return false;
		}
		String lastFrameType = this.getType(frames.get(18), frames.get(19));
		
		if ((lastFrameType == "open" && frameCount != 20) || (lastFrameType == "spare" && frameCount != 21)
				|| (lastFrameType == "strike" && frameCount != 22)) {
			return false;
		}
		return true;
	}

}
