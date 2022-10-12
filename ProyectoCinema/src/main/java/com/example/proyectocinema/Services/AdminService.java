package com.example.proyectocinema.Services;

import com.example.proyectocinema.Repository.AdminRepository;
import com.example.proyectocinema.model.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public List<Admin> getAll(){
        return adminRepository.getAll();
    }

    public Optional<Admin> getAdmin(int id){
        return adminRepository.getAdmin(id);
    }

    public Admin save(Admin admin){
        if (admin.getIdAdmin()== null){
            return adminRepository.save(admin);
        }else{
            Optional<Admin> client1 = adminRepository.getAdmin(admin.getIdAdmin());
            if(client1.isEmpty()){
                return adminRepository.save(admin);
            }else{
                return admin;
            }
        }
    }

    public boolean deleteUserAdministrator(Integer id) {
        adminRepository.deleteUserAdministrator(id);
        return true;
    }

    public Admin updateUserAdministrator(Admin adminModel) {
        return adminRepository.updateUserAdministrator(adminModel);
    }

}
