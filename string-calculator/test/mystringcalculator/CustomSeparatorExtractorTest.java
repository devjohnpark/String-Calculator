package mystringcalculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

// 테스트할 경우의 수
// 3. 커스텀 구분자의 문자열 형태일 경우, 문자열 앞부분의 "//;\n"에서 커스텀 구분자 ';'가 추출되는지
// 4. 커스텀 구분자의 문자열 형태가 아닌 경우, 결과값 확인
class CustomSeparatorExtractorTest {

    private CustomSeparatorExtractor customSeparatorExtractor;

    @BeforeEach
    void setUp() {
        customSeparatorExtractor = new CustomSeparatorExtractor();
    }

    @Test
    void getCustomSeparator_custom() {
        // Given
        char customSeparator = ';';
        String input = "//"+ customSeparator + "\n";

        // When
        Optional<Character> result = customSeparatorExtractor.getCustomSeparator(input);

        // Then
        assertTrue(result.isPresent());
        assertEquals(customSeparator, result.get());
//        assertEquals(Optional.of(customSeparator), result);
    }

    @Test
    void getCustomSeparator_not_custom() {
        // Given
        char customSeparator = ';';
        String input = "123" + customSeparator + "123";

        // When
        Optional<Character> result = customSeparatorExtractor.getCustomSeparator(input);

        // Then
        assertNotEquals(Optional.of(customSeparator), result);
    }
}