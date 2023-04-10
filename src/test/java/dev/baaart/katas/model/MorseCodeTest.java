package dev.baaart.katas.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MorseCodeTest {

    private final MorseCode morseCode = new MorseCode();

    @Test
    void getSingleChar() {
        assertEquals("J", morseCode.get(".---"));
        assertEquals("L", morseCode.get(".-.."));
    }

    @Test
    void getSOS(){
        assertEquals("SOS", morseCode.get("...---..."));
    }

    @Test
    void getNonValid(){
        assertNull(morseCode.get("...-.-.-..."));
    }
}