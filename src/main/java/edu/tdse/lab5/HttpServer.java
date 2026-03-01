package edu.tdse.lab5;

import java.net.*;
import java.io.*;
public class HttpServer {
    public static void main(String[] args) throws IOException, URISyntaxException {
        ServerSocket serverSocket = null;
        while (true) {
            try {
                serverSocket = new ServerSocket(35000);
            } catch (IOException e) {
                System.err.println("Could not listen on port: 35000.");
                System.exit(1);
            }
            Socket clientSocket = null;
            try {
                System.out.println("Listo para recibir ...");
                clientSocket = serverSocket.accept();
            } catch (IOException e) {
                System.err.println("Accept failed.");
                System.exit(1);
            }


            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                            clientSocket.getInputStream()));
            String inputLine, outputLine;
            boolean isFirstLine = true;
            String rePath = null;
            while ((inputLine = in.readLine()) != null) {
                System.out.println("Received: " + inputLine);
                if (isFirstLine) {
                    String[] fistLineTokens = inputLine.split(" ");
                    String method = fistLineTokens[0];
                    String uri = fistLineTokens[1];

                    URI requestedURI = new URI(uri);
                    rePath = requestedURI.getPath();
                    System.out.println("path:" + rePath);
                    isFirstLine = false;
                }
                if (!in.ready()) {
                    break;
                }

            }

            assert rePath != null;
            if(rePath.equals("/pi"))
                outputLine = "HTTP/1.1 200 OK\r\n" +
                        "content=Type: text/html\n\r"
                        + "\n\r"
                        + "<!DOCTYPE html>"
                        + "<html>"
                        + "<head>"
                        + "<meta charset=\"UTF-8\">"
                        + "<title>Title of the document</title>\n"
                        + "</head>"
                        + "<body>"
                        + Math.PI
                        + "</body>"
                        + "</html>" + inputLine;
            else {
                outputLine = "HTTP/1.1 200 OK\r\n" +
                        "content=Type: text/html\n\r"
                        + "\n\r"
                        + "<!DOCTYPE html>"
                        + "<html>"
                        + "<head>"
                        + "<meta charset=\"UTF-8\">"
                        + "<title>Title of the document</title>\n"
                        + "</head>"
                        + "<body>"
                        + "body"
                        + "</body>"
                        + "</html>" + inputLine;


            }
            out.println(outputLine);

            out.close();
            in.close();
            clientSocket.close();
            serverSocket.close();





        }
    }
}