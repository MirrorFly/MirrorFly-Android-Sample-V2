// Generated by Dagger (https://dagger.dev).
package com.contusfly.di.modules;

import com.contusfly.repository.MessageRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class RepoModule_ProvideMessageRepositoryFactory implements Factory<MessageRepository> {
  private final RepoModule module;

  public RepoModule_ProvideMessageRepositoryFactory(RepoModule module) {
    this.module = module;
  }

  @Override
  public MessageRepository get() {
    return provideMessageRepository(module);
  }

  public static RepoModule_ProvideMessageRepositoryFactory create(RepoModule module) {
    return new RepoModule_ProvideMessageRepositoryFactory(module);
  }

  public static MessageRepository provideMessageRepository(RepoModule instance) {
    return Preconditions.checkNotNullFromProvides(instance.provideMessageRepository());
  }
}