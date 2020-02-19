package project;

public class JulianException extends RuntimeException {
    public JulianException(String s) {
    }
    public JulianException(String s, Exception e ) {
        System.out.println(s);
    }
}
