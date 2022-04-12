package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Client {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    private long user;
    private String time;
    private String ip;
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
