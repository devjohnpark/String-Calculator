package stringcalculator;

import java.util.Optional;

// 문자(구분자, 숫자)의 유효성 확인하는 역할
class CharacterValidator {

    private static final char DEFAULT_SEPARATOR1 = ',';
    private static final char DEFAULT_SEPARATOR2 = ':';
    private static final char MIN_DIGIT = '0';
    private static final char MAX_DIGIT = '9';
    private final String CUSTOM_SEPARATOR_PREFIX = "//";
    private final String CUSTOM_SEPARATOR_SUFFIX = "\n";

    private Optional<Character> customSeparator = Optional.empty();

    public void setCustomSeparator(Optional<Character> customSeparator) {
        this.customSeparator = customSeparator;
    }

    public void validCustomSeparator(String input) {
        if (isCustomSeparator(input)) {
            this.customSeparator = Optional.of(input.charAt(CUSTOM_SEPARATOR_PREFIX.length()));
        }
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

    private boolean isCustomSeparator(String input) {
        return input.startsWith(CUSTOM_SEPARATOR_PREFIX) && input.substring(CUSTOM_SEPARATOR_PREFIX.length() + 1).startsWith(CUSTOM_SEPARATOR_SUFFIX);
    }

    private boolean isCustomSeparator(char currentChar) {
        return customSeparator.isPresent() && currentChar == customSeparator.get();
    }

    private boolean isDefaultSeparator(char currentChar) {
        return currentChar == DEFAULT_SEPARATOR1 || currentChar == DEFAULT_SEPARATOR2;
    }
}
