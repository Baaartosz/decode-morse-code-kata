package dev.baaart.katas.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MorseCodeTest {

    @Test
    void getSingleChar() {
        assertEquals("J", MorseCode.get(".---"));
        assertEquals("L", MorseCode.get(".-.."));
    }

    @Test
    void getSOS(){
        assertEquals("SOS", MorseCode.get("...---..."));
    }

    @Test
    void getNonValid(){
        assertNull(MorseCode.get("...-.-.-..."));
    }
}