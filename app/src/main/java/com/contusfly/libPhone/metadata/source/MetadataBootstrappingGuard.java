/*
 * Copyright (C) 2022 The Libphonenumber Authors
 * Copyright (C) 2022 Michael Rozumyanskiy
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.contusfly.libPhone.metadata.source;

/**
 * Guard that ensures that metadata bootstrapping process (loading and parsing) is triggered only
 * once per metadata file.
 *
 * @param <T> needs to extend {@link MetadataContainer}
 */
public interface MetadataBootstrappingGuard<T extends MetadataContainer> {

  /**
   * If metadata from the provided file has not yet been read, invokes loading and parsing from the
   * provided file and adds the result to guarded {@link MetadataContainer}.
   *
   * @param phoneMetadataFile to read from
   * @return guarded {@link MetadataContainer}
   */
  T getOrBootstrap(String phoneMetadataFile);
}
