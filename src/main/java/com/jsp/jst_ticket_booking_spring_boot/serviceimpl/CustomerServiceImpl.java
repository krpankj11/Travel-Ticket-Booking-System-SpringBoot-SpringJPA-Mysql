package com.jsp.jst_ticket_booking_spring_boot.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.jsp.jst_ticket_booking_spring_boot.Response.ResponseStructure;
import com.jsp.jst_ticket_booking_spring_boot.dao.CustomerDao;
import com.jsp.jst_ticket_booking_spring_boot.dto.Customer;
import com.jsp.jst_ticket_booking_spring_boot.service.CustomerService;

import jakarta.servlet.http.HttpSession;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerDao customerDao;
	
	@Autowired
	private ResponseStructure<Customer> responseStructure;
	
	@Autowired
	private HttpSession httpSession;
	
	@Override
	public ResponseStructure<Customer> saveCustomerService(Customer customer) {
	
		Customer customer1=customerDao.saveCustomerDao(customer);
		
		if(customer1!=null) {
			responseStructure.setStatusCode(HttpStatus.CREATED.value());
			responseStructure.setMessage("Customer Registered");
			customer1.setPassword("*******");
			responseStructure.setData(customer1);
			return responseStructure;
		}else {
			responseStructure.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
			responseStructure.setMessage("Customer Not Registered");
			responseStructure.setData(null);
			return responseStructure;
		}
		
	}
	
	@Override
    public ResponseStructure<Customer> loginCustomerWithEmailAndPasswordService(String email, String password) {
       Customer customer = customerDao.findCustomerByEmailDao(email);
        if(customer!=null){

            if(customer.getPassword().equals(password)){
            	
                httpSession.setAttribute("customerSession",email);
                httpSession.setMaxInactiveInterval(300);
                responseStructure.setStatusCode(HttpStatus.CONTINUE.value());
                responseStructure.setMessage("login success go ahead");
                customer.setPassword("*******************");
                responseStructure.setData(customer);

                return  responseStructure;
            }else{
                responseStructure.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
                responseStructure.setMessage("login faild...because password is wrong");
                customer.setPassword("*******************");
                responseStructure.setData(customer);
                return  responseStructure;
            }

        }else {

            responseStructure.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
            responseStructure.setMessage("login faild...because email is wrong");
            responseStructure.setData(customer);
            return responseStructure;
        }
    }


}
