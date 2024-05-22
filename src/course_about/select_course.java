package course_about;

public class select_course {
    private String sno;
    private String cno;
    private String score;

    public select_course(String sno, String cno, String score) {
        this.sno = sno;
        this.cno = cno;
        this.score = score;
    }

    public String getSno() {
        return sno;
    }

    public String getCno(){
        return cno;
    }

    public String getScore() {
        return score;
    }
}

