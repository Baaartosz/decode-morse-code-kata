package dev.baaart.katas.decoder;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MorseCodeDecoderTest {

    private final MorseCodeDecoder morseCodeDecoder = new MorseCodeDecoder();

    @Test
    void decodeSingleChar() {
        assertEquals("H",
                morseCodeDecoder.decode("...."));
    }

    @Test
    void decodeTwoWordsWithSpace() {
        assertEquals("HEY JUDE",
                morseCodeDecoder.decode(".... . -.--   .--- ..- -.. ."));
    }

    @Test
    void decodeLongSentenceWithSpaces() {
        assertEquals("HELLO WORLD ITS AN AMAZING DAY",
                morseCodeDecoder.decode(".... . .-.. .-.. ---   .-- --- .-. .-.. -..   .. - ...   .- -.   .- -- .- --.. .. -. --.   -.. .- -.--"));
    }

    @Test
    void decodeSentence(){
        assertEquals("HEY JUDE",
                morseCodeDecoder.decode(".... . -.--   .--- ..- -.. ."));
    }

    @Test
    void decodeComplexSingleSpaceBeforeCharacter() {
        assertEquals("E",
                morseCodeDecoder.decode("  ."));
    }

    @Test
    void decodeComplexSpacesOnCharacters() {
        assertEquals("E E",
                morseCodeDecoder.decode("   .   . "));
    }

    @Test
    void decodeComplexExtraSpacesInSentence() {
        assertEquals("HEY JUDE",
                morseCodeDecoder.decode(" .... . -.--    .--- ..- -.. ."));
    }
}