import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class OTP {
    private static final String SENDER = "yehiazakaria539@gmail.com";
    private static final String PASSWORD = "1922004yzz";
    private String RECEIVER;
    private int otp = (int) (Math.random() * 1000000);

    public OTP() {

    }

    public void setRECEIVER(String RECEIVER) {
        this.RECEIVER = RECEIVER;
    }

    public void sendOTP() throws MessagingException {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                return new javax.mail.PasswordAuthentication(SENDER, PASSWORD);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(SENDER));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(RECEIVER));
            message.setSubject("Your OTP");
            message.setText("Your OTP is: " + otp);
            Transport.send(message);
            System.out.println("OTP sent successfully to " + RECEIVER);
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }

    public boolean checkOTP(int otp) {
        if (this.otp == otp) {
            System.out.println("OTP verified");
            return true;
        } else {
            System.out.println("OTP not verified");
            return false;
        }
    }






}
