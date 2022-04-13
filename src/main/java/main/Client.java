package main;

//import com.sun.istack.NotNull;

import org.springframework.context.annotation.Primary;

import javax.persistence.*;

@Entity
public class Client {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    private String time;
    private String ip;
    private String url;

    protected Client(){}

    public Client(int id, String time, String ip, String url) {
        this.id = id;
        this.time = time;
        this.ip = ip;
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
                "Client[id=%d, time=%d, ip='%s', url='%s']",
                id, time, ip, url);
    }
}
