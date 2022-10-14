package com.example.proyectocinema.Services;
import com.example.proyectocinema.Repository.CinemaRepository;
import com.example.proyectocinema.model.Cinema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service

public class CinemaService {
    @Autowired
    private CinemaRepository cinemaRepository;

    public List<Cinema> getAll() {
        return cinemaRepository.getAll();
    }

    public Optional<Cinema> getCinema(int id) {
        return cinemaRepository.getCinema(id);
    }
    public Cinema save(Cinema cinema) {
        if (cinema.getId() == null) {
            return cinemaRepository.save(cinema);
        } else {
            Optional<Cinema> cinema1 = cinemaRepository.getCinema(cinema.getId());
            if (cinema1.isEmpty()) {
                return cinemaRepository.save(cinema);
            } else {
                return cinema;
            }
        }
    }
    public Cinema update(Cinema cinema){
        if (cinema.getId()!=null){
            Optional<Cinema> cinema1=cinemaRepository.getCinema(cinema.getId());
            if (!cinema1.isEmpty()){
                if (cinema.getName()!=null){
                    cinema1.get().setName(cinema.getName());
                }
                if (cinema.getOwner()!=null){
                    cinema1.get().setOwner(cinema.getOwner());
                }
                if (cinema.getCapacity()!=null){
                    cinema1.get().setCapacity(cinema.getCapacity());
                }
                if (cinema.getDescription()!=null){
                    cinema1.get().setDescription(cinema.getDescription());
                }
                if (cinema.getCategory()!=null){
                    cinema1.get().setCategory(cinema.getCategory());
                }
                cinemaRepository.save(cinema1.get());
                return cinema1.get();
            }else {
                return cinema;
            }
        }else {
            return cinema;
        }
    }
            public boolean deleteCinema(int id){
          Boolean d = getCinema(id).map(cinema -> {
              cinemaRepository.delete(cinema);
              return true;
          }).orElse(false);
          return d;
    }
}
