package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        String input = Console.readLine();

        Expression expression = Expression.parse(input);

        System.out.println("결과 : " + expression.getSum());
    }
}
