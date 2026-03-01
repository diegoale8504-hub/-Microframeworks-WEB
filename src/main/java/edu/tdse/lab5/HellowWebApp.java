package edu.tdse.lab5;

import static edu.tdse.lab5.HttpServer.get;

public class HellowWebApp {
    public static void main(String[] args){
        get("/pi", ()-> "PI = " + Math.PI);
    }
}
