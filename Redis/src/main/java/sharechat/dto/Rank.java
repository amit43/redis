package sharechat.dto;

/**
 * Created by amit_k on 4/1/19.
 */
public class Rank {

    String studentId;

    Long rank;

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public Long getRank() {
        return rank;
    }

    public void setRank(Long rank) {
        this.rank = rank;
    }

    public Rank(String studentId, Long rank) {
        this.studentId = studentId;
        this.rank = rank;
    }

    public Rank() {
        this.studentId = null;
        this.rank = Long.valueOf(-1L);
    }
}
