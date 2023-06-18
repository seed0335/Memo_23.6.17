package seed.pratice.Memo;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Memo {
    public Long id;
    public String name;
    public String password;
    public String content;

    public Memo() {
    }

    public Memo(String name, String password, String content) {
        this.name = name;
        this.password = password;
        this.content = content;
    }

    public Memo(Long id, String password, String content) {
        this.id = id;
        this.password = password;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Memo(Long id, String name, String password, String content) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.content = content;
    }
}
