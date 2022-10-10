package Controller;


import Services.CinemaService;
import model.Cinema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Cinema")

public class CinemaController {
    @Autowired

    private CinemaService cinemaService;

    @GetMapping("/All")
        public List<Cinema> getAll(){
        return  cinemaService.getAll();
    }

    @GetMapping("{Id}")
    public Optional<Cinema> getCinema(@PathVariable("Id")int id){
        return cinemaService.getCinema(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Cinema save(RequestBody Cinema cinema){
        return cinemaService.save(cinema)
    }
}
