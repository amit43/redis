package sharechat.service.impl;

import com.google.inject.Inject;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import sharechat.dto.Rank;
import sharechat.service.StudentService;
import sharechat.util.RedisTables;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by amit_k on 4/1/19.
 */
public class StudentServiceImpl implements StudentService {

    private final JedisPool jedisPool;

    @Inject
    public StudentServiceImpl(JedisPool jedisPool)
    {
        this.jedisPool = jedisPool;
    }


    @Override
    public Rank getStudentRank(String studentId) {

        Jedis jedis = jedisPool.getResource();

        return new Rank(studentId,
                jedis.zscore(RedisTables.STUDENT_MARKS, studentId),
                jedis.zrevrank(RedisTables.STUDENT_MARKS, studentId));
    }


    @Override
    public List<Rank> getLeaderboard(Integer offset, Integer limit) {

        Jedis jedis = jedisPool.getResource();

        List<Rank> leaderboard = new ArrayList<>();
        AtomicInteger counter = new AtomicInteger(offset);

        jedis.zrevrangeWithScores(RedisTables.STUDENT_MARKS, offset, offset + limit - 1)
                .forEach(student -> {
                    leaderboard.add(
                            new Rank(student.getElement(),
                                    student.getScore(),
                                    new Integer(counter.getAndIncrement()).longValue()));

                });

        return leaderboard;
    }
}
