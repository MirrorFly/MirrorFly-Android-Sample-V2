package com.contusfly.network;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.mirrorflysdk.api.FlyCore;
import com.mirrorflysdk.flycommons.FlyCallback;
import com.mirrorflysdk.flycommons.FlyUtils;
import com.mirrorflysdk.flycommons.LogMessage;
import org.jetbrains.annotations.NotNull;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import okhttp3.Authenticator;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;

public class UikitTokenAuthenticator implements Authenticator {
    private static final String TAG = UikitTokenAuthenticator.class.getSimpleName();
    private static final int RETRY_LIMIT = 3;

    @Override
    public Request authenticate(Route route, @NotNull Response response) throws IOException {
        int retryCount = responseCount(response);
        if (retryCount >= RETRY_LIMIT) {
            LogMessage.i(TAG, "Retry count exceeded! Giving up.");
            return null; // If we've failed 3 times, give up.
        } else {
            LogMessage.d(TAG, "Retrying count: " + retryCount);
        }

            LogMessage.i(TAG, "Refreshing Auth token...");
        if (refreshToken()) {
            LogMessage.i(TAG, "Proceeding the request with new Auth token...");
            //get the new token from storage
            String newAccessToken = FlyUtils.decodedToken().trim();
            //update the request
            return response.request().newBuilder()
                    .header("Authorization", newAccessToken)
                    .build();
        } else {
            LogMessage.e(TAG, "Refreshing Auth token Failed...");
            return response.request();
        }
    }

    private int responseCount(Response response) {
        int result = 1;
        while ((response = response.priorResponse()) != null) {
            result++;
        }
        return result;
    }

    /**
     * Refreshes token and stores it to the local storage
     *
     * @return true, if token refresh successful
     * @throws IOException exception will be thrown if {@link IOException} occurs
     */
    private boolean refreshToken() throws IOException {
        final CountDownLatch latch = new CountDownLatch(1);
        final AtomicBoolean result = new AtomicBoolean(false);
        FlyCore.refreshAndGetAuthToken(new FlyCallback() {
            @Override
            public void flyResponse(boolean isSuccess, @Nullable Throwable throwable, @NonNull HashMap<String, Object> data) {
                result.set(isSuccess);
                latch.countDown();
            }
        });

        try {
            latch.await();  // Wait for the callback to complete
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new IOException("Interrupted while waiting for token refresh", e);
        }

        return result.get();
    }

}
