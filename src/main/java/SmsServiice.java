import com.africastalking.AfricasTalking;
import com.africastalking.SmsService;
import com.africastalking.sms.Recipient;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class SmsServiice {


    public static String API_KEY;
    public static String USERNAME;
    public static String MESSAGE;
    public static String SERVICE_CODE;
    public static Boolean ENQUEUE=false;

    public static void main(String[] arg) throws IOException {
        setNameAndAPIKey();
        generateMessage();
        setServiceCode();
        AfricasTalking.initialize(API_KEY, USERNAME);
        List<Recipient> responses = sendSMS(getRecipients());
        System.out.println(responses.size());
        for (Recipient response : responses) {
            System.out.println(String.format("{ Number : %1$s\n" +"  Cost : %2$s \n" + "  Status : %3$s \n"+"  MessageId : %4$s \n}",
                response.number, response.cost,response.status,response.messageId));
        }
    }

    private static List<Recipient> sendSMS(String[] recipients) throws IOException {

        SmsService sms =AfricasTalking.getService(AfricasTalking.SERVICE_SMS);
        return sms.send(MESSAGE, SERVICE_CODE, recipients, ENQUEUE);
    }

    private static String[] getRecipients() {
        //read from some source
        return new String[] {"+254739496441", "+254739495441"};
    }

    private static void setServiceCode() {
        SERVICE_CODE="34478";
    }

    private static void generateMessage() {
        MESSAGE="Dear Mauriz , XXXX is helping you to improve your yield with free XXXXXX supply. kindly dial *384*44135# more details";
    }

    private static void setNameAndAPIKey() throws IOException {
        String filePath = "local.properties";
        Properties properties = new Properties();
        FileInputStream is = new FileInputStream(filePath);
        properties.load(is);
        API_KEY = properties.getProperty("application.username");
        USERNAME = properties.getProperty("application.key");
    }
}
