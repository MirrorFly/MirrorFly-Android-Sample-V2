// Generated by Dagger (https://dagger.dev).
package com.contusfly.activities.parent;

import com.contusfly.chat.MessagingClient;
import com.contusfly.di.factory.AppViewModelFactory;
import com.contusfly.utils.ChatViewUtils;
import com.contusfly.utils.SharedPreferenceManager;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;

@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class ChatParent_MembersInjector implements MembersInjector<ChatParent> {
  private final Provider<AppViewModelFactory> chatViewModelFactoryProvider;

  private final Provider<ChatViewUtils> chatViewUtilsProvider;

  private final Provider<SharedPreferenceManager> sharedPreferenceManagerProvider;

  private final Provider<MessagingClient> messagingClientProvider;

  private final Provider<AppViewModelFactory> viewModelFactoryProvider;

  public ChatParent_MembersInjector(Provider<AppViewModelFactory> chatViewModelFactoryProvider,
      Provider<ChatViewUtils> chatViewUtilsProvider,
      Provider<SharedPreferenceManager> sharedPreferenceManagerProvider,
      Provider<MessagingClient> messagingClientProvider,
      Provider<AppViewModelFactory> viewModelFactoryProvider) {
    this.chatViewModelFactoryProvider = chatViewModelFactoryProvider;
    this.chatViewUtilsProvider = chatViewUtilsProvider;
    this.sharedPreferenceManagerProvider = sharedPreferenceManagerProvider;
    this.messagingClientProvider = messagingClientProvider;
    this.viewModelFactoryProvider = viewModelFactoryProvider;
  }

  public static MembersInjector<ChatParent> create(
      Provider<AppViewModelFactory> chatViewModelFactoryProvider,
      Provider<ChatViewUtils> chatViewUtilsProvider,
      Provider<SharedPreferenceManager> sharedPreferenceManagerProvider,
      Provider<MessagingClient> messagingClientProvider,
      Provider<AppViewModelFactory> viewModelFactoryProvider) {
    return new ChatParent_MembersInjector(chatViewModelFactoryProvider, chatViewUtilsProvider, sharedPreferenceManagerProvider, messagingClientProvider, viewModelFactoryProvider);
  }

  @Override
  public void injectMembers(ChatParent instance) {
    injectChatViewModelFactory(instance, chatViewModelFactoryProvider.get());
    injectChatViewUtils(instance, chatViewUtilsProvider.get());
    injectSharedPreferenceManager(instance, sharedPreferenceManagerProvider.get());
    injectMessagingClient(instance, messagingClientProvider.get());
    injectViewModelFactory(instance, viewModelFactoryProvider.get());
  }

  @InjectedFieldSignature("com.contusfly.activities.parent.ChatParent.chatViewModelFactory")
  public static void injectChatViewModelFactory(ChatParent instance,
      AppViewModelFactory chatViewModelFactory) {
    instance.chatViewModelFactory = chatViewModelFactory;
  }

  @InjectedFieldSignature("com.contusfly.activities.parent.ChatParent.chatViewUtils")
  public static void injectChatViewUtils(ChatParent instance, ChatViewUtils chatViewUtils) {
    instance.chatViewUtils = chatViewUtils;
  }

  @InjectedFieldSignature("com.contusfly.activities.parent.ChatParent.sharedPreferenceManager")
  public static void injectSharedPreferenceManager(ChatParent instance,
      SharedPreferenceManager sharedPreferenceManager) {
    instance.sharedPreferenceManager = sharedPreferenceManager;
  }

  @InjectedFieldSignature("com.contusfly.activities.parent.ChatParent.messagingClient")
  public static void injectMessagingClient(ChatParent instance, MessagingClient messagingClient) {
    instance.messagingClient = messagingClient;
  }

  @InjectedFieldSignature("com.contusfly.activities.parent.ChatParent.viewModelFactory")
  public static void injectViewModelFactory(ChatParent instance,
      AppViewModelFactory viewModelFactory) {
    instance.viewModelFactory = viewModelFactory;
  }
}
