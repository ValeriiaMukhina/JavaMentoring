package utils;

import org.junit.Assert;
import org.junit.Test;

import utils.validation.InputValidator;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class ConsoleReaderTest {

    @Test
    public void shouldTakeUserInput() {
        String input = "test";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        String value = ConsoleReader.read(new InputValidator() {
            @Override
            public boolean isValid(String data) {
                return true;
            }
        });

        //assert output
        Assert.assertEquals("test", value);
    }
}