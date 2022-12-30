package lab5;

import java.io.BufferedWriter;
import java.io.FilterWriter;
import java.io.IOException;

public class Writer extends FilterWriter {
    protected Writer(BufferedWriter out) {
        super(out);
    }

    public void write(char[] cbuf, int off, int len) throws IOException {
        for (int i = 0; i < cbuf.length; i++) {
            cbuf[i] = (char) (cbuf[i] + EncryptionDecryption.getKey());
        }
        super.write(cbuf, off, len);
    }
}
