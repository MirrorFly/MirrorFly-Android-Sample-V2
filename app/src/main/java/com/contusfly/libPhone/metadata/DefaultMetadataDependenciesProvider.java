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

package com.contusfly.libPhone.metadata;

import com.contusfly.libPhone.MetadataLoader;
import com.contusfly.libPhone.metadata.init.ClassPathResourceMetadataLoader;
import com.contusfly.libPhone.metadata.init.MetadataParser;
import com.contusfly.libPhone.metadata.source.FormattingMetadataSource;
import com.contusfly.libPhone.metadata.source.FormattingMetadataSourceImpl;
import com.contusfly.libPhone.metadata.source.MetadataSource;
import com.contusfly.libPhone.metadata.source.MetadataSourceImpl;
import com.contusfly.libPhone.metadata.source.MultiFileModeFileNameProvider;
import com.contusfly.libPhone.metadata.source.PhoneMetadataFileNameProvider;
import com.contusfly.libPhone.metadata.source.RegionMetadataSource;
import com.contusfly.libPhone.metadata.source.RegionMetadataSourceImpl;

/**
 * Provides metadata init and source dependencies when metadata is stored in multi-file mode and
 * loaded as a classpath resource.
 */
public final class DefaultMetadataDependenciesProvider {

  private static final DefaultMetadataDependenciesProvider INSTANCE = new DefaultMetadataDependenciesProvider();

  public static DefaultMetadataDependenciesProvider getInstance() {
    return INSTANCE;
  }

  public DefaultMetadataDependenciesProvider() {
    this(new ClassPathResourceMetadataLoader());
  }

  public DefaultMetadataDependenciesProvider(MetadataLoader metadataLoader) {
    if (metadataLoader == null) {
      throw new IllegalArgumentException("metadataLoader could not be null.");
    }
    this.metadataLoader = metadataLoader;
    this.phoneNumberMetadataSource =
        new MetadataSourceImpl(
            phoneNumberMetadataFileNameProvider,
            metadataLoader,
            metadataParser);
    this.shortNumberMetadataSource =
        new RegionMetadataSourceImpl(
            shortNumberMetadataFileNameProvider,
            metadataLoader,
            metadataParser);
    this.alternateFormatsMetadataSource =
        new FormattingMetadataSourceImpl(
            alternateFormatsMetadataFileNameProvider,
            metadataLoader,
            metadataParser);
  }

  private final MetadataParser metadataParser = MetadataParser.newLenientParser();
  private final MetadataLoader metadataLoader;

  private final PhoneMetadataFileNameProvider phoneNumberMetadataFileNameProvider =
      new MultiFileModeFileNameProvider(
          "/com/contusfly/libPhone/data/PhoneNumberMetadataProto");
  private final MetadataSource phoneNumberMetadataSource;

  private final PhoneMetadataFileNameProvider shortNumberMetadataFileNameProvider =
      new MultiFileModeFileNameProvider(
          "/com/contusfly/libPhone/data/ShortNumberMetadataProto");
  private final RegionMetadataSource shortNumberMetadataSource;

  private final PhoneMetadataFileNameProvider alternateFormatsMetadataFileNameProvider =
      new MultiFileModeFileNameProvider(
          "/com/contusfly/libPhone/data/PhoneNumberAlternateFormatsProto");
  private final FormattingMetadataSource alternateFormatsMetadataSource;

  public MetadataParser getMetadataParser() {
    return metadataParser;
  }

  public MetadataLoader getMetadataLoader() {
    return metadataLoader;
  }

  public PhoneMetadataFileNameProvider getPhoneNumberMetadataFileNameProvider() {
    return phoneNumberMetadataFileNameProvider;
  }

  public MetadataSource getPhoneNumberMetadataSource() {
    return phoneNumberMetadataSource;
  }

  public PhoneMetadataFileNameProvider getShortNumberMetadataFileNameProvider() {
    return shortNumberMetadataFileNameProvider;
  }

  public RegionMetadataSource getShortNumberMetadataSource() {
    return shortNumberMetadataSource;
  }

  public PhoneMetadataFileNameProvider getAlternateFormatsMetadataFileNameProvider() {
    return alternateFormatsMetadataFileNameProvider;
  }

  public FormattingMetadataSource getAlternateFormatsMetadataSource() {
    return alternateFormatsMetadataSource;
  }

  public String getCarrierDataDirectory() {
    return "/com/contusfly/libPhone/carrier/data/";
  }

  public String getGeocodingDataDirectory() {
    return "/com/contusfly/libPhone/geocoding/data/";
  }
}
