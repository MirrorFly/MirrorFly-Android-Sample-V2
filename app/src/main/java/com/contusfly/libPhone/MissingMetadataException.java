package com.contusfly.libPhone;

/** Exception class for cases when expected metadata cannot be found. */
public final class MissingMetadataException extends IllegalStateException {

  public MissingMetadataException(String message) {
    super(message);
  }
}
