package edu.tdse.lab5;

public class Response {
    private int status = 200;
    private String contentType = "text/plain; charset=UTF-8";

    public int getStatus() {
        return status;
    }

    public void status(int status) {
        this.status = status;
    }

    public String getContentType() {
        return contentType;
    }

    public void type(String contentType) {
        this.contentType = contentType;
    }
}
