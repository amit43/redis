package sharechat.service;

import sharechat.dto.Rank;

import java.util.List;

/**
 * Created by amit_k on 4/1/19.
 */
public interface StudentService {

    Rank getStudentRank(String studentId);

    List<Rank> getLeaderboard(Integer offset, Integer limit);
}
