package com.company.view;

import java.util.Date;
import java.time.LocalTime;
import java.util.Date;
public class player {
        private String name;
        private int Wins;
        private int loss;
        private Date date;

        public player(){
            this.name = "";
            this.Wins = 0 ;
            this.loss = 0 ;
            this.date = new Date();
        }


        public player(String name,int wins, int loss, Date date){
            this.name = name;
            this.Wins = Wins;
            this.loss = loss;
            this.date = date;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getWins() {
            return Wins;
        }

        public void setWins(int wins) {
            Wins = wins;
        }

        public int getLoss() {
            return loss;
        }

        public void setLoss(int loss) {
            this.loss = loss;
        }

        public Date getDate() {
            return date;
        }

        public void setDate(Date date) {
            this.date = date;
        }
    }
