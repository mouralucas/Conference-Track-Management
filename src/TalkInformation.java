/**
 *
 * @author Lucas Penha de Moura
 */
public class TalkInformation {
    private String talkTitle;
    private int talkLength;

    public TalkInformation(){}
    
    public TalkInformation(String talkTitle, int talkLength) {
        this.talkTitle = talkTitle;
        this.talkLength = talkLength;
    }
       
    public String getTalkTitle() {
        return talkTitle;
    }

    public void setTalkTitle(String talkTitle) {
        this.talkTitle = talkTitle;
    }

    public int getTalkLength() {
        return talkLength;
    }

    public void setTalkLength(int talkLength) {
        this.talkLength = talkLength;
    }
    
    
}
