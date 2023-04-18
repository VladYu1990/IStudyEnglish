package ru.project.IStudyEnglish.infrastructure.DAO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name="TaskForRepetition")
public class RepetitionExerciseDAO {

    @Id
    @Column(name = "id")
    private int id;
    @Id
    @Column(name = "id_word")
    private int id_word;
    @Id
    @Column(name = "timeLastRepetition")
    private Date timeLastRepetition;
    @Id
    @Column(name = "timeNextRepetition")
    private Date timeNextRepetition;

    public RepetitionExerciseDAO() {

        this.id = id;
        this.id_word = id_word;
        this.timeLastRepetition = timeLastRepetition;
        this.timeNextRepetition = timeNextRepetition;
    }
}
