package com.citizant.kudos.service.impl;

import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.amazonaws.AmazonClientException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClient;
import com.amazonaws.services.simpleemail.model.Body;
import com.amazonaws.services.simpleemail.model.Content;
import com.amazonaws.services.simpleemail.model.Destination;
import com.amazonaws.services.simpleemail.model.Message;
import com.amazonaws.services.simpleemail.model.SendEmailRequest;
import com.citizant.kudos.common.SystemConfig;
import com.citizant.kudos.service.EmailService;

public class AwsEmailServiceImpl implements EmailService {
	static final String FROM = "swang@citizant.com";  // Replace with your "From" address. This address must be verified.
    static final String TO = "swang@citizant.com"; 	  // Replace with a "To" address. If you have not yet requested
                                                      // production access, this address must be verified.
    static final String BODY = "This email was sent through Amazon SES by using the AWS SDK for Java.";
    static final String SUBJECT = "Amazon SES test (AWS SDK for Java)";
    
    private static Log log = LogFactory.getLog("com.citizant.kudos.service.impl.AwsEmailServiceImpl");

    AWSCredentials credentials = null;
    
    public AwsEmailServiceImpl() {
    	
         try {
             credentials = new ProfileCredentialsProvider().getCredentials();
         } catch (Exception e) {
             throw new AmazonClientException(
                     "Cannot load the credentials from the credential profiles file. " +
                     "Please make sure that your credentials file is at the correct " +
                     "location (~/.aws/credentials), and is in valid format.",
                     e);
         }
         
    }
     
	@Override
	public boolean sendMail(String to, String from, String url) {
		  // Construct an object to contain the recipient address.
        Destination destination = new Destination().withToAddresses(new String[]{to});

        // Create the subject and body of the message.
        Content subject = new Content().withData("You Have Received a KUDO!!");
        Content textBody = new Content().withData("Hello,\nYou have received a KUDO!!  Click on the link below to see it:\n" + url + "\nThank you\nFLASH Team.");
        Body body = new Body().withText(textBody);

        // Create a message with the specified subject and body.
        Message message = new Message().withSubject(subject).withBody(body);

        // Assemble the email.
        SendEmailRequest request = new SendEmailRequest().withSource(from).withDestination(destination).withMessage(message);
        try {        
            // Instantiate an Amazon SES client, which will make the service call with the supplied AWS credentials.
            AmazonSimpleEmailServiceClient client = new AmazonSimpleEmailServiceClient(credentials);
            Region REGION = Region.getRegion(Regions.US_EAST_1);
            client.setRegion(REGION);
            // Send the email.
            client.sendEmail(request);
            return true;
        } catch (Exception ex) {
        	return false;
        }
	}
}
