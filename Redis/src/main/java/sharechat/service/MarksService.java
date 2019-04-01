package sharechat.service;

import sharechat.dto.MarksDetails;

/**
 * Created by amit_k on 4/1/19.
 */
public interface MarksService {

    MarksDetails createOrUpdate(MarksDetails marksDetails);
}
