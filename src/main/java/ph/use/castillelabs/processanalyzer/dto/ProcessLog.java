package ph.use.castillelabs.processanalyzer.dto;

/**
 * Created by julius on 26/10/2018.
 */
public class ProcessLog {

  private int uid;
  private int pid;
  private int startTime;
  private int endTime;
  private int consumption;

  /**
   * no arg
   */
  public ProcessLog() {}

  public ProcessLog(Builder builder) {
    this.uid = builder.uid;
    this.pid = builder.pid;
    this.startTime = builder.startTime;
    this.endTime = builder.endTime;
    this.consumption = builder.consumption;
  }

  public int getUid() {
    return uid;
  }

  public void setUid(int uid) {
    this.uid = uid;
  }

  public int getPid() {
    return pid;
  }

  public void setPid(int pid) {
    this.pid = pid;
  }

  public int getStartTime() {
    return startTime;
  }

  public void setStartTime(int startTime) {
    this.startTime = startTime;
  }

  public int getEndTime() {
    return endTime;
  }

  public void setEndTime(int endTime) {
    this.endTime = endTime;
  }

  public int getConsumption() {
    return consumption;
  }

  public void setConsumption(int consumption) {
    this.consumption = consumption;
  }

  public static class Builder {

    private int uid;
    private int pid;
    private int startTime;
    private int endTime;
    private int consumption;

    public Builder uid(int uid) {
      this.uid = uid;
      return this;
    }

    public Builder pid(int pid) {
      this.pid = pid;
      return this;
    }

    public Builder startTime(int startTime) {
      this.startTime = startTime;
      return this;
    }

    public Builder endTime(int endTime) {
      this.endTime = endTime;
      return this;
    }

    public Builder consumption(int consumption) {
      this.consumption = consumption;
      return this;
    }

    public ProcessLog build() {
      return new ProcessLog(this);
    }
  }
}
