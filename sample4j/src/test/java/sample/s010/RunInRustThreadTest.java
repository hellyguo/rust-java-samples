package sample.s010;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sample.common.TestHelper;

/**
 * @author Helly Guo
 * <p>
 * Created on 7/24/24 8:38 PM
 */
public class RunInRustThreadTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(RunInRustThreadTest.class);

    @Test
    public void test() {
        RunInRustThread.callAsync("a msg from Java");
        TestHelper.trySleep(2000);
        while (true) {
            boolean success = RunInRustThread.stopExecute();
            if (success) {
                LOGGER.info("success to set active to false");
                break;
            } else {
                LOGGER.warn("fail to set active to false");
                TestHelper.trySleep(1000);
            }
        }
    }

}
