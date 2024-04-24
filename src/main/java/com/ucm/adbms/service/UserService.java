package com.ucm.adbms.service;

import com.ucm.adbms.entity.Admin;
import com.ucm.adbms.entity.Customer;
import com.ucm.adbms.entity.Vendor;
import com.ucm.adbms.repository.AdminRepository;
import com.ucm.adbms.repository.CustomerRepository;
import com.ucm.adbms.repository.VendorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

    private final AdminRepository adminRepository;
    private final CustomerRepository customerRepository;
    private final VendorRepository vendorRepository;


    /**
     * Type of User
     * @param username - username
     * @return username
     */
    public Object identifyUser(String username){

        Admin admin = adminRepository.findByEmail(username) ;

        if(admin != null)
            return  admin ;

        Vendor vendor = vendorRepository.findByEmail(username) ;

        if(vendor != null)
            return vendor ;

        Customer customer = customerRepository.findByEmail(username) ;

        if(customer != null)
            return  customer ;

        return "unknown" ;
    }


}
