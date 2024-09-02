package mystringcalculator;

import java.util.Optional;

// 문자(구분자, 숫자)의 유효성 확인하는 역할
class CharacterValidator {

    private final char DEFAULT_SEPARATOR1 = ',';
    private final char DEFAULT_SEPARATOR2 = ':';
    private final char MIN_DIGIT = '0';
    private final char MAX_DIGIT = '9';
    private final CustomSeparatorExtractor customSeparatorExtractor;
    private Optional<Character> customSeparator = Optional.empty();

    public CharacterValidator() {
        this.customSeparatorExtractor = new CustomSeparatorExtractor();
    }

    public void validCustomSeparator(String input) {
        this.customSeparator = customSeparatorExtractor.getCustomSeparator(input);
    }

    public boolean isDigit(char currentChar) {
        return currentChar >= MIN_DIGIT && currentChar <= MAX_DIGIT;
    }

    public boolean isNegativeNumber(char currentChar) {
        return currentChar == '-';
    }

    public boolean isSeparator(char currentChar) {
        return isCustomSeparator(currentChar) || isDefaultSeparator(currentChar);
    }

    private boolean isCustomSeparator(char currentChar) {
        return customSeparator.isPresent() && currentChar == customSeparator.get();
    }

    private boolean isDefaultSeparator(char currentChar) {
        return currentChar == DEFAULT_SEPARATOR1 || currentChar == DEFAULT_SEPARATOR2;
    }
}
