import java.util.List;

/**
 *
 * @author Lucas Penha de Moura
 */
public class PrintTracks {

    private int initTime;
    private int hour;
    private int min;
    private String clock12hour;

    /**
     *
     * @param track
     * @param trackNumber
     */
    public void print(List<TalkInformation> track, int trackNumber) {
        System.out.println("Track " + trackNumber + ":");

        initTime = 540;
        track.forEach((i) -> {
            /*Lunch must start at 12:00PM*/
            if (i.getTalkTitle().equals("Lunch")) {
                initTime = 720;
            }

            /*If last talk of afternoon ends after 4PM network must start at 5PM*/
            if (i.getTalkTitle().equals("Network Event") && initTime > 960) {
                initTime = 1020;
            }
            
            /*If last talk of afternoon ends after 4PM network must start at 4PM*/
            if(i.getTalkTitle().equals("Network Event") && initTime < 960){
                initTime = 960;
            }

            /*Converts 24 h clock to 12 hours clock*/
            if (initTime < 720) {
                hour = initTime / 60;
                min = initTime % 60;
                clock12hour = "AM";
            } else if(initTime == 720){
                hour = initTime / 60;
                min = initTime % 60;
                clock12hour = "PM";
            }else {
                hour = (initTime/60) - 12;
                min = initTime % 60;
                clock12hour = "PM";
            }

            System.out.format("%02d:%02d%s %s\n", hour, min, clock12hour, i.getTalkTitle());
            initTime += i.getTalkLength();

        });

        System.out.println("\n");
    }
}
