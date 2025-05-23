package com.example.crud_api;

public class PlayerItem {

    String no;
    String name;
    String birth_date;
    String Position;
    String International;
    String Team;
    String Poster;

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(String birth_date) {
        this.birth_date = birth_date;
    }

    public String getPosition() {
        return Position;
    }

    public void setPosition(String position) {
        Position = position;
    }

    public String getInternational() {
        return International;
    }

    public void setInternational(String international) {
        International = international;
    }

    public String getTeam() {
        return Team;
    }

    public void setTeam(String team) {
        Team = team;
    }

    public String getPoster() {
        return Poster;
    }

    public void setPoster(String poster) {
        Poster = poster;
    }
}
