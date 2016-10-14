package cn.tk.java.util.commonUtils.idgenerator;

public interface EntityIdGenerator {
    public long generateLongId() throws InvalidSystemClockException, GetHardwareIdFailedException;

    public String generateLongIdString() throws InvalidSystemClockException, GetHardwareIdFailedException;
}