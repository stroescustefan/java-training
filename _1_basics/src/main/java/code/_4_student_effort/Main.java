package code._4_student_effort;

import java.util.*;

public class Main {

	public static void solve_challenge_1() {
		int i;

		for (i = 1; i <= 100; i++) {
			String result = "";

			if (i % 3 == 0) {
				result += "Fizz";
			}
			if (i % 5 == 0) {
				result += "Buzz";
			}
			if (i % 7 == 0) {
				result += "Rizz";
			}
			if (i % 11 == 0) {
				result += "Jazz";
			}

			if (result.equalsIgnoreCase("")) {
				System.out.print(i + " ");
			} else {
				System.out.print(result + " ");
			}
		}
		System.out.println();
	}


	public static String compute_compute2(int number) {
		String result = "";
		int isDiv = 0;

		if (number % 3 == 0) {
			result += "Foo";
			isDiv = 1;
		}
		if (number % 5 == 0) {
			result += "Bar";
			isDiv = 1;
		}
		if (number % 7 == 0) {
			result += "Qix";
			isDiv = 1;
		}

		char numberDigits[] = String.valueOf(number).toCharArray();
		for (char digit : numberDigits) {

			if (digit == '3') {
				result += "Foo";
			} else if (digit == '5') {
				result += "Bar";
			} else if (digit == '7') {
				result += "Qix";
			} else if (digit == '0') {
				result += "*";
			} else if (isDiv == 0) {
				result += digit;
			}
		}

		return result;
	}

	public static int solve_challenge_3(ArrayList<Integer> numbers) {
		int left, right;
		int countPairs;

		Collections.sort(numbers);
		left = 0;
		right = numbers.size() - 1;
		countPairs = 0;
		while (left < right) {
			if (numbers.get(left) + numbers.get(right) == 0) {
				countPairs++;
				right--;
				left++;

			} else if (numbers.get(left) + numbers.get(right) > 0) {
				right--;

			} else {
				left++;
			}
		}

		return countPairs;
	}


	public static int solve_challenge_4(ArrayList<Integer> numbers) {
		int countPairs = 0;
		HashSet<Integer> isTaken = new HashSet<>();

		for (int i = 0; i < numbers.size() - 2; i++) {
			for (int j = i + 1; j < numbers.size() - 1; j++) {
				for (int k = j + 1; k < numbers.size(); k++) {
					boolean indexTaken = false;
					if (isTaken.contains(i) || isTaken.contains(j) || isTaken.contains(k)) {
						indexTaken = true;
					}

					if (!indexTaken && (numbers.get(i) + numbers.get(j) + numbers.get(k) == 0)) {
						isTaken.add(i);
						isTaken.add(j);
						isTaken.add(k);
						countPairs++;
						break;
					}
				}
			}
		}
		return countPairs;
	}


	public static void main(String[] args) {
		//TODO put your code changes in here
		// second comment

		// challenge 1
		solve_challenge_1();

		// challenge 2
		System.out.println(compute_compute2(1203));

		//challenge 3
		ArrayList<Integer> numbers = new ArrayList<>(List.of(3, 2, -3, -2, 3, 0));
		System.out.println("Numarul de perechi cu suma 0 este: " + solve_challenge_3(numbers));
		ArrayList<Integer> numbers2 = new ArrayList<>(List.of(1, 1, 0, -1, -1));
		System.out.println("Numarul de perechi cu suma 0 este: " + solve_challenge_3(numbers2));
		ArrayList<Integer> numbers3 = new ArrayList<>(List.of(5, 9, -5, 7, -5));
		System.out.println("Numarul de perechi cu suma 0 este: " + solve_challenge_3(numbers3));

		// challenge 4
		ArrayList<Integer> chl4 = new ArrayList<>(List.of(-1, -1, -1, 2));
		System.out.println("Numarul de triplete cu suma 0 este: " + solve_challenge_4(chl4));
	}
}
