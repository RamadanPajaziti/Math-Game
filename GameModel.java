import java.util.Random;

public class GameModel {

	private static Random ran;
	public int randomNumb1;
	public int randomNumb2;
	private String operand = " ";
	private static int[] threeNumbers;
	private static int[] finalAnswer;
	public static boolean check;
	public boolean lastCheck;

	public GameModel() {
		solutionChances();
		solution();
	}

	public String getOperand() {
		return operand;
	}

	public int[] ranNumbers() {

		int count = MainFrame.getCount();
		int[] numbers = new int[2];
		if (count < 10) {
			ran = new Random();
			numbers[0] = ran.nextInt(20);
			ran = new Random();
			numbers[1] = ran.nextInt(20);

		} else if (count < 30) {
			ran = new Random();
			numbers[0] = ran.nextInt(50);
			ran = new Random();
			numbers[1] = ran.nextInt(50);

		} else if (count < 50) {
			ran = new Random();
			numbers[0] = ran.nextInt(70);
			ran = new Random();
			numbers[1] = ran.nextInt(70);

		} else {
			ran = new Random();
			numbers[0] = ran.nextInt(100);
			ran = new Random();
			numbers[1] = ran.nextInt(100);
		}
		return numbers;
	}

	public static String operatori() {

		ran = new Random();
		int stringRan = ran.nextInt(4);

		String[] operatoret = { "+", "-", "*", "/" };
		String answer = "";

		switch (stringRan) {
		case 0:
			answer = operatoret[0];
			break;
		case 1:
			answer = operatoret[1];
			break;
		case 2:
			answer = operatoret[2];
			break;
		case 3:
			answer = operatoret[3];
			break;
		}

		return answer;
	}

	// te answer[0] e kthen numrin e pare random, te answer[1] e kthen te dytin
	// dhe te answer[2] e kthen rezultatin perfundimtar

	public int[] solutionChances() {
		ran = new Random();

		finalAnswer = new int[3];

		int ranNumb = ran.nextInt(2) + 1;

		int[] answer = new int[3];
		int[] ranNumbers = new int[3];
		ranNumbers = ranNumbers();
		operand = operatori();
		switch (ranNumb) {
		// zgjidhja reale dmth true
		case 1:
			switch (operand) {
			case "+":
				answer[2] = ranNumbers[0] + ranNumbers[1];
				operand = "+";
				break;
			case "-":
				answer[2] = ranNumbers[0] - ranNumbers[1];
				operand = "-";
				break;
			case "*":
				answer[2] = (ranNumbers[0]) * ranNumbers[1];
				operand = "*";
				break;
			case "/":
				if (ranNumbers[1] == 0) {
					ranNumbers[1] += 1;

					answer[2] = ranNumbers[0] / ranNumbers[1];
				} else
					answer[2] = ranNumbers[0] / ranNumbers[1];
				operand = "/";
				break;
			}

			break;

		// zgjidhja joreale dmth kur rezultati eshte false
		case 2:
			switch (operand) {
			case "+":
				answer[2] = (ranNumbers[0]) + ranNumbers[1] + ran.nextInt(50);
				operand = "+";
				break;
			case "-":
				answer[2] = ranNumbers[0] - ranNumbers[1] + ran.nextInt(50);
				operand = "-";
				break;
			case "*":
				answer[2] = ranNumbers[0] * ranNumbers[1] + ran.nextInt(50);
				operand = "*";
				break;
			case "/":
				if (ranNumbers[1] == 0) {
					// nese eshte 0 e shton nje qe mos te pjestohet me 0 pastaj
					// qe te qet perjashtim
					ranNumbers[1] += 1;
					answer[2] = ranNumbers[0] / ranNumbers[1];
				} else {
					answer[2] = ranNumbers[0] / ranNumbers[1];
				}

				operand = "/";
				break;
			}
			break;
		}
		answer[0] = ranNumbers[0];
		answer[1] = ranNumbers[1];

		finalAnswer = answer;

		return answer;
	}

	public int[] getFinalAnswer() {
		
		return finalAnswer;
	}

	public boolean solution() {

		int[] solutionsNumbers = new int[3];
		int[] numbers = getFinalAnswer();

		threeNumbers = new int[3];
		threeNumbers = numbers;
		solutionsNumbers = threeNumbers;

		int numb1 = solutionsNumbers[0];
		int numb2 = solutionsNumbers[1];
		int solution = solutionsNumbers[2];

		boolean answer = false;

		switch (operand) {
		case "+":
			answer = (numb1 + numb2) == solution;
			break;
		case "-":
			answer = (numb1 - numb2) == solution;
			break;
		case "*":
			answer = (numb1 * numb2) == solution;
			break;
		case "/":
			answer = (numb1 / numb2) == solution;
			break;
		}
	
		check = answer;
		return answer;
	}

	public static boolean checkAnswer() {
		return check;
	}


}
