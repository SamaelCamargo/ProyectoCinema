package com.example.proyectocinema.Controller;

import com.example.proyectocinema.Services.AdminService;
import com.example.proyectocinema.model.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/Admin")
@CrossOrigin(origins = "*", methods = {
        RequestMethod.GET,
        RequestMethod.POST,
        RequestMethod.PUT,
        RequestMethod.DELETE
})
public class AdminController {
        @Autowired
        private AdminService adminService;

        @GetMapping(path = "/all")
        @PostMapping("/all")
        public List<Admin> getAll(){
                return adminService.getAll();
        }


        @GetMapping("/{id}")
        public Optional<Admin> getAdmin(@PathVariable("id") int id){
                return adminService.getAdmin(id);
        }

        @PostMapping("/save")
        @ResponseStatus(HttpStatus.CREATED)
        public Admin save(@RequestBody Admin admin){
                return adminService.save(admin);
        }

        @DeleteMapping("/{id}")
        @ResponseStatus(HttpStatus.NO_CONTENT)
        public boolean deleteUserAdministratorModel(@PathVariable Integer id) {
                adminService.deleteUserAdministrator(id);
                return true;
        }

        @PutMapping("/update")
        @ResponseStatus(HttpStatus.CREATED)
        public Admin updateUserAdministrator(@RequestBody Admin adminModel) {
                return adminService.updateUserAdministrator(adminModel);
        }

}
