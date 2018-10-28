package Model;

import java.io.Serializable;
import java.util.Date;

public class Blog implements Serializable {
    private String name;
    private String txt;
    private Date date;
    private int id;

    public Blog(){}

    public Blog(String name, String txt, Date date, int id) {
        this.name = name;
        this.txt = txt;
        this.date = date;
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTxt() {
        return this.txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
