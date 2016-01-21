package av.xxx.qunyingzhuantest.Bean;

/**
 * Created by 1 on 2016/1/20.
 */
public class ChatBean {

    private int type;
    private String text;

    public ChatBean(int type, String text) {
        this.type = type;
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
