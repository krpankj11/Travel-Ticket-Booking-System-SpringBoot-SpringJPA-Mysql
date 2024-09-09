package com.jsp.jst_ticket_booking_spring_boot.admincontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.jst_ticket_booking_spring_boot.Response.ResponseStructure;
import com.jsp.jst_ticket_booking_spring_boot.dto.Admin;
import com.jsp.jst_ticket_booking_spring_boot.service.AdminService;

import jakarta.servlet.http.HttpSession;

@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
@RestController
@RequestMapping(value = "/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(value = "/fetchAdminByEmail/{email}")
    public Admin findByEmailController(@PathVariable String email) {
        return adminService.findByEmailService(email);
    }
    
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(value = "/loginAdminWithEmailAndPassword/{email}/{password}")
    public ResponseStructure<Admin> loginAdminWithEmailAndPasswordController(@PathVariable String email,@PathVariable String password) {
		return adminService.loginAdminWithEmailAndPasswordService(email, password);
	}

    @CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
    @GetMapping(value = "/LogoutAdmin")
    public ResponseStructure<Admin> LogoutAdminController() {
		return adminService.LogOutAdminService();
	}
    
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(value = "/displayAllAdmin")
    public ResponseStructure<List<Admin>> displayAllAdminController() {
		return adminService.displayAllAdminService();
	}
    
//    @CrossOrigin(origins = "http://localhost:3000")
//    @GetMapping(value = "/displayAllAdmin")
//    public ResponseStructure<List<Admin>> displayAllAdminController(HttpSession session) {
//		return adminService.displayAllAdminService(session);
//	}
//    
//    @CrossOrigin(origins = "http://localhost:3000")
//    @GetMapping(value = "/displayAllAdmin")
//    public List<Admin> displayAllAdminController() {
//		return adminService.displayAllAdminService();
//	}
    
}
