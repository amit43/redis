package sharechat.dto;

/**
 * Created by amit_k on 4/1/19.
 */
public class MarksDetails {

    private String studentId;

    private Integer score;


    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public MarksDetails(String studentId, Integer score) {
        this.studentId = studentId;
        this.score = score;
    }

    public MarksDetails() {
        this.studentId = null;
        this.score = 0;
    }
}
