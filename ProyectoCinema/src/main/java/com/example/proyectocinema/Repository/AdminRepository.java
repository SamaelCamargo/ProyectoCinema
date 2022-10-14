package com.example.proyectocinema.Repository;

import com.example.proyectocinema.Repository.Crud.AdminCrudRepository;
import com.example.proyectocinema.model.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AdminRepository {
    @Autowired
    private AdminCrudRepository adminCrudRepository;


    public List<Admin> getAll(){
        return (List<Admin>) adminCrudRepository.findAll();
    }

    public Optional<Admin> getAdmin(int id){
        return adminCrudRepository.findById(id);
    }

    public Admin save (Admin admin){
        return adminCrudRepository.save(admin);
    }

    public void delete (Admin admin){
        adminCrudRepository.delete(admin);
    }

    public boolean deleteUserAdministrator(Integer id) {
        try {
            adminCrudRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }

    }

    public Admin updateUserAdministrator(Admin adminModel) {
        if (adminModel.getIdAdmin() != null) {
            Optional<Admin> admin = adminCrudRepository.findById(adminModel.getIdAdmin());
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
                adminCrudRepository.save(admin.get());
                return admin.get();
            } else {
                return adminModel;
            }
        } else {
            return adminModel;
        }
    }
}
