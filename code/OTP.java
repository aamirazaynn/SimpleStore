import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *  this class is used to send email with OTP
 */
public class OTP {
    private static final String SENDER = "";
    private static final String PASSWORD = "";
    private String RECEIVER;
    private int otp = (int) (Math.random() * 1000000);

    /**
     *  constructor
     */
    public OTP() {

    }

    /**
     *  this method is used to set the receiver
     * @param RECEIVER
     */
    public void setRECEIVER(String RECEIVER) {
        this.RECEIVER = RECEIVER;
    }

    /**
     *  this method is used to send email with OTP
     * @throws MessagingException
     */
    public void sendOTP() throws MessagingException {
        Properties props = new Properties();
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "465");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                return new javax.mail.PasswordAuthentication(SENDER, PASSWORD);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(SENDER));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(RECEIVER));
            message.setSubject("Email Verification");
            message.setText("To ensure your account is verified, please enter the following OTP in our app: " + otp
                    + ".\n\nBest Regards,\nToffee System.");
            Transport.send(message);
            System.out.println("OTP sent successfully to " + RECEIVER);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     *  this method is used to check if the user entered the correct OTP
     * @param otp
     * @return
     */
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
