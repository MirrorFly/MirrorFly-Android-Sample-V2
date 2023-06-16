package com.contusfly.starredMessages.adapter;

import java.lang.System;

/**
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u00d4\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u0002H\u0002J \u0010,\u001a\u00020*2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020.2\u0006\u00100\u001a\u00020$H\u0002J\u0012\u00101\u001a\u0004\u0018\u00010\u001d2\u0006\u00102\u001a\u00020$H\u0002J\u0010\u00103\u001a\u00020\u001d2\u0006\u00104\u001a\u00020\u001dH\u0002J\b\u00105\u001a\u00020\u0006H\u0016J\u0010\u00106\u001a\u0002072\u0006\u00108\u001a\u00020\u0006H\u0016J\u0010\u00109\u001a\u00020\u00062\u0006\u00108\u001a\u00020\u0006H\u0016J\u0012\u0010:\u001a\u0004\u0018\u00010\u001d2\u0006\u00102\u001a\u00020$H\u0003J\u0010\u0010;\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010$\u0018\u00010&J\u0012\u0010<\u001a\u00020=2\b\u00104\u001a\u0004\u0018\u00010\u001dH\u0002J \u0010>\u001a\u00020*2\u0006\u0010+\u001a\u00020\u00022\u0006\u00102\u001a\u00020$2\u0006\u00108\u001a\u00020\u0006H\u0002J \u0010?\u001a\u00020*2\u0006\u0010+\u001a\u00020\u00022\u0006\u00102\u001a\u00020$2\u0006\u00108\u001a\u00020\u0006H\u0002J \u0010@\u001a\u00020*2\u0006\u0010+\u001a\u00020\u00022\u0006\u00102\u001a\u00020$2\u0006\u00108\u001a\u00020\u0006H\u0002J \u0010A\u001a\u00020*2\u0006\u0010+\u001a\u00020\u00022\u0006\u00102\u001a\u00020$2\u0006\u00108\u001a\u00020\u0006H\u0002J \u0010B\u001a\u00020*2\u0006\u0010+\u001a\u00020\u00022\u0006\u00102\u001a\u00020$2\u0006\u00108\u001a\u00020\u0006H\u0002J \u0010C\u001a\u00020*2\u0006\u0010+\u001a\u00020\u00022\u0006\u00102\u001a\u00020$2\u0006\u00108\u001a\u00020\u0006H\u0002J \u0010D\u001a\u00020*2\u0006\u0010+\u001a\u00020\u00022\u0006\u00100\u001a\u00020$2\u0006\u00108\u001a\u00020\u0006H\u0002J \u0010E\u001a\u00020*2\u0006\u0010+\u001a\u00020\u00022\u0006\u00100\u001a\u00020$2\u0006\u00108\u001a\u00020\u0006H\u0002J \u0010F\u001a\u00020*2\u0006\u0010+\u001a\u00020\u00022\u0006\u00102\u001a\u00020$2\u0006\u00108\u001a\u00020\u0006H\u0002J \u0010G\u001a\u00020*2\u0006\u0010+\u001a\u00020\u00022\u0006\u00102\u001a\u00020$2\u0006\u00108\u001a\u00020\u0006H\u0002J \u0010H\u001a\u00020*2\u0006\u0010+\u001a\u00020\u00022\u0006\u00102\u001a\u00020$2\u0006\u00108\u001a\u00020\u0006H\u0002J \u0010I\u001a\u00020*2\u0006\u0010+\u001a\u00020\u00022\u0006\u00102\u001a\u00020$2\u0006\u00108\u001a\u00020\u0006H\u0002J \u0010J\u001a\u00020*2\u0006\u0010+\u001a\u00020\u00022\u0006\u00100\u001a\u00020$2\u0006\u00108\u001a\u00020\u0006H\u0002J \u0010K\u001a\u00020*2\u0006\u0010+\u001a\u00020\u00022\u0006\u00100\u001a\u00020$2\u0006\u00108\u001a\u00020\u0006H\u0002J(\u0010L\u001a\u00020*2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010M\u001a\u00020N2\u0006\u0010O\u001a\u00020P2\u0006\u0010Q\u001a\u00020RH\u0002J\u0018\u0010S\u001a\u00020*2\u0006\u0010+\u001a\u00020\u00022\u0006\u00108\u001a\u00020\u0006H\u0016J\u0018\u0010T\u001a\u00020\u00022\u0006\u0010U\u001a\u00020V2\u0006\u0010W\u001a\u00020\u0006H\u0016J2\u0010X\u001a\u00020*2\u0006\u0010-\u001a\u00020.2\u0006\u0010Y\u001a\u00020.2\u0006\u0010/\u001a\u00020.2\u0006\u00100\u001a\u00020$2\b\u0010Z\u001a\u0004\u0018\u00010.H\u0002J \u0010[\u001a\u00020*2\u0006\u0010\\\u001a\u00020.2\u0006\u00100\u001a\u00020$2\u0006\u00108\u001a\u00020\u0006H\u0002J(\u0010]\u001a\u00020*2\u0006\u0010Y\u001a\u00020.2\u0006\u0010^\u001a\u00020.2\u0006\u00100\u001a\u00020$2\u0006\u0010_\u001a\u00020.H\u0002J \u0010`\u001a\u00020*2\u0006\u0010a\u001a\u00020.2\u0006\u00100\u001a\u00020$2\u0006\u00108\u001a\u00020\u0006H\u0002J\u000e\u0010b\u001a\u00020*2\u0006\u0010\f\u001a\u00020\rJ0\u0010c\u001a\u00020*2\u0006\u00102\u001a\u00020$2\u0006\u0010+\u001a\u00020\u00022\u0006\u0010d\u001a\u00020P2\u0006\u0010e\u001a\u00020f2\u0006\u0010g\u001a\u00020hH\u0002J\u001c\u0010i\u001a\u00020*2\b\u00102\u001a\u0004\u0018\u00010$2\b\u0010j\u001a\u0004\u0018\u00010PH\u0016J \u0010k\u001a\u00020*2\u0006\u0010l\u001a\u00020m2\u0006\u00102\u001a\u00020$2\u0006\u0010n\u001a\u00020\u001dH\u0002J \u0010o\u001a\u00020*2\u0006\u0010+\u001a\u00020\u00022\u0006\u0010p\u001a\u00020\u00062\u0006\u00102\u001a\u00020$H\u0002J&\u0010q\u001a\u00020*2\b\u0010r\u001a\u0004\u0018\u00010\u001d2\b\u0010s\u001a\u0004\u0018\u00010.2\b\u0010t\u001a\u0004\u0018\u00010hH\u0016J \u0010u\u001a\u00020*2\u0006\u0010v\u001a\u00020h2\u0006\u0010w\u001a\u00020x2\u0006\u0010y\u001a\u00020PH\u0002J \u0010z\u001a\u00020*2\u0006\u0010{\u001a\u00020|2\u0006\u00102\u001a\u00020$2\u0006\u00108\u001a\u00020\u0006H\u0002J \u0010}\u001a\u00020*2\u0006\u0010l\u001a\u00020~2\u0006\u00102\u001a\u00020$2\u0006\u00108\u001a\u00020\u0006H\u0002J\"\u0010\u007f\u001a\u00020*2\b\u0010\u0080\u0001\u001a\u00030\u0081\u00012\u0006\u00102\u001a\u00020$2\u0006\u00108\u001a\u00020\u0006H\u0002J#\u0010\u0082\u0001\u001a\u00020*2\b\u0010\u0083\u0001\u001a\u00030\u0084\u00012\u0006\u00102\u001a\u00020$2\u0006\u00108\u001a\u00020\u0006H\u0002J#\u0010\u0085\u0001\u001a\u00020*2\b\u0010\u0086\u0001\u001a\u00030\u0087\u00012\u0006\u00102\u001a\u00020$2\u0006\u00108\u001a\u00020\u0006H\u0002J#\u0010\u0088\u0001\u001a\u00020*2\b\u0010\u0089\u0001\u001a\u00030\u008a\u00012\u0006\u00102\u001a\u00020$2\u0006\u00108\u001a\u00020\u0006H\u0002J#\u0010\u008b\u0001\u001a\u00020*2\b\u0010\u008c\u0001\u001a\u00030\u008d\u00012\u0006\u00102\u001a\u00020$2\u0006\u00108\u001a\u00020\u0006H\u0002J#\u0010\u008e\u0001\u001a\u00020*2\b\u0010\u0083\u0001\u001a\u00030\u008f\u00012\u0006\u00102\u001a\u00020$2\u0006\u00108\u001a\u00020\u0006H\u0002J#\u0010\u0090\u0001\u001a\u00020*2\b\u0010\u0086\u0001\u001a\u00030\u0091\u00012\u0006\u00102\u001a\u00020$2\u0006\u00108\u001a\u00020\u0006H\u0002J#\u0010\u0092\u0001\u001a\u00020*2\b\u0010\u0093\u0001\u001a\u00030\u0094\u00012\u0006\u00102\u001a\u00020$2\u0006\u00108\u001a\u00020\u0006H\u0002J#\u0010\u0095\u0001\u001a\u00020*2\b\u0010\u0096\u0001\u001a\u00030\u0097\u00012\u0006\u00102\u001a\u00020$2\u0006\u00108\u001a\u00020\u0006H\u0002J!\u0010\u0098\u0001\u001a\u00020*2\u0006\u0010l\u001a\u00020m2\u0006\u00102\u001a\u00020$2\u0006\u00108\u001a\u00020\u0006H\u0002J3\u0010\u0099\u0001\u001a\u00020*2\t\u0010\u009a\u0001\u001a\u0004\u0018\u00010h2\u0007\u0010\u009b\u0001\u001a\u00020\u00062\t\u0010\u009c\u0001\u001a\u0004\u0018\u00010$2\t\u0010\u009d\u0001\u001a\u0004\u0018\u00010PH\u0016J\u0013\u0010\u009e\u0001\u001a\u00020*2\b\u0010\u009f\u0001\u001a\u00030\u00a0\u0001H\u0016J\u0011\u0010\u00a1\u0001\u001a\u00020*2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013J\u001f\u0010\u00a2\u0001\u001a\u00020*2\b\u0010j\u001a\u0004\u0018\u00010P2\n\u0010\u00a3\u0001\u001a\u0005\u0018\u00010\u00a4\u0001H\u0016J\u0018\u0010\u00a5\u0001\u001a\u00020*2\u0007\u0010\u00a6\u0001\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dJ\u001c\u0010\u00a7\u0001\u001a\u00020*2\b\u0010\u00a8\u0001\u001a\u00030\u00a9\u00012\u0007\u0010\u00aa\u0001\u001a\u00020=H\u0002J\u001c\u0010\u00ab\u0001\u001a\u00020*2\u0006\u0010v\u001a\u00020h2\t\u0010\u00aa\u0001\u001a\u0004\u0018\u00010=H\u0002J&\u0010\u00ac\u0001\u001a\u00020*2\u0006\u0010v\u001a\u00020h2\t\u0010\u00aa\u0001\u001a\u0004\u0018\u00010=2\b\u0010\u00ad\u0001\u001a\u00030\u00ae\u0001H\u0002J\u001b\u0010\u00af\u0001\u001a\u00020*2\u0007\u0010\u00b0\u0001\u001a\u00020\u001b2\u0007\u0010\u00b1\u0001\u001a\u00020PH\u0016J\u001b\u0010\u00b2\u0001\u001a\u00020*2\u0007\u0010\u00b0\u0001\u001a\u00020\u001b2\u0007\u0010\u00b1\u0001\u001a\u00020PH\u0016J\u0017\u0010\u00b3\u0001\u001a\u00020*2\u000e\u0010%\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010&J\u0016\u0010\u00b4\u0001\u001a\u00020*2\r\u0010\u00b5\u0001\u001a\b\u0012\u0004\u0012\u00020$0&J\u001e\u0010\u00b6\u0001\u001a\u00020*2\b\u00102\u001a\u0004\u0018\u00010$2\t\u0010\u00b7\u0001\u001a\u0004\u0018\u00010PH\u0016J!\u0010\u00b8\u0001\u001a\u00020*2\u0006\u0010+\u001a\u00020\u00022\u0006\u00102\u001a\u00020$2\u0006\u0010M\u001a\u00020NH\u0002J\u0019\u0010\u00b9\u0001\u001a\u00020*2\b\u0010\u00ba\u0001\u001a\u00030\u00bb\u00012\u0006\u00100\u001a\u00020$J\u0019\u0010\u00bc\u0001\u001a\u00020*2\u0006\u0010+\u001a\u00020\u00022\u0006\u00108\u001a\u00020\u0006H\u0002JC\u0010\u00bd\u0001\u001a\u00020*2\u0006\u00102\u001a\u00020$2\u0006\u0010+\u001a\u00020\u00022\u0006\u00108\u001a\u00020\u00062\u0006\u0010d\u001a\u00020P2\u0007\u0010\u00be\u0001\u001a\u00020f2\u0006\u0010g\u001a\u00020h2\u0007\u0010\u00bf\u0001\u001a\u00020\u001bH\u0002J!\u0010\u00c0\u0001\u001a\u00020*2\u0006\u0010\\\u001a\u00020.2\u0006\u00100\u001a\u00020$2\u0006\u00108\u001a\u00020\u0006H\u0002J,\u0010\u00c1\u0001\u001a\u00020*2\u0006\u0010Y\u001a\u00020.2\t\u0010\u00c2\u0001\u001a\u0004\u0018\u00010.2\u0006\u0010^\u001a\u00020.2\u0006\u00100\u001a\u00020$H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\"\u001a\b\u0012\u0004\u0012\u00020$0#X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010%\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010&X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\'\u001a\u0004\u0018\u00010(X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u00c3\u0001"}, d2 = {"Lcom/contusfly/starredMessages/adapter/StarredMessagesAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/contusfly/interfaces/MessageItemListener;", "()V", "RECEIVER_HEADER", "", "SENDER_HEADER", "chatAdapterHelper", "Lcom/contusfly/adapters/ChatAdapterHelper;", "chatStarredMessageUtils", "Lcom/contusfly/utils/ChatMessageUtils;", "context", "Landroid/content/Context;", "fileItemView", "Lcom/contusfly/adapters/viewhelpers/FileItemView;", "inflater", "Landroid/view/LayoutInflater;", "listener", "Lcom/contusfly/interfaces/OnChatItemClickListener;", "mMediaController", "Lcom/contusfly/chat/MediaController;", "mediaDetailUtils", "Lcom/contusfly/utils/MediaDetailUtils;", "replyViewUtils", "Lcom/contusfly/chat/reply/ReplyViewUtils;", "searchEnabled", "", "searchKey", "", "starredAudioItemView", "Lcom/contusfly/adapters/viewhelpers/AudioItemView;", "starredImageItemViewHelper", "Lcom/contusfly/adapters/viewhelpers/ImageItemViewHelper;", "starredMessageData", "", "Lcom/mirrorflysdk/api/models/ChatMessage;", "starredMessageMessages", "", "starredVideoItemViewHelper", "Lcom/contusfly/adapters/viewhelpers/VideoItemViewHelper;", "check", "", "holder", "downloadClick", "download", "Landroid/view/View;", "cancelDownload", "messageItem", "getChatMsgTime", "item", "getHtmlStarredMessageText", "message", "getItemCount", "getItemId", "", "position", "getItemViewType", "getMessageDate", "getMessages", "getSpannedText", "Landroid/text/Spanned;", "getStarredAudioViewReceiver", "getStarredAudioViewSender", "getStarredContactViewReceiver", "getStarredContactViewSender", "getStarredFileViewReceiver", "getStarredFileViewSender", "getStarredImageViewReceiver", "getStarredImageViewSender", "getStarredLocationViewReceiver", "getStarredLocationViewSender", "getStarredTextViewReceiver", "getStarredTextViewSender", "getStarredVideoViewReceiver", "getStarredVideoViewSender", "loadUserProfileImage", "profileDetails", "Lcom/mirrorflysdk/api/contacts/ProfileDetails;", "imgView", "Landroid/widget/ImageView;", "errorImg", "Landroid/graphics/drawable/Drawable;", "onBindViewHolder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "receiverDownloadClick", "retry", "txtSize", "receiverItemClick", "receiverItem", "senderDownloadClick", "cancelUpload", "carbonDownloadView", "senderItemClick", "senderItem", "setAdapterData", "setAudioSeekBarListener", "playImage", "starredMsgSeekBar", "Landroid/widget/SeekBar;", "durationView", "Landroid/widget/TextView;", "setChatStatus", "viewHolder", "setFileSenderView", "fileViewHolder", "Lcom/contusfly/adapters/holders/FileSentViewHolder;", "time", "setHeader", "type", "setImageViewSize", "starredFileSize", "downloadView", "starredFileSizeView", "setJoinLinkView", "txtChat", "joinLinkView", "Landroid/widget/LinearLayout;", "joinLinkLogo", "setListenersForAudioMessages", "audioViewHolder", "Lcom/contusfly/adapters/holders/AudioSentViewHolder;", "setListenersForReceivedFileMessages", "Lcom/contusfly/adapters/holders/FileReceivedViewHolder;", "setListenersForReceiverAudioMessages", "audioReceiverViewHolder", "Lcom/contusfly/adapters/holders/AudioReceivedViewHolder;", "setListenersForReceiverImageMessages", "imgViewHolder", "Lcom/contusfly/adapters/holders/ImageReceivedViewHolder;", "setListenersForReceiverLocationMessages", "locationHolder", "Lcom/contusfly/adapters/holders/LocationReceivedViewHolder;", "setListenersForReceiverTextMessages", "txtReceiverViewHolder", "Lcom/contusfly/adapters/holders/TextReceivedViewHolder;", "setListenersForReceiverVideoMessages", "videoReceiverViewHolder", "Lcom/contusfly/adapters/holders/VideoReceivedViewHolder;", "setListenersForSenderImageMessages", "Lcom/contusfly/adapters/holders/ImageSentViewHolder;", "setListenersForSenderLocationMessages", "Lcom/contusfly/adapters/holders/LocationSentViewHolder;", "setListenersForSenderTextMessages", "txtSenderViewHolder", "Lcom/contusfly/adapters/holders/TextSentViewHolder;", "setListenersForSenderVideoMessages", "videoSenderViewHolder", "Lcom/contusfly/adapters/holders/VideoSentViewHolder;", "setListenersForSentFileMessages", "setMediaDuration", "txtSendDuration", "fileStatus", "starredMessageItem", "imgChatType", "setMediaStatus", "mediaStatus", "Lcom/contusfly/models/MediaStatus;", "setOnStarredMessageDownloadClickListener", "setRecentChatStatus", "status", "Lcom/mirrorflysdk/api/MessageStatus;", "setSearch", "isSearchEnabled", "setSearchHighlightAppCompatTextView", "txtSendName", "Landroidx/appcompat/widget/AppCompatTextView;", "fromHtml", "setSearchTextHighlight", "setSearchTextHighlightMention", "mentionedUserName", "Landroid/text/SpannableStringBuilder;", "setStaredStatus", "isStarred", "imageView", "setStarredCaptionStatus", "setStarredMessageMessages", "setStarredMessages", "starredMessages", "setStatus", "imgChatStatus", "setupReceiverHeader", "showHideSenderName", "senderNameHolder", "Lcom/contusfly/adapters/holders/SenderNameHolder;", "showSenderNameIfGroupChat", "starredAudioPlayClick", "seekBar", "doesSentMessage", "starredItemClick", "uploadClick", "carbonRetry", "app_debug"})
public final class StarredMessagesAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<androidx.recyclerview.widget.RecyclerView.ViewHolder> implements com.contusfly.interfaces.MessageItemListener {
    private final int SENDER_HEADER = 1;
    private final int RECEIVER_HEADER = 2;
    
    /**
     * Text reply view utils
     */
    private com.contusfly.chat.reply.ReplyViewUtils replyViewUtils;
    
    /**
     * object holds file view item details
     */
    private com.contusfly.adapters.viewhelpers.FileItemView fileItemView;
    
    /**
     * The listener instance of OnChatItemClickListener
     */
    private com.contusfly.interfaces.OnChatItemClickListener listener;
    
    /**
     * The list of chat data
     */
    private java.util.List<com.mirrorflysdk.api.models.ChatMessage> starredMessageData;
    
    /**
     * The media controller which used to play the audio in the chat view
     */
    private com.contusfly.chat.MediaController mMediaController;
    
    /**
     * The startupActivityContext of the list view activity
     */
    private android.content.Context context;
    
    /**
     * Chat message common methods will be available here
     */
    private com.contusfly.utils.ChatMessageUtils chatStarredMessageUtils;
    
    /**
     * Store the selected messages in the long press
     */
    private java.util.List<java.lang.String> starredMessageMessages;
    private com.contusfly.adapters.ChatAdapterHelper chatAdapterHelper;
    
    /**
     * Media details
     */
    private com.contusfly.utils.MediaDetailUtils mediaDetailUtils;
    
    /**
     * Image item view
     */
    private com.contusfly.adapters.viewhelpers.ImageItemViewHelper starredImageItemViewHelper;
    
    /**
     * Helper class for video item view
     */
    private com.contusfly.adapters.viewhelpers.VideoItemViewHelper starredVideoItemViewHelper;
    
    /**
     * Audio item view
     */
    private com.contusfly.adapters.viewhelpers.AudioItemView starredAudioItemView;
    private android.view.LayoutInflater inflater;
    private boolean searchEnabled = false;
    private java.lang.String searchKey;
    
    public StarredMessagesAdapter() {
        super();
    }
    
    /**
     * Instantiates a new adapter chat data.
     *
     * @param context The startupActivityContext of the activity
     */
    public final void setAdapterData(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
    }
    
    public final void setSearch(boolean isSearchEnabled, @org.jetbrains.annotations.NotNull()
    java.lang.String searchKey) {
    }
    
    /**
     * Sets the on download click listener.
     *
     * @param listener The listener when the chat item download clicked
     */
    public final void setOnStarredMessageDownloadClickListener(@org.jetbrains.annotations.Nullable()
    com.contusfly.interfaces.OnChatItemClickListener listener) {
    }
    
    /**
     * Sets the Chat Messages in the adapter.
     *
     * @param starredMessages List of chat messages
     */
    public final void setStarredMessages(@org.jetbrains.annotations.NotNull()
    java.util.List<? extends com.mirrorflysdk.api.models.ChatMessage> starredMessages) {
    }
    
    /**
     * Set the selected messages from the chat view for displaying the different color
     *
     * @param starredMessageMessages Selected message list
     */
    public final void setStarredMessageMessages(@org.jetbrains.annotations.Nullable()
    java.util.List<java.lang.String> starredMessageMessages) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public androidx.recyclerview.widget.RecyclerView.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    androidx.recyclerview.widget.RecyclerView.ViewHolder holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemViewType(int position) {
        return 0;
    }
    
    @java.lang.Override()
    public long getItemId(int position) {
        return 0L;
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    /**
     * Show/Hides sender name if the chat is group chat
     *
     * @param holder   view holder of the item
     * @param position position of the item
     */
    private final void showSenderNameIfGroupChat(androidx.recyclerview.widget.RecyclerView.ViewHolder holder, int position) {
    }
    
    public final void showHideSenderName(@org.jetbrains.annotations.NotNull()
    com.contusfly.adapters.holders.SenderNameHolder senderNameHolder, @org.jetbrains.annotations.NotNull()
    com.mirrorflysdk.api.models.ChatMessage messageItem) {
    }
    
    /**
     * Gets the text view.
     *
     * @param holder   Holder of the text view
     * @param item     Instance of the Message
     * @param position Position of the list item
     */
    private final void getStarredTextViewSender(androidx.recyclerview.widget.RecyclerView.ViewHolder holder, com.mirrorflysdk.api.models.ChatMessage item, int position) {
    }
    
    private final void setJoinLinkView(android.widget.TextView txtChat, android.widget.LinearLayout joinLinkView, android.widget.ImageView joinLinkLogo) {
    }
    
    /**
     * starred textview for receiver side
     *
     * @param holder   adapter viewholder object
     * @param item     object which hold item data
     * @param position of the item
     */
    private final void getStarredTextViewReceiver(androidx.recyclerview.widget.RecyclerView.ViewHolder holder, com.mirrorflysdk.api.models.ChatMessage item, int position) {
    }
    
    private final void setSearchTextHighlight(android.widget.TextView txtChat, android.text.Spanned fromHtml) {
    }
    
    private final void setSearchTextHighlightMention(android.widget.TextView txtChat, android.text.Spanned fromHtml, android.text.SpannableStringBuilder mentionedUserName) {
    }
    
    /**
     * Get the image view for the adapter
     *
     * @param holder      Holder of the recycler view
     * @param messageItem Message item contains message data
     * @param position    List item position
     */
    private final void getStarredImageViewSender(androidx.recyclerview.widget.RecyclerView.ViewHolder holder, com.mirrorflysdk.api.models.ChatMessage messageItem, int position) {
    }
    
    /**
     * starred imageview for receiver side
     *
     * @param holder      adapter viewholder object
     * @param messageItem object which hold item data
     * @param position    of the item
     */
    private final void getStarredImageViewReceiver(androidx.recyclerview.widget.RecyclerView.ViewHolder holder, com.mirrorflysdk.api.models.ChatMessage messageItem, int position) {
    }
    
    /**
     * starred videoview for sender side
     *
     * @param holder      adapter viewholder object
     * @param messageItem object which hold item data
     * @param position    of the item
     */
    private final void getStarredVideoViewSender(androidx.recyclerview.widget.RecyclerView.ViewHolder holder, com.mirrorflysdk.api.models.ChatMessage messageItem, int position) {
    }
    
    /**
     * starred videoview for receiver side
     *
     * @param holder      adapter viewholder object
     * @param messageItem object which hold item data
     * @param position    of the item
     */
    private final void getStarredVideoViewReceiver(androidx.recyclerview.widget.RecyclerView.ViewHolder holder, com.mirrorflysdk.api.models.ChatMessage messageItem, int position) {
    }
    
    /**
     * Gets the location view to display the map
     *
     * @param holder        Holder of the recycler view
     * @param item          Message item contains message data
     * @param position      List item position
     */
    private final void getStarredLocationViewSender(androidx.recyclerview.widget.RecyclerView.ViewHolder holder, com.mirrorflysdk.api.models.ChatMessage item, int position) {
    }
    
    /**
     * Gets the location view to display the map in receiver side
     *
     * @param holder        Holder of the recycler view
     * @param item          Message item contains message data
     * @param position      List item position
     */
    private final void getStarredLocationViewReceiver(androidx.recyclerview.widget.RecyclerView.ViewHolder holder, com.mirrorflysdk.api.models.ChatMessage item, int position) {
    }
    
    /**
     * Create the audio view based on the Message data
     *
     * @param holder   Holder of the recycler view
     * @param item     Message item contains message data
     * @param position List item position
     */
    private final void getStarredAudioViewSender(androidx.recyclerview.widget.RecyclerView.ViewHolder holder, com.mirrorflysdk.api.models.ChatMessage item, int position) {
    }
    
    /**
     * Create the audio view based on the Message data in receiver side
     *
     * @param holder   Holder of the recycler view
     * @param item     Message item contains message data
     * @param position List item position
     */
    private final void getStarredAudioViewReceiver(androidx.recyclerview.widget.RecyclerView.ViewHolder holder, com.mirrorflysdk.api.models.ChatMessage item, int position) {
    }
    
    /**
     * Handle the file view to display the file on sender view or receiver view with type of file in the chat view.
     *
     * @param holder   Holder of the recycler view
     * @param item     Message item contains message data
     * @param position List item position
     */
    private final void getStarredFileViewSender(androidx.recyclerview.widget.RecyclerView.ViewHolder holder, com.mirrorflysdk.api.models.ChatMessage item, int position) {
    }
    
    /**
     * Handle the file view to display the file on receiver view with type of file in the chat view.
     *
     * @param holder   Holder of the recycler view
     * @param item     Message item contains message data
     * @param position List item position
     */
    private final void getStarredFileViewReceiver(androidx.recyclerview.widget.RecyclerView.ViewHolder holder, com.mirrorflysdk.api.models.ChatMessage item, int position) {
    }
    
    /**
     * Create the contact view based on the Message data
     *
     * @param holder        Holder of the recycler view
     * @param item          Message item contains message data
     * @param position      List item position
     */
    private final void getStarredContactViewSender(androidx.recyclerview.widget.RecyclerView.ViewHolder holder, com.mirrorflysdk.api.models.ChatMessage item, int position) {
    }
    
    private final void setSearchHighlightAppCompatTextView(androidx.appcompat.widget.AppCompatTextView txtSendName, android.text.Spanned fromHtml) {
    }
    
    /**
     * Create the contact view based on the Message data in receiver side.
     *
     * @param holder        Holder of the recycler view
     * @param item          Message item contains message data
     * @param position      List item position
     */
    private final void getStarredContactViewReceiver(androidx.recyclerview.widget.RecyclerView.ViewHolder holder, com.mirrorflysdk.api.models.ChatMessage item, int position) {
    }
    
    /**
     * This sets the header view for the starred message
     *
     * @param holder item holder
     * @param type   sender or receiver
     * @param item   message item
     */
    private final void setHeader(androidx.recyclerview.widget.RecyclerView.ViewHolder holder, int type, com.mirrorflysdk.api.models.ChatMessage item) {
    }
    
    private final void setupReceiverHeader(androidx.recyclerview.widget.RecyclerView.ViewHolder holder, com.mirrorflysdk.api.models.ChatMessage item, com.mirrorflysdk.api.contacts.ProfileDetails profileDetails) {
    }
    
    private final void loadUserProfileImage(android.content.Context context, com.mirrorflysdk.api.contacts.ProfileDetails profileDetails, android.widget.ImageView imgView, android.graphics.drawable.Drawable errorImg) {
    }
    
    /**
     * Checking the contact type to make email icon visible and invisible
     *
     * @param holder     item holder
     */
    private final void check(androidx.recyclerview.widget.RecyclerView.ViewHolder holder) {
    }
    
    /**
     * This method is used to get the message sent time
     *
     * @param item messsage item
     * @return time
     */
    private final java.lang.String getChatMsgTime(com.mirrorflysdk.api.models.ChatMessage item) {
        return null;
    }
    
    /**
     * Returns Spanned string by adding HTML empty text to avoid overlap with time view in FrameLayout
     *
     * @param message Message content
     * @return Spanned Result spanned text with space
     */
    private final java.lang.String getHtmlStarredMessageText(java.lang.String message) {
        return null;
    }
    
    /**
     * Converts message to a valid spanned text
     *
     * @param message message date which is sent/received
     */
    private final android.text.Spanned getSpannedText(java.lang.String message) {
        return null;
    }
    
    /**
     * Starred message item click handler
     *
     * @param receiverItem Receiver item view
     * @param messageItem  Received message Item
     * @param position     Position of message
     */
    private final void starredItemClick(android.view.View receiverItem, com.mirrorflysdk.api.models.ChatMessage messageItem, int position) {
    }
    
    /**
     * set Listeners For Sender Side TextView
     *
     * @param txtSenderViewHolder holder object
     * @param item                object which hold data to display
     * @param position            list item position
     */
    private final void setListenersForSenderTextMessages(com.contusfly.adapters.holders.TextSentViewHolder txtSenderViewHolder, com.mirrorflysdk.api.models.ChatMessage item, int position) {
    }
    
    /**
     * set single & long click Listeners For Sender Side conversation
     *
     * @param senderItem  sender view in conversation
     * @param messageItem object which hold data to display
     * @param position    list item position
     */
    private final void senderItemClick(android.view.View senderItem, com.mirrorflysdk.api.models.ChatMessage messageItem, int position) {
    }
    
    /**
     * set Listeners For Receiver Side TextView
     *
     * @param txtReceiverViewHolder holder object
     * @param item                  object which hold data to display
     * @param position              list item position
     */
    private final void setListenersForReceiverTextMessages(com.contusfly.adapters.holders.TextReceivedViewHolder txtReceiverViewHolder, com.mirrorflysdk.api.models.ChatMessage item, int position) {
    }
    
    /**
     * set single & long click Listeners For Receiver Side conversation
     *
     * @param receiverItem sender view in conversation
     * @param messageItem  object which hold data to display
     * @param position     list item position
     */
    private final void receiverItemClick(android.view.View receiverItem, com.mirrorflysdk.api.models.ChatMessage messageItem, int position) {
    }
    
    /**
     * Handle the audio play click
     *
     * @param filePath        Local path of the audio
     * @param duration        Local file duration
     * @param position        Position of the chat item
     * @param playImage       Play button of the audio view
     * @param seekBar         Seek bar of the audio
     * @param durationView    Duration text view
     * @param doesSentMessage Boolean to identify whether the audio message is posted in the chat activity.
     */
    private final void starredAudioPlayClick(com.mirrorflysdk.api.models.ChatMessage item, androidx.recyclerview.widget.RecyclerView.ViewHolder holder, int position, android.widget.ImageView playImage, android.widget.SeekBar seekBar, android.widget.TextView durationView, boolean doesSentMessage) {
    }
    
    /**
     * Handle the audio seekbar click
     *
     * @param item            Message Item data
     * @param holder          View holder of current view in adapter
     * @param playImage       Play button of the audio view
     * @param SeekBar         Seek bar of the audio
     * @param doesSentMessage Boolean to identify whether the audio message is posted in the
     * @param durationView to set  duration in the audio
     */
    private final void setAudioSeekBarListener(com.mirrorflysdk.api.models.ChatMessage item, androidx.recyclerview.widget.RecyclerView.ViewHolder holder, android.widget.ImageView playImage, android.widget.SeekBar starredMsgSeekBar, android.widget.TextView durationView) {
    }
    
    @java.lang.Override()
    public void setChatStatus(@org.jetbrains.annotations.Nullable()
    com.mirrorflysdk.api.models.ChatMessage item, @org.jetbrains.annotations.Nullable()
    android.widget.ImageView viewHolder) {
    }
    
    @java.lang.Override()
    public void setRecentChatStatus(@org.jetbrains.annotations.Nullable()
    android.widget.ImageView viewHolder, @org.jetbrains.annotations.Nullable()
    com.mirrorflysdk.api.MessageStatus status) {
    }
    
    @java.lang.Override()
    public void setMediaStatus(@org.jetbrains.annotations.NotNull()
    com.contusfly.models.MediaStatus mediaStatus) {
    }
    
    @java.lang.Override()
    public void setMediaDuration(@org.jetbrains.annotations.Nullable()
    android.widget.TextView txtSendDuration, int fileStatus, @org.jetbrains.annotations.Nullable()
    com.mirrorflysdk.api.models.ChatMessage starredMessageItem, @org.jetbrains.annotations.Nullable()
    android.widget.ImageView imgChatType) {
    }
    
    @java.lang.Override()
    public void setImageViewSize(@org.jetbrains.annotations.Nullable()
    java.lang.String starredFileSize, @org.jetbrains.annotations.Nullable()
    android.view.View downloadView, @org.jetbrains.annotations.Nullable()
    android.widget.TextView starredFileSizeView) {
    }
    
    @java.lang.Override()
    public void setStatus(@org.jetbrains.annotations.Nullable()
    com.mirrorflysdk.api.models.ChatMessage item, @org.jetbrains.annotations.Nullable()
    android.widget.ImageView imgChatStatus) {
    }
    
    /**
     * Gets the chat messages.
     *
     * @return List<Message> List of messages
     *   </Message>
     */
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.mirrorflysdk.api.models.ChatMessage> getMessages() {
        return null;
    }
    
    /**
     * This function is used to manipulate the message date
     *
     * @param item message item
     * @return formatted date as string
     */
    @android.annotation.SuppressLint(value = {"SimpleDateFormat"})
    private final java.lang.String getMessageDate(com.mirrorflysdk.api.models.ChatMessage item) {
        return null;
    }
    
    private final void setListenersForSenderImageMessages(com.contusfly.adapters.holders.ImageSentViewHolder imgViewHolder, com.mirrorflysdk.api.models.ChatMessage item, int position) {
    }
    
    /**
     * Sets the listener to the child views present in the parent view.
     *
     * @param imgViewHolder The view holding the child items.
     * @param item          The data set used to render the content of child views.
     * @param position      The position of the item within the adapter's data set.
     */
    private final void setListenersForReceiverImageMessages(com.contusfly.adapters.holders.ImageReceivedViewHolder imgViewHolder, com.mirrorflysdk.api.models.ChatMessage item, int position) {
    }
    
    /**
     * Register a callback to be invoked when this view is clicked. If this view is not clickable, it becomes clickable.
     *
     * @param download       The download view placed in the ViewHolder.
     * @param retry          The retry view placed in the ViewHolder.
     * @param cancelDownload The cancel download view placed in the ViewHolder.
     * @param messageItem    The message object which possess the data rendered in the ViewHolder.
     */
    private final void receiverDownloadClick(android.view.View download, android.view.View retry, android.view.View cancelDownload, com.mirrorflysdk.api.models.ChatMessage messageItem, android.view.View txtSize) {
    }
    
    /**
     * Sets the listener to the child views present in the parent view.
     *
     * @param videoSenderViewHolder The view holding the child items.
     * @param item                  The data set used to render the content of child views.
     * @param position              The position of the item within the adapter's data set.
     */
    private final void setListenersForSenderVideoMessages(com.contusfly.adapters.holders.VideoSentViewHolder videoSenderViewHolder, com.mirrorflysdk.api.models.ChatMessage item, int position) {
    }
    
    /**
     * Register a callback to be invoked when this view is clicked. If this view is not clickable, it becomes clickable.
     *
     * @param retry              The retry view placed in the ViewHolder.
     * @param cancelUpload       The cancel upload view placed in the ViewHolder.
     * @param messageItem        The message object which possess the data rendered in the
     * ViewHolder.
     * @param carbonDownloadView The carbon download view placed in the ViewHolder.
     */
    private final void senderDownloadClick(android.view.View retry, android.view.View cancelUpload, com.mirrorflysdk.api.models.ChatMessage messageItem, android.view.View carbonDownloadView) {
    }
    
    /**
     * Sets the listener to the child views present in the parent view.
     *
     * @param videoReceiverViewHolder The view holding the child items.
     * @param item                    The data set used to render the content of child views.
     * @param position                The position of the item within the adapter's data set.
     */
    private final void setListenersForReceiverVideoMessages(com.contusfly.adapters.holders.VideoReceivedViewHolder videoReceiverViewHolder, com.mirrorflysdk.api.models.ChatMessage item, int position) {
    }
    
    /**
     * Sets the listener to the child views present in the parent view.
     *
     * @param locationHolder The view holding the child items.
     * @param item           The data set used to render the content of child views.
     * @param position       The position of the item within the adapter's data set.
     */
    private final void setListenersForReceiverLocationMessages(com.contusfly.adapters.holders.LocationReceivedViewHolder locationHolder, com.mirrorflysdk.api.models.ChatMessage item, int position) {
    }
    
    /**
     * Sets the listener to the child views present in the parent view.
     *
     * @param locationHolder The view holding the child items.
     * @param item           The data set used to render the content of child views.
     * @param position       The position of the item within the adapter's data set.
     */
    private final void setListenersForSenderLocationMessages(com.contusfly.adapters.holders.LocationSentViewHolder locationHolder, com.mirrorflysdk.api.models.ChatMessage item, int position) {
    }
    
    /**
     * Sets the listener to the child views present in the parent view.
     *
     * @param audioViewHolder The view holding the child items.
     * @param item            The data set used to render the content of child views.
     * @param position        The position of the item within the adapter's data set.
     */
    private final void setListenersForAudioMessages(com.contusfly.adapters.holders.AudioSentViewHolder audioViewHolder, com.mirrorflysdk.api.models.ChatMessage item, int position) {
    }
    
    /**
     * Register a callback to be invoked when this view is clicked. If this view is not clickable, it becomes clickable.
     *
     * @param retry        The retry view placed in the ViewHolder.
     * @param cancelUpload The cancel upload view placed in the ViewHolder.
     * @param messageItem  The message object which possess the data rendered in the ViewHolder.
     */
    private final void uploadClick(android.view.View retry, android.view.View carbonRetry, android.view.View cancelUpload, com.mirrorflysdk.api.models.ChatMessage messageItem) {
    }
    
    /**
     * Sets the listener to the child views present in the parent view.
     *
     * @param audioReceiverViewHolder The view holding the child items.
     * @param item                    The data set used to render the content of child views.
     * @param position                The position of the item within the adapter's data set.
     */
    private final void setListenersForReceiverAudioMessages(com.contusfly.adapters.holders.AudioReceivedViewHolder audioReceiverViewHolder, com.mirrorflysdk.api.models.ChatMessage item, int position) {
    }
    
    /**
     * Register a callback to be invoked when this view is clicked. If this view is not clickable, it becomes clickable.
     *
     * @param download       The download view placed in the ViewHolder.
     * @param cancelDownload The cancel download view placed in the ViewHolder.
     * @param messageItem    The message object which possess the data rendered in the ViewHolder.
     */
    private final void downloadClick(android.view.View download, android.view.View cancelDownload, com.mirrorflysdk.api.models.ChatMessage messageItem) {
    }
    
    /**
     * Sets the sender view for the file type chat messages.
     *
     * @param fileViewHolder the holder containing the view item.
     * @param item           the message object comprising the file information.
     * @param time           the time at which the message has been sent.
     */
    private final void setFileSenderView(com.contusfly.adapters.holders.FileSentViewHolder fileViewHolder, com.mirrorflysdk.api.models.ChatMessage item, java.lang.String time) {
    }
    
    /**
     * Sets the listener to the child views present in the parent view.
     *
     * @param fileViewHolder The view holding the child items.
     * @param item           The data set used to render the content of child views.
     * @param position       The position of the item within the adapter's data set.
     */
    private final void setListenersForSentFileMessages(com.contusfly.adapters.holders.FileSentViewHolder fileViewHolder, com.mirrorflysdk.api.models.ChatMessage item, int position) {
    }
    
    /**
     * Sets the listener to the child views present in the parent view.
     *
     * @param fileViewHolder The view holding the child items.
     * @param item           The data set used to render the content of child views.
     * @param position       The position of the item within the adapter's data set.
     */
    private final void setListenersForReceivedFileMessages(com.contusfly.adapters.holders.FileReceivedViewHolder fileViewHolder, com.mirrorflysdk.api.models.ChatMessage item, int position) {
    }
    
    @java.lang.Override()
    public void setStaredStatus(boolean isStarred, @org.jetbrains.annotations.NotNull()
    android.widget.ImageView imageView) {
    }
    
    @java.lang.Override()
    public void setStarredCaptionStatus(boolean isStarred, @org.jetbrains.annotations.NotNull()
    android.widget.ImageView imageView) {
    }
}