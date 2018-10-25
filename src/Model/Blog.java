package Model;

import java.io.Serializable;
import java.util.Date;

public class Blog implements Serializable {
    private String name;
    private String txt;
    private Date date;

    public Blog(){}

    public Blog(String name, String txt, Date date) {
        this.name = name;
        this.txt = txt;
        this.date = date;
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
}
