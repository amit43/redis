package sharechat.service.impl;

import com.google.inject.Inject;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import sharechat.dto.MarksDetails;
import sharechat.service.MarksService;
import sharechat.util.RedisTables;

/**
 * Created by amit_k on 4/1/19.
 */
public class MarksServiceImpl implements MarksService{

    private final JedisPool jedisPool;

    @Inject
    public MarksServiceImpl(JedisPool jedisPool)
    {
        this.jedisPool = jedisPool;
    }


    @Override
    public MarksDetails createOrUpdate(MarksDetails marksDetails) {

        Jedis jedis = jedisPool.getResource();
        jedis.zadd(RedisTables.STUDENT_MARKS, marksDetails.getScore(), marksDetails.getStudentId());

        return marksDetails;
    }
}
