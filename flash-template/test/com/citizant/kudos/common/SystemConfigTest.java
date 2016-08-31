package com.citizant.kudos.common;

import org.dom4j.DocumentException;
import org.junit.Test;

import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;

import org.junit.Assert;

public class SystemConfigTest {
	
	@Test
	public void testSingleton()
	{
		Assert.assertEquals(SystemConfig.getInstance(),SystemConfig.getInstance());
	}

	@Test
	public void testLoadConfig() throws DocumentException
	{
		SystemConfig config = SystemConfig.getInstance();
		config.loadConfig("test-resources/system-config.xml");
		Assert.assertEquals("http://localhost:8090", config.getFidServiceURL());
		Assert.assertEquals("http://localhost:8099", config.getFaceServiceURL());
		Assert.assertEquals("dev-bucket-c58f0569", config.getAwsS3Bucket());
		Assert.assertEquals("arn:aws:kms:us-east-1:434141935580", config.getDataKeyId());
		Assert.assertEquals("https://kms.us-east-1.amazonaws.com", config.getKmsEndPoint());
		Assert.assertEquals("swang@citizant.com", config.getSesSenderEmail());
		Assert.assertEquals("reset", config.getDefaultEmailSubject());
		Assert.assertEquals("some content", config.getDefaultEmailContent());
		Assert.assertEquals("something changed", config.getConfirmEmailSubject());
		Assert.assertEquals("yada", config.getConfirmEmailContent());
		Assert.assertEquals("rtfm", config.getCardInstruction());
		Assert.assertEquals("fss-01", config.getServerId());
	}
	
	@Test
	public void testParseRegionString()
	{
		SystemConfig config = SystemConfig.getInstance();
	    Assert.assertEquals(Region.getRegion(Regions.US_EAST_1), config.parseRegionString(""));	
	    Assert.assertEquals(Region.getRegion(Regions.US_EAST_1), config.parseRegionString("us-east-1"));	
	    Assert.assertEquals(Region.getRegion(Regions.US_WEST_1), config.parseRegionString("us-west-1"));	
	    Assert.assertEquals(Region.getRegion(Regions.US_WEST_2), config.parseRegionString("us-west-2"));	
	}

}
