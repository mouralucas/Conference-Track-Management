import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lucas Penha de Moura
 */
public class Schedule {

    private BufferedReader inputInformation;
    private List<TalkInformation> listTalk = new ArrayList<>();
    private String talk;
    private String aux[];
    private int length;

    /**
     * 
     * @param file
     * @return the list of talks and its lengths
     */
    public List openSchedule(String file) {
        try {
            inputInformation = new BufferedReader(new FileReader(file));

            /*Read all schedule file (input) and determines the length of all talks*/
            while (inputInformation.ready()) {
                talk = inputInformation.readLine();
                aux = talk.split(" ");
                if (!aux[aux.length - 1].equals("lightning")) {
                    length = Integer.parseInt(aux[aux.length - 1].replace("min", ""));
                }else {
                    length = 5;
                }
                
                listTalk.add(new TalkInformation(talk, length));
            }

            inputInformation.close();
            
            

        } catch (IOException e) {
            System.out.println("Schedule Not Found");
        }
        
        return listTalk;
    }
}
