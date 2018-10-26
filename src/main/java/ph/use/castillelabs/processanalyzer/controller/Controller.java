package ph.use.castillelabs.processanalyzer.controller;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import ph.use.castillelabs.processanalyzer.dto.Response;
import ph.use.castillelabs.processanalyzer.service.ProcessService;

/**
 * Created by julius on 24/10/2018.
 */
@RestController
public class Controller {

  @Autowired
  private ProcessService processService;


  @RequestMapping(
      method = {RequestMethod.GET, RequestMethod.POST},
      value = "/process"
  )
  public ResponseEntity processTSVLog(@RequestParam("file") MultipartFile file,
      @RequestParam("start") int start, @RequestParam("end") int end) {
    Response response = new Response();
    if (file != null && !file.isEmpty()) {
      try {
        int results = processService.findHighestConsumptionIn(file.getBytes(), start, end);
        response.setHighestConsumptionId(results);
        response.setMessage("Success");
        return ResponseEntity.ok(response);
      } catch (IOException e) {
        response.setMessage(e.getMessage());
      }
    }
    return ResponseEntity.ok(response);
  }

}
