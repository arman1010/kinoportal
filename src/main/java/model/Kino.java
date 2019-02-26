package model;

import lombok.Data;

import java.util.Date;
import java.util.Set;

@Data
public class Kino {
    private int id;
    private String name;
    private String description;
    private String picUrl;
    private int year;
    private String directorName;
    private Set<Genre> genre;
    private User user;
    private Date date;
}
