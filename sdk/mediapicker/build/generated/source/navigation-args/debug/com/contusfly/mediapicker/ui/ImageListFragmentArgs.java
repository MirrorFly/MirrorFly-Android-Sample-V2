package com.contusfly.mediapicker.ui;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.navigation.NavArgs;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class ImageListFragmentArgs implements NavArgs {
  private final HashMap arguments = new HashMap();

  private ImageListFragmentArgs() {
  }

  @SuppressWarnings("unchecked")
  private ImageListFragmentArgs(HashMap argumentsMap) {
    this.arguments.putAll(argumentsMap);
  }

  @NonNull
  @SuppressWarnings("unchecked")
  public static ImageListFragmentArgs fromBundle(@NonNull Bundle bundle) {
    ImageListFragmentArgs __result = new ImageListFragmentArgs();
    bundle.setClassLoader(ImageListFragmentArgs.class.getClassLoader());
    if (bundle.containsKey("folder_name")) {
      String folderName;
      folderName = bundle.getString("folder_name");
      if (folderName == null) {
        throw new IllegalArgumentException("Argument \"folder_name\" is marked as non-null but was passed a null value.");
      }
      __result.arguments.put("folder_name", folderName);
    } else {
      throw new IllegalArgumentException("Required argument \"folder_name\" is missing and does not have an android:defaultValue");
    }
    if (bundle.containsKey("image_position")) {
      int imagePosition;
      imagePosition = bundle.getInt("image_position");
      __result.arguments.put("image_position", imagePosition);
    } else {
      throw new IllegalArgumentException("Required argument \"image_position\" is missing and does not have an android:defaultValue");
    }
    return __result;
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public String getFolderName() {
    return (String) arguments.get("folder_name");
  }

  @SuppressWarnings("unchecked")
  public int getImagePosition() {
    return (int) arguments.get("image_position");
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public Bundle toBundle() {
    Bundle __result = new Bundle();
    if (arguments.containsKey("folder_name")) {
      String folderName = (String) arguments.get("folder_name");
      __result.putString("folder_name", folderName);
    }
    if (arguments.containsKey("image_position")) {
      int imagePosition = (int) arguments.get("image_position");
      __result.putInt("image_position", imagePosition);
    }
    return __result;
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
        return true;
    }
    if (object == null || getClass() != object.getClass()) {
        return false;
    }
    ImageListFragmentArgs that = (ImageListFragmentArgs) object;
    if (arguments.containsKey("folder_name") != that.arguments.containsKey("folder_name")) {
      return false;
    }
    if (getFolderName() != null ? !getFolderName().equals(that.getFolderName()) : that.getFolderName() != null) {
      return false;
    }
    if (arguments.containsKey("image_position") != that.arguments.containsKey("image_position")) {
      return false;
    }
    if (getImagePosition() != that.getImagePosition()) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    int result = 1;
    result = 31 * result + (getFolderName() != null ? getFolderName().hashCode() : 0);
    result = 31 * result + getImagePosition();
    return result;
  }

  @Override
  public String toString() {
    return "ImageListFragmentArgs{"
        + "folderName=" + getFolderName()
        + ", imagePosition=" + getImagePosition()
        + "}";
  }

  public static class Builder {
    private final HashMap arguments = new HashMap();

    @SuppressWarnings("unchecked")
    public Builder(ImageListFragmentArgs original) {
      this.arguments.putAll(original.arguments);
    }

    @SuppressWarnings("unchecked")
    public Builder(@NonNull String folderName, int imagePosition) {
      if (folderName == null) {
        throw new IllegalArgumentException("Argument \"folder_name\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("folder_name", folderName);
      this.arguments.put("image_position", imagePosition);
    }

    @NonNull
    public ImageListFragmentArgs build() {
      ImageListFragmentArgs result = new ImageListFragmentArgs(arguments);
      return result;
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public Builder setFolderName(@NonNull String folderName) {
      if (folderName == null) {
        throw new IllegalArgumentException("Argument \"folder_name\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("folder_name", folderName);
      return this;
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public Builder setImagePosition(int imagePosition) {
      this.arguments.put("image_position", imagePosition);
      return this;
    }

    @SuppressWarnings("unchecked")
    @NonNull
    public String getFolderName() {
      return (String) arguments.get("folder_name");
    }

    @SuppressWarnings("unchecked")
    public int getImagePosition() {
      return (int) arguments.get("image_position");
    }
  }
}
