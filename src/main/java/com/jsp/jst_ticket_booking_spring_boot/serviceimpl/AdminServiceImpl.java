package com.jsp.jst_ticket_booking_spring_boot.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.jsp.jst_ticket_booking_spring_boot.Response.ResponseStructure;
import com.jsp.jst_ticket_booking_spring_boot.dao.AdminDao;
import com.jsp.jst_ticket_booking_spring_boot.daoimpl.AdminDaoImpl;
import com.jsp.jst_ticket_booking_spring_boot.dto.Admin;
import com.jsp.jst_ticket_booking_spring_boot.service.AdminService;

import jakarta.servlet.http.HttpSession;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminDao adminDao;
    
    @Autowired
    private AdminDaoImpl adminDaoImpl;
    
    @Autowired
    private ResponseStructure<Admin> responseStructure;
    
    @Autowired
    private HttpSession httpSession;
    
//    @Autowired
//    private ListResponseStructure<Admin> listResponseStructure;
    
    @Autowired
    private ResponseStructure<List<Admin>> responseStructure2;
    
    private Admin admin=null;

    @Override
    public Admin findByEmailService(String email) {
        return adminDao.findByEmailDao(email);
    }

	@Override
	public ResponseStructure<Admin> loginAdminWithEmailAndPasswordService(String email, String password) {
		admin=adminDao.findByEmailDao(email);
		
		if(admin!=null) {
			
			if(admin.getPassword().equals(password)) {
				
				httpSession.setAttribute("adminSession", email);
				
				httpSession.setMaxInactiveInterval(300);
				
				//admin1=admin;
				
				responseStructure.setStatusCode(HttpStatus.CONTINUE.value());
				responseStructure.setMessage("Login Success go ahead");
				admin.setPassword("**********");
				responseStructure.setData(admin);
				return responseStructure;
				
			}else {
				responseStructure.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
				responseStructure.setMessage("Login Fail incorrect Password");
				admin.setPassword("**********");
				responseStructure.setData(admin);
				return responseStructure;
			}
			
		}else {
			responseStructure.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
			responseStructure.setMessage("Login Fail incorrect Email");
			responseStructure.setData(null);
			return responseStructure;
		}
	}

	@Override
	public ResponseStructure<Admin> LogOutAdminService() {
		if(httpSession.getAttribute("adminSession")!=null) {
			httpSession.getAttribute("adminSession");
			httpSession.invalidate();
			System.out.println(httpSession.getLastAccessedTime());
			
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("LogOut Fail Successfully");
			
			if(admin!=null) {
				admin.setPassword("*************");
				admin.setId(000);
			}
			
			return responseStructure;
		}else {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Login First");
			return responseStructure;
		}
	}

	@Override
	public ResponseStructure<List<Admin>> displayAllAdminService() {
		if(httpSession.getAttribute("adminSession")!=null) {
			System.out.println("If Block");
			List<Admin> admins=adminDaoImpl.displayAllAdminDaoImpl();
			
			responseStructure2.setStatusCode(HttpStatus.OK.value());
			responseStructure2.setMessage("All Admin Data");
			responseStructure2.setData(admins);
			//return listResponseStructure;
			return responseStructure2;
		}else {
			System.out.println("Else Block");
			responseStructure2.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
			responseStructure2.setMessage("Not Loged in");
			responseStructure2.setData(null);
			return responseStructure2;
			//return null;
		}
	}
//	@Override
//	public ListResponseStructure<Admin> displayAllAdminService(HttpSession session) {
//		if(httpSession.getAttribute("adminSession")!=null) {
//			System.out.println("If Block");
//			List<Admin> admins=adminDaoImpl.displayAllAdminDaoImpl();
//			
//			listResponseStructure.setStatusCode(HttpStatus.OK.value());
//			listResponseStructure.setMessage("All Admin Data");
//			listResponseStructure.setData(admins);
//			//return listResponseStructure;
//			return listResponseStructure;
//		}else {
//			System.out.println("Else Block");
//			listResponseStructure.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
//			listResponseStructure.setMessage("Not Loged in");
//			listResponseStructure.setData(null);
//			return listResponseStructure;
//			//return null;
//		}
//	}
}
