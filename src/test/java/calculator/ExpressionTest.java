package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
        assertThat(expression.getSum()).isEqualTo(6);
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
        assertThat(expression.getSum()).isEqualTo(6);
    }

    @Test
    void 음수_입력() {
        // given
        String input = "-1,2,3";

        // when, then
        Expression expression = Expression.parse(input);
        assertThatThrownBy(expression::getSum).isInstanceOf(IllegalArgumentException.class);
    }
}