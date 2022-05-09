package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    void splitMultiple() {
        String[] actual = "a,b,c".split(",");
        assertThat(actual).isEqualTo(new String[]{"a", "b", "c"});
        assertThat(actual).contains("a");
        assertThat(actual).contains("b");
        assertThat(actual).contains("c");
    }

    @Test
    void splitSingle() {
        String[] actual = "a".split(",");
        assertThat(actual).isEqualTo(new String[]{"a"});
        assertThat(actual).containsExactly("a");
    }

    @Test
    void substring() {
        String actual = "(1,2)".substring(1, 4);
        assertThat(actual).isEqualTo("1,2");
    }
}
