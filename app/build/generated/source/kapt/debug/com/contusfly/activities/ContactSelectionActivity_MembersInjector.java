// Generated by Dagger (https://dagger.dev).
package com.contusfly.activities;

import com.contusfly.chat.MessagingClient;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;

@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class ContactSelectionActivity_MembersInjector implements MembersInjector<ContactSelectionActivity> {
  private final Provider<MessagingClient> messagingClientProvider;

  public ContactSelectionActivity_MembersInjector(
      Provider<MessagingClient> messagingClientProvider) {
    this.messagingClientProvider = messagingClientProvider;
  }

  public static MembersInjector<ContactSelectionActivity> create(
      Provider<MessagingClient> messagingClientProvider) {
    return new ContactSelectionActivity_MembersInjector(messagingClientProvider);
  }

  @Override
  public void injectMembers(ContactSelectionActivity instance) {
    injectMessagingClient(instance, messagingClientProvider.get());
  }

  @InjectedFieldSignature("com.contusfly.activities.ContactSelectionActivity.messagingClient")
  public static void injectMessagingClient(ContactSelectionActivity instance,
      MessagingClient messagingClient) {
    instance.messagingClient = messagingClient;
  }
}
