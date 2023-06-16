package com.contusfly.mediapicker.ui;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.navigation.NavDirections;
import com.contusfly.mediapicker.R;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class FolderListFragmentDirections {
  private FolderListFragmentDirections() {
  }

  @NonNull
  public static ActionFolderListFragmentToImageListFragment actionFolderListFragmentToImageListFragment(
      @NonNull String folderName, int imagePosition) {
    return new ActionFolderListFragmentToImageListFragment(folderName, imagePosition);
  }

  public static class ActionFolderListFragmentToImageListFragment implements NavDirections {
    private final HashMap arguments = new HashMap();

    @SuppressWarnings("unchecked")
    private ActionFolderListFragmentToImageListFragment(@NonNull String folderName,
        int imagePosition) {
      if (folderName == null) {
        throw new IllegalArgumentException("Argument \"folder_name\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("folder_name", folderName);
      this.arguments.put("image_position", imagePosition);
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public ActionFolderListFragmentToImageListFragment setFolderName(@NonNull String folderName) {
      if (folderName == null) {
        throw new IllegalArgumentException("Argument \"folder_name\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("folder_name", folderName);
      return this;
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public ActionFolderListFragmentToImageListFragment setImagePosition(int imagePosition) {
      this.arguments.put("image_position", imagePosition);
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    @NonNull
    public Bundle getArguments() {
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
    public int getActionId() {
      return R.id.action_FolderListFragment_to_ImageListFragment;
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

    @Override
    public boolean equals(Object object) {
      if (this == object) {
          return true;
      }
      if (object == null || getClass() != object.getClass()) {
          return false;
      }
      ActionFolderListFragmentToImageListFragment that = (ActionFolderListFragmentToImageListFragment) object;
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
      if (getActionId() != that.getActionId()) {
        return false;
      }
      return true;
    }

    @Override
    public int hashCode() {
      int result = 1;
      result = 31 * result + (getFolderName() != null ? getFolderName().hashCode() : 0);
      result = 31 * result + getImagePosition();
      result = 31 * result + getActionId();
      return result;
    }

    @Override
    public String toString() {
      return "ActionFolderListFragmentToImageListFragment(actionId=" + getActionId() + "){"
          + "folderName=" + getFolderName()
          + ", imagePosition=" + getImagePosition()
          + "}";
    }
  }
}
