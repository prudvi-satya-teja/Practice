package org.example;


public class Dev {

    private Computer con;

    Dev() {
        System.out.println("Dev constructor");
    }

    public void setCon(Computer con) {
        this.con = con;
    }

    public void build() {
        System.out.println("Builing an awesome application");
        this.con.work();
    }

}
