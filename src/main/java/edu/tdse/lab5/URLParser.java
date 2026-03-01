package edu.tdse.lab5;
import java.net.MalformedURLException;
import java.net.URL;
public class URLParser {
    public static void main(String[] args) throws MalformedURLException {
        URL myurl = new URL("http://lbdn.is.escuelaing.edu.co:8084/respuestaexamenarep.txt");

        System.out.println("protocol: " + myurl.getProtocol());
        System.out.println("Port: " + myurl.getPort());
        System.out.println("Authority: " + myurl.getAuthority());
        System.out.println("Host: " + myurl.getHost());
        System.out.println("Path: " + myurl.getPath());
        System.out.println("Query: " + myurl.getQuery());
        System.out.println("File: " + myurl.getFile());
        System.out.println("Ref: " + myurl.getRef());
    }
}
