package sharechat.dto;

/**
 * Created by amit_k on 4/1/19.
 */
public class Rank {

    String studentId;

    Double marks;

    Long rank;

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public Double getMarks() {
        return marks;
    }

    public void setMarks(Double marks) {
        this.marks = marks;
    }

    public Long getRank() {
        return rank;
    }

    public void setRank(Long rank) {
        this.rank = rank;
    }


    public Rank(String studentId, Double marks, Long rank) {
        this.studentId = studentId;
        this.marks = marks;
        this.rank = rank;
    }

    public Rank() {
        this.studentId = null;
        this.marks = -1.0;
        this.rank = -1L;
    }
}
