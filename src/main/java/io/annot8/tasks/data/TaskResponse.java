package io.annot8.tasks.data;

public class TaskResponse {

  public enum Status {
    OK, TASK_ERROR
  }

  private final Status status;

  private TaskResponse(final Status status) {
    this.status = status;
  }

  public static TaskResponse ok() {
    return new TaskResponse(Status.OK);
  }

  public static TaskResponse itemError() {
    return new TaskResponse(Status.TASK_ERROR);
  }

  public Status getStatus() {
    return status;
  }
}
