package dev.baaart.katas.decoder;

import dev.baaart.katas.model.MorseCode;

public class MorseCodeDecoder implements Decode {

    @Override
    public String decode(String code) {
        int trail = 0;
        int spaces = 0;

        StringBuffer buffer = new StringBuffer();
        String trimmedCode = code.trim();

        for (int lead = 0; lead < trimmedCode.length(); lead++) {
            char c = trimmedCode.charAt(lead);

            if (isSpace(c)) {
                spaces++;
                if (lead > 0 && isMorseCodeChar(trimmedCode.charAt(lead - 1))) {
                    buffer.append(getCodeFromBounds(trimmedCode, trail, lead));
                    trail = lead;
                }
            }

            if (isMorseCodeChar(c)) {
                if (lead > 0 && isSpace(trimmedCode.charAt(lead - 1))) {
                    trail = lead;
                    spaces = 0;
                }
            }

            if (spaces == 3) buffer.append(" ");

            // Reached end of file.
            if (lead == trimmedCode.length() - 1 && !isSpace(trimmedCode.charAt(lead))) {
                buffer.append(getCodeFromBounds(trimmedCode, trail, trimmedCode.length()));
            }
        }

        return buffer.toString();
    }

    private static boolean isSpace(char c) {
        return c == ' ';
    }

    private static boolean isMorseCodeChar(char c) {
        return c == '.' || c == '-';
    }

    private static String getCodeFromBounds(String code, int start, int end) {
        return MorseCode.get(code.substring(start, end));
    }
}
