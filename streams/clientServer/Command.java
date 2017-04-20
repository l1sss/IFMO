package streams.clientServer;

import java.io.*;

/**
 * Created by l1s on 17.04.17.
 */
public class Command implements Externalizable {
    private int code;

    public Command() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeInt(code);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        code = in.readInt();
    }

    @Override
    public String toString() {
        return "code=" + code;
    }
}
