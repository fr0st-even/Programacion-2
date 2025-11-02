package Pintest;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RangeValidatorTest {

    private RangeValidator cut;

    @BeforeEach
    void before() {
        cut = new RangeValidator();
    }

    @Test
    @DisplayName("Debería retornar verdadero dado 50")
    void fifty_isValid_returnsTrue() {
        assertThat(cut.isValid(50)).isTrue();
    }

    @Test
    @DisplayName("Debería retornar falso dado 200")
    void twoHundred_isValid_returnsFalse() {
        assertThat(cut.isValid(200)).isFalse();
    }

    @Test
    @DisplayName("Debería retornar verdadero dado 100")
    void hundred_isValid_returnsTrue() {
        assertThat(cut.isValid(100)).isTrue();
    }

    @Test
    @DisplayName("Debería retornar falso dado 0")
    void zero_isValid_returnsFalse() {
        assertThat(cut.isValid(0)).isFalse();
    }
}
