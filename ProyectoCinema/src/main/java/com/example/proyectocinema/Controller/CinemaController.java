package com.example.proyectocinema.Controller;
import com.example.proyectocinema.Services.CinemaService;
import com.example.proyectocinema.model.Cinema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Cinema")
@CrossOrigin(origins = "*", methods = {
        RequestMethod.GET,
        RequestMethod.POST,
        RequestMethod.PUT,
        RequestMethod.DELETE
})
public class CinemaController {
    @Autowired

    private CinemaService cinemaService;

    @GetMapping("/all")
    @PostMapping("/all")
        public List<Cinema> getAll(){
        return  cinemaService.getAll();
    }

    @PostMapping("/all")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Cinema> getAllUserAdmin() {
        return cinemaService.getAll();
    }


    @GetMapping("{id}")
    public Optional<Cinema> getCinema(@PathVariable("id")int id){
        return cinemaService.getCinema(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Cinema save(@RequestBody Cinema cinema){
        return cinemaService.save(cinema);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int clientId){
        return cinemaService.deleteCinema(clientId);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Cinema updateCinema(@RequestBody Cinema cinemaModel) {
        return cinemaService.update(cinemaModel);
    }
}
