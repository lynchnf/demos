package norman.demo.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

public class DemoBean {
    private static final Logger LOGGER = LoggerFactory.getLogger(DemoBean.class);
    private static final Random RANDOM = new Random();
    private static final int SLEEP_FAST_HIGH = 900;
    private static final int SLEEP_FAST_LOW = 0;
    private static final int SLEEP_SLOW_HIGH = 2000;
    private static final int SLEEP_SLOW_LOW = 1100;
    private static final String LATENCY_MESSAGE_FORMAT_LESS = "Latency of %,d milliseconds is less than 1 second.";
    private static final String LATENCY_MESSAGE_FORMAT_MORE = "Latency of %,d milliseconds is more than 1 second.";
    private int status;
    private String latencyMessage;
    private boolean pathParameter;
    private String parameterValue;

    // Constructor is private to force the demo apps to get a bean from a factory method.
    private DemoBean(int status, String latencyMessage, boolean pathParameter, String parameterValue) {
        this.status = status;
        this.latencyMessage = latencyMessage;
        this.pathParameter = pathParameter;
        this.parameterValue = parameterValue;
    }

    public static DemoBean sleepAndGe(DemoBeanType type, String parameterValue) {
        // Fast or slow? Flip a coin.
        long sleepMillis = 0L;
        int coin = RANDOM.nextInt(2);
        if (coin == 0) {
            sleepMillis = RANDOM.nextInt(SLEEP_FAST_HIGH - SLEEP_FAST_LOW) + SLEEP_FAST_LOW;
        } else {
            sleepMillis = RANDOM.nextInt(SLEEP_SLOW_HIGH - SLEEP_SLOW_LOW) + SLEEP_SLOW_LOW;
        }
        // Succeed or fail? Flip a coin again.
        coin = RANDOM.nextInt(2);
        int status = 200;
        if (coin == 0) {
            status = 500;
        }
        // Sleep
        long startTimeMillis = System.currentTimeMillis();
        LOGGER.debug("Sleeping for " + sleepMillis + " milliseconds.");
        try {
            Thread.sleep(sleepMillis);
        } catch (InterruptedException e) {
            LOGGER.warn("Sleep interrupted.", e);
        }
        // Build latency message based on how long we actually slept.
        long latency = System.currentTimeMillis() - sleepMillis;
        String latencyMessage;
        if (latency <= 1000L) {
            latencyMessage = String.format(LATENCY_MESSAGE_FORMAT_LESS, latency);
        } else {
            latencyMessage = String.format(LATENCY_MESSAGE_FORMAT_MORE, latency);
        }
        // If we hae a path parameter, put it in the bean.
        DemoBean bean;
        if (type == DemoBeanType.PARM) {
            bean = new DemoBean(status, latencyMessage, true, parameterValue);
        } else {
            bean = new DemoBean(status, latencyMessage, false, null);
        }
        return bean;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getLatencyMessage() {
        return latencyMessage;
    }

    public void setLatencyMessage(String latencyMessage) {
        this.latencyMessage = latencyMessage;
    }

    public boolean isPathParameter() {
        return pathParameter;
    }

    public void setPathParameter(boolean pathParameter) {
        this.pathParameter = pathParameter;
    }

    public String getParameterValue() {
        return parameterValue;
    }

    public void setParameterValue(String parameterValue) {
        this.parameterValue = parameterValue;
    }

    @Override
    public String toString() {
        // @formatter:off
        return "DemoBean{" +
                "status=" + status +
                ", latencyMessage='" + latencyMessage + '\'' +
                (pathParameter ? ", parameterValue='" + parameterValue + '\'' : "") + '\'' +
                '}';
        // @formatter:on
    }
}
