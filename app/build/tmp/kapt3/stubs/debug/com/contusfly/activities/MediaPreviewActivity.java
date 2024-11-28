package com.contusfly.activities;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u00ea\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0017\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u0007B\u0005\u00a2\u0006\u0002\u0010\bJ\n\u0010\u008f\u0001\u001a\u00030\u0090\u0001H\u0002J\n\u0010\u0091\u0001\u001a\u00030\u0090\u0001H\u0002J\u001c\u0010\u0092\u0001\u001a\u00030\u0090\u00012\b\u0010\u0093\u0001\u001a\u00030\u0085\u00012\b\u0010\u0094\u0001\u001a\u00030\u0095\u0001J\n\u0010\u0096\u0001\u001a\u00030\u0090\u0001H\u0002J\u0014\u0010\u0097\u0001\u001a\u00030\u0090\u00012\b\u0010\u0098\u0001\u001a\u00030\u0083\u0001H\u0002J\n\u0010\u0099\u0001\u001a\u00030\u0090\u0001H\u0002J\n\u0010\u009a\u0001\u001a\u00030\u0090\u0001H\u0002J\n\u0010\u009b\u0001\u001a\u00030\u009c\u0001H\u0002J\u0013\u0010\u009d\u0001\u001a\u00030\u0090\u00012\u0007\u0010\u0081\u0001\u001a\u00020&H\u0002J\n\u0010\u009e\u0001\u001a\u00030\u0090\u0001H\u0002J\n\u0010\u009f\u0001\u001a\u00030\u0090\u0001H\u0002J\n\u0010\u00a0\u0001\u001a\u00030\u0090\u0001H\u0002J\n\u0010\u00a1\u0001\u001a\u00030\u0090\u0001H\u0002J\n\u0010\u00a2\u0001\u001a\u00030\u0090\u0001H\u0002J\n\u0010\u00a3\u0001\u001a\u00030\u0090\u0001H\u0002J\n\u0010\u00a4\u0001\u001a\u00030\u0090\u0001H\u0002J\n\u0010\u00a5\u0001\u001a\u00030\u0090\u0001H\u0002J\n\u0010\u00a6\u0001\u001a\u00030\u0090\u0001H\u0002J\n\u0010\u00a7\u0001\u001a\u00030\u0090\u0001H\u0002JG\u0010\u00a8\u0001\u001a\u00030\u0090\u00012\u0019\u0010\u00a9\u0001\u001a\u0014\u0012\u0005\u0012\u00030\u00aa\u000104j\t\u0012\u0005\u0012\u00030\u00aa\u0001`u2\u0007\u0010\u0081\u0001\u001a\u00020&2\u0017\u0010\u00ab\u0001\u001a\u0012\u0012\u0004\u0012\u00020&04j\b\u0012\u0004\u0012\u00020&`uH\u0002J\u0013\u0010\u00ac\u0001\u001a\u00030\u0090\u00012\u0007\u0010\u00ad\u0001\u001a\u00020$H\u0002J\n\u0010\u00ae\u0001\u001a\u00030\u0090\u0001H\u0002J\n\u0010\u00af\u0001\u001a\u00030\u0090\u0001H\u0002J\n\u0010\u00b0\u0001\u001a\u00030\u0090\u0001H\u0002J\n\u0010\u00b1\u0001\u001a\u00030\u0090\u0001H\u0002J\n\u0010\u00b2\u0001\u001a\u00030\u0090\u0001H\u0016J\u0014\u0010\u00b3\u0001\u001a\u00030\u0090\u00012\b\u0010\u00b4\u0001\u001a\u00030\u00b5\u0001H\u0016J\u0016\u0010\u00b6\u0001\u001a\u00030\u0090\u00012\n\u0010\u00b7\u0001\u001a\u0005\u0018\u00010\u00b8\u0001H\u0014J\n\u0010\u00b9\u0001\u001a\u00030\u0090\u0001H\u0014J\u0016\u0010\u00ba\u0001\u001a\u00030\u0090\u00012\n\u0010\u00b4\u0001\u001a\u0005\u0018\u00010\u00b5\u0001H\u0016J\u0014\u0010\u00bb\u0001\u001a\u00030\u0090\u00012\b\u0010\u00bc\u0001\u001a\u00030\u00bd\u0001H\u0016J\u001f\u0010\u00be\u0001\u001a\u00030\u0090\u00012\n\u0010\u00bf\u0001\u001a\u0005\u0018\u00010\u00b5\u00012\u0007\u0010\u00ad\u0001\u001a\u00020$H\u0016J\u0013\u0010\u00c0\u0001\u001a\u00030\u0090\u00012\u0007\u0010\u00c1\u0001\u001a\u00020\nH\u0002J\u0016\u0010\u00c2\u0001\u001a\u00030\u0090\u00012\n\u0010\u00c3\u0001\u001a\u0005\u0018\u00010\u00c4\u0001H\u0007J\u0013\u0010\u00c5\u0001\u001a\u00030\u0090\u00012\u0007\u0010\u00c6\u0001\u001a\u00020$H\u0016J&\u0010\u00c7\u0001\u001a\u00030\u0090\u00012\u0007\u0010\u00ad\u0001\u001a\u00020$2\b\u0010\u00c8\u0001\u001a\u00030\u00c9\u00012\u0007\u0010\u00ca\u0001\u001a\u00020$H\u0016J\u0013\u0010\u00cb\u0001\u001a\u00030\u0090\u00012\u0007\u0010\u00ad\u0001\u001a\u00020$H\u0016J\n\u0010\u00cc\u0001\u001a\u00030\u0090\u0001H\u0014J\u0016\u0010\u00cd\u0001\u001a\u00030\u0090\u00012\n\u0010\u00b7\u0001\u001a\u0005\u0018\u00010\u00b8\u0001H\u0014J\n\u0010\u00ce\u0001\u001a\u00030\u0090\u0001H\u0014J\n\u0010\u00cf\u0001\u001a\u00030\u0090\u0001H\u0016J\n\u0010\u00d0\u0001\u001a\u00030\u0090\u0001H\u0016J\u0014\u0010\u00d1\u0001\u001a\u00030\u0090\u00012\b\u0010\u00d2\u0001\u001a\u00030\u00d3\u0001H\u0016J\n\u0010\u00d4\u0001\u001a\u00030\u0090\u0001H\u0002J\n\u0010\u00d5\u0001\u001a\u00030\u0090\u0001H\u0002J\n\u0010\u00d6\u0001\u001a\u00030\u0090\u0001H\u0002J\n\u0010\u00d7\u0001\u001a\u00030\u0090\u0001H\u0002JS\u0010\u00d8\u0001\u001a\u00030\u0090\u00012\n\u0010\u00d9\u0001\u001a\u0005\u0018\u00010\u00da\u00012\u0019\u0010\u00a9\u0001\u001a\u0014\u0012\u0005\u0012\u00030\u00aa\u000104j\t\u0012\u0005\u0012\u00030\u00aa\u0001`u2\u0007\u0010\u0081\u0001\u001a\u00020&2\u0017\u0010\u00ab\u0001\u001a\u0012\u0012\u0004\u0012\u00020&04j\b\u0012\u0004\u0012\u00020&`uH\u0002J\u001c\u0010\u00db\u0001\u001a\u00030\u0090\u00012\u0007\u0010\u0081\u0001\u001a\u00020&2\u0007\u0010\u00dc\u0001\u001a\u00020&H\u0002J\n\u0010\u00dd\u0001\u001a\u00030\u0090\u0001H\u0002J\n\u0010\u00de\u0001\u001a\u00030\u0090\u0001H\u0002J\b\u0010\u00df\u0001\u001a\u00030\u0090\u0001J\n\u0010\u00e0\u0001\u001a\u00030\u0090\u0001H\u0002J\u0013\u0010\u00e1\u0001\u001a\u00030\u0090\u00012\u0007\u0010\u00e2\u0001\u001a\u00020&H\u0002J\u0013\u0010\u00e3\u0001\u001a\u00030\u0090\u00012\u0007\u0010\u00e4\u0001\u001a\u00020$H\u0002J\n\u0010\u00e5\u0001\u001a\u00030\u0090\u0001H\u0002J\n\u0010\u00e6\u0001\u001a\u00030\u0090\u0001H\u0002J\n\u0010\u00e7\u0001\u001a\u00030\u0090\u0001H\u0002J\n\u0010\u00e8\u0001\u001a\u00030\u0090\u0001H\u0002J\u0018\u0010\u00e9\u0001\u001a\u00030\u0090\u00012\f\u0010X\u001a\b\u0012\u0004\u0012\u00020&0\u0016H\u0002J\u0013\u0010\u00ea\u0001\u001a\u00030\u0090\u00012\u0007\u0010\u00eb\u0001\u001a\u00020&H\u0002J\n\u0010\u00ec\u0001\u001a\u00030\u0090\u0001H\u0002J\u0013\u0010\u00ed\u0001\u001a\u00030\u0090\u00012\u0007\u0010\u00ee\u0001\u001a\u00020&H\u0002J\n\u0010\u00ef\u0001\u001a\u00030\u0090\u0001H\u0002J\u0014\u0010\u00f0\u0001\u001a\u00030\u0090\u00012\n\u0010\u00b4\u0001\u001a\u0005\u0018\u00010\u00b5\u0001R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\fX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0018\u001a\u00020\u00198BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001a\u0010\u001bR\u001b\u0010\u001e\u001a\u00020\u001f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\"\u0010\u001d\u001a\u0004\b \u0010!R\u000e\u0010#\u001a\u00020$X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\'\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010*\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010+X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010-\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001a\u00101\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b1\u0010.\"\u0004\b2\u00100R\u0016\u00103\u001a\n\u0012\u0004\u0012\u00020&\u0018\u000104X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u00105\u001a\u0004\u0018\u000106X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u00107\u001a\u000208X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u00109\u001a\u0004\u0018\u00010:X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u001a\u0010?\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b@\u0010.\"\u0004\bA\u00100R\u000e\u0010B\u001a\u00020CX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020EX\u0082.\u00a2\u0006\u0002\n\u0000R\u001e\u0010F\u001a\u00020G8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\u001a\u0010L\u001a\u00020MX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR\u000e\u0010R\u001a\u00020&X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010S\u001a\u00020T8DX\u0084\u0084\u0002\u00a2\u0006\f\n\u0004\bW\u0010\u001d\u001a\u0004\bU\u0010VR\u0014\u0010X\u001a\b\u0012\u0004\u0012\u00020&0\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010Y\u001a\u00020Z8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b[\u0010\\\"\u0004\b]\u0010^R\u0010\u0010_\u001a\u0004\u0018\u00010`X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020&0c0bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001b\u0010d\u001a\u00020e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bh\u0010\u001d\u001a\u0004\bf\u0010gR\u001b\u0010i\u001a\u00020j8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bm\u0010\u001d\u001a\u0004\bk\u0010lR\u0010\u0010n\u001a\u0004\u0018\u00010oX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010p\u001a\u00020$X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010q\u001a\b\u0012\u0004\u0012\u00020r0\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010s\u001a\u0012\u0012\u0004\u0012\u00020t04j\b\u0012\u0004\u0012\u00020t`uX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010v\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010+X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010w\u001a\u0004\u0018\u00010xX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010y\u001a\u00020z8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b{\u0010|\"\u0004\b}\u0010~R\u000e\u0010\u007f\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000f\u0010\u0080\u0001\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0081\u0001\u001a\u0004\u0018\u00010&X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0018\u0010\u0082\u0001\u001a\u000b\u0012\u0005\u0012\u00030\u0083\u0001\u0018\u000104X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0015\u0010\u0084\u0001\u001a\u00030\u0085\u0001\u00a2\u0006\n\n\u0000\u001a\u0006\b\u0086\u0001\u0010\u0087\u0001R \u0010\u0088\u0001\u001a\u00030\u0089\u00018FX\u0086\u0084\u0002\u00a2\u0006\u000f\n\u0005\b\u008c\u0001\u0010\u001d\u001a\u0006\b\u008a\u0001\u0010\u008b\u0001R\u000f\u0010\u008d\u0001\u001a\u00020$X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000f\u0010\u008e\u0001\u001a\u00020$X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u00f1\u0001"}, d2 = {"Lcom/contusfly/activities/MediaPreviewActivity;", "Lcom/contusfly/activities/BaseActivity;", "Lcom/contusfly/adapters/MediaPreviewAdapter$OnItemClickListener;", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "Landroid/view/View$OnClickListener;", "Lio/github/rockerhieu/emojicon/EmojiconsFragment$OnEmojiconBackspaceClickedListener;", "Lio/github/rockerhieu/emojicon/EmojiconGridFragment$OnEmojiconClickedListener;", "Lcom/contusfly/adapters/GroupTagAdapter$UserTagClickListener;", "()V", "alreadyOpen", "", "chat", "Lcom/contusfly/models/Chat;", "getChat", "()Lcom/contusfly/models/Chat;", "setChat", "(Lcom/contusfly/models/Chat;)V", "emojiEditText", "Lcom/contusfly/groupmention/MentionEditGroupText;", "emojiHandler", "Lcom/contusfly/utils/EmojiHandler;", "fileObjects", "", "Lcom/contusfly/models/FileObject;", "groupTagAdapter", "Lcom/contusfly/adapters/GroupTagAdapter;", "getGroupTagAdapter", "()Lcom/contusfly/adapters/GroupTagAdapter;", "groupTagAdapter$delegate", "Lkotlin/Lazy;", "groupTagRecycler", "Landroidx/recyclerview/widget/RecyclerView;", "getGroupTagRecycler", "()Landroidx/recyclerview/widget/RecyclerView;", "groupTagRecycler$delegate", "imagePosition", "", "intentKeyShare", "", "isFromCamera", "isFromChatScreen", "isFromQuickShare", "isImageList", "", "isResumeFirstTime", "isResumedNotCalled", "()Z", "setResumedNotCalled", "(Z)V", "isSoftKeyboardShown", "setSoftKeyboardShown", "jidList", "Ljava/util/ArrayList;", "keyboardHeightProvider", "Lcom/contusfly/views/KeyboardHeightProvider;", "lastClickTime", "", "mediaListCaption", "Lcom/contusfly/utils/MediaCaptionMentionList;", "getMediaListCaption", "()Lcom/contusfly/utils/MediaCaptionMentionList;", "setMediaListCaption", "(Lcom/contusfly/utils/MediaCaptionMentionList;)V", "mediaListCaptionAddedStatus", "getMediaListCaptionAddedStatus", "setMediaListCaptionAddedStatus", "mediaPreviewAdapter", "Lcom/contusfly/adapters/MediaPreviewAdapter;", "mediaPreviewBinding", "Lcom/contusfly/databinding/ActivityMediaPreviewBinding;", "mediaPreviewViewModelFactory", "Lcom/contusfly/di/factory/AppViewModelFactory;", "getMediaPreviewViewModelFactory", "()Lcom/contusfly/di/factory/AppViewModelFactory;", "setMediaPreviewViewModelFactory", "(Lcom/contusfly/di/factory/AppViewModelFactory;)V", "mediaViewPagerAdapter", "Lcom/contusfly/adapters/MediaPreviewPagerAdapter;", "getMediaViewPagerAdapter", "()Lcom/contusfly/adapters/MediaPreviewPagerAdapter;", "setMediaViewPagerAdapter", "(Lcom/contusfly/adapters/MediaPreviewPagerAdapter;)V", "mentionFilterKey", "mentionViewModel", "Lcom/contusfly/viewmodels/MentionsViewModel;", "getMentionViewModel", "()Lcom/contusfly/viewmodels/MentionsViewModel;", "mentionViewModel$delegate", "mentionedUsersIds", "messagingClient", "Lcom/contusfly/chat/MessagingClient;", "getMessagingClient", "()Lcom/contusfly/chat/MessagingClient;", "setMessagingClient", "(Lcom/contusfly/chat/MessagingClient;)V", "myApp", "Lcom/contusfly/constants/MobileApplication;", "notificationPermissionLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "", "parentContent", "Landroidx/appcompat/widget/ContentFrameLayout;", "getParentContent", "()Landroidx/appcompat/widget/ContentFrameLayout;", "parentContent$delegate", "permissionAlertDialog", "Lcom/contusfly/views/PermissionAlertDialog;", "getPermissionAlertDialog", "()Lcom/contusfly/views/PermissionAlertDialog;", "permissionAlertDialog$delegate", "progressDialog", "Lcom/contusfly/views/DoProgressDialog;", "remainingMessagesCount", "selectedImageList", "Lcom/contusfly/models/MediaPreviewModel;", "selectedImages", "Lcom/contusfly/mediapicker/model/Image;", "Lkotlin/collections/ArrayList;", "selectedUsers", "sendTextMessageWithMentionFormat", "", "shareMessagesController", "Lcom/contusfly/chat/ShareMessagesController;", "getShareMessagesController", "()Lcom/contusfly/chat/ShareMessagesController;", "setShareMessagesController", "(Lcom/contusfly/chat/ShareMessagesController;)V", "showChatKeyboard", "showingEmojiKeyboard", "toUser", "uriList", "Landroid/net/Uri;", "userMentionConfig", "Lcom/contusfly/groupmention/UserMentionConfig;", "getUserMentionConfig", "()Lcom/contusfly/groupmention/UserMentionConfig;", "viewModel", "Lcom/contusfly/viewmodels/MediaPreviewViewModel;", "getViewModel", "()Lcom/contusfly/viewmodels/MediaPreviewViewModel;", "viewModel$delegate", "viewPagerPosition", "viewPagerState", "addMediaCaptionMentionList", "", "backToCamera", "bindMediaUserMention", "mentionConfig", "handler", "Lcom/contusfly/groupmention/OnMentionEventListener;", "checkAndShowPreviewList", "createAdapterObject", "uri", "finishQuickShare", "firstIndexImageMentionUserId", "getKeyboardListener", "Lcom/contusfly/views/KeyboardHeightProvider$KeyboardListener;", "handleCaptionImage", "handleCursorAndKeyboardVisibility", "handlePreviewFromCamera", "handlePreviewFromGallery", "handleQuickShareInitialOperations", "hideKeyboard", "initGroupMentionTag", "initMentionAdapter", "initViews", "initializeAdapterForViewPager", "initializeCaptionListener", "launchChatPage", "sentMessages", "Lcom/mirrorflysdk/api/models/ChatMessage;", "errorMessageList", "maintainAddedMentionUser", "position", "mediaUpload", "mediafileUpload", "navigateToAppropriateScreen", "notificationPermissionChecking", "onBackPressed", "onClick", "v", "Landroid/view/View;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onEmojiconBackspaceClicked", "onEmojiconClicked", "emojicon", "Lio/github/rockerhieu/emojicon/emoji/Emojicon;", "onItemClick", "view", "onKeyboardVisibilityChanged", "shown", "onMessageEvent", "messageEvent", "Lcom/contusfly/models/PrivateChatAuthenticationModel;", "onPageScrollStateChanged", "state", "onPageScrolled", "positionOffset", "", "positionOffsetPixels", "onPageSelected", "onPause", "onPostCreate", "onResume", "onStart", "onStop", "onUserTagClicked", "profileDetails", "Lcom/mirrorflysdk/api/contacts/ProfileDetails;", "prepareMultipleUserNames", "quickShareMediafileUpload", "removeSelectedFile", "removeSelectedFileFromPicker", "sendGalleryAttachmentFiles", "messageObject", "Lcom/contusfly/models/MessageObject;", "sendGalleryAttachments", "replyMessageId", "sendMedia", "sendMediaFilesForSingleUser", "setAdapterForViewPager", "setAddMoreVisibility", "setCaptionEntryFirst", "it", "setCaptionLength", "length", "setEmojiKeyBoardListener", "setKeyboardHeightListener", "setMediaPickerAdapter", "setObservers", "setTextIncludingMention", "setUserName", "name", "setViewPagerAdapter", "showUnSentMentionUsersMessage", "unsentMessage", "startCopyingFilesToMirrorFlyDirectoryAndSend", "viewPagerOnClick", "app_debug"})
public final class MediaPreviewActivity extends com.contusfly.activities.BaseActivity implements com.contusfly.adapters.MediaPreviewAdapter.OnItemClickListener, androidx.viewpager.widget.ViewPager.OnPageChangeListener, android.view.View.OnClickListener, io.github.rockerhieu.emojicon.EmojiconsFragment.OnEmojiconBackspaceClickedListener, io.github.rockerhieu.emojicon.EmojiconGridFragment.OnEmojiconClickedListener, com.contusfly.adapters.GroupTagAdapter.UserTagClickListener {
    private com.contusfly.databinding.ActivityMediaPreviewBinding mediaPreviewBinding;
    @org.jetbrains.annotations.NotNull
    private final com.contusfly.groupmention.UserMentionConfig userMentionConfig = null;
    private boolean mediaListCaptionAddedStatus = false;
    @javax.inject.Inject
    public com.contusfly.di.factory.AppViewModelFactory mediaPreviewViewModelFactory;
    @org.jetbrains.annotations.NotNull
    private final kotlin.Lazy viewModel$delegate = null;
    @org.jetbrains.annotations.NotNull
    private final kotlin.Lazy mentionViewModel$delegate = null;
    private final kotlin.Lazy groupTagRecycler$delegate = null;
    private final kotlin.Lazy groupTagAdapter$delegate = null;
    @javax.inject.Inject
    public com.contusfly.chat.MessagingClient messagingClient;
    private com.contusfly.views.KeyboardHeightProvider keyboardHeightProvider;
    
    /**
     * Check is from camera or not
     */
    private boolean isFromCamera = false;
    private final kotlin.Lazy parentContent$delegate = null;
    private boolean isResumeFirstTime = true;
    
    /**
     * User jid to send images
     */
    private java.lang.String toUser;
    
    /**
     * Store onclick time to avoid double click
     */
    private long lastClickTime = 0L;
    
    /**
     * Share the Key Value
     */
    private java.lang.String intentKeyShare;
    
    /**
     * Instance of the EmojiHandler to access the emoji and text keypad
     */
    private com.contusfly.utils.EmojiHandler emojiHandler;
    private boolean alreadyOpen = false;
    private boolean showChatKeyboard = false;
    
    /**
     * Check is from Chat Screen or not
     */
    private boolean isFromChatScreen = false;
    
    /**
     * Check is from Quick Share or not
     */
    private boolean isFromQuickShare = false;
    
    /**
     * Position of the selected message
     */
    private int imagePosition = 0;
    
    /**
     * State of view pager during transition
     */
    private int viewPagerState = 0;
    
    /**
     * Position of view pager
     */
    private int viewPagerPosition = 0;
    
    /**
     * List of selected images
     */
    private java.util.List<com.contusfly.models.MediaPreviewModel> selectedImageList;
    private boolean showingEmojiKeyboard = false;
    
    /**
     * List of selected files from Quick Share
     */
    private java.util.List<com.contusfly.models.FileObject> fileObjects;
    
    /**
     * Adapter for the media list
     */
    public com.contusfly.adapters.MediaPreviewPagerAdapter mediaViewPagerAdapter;
    private boolean isSoftKeyboardShown = false;
    private boolean isResumedNotCalled = false;
    private com.contusfly.adapters.MediaPreviewAdapter mediaPreviewAdapter;
    
    /**
     * Selected images from gallery
     */
    private java.util.ArrayList<com.contusfly.mediapicker.model.Image> selectedImages;
    
    /**
     * The progress dialog of the activity When run the background tasks
     */
    private com.contusfly.views.DoProgressDialog progressDialog;
    
    /**
     * List of selected files from Quick Share
     */
    private java.util.List<java.lang.String> selectedUsers;
    
    /**
     * The Boolean List is contains All image list
     */
    private java.util.List<java.lang.Boolean> isImageList;
    
    /**
     * List Contian jid of multiple users
     */
    private java.util.ArrayList<java.lang.String> jidList;
    
    /**
     * The Array List Contains Uri List
     */
    private java.util.ArrayList<android.net.Uri> uriList;
    private int remainingMessagesCount = 0;
    private com.contusfly.groupmention.MentionEditGroupText emojiEditText;
    private java.util.List<java.lang.String> mentionedUsersIds;
    private java.lang.CharSequence sendTextMessageWithMentionFormat;
    private java.lang.String mentionFilterKey;
    @org.jetbrains.annotations.Nullable
    private com.contusfly.utils.MediaCaptionMentionList mediaListCaption;
    private com.contusfly.constants.MobileApplication myApp;
    
    /**
     * View to the files number
     */
    @javax.inject.Inject
    public com.contusfly.chat.ShareMessagesController shareMessagesController;
    private final kotlin.Lazy permissionAlertDialog$delegate = null;
    public com.contusfly.models.Chat chat;
    private final androidx.activity.result.ActivityResultLauncher<java.lang.String[]> notificationPermissionLauncher = null;
    private java.util.HashMap _$_findViewCache;
    
    public MediaPreviewActivity() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.contusfly.groupmention.UserMentionConfig getUserMentionConfig() {
        return null;
    }
    
    public final boolean getMediaListCaptionAddedStatus() {
        return false;
    }
    
    public final void setMediaListCaptionAddedStatus(boolean p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.contusfly.di.factory.AppViewModelFactory getMediaPreviewViewModelFactory() {
        return null;
    }
    
    public final void setMediaPreviewViewModelFactory(@org.jetbrains.annotations.NotNull
    com.contusfly.di.factory.AppViewModelFactory p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.contusfly.viewmodels.MediaPreviewViewModel getViewModel() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    protected final com.contusfly.viewmodels.MentionsViewModel getMentionViewModel() {
        return null;
    }
    
    private final androidx.recyclerview.widget.RecyclerView getGroupTagRecycler() {
        return null;
    }
    
    private final com.contusfly.adapters.GroupTagAdapter getGroupTagAdapter() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.contusfly.chat.MessagingClient getMessagingClient() {
        return null;
    }
    
    public final void setMessagingClient(@org.jetbrains.annotations.NotNull
    com.contusfly.chat.MessagingClient p0) {
    }
    
    private final androidx.appcompat.widget.ContentFrameLayout getParentContent() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.contusfly.adapters.MediaPreviewPagerAdapter getMediaViewPagerAdapter() {
        return null;
    }
    
    public final void setMediaViewPagerAdapter(@org.jetbrains.annotations.NotNull
    com.contusfly.adapters.MediaPreviewPagerAdapter p0) {
    }
    
    public final boolean isSoftKeyboardShown() {
        return false;
    }
    
    public final void setSoftKeyboardShown(boolean p0) {
    }
    
    public final boolean isResumedNotCalled() {
        return false;
    }
    
    public final void setResumedNotCalled(boolean p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.contusfly.utils.MediaCaptionMentionList getMediaListCaption() {
        return null;
    }
    
    public final void setMediaListCaption(@org.jetbrains.annotations.Nullable
    com.contusfly.utils.MediaCaptionMentionList p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.contusfly.chat.ShareMessagesController getShareMessagesController() {
        return null;
    }
    
    public final void setShareMessagesController(@org.jetbrains.annotations.NotNull
    com.contusfly.chat.ShareMessagesController p0) {
    }
    
    private final com.contusfly.views.PermissionAlertDialog getPermissionAlertDialog() {
        return null;
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final void addMediaCaptionMentionList() {
    }
    
    @java.lang.Override
    protected void onPostCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final void initViews() {
    }
    
    private final void setKeyboardHeightListener() {
    }
    
    private final void setCaptionLength(int length) {
    }
    
    private final void initializeCaptionListener() {
    }
    
    private final void initializeAdapterForViewPager() {
    }
    
    private final void checkAndShowPreviewList() {
    }
    
    private final void onKeyboardVisibilityChanged(boolean shown) {
    }
    
    private final void setUserName(java.lang.String name) {
    }
    
    private final void prepareMultipleUserNames() {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.contusfly.models.Chat getChat() {
        return null;
    }
    
    public final void setChat(@org.jetbrains.annotations.NotNull
    com.contusfly.models.Chat p0) {
    }
    
    private final void setObservers() {
    }
    
    private final void setCaptionEntryFirst(java.lang.String it) {
    }
    
    private final void firstIndexImageMentionUserId() {
    }
    
    private final void showUnSentMentionUsersMessage(java.lang.String unsentMessage) {
    }
    
    private final void handlePreviewFromCamera() {
    }
    
    private final void handleQuickShareInitialOperations() {
    }
    
    private final void createAdapterObject(android.net.Uri uri) {
    }
    
    private final void handlePreviewFromGallery() {
    }
    
    public final void setAdapterForViewPager() {
    }
    
    @java.lang.Override
    public void onBackPressed() {
    }
    
    private final void finishQuickShare() {
    }
    
    private final void backToCamera() {
    }
    
    @java.lang.Override
    public void onItemClick(@org.jetbrains.annotations.Nullable
    android.view.View view, int position) {
    }
    
    @java.lang.Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }
    
    @java.lang.Override
    public void onPageSelected(int position) {
    }
    
    private final void maintainAddedMentionUser(int position) {
    }
    
    @java.lang.Override
    public void onPageScrollStateChanged(int state) {
    }
    
    public final void viewPagerOnClick(@org.jetbrains.annotations.Nullable
    android.view.View v) {
    }
    
    /**
     * Hide the soft input keyboard from the startupActivityContext of the window
     * that is currently accepting input.
     */
    private final void hideKeyboard() {
    }
    
    @java.lang.Override
    public void onClick(@org.jetbrains.annotations.NotNull
    android.view.View v) {
    }
    
    private final void setEmojiKeyBoardListener() {
    }
    
    private final void sendMedia() {
    }
    
    private final void mediaUpload() {
    }
    
    private final void notificationPermissionChecking() {
    }
    
    private final void quickShareMediafileUpload() {
    }
    
    private final void mediafileUpload() {
    }
    
    private final void startCopyingFilesToMirrorFlyDirectoryAndSend() {
    }
    
    private final void sendMediaFilesForSingleUser() {
    }
    
    private final void navigateToAppropriateScreen() {
    }
    
    /**
     * handle caption click
     */
    private final void handleCaptionImage(java.lang.String toUser) {
    }
    
    private final void sendGalleryAttachments(java.lang.String toUser, java.lang.String replyMessageId) {
    }
    
    private final void sendGalleryAttachmentFiles(com.contusfly.models.MessageObject messageObject, java.util.ArrayList<com.mirrorflysdk.api.models.ChatMessage> sentMessages, java.lang.String toUser, java.util.ArrayList<java.lang.String> errorMessageList) {
    }
    
    private final void launchChatPage(java.util.ArrayList<com.mirrorflysdk.api.models.ChatMessage> sentMessages, java.lang.String toUser, java.util.ArrayList<java.lang.String> errorMessageList) {
    }
    
    private final void removeSelectedFile() {
    }
    
    private final void removeSelectedFileFromPicker() {
    }
    
    private final void setAddMoreVisibility() {
    }
    
    private final void setMediaPickerAdapter() {
    }
    
    private final void setViewPagerAdapter() {
    }
    
    @java.lang.Override
    protected void onResume() {
    }
    
    private final void handleCursorAndKeyboardVisibility() {
    }
    
    @java.lang.Override
    protected void onPause() {
    }
    
    @java.lang.Override
    protected void onDestroy() {
    }
    
    @java.lang.Override
    public void onEmojiconBackspaceClicked(@org.jetbrains.annotations.Nullable
    android.view.View v) {
    }
    
    @java.lang.Override
    public void onEmojiconClicked(@org.jetbrains.annotations.NotNull
    io.github.rockerhieu.emojicon.emoji.Emojicon emojicon) {
    }
    
    private final com.contusfly.views.KeyboardHeightProvider.KeyboardListener getKeyboardListener() {
        return null;
    }
    
    private final void initMentionAdapter() {
    }
    
    /**
     * Group mention functionaliity
     */
    private final void initGroupMentionTag() {
    }
    
    @java.lang.Override
    public void onUserTagClicked(@org.jetbrains.annotations.NotNull
    com.mirrorflysdk.api.contacts.ProfileDetails profileDetails) {
    }
    
    public final void bindMediaUserMention(@org.jetbrains.annotations.NotNull
    com.contusfly.groupmention.UserMentionConfig mentionConfig, @org.jetbrains.annotations.NotNull
    com.contusfly.groupmention.OnMentionEventListener handler) {
    }
    
    private final void setTextIncludingMention(java.util.List<java.lang.String> mentionedUsersIds) {
    }
    
    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public final void onMessageEvent(@org.jetbrains.annotations.Nullable
    com.contusfly.models.PrivateChatAuthenticationModel messageEvent) {
    }
    
    @java.lang.Override
    public void onStart() {
    }
    
    @java.lang.Override
    public void onStop() {
    }
}