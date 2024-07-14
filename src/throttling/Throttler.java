/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package throttling;

import annotations.Injectable;

/**
 *
 * @author manel
 */
@Injectable
public class Throttler {

    private long timeUnderThrottling;
    private int threshold;
    private long lastThrottleTime;
    private long counter;

    private final Object lock;

    public Throttler() {
        lock = new Object();
    }

    public void configure(long timeUnderThrottling, int threshold) {
        this.timeUnderThrottling = timeUnderThrottling;
        this.threshold = threshold;
    }

    public boolean throttle() {
        synchronized (lock) {
            long now = System.currentTimeMillis();

            if (now - lastThrottleTime > timeUnderThrottling) {
                counter = 0;
                lastThrottleTime = now;
            }
            if (counter < threshold) {
                counter++;
                return true;
            } else {
                return false;
            }
        }
    }
}
