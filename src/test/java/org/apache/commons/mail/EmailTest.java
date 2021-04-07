package org.apache.commons.mail;

import java.util.Date;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

//COVERAGE:
//addBCc(String... emails) 100%
//addCc(String email) 100%
//addHeader(String name, String value) 78.3%
//addReplyTo(String email, String name) 100%
//buildMimeMessage() 72.1%
//getHostName() 70.6%
//getMailSession() 72.0%
//getSentDate() 100%
//getSocketConnectionTimeout() 100%
//setFrom(String email) 100%

public class EmailTest {
	
	private static final String[] TEST_EMAILS = {"bla@abc.com", "blabla@abc.org", "blablalblalblalblalblalblalbla@abc.com.bd"}; //email addresses for various tests
	
	private EmailConcrete testEmail; //EmailConcrete object for testing
	
	@Before
	public void setupEmailTest() throws Exception {
		
		testEmail = new EmailConcrete(); //makes testEmail a new EmailConrete to initialize it		
	}
	
	@After
	public void tearDownEmailTest() throws Exception {
		
	}
	
	@Test //tests if a correct argument is passed to addBcc
	public void testAddBccCorrect() throws Exception {
		
		testEmail.addBcc(TEST_EMAILS); //testing the addBcc function with the full list of test emails
		
		assertEquals(3, testEmail.getBccAddresses().size()); //checking if the size of the BCC address list is equal to 3
		
	}
	
	@Test (expected = EmailException.class) //tests if an incorrect null argument is passed to addBcc
	public void testAddBccIncorrect() throws Exception {
		
		String[] nullString = null; //null array of strings
		testEmail.addBcc(nullString); //testing the addBcc function with null strings
		
		assertEquals(0, testEmail.getBccAddresses().size()); //checking if the size of the BCC address list is equal to 0
	}
	
	@Test //tests if a correct argument is passed to addCc 
	public void testAddCc() throws Exception {
		
		testEmail.addCc(TEST_EMAILS[0]); //passes the first email from the array
		
		assertEquals(1, testEmail.getCcAddresses().size()); //makes sure only one email is in the list
		
	}
	
	@Test //tests if correct arguments are passed to addHeader
	public void testAddHeaderCorrect() throws Exception {
		
		testEmail.addHeader("H1", "Person"); //passes a name and value as strings
	}
	
	@Test (expected = IllegalArgumentException.class) //tests if an incorrect null argument is passed to addHeader
	public void testAddHeaderIncorrect() throws Exception {
		
		String noName = null; //null name string
		String noValue = null; //null value string
		
		testEmail.addHeader(noName, noValue); //calls addHeader with the null values
	}
	
	@Test //tests addReplyTo with correct string arguments
	public void testAddReplyTo() throws Exception {
		
		String name = "Bob"; //name string
		
		testEmail.addReplyTo(TEST_EMAILS[0], name); //passes first email and name string
		
		assertEquals(name + " <" +TEST_EMAILS[0] + ">", String.valueOf(testEmail.getReplyToAddresses().get(0))); //checks to see if the reply to address added is correct using the proper formatting
	}
}
