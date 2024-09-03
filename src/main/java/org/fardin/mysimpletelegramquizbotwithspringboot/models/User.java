package org.fardin.mysimpletelegramquizbotwithspringboot.models;

import jakarta.persistence.*;
import org.fardin.mysimpletelegramquizbotwithspringboot.states.UserState;

import java.util.Objects;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    Long userid;
    String name;
    String username;
    @Transient
    UserState userState;
    @Transient
    QuizInformation quizInformation;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getName() {
        return name;
    }

    public UserState getUserState() {
        return userState;
    }

    public void setUserState(UserState userState) {
        this.userState = userState;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && Objects.equals(userid, user.userid) && Objects.equals(name, user.name) && Objects.equals(username, user.username);
    }

    public QuizInformation getQuizInformation() {
        return quizInformation;
    }

    public void setQuizInformation(QuizInformation quizInformation) {
        this.quizInformation = quizInformation;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userid, name, username);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userid=" + userid +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
