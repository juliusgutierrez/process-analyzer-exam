package ph.use.castillelabs.processanalyzer.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by julius on 26/10/2018.
 */
public class Response {

  private String message;

  @JsonProperty("highest_consumption_id")
  private int highestConsumptionId;

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public int getHighestConsumptionId() {
    return highestConsumptionId;
  }

  public void setHighestConsumptionId(int highestConsumptionId) {
    this.highestConsumptionId = highestConsumptionId;
  }

}
