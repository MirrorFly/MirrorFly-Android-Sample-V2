package com.contusfly;

import androidx.lifecycle.GeneratedAdapter;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MethodCallsLogger;
import java.lang.Override;

public class AppLifecycleListener_LifecycleAdapter implements GeneratedAdapter {
  final AppLifecycleListener mReceiver;

  AppLifecycleListener_LifecycleAdapter(AppLifecycleListener receiver) {
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
    if (event == Lifecycle.Event.ON_CREATE) {
      if (!hasLogger || logger.approveCall("appLifeCycleOnCreate", 1)) {
        mReceiver.appLifeCycleOnCreate();
      }
      return;
    }
    if (event == Lifecycle.Event.ON_START) {
      if (!hasLogger || logger.approveCall("onMoveToForeground", 1)) {
        mReceiver.onMoveToForeground();
      }
      return;
    }
    if (event == Lifecycle.Event.ON_RESUME) {
      if (!hasLogger || logger.approveCall("onResumeCallback", 1)) {
        mReceiver.onResumeCallback();
      }
      return;
    }
    if (event == Lifecycle.Event.ON_DESTROY) {
      if (!hasLogger || logger.approveCall("onAppDestroyed", 1)) {
        mReceiver.onAppDestroyed();
      }
      return;
    }
  }
}
