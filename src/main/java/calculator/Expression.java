package calculator;

public class Expression {
    private static final char[] DEFAULT_DELIMITERS = {',', ':'};

    private char[] delimiters = DEFAULT_DELIMITERS;
    private String numberSequence;

    public static Expression parse (String input) {
        return new Expression(input);
    }

    private Expression(String input) {
        if(input.startsWith("//")) {
            delimiters = new char[] {input.charAt(2)};
            int newLineIndex = input.indexOf("\\n");
            input = input.substring(newLineIndex + 2);
        }

        numberSequence = input;
    }

    public int getSum() {
        String[] numbers = numberSequence.split("[" + new String(delimiters) + "]");
        int sum = 0;
        for (String numberStr : numbers) {
            int number;
            try {
                number = Integer.parseInt(numberStr);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("String contains non-numeric value");
            }

            if (number <= 0) {
                throw new IllegalArgumentException("Input number must be positive.");
            }
            sum += number;
        }

        return sum;
    }

    public char[] getDelimiters() {
        return delimiters;
    }

    public String getNumberSequence() {
        return numberSequence;
    }
}
