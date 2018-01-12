
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Lucas Penha de Moura
 */
public class CreateTracks {

    PrintTracks print = new PrintTracks();
    TalkInformation ti;

    private int trackMorning;
    private int trackAfternoon;

    private boolean morningOk;
    private boolean afternoonOk;

    List<TalkInformation> scheduleTalks;
    List<TalkInformation> track = new ArrayList<>();
    //List<TalkInformation> track2 = new ArrayList<>();
    

    /**
     *
     * @param talks
     */
    public void tracks(List<TalkInformation> talks) {
        scheduleTalks = talks;
        fillTracks(1);
        //fillTracks(2);
    }

    public void fillTracks(int trackNumber) {

        //sorts the list from greater length to smallest 
        scheduleTalks.sort(Comparator.comparing(TalkInformation::getTalkLength).reversed());

        Iterator<TalkInformation> iterator = scheduleTalks.iterator();

        while (iterator.hasNext()) {

            /*The Mourning Track*/
            morningOk = false;
            trackMorning = 0;
            while (!morningOk) {
                ti = iterator.next();
                if ((trackMorning + ti.getTalkLength()) <= 180) {
                    track.add(ti);
                    trackMorning += ti.getTalkLength();
                    iterator.remove();
                } else {
                    morningOk = true;
                }
            }

            //Add the lunch track
            track.add(new TalkInformation("Lunch", 60));

            /*The Afternoon Track*/
            afternoonOk = false;
            trackAfternoon = 0;
            while (!afternoonOk) {
                ti = iterator.next();
                if ((trackAfternoon + ti.getTalkLength()) <= 240) {
                    track.add(ti);
                    trackAfternoon += ti.getTalkLength();
                    iterator.remove();
                } else {
                    afternoonOk = true;
                }
            }

            //Add the network event (the length is 0 for it's no time determined for this event and it's not relevant to the solution)
            track.add(new TalkInformation("Network Event", 0));
            break;

        }
        
        track.forEach((i) -> {
            System.out.println(i.getTalkTitle());
        });
    }
}
