package za.co.eoh.andile.cic.exception;
import java.util.Date;

public class ExceptionResponse {
  private Date timestamp;
  private int errorCode;
  private String message;
  private String details;

  public ExceptionResponse(Date timestamp, int errorCode, String message, String details) {
	super();
	this.timestamp = timestamp;
	this.errorCode = errorCode;
	this.message = message;
	this.details = details;
  }

	 public Date getTimestamp() {
		 return timestamp;
	 }

	 public String getMessage() {
		 return message;
	 }

	 public String getDetails() {
		 return details;
	 }

	public int getErrorCode() {
		return errorCode;
	}
	
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

}