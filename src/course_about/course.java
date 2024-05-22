package course_about;

public class course {
    private String cno;
    private String cname;
    private String ctime;
    private String cscore;

    public course(String cno, String cname, String ctime, String cscore) {
        this.cno = cno;
        this.cname = cname;
        this.ctime = ctime;
        this.cscore = cscore;
    }

    public String getCname() {
        return cname;
    }

    public String getCtime() {
        return ctime;
    }

    public String getCscore() {
        return cscore;
    }

    public String getCno() {
        return cno;
    }
}
