package nal.test.planning.dto;

public class JsonResponsePagingDto {
    private int code;
    private String message;
    private MetaPaging metaPaging;
    private Object data;

    public int getCode() {
        return code;
    }
    public void setCode(int code) {
        this.code = code;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public Object getData() {
        return data;
    }
    public void setData(Object data) {
        this.data = data;
    }
    public MetaPaging getMetaPaging() {
        return metaPaging;
    }
    public void setMetaPaging(MetaPaging metaPaging) {
        this.metaPaging = metaPaging;
    }
}
