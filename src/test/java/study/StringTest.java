package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    void splitString() {
        String[] actual = "1,2".split(",");
        assertThat(actual).contains("1");
        assertThat(actual).contains("2");
        assertThat(actual).containsExactly("1", "2");
    }

    @Test 
    void splitWithNotExistValue() {
        String[] actual = "1".split(",");
        assertThat(actual).containsExactly("1");
    }

    @Test
    void substring() {
        String actual = "(1,2)".substring(1, 4);
        assertThat(actual).matches("1,2");
    }

    @Test
    void charAtValid() {
        char actual = "abc".charAt(1);
        assertThat(actual).isEqualTo('b');
    }

    @Test
    @DisplayName("nananan")
    void charAtInvalid() {
        assertThatThrownBy(() -> "abc".charAt(4))
                .isInstanceOf(IndexOutOfBoundsException.class);

        // assertThatExceptionOfType(IndexOutOfBoundsException.class)
        //         .isThrownBy(() -> "abc".charAt(4));
    }
}
