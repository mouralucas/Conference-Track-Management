/**
 *
 * @author Lucas Penha de Moura
 */


public class InitSystem {
    /**
     * 
     * @param args 
     */
    public static void main(String args[]) {
        /*Class that opens the file with the available talks*/
        Schedule schedule = new Schedule();
        
        /*Starts the traks management with the available talks and its lengths*/
        CreateTracks tracks = new CreateTracks();
        tracks.tracks(schedule.openSchedule(args[0]));
    }
}
