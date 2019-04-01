package sharechat.resources;

import com.google.inject.Inject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.eclipse.jetty.http.HttpStatus;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import sharechat.dto.MarksDetails;
import sharechat.util.JsonUtil;

import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by amit_k on 4/1/19.
 */
@Api(value = "MarksResource", description = "Update and Fetch Marks of Students")
@Path("v0.1/marks")
@Produces(MediaType.APPLICATION_JSON)
public class MarksResource {

    private final JedisPool jedisPool;

    @Inject
    public MarksResource(JedisPool jedisPool)
    {
        this.jedisPool = jedisPool;
    }


    // TODO AMIT: Implement Access Control
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiResponses(value = {
            @ApiResponse(code = HttpStatus.OK_200, message = "Updated Marks Details",
                    response = MarksDetails.class),
            @ApiResponse(code = HttpStatus.FORBIDDEN_403, message = "You are not authorised to access this  data")
    })
    public Response updateMarks(@ApiParam("marks_details") MarksDetails marksDetails) {

        Jedis jedis = jedisPool.getResource();

        jedis.zadd("rankings", marksDetails.getScore(), marksDetails.getStudentId());

        return Response.status(Response.Status.OK)
                .entity(marksDetails).build();
    }
}
