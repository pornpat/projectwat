package camt.se331.watduangdee.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by TEN10 on 5/17/2015.
 */

@Entity
public class Qanda {
    @Id
    @GeneratedValue
    Long id;
    String question;
    String answer;


    public Qanda() {

    }

    public Qanda(Long id, String question, String answer) {
        this.id = id;
        this.question = question;
        this.answer = answer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

}
