public class Simber {

	public static void main(String[] args) {

		int degree = 7;
		double count = 0;
		
		for (double i = 0; i < Math.pow(10, degree); i++) {
			if(isSimber(i)) {
				count = (count + 1) % 1000000123.0;
				//System.out.println("Count after " + i + " : " + count);
			}
		}
		
		System.out.println("Total count: " + count);
		
		//System.out.println(isSimber(1000));
		
	}
	
	private static Boolean isSimber(double n) {
		int[] digitBreakDown = breakDownDigits(n);
		
		for(int i = 0 ; i < 10; i++) {
			int count = digitBreakDown[i];
			
			if(MathFunctions.isEven(i)) {
				if(MathFunctions.isOdd(count)) {
					//System.out.println(n + " : false");
					return false;
				}
			} else {
				if(count!=0 && MathFunctions.isEven(count)) {
					//System.out.println(n + " : false");
					return false;
				}
			}
		}
		//System.out.println(n + " : true");
		System.out.println(n);
		return true;
	}

	private static int[] breakDownDigits(double num) {
		int[] countsOfDigits = createDigitCountArray();
		while (num >= 10)
		{
			int digit = (int) num % 10;
			num = num / 10;
			countsOfDigits[digit] += 1;
		}
		countsOfDigits[(int)num] += 1;
		//printArray(countsOfDigits);
		return countsOfDigits;
	}

	private static int[] createDigitCountArray() {
		int[] countsOfDigits = new int[10];
		for(int i = 0; i < 10; i++) {
			countsOfDigits[i] = 0;
		}
		return countsOfDigits;
	}
	
	private static void printArray(int[] arr) {
		for(int i = 0; i< arr.length; i++) {
			System.out.println(i + " : " + arr[i]);
		}
	}
}