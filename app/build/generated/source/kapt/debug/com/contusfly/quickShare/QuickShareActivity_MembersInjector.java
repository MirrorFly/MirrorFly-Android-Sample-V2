// Generated by Dagger (https://dagger.dev).
package com.contusfly.quickShare;

import com.contusfly.chat.ShareMessagesController;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;

@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class QuickShareActivity_MembersInjector implements MembersInjector<QuickShareActivity> {
  private final Provider<ShareMessagesController> shareMessagesControllerProvider;

  public QuickShareActivity_MembersInjector(
      Provider<ShareMessagesController> shareMessagesControllerProvider) {
    this.shareMessagesControllerProvider = shareMessagesControllerProvider;
  }

  public static MembersInjector<QuickShareActivity> create(
      Provider<ShareMessagesController> shareMessagesControllerProvider) {
    return new QuickShareActivity_MembersInjector(shareMessagesControllerProvider);
  }

  @Override
  public void injectMembers(QuickShareActivity instance) {
    injectShareMessagesController(instance, shareMessagesControllerProvider.get());
  }

  @InjectedFieldSignature("com.contusfly.quickShare.QuickShareActivity.shareMessagesController")
  public static void injectShareMessagesController(QuickShareActivity instance,
      ShareMessagesController shareMessagesController) {
    instance.shareMessagesController = shareMessagesController;
  }
}
