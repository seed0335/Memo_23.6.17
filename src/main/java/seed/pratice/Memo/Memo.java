package seed.pratice.Memo;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Memo {
    private Long id;
    private String name;
    private String content;

    public Memo() {
    }

    public Memo(String name, String content) {
        this.name = name;
        this.content = content;
    }
}
