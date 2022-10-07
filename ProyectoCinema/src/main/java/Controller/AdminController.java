package Controller;

import Repository.Crud.AdminCrudRepository;
import Services.AdminService;
import model.Admin;
import org.hibernate.annotations.Cache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/Admin")
@CrossOrigin(origins = "*", methods = {
        RequestMethod.GET,
        RequestMethod.POST,
        RequestMethod.PUT,
        RequestMethod.DELETE }
        )
public class AdminController {
        @Autowired
        private AdminService adminService;

        @PostMapping(path = "/all")
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

}
