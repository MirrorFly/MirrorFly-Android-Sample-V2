// Generated by view binder compiler. Do not edit!
package com.contusfly.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.contusfly.R;
import com.contusfly.views.CustomRecyclerView;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityStarredMessageBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView_;

  @NonNull
  public final Button btnAdd;

  @NonNull
  public final Button btnBlock;

  @NonNull
  public final ViewStub chatControlsViewStub;

  @NonNull
  public final RelativeLayout chatXmppConnectionStatusLayout;

  @NonNull
  public final TextView chatXmppConnectionText;

  @NonNull
  public final FrameLayout emojicons;

  @NonNull
  public final ViewEmptyDataBinding emptyList;

  @NonNull
  public final ImageView fbRedirectBottom;

  @NonNull
  public final LinearLayout layoutRedirectMessage;

  @NonNull
  public final LinearLayout llBlock;

  @NonNull
  public final ImageView replyClose;

  @NonNull
  public final RelativeLayout rootView;

  @NonNull
  public final LinearLayout suggestionLayout;

  @NonNull
  public final RecyclerView suggestionRecycler;

  @NonNull
  public final Toolbar toolbar;

  @NonNull
  public final TextView unreadCount;

  @NonNull
  public final ViewChatFooterBinding viewChatFooter;

  @NonNull
  public final CustomRecyclerView viewChatList;

  @NonNull
  public final LinearLayout viewFooter;

  @NonNull
  public final View viewOverlay;

  @NonNull
  public final ListChatReplySentItemBinding viewTextReplyLayout;

  private ActivityStarredMessageBinding(@NonNull RelativeLayout rootView_, @NonNull Button btnAdd,
      @NonNull Button btnBlock, @NonNull ViewStub chatControlsViewStub,
      @NonNull RelativeLayout chatXmppConnectionStatusLayout,
      @NonNull TextView chatXmppConnectionText, @NonNull FrameLayout emojicons,
      @NonNull ViewEmptyDataBinding emptyList, @NonNull ImageView fbRedirectBottom,
      @NonNull LinearLayout layoutRedirectMessage, @NonNull LinearLayout llBlock,
      @NonNull ImageView replyClose, @NonNull RelativeLayout rootView,
      @NonNull LinearLayout suggestionLayout, @NonNull RecyclerView suggestionRecycler,
      @NonNull Toolbar toolbar, @NonNull TextView unreadCount,
      @NonNull ViewChatFooterBinding viewChatFooter, @NonNull CustomRecyclerView viewChatList,
      @NonNull LinearLayout viewFooter, @NonNull View viewOverlay,
      @NonNull ListChatReplySentItemBinding viewTextReplyLayout) {
    this.rootView_ = rootView_;
    this.btnAdd = btnAdd;
    this.btnBlock = btnBlock;
    this.chatControlsViewStub = chatControlsViewStub;
    this.chatXmppConnectionStatusLayout = chatXmppConnectionStatusLayout;
    this.chatXmppConnectionText = chatXmppConnectionText;
    this.emojicons = emojicons;
    this.emptyList = emptyList;
    this.fbRedirectBottom = fbRedirectBottom;
    this.layoutRedirectMessage = layoutRedirectMessage;
    this.llBlock = llBlock;
    this.replyClose = replyClose;
    this.rootView = rootView;
    this.suggestionLayout = suggestionLayout;
    this.suggestionRecycler = suggestionRecycler;
    this.toolbar = toolbar;
    this.unreadCount = unreadCount;
    this.viewChatFooter = viewChatFooter;
    this.viewChatList = viewChatList;
    this.viewFooter = viewFooter;
    this.viewOverlay = viewOverlay;
    this.viewTextReplyLayout = viewTextReplyLayout;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView_;
  }

  @NonNull
  public static ActivityStarredMessageBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityStarredMessageBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_starred_message, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityStarredMessageBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btn_add;
      Button btnAdd = ViewBindings.findChildViewById(rootView, id);
      if (btnAdd == null) {
        break missingId;
      }

      id = R.id.btn_block;
      Button btnBlock = ViewBindings.findChildViewById(rootView, id);
      if (btnBlock == null) {
        break missingId;
      }

      id = R.id.chat_controls_view_stub;
      ViewStub chatControlsViewStub = ViewBindings.findChildViewById(rootView, id);
      if (chatControlsViewStub == null) {
        break missingId;
      }

      id = R.id.chat_xmpp_connection_status_layout;
      RelativeLayout chatXmppConnectionStatusLayout = ViewBindings.findChildViewById(rootView, id);
      if (chatXmppConnectionStatusLayout == null) {
        break missingId;
      }

      id = R.id.chat_xmpp_connection_text;
      TextView chatXmppConnectionText = ViewBindings.findChildViewById(rootView, id);
      if (chatXmppConnectionText == null) {
        break missingId;
      }

      id = R.id.emojicons;
      FrameLayout emojicons = ViewBindings.findChildViewById(rootView, id);
      if (emojicons == null) {
        break missingId;
      }

      id = R.id.empty_list;
      View emptyList = ViewBindings.findChildViewById(rootView, id);
      if (emptyList == null) {
        break missingId;
      }
      ViewEmptyDataBinding binding_emptyList = ViewEmptyDataBinding.bind(emptyList);

      id = R.id.fb_redirect_bottom;
      ImageView fbRedirectBottom = ViewBindings.findChildViewById(rootView, id);
      if (fbRedirectBottom == null) {
        break missingId;
      }

      id = R.id.layout_redirect_message;
      LinearLayout layoutRedirectMessage = ViewBindings.findChildViewById(rootView, id);
      if (layoutRedirectMessage == null) {
        break missingId;
      }

      id = R.id.ll_block;
      LinearLayout llBlock = ViewBindings.findChildViewById(rootView, id);
      if (llBlock == null) {
        break missingId;
      }

      id = R.id.reply_close;
      ImageView replyClose = ViewBindings.findChildViewById(rootView, id);
      if (replyClose == null) {
        break missingId;
      }

      RelativeLayout rootView_ = (RelativeLayout) rootView;

      id = R.id.suggestion_layout;
      LinearLayout suggestionLayout = ViewBindings.findChildViewById(rootView, id);
      if (suggestionLayout == null) {
        break missingId;
      }

      id = R.id.suggestion_recycler;
      RecyclerView suggestionRecycler = ViewBindings.findChildViewById(rootView, id);
      if (suggestionRecycler == null) {
        break missingId;
      }

      id = R.id.toolbar;
      Toolbar toolbar = ViewBindings.findChildViewById(rootView, id);
      if (toolbar == null) {
        break missingId;
      }

      id = R.id.unread_count;
      TextView unreadCount = ViewBindings.findChildViewById(rootView, id);
      if (unreadCount == null) {
        break missingId;
      }

      id = R.id.view_chat_footer;
      View viewChatFooter = ViewBindings.findChildViewById(rootView, id);
      if (viewChatFooter == null) {
        break missingId;
      }
      ViewChatFooterBinding binding_viewChatFooter = ViewChatFooterBinding.bind(viewChatFooter);

      id = R.id.view_chat_list;
      CustomRecyclerView viewChatList = ViewBindings.findChildViewById(rootView, id);
      if (viewChatList == null) {
        break missingId;
      }

      id = R.id.view_footer;
      LinearLayout viewFooter = ViewBindings.findChildViewById(rootView, id);
      if (viewFooter == null) {
        break missingId;
      }

      id = R.id.view_overlay;
      View viewOverlay = ViewBindings.findChildViewById(rootView, id);
      if (viewOverlay == null) {
        break missingId;
      }

      id = R.id.view_text_reply_layout;
      View viewTextReplyLayout = ViewBindings.findChildViewById(rootView, id);
      if (viewTextReplyLayout == null) {
        break missingId;
      }
      ListChatReplySentItemBinding binding_viewTextReplyLayout = ListChatReplySentItemBinding.bind(viewTextReplyLayout);

      return new ActivityStarredMessageBinding((RelativeLayout) rootView, btnAdd, btnBlock,
          chatControlsViewStub, chatXmppConnectionStatusLayout, chatXmppConnectionText, emojicons,
          binding_emptyList, fbRedirectBottom, layoutRedirectMessage, llBlock, replyClose,
          rootView_, suggestionLayout, suggestionRecycler, toolbar, unreadCount,
          binding_viewChatFooter, viewChatList, viewFooter, viewOverlay,
          binding_viewTextReplyLayout);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}