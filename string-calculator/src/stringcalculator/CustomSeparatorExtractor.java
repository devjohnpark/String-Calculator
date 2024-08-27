package stringcalculator;

import java.util.Optional;

// 커스텀 구분자 추출하는 역할
class CustomSeparatorExtractor {
    private final String CUSTOM_SEPARATOR_PREFIX = "//";
    private final String CUSTOM_SEPARATOR_SUFFIX = "\n";

    public Optional<Character> getCustomSeparator(String input) {
        if (isCustomSeparator(input)) {
            return Optional.of(input.charAt(CUSTOM_SEPARATOR_PREFIX.length()));
        }
        return Optional.empty();
    }

    private boolean isCustomSeparator(String input) {
        return input.startsWith(CUSTOM_SEPARATOR_PREFIX) && input.substring(CUSTOM_SEPARATOR_PREFIX.length() + 1).startsWith(CUSTOM_SEPARATOR_SUFFIX);
    }
}
