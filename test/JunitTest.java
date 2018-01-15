import junit.framework.TestCase;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Lucas Penha de Moura
 */
public class JunitTest extends TestCase {

    public JunitTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception{
        System.out.println("* UtilsJUnit4Test: @BeforeClass method");
    }

    @AfterClass
    public static void tearDownClass() throws Exception{
        System.out.println("* UtilsJUnit4Test: @AfterClass method");
    }

    
    @Test
    public void testTalksTracks() {
        //All schedule tracks must be in the tracks
        int numberOfTalksScheduled = 19;
        int numberOfTalksInTracks;
        
        Schedule schedule = new Schedule();
        
        /*Starts the traks management with the available talks and its lengths*/
        CreateTracks tracks = new CreateTracks();
        numberOfTalksInTracks = tracks.tracks(schedule.openSchedule("input.txt"));
        assertEquals(numberOfTalksScheduled, numberOfTalksInTracks);
    }
}
