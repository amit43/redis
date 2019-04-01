package sharechat.resources;

import com.google.inject.Inject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.eclipse.jetty.http.HttpStatus;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Tuple;
import sharechat.dto.Rank;
import sharechat.service.StudentService;
import sharechat.util.RedisTables;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by amit_k on 4/1/19.
 */
@Api(value = "StudentResource", description = "Provides Student Details")
@Path("v0.1/student/")
public class StudentResource {

    StudentService studentService;

    @Inject
    public StudentResource(StudentService studentService)
    {
        this.studentService = studentService;
    }


    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiResponses(value = {
            @ApiResponse(code = HttpStatus.OK_200, message = "Get Rank for student",
                    response = Rank.class)
    })
    @Path("{student_id}/")
    public Response getRank(@PathParam("student_id") String studentId) {

        return Response.status(Response.Status.OK)
                .entity(studentService.getStudentRank(studentId)).build();
    }



    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiResponses(value = {
            @ApiResponse(code = HttpStatus.OK_200, message = "Get Leaderboard",
                    response = Rank.class, responseContainer = "List")
    })
    @Path("leaderboard/")
    public Response getLeaderboard(@QueryParam("offset") Integer offset,
                                   @QueryParam("limit") Integer limit) {


        return Response.status(Response.Status.OK)
                .entity(studentService.getLeaderboard(offset, limit))
                .build();
    }
}
