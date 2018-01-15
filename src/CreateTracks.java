
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

    private int trackMorning;
    private int trackAfternoon;
    private int talkCount;

    List<TalkInformation> scheduleTalks = new ArrayList<>();
    List<TalkInformation> track = new ArrayList<>();

    /**
     *
     * @param talks (list of scheduled talks)
     * @return the number of talks that were used to create the tracks
     */
    public int tracks(List<TalkInformation> talks) {
        scheduleTalks = talks;
        talkCount = 0; //counts the number of talks in both tracks

        //sorts the list from greater length to smallest 
        scheduleTalks.sort(Comparator.comparing(TalkInformation::getTalkLength).reversed());

        fillTracks(1);          //create track 1
        fillTracks(2);          //create track 2
        return talkCount;       //variable that count how many talks are in both tracks
    }

    /**
     *
     * @param trackNumber
     */
    public void fillTracks(int trackNumber) {
        /*The Mourning Track*/
        trackMorning = 0;
        scheduleTalks.forEach((i) -> {
            if (!i.isChosen() && (trackMorning + i.getTalkLength() <= 180)) {
                track.add(i);
                trackMorning += i.getTalkLength();
                i.setChosen(true);
                talkCount++;
            }
        });

        //Add the lunch track
        track.add(new TalkInformation("Lunch", 60));

        /*The Afternoon Track*/
        trackAfternoon = 0;
        scheduleTalks.forEach((i) -> {
            if (!i.isChosen() && (trackAfternoon + i.getTalkLength() < 240)) {
                track.add(i);
                trackAfternoon += i.getTalkLength();
                i.setChosen(true);
                talkCount++;
            }
        });

        //Add the network event (the length is 0 for it's no time determined for this event and it's not relevant to the solution)
        track.add(new TalkInformation("Network Event", 0));

        //prints the track in the terminal
        print.print(track, trackNumber);

        track.clear();
    }
}
