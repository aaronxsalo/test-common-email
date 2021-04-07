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
}
