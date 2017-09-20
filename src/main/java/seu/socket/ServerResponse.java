package seu.socket;

import java.io.Serializable;

public class ServerResponse implements Serializable {

    private Object data;

    public ServerResponse() {
        super();
    }

    public ServerResponse(Object data) {
        this.data = data;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ServerResponse{" +
                "data=" + data +
                '}';
    }
}
