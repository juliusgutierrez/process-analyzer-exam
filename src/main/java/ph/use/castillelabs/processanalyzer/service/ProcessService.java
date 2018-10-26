package ph.use.castillelabs.processanalyzer.service;

/**
 * Created by julius on 26/10/2018.
 */
public interface ProcessService {

  int findHighestConsumptionIn(byte[] rawLogs, int startTime, int endTime);

}
