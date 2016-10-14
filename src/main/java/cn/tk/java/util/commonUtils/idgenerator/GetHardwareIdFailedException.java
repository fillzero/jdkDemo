package cn.tk.java.util.commonUtils.idgenerator;

public class GetHardwareIdFailedException extends Exception {
    /**
	 * 
	 */
	private static final long serialVersionUID = 7879305437549000894L;

	GetHardwareIdFailedException(String reason) {
        super(reason);
    }

    GetHardwareIdFailedException(Exception e) {
        super(e);
    }
}