package lotto.validation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BonusNumberValidatorTest {

    @DisplayName("아무 값도 입력하지 않으면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"", "  "})
    void validateNull(String input) {
        assertThrows(IllegalArgumentException.class, () -> {
            BonusNumberValidator.validateBonusNumber(input);
        });
    }

    @DisplayName("숫자가 0으로 시작되면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"045", "0", "04"})
    void validateStartWithZero(String input) {
        assertThrows(IllegalArgumentException.class, () -> {
            BonusNumberValidator.validateBonusNumber(input);
        });
    }

    @DisplayName("입력된 수가 1~45의 범위가 아닌 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"48", "848"})
    void validateRange(String input) {
        assertThrows(IllegalArgumentException.class, () -> {
            BonusNumberValidator.validateBonusNumber(input);
        });
    }
}