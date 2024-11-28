package com.contusfly;

import androidx.lifecycle.GeneratedAdapter;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MethodCallsLogger;
import java.lang.Override;

public class EmailContactSyncService_LifecycleAdapter implements GeneratedAdapter {
  final EmailContactSyncService mReceiver;

  EmailContactSyncService_LifecycleAdapter(EmailContactSyncService receiver) {
    this.mReceiver = receiver;
  }

  @Override
  public void callMethods(LifecycleOwner owner, Lifecycle.Event event, boolean onAny,
      MethodCallsLogger logger) {
    boolean hasLogger = logger != null;
    if (onAny) {
      return;
    }
    if (event == Lifecycle.Event.ON_STOP) {
      if (!hasLogger || logger.approveCall("onMoveToBackground", 1)) {
        mReceiver.onMoveToBackground();
      }
      return;
    }
    if (event == Lifecycle.Event.ON_START) {
      if (!hasLogger || logger.approveCall("onMoveToForeground", 1)) {
        mReceiver.onMoveToForeground();
      }
      return;
    }
  }
}
