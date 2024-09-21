import java.util.Scanner;
public class NumberToWords {
    private static final String[] lessThanTwenty = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
            "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
    private static final String[] tens = {"", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
    private static final String[] thousands = {"", "thousand", "million"};
    public static String numberToWords(int num) {
        if (num == 0) return "zero";
        int thousandGroup = 0;
        String result = "";

        while (num > 0) {
            if (num % 1000 != 0) {
                result = convertChunk(num % 1000) + thousands[thousandGroup] + (thousandGroup > 0 ? " " : "") + result;
            }
            num /= 1000;
            thousandGroup++;
        }
        return result.trim();
    }
    private static String convertChunk(int num) {
        if (num < 20) {
            return lessThanTwenty[num] + " ";
        } else if (num < 100) {
            return tens[num / 10] + " " + lessThanTwenty[num % 10] + " ";
        } else {
            return lessThanTwenty[num / 100] + " hundred " + convertChunk(num % 100);
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number between 1 and 999,999,999: ");
        int number = scanner.nextInt();
        String result = numberToWords(number);
        System.out.println("The convesion of the number in words is: " + result);
        scanner.close();
    }
}