package stringcalculator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SplitTest {
    @Test
    void split_singualr() {
        String text = "1";
        String[] tokens = text.split("[,:]");
        assertArrayEquals(new String[] {"1"}, tokens);
    }

    @Test
    void split_multitude() {
        String text = "1,2:3";
        String[] tokens = text.split("[,:]");
        assertArrayEquals(new String[] {"1", "2", "3"}, tokens);
    }
}
