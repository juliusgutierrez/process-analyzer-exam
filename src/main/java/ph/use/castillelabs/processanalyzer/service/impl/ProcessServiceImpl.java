package ph.use.castillelabs.processanalyzer.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ph.use.castillelabs.processanalyzer.dto.ProcessLog;
import ph.use.castillelabs.processanalyzer.service.ProcessService;

/**
 * Created by julius on 26/10/2018.
 */
@Service
public class ProcessServiceImpl implements ProcessService {

  private static final Logger LOGGER = LoggerFactory.getLogger(ProcessServiceImpl.class);

  @Override
  public int findHighestConsumptionIn(byte[] rawLogs, int startTime, int endTime) {
    String logs = new String(rawLogs);
    LOGGER.info(logs);
    String[] rows = logs.split("\n");
    List<ProcessLog> processLogs = convertToProcess(rows);
    return determinedHighestConsumptions(processLogs, startTime, endTime);
  }

  /**
   * convert byte array to object
   * @param rows
   * @return
   */
  private List<ProcessLog> convertToProcess(String[] rows) {
    List<ProcessLog> processLogs = new ArrayList<>();
    for (String row : rows) {
      String[] rawLog = row.split("\t");
      ProcessLog process = new ProcessLog.Builder()
          .uid(Integer.parseInt(rawLog[0]))
          .pid(Integer.parseInt(rawLog[1]))
          .startTime(Integer.parseInt(rawLog[2]))
          .endTime(Integer.parseInt(rawLog[3]))
          .consumption(Integer.parseInt(rawLog[4]))
          .build();
      process.setUid(Integer.parseInt(rawLog[0]));
      process.setPid(Integer.parseInt(rawLog[1]));
      process.setStartTime(Integer.parseInt(rawLog[2]));
      process.setEndTime(Integer.parseInt(rawLog[3]));
      process.setConsumption(Integer.parseInt(rawLog[4]));
      processLogs.add(process);
    }
    return processLogs;
  }

  /**
   * 0(n)
   * determinedHighestConsumptions
   */
  private int determinedHighestConsumptions(List<ProcessLog> processLogs,
      int startTime, int endTime) {
    Map<Integer, Integer> holder = new HashMap<>();
    int highestConsumption = 0;
    int id = 0;

    for (ProcessLog processLog : processLogs) {
      if (processLog.getStartTime() >= startTime && processLog.getEndTime() <= endTime) {
        Integer consumption = holder.get(processLog.getUid());

        if (consumption == null) {
          consumption = 0;
        }

        int current = (consumption + processLog.getConsumption());
        holder.put(processLog.getUid(), current);

        if (current > highestConsumption) {
          highestConsumption = current;
          id = processLog.getUid();
        }
      }
    }

    LOGGER.info("id: [{}] highest consumption: [{}]", id, highestConsumption);
    return id;
  }


}
