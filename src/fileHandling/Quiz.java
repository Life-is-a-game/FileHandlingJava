package fileHandling;

public class Quiz {

	private String question;
	private String[] ansArr;
	
	/**
	 *  Initialises a quiz object with the given parameters.
	 * @param question
	 * @param ansArr
	 */
	public Quiz(String question, String[] ansArr) {
		super();
		this.question = question;
		this.ansArr = ansArr;
	}
	
	public String getQuestion() {
		return question;
	}
	public String[] getAnsArr() {
		return ansArr;
	}
	
	
}
