package com.java.atm.atm_machine;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.java.atm.entity.Account;


public class AppTest extends AbstractTest{
	
	   @Override
	   @Before
	   public void setUp() {
	      super.setUp();
	   }
	   @Test
	   public void testWithdraw() throws Exception {
	      String uri = "atm/withdraw/96543/1000";
	      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)).andReturn();
	      
	      String content = mvcResult.getResponse().getContentAsString();
	      
	      assertEquals(content,"Success");
	   }
	   @Test
	   public void testBalance() throws Exception {
		   String uri = "atm/checkbalance/96543";
		    MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)).andReturn();
		      
		    String content = mvcResult.getResponse().getContentAsString();
		      
		      assertTrue(content!=null);
	   }
	   @Test
	   public void checkAddAccount() throws Exception {
		   String uri = "/atm/addaccount";
		      Account acc = new Account("TestUser",11111,555,234.0);
		      String inputJson = super.mapToJson(acc);
		      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
		         .contentType(MediaType.APPLICATION_JSON_VALUE)
		         .content(inputJson)).andReturn();
		      
		      String content = mvcResult.getResponse().getContentAsString();
		      Account acclist = super.mapFromJson(content, Account.class);
		      assertTrue(acclist!=null);
	   }
	   @Test
	   public void checkDeposit() throws Exception {
		   String uri = "atm/deposit/96543/2000";
		      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)).andReturn();
		      
		      String content = mvcResult.getResponse().getContentAsString();
		      
		      assertEquals(content,"Success");
	   }
	
}
