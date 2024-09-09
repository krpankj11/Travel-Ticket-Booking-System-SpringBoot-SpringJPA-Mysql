package com.jsp.jst_ticket_booking_spring_boot.service;

import java.util.List;

import com.jsp.jst_ticket_booking_spring_boot.Response.ListResponseStructure;
import com.jsp.jst_ticket_booking_spring_boot.Response.ResponseStructure;
import com.jsp.jst_ticket_booking_spring_boot.dto.Admin;

import jakarta.servlet.http.HttpSession;

public interface AdminService {
    Admin findByEmailService(String email);
    
    ResponseStructure<Admin> loginAdminWithEmailAndPasswordService(String email, String password);
    
    ResponseStructure<Admin> LogOutAdminService();
    
    ResponseStructure<List<Admin>> displayAllAdminService();
    
    //ResponseStructure<List<Admin>> displayAllAdminService(HttpSession session);
}
