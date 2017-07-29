package pdfemail.base;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pdfemail.customization.JyperionListener;

//Add listener for pdf report generation

@Listeners(JyperionListener.class)
public class TestGuru99PDFEmail extends BaseClass {

	WebDriver driver;

	//Testcase failed so screen shot generate
	@Test
	public void testPDFReportOne() {
		driver = BaseClass.getDriver();
		driver.get("https://www.google.co.in");
		Assert.assertTrue(false);
	}


	//Testcase failed so screen shot generate

	@Test

	public void testPDFReporTwo(){

		driver = BaseClass.getDriver();

		driver.get("http:/guru99.com");

		Assert.assertTrue(false);

	}



	//Test test case will be pass, so no screen shot on it

	@Test

	public void testPDFReportThree(){

		driver = BaseClass.getDriver();

		driver.get("http://demo.guru99.com");

		Assert.assertTrue(true);

	}
	
	@AfterTest
	public void close() {
		driver.close();
	}
	
	 //After complete execution send pdf report by email
	@AfterSuite
	public void tearDown() throws MessagingException {
		sendPDFReportByGmail("deepak.republic@gmail.com","password","deepenrathore28@gmail.com","PDF Report","");
	}
	
	/**

     * Send email using java

     * @param from

     * @param pass

     * @param to

     * @param subject

     * @param body
	 * @throws MessagingException 

     */
	public static void sendPDFReportByGmail(String from,String password , String to,String subject , String body) throws MessagingException {
			
			Properties props = System.getProperties();
	        String host = "smtp.gmail.com";
	        props.put("mail.smtp.starttls.enable", "true");
	        props.put("mail.smtp.host", host);
	        props.put("mail.smtp.user", from);
	        props.put("mail.smtp.password", password);
	        props.put("mail.smtp.port", "587");
	        props.put("mail.smtp.auth", "true");
			
			Session session = Session.getDefaultInstance(props);
			
			MimeMessage message = new MimeMessage(session);
			
			try {
				//Set from address
				message.setFrom(new InternetAddress(from));
				message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
				
				//set subject
				message.setSubject(subject);
				message.setText(body);
				
				BodyPart objMessageBodyPart = new MimeBodyPart();
				objMessageBodyPart.setText("Please find attached PDF report");
				
				Multipart multipart = new MimeMultipart();
				multipart.addBodyPart(objMessageBodyPart);
				
				
				objMessageBodyPart = new MimeBodyPart();
				//Set path to the pdf report file

				String filename = System.getProperty("user.dir")+"/Default test.pdf";
				
				//Create data source to attach the file in mail
				DataSource source = new FileDataSource(filename);
				
				objMessageBodyPart.setDataHandler(new DataHandler(source));
				
				
				objMessageBodyPart.setFileName(filename);
				multipart.addBodyPart(objMessageBodyPart);
				
				message.setContent(multipart);
				
				Transport transport = session.getTransport("smtp");
				transport.connect(host,from,password);
				
				transport.sendMessage(message, message.getAllRecipients());
				
				transport.close();
				
				
				
			} catch (AddressException ae) {
				ae.printStackTrace();
			}
			catch(MessagingException me) {
				me.printStackTrace();
			}
			
	}
}
