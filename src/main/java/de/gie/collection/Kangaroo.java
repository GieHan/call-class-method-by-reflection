package de.gie.collection;

public class Kangaroo {

    private String text;
    private boolean signal;

    public Kangaroo(String text) {
        this.text   = text;
        this.signal = false;
    }

    public  Kangaroo(boolean signal){
        this.text   = "";
        this.signal = signal;
    }

    public Kangaroo(String text, boolean signal) {
        this.text = text;
        this.signal = signal;
    }

    public String doSing(String s, int i, Boolean b) {
        return s + " " + Integer.toString(i) + " " + Boolean.toString(b);
    }
}
