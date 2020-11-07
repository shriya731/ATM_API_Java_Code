package com.java.atm.atm_machine;




import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java.atm.entity.Account;
import com.java.atm.service.AtmService;

@Controller
@RequestMapping("/atm")
public class AtmController {
	
	 @Autowired
	    private AtmService atmService;

	    

	    @RequestMapping("/withdraw/{accountnumber}/{amount}")
	    public @ResponseBody String withdraw( @PathVariable(value = "accountnumber") long accountNumber, @PathVariable(value = "amount") int amount) {
	        try {
	            
	                if (atmService.withdraw(accountNumber, amount)) {
	                    return "Success";
	                } else {
	                    return "Error occured while updating your account";
	                }
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	            return "Error occured while updating your account";
	        }
	    }

	    @RequestMapping("/checkbalance/{accountnumber}")
	    public @ResponseBody double checkBalance( @PathVariable(value = "accountnumber") long accountNumber) {
	        try {
	            
	                return atmService.checkBalance(accountNumber);
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	            return 0.0;
	        }
	    }
	    
	    @RequestMapping("/addaccount")
		public Account addAccount(@RequestBody Account account) {
			
			
	    	account.setId(0);
			
	    	atmService.save(account);
			
			return account;
		}

	    @RequestMapping("/deposit/{accountnumber}/{amount}")
	    public @ResponseBody String deposit(@PathVariable(value = "accountnumber") long accountNumber, @PathVariable(value = "amount") int amount) {
	        try {
	            
	                if (atmService.deposit(accountNumber, amount)) {
	                    return "Success";
	                } else {
	                    return "Error occured while updating your account";
	                }
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	            return "Error occured while updating your account";
	        }
	    }

}
