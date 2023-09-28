package dynamic_beat;

public class PlayRecordDTO {
	int idx;
	String ID;
	String title;
	String difficulty;
	String playTime;
	
	int score;
	
	private String strYY;
	private String strMM;
	private String strDD;
	
	public String getStrYY() {
		return strYY;
	}
	public void setStrYY(String strYY) {
		this.strYY = strYY;
	}
	public String getStrMM() {
		return strMM;
	}
	public void setStrMM(String strMM) {
		this.strMM = strMM;
	}
	public String getStrDD() {
		return strDD;
	}
	public void setStrDD(String strDD) {
		this.strDD = strDD;
	}

	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPlayTime() {
		return playTime;
	}
	public void setPlayTime(String playTime) {
		this.playTime = playTime;
	}
	public String getDifficulty() {
		return difficulty;
	}
	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	@Override
	public String toString() {
		return "PlayRecordDTO [idx=" + idx + ", ID=" + ID + ", title=" + title + ", playTime=" + playTime
				+ ", difficulty=" + difficulty + ", score=" + score + ", strYY=" + strYY + ", strMM=" + strMM
				+ ", strDD=" + strDD + ", getStrYY()=" + getStrYY() + ", getStrMM()=" + getStrMM() + ", getStrDD()="
				+ getStrDD() + ", getIdx()=" + getIdx() + ", getID()=" + getID() + ", getTitle()=" + getTitle()
				+ ", getPlayTime()=" + getPlayTime() + ", getDifficulty()=" + getDifficulty() + ", getScore()="
				+ getScore() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	} 
}
