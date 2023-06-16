package com.contusfly.quickShare;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0088\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004J\b\u0010Z\u001a\u00020[H\u0002J\b\u0010\\\u001a\u000200H\u0002J\u0006\u0010]\u001a\u00020[J\u0012\u0010^\u001a\u00020[2\b\u0010_\u001a\u0004\u0018\u00010\u0006H\u0002J \u0010`\u001a\u00020[2\u0006\u0010a\u001a\u00020b2\u0006\u0010c\u001a\u00020\u00182\u0006\u0010\"\u001a\u00020#H\u0002J\b\u0010d\u001a\u00020[H\u0016J\u0006\u0010e\u001a\u00020[J\b\u0010f\u001a\u00020[H\u0002J0\u0010g\u001a\u0012\u0012\u0004\u0012\u00020\u00120\u0011j\b\u0012\u0004\u0012\u00020\u0012`\u00132\u0016\u0010h\u001a\u0012\u0012\u0004\u0012\u00020i0\u0011j\b\u0012\u0004\u0012\u00020i`\u0013H\u0002J(\u0010j\u001a\u00020[2\u0006\u0010k\u001a\u00020\u00062\u0006\u0010l\u001a\u00020b2\u0006\u0010c\u001a\u00020\u00182\u0006\u0010\"\u001a\u00020#H\u0002J\u000e\u0010m\u001a\b\u0012\u0004\u0012\u00020\u00180\u001eH\u0002J\u0018\u0010n\u001a\u00020[2\u0006\u0010k\u001a\u00020\u00062\u0006\u0010c\u001a\u00020\u0018H\u0002J\u0010\u0010o\u001a\u00020\u00062\u0006\u0010l\u001a\u00020bH\u0002J\u000e\u0010p\u001a\b\u0012\u0004\u0012\u00020\u00060\u0011H\u0002J\b\u0010q\u001a\u00020\u0006H\u0002J\u0010\u0010r\u001a\u00020\u00062\u0006\u0010s\u001a\u00020\rH\u0002J\b\u0010t\u001a\u00020[H\u0002J\b\u0010u\u001a\u00020[H\u0002J\b\u0010v\u001a\u00020[H\u0002J\b\u0010w\u001a\u00020[H\u0002J\b\u0010x\u001a\u00020[H\u0002J\b\u0010y\u001a\u00020[H\u0002J\b\u0010z\u001a\u00020[H\u0002J\u0016\u0010{\u001a\u0002002\f\u0010|\u001a\b\u0012\u0004\u0012\u00020\u00180\u0011H\u0002J\u0010\u0010}\u001a\u00020[2\u0006\u0010~\u001a\u00020#H\u0016J\u0006\u0010\u007f\u001a\u000200J\u0012\u0010\u0080\u0001\u001a\u00020\u00062\u0007\u0010\u0081\u0001\u001a\u00020\rH\u0002J\u0018\u0010\u0082\u0001\u001a\u00020[2\r\u0010\u0083\u0001\u001a\b\u0012\u0004\u0012\u00020\u00060\u0011H\u0002J\t\u0010\u0084\u0001\u001a\u00020[H\u0002J$\u0010\u0085\u0001\u001a\u00020[2\u0007\u0010\u0086\u0001\u001a\u00020\u00062\u0007\u0010\u0087\u0001\u001a\u00020\u00062\u0007\u0010\u0088\u0001\u001a\u000200H\u0016J\t\u0010\u0089\u0001\u001a\u00020[H\u0016J\u0015\u0010\u008a\u0001\u001a\u00020[2\n\u0010\u008b\u0001\u001a\u0005\u0018\u00010\u008c\u0001H\u0014J\u0015\u0010\u008d\u0001\u001a\u0002002\n\u0010\u008e\u0001\u001a\u0005\u0018\u00010\u008f\u0001H\u0016J\t\u0010\u0090\u0001\u001a\u00020[H\u0014J\u001e\u0010\u0091\u0001\u001a\u00020[2\n\u0010\u0092\u0001\u001a\u0005\u0018\u00010\u0093\u00012\u0007\u0010\u0094\u0001\u001a\u000200H\u0016J\u0013\u0010\u0095\u0001\u001a\u0002002\b\u0010\u0096\u0001\u001a\u00030\u0097\u0001H\u0016J\u0015\u0010\u0098\u0001\u001a\u00020[2\n\u0010\u008b\u0001\u001a\u0005\u0018\u00010\u008c\u0001H\u0014J\t\u0010\u0099\u0001\u001a\u00020[H\u0014J\t\u0010\u009a\u0001\u001a\u00020[H\u0002J!\u0010\u009b\u0001\u001a\u0012\u0012\u0004\u0012\u00020i0\u0011j\b\u0012\u0004\u0012\u00020i`\u00132\u0006\u0010l\u001a\u00020bH\u0002J\u0013\u0010\u009c\u0001\u001a\u00020[2\b\u0010c\u001a\u0004\u0018\u00010\u0018H\u0016J0\u0010\u009d\u0001\u001a\u00020[2\r\u0010\u009e\u0001\u001a\b\u0012\u0004\u0012\u00020\u00180\u00112\r\u0010\u0083\u0001\u001a\b\u0012\u0004\u0012\u00020\u00060\u00112\u0007\u0010\u009f\u0001\u001a\u000200H\u0002J\t\u0010\u00a0\u0001\u001a\u00020[H\u0002J\t\u0010\u00a1\u0001\u001a\u00020[H\u0002J\t\u0010\u00a2\u0001\u001a\u00020[H\u0002J\u001d\u0010\u00a3\u0001\u001a\u00020[2\b\u0010\u00a4\u0001\u001a\u00030\u00a5\u00012\b\u0010\u00a6\u0001\u001a\u00030\u00a7\u0001H\u0002J\t\u0010\u00a8\u0001\u001a\u00020[H\u0002J\u0018\u0010\u00a8\u0001\u001a\u00020[2\r\u0010\u00a9\u0001\u001a\b\u0012\u0004\u0012\u00020\u00060\u0011H\u0002J\t\u0010\u00aa\u0001\u001a\u00020[H\u0002J\u0012\u0010\u00ab\u0001\u001a\u00020[2\u0007\u0010\u00ac\u0001\u001a\u00020\u0006H\u0002J\u0012\u0010\u00ad\u0001\u001a\u00020[2\u0007\u0010\u0086\u0001\u001a\u00020\u0006H\u0016J\u0012\u0010\u00ae\u0001\u001a\u00020[2\u0007\u0010\u0086\u0001\u001a\u00020\u0006H\u0016J\'\u0010\u00af\u0001\u001a\u00020[2\u0006\u0010c\u001a\u00020\u00182\u0014\u0010\u00b0\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u0002000\u00b1\u0001H\u0002J\'\u0010\u00b2\u0001\u001a\u00020[2\u0006\u0010c\u001a\u00020\u00182\u0014\u0010\u00b0\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u0002000\u00b1\u0001H\u0002J\u0019\u0010\u00b2\u0001\u001a\u00020[2\u0006\u0010c\u001a\u00020\u00182\u0006\u0010\"\u001a\u00020#H\u0002J\'\u0010\u00b3\u0001\u001a\u00020[2\u0006\u0010c\u001a\u00020\u00182\u0014\u0010\u00b0\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u0002000\u00b1\u0001H\u0002J\u0014\u0010\u00b4\u0001\u001a\u00020\u00062\t\u0010\u00b5\u0001\u001a\u0004\u0018\u00010\u0006H\u0002J\'\u0010\u00b6\u0001\u001a\u00020[2\u0006\u0010c\u001a\u00020\u00182\u0014\u0010\u00b0\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u0002000\u00b1\u0001H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\bX\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\tR\u000e\u0010\n\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\"\u0010\u0010\u001a\u0016\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011j\n\u0012\u0004\u0012\u00020\u0012\u0018\u0001`\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R.\u0010\u0017\u001a\u0016\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0011j\n\u0012\u0004\u0012\u00020\u0018\u0018\u0001`\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00060\u001eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\"\u0010\u001f\u001a\u0016\u0012\u0012\u0012\u0010\u0012\f\u0012\n !*\u0004\u0018\u00010\u00060\u00060\b0 X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\"\u001a\u00020#X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010\'R\u000e\u0010(\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010)\u001a\u00020*X\u0080.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u000e\u0010/\u001a\u000200X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u00101\u001a\u000200X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u00102\u001a\u000203X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u00104\u001a\u000205X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u00106\u001a\u000205X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u00107\u001a\u000208X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020#X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020;X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001b\u0010<\u001a\u00020=8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b@\u0010A\u001a\u0004\b>\u0010?R\u000e\u0010B\u001a\u000200X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010C\u001a\u0004\u0018\u00010DX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020FX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010G\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010H\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060IX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001e\u0010J\u001a\u00020K8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR\u0016\u0010P\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\b\n\u0000\u0012\u0004\bQ\u0010\u0004R\u0016\u0010R\u001a\b\u0012\u0004\u0012\u00020\u00060\bX\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\tR\u0014\u0010S\u001a\b\u0012\u0004\u0012\u00020\u00060\u001eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010T\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010U\u001a\u00020V8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bY\u0010A\u001a\u0004\bW\u0010X\u00a8\u0006\u00b7\u0001"}, d2 = {"Lcom/contusfly/quickShare/QuickShareActivity;", "Lcom/contusfly/activities/BaseActivity;", "Lcom/contusfly/quickShare/FilesDialogFragment$DialogFragmentInterface;", "Lcom/contusfly/views/CommonAlertDialog$CommonDialogClosedListener;", "()V", "CONTACT", "", "SUPPORTED_IMAGE_VIDEO_FORMATS", "", "[Ljava/lang/String;", "TEXT", "USERS", "audioLimit", "", "commonAlertDialog", "Lcom/contusfly/views/CommonAlertDialog;", "contactShareModels", "Ljava/util/ArrayList;", "Lcom/contusfly/models/ContactShareModel;", "Lkotlin/collections/ArrayList;", "dialogFragment", "Landroidx/fragment/app/DialogFragment;", "fileLimit", "fileList", "Lcom/contusfly/models/FileObject;", "getFileList", "()Ljava/util/ArrayList;", "setFileList", "(Ljava/util/ArrayList;)V", "formats", "", "galleryPermissionLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "kotlin.jvm.PlatformType", "i", "", "getI", "()I", "setI", "(I)V", "imageLimit", "intent", "Landroid/content/Intent;", "getIntent$app_debug", "()Landroid/content/Intent;", "setIntent$app_debug", "(Landroid/content/Intent;)V", "isFileValidationsVerified", "", "isMediaScanSuccess", "mHandler", "Landroid/os/Handler;", "mQuickShareAdapter", "Lcom/contusfly/adapters/SectionedShareAdapter;", "mSearchQuickShareAdapter", "mUserListType", "Lcom/contusfly/helpers/UserListType;", "noOfFiles", "onItemClickListener", "Lcom/contusfly/interfaces/RecyclerViewItemClick;", "permissionAlertDialog", "Lcom/contusfly/views/PermissionAlertDialog;", "getPermissionAlertDialog", "()Lcom/contusfly/views/PermissionAlertDialog;", "permissionAlertDialog$delegate", "Lkotlin/Lazy;", "permissionDenied", "progressDialog", "Lcom/contusfly/views/DoProgressDialog;", "quickShareBinding", "Lcom/contusfly/databinding/ActivityQuickShareBinding;", "searchKey", "selectedUsersWithNames", "Ljava/util/LinkedHashMap;", "shareMessagesController", "Lcom/contusfly/chat/ShareMessagesController;", "getShareMessagesController", "()Lcom/contusfly/chat/ShareMessagesController;", "setShareMessagesController", "(Lcom/contusfly/chat/ShareMessagesController;)V", "shareType", "getShareType$annotations", "supportedFormats", "videoImageFormats", "videoLimit", "viewModel", "Lcom/contusfly/viewmodels/ForwardMessageViewModel;", "getViewModel", "()Lcom/contusfly/viewmodels/ForwardMessageViewModel;", "viewModel$delegate", "checkConditionForPin", "", "checkPermission", "clickListeners", "composeTextMessage", "shareText", "convertFileSchemeToUri", "mainURI", "Landroid/net/Uri;", "fileObject", "exitShare", "filterList", "finishQuickShare", "generateContactShareModel", "contactMessages", "Lcom/mirrorflysdk/flydatabase/model/ContactMessage;", "getFileNameSizeType", "absolutePath", "uri", "getInvalidFiles", "getMediaDurationFromFilePath", "getMimeTypeFromFilePath", "getSelectedUserIdList", "getSelectedUserNames", "getStringSizeLengthFile", "size", "goToContactPreview", "handleIntent", "handleMultipleFileShare", "handleNextClick", "handleSingleFileShare", "initViews", "initializeDialog", "isFeatureAvailableForFiles", "fileObjects", "listOptionSelected", "position", "maxUserReached", "milliSecondsToTimer", "milliseconds", "navigateToAppropriateScreen", "userIdList", "observeNetworkListener", "onAdminBlockedOtherUser", "jid", "type", "status", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateOptionsMenu", "menu", "Landroid/view/Menu;", "onDestroy", "onDialogClosed", "dialogType", "Lcom/contusfly/views/CommonAlertDialog$DIALOGTYPE;", "isSuccess", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "onPostCreate", "onResume", "openPinActivity", "parseVcard", "removeFile", "sendOtherFiles", "otherFileList", "isNavigationEnable", "setAdapterBasedOnSearchType", "setLimitValues", "setObservers", "setScrollListener", "recyclerView", "Lcom/contusfly/views/CustomRecyclerView;", "layoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "shareFiles", "jidList", "showBusyAlert", "updateProfileDetails", "userJid", "userDeletedHisProfile", "userUpdatedHisProfile", "validateAudioObject", "fileValidation", "Ljava/util/HashMap;", "validateFileObject", "validateImageObject", "validateMimeType", "mimeType", "validateVideoObject", "app_debug"})
public final class QuickShareActivity extends com.contusfly.activities.BaseActivity implements com.contusfly.quickShare.FilesDialogFragment.DialogFragmentInterface, com.contusfly.views.CommonAlertDialog.CommonDialogClosedListener {
    private com.contusfly.databinding.ActivityQuickShareBinding quickShareBinding;
    private final java.lang.String CONTACT = "text/x-vcard";
    private final java.lang.String TEXT = "text/plain";
    private final java.lang.String USERS = "USERS";
    private boolean permissionDenied = false;
    private boolean isFileValidationsVerified = true;
    private final java.lang.String[] SUPPORTED_IMAGE_VIDEO_FORMATS = {"jpg", "jpeg", "png", "webp", "gif", "mp4"};
    private final java.lang.String[] supportedFormats = {"pdf", "txt", "rtf", "xls", "ppt", "pptx", "zip", "rar", "xlsx", "doc", "docx", "wav", "mp3", "mp4", "aac", "jpg", "jpeg", "png", "webp", "gif", "pptx", "csv"};
    private java.util.List<java.lang.String> formats;
    private java.util.List<java.lang.String> videoImageFormats;
    private java.lang.String searchKey = "";
    private com.contusfly.helpers.UserListType mUserListType = com.contusfly.helpers.UserListType.USER_LIST;
    
    /**
     * The handler to delay the search
     */
    private android.os.Handler mHandler;
    private final java.util.LinkedHashMap<java.lang.String, java.lang.String> selectedUsersWithNames = null;
    
    /**
     * List holds the media files
     */
    @org.jetbrains.annotations.Nullable()
    private java.util.ArrayList<com.contusfly.models.FileObject> fileList;
    private java.util.ArrayList<com.contusfly.models.ContactShareModel> contactShareModels;
    
    /**
     * Dialog to show Invalid media files
     */
    private androidx.fragment.app.DialogFragment dialogFragment;
    private int i = 0;
    
    /**
     * Adapter for quick share user selection List
     */
    private com.contusfly.adapters.SectionedShareAdapter mQuickShareAdapter;
    private com.contusfly.adapters.SectionedShareAdapter mSearchQuickShareAdapter;
    private final kotlin.Lazy viewModel$delegate = null;
    
    /**
     * Holds the type of incoming share type
     */
    private java.lang.String shareType;
    private int noOfFiles = 0;
    private boolean isMediaScanSuccess = false;
    
    /**
     * The progress dialog of the activity When run the background tasks
     */
    private com.contusfly.views.DoProgressDialog progressDialog;
    private com.contusfly.views.CommonAlertDialog commonAlertDialog;
    private long videoLimit = 0L;
    private long audioLimit = 0L;
    private long fileLimit = 0L;
    private long imageLimit = 0L;
    public android.content.Intent intent;
    
    /**
     * View to the files number
     */
    @javax.inject.Inject()
    public com.contusfly.chat.ShareMessagesController shareMessagesController;
    private final kotlin.Lazy permissionAlertDialog$delegate = null;
    private final androidx.activity.result.ActivityResultLauncher<java.lang.String[]> galleryPermissionLauncher = null;
    private final com.contusfly.interfaces.RecyclerViewItemClick onItemClickListener = null;
    private java.util.HashMap _$_findViewCache;
    
    public QuickShareActivity() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.ArrayList<com.contusfly.models.FileObject> getFileList() {
        return null;
    }
    
    public final void setFileList(@org.jetbrains.annotations.Nullable()
    java.util.ArrayList<com.contusfly.models.FileObject> p0) {
    }
    
    public final int getI() {
        return 0;
    }
    
    public final void setI(int p0) {
    }
    
    private final com.contusfly.viewmodels.ForwardMessageViewModel getViewModel() {
        return null;
    }
    
    /**
     * Holds the type of incoming share type
     */
    @ShareType()
    @java.lang.Deprecated()
    private static void getShareType$annotations() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.Intent getIntent$app_debug() {
        return null;
    }
    
    public final void setIntent$app_debug(@org.jetbrains.annotations.NotNull()
    android.content.Intent p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.contusfly.chat.ShareMessagesController getShareMessagesController() {
        return null;
    }
    
    public final void setShareMessagesController(@org.jetbrains.annotations.NotNull()
    com.contusfly.chat.ShareMessagesController p0) {
    }
    
    private final com.contusfly.views.PermissionAlertDialog getPermissionAlertDialog() {
        return null;
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    public void userUpdatedHisProfile(@org.jetbrains.annotations.NotNull()
    java.lang.String jid) {
    }
    
    /**
     * To handle callback of any user's profile deleted
     */
    @java.lang.Override()
    public void userDeletedHisProfile(@org.jetbrains.annotations.NotNull()
    java.lang.String jid) {
    }
    
    @java.lang.Override()
    protected void onPostCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void setObservers() {
    }
    
    private final void observeNetworkListener() {
    }
    
    private final void setAdapterBasedOnSearchType() {
    }
    
    private final void initViews() {
    }
    
    private final void setScrollListener(com.contusfly.views.CustomRecyclerView recyclerView, androidx.recyclerview.widget.LinearLayoutManager layoutManager) {
    }
    
    /**
     * Filter the list from the search key
     */
    public final void filterList() {
    }
    
    /**
     * Intent must be handled only when storage permissions are granted
     */
    private final void handleIntent() {
    }
    
    private final void checkConditionForPin() {
    }
    
    private final void openPinActivity() {
    }
    
    private final void handleSingleFileShare() {
    }
    
    private final void handleMultipleFileShare() {
    }
    
    public final void clickListeners() {
    }
    
    private final void handleNextClick() {
    }
    
    private final void shareFiles() {
    }
    
    private final void shareFiles(java.util.ArrayList<java.lang.String> jidList) {
    }
    
    private final boolean isFeatureAvailableForFiles(java.util.ArrayList<com.contusfly.models.FileObject> fileObjects) {
        return false;
    }
    
    private final void sendOtherFiles(java.util.ArrayList<com.contusfly.models.FileObject> otherFileList, java.util.ArrayList<java.lang.String> userIdList, boolean isNavigationEnable) {
    }
    
    private final void navigateToAppropriateScreen(java.util.ArrayList<java.lang.String> userIdList) {
    }
    
    /**
     * Dialog action to show whether the busy status to be enabled or disabled...
     */
    private final void showBusyAlert() {
    }
    
    private final java.lang.String getStringSizeLengthFile(long size) {
        return null;
    }
    
    private final java.lang.String milliSecondsToTimer(long milliseconds) {
        return null;
    }
    
    private final void setLimitValues() {
    }
    
    private final java.util.ArrayList<com.mirrorflysdk.flydatabase.model.ContactMessage> parseVcard(android.net.Uri uri) {
        return null;
    }
    
    @java.lang.Override()
    protected void onResume() {
    }
    
    /**
     * @return if permission not granted return FALSE, else TRUE
     */
    private final boolean checkPermission() {
        return false;
    }
    
    private final java.lang.String getSelectedUserNames() {
        return null;
    }
    
    private final java.util.List<com.contusfly.models.FileObject> getInvalidFiles() {
        return null;
    }
    
    private final void initializeDialog() {
    }
    
    @com.contusfly.chat.FileMimeType()
    private final java.lang.String validateMimeType(java.lang.String mimeType) {
        return null;
    }
    
    private final void convertFileSchemeToUri(android.net.Uri mainURI, com.contusfly.models.FileObject fileObject, int i) {
    }
    
    private final void getFileNameSizeType(java.lang.String absolutePath, android.net.Uri uri, com.contusfly.models.FileObject fileObject, int i) {
    }
    
    private final java.lang.String getMimeTypeFromFilePath(android.net.Uri uri) {
        return null;
    }
    
    private final void validateFileObject(com.contusfly.models.FileObject fileObject, int i) {
    }
    
    private final void validateVideoObject(com.contusfly.models.FileObject fileObject, java.util.HashMap<java.lang.String, java.lang.Boolean> fileValidation) {
    }
    
    private final void validateAudioObject(com.contusfly.models.FileObject fileObject, java.util.HashMap<java.lang.String, java.lang.Boolean> fileValidation) {
    }
    
    private final void validateFileObject(com.contusfly.models.FileObject fileObject, java.util.HashMap<java.lang.String, java.lang.Boolean> fileValidation) {
    }
    
    private final void validateImageObject(com.contusfly.models.FileObject fileObject, java.util.HashMap<java.lang.String, java.lang.Boolean> fileValidation) {
    }
    
    private final void getMediaDurationFromFilePath(java.lang.String absolutePath, com.contusfly.models.FileObject fileObject) {
    }
    
    @java.lang.Override()
    public boolean onCreateOptionsMenu(@org.jetbrains.annotations.Nullable()
    android.view.Menu menu) {
        return false;
    }
    
    @java.lang.Override()
    public boolean onOptionsItemSelected(@org.jetbrains.annotations.NotNull()
    android.view.MenuItem item) {
        return false;
    }
    
    public final boolean maxUserReached() {
        return false;
    }
    
    @java.lang.Override()
    public void removeFile(@org.jetbrains.annotations.Nullable()
    com.contusfly.models.FileObject fileObject) {
    }
    
    @java.lang.Override()
    public void exitShare() {
    }
    
    @java.lang.Override()
    public void onDialogClosed(@org.jetbrains.annotations.Nullable()
    com.contusfly.views.CommonAlertDialog.DIALOGTYPE dialogType, boolean isSuccess) {
    }
    
    private final void updateProfileDetails(java.lang.String userJid) {
    }
    
    @java.lang.Override()
    public void listOptionSelected(int position) {
    }
    
    private final void composeTextMessage(java.lang.String shareText) {
    }
    
    private final void goToContactPreview() {
    }
    
    private final java.util.ArrayList<com.contusfly.models.ContactShareModel> generateContactShareModel(java.util.ArrayList<com.mirrorflysdk.flydatabase.model.ContactMessage> contactMessages) {
        return null;
    }
    
    private final java.util.ArrayList<java.lang.String> getSelectedUserIdList() {
        return null;
    }
    
    private final void finishQuickShare() {
    }
    
    @java.lang.Override()
    public void onBackPressed() {
    }
    
    @java.lang.Override()
    protected void onDestroy() {
    }
    
    @java.lang.Override()
    public void onAdminBlockedOtherUser(@org.jetbrains.annotations.NotNull()
    java.lang.String jid, @org.jetbrains.annotations.NotNull()
    java.lang.String type, boolean status) {
    }
}