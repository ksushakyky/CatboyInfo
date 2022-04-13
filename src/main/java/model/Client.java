package model;

//import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "data")
public class Client {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;

//    @NotNull
    @Column(name = "user")
    private long user;
    @Column(name = "time")
    private String time;
    @Column(name = "ip")
    private String ip;
    @Column(name = "url")
    private String url;

    protected Client(){}

    public Client(int id, int user, String time, String ip, String url) {
        this.id = id;
        this.user = user;
        this.time = time;
        this.ip = ip;
        this.url = url;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUser() {
        return user;
    }

    public void setUser(long user) {
        this.user = user;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return String.format(
                "Client[id=%d, user=%d, time=%d, ip='%s', url='%s']",
                id, user, time, ip, url);
    }
}
