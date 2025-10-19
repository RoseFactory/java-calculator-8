package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class ExpressionTest {

    @Test
    void 커스텀_구분자_사용() {
        // given
        String input = "//;\\n1;2;3";

        // when
        Expression expression = Expression.parse(input);

        // then
        assertThat(expression.getDelimiters()).isEqualTo(new char[]{';'});
        assertThat(expression.getNumberSequence()).isEqualTo("1;2;3");
    }

    @Test
    void 일반_입력() {
        // given
        String input = "1,2:3";

        // when
        Expression expression = Expression.parse(input);

        // then
        assertThat(expression.getDelimiters()).isEqualTo(new char[]{',', ':'});
        assertThat(expression.getNumberSequence()).isEqualTo("1,2:3");
    }
}