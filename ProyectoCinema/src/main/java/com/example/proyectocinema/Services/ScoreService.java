package com.example.proyectocinema.Services;

import com.example.proyectocinema.Repository.ScoreRepository;

import com.example.proyectocinema.model.Score;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScoreService {
    @Autowired
    private ScoreRepository scoreRepository;

    public List<Score> getAll() {
        return scoreRepository.getAll();
    }

    public Optional<Score> getScore(int id) {
        return scoreRepository.getScore(id);
    }

    public Score save(Score score) {
        if (score.getIdScore() == null) {
            return scoreRepository.save(score);
        } else {
            java.util.Optional<Score> score1 = scoreRepository.getScore(score.getIdScore());
            if (score1.isEmpty()) {
                return scoreRepository.save(score);
            } else {
                return score;
            }
        }
    }

    //RETO 4
    public Score update(Score score) {
        if (score.getIdScore() != null) {
            Optional<Score> score1 = scoreRepository.getScore(score.getIdScore());
            if (!score1.isEmpty()) {

                if (score.getMessageText() != null) {
                    score1.get().setMessageText(score.getMessageText());
                }
                if (score.getStarts() != null) {
                    score1.get().setStarts(score.getStarts());
                }
                if (score.getReservation() != null) {
                    score1.get().setReservation(score.getReservation());
                }
                scoreRepository.save(score1.get());
                return score1.get();
            } else {
                return score;
            }
        } else {
            return score;
        }
    }

    public boolean deleteScore(int id) {
        Boolean delete = getScore(id).map(score -> {
            scoreRepository.delete(score);
            return true;
        }).orElse(false);
        return delete;

    }
}