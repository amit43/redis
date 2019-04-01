package sharechat.resources;

import com.google.inject.Inject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.eclipse.jetty.http.HttpStatus;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import sharechat.dto.Rank;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by amit_k on 4/1/19.
 */
@Api(value = "StudentResource", description = "Provides Student Details")
@Path("v0.1/student/")
public class StudentResource {

    private final JedisPool jedisPool;

    @Inject
    public StudentResource(JedisPool jedisPool)
    {
        this.jedisPool = jedisPool;
    }


    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiResponses(value = {
            @ApiResponse(code = HttpStatus.OK_200, message = "Get Rank for student",
                    response = Rank.class),
            @ApiResponse(code = HttpStatus.FORBIDDEN_403, message = "You are not authorised to access this  data")
    })
    @Path("{student_id}/")
    public Response getRank(@PathParam("student_id") String studentId) {

        Jedis jedis = jedisPool.getResource();

        // Rank Object
        Rank rank = new Rank(studentId, jedis.zrevrank("rankings", studentId));
        return Response.status(Response.Status.OK)
                .entity(rank).build();
    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiResponses(value = {
            @ApiResponse(code = HttpStatus.OK_200, message = "Get Leaderboard",
                    response = Rank.class, responseContainer = "List"),
            @ApiResponse(code = HttpStatus.FORBIDDEN_403, message = "You are not authorised to access this  data")
    })
    @Path("leaderboard/")
    public Response getLeaderboard(@QueryParam("offset") Integer offset,
                                   @QueryParam("limit") Integer limit) {

        Jedis jedis = jedisPool.getResource();


        //List of Rank Object
        // TODO AMIT: Fetch Leaderboard
        List<Rank> leaderboard = new ArrayList<Rank>();
        return Response.status(Response.Status.OK)
                .entity(leaderboard).build();
    }
}
