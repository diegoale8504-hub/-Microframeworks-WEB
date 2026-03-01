package edu.tdse.lab5;



@FunctionalInterface
public interface Route {
    String handle(Request req, Response res) throws Exception;
}
