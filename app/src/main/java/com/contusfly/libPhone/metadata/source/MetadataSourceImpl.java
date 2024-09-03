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

import com.contusfly.libPhone.MetadataLoader;
import com.contusfly.libPhone.Phonemetadata.PhoneMetadata;
import com.contusfly.libPhone.internal.GeoEntityUtility;
import com.contusfly.libPhone.metadata.init.MetadataParser;

/**
 * Implementation of {@link MetadataSource} guarded by {@link MetadataBootstrappingGuard}.
 *
 * <p>By default, a {@link BlockingMetadataBootstrappingGuard} will be used, but any custom
 * implementation can be injected.
 */
public final class MetadataSourceImpl implements MetadataSource {

  private final PhoneMetadataFileNameProvider phoneMetadataFileNameProvider;
  private final MetadataBootstrappingGuard<CompositeMetadataContainer> bootstrappingGuard;

  public MetadataSourceImpl(
      PhoneMetadataFileNameProvider phoneMetadataFileNameProvider,
      MetadataBootstrappingGuard<CompositeMetadataContainer> bootstrappingGuard) {
    this.phoneMetadataFileNameProvider = phoneMetadataFileNameProvider;
    this.bootstrappingGuard = bootstrappingGuard;
  }

  public MetadataSourceImpl(
      PhoneMetadataFileNameProvider phoneMetadataFileNameProvider,
      MetadataLoader metadataLoader,
      MetadataParser metadataParser) {
    this(
        phoneMetadataFileNameProvider,
        new BlockingMetadataBootstrappingGuard<>(
            metadataLoader, metadataParser, new CompositeMetadataContainer()));
  }

  @Override
  public PhoneMetadata getMetadataForNonGeographicalRegion(int countryCallingCode) {
    if (GeoEntityUtility.isGeoEntity(countryCallingCode)) {
      throw new IllegalArgumentException(
          countryCallingCode + " calling code belongs to a geo entity");
    }
    return bootstrappingGuard
        .getOrBootstrap(phoneMetadataFileNameProvider.getFor(countryCallingCode))
        .getMetadataBy(countryCallingCode);
  }

  @Override
  public PhoneMetadata getMetadataForRegion(String regionCode) {
    if (!GeoEntityUtility.isGeoEntity(regionCode)) {
      throw new IllegalArgumentException(regionCode + " region code is a non-geo entity");
    }
    return bootstrappingGuard
        .getOrBootstrap(phoneMetadataFileNameProvider.getFor(regionCode))
        .getMetadataBy(regionCode);
  }
}
