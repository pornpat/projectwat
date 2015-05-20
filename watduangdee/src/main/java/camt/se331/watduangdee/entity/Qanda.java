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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Qanda qanda = (Qanda) o;

        if (answer != null ? !answer.equals(qanda.answer) : qanda.answer != null) return false;
        if (id != null ? !id.equals(qanda.id) : qanda.id != null) return false;
        if (question != null ? !question.equals(qanda.question) : qanda.question != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (question != null ? question.hashCode() : 0);
        result = 31 * result + (answer != null ? answer.hashCode() : 0);
        return result;
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
