package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

import app.KKProtocol;


public class KKProtocolTest {
    private KKProtocol kkProtocol;

    @BeforeEach
    public void setup() throws Exception {
        this.kkProtocol = new KKProtocol();
    }

    @Test
    @DisplayName("Testing first call returns \"Knock Knock\"")
    public void testProcessInputFirstCall() {
        assertEquals("Knock Knock", this.kkProtocol.processInput(null));
    }

    @Test
    @DisplayName("Testing second call returns \"Your\" if correct input")
    public void testProcessInputSecCall() {
        assertEquals("Knock Knock", this.kkProtocol.processInput("Who's There"));
    }

    
}
