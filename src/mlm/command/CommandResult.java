package mlm.command;

/**
 * Return object for Command execution statuses.
 */
public class CommandResult {

	//TODO additional Statuses (eg cancelled)
	//TODO additional returns (eg message, error, data)
	
	public enum Status {
		SUCCESS,
		FAILURE,
		SHUTDOWN
	}
	
	private final Status status;
	
	/**
	 * Datatype for returning Command execution result
	 * @param status Command execution result
	 */
	public CommandResult(Status status) {
		this.status = status;
	}
	
	public Status getStatus() {
		return status;
	}
	
	public boolean shouldShutdown() {
		return status == Status.SHUTDOWN;
	}
	
	/**
	 * Shortcut to return successful execution.
	 * @return Status.SUCCESS
	 */
	public static CommandResult success() {
		return new CommandResult(Status.SUCCESS);
	}
	
	/**
	 * Shortcut to return failed execution.
	 * @return Status.FAILURE
	 */
	public static CommandResult failure() {
		return new CommandResult(Status.FAILURE);
	}
	
	/**
	 * Shortcut to confirm application exit execution.
	 * @return Status.SHUTDOWN
	 */
	public static CommandResult shutdown() {
		return new CommandResult(Status.SHUTDOWN);
	}
}