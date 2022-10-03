package repository;


import model.Score;
import repository.crud.ScoreCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ScoreRepository {
    @Autowired
    private ScoreCrudRepository scoreCrudRepository;


    public List<Score> getAll(){
        return (List<Score>) scoreCrudRepository.findAll();
    }

    public Optional<Score> getScore(int id){
        return scoreCrudRepository.findById(id);
    }

    public Score save (Score score){
        return scoreCrudRepository.save(score);
    }

    public void delete (Score score){
        scoreCrudRepository.delete(score);
    }

}
