package com.citizant.kudos.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;


public class SystemConfig {
	
	private static Log log = LogFactory.getLog(SystemConfig.class);
	
	private static SystemConfig instance;
	
	private String awsS3Bucket = "";
	private String fidServiceURL = "";
	private String faceServiceURL = "";
	private String serverId = "";
	private String dataKeyId = "";
	private String kmsEndPoint = "";
	private String sesSenderEmail = "swang@citizant.com";
	private String defaultEmailSubject = "";
	private String defaultEmailContent = "";
	private String confirmEmailSubject = "";
	private String confirmEmailContent = "";
	private String cardInstruction = "";
	private String loadBalancerAddress = "";
	private String jasperTemplate = "";
	private String env = "LOCAL";
	private Region awsRegion;
	
	private SystemConfig()
	{
		readAWSRegionAndEnv();
	}
	
	public static synchronized SystemConfig getInstance()
	{
	    if (instance == null)
	    {
	    	instance = new SystemConfig();
	    }
	    return instance;
	}
	
	public void loadConfig (String fileName) throws DocumentException {
			SAXReader reader = new SAXReader();
			File metaFile = new File(fileName);
			Document doc = reader.read(metaFile);
			Element root = doc.getRootElement();
			awsS3Bucket = root.elementText("asw-s3-bucket");
			fidServiceURL = root.elementText("id-service-url");	
			serverId = root.elementText("server-id");	
			dataKeyId = root.elementText("data-key-id");
			kmsEndPoint = root.elementText("kms-end-point");		
			sesSenderEmail = root.elementText("ses-sender-email");	
			faceServiceURL = root.elementText("face-service-url");	
			defaultEmailSubject = root.elementText("reset-email-subject");	
			defaultEmailContent = root.elementText("reset-email-content");	
			confirmEmailSubject = root.elementText("confirm-email-subject");	
			confirmEmailContent = root.elementText("confirm-email-content");
			cardInstruction = root.elementText("card-instruction");
			loadBalancerAddress = root.elementText("load-balancer-address");
	}

	public String getAwsS3Bucket() {
		return awsS3Bucket;
	}

	public String getFidServiceURL() {
		return fidServiceURL;
	}

	public String getFaceServiceURL() {
		return faceServiceURL;
	}

	public String getServerId() {
		return serverId;
	}

	public String getDataKeyId() {
		return dataKeyId;
	}

	public String getKmsEndPoint() {
		return kmsEndPoint;
	}

	public String getSesSenderEmail() {
		return sesSenderEmail;
	}

	public String getDefaultEmailSubject() {
		return defaultEmailSubject;
	}

	public String getDefaultEmailContent() {
		return defaultEmailContent;
	}

	public String getConfirmEmailSubject() {
		return confirmEmailSubject;
	}

	public String getConfirmEmailContent() {
		return confirmEmailContent;
	}

	public String getCardInstruction() {
		return cardInstruction;
	}

	public String getLoadBalancerAddress() {
		return loadBalancerAddress;
	}

	public String getJasperTemplate() {
		return jasperTemplate;
	}
	
	public String getEnv()
	{
		return env;
	}
		
	public Region getAWSRegion()
	{
		return awsRegion;
	}
	
	public void readAWSRegionAndEnv() {
		String regionString = "us-east-1";
		env = "Local Dev";
		
		String userHome = System.getProperty( "user.home" );
		String regionFile = userHome + "/region";
		
		File rf = new File(regionFile);
		if(rf.exists()) {
			Properties pros = new Properties();
			try{
				pros.load(new FileInputStream(rf));
				regionString = pros.getProperty("region");
				env = pros.getProperty("env");
			} catch (IOException e){
				//Proceed with default values for env and region
				log.error(e);
			}
		}
        awsRegion = parseRegionString(regionString);
	}

	public Region parseRegionString(String region) {
		Region rg = Region.getRegion(Regions.US_EAST_1);
		if("us-west-1".equals(region)) {
			rg = Region.getRegion(Regions.US_WEST_1);
		}
		if("us-west-2".equals(region)) {
			rg = Region.getRegion(Regions.US_WEST_2);
		}
		return rg;
	}
	
}
