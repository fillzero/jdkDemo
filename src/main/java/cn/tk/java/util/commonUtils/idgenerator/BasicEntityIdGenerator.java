package cn.tk.java.util.commonUtils.idgenerator;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;


public class BasicEntityIdGenerator implements EntityIdGenerator {

    // id format =>
    // timestamp |datacenter | sequence
    // 41 |10 | 12
    private final long sequenceBits     = 12;
    private final long datacenterIdBits = 10L;
    private final long maxDatacenterId  = -1L ^ (-1L << datacenterIdBits);

    private final long datacenterIdShift  = sequenceBits;
    private final long timestampLeftShift = sequenceBits + datacenterIdBits;

    private final long twepoch     = 1288834974657L;
    private final long datacenterId;
    private final long sequenceMax = 4096;

    private volatile long lastTimestamp = -1L;
    private volatile long sequence      = 0L;

    private static BasicEntityIdGenerator basicEntityIdGenerator;

    public static BasicEntityIdGenerator getInstance() throws GetHardwareIdFailedException {
        if (basicEntityIdGenerator == null)
        {
        	synchronized (BasicEntityIdGenerator.class)
        	{
        		if (basicEntityIdGenerator == null)
        		{
        			basicEntityIdGenerator = new BasicEntityIdGenerator();
        		}
        	}
        }
        return basicEntityIdGenerator;
    }
    private BasicEntityIdGenerator() throws GetHardwareIdFailedException {
        datacenterId = getDatacenterId();
        if (datacenterId > maxDatacenterId || datacenterId < 0) {
            throw new GetHardwareIdFailedException("datacenterId > maxDatacenterId");
        }
    }

    @Override
    public synchronized long generateLongId() throws InvalidSystemClockException {
        long timestamp = System.currentTimeMillis();
        if (timestamp < lastTimestamp) {
            throw new InvalidSystemClockException("Clock moved backwards.  Refusing to generate id for "
                    + (lastTimestamp - timestamp) + " milliseconds.");
        }
        if (lastTimestamp == timestamp) {
            sequence = (sequence + 1) % sequenceMax;
            if (sequence == 0) {
                timestamp = tilNextMillis(lastTimestamp);
            }
        }
        else {
            sequence = 0;
        }
        lastTimestamp = timestamp;
        long id = ((timestamp - twepoch) << timestampLeftShift) | (datacenterId << datacenterIdShift) | sequence;
        return id;
    }

    public String generateLongIdString() throws InvalidSystemClockException, GetHardwareIdFailedException {
        long id=generateLongId();
        return Long.toString(id);
    }

    protected long tilNextMillis(long lastTimestamp) {
        long timestamp = System.currentTimeMillis();
        while (timestamp <= lastTimestamp) {
            timestamp = System.currentTimeMillis();
        }
        return timestamp;
    }

    protected long getDatacenterId() throws GetHardwareIdFailedException {

        try {
            InetAddress ip = InetAddress.getLocalHost();
            NetworkInterface network = NetworkInterface.getByInetAddress(ip);
            long id;
            if (network == null) {
                id = 1;
            }
            else {
                byte[] mac = network.getHardwareAddress();
                id = ((0x000000FF & (long) mac[mac.length - 1])
                        | (0x0000FF00 & (((long) mac[mac.length - 2]) << 8))) >> 6;
            }
            return id;
        }
        catch (SocketException e) {
            throw new GetHardwareIdFailedException(e);
        }
        catch (UnknownHostException e) {
            throw new GetHardwareIdFailedException(e);
        }
    }
}
