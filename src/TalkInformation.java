/**
 *
 * @author Lucas Penha de Moura
 */
public class TalkInformation {
    private String talkTitle;
    private int talkLength;
    private boolean chosen;

    public TalkInformation(){}
    
    /**
     * 
     * @param talkTitle
     * @param talkLength 
     */
    public TalkInformation(String talkTitle, int talkLength) {
        this.talkTitle = talkTitle;
        this.talkLength = talkLength;
    }
       
    /**
     * 
     * @return the title of the talk
     */
    public String getTalkTitle() {
        return talkTitle;
    }

    /**
     * 
     * @param talkTitle 
     */
    public void setTalkTitle(String talkTitle) {
        this.talkTitle = talkTitle;
    }

    /**
     * 
     * @return the length of the talk
     */
    public int getTalkLength() {
        return talkLength;
    }

    /**
     * 
     * @param talkLength 
     */
    public void setTalkLength(int talkLength) {
        this.talkLength = talkLength;
    }

    /**
     * 
     * @return if the talk was used in a track or not
     */
    public boolean isChosen() {
        return chosen;
    }

    /**
     * 
     * @param chosen 
     */
    public void setChosen(boolean chosen) {
        this.chosen = chosen;
    } 
}
