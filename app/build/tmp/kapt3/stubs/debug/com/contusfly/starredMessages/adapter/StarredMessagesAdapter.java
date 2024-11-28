package com.contusfly.starredMessages.adapter;

import java.lang.System;

/**
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0092\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\u0010\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\u0002H\u0002J\u0018\u00103\u001a\u0002012\u0006\u00102\u001a\u00020\u00022\u0006\u00104\u001a\u00020+H\u0002J \u00105\u001a\u0002012\u0006\u00106\u001a\u00020\t2\u0006\u00107\u001a\u00020\t2\u0006\u00108\u001a\u00020\"H\u0016J \u00109\u001a\u0002012\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020;2\u0006\u0010=\u001a\u00020+H\u0002J\u0018\u0010>\u001a\u0002012\u0006\u00102\u001a\u00020\u00022\u0006\u0010?\u001a\u00020\"H\u0002J\u0012\u0010@\u001a\u0004\u0018\u00010\"2\u0006\u00104\u001a\u00020+H\u0002J\u0010\u0010A\u001a\u00020\"2\u0006\u0010B\u001a\u00020\"H\u0002J\b\u0010C\u001a\u00020\tH\u0016J\u0010\u0010D\u001a\u00020E2\u0006\u00106\u001a\u00020\tH\u0016J\u0010\u0010F\u001a\u00020\t2\u0006\u00106\u001a\u00020\tH\u0016J\u0012\u0010G\u001a\u0004\u0018\u00010\"2\u0006\u0010H\u001a\u00020IH\u0002J\u0010\u0010J\u001a\u00020\t2\u0006\u0010K\u001a\u00020\"H\u0002J\u0012\u0010L\u001a\u0004\u0018\u00010\"2\u0006\u00104\u001a\u00020+H\u0003J\u0010\u0010M\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010+\u0018\u00010-J\u0012\u0010N\u001a\u00020O2\b\u0010B\u001a\u0004\u0018\u00010\"H\u0002J \u0010P\u001a\u0002012\u0006\u00102\u001a\u00020\u00022\u0006\u00104\u001a\u00020+2\u0006\u00106\u001a\u00020\tH\u0002J \u0010Q\u001a\u0002012\u0006\u00102\u001a\u00020\u00022\u0006\u00104\u001a\u00020+2\u0006\u00106\u001a\u00020\tH\u0002J \u0010R\u001a\u0002012\u0006\u00102\u001a\u00020\u00022\u0006\u00104\u001a\u00020+2\u0006\u00106\u001a\u00020\tH\u0002J \u0010S\u001a\u0002012\u0006\u00102\u001a\u00020\u00022\u0006\u00104\u001a\u00020+2\u0006\u00106\u001a\u00020\tH\u0002J \u0010T\u001a\u0002012\u0006\u00102\u001a\u00020\u00022\u0006\u00104\u001a\u00020+2\u0006\u00106\u001a\u00020\tH\u0002J \u0010U\u001a\u0002012\u0006\u00102\u001a\u00020\u00022\u0006\u00104\u001a\u00020+2\u0006\u00106\u001a\u00020\tH\u0002J \u0010V\u001a\u0002012\u0006\u00102\u001a\u00020\u00022\u0006\u0010=\u001a\u00020+2\u0006\u00106\u001a\u00020\tH\u0002J \u0010W\u001a\u0002012\u0006\u00102\u001a\u00020\u00022\u0006\u0010=\u001a\u00020+2\u0006\u00106\u001a\u00020\tH\u0002J \u0010X\u001a\u0002012\u0006\u00102\u001a\u00020\u00022\u0006\u00104\u001a\u00020+2\u0006\u00106\u001a\u00020\tH\u0002J \u0010Y\u001a\u0002012\u0006\u00102\u001a\u00020\u00022\u0006\u00104\u001a\u00020+2\u0006\u00106\u001a\u00020\tH\u0002J \u0010Z\u001a\u0002012\u0006\u00102\u001a\u00020\u00022\u0006\u00104\u001a\u00020+2\u0006\u00106\u001a\u00020\tH\u0002J \u0010[\u001a\u0002012\u0006\u00102\u001a\u00020\u00022\u0006\u00104\u001a\u00020+2\u0006\u00106\u001a\u00020\tH\u0002J \u0010\\\u001a\u0002012\u0006\u00102\u001a\u00020\u00022\u0006\u00104\u001a\u00020+2\u0006\u00106\u001a\u00020\tH\u0002J \u0010]\u001a\u0002012\u0006\u00102\u001a\u00020\u00022\u0006\u00104\u001a\u00020+2\u0006\u00106\u001a\u00020\tH\u0002J \u0010^\u001a\u0002012\u0006\u00102\u001a\u00020\u00022\u0006\u0010=\u001a\u00020+2\u0006\u00106\u001a\u00020\tH\u0002J \u0010_\u001a\u0002012\u0006\u00102\u001a\u00020\u00022\u0006\u0010=\u001a\u00020+2\u0006\u00106\u001a\u00020\tH\u0002J\u0018\u0010`\u001a\u0002012\u0006\u0010a\u001a\u00020b2\u0006\u0010c\u001a\u00020\"H\u0002J(\u0010d\u001a\u0002012\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010e\u001a\u00020f2\u0006\u0010g\u001a\u00020h2\u0006\u0010i\u001a\u00020jH\u0002J\u0018\u0010k\u001a\u0002012\u0006\u00102\u001a\u00020\u00022\u0006\u00106\u001a\u00020\tH\u0016J\u0018\u0010l\u001a\u00020\u00022\u0006\u0010m\u001a\u00020n2\u0006\u0010o\u001a\u00020\tH\u0016J\u0006\u0010p\u001a\u000201J2\u0010q\u001a\u0002012\u0006\u0010:\u001a\u00020;2\u0006\u0010r\u001a\u00020;2\u0006\u0010<\u001a\u00020;2\u0006\u0010=\u001a\u00020+2\b\u0010s\u001a\u0004\u0018\u00010;H\u0002J,\u0010t\u001a\u0002012\u0006\u0010u\u001a\u00020;2\u0006\u0010=\u001a\u00020+2\u0006\u00106\u001a\u00020\t2\n\b\u0002\u0010v\u001a\u0004\u0018\u00010;H\u0002J(\u0010w\u001a\u0002012\u0006\u0010r\u001a\u00020;2\u0006\u0010x\u001a\u00020;2\u0006\u0010=\u001a\u00020+2\u0006\u0010y\u001a\u00020;H\u0002J,\u0010z\u001a\u0002012\u0006\u0010{\u001a\u00020;2\u0006\u0010=\u001a\u00020+2\u0006\u00106\u001a\u00020\t2\n\b\u0002\u0010v\u001a\u0004\u0018\u00010;H\u0002J\u000e\u0010|\u001a\u0002012\u0006\u0010\u000f\u001a\u00020\u0010J4\u0010}\u001a\u0002012\u0006\u0010~\u001a\u00020+2\u0006\u00102\u001a\u00020\u00022\u0006\u0010\u007f\u001a\u00020h2\b\u0010\u0080\u0001\u001a\u00030\u0081\u00012\b\u0010\u0082\u0001\u001a\u00030\u0083\u0001H\u0002J\u001e\u0010\u0084\u0001\u001a\u0002012\b\u00104\u001a\u0004\u0018\u00010+2\t\u0010\u0085\u0001\u001a\u0004\u0018\u00010hH\u0016J$\u0010\u0086\u0001\u001a\u0002012\b\u0010\u0087\u0001\u001a\u00030\u0088\u00012\u0006\u00104\u001a\u00020+2\u0007\u0010\u0089\u0001\u001a\u00020\"H\u0002J\"\u0010\u008a\u0001\u001a\u0002012\u0006\u00102\u001a\u00020\u00022\u0007\u0010\u008b\u0001\u001a\u00020\t2\u0006\u00104\u001a\u00020+H\u0002J+\u0010\u008c\u0001\u001a\u0002012\t\u0010\u008d\u0001\u001a\u0004\u0018\u00010\"2\t\u0010\u008e\u0001\u001a\u0004\u0018\u00010;2\n\u0010\u008f\u0001\u001a\u0005\u0018\u00010\u0083\u0001H\u0016J+\u0010\u0090\u0001\u001a\u0002012\u0007\u0010\u0091\u0001\u001a\u00020;2\u0006\u0010B\u001a\u00020+2\u0006\u00106\u001a\u00020\t2\u0007\u0010\u0092\u0001\u001a\u00020\"H\u0002J/\u0010\u0093\u0001\u001a\u0002012\b\u0010\u0094\u0001\u001a\u00030\u0083\u00012\b\u0010\u0095\u0001\u001a\u00030\u0096\u00012\u0007\u0010\u0097\u0001\u001a\u00020h2\u0007\u0010\u0098\u0001\u001a\u00020\"H\u0002J#\u0010\u0099\u0001\u001a\u0002012\b\u0010\u009a\u0001\u001a\u00030\u009b\u00012\u0006\u00104\u001a\u00020+2\u0006\u00106\u001a\u00020\tH\u0002J#\u0010\u009c\u0001\u001a\u0002012\b\u0010\u0087\u0001\u001a\u00030\u009d\u00012\u0006\u00104\u001a\u00020+2\u0006\u00106\u001a\u00020\tH\u0002J#\u0010\u009e\u0001\u001a\u0002012\b\u0010\u009f\u0001\u001a\u00030\u00a0\u00012\u0006\u00104\u001a\u00020+2\u0006\u00106\u001a\u00020\tH\u0002J#\u0010\u00a1\u0001\u001a\u0002012\b\u0010\u00a2\u0001\u001a\u00030\u00a3\u00012\u0006\u00104\u001a\u00020+2\u0006\u00106\u001a\u00020\tH\u0002J#\u0010\u00a4\u0001\u001a\u0002012\b\u0010\u00a5\u0001\u001a\u00030\u00a6\u00012\u0006\u00104\u001a\u00020+2\u0006\u00106\u001a\u00020\tH\u0002J#\u0010\u00a7\u0001\u001a\u0002012\b\u0010\u00a8\u0001\u001a\u00030\u00a9\u00012\u0006\u00104\u001a\u00020+2\u0006\u00106\u001a\u00020\tH\u0002J#\u0010\u00a7\u0001\u001a\u0002012\b\u0010\u00aa\u0001\u001a\u00030\u00ab\u00012\u0006\u00104\u001a\u00020+2\u0006\u00106\u001a\u00020\tH\u0002J#\u0010\u00ac\u0001\u001a\u0002012\b\u0010\u00ad\u0001\u001a\u00030\u00ae\u00012\u0006\u00104\u001a\u00020+2\u0006\u00106\u001a\u00020\tH\u0002J#\u0010\u00af\u0001\u001a\u0002012\b\u0010\u00a2\u0001\u001a\u00030\u00b0\u00012\u0006\u00104\u001a\u00020+2\u0006\u00106\u001a\u00020\tH\u0002J#\u0010\u00b1\u0001\u001a\u0002012\b\u0010\u00a5\u0001\u001a\u00030\u00b2\u00012\u0006\u00104\u001a\u00020+2\u0006\u00106\u001a\u00020\tH\u0002J#\u0010\u00b3\u0001\u001a\u0002012\b\u0010\u00b4\u0001\u001a\u00030\u00b5\u00012\u0006\u00104\u001a\u00020+2\u0006\u00106\u001a\u00020\tH\u0002J#\u0010\u00b3\u0001\u001a\u0002012\b\u0010\u00b6\u0001\u001a\u00030\u00b7\u00012\u0006\u00104\u001a\u00020+2\u0006\u00106\u001a\u00020\tH\u0002J#\u0010\u00b8\u0001\u001a\u0002012\b\u0010\u00b9\u0001\u001a\u00030\u00ba\u00012\u0006\u00104\u001a\u00020+2\u0006\u00106\u001a\u00020\tH\u0002J#\u0010\u00bb\u0001\u001a\u0002012\b\u0010\u0087\u0001\u001a\u00030\u0088\u00012\u0006\u00104\u001a\u00020+2\u0006\u00106\u001a\u00020\tH\u0002J\u001b\u0010\u00bc\u0001\u001a\u0002012\u0007\u0010\u00bd\u0001\u001a\u00020h2\u0007\u0010\u00be\u0001\u001a\u00020 H\u0002J\u0013\u0010\u00bf\u0001\u001a\u0002012\b\u0010\u00c0\u0001\u001a\u00030\u00c1\u0001H\u0016J4\u0010\u00c2\u0001\u001a\u0002012\n\u0010\u00c3\u0001\u001a\u0005\u0018\u00010\u0083\u00012\u0007\u0010\u00c4\u0001\u001a\u00020\t2\t\u0010\u00c5\u0001\u001a\u0004\u0018\u00010+2\t\u0010\u00c6\u0001\u001a\u0004\u0018\u00010hH\u0016J\u0013\u0010\u00c7\u0001\u001a\u0002012\b\u0010\u00c8\u0001\u001a\u00030\u00c9\u0001H\u0016J&\u0010\u00ca\u0001\u001a\u0002012\b\u0010\u0094\u0001\u001a\u00030\u0083\u00012\b\u0010\u00cb\u0001\u001a\u00030\u0096\u00012\u0007\u0010\u00cc\u0001\u001a\u00020hH\u0002J\u0011\u0010\u00cd\u0001\u001a\u0002012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018J \u0010\u00ce\u0001\u001a\u0002012\t\u0010\u0085\u0001\u001a\u0004\u0018\u00010h2\n\u0010\u00cf\u0001\u001a\u0005\u0018\u00010\u00d0\u0001H\u0016J\u0018\u0010\u00d1\u0001\u001a\u0002012\u0007\u0010\u00d2\u0001\u001a\u00020 2\u0006\u0010!\u001a\u00020\"J\u001c\u0010\u00d3\u0001\u001a\u0002012\b\u0010\u00d4\u0001\u001a\u00030\u00d5\u00012\u0007\u0010\u00d6\u0001\u001a\u00020OH\u0002J\u001e\u0010\u00d7\u0001\u001a\u0002012\b\u0010\u0094\u0001\u001a\u00030\u0083\u00012\t\u0010\u00d6\u0001\u001a\u0004\u0018\u00010OH\u0002J(\u0010\u00d8\u0001\u001a\u0002012\b\u0010\u0094\u0001\u001a\u00030\u0083\u00012\t\u0010\u00d6\u0001\u001a\u0004\u0018\u00010O2\b\u0010\u00d9\u0001\u001a\u00030\u00da\u0001H\u0002J#\u0010\u00db\u0001\u001a\u0002012\b\u0010\u00dc\u0001\u001a\u00030\u00dd\u00012\u0006\u00104\u001a\u00020+2\u0006\u00106\u001a\u00020\tH\u0002J\u001b\u0010\u00de\u0001\u001a\u0002012\u0007\u0010\u00df\u0001\u001a\u00020 2\u0007\u0010\u00e0\u0001\u001a\u00020hH\u0016J\u001b\u0010\u00e1\u0001\u001a\u0002012\u0007\u0010\u00df\u0001\u001a\u00020 2\u0007\u0010\u00e0\u0001\u001a\u00020hH\u0016J\u0017\u0010\u00e2\u0001\u001a\u0002012\u000e\u0010,\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010-J\u0016\u0010\u00e3\u0001\u001a\u0002012\r\u0010\u00e4\u0001\u001a\b\u0012\u0004\u0012\u00020+0-J\u001e\u0010\u00e5\u0001\u001a\u0002012\b\u00104\u001a\u0004\u0018\u00010+2\t\u0010\u00e6\u0001\u001a\u0004\u0018\u00010hH\u0016J!\u0010\u00e7\u0001\u001a\u0002012\u0006\u00102\u001a\u00020\u00022\u0006\u00104\u001a\u00020+2\u0006\u0010e\u001a\u00020fH\u0002J\u0019\u0010\u00e8\u0001\u001a\u0002012\b\u0010\u00e9\u0001\u001a\u00030\u00ea\u00012\u0006\u0010=\u001a\u00020+J\u0019\u0010\u00eb\u0001\u001a\u0002012\u0006\u00102\u001a\u00020\u00022\u0006\u00106\u001a\u00020\tH\u0002JF\u0010\u00ec\u0001\u001a\u0002012\u0006\u0010~\u001a\u00020+2\u0006\u00102\u001a\u00020\u00022\u0006\u00106\u001a\u00020\t2\u0006\u0010\u007f\u001a\u00020h2\b\u0010\u00ed\u0001\u001a\u00030\u0081\u00012\b\u0010\u0082\u0001\u001a\u00030\u0083\u00012\u0007\u0010\u00ee\u0001\u001a\u00020 H\u0002J!\u0010\u00ef\u0001\u001a\u0002012\u0006\u0010u\u001a\u00020;2\u0006\u0010=\u001a\u00020+2\u0006\u00106\u001a\u00020\tH\u0002J,\u0010\u00f0\u0001\u001a\u0002012\u0006\u0010r\u001a\u00020;2\t\u0010\u00f1\u0001\u001a\u0004\u0018\u00010;2\u0006\u0010x\u001a\u00020;2\u0006\u0010=\u001a\u00020+H\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082D\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\'\u001a\u0004\u0018\u00010(X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010)\u001a\b\u0012\u0004\u0012\u00020+0*X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010,\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010-X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010/X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u00f2\u0001"}, d2 = {"Lcom/contusfly/starredMessages/adapter/StarredMessagesAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/contusfly/interfaces/MessageItemListener;", "Lcom/contusfly/interfaces/AudioPlayItemViewSetListener;", "listChats", "Landroidx/recyclerview/widget/RecyclerView;", "(Landroidx/recyclerview/widget/RecyclerView;)V", "RECEIVER_HEADER", "", "SENDER_HEADER", "chatAdapterHelper", "Lcom/contusfly/adapters/ChatAdapterHelper;", "chatStarredMessageUtils", "Lcom/contusfly/utils/ChatMessageUtils;", "context", "Landroid/content/Context;", "fileItemView", "Lcom/contusfly/adapters/viewhelpers/FileItemView;", "inflater", "Landroid/view/LayoutInflater;", "getListChats", "()Landroidx/recyclerview/widget/RecyclerView;", "listener", "Lcom/contusfly/interfaces/OnChatItemClickListener;", "mMediaController", "Lcom/contusfly/chat/MediaController;", "mediaDetailUtils", "Lcom/contusfly/utils/MediaDetailUtils;", "replyViewUtils", "Lcom/contusfly/chat/reply/ReplyViewUtils;", "searchEnabled", "", "searchKey", "", "setDrawable", "Lcom/contusfly/views/SetDrawable;", "starredAudioItemView", "Lcom/contusfly/adapters/viewhelpers/AudioItemView;", "starredImageItemViewHelper", "Lcom/contusfly/adapters/viewhelpers/ImageItemViewHelper;", "starredMessageData", "", "Lcom/mirrorflysdk/api/models/ChatMessage;", "starredMessageMessages", "", "starredVideoItemViewHelper", "Lcom/contusfly/adapters/viewhelpers/VideoItemViewHelper;", "check", "", "holder", "checkUserFromReceiver", "item", "currentlyPlayItem", "position", "progress", "playduration", "downloadClick", "download", "Landroid/view/View;", "cancelDownload", "messageItem", "fetchProfileDetailOfReceivedNumber", "receivedNumber", "getChatMsgTime", "getHtmlStarredMessageText", "message", "getItemCount", "getItemId", "", "getItemViewType", "getJidFromSharedContact", "contactMessage", "Lcom/mirrorflysdk/api/models/ContactChatMessage;", "getMessageAudioPosition", "messageId", "getMessageDate", "getMessages", "getSpannedText", "Landroid/text/Spanned;", "getStarredAudioViewReceiver", "getStarredAudioViewSender", "getStarredContactViewReceiver", "getStarredContactViewSender", "getStarredFileViewReceiver", "getStarredFileViewSender", "getStarredImageViewReceiver", "getStarredImageViewSender", "getStarredLocationViewReceiver", "getStarredLocationViewSender", "getStarredMeetViewReceiver", "getStarredMeetViewSender", "getStarredTextViewReceiver", "getStarredTextViewSender", "getStarredVideoViewReceiver", "getStarredVideoViewSender", "handleContactView", "contactReceiverViewHolder", "Lcom/contusfly/adapters/holders/ContactReceivedViewHolder;", "jID", "loadUserProfileImage", "profileDetails", "Lcom/mirrorflysdk/api/contacts/ProfileDetails;", "imgView", "Landroid/widget/ImageView;", "errorImg", "Landroid/graphics/drawable/Drawable;", "onBindViewHolder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "pauseMediaPlayer", "receiverDownloadClick", "retry", "txtSize", "receiverItemClick", "receiverItem", "mediaClickView", "senderDownloadClick", "cancelUpload", "carbonDownloadView", "senderItemClick", "senderItem", "setAdapterData", "setAudioSeekBarListener", "chatMessage", "playImage", "starredMsgSeekBar", "Landroid/widget/SeekBar;", "durationView", "Landroid/widget/TextView;", "setChatStatus", "viewHolder", "setFileSenderView", "fileViewHolder", "Lcom/contusfly/adapters/holders/FileSentViewHolder;", "time", "setHeader", "type", "setImageViewSize", "starredFileSize", "downloadView", "starredFileSizeView", "setInviteClickListener", "view", "jid", "setJoinLinkView", "txtChat", "joinLinkView", "Landroid/widget/LinearLayout;", "joinLinkLogo", "originalMsg", "setListenersForAudioMessages", "audioViewHolder", "Lcom/contusfly/adapters/holders/AudioSentViewHolder;", "setListenersForReceivedFileMessages", "Lcom/contusfly/adapters/holders/FileReceivedViewHolder;", "setListenersForReceiverAudioMessages", "audioReceiverViewHolder", "Lcom/contusfly/adapters/holders/AudioReceivedViewHolder;", "setListenersForReceiverImageMessages", "imgViewHolder", "Lcom/contusfly/adapters/holders/ImageReceivedViewHolder;", "setListenersForReceiverLocationMessages", "locationHolder", "Lcom/contusfly/adapters/holders/LocationReceivedViewHolder;", "setListenersForReceiverTextMessages", "meetReceivedViewHolder", "Lcom/contusfly/adapters/holders/MeetReceivedViewHolder;", "txtReceiverViewHolder", "Lcom/contusfly/adapters/holders/TextReceivedViewHolder;", "setListenersForReceiverVideoMessages", "videoReceiverViewHolder", "Lcom/contusfly/adapters/holders/VideoReceivedViewHolder;", "setListenersForSenderImageMessages", "Lcom/contusfly/adapters/holders/ImageSentViewHolder;", "setListenersForSenderLocationMessages", "Lcom/contusfly/adapters/holders/LocationSentViewHolder;", "setListenersForSenderTextMessages", "meetSendViewHolder", "Lcom/contusfly/adapters/holders/MeetSentViewHolder;", "txtSenderViewHolder", "Lcom/contusfly/adapters/holders/TextSentViewHolder;", "setListenersForSenderVideoMessages", "videoSenderViewHolder", "Lcom/contusfly/adapters/holders/VideoSentViewHolder;", "setListenersForSentFileMessages", "setLoginUserContactProfilePicture", "txtSendImg", "isSender", "setMediaCaption", "mediStatus", "Lcom/contusfly/models/MediaCaption;", "setMediaDuration", "txtSendDuration", "fileStatus", "starredMessageItem", "imgChatType", "setMediaStatus", "mediaStatus", "Lcom/contusfly/models/MediaStatus;", "setMeetLinkView", "scheduledMeetLinkView", "scheduledMeetLinkLogo", "setOnStarredMessageDownloadClickListener", "setRecentChatStatus", "status", "Lcom/mirrorflysdk/api/MessageStatus;", "setSearch", "isSearchEnabled", "setSearchHighlightAppCompatTextView", "txtSendName", "Landroidx/appcompat/widget/AppCompatTextView;", "fromHtml", "setSearchTextHighlight", "setSearchTextHighlightMention", "mentionedUserName", "Landroid/text/SpannableStringBuilder;", "setSentStarredContactActions", "starredContactSentHolder", "Lcom/contusfly/adapters/holders/ContactSentViewHolder;", "setStaredStatus", "isStarred", "imageView", "setStarredCaptionStatus", "setStarredMessageMessages", "setStarredMessages", "starredMessages", "setStatus", "imgChatStatus", "setupReceiverHeader", "showHideSenderName", "senderNameHolder", "Lcom/contusfly/adapters/holders/SenderNameHolder;", "showSenderNameIfGroupChat", "starredAudioPlayClick", "seekBar", "doesSentMessage", "starredItemClick", "uploadClick", "carbonRetry", "app_debug"})
public final class StarredMessagesAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<androidx.recyclerview.widget.RecyclerView.ViewHolder> implements com.contusfly.interfaces.MessageItemListener, com.contusfly.interfaces.AudioPlayItemViewSetListener {
    @org.jetbrains.annotations.NotNull
    private final androidx.recyclerview.widget.RecyclerView listChats = null;
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
    private com.contusfly.views.SetDrawable setDrawable;
    private boolean searchEnabled = false;
    private java.lang.String searchKey;
    
    public StarredMessagesAdapter(@org.jetbrains.annotations.NotNull
    androidx.recyclerview.widget.RecyclerView listChats) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.recyclerview.widget.RecyclerView getListChats() {
        return null;
    }
    
    /**
     * Instantiates a new adapter chat data.
     *
     * @param context The startupActivityContext of the activity
     */
    public final void setAdapterData(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
    }
    
    public final void setSearch(boolean isSearchEnabled, @org.jetbrains.annotations.NotNull
    java.lang.String searchKey) {
    }
    
    /**
     * Sets the on download click listener.
     *
     * @param listener The listener when the chat item download clicked
     */
    public final void setOnStarredMessageDownloadClickListener(@org.jetbrains.annotations.Nullable
    com.contusfly.interfaces.OnChatItemClickListener listener) {
    }
    
    /**
     * Sets the Chat Messages in the adapter.
     *
     * @param starredMessages List of chat messages
     */
    public final void setStarredMessages(@org.jetbrains.annotations.NotNull
    java.util.List<? extends com.mirrorflysdk.api.models.ChatMessage> starredMessages) {
    }
    
    /**
     * Set the selected messages from the chat view for displaying the different color
     *
     * @param starredMessageMessages Selected message list
     */
    public final void setStarredMessageMessages(@org.jetbrains.annotations.Nullable
    java.util.List<java.lang.String> starredMessageMessages) {
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public androidx.recyclerview.widget.RecyclerView.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull
    androidx.recyclerview.widget.RecyclerView.ViewHolder holder, int position) {
    }
    
    @java.lang.Override
    public int getItemViewType(int position) {
        return 0;
    }
    
    @java.lang.Override
    public long getItemId(int position) {
        return 0L;
    }
    
    @java.lang.Override
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
    
    public final void showHideSenderName(@org.jetbrains.annotations.NotNull
    com.contusfly.adapters.holders.SenderNameHolder senderNameHolder, @org.jetbrains.annotations.NotNull
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
    
    private final void getStarredMeetViewSender(androidx.recyclerview.widget.RecyclerView.ViewHolder holder, com.mirrorflysdk.api.models.ChatMessage item, int position) {
    }
    
    private final void setMeetLinkView(android.widget.TextView txtChat, android.widget.LinearLayout scheduledMeetLinkView, android.widget.ImageView scheduledMeetLinkLogo) {
    }
    
    private final void setJoinLinkView(android.widget.TextView txtChat, android.widget.LinearLayout joinLinkView, android.widget.ImageView joinLinkLogo, java.lang.String originalMsg) {
    }
    
    /**
     * starred textview for receiver side
     *
     * @param holder   adapter view holder object
     * @param item     object which hold item data
     * @param position of the item
     */
    private final void getStarredTextViewReceiver(androidx.recyclerview.widget.RecyclerView.ViewHolder holder, com.mirrorflysdk.api.models.ChatMessage item, int position) {
    }
    
    private final void getStarredMeetViewReceiver(androidx.recyclerview.widget.RecyclerView.ViewHolder holder, com.mirrorflysdk.api.models.ChatMessage item, int position) {
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
     * @param holder      adapter view holder object
     * @param messageItem object which hold item data
     * @param position    of the item
     */
    private final void getStarredImageViewReceiver(androidx.recyclerview.widget.RecyclerView.ViewHolder holder, com.mirrorflysdk.api.models.ChatMessage messageItem, int position) {
    }
    
    /**
     * starred video view for sender side
     *
     * @param holder      adapter view holder object
     * @param messageItem object which hold item data
     * @param position    of the item
     */
    private final void getStarredVideoViewSender(androidx.recyclerview.widget.RecyclerView.ViewHolder holder, com.mirrorflysdk.api.models.ChatMessage messageItem, int position) {
    }
    
    /**
     * starred video view for receiver side
     *
     * @param holder      adapter view holder object
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
    
    private final void setSentStarredContactActions(com.contusfly.adapters.holders.ContactSentViewHolder starredContactSentHolder, com.mirrorflysdk.api.models.ChatMessage item, int position) {
    }
    
    private final java.lang.String getJidFromSharedContact(com.mirrorflysdk.api.models.ContactChatMessage contactMessage) {
        return null;
    }
    
    /**
     * Method used to set the contact profile picture for logged in user
     *
     * @param txtSendImg The contact profile image view.
     * @param isSender  boolean value to identify sender or receiver
     */
    private final void setLoginUserContactProfilePicture(android.widget.ImageView txtSendImg, boolean isSender) {
    }
    
    private final void setInviteClickListener(android.view.View view, com.mirrorflysdk.api.models.ChatMessage message, int position, java.lang.String jid) {
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
     * Checking user to send contact from receiver side
     *
     * @param holder Holder of the recycler view
     * @param item
     */
    private final void checkUserFromReceiver(androidx.recyclerview.widget.RecyclerView.ViewHolder holder, com.mirrorflysdk.api.models.ChatMessage item) {
    }
    
    private final void fetchProfileDetailOfReceivedNumber(androidx.recyclerview.widget.RecyclerView.ViewHolder holder, java.lang.String receivedNumber) {
    }
    
    private final void handleContactView(com.contusfly.adapters.holders.ContactReceivedViewHolder contactReceiverViewHolder, java.lang.String jID) {
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
     * @param item message item
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
    
    private final void setListenersForSenderTextMessages(com.contusfly.adapters.holders.MeetSentViewHolder meetSendViewHolder, com.mirrorflysdk.api.models.ChatMessage item, int position) {
    }
    
    /**
     * set single & long click Listeners For Sender Side conversation
     *
     * @param senderItem  sender view in conversation
     * @param messageItem object which hold data to display
     * @param position    list item position
     */
    private final void senderItemClick(android.view.View senderItem, com.mirrorflysdk.api.models.ChatMessage messageItem, int position, android.view.View mediaClickView) {
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
    
    private final void setListenersForReceiverTextMessages(com.contusfly.adapters.holders.MeetReceivedViewHolder meetReceivedViewHolder, com.mirrorflysdk.api.models.ChatMessage item, int position) {
    }
    
    /**
     * set single & long click Listeners For Receiver Side conversation
     *
     * @param receiverItem sender view in conversation
     * @param messageItem  object which hold data to display
     * @param position     list item position
     */
    private final void receiverItemClick(android.view.View receiverItem, com.mirrorflysdk.api.models.ChatMessage messageItem, int position, android.view.View mediaClickView) {
    }
    
    /**
     * Handle the audio play click
     *
     * @param chatMessage        chatMessage
     * @param holder            holder of the chat message
     * @param position        Position of the chat item
     * @param playImage       Play button of the audio view
     * @param seekBar         Seek bar of the audio
     * @param durationView    Duration text view
     * @param doesSentMessage Boolean to identify whether the audio message is posted in the chat activity.
     */
    private final void starredAudioPlayClick(com.mirrorflysdk.api.models.ChatMessage chatMessage, androidx.recyclerview.widget.RecyclerView.ViewHolder holder, int position, android.widget.ImageView playImage, android.widget.SeekBar seekBar, android.widget.TextView durationView, boolean doesSentMessage) {
    }
    
    private final int getMessageAudioPosition(java.lang.String messageId) {
        return 0;
    }
    
    /**
     * Handle the audio seekbar click
     *
     * @param chatMessage            Message Item data
     * @param holder          View holder of current view in adapter
     * @param playImage       Play button of the audio view
     * @param starredMsgSeekBar         Seek bar of the audio
     * @param durationView to set  duration in the audio
     */
    private final void setAudioSeekBarListener(com.mirrorflysdk.api.models.ChatMessage chatMessage, androidx.recyclerview.widget.RecyclerView.ViewHolder holder, android.widget.ImageView playImage, android.widget.SeekBar starredMsgSeekBar, android.widget.TextView durationView) {
    }
    
    @java.lang.Override
    public void setChatStatus(@org.jetbrains.annotations.Nullable
    com.mirrorflysdk.api.models.ChatMessage item, @org.jetbrains.annotations.Nullable
    android.widget.ImageView viewHolder) {
    }
    
    @java.lang.Override
    public void setRecentChatStatus(@org.jetbrains.annotations.Nullable
    android.widget.ImageView viewHolder, @org.jetbrains.annotations.Nullable
    com.mirrorflysdk.api.MessageStatus status) {
    }
    
    @java.lang.Override
    public void setMediaStatus(@org.jetbrains.annotations.NotNull
    com.contusfly.models.MediaStatus mediaStatus) {
    }
    
    @java.lang.Override
    public void setMediaCaption(@org.jetbrains.annotations.NotNull
    com.contusfly.models.MediaCaption mediStatus) {
    }
    
    @java.lang.Override
    public void setMediaDuration(@org.jetbrains.annotations.Nullable
    android.widget.TextView txtSendDuration, int fileStatus, @org.jetbrains.annotations.Nullable
    com.mirrorflysdk.api.models.ChatMessage starredMessageItem, @org.jetbrains.annotations.Nullable
    android.widget.ImageView imgChatType) {
    }
    
    @java.lang.Override
    public void setImageViewSize(@org.jetbrains.annotations.Nullable
    java.lang.String starredFileSize, @org.jetbrains.annotations.Nullable
    android.view.View downloadView, @org.jetbrains.annotations.Nullable
    android.widget.TextView starredFileSizeView) {
    }
    
    @java.lang.Override
    public void setStatus(@org.jetbrains.annotations.Nullable
    com.mirrorflysdk.api.models.ChatMessage item, @org.jetbrains.annotations.Nullable
    android.widget.ImageView imgChatStatus) {
    }
    
    /**
     * Gets the chat messages.
     *
     * @return List<Message> List of messages
     *   </Message>
     */
    @org.jetbrains.annotations.Nullable
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
    
    @java.lang.Override
    public void setStaredStatus(boolean isStarred, @org.jetbrains.annotations.NotNull
    android.widget.ImageView imageView) {
    }
    
    @java.lang.Override
    public void setStarredCaptionStatus(boolean isStarred, @org.jetbrains.annotations.NotNull
    android.widget.ImageView imageView) {
    }
    
    @java.lang.Override
    public void currentlyPlayItem(int position, int progress, @org.jetbrains.annotations.NotNull
    java.lang.String playduration) {
    }
    
    /**
     * Stop the player of the Media player.
     */
    public final void pauseMediaPlayer() {
    }
}