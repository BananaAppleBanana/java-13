package week3.restimpl.pojo;

import java.util.Date;

public class Student {
    private String id;
    private String name;
    private Date createdDate;

    public Student(String id, String name) {
        this.id = id;
        this.name = name;
        this.createdDate = new Date();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
