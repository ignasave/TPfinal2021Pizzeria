package Ignacio.guia1.Enunciado5;
/*      Enunciado5 hora = new Enunciado5(23,59,59);
        hora.printHourFormated();
        hora.advance1Second();
        hora.printHourFormated();
        hora.rewind1Second();
        hora.printHourFormated();*/
public class Enunciado5 {
    private int hour;
    private int minute;
    private int second;

    public Enunciado5(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public Enunciado5() {
    }

    public void printHourFormated () {
        String hourFormated = this.hour < 10 ? '0' + String.valueOf(this.hour) : String.valueOf(this.hour);
        String minuteFormated = this.minute < 10 ? '0' + String.valueOf(this.minute) : String.valueOf(this.minute);
        String secondFormated = this.second < 10 ? '0' + String.valueOf(this.second) : String.valueOf(this.second);
        System.out.println(hourFormated + ':' + minuteFormated + ':' + secondFormated);
    }

    public Enunciado5 advance1Second () {
        if(this.second == 59) {
            if(this.minute == 59){
                if(this.hour == 23){
                    this.hour = 0;
                } else {
                    this.hour++;
                }
                this.minute = 0;
            } else {
                this.minute++;
            }
            this.second = 0;
        } else {
            this.second++;
        }
        return this;
    }

    public Enunciado5 rewind1Second () {
        if(this.second == 0) {
            if(this.minute == 0){
                if(this.hour == 0){
                    this.hour = 23;
                } else {
                    this.hour--;
                }
                this.minute = 59;
            } else {
                this.minute--;
            }
            this.second = 59;
        } else {
            this.second--;
        }
        return this;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour > 0 ? hour < 23 ? hour : 23 : 0;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute > 0 ? minute < 59 ? minute : 59 : 0;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second > 0 ? second < 59 ? second : 59 : 0;
    }
}
