package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("InputValidator의 검증 기능 중")
class InputValidatorTest {
    private InputValidator inputValidator = new InputValidator();

    @Nested
    @DisplayName("숫자 검증에서")
    class ValidateIsNumeric {
        @Test
        @DisplayName("숫자를 입력했을때가 검증되는가")
        void validateNumber() {
            inputValidator.validateIsNumeric("123");
        }

        @Test
        @DisplayName("일반 문자열을 입력했을때가 검증되는가")
        void validateNonNumber() {
            assertThatThrownBy(() -> inputValidator.validateIsNumeric("abc"))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Nested
    @DisplayName("1000의 배수 검증에서")
    class ValidateMultiplyOfThousand {
        @Test
        @DisplayName("1000의 배수를 입력했을떄가 검증되는가")
        void validateMultiplyOfThousand() {
            inputValidator.validateMultiplyOfThousand(1000);
        }

        @Test
        @DisplayName("1000의 배수가 아닌 수를 입력했을떄가 검증되는가")
        void validateAnyNumber() {
            assertThatThrownBy(() -> inputValidator.validateMultiplyOfThousand(1001))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Nested
    @DisplayName("당첨 번호 입력값 검증에서")
    class ValidateIsListWithComma {
        @Test
        @DisplayName("정상 입력이 검증되는가")
        void validateRightInput() {
            inputValidator.validateIsListWithComma("1,2,3,4,5,6");
        }

        @Test
        @DisplayName("비정상 입력이 검증되는가")
        void validateWrongInputWithMissingNumber() {
            assertThatThrownBy(() -> inputValidator.validateIsListWithComma("1,2,3,4,5,"))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("비정상 입력이 검증되는가")
        void validateWrongInput() {
            assertThatThrownBy(() -> inputValidator.validateIsListWithComma("1,2,3,4,5 ,6"))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
}
