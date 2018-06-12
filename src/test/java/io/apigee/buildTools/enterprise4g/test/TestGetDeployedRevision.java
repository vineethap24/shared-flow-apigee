/**
 * Copyright (C) 2014 Apigee Corporation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.apigee.buildTools.enterprise4g.test;

import io.apigee.buildTools.enterprise4g.rest.RestUtil;
import io.apigee.buildTools.enterprise4g.utils.ServerProfile;
import junit.framework.TestCase;

import java.io.IOException;

public class TestGetDeployedRevision extends TestCase {
	
	ServerProfile profile = new ServerProfile();
	
	protected void setUp() throws Exception {
		super.setUp();

        profile.setHostUrl("https://api.enterprise.apigee.com");
        profile.setApplication("taskservice");
        profile.setCredential_user(System.getProperty("username"));
        profile.setCredential_pwd(System.getProperty("password"));
        profile.setEnvironment(System.getProperty("env"));
        profile.setOrg(System.getProperty("org"));
        profile.setApi_version("v1");
        profile.setTokenUrl("https://login.apigee.com/oauth/token");
        //profile.setProfileId("PUT-UR-PROFILE");


    }
	
	
	
	public void testGetRevisionCall() throws IOException{
		try {
			String revision = RestUtil.getDeployedRevision(profile);
			assertNotNull(revision);
			System.out.println("deployed revision:: "+ revision);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 
	}

}