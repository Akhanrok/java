package lab5;

import java.io.BufferedReader;
import java.io.FilterReader;
import java.io.IOException;

public class Reader extends FilterReader {
    protected Reader(BufferedReader in) {
        super(in);
    }

    public int read(char[] cbuf, int off, int len) throws IOException {
        int read = super.read(cbuf, off, len);
        for (int i = 0; i < cbuf.length; i++) {
            cbuf[i] = (char) (cbuf[i] - EncryptionDecryption.getKey());
        }
        return read;

    }
}
