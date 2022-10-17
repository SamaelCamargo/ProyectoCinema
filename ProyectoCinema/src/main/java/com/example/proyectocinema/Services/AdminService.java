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

    public List<Admin> getAll() {
        return adminRepository.getAll();
    }

    public Optional<Admin> getAdmin(int id) {
        return adminRepository.getAdmin(id);
    }

    public Admin save(Admin admin) {
        if (admin.getIdAdmin() == null) {
            return adminRepository.save(admin);
        } else {
            Optional<Admin> client1 = adminRepository.getAdmin(admin.getIdAdmin());
            if (client1.isEmpty()) {
                return adminRepository.save(admin);
            } else {
                return admin;
            }
        }
    }

    public boolean deleteUserAdministrator(Integer id) {
        Boolean d = getAdmin(id).map(client -> {
            adminRepository.delete(client);
            return true;
        }).orElse(false);
        return d;

    }

    public Admin updateUserAdministrator(Admin adminModel) {
        if (adminModel.getIdAdmin() != null) {
            Optional<Admin> admin = adminRepository.getAdmin(adminModel.getIdAdmin());
            if (!admin.isEmpty()) {
                if (adminModel.getName() != null) {
                    admin.get().setName(adminModel.getName());
                }
                if (adminModel.getEmail() != null) {
                    admin.get().setEmail(adminModel.getEmail());
                }
                if (adminModel.getPassword() != null) {
                    admin.get().setPassword(adminModel.getPassword());
                }
                adminRepository.save(admin.get());
                return admin.get();
            } else {
                return adminModel;
            }
        } else {
            return adminModel;
        }
    }

}
