package com.contusfly.mediapicker.ui;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.contusfly.mediapicker.R;

public class ImageListFragmentDirections {
  private ImageListFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionImageListFragmentToFolderListFragment() {
    return new ActionOnlyNavDirections(R.id.action_ImageListFragment_to_FolderListFragment);
  }
}
