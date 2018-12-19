import android.support.test.runner.AndroidJUnit4;

import com.udacity.gradle.builditbigger.EndpointsAsyncTask;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertNotNull;

/**
 * Created by Calin Tesu on 12/19/2018.
 */

@RunWith(AndroidJUnit4.class)
public class NightmareJokeTesting {

    @Test
    public void testNightmareJokeAsyncTask() throws Throwable {

        final CountDownLatch signal = new CountDownLatch(1);

        EndpointsAsyncTask endpointsAsyncTask = new EndpointsAsyncTask(new EndpointsAsyncTask.ResponseReceived() {
            @Override
            public void onResponseReceived(String response) {
                assertNotNull(response);
                signal.countDown();
            }
        });

        endpointsAsyncTask.execute();

        signal.await(30, TimeUnit.SECONDS);
    }
}
