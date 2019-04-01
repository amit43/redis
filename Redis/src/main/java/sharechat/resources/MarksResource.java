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
import sharechat.service.MarksService;
import sharechat.util.JsonUtil;
import sharechat.util.RedisTables;

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

    private final MarksService marksService;

    @Inject
    public MarksResource(MarksService marksService)
    {
        this.marksService = marksService;
    }


    // TODO AMIT: Implement Access Control
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiResponses(value = {
            @ApiResponse(code = HttpStatus.OK_200, message = "Updated Marks Details",
                    response = MarksDetails.class)
    })
    public Response updateMarks(@ApiParam("marks_details") MarksDetails marksDetails) {


        return Response.status(Response.Status.OK)
                .entity(marksService.createOrUpdate(marksDetails)).build();
    }
}
