package com.contusfly.viewmodels;

import java.lang.System;

/**
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u00e0\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010!\n\u0002\b\u001a\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b0\n\u0002\u0018\u0002\n\u0002\b\u001f\u0018\u00002\u00020\u0001B\u0007\b\u0007\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u00c2\u0001\u001a\u00030\u00c3\u0001J\b\u0010\u00c4\u0001\u001a\u00030\u00c3\u0001J\n\u0010\u00c5\u0001\u001a\u00030\u00c3\u0001H\u0002J\b\u0010\u00c6\u0001\u001a\u00030\u00c3\u0001J\b\u0010\u00c7\u0001\u001a\u00030\u00c3\u0001J\u001a\u0010\u00c8\u0001\u001a\u00030\u00c3\u00012\u0007\u0010\u00c9\u0001\u001a\u0002042\u0007\u0010\u00ca\u0001\u001a\u00020\u0005J\u0012\u0010\u00cb\u0001\u001a\u00030\u00c3\u00012\b\u0010\u00cc\u0001\u001a\u00030\u00cd\u0001J!\u0010\u00ce\u0001\u001a\u00030\u00c3\u00012\u0015\u0010\u00cf\u0001\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0005\u0012\u00030\u00d1\u00010\u00d0\u0001H\u0002J\u0010\u0010N\u001a\u00030\u00c3\u00012\u0007\u0010\u00d2\u0001\u001a\u00020\bJ*\u0010\u00d3\u0001\u001a\u00030\u00c3\u00012\u0007\u0010\u00d2\u0001\u001a\u00020\b2\u0017\u0010\u00d4\u0001\u001a\u0012\u0012\u0004\u0012\u00020\b0$j\b\u0012\u0004\u0012\u00020\b`%J \u0010\u00d5\u0001\u001a\u00030\u00c3\u00012\u0007\u0010\u00d2\u0001\u001a\u00020\b2\r\u0010\u00d4\u0001\u001a\b\u0012\u0004\u0012\u00020\b0$J\u0011\u0010\u00d6\u0001\u001a\u00030\u00c3\u00012\u0007\u0010\u00d2\u0001\u001a\u00020\bJ\u0010\u0010V\u001a\u00030\u00c3\u00012\u0007\u0010\u00d2\u0001\u001a\u00020\bJ8\u0010\u00d7\u0001\u001a\b\u0012\u0004\u0012\u00020T0\u00192\u0017\u0010\u00d4\u0001\u001a\u0012\u0012\u0004\u0012\u00020\b0$j\b\u0012\u0004\u0012\u00020\b`%2\u000e\u0010\u00d8\u0001\u001a\t\u0012\u0004\u0012\u00020Q0\u00a8\u0001H\u0002J\u001f\u0010\u00d9\u0001\u001a\u00030\u00c3\u00012\u0013\u0010\u0095\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u000204030\u0004H\u0002J\u001a\u0010\u00da\u0001\u001a\u00030\u00c3\u00012\u0007\u0010\u00db\u0001\u001a\u00020\b2\u0007\u0010\u00dc\u0001\u001a\u00020\bJ\u001b\u0010\u00dd\u0001\u001a\u00020\u00052\u0007\u0010\u00db\u0001\u001a\u00020\b2\u0007\u0010\u00dc\u0001\u001a\u00020\bH\u0002J\u0012\u0010\u00de\u0001\u001a\u00020\u00052\u0007\u0010\u00df\u0001\u001a\u000204H\u0002J\"\u0010\u00e0\u0001\u001a\u00020\u00052\u000e\u0010\u00e1\u0001\u001a\t\u0012\u0004\u0012\u0002040\u00a8\u00012\u0007\u0010\u00e2\u0001\u001a\u00020\nH\u0002J\u0013\u0010\u00e3\u0001\u001a\u00030\u00c3\u00012\t\b\u0002\u0010\u00e4\u0001\u001a\u00020\nJ\b\u0010\u00e5\u0001\u001a\u00030\u00c3\u0001J\u0010\u0010\u0014\u001a\u00030\u00c3\u00012\u0007\u0010\u00e6\u0001\u001a\u00020\nJ\u0007\u0010\u00e7\u0001\u001a\u00020\nJ\u0010\u0010\u001c\u001a\u00030\u00c3\u00012\u0007\u0010\u00e6\u0001\u001a\u00020\nJ\u0007\u00109\u001a\u00030\u00c3\u0001J\b\u0010\u00e8\u0001\u001a\u00030\u00c3\u0001J\u001d\u0010\u00e9\u0001\u001a\u00020\u001e2\b\u0010\u00ea\u0001\u001a\u00030\u00eb\u0001H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0003\u0010\u00ec\u0001J\u0013\u0010\u00ed\u0001\u001a\u00030\u00c3\u00012\t\b\u0002\u0010\u00ee\u0001\u001a\u00020\u0005J\u0017\u0010\u00ef\u0001\u001a\u00030\u00c3\u00012\r\u0010\u00d4\u0001\u001a\b\u0012\u0004\u0012\u00020\b0\u0019J\u0007\u0010\u00f0\u0001\u001a\u00020\nJ\u001a\u0010\u00f1\u0001\u001a\u00030\u00c3\u00012\u0007\u0010\u00db\u0001\u001a\u00020\b2\u0007\u0010\u00dc\u0001\u001a\u00020\bJ\u001b\u0010\u00f2\u0001\u001a\u00020\u00052\u0007\u0010\u00db\u0001\u001a\u00020\b2\u0007\u0010\u00dc\u0001\u001a\u00020\bH\u0002J\b\u0010\u0084\u0001\u001a\u00030\u00c3\u0001J\b\u0010\u00f3\u0001\u001a\u00030\u00c3\u0001J\b\u0010\u0086\u0001\u001a\u00030\u00c3\u0001J\n\u0010\u0088\u0001\u001a\u00030\u00c3\u0001H\u0002J\n\u0010\u0094\u0001\u001a\u00030\u00c3\u0001H\u0002J!\u0010\u00f4\u0001\u001a\u00030\u00c3\u00012\u0017\u0010\u00d4\u0001\u001a\u0012\u0012\u0004\u0012\u00020\b0$j\b\u0012\u0004\u0012\u00020\b`%J\u0007\u0010\u00f5\u0001\u001a\u00020\nJ\u001a\u0010\u00f6\u0001\u001a\u00030\u00c3\u00012\u0007\u0010\u00db\u0001\u001a\u00020\b2\u0007\u0010\u00dc\u0001\u001a\u00020\bJ\u001a\u0010\u00f7\u0001\u001a\u00030\u00c3\u00012\u0007\u0010\u00db\u0001\u001a\u00020\b2\u0007\u0010\u00dc\u0001\u001a\u00020\bJ\b\u0010\u00f8\u0001\u001a\u00030\u00c3\u0001J$\u0010\u00f9\u0001\u001a\u00020\u00052\u0007\u0010\u00db\u0001\u001a\u00020\b2\u0007\u0010\u00df\u0001\u001a\u0002042\u0007\u0010\u00dc\u0001\u001a\u00020\bH\u0002J\b\u0010\u00fa\u0001\u001a\u00030\u00c3\u0001J\u0007\u0010\u00fb\u0001\u001a\u00020\nJ\u001f\u0010\u00fc\u0001\u001a\u00030\u00c3\u00012\u0013\u0010\u0095\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u000204030\u0004H\u0002J\u001c\u0010\u00fd\u0001\u001a\u00030\u00c3\u00012\u0007\u0010\u00fe\u0001\u001a\u00020\u00052\u0007\u0010\u00df\u0001\u001a\u000204H\u0002J\u001b\u0010\u00ff\u0001\u001a\u00020\n2\u0007\u0010\u008e\u0001\u001a\u0002042\u0007\u0010\u00d2\u0001\u001a\u00020\bH\u0002J\u001b\u0010\u0080\u0002\u001a\u00020\n2\u0007\u0010\u008e\u0001\u001a\u0002042\u0007\u0010\u00d2\u0001\u001a\u00020\bH\u0002J\t\u0010\u0081\u0002\u001a\u00020\nH\u0002J\b\u0010\u0082\u0002\u001a\u00030\u00c3\u0001J\u0012\u0010\u0083\u0002\u001a\u00030\u00c3\u00012\b\u0010\u00cc\u0001\u001a\u00030\u00cd\u0001J\u0012\u0010\u0084\u0002\u001a\u00030\u00c3\u00012\b\u0010\u00cc\u0001\u001a\u00030\u00cd\u0001J\b\u0010\u0085\u0002\u001a\u00030\u00c3\u0001J\b\u0010\u0086\u0002\u001a\u00030\u00c3\u0001J!\u0010\u0087\u0002\u001a\u00030\u00c3\u00012\u0015\u0010\u00cf\u0001\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0005\u0012\u00030\u00d1\u00010\u00d0\u0001H\u0002J\b\u0010\u0088\u0002\u001a\u00030\u00c3\u0001J\u0011\u0010\u0089\u0002\u001a\u00030\u00c3\u00012\u0007\u0010\u008a\u0002\u001a\u00020\nJ\u0013\u0010\u008b\u0002\u001a\u00030\u00c3\u00012\u0007\u0010\u008c\u0002\u001a\u00020\nH\u0002J\b\u0010\u008d\u0002\u001a\u00030\u00c3\u0001J\b\u0010\u008e\u0002\u001a\u00030\u00c3\u0001J\u0007\u0010\u008f\u0002\u001a\u00020\nJ\u001a\u0010\u0090\u0002\u001a\u00030\u00c3\u00012\u0007\u0010\u00db\u0001\u001a\u00020\b2\u0007\u0010\u0091\u0002\u001a\u00020\nJ\u0011\u0010\u0092\u0002\u001a\u00030\u00c3\u00012\u0007\u0010\u0093\u0002\u001a\u00020\nJ\u001a\u0010\u0094\u0002\u001a\u00030\u00c3\u00012\u0007\u0010\u00db\u0001\u001a\u00020\b2\u0007\u0010\u0095\u0002\u001a\u00020\nJ\u0013\u0010\u0096\u0002\u001a\u00030\u00c3\u00012\t\u0010\u00db\u0001\u001a\u0004\u0018\u00010\bJ\u0010\u0010\u0097\u0002\u001a\u00030\u00c3\u00012\u0006\u0010j\u001a\u00020\nJ\u0011\u0010\u0098\u0002\u001a\u00030\u00c3\u00012\u0007\u0010\u0099\u0002\u001a\u00020\bJ\u0014\u0010\u009a\u0002\u001a\u00030\u00c3\u00012\n\u0010\u009b\u0002\u001a\u0005\u0018\u00010\u009c\u0002J\u0013\u0010\u009d\u0002\u001a\u00030\u00c3\u00012\u0007\u0010\u009e\u0002\u001a\u00020\nH\u0002J\u0010\u0010\u009f\u0002\u001a\u00030\u00c3\u00012\u0006\u0010l\u001a\u00020\nJ\u0013\u0010\u00a0\u0002\u001a\u00030\u00c3\u00012\u0007\u0010\u00a1\u0002\u001a\u00020\nH\u0002J#\u0010\u00a2\u0002\u001a\u00030\u00c3\u00012\u0019\u0010\u00a3\u0002\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\n0\u000eJ\u0018\u0010\u00a4\u0002\u001a\u00030\u00c3\u00012\u000e\u0010\u00a5\u0002\u001a\t\u0012\u0004\u0012\u00020\b0\u00a8\u0001J\u001a\u0010\u00a6\u0002\u001a\u00030\u00c3\u00012\u0007\u0010\u00a7\u0002\u001a\u00020\b2\u0007\u0010\u00a8\u0002\u001a\u00020\nJ\u0011\u0010\u00a9\u0002\u001a\u00030\u00c3\u00012\u0007\u0010\u00aa\u0002\u001a\u00020\bJ\b\u0010\u00ab\u0002\u001a\u00030\u00c3\u0001J\u0013\u0010\u00ac\u0002\u001a\u00030\u00c3\u00012\u0007\u0010\u00ad\u0002\u001a\u00020\u0005H\u0002J\u0011\u0010\u00ae\u0002\u001a\u00030\u00c3\u00012\u0007\u0010\u00af\u0002\u001a\u00020\u0016J\u0011\u0010\u00b0\u0002\u001a\u00030\u00c3\u00012\u0007\u0010\u00aa\u0002\u001a\u00020\bJ\n\u0010\u00b1\u0002\u001a\u00030\u00c3\u0001H\u0002J\u0007\u0010\u00b2\u0002\u001a\u00020\nJ!\u0010\u00b3\u0002\u001a\u00030\u00c3\u00012\u0015\u0010\u00cf\u0001\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0005\u0012\u00030\u00d1\u00010\u00d0\u0001H\u0002J%\u0010\u00b4\u0002\u001a\u00030\u00c3\u00012\u001b\u0010\u00b5\u0002\u001a\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010$j\n\u0012\u0004\u0012\u00020\b\u0018\u0001`%J\u0011\u0010\u00b6\u0002\u001a\u00030\u00c3\u00012\u0007\u0010\u00d2\u0001\u001a\u00020\bJ\b\u0010\u00b7\u0002\u001a\u00030\u00c3\u0001J\b\u0010\u00b8\u0002\u001a\u00030\u00c3\u0001J%\u0010\u00b9\u0002\u001a\u00030\u00c3\u00012\u0007\u0010\u00ba\u0002\u001a\u00020\u00052\u0007\u0010\u00fe\u0001\u001a\u00020\u00052\u0007\u0010\u00df\u0001\u001a\u000204H\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR)\u0010\r\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00050\u000e0\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR#\u0010\u0010\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\n0\u00110\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\fR\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\n0\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\fR\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\fR\u001d\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00190\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\fR\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\n0\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\fR\u0017\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\fR\u001d\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020!0\u00190\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010\fR+\u0010#\u001a\u0012\u0012\u0004\u0012\u00020!0$j\b\u0012\u0004\u0012\u00020!`%8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b&\u0010\'R\u0017\u0010*\u001a\b\u0012\u0004\u0012\u00020\b0\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b+\u0010\fR\u0017\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00050-8F\u00a2\u0006\u0006\u001a\u0004\b.\u0010/R\u0017\u00100\u001a\b\u0012\u0004\u0012\u00020\u00050-8F\u00a2\u0006\u0006\u001a\u0004\b1\u0010/R!\u00102\u001a\b\u0012\u0004\u0012\u000204038FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b7\u0010)\u001a\u0004\b5\u00106R\u0017\u00108\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b9\u0010\fR\u001d\u0010:\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u000204030\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b;\u0010\fR\u0017\u0010<\u001a\b\u0012\u0004\u0012\u00020\n0\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b=\u0010\fR\u001d\u0010>\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020?0$0\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b@\u0010\fR)\u0010A\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u000e0\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\bB\u0010\fR\u001d\u0010C\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0$0\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\bD\u0010\fR\u0017\u0010E\u001a\b\u0012\u0004\u0012\u00020\n0\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\bF\u0010\fR\u0017\u0010G\u001a\b\u0012\u0004\u0012\u00020\n0\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\bH\u0010\fR\u000e\u0010I\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010J\u001a\u00020KX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010L\u001a\b\u0012\u0004\u0012\u00020\n0\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\bM\u0010\fR\u001d\u0010N\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002040\u00190\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\bO\u0010\fR\u001d\u0010P\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020Q0\u00190\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\bR\u0010\fR\u001d\u0010S\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020T0\u00190\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\bU\u0010\fR\u001d\u0010V\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002040\u00190\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\bW\u0010\fR\u0017\u0010X\u001a\b\u0012\u0004\u0012\u00020\b0\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\bY\u0010\fR\u0017\u0010Z\u001a\b\u0012\u0004\u0012\u00020\b0\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b[\u0010\fR\u0017\u0010\\\u001a\b\u0012\u0004\u0012\u00020\b0\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b]\u0010\fR\u0017\u0010^\u001a\b\u0012\u0004\u0012\u00020\b0\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b_\u0010\fR\u0017\u0010`\u001a\b\u0012\u0004\u0012\u00020\b0\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\ba\u0010\fR\u001a\u0010b\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bb\u0010c\"\u0004\bd\u0010eR\u0017\u0010f\u001a\b\u0012\u0004\u0012\u00020\n0\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\bf\u0010\fR\u000e\u0010g\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010h\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bh\u0010c\"\u0004\bi\u0010eR\u000e\u0010j\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010k\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010l\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R#\u0010m\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\n0\u00110\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\bm\u0010\fR#\u0010n\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\n0\u00110\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\bn\u0010\fR\u0017\u0010o\u001a\b\u0012\u0004\u0012\u00020\n0\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\bp\u0010\fR\u001a\u0010q\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\br\u0010s\"\u0004\bt\u0010uR)\u0010v\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020w0\u00190\u00110\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\bx\u0010\fR#\u0010y\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00110\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\bz\u0010\fR\u0017\u0010{\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b|\u0010\fR\u0017\u0010}\u001a\b\u0012\u0004\u0012\u00020\b0\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b~\u0010\fR\u0018\u0010\u007f\u001a\b\u0012\u0004\u0012\u00020\n0\u0004\u00a2\u0006\t\n\u0000\u001a\u0005\b\u0080\u0001\u0010\fR\u0019\u0010\u0081\u0001\u001a\b\u0012\u0004\u0012\u00020\u00050$\u00a2\u0006\t\n\u0000\u001a\u0005\b\u0082\u0001\u0010\'R\u0019\u0010\u0083\u0001\u001a\b\u0012\u0004\u0012\u00020\n0\u0004\u00a2\u0006\t\n\u0000\u001a\u0005\b\u0084\u0001\u0010\fR\u001f\u0010\u0085\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020Q0\u00190\u0004\u00a2\u0006\t\n\u0000\u001a\u0005\b\u0086\u0001\u0010\fR\u0019\u0010\u0087\u0001\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0004\u00a2\u0006\t\n\u0000\u001a\u0005\b\u0088\u0001\u0010\fR.\u0010\u0089\u0001\u001a\u0012\u0012\u0004\u0012\u00020Q0$j\b\u0012\u0004\u0012\u00020Q`%8FX\u0086\u0084\u0002\u00a2\u0006\u000e\n\u0005\b\u008b\u0001\u0010)\u001a\u0005\b\u008a\u0001\u0010\'R\u0019\u0010\u008c\u0001\u001a\b\u0012\u0004\u0012\u00020\b0\u0004\u00a2\u0006\t\n\u0000\u001a\u0005\b\u008d\u0001\u0010\fR+\u0010\u008e\u0001\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u000e0\u0004\u00a2\u0006\t\n\u0000\u001a\u0005\b\u008f\u0001\u0010\fR$\u0010\u0090\u0001\u001a\b\u0012\u0004\u0012\u000204038FX\u0086\u0084\u0002\u00a2\u0006\u000e\n\u0005\b\u0092\u0001\u0010)\u001a\u0005\b\u0091\u0001\u00106R\u0019\u0010\u0093\u0001\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0004\u00a2\u0006\t\n\u0000\u001a\u0005\b\u0094\u0001\u0010\fR\u001f\u0010\u0095\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u000204030\u0004\u00a2\u0006\t\n\u0000\u001a\u0005\b\u0096\u0001\u0010\fR\u0010\u0010\u0097\u0001\u001a\u00030\u0098\u0001X\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0099\u0001\u001a\u00030\u009a\u0001X\u0082.\u00a2\u0006\u0002\n\u0000R\u0019\u0010\u009b\u0001\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\t\n\u0000\u001a\u0005\b\u009c\u0001\u0010\fR\u000f\u0010\u009d\u0001\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0019\u0010\u009e\u0001\u001a\b\u0012\u0004\u0012\u00020\n0\u0004\u00a2\u0006\t\n\u0000\u001a\u0005\b\u009f\u0001\u0010\fR\u0019\u0010\u00a0\u0001\u001a\b\u0012\u0004\u0012\u00020\n0\u0004\u00a2\u0006\t\n\u0000\u001a\u0005\b\u00a1\u0001\u0010\fR\u0019\u0010\u00a2\u0001\u001a\b\u0012\u0004\u0012\u00020\n0\u0004\u00a2\u0006\t\n\u0000\u001a\u0005\b\u00a3\u0001\u0010\fR\u000f\u0010\u00a4\u0001\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0019\u0010\u00a5\u0001\u001a\b\u0012\u0004\u0012\u00020\b0\u0004\u00a2\u0006\t\n\u0000\u001a\u0005\b\u00a6\u0001\u0010\fR\u0016\u0010\u00a7\u0001\u001a\t\u0012\u0004\u0012\u00020T0\u00a8\u0001X\u0082\u000e\u00a2\u0006\u0002\n\u0000R \u0010\u00a9\u0001\u001a\u000f\u0012\u000b\u0012\t\u0012\u0004\u0012\u00020\b0\u00a8\u00010\u0004\u00a2\u0006\t\n\u0000\u001a\u0005\b\u00aa\u0001\u0010\fR.\u0010\u00ab\u0001\u001a\u0012\u0012\u0004\u0012\u00020\b0$j\b\u0012\u0004\u0012\u00020\b`%8FX\u0086\u0084\u0002\u00a2\u0006\u000e\n\u0005\b\u00ad\u0001\u0010)\u001a\u0005\b\u00ac\u0001\u0010\'R$\u0010\u00ae\u0001\u001a\b\u0012\u0004\u0012\u0002040$8FX\u0086\u0084\u0002\u00a2\u0006\u000e\n\u0005\b\u00b0\u0001\u0010)\u001a\u0005\b\u00af\u0001\u0010\'R.\u0010\u00b1\u0001\u001a\u0012\u0012\u0004\u0012\u0002040$j\b\u0012\u0004\u0012\u000204`%8FX\u0086\u0084\u0002\u00a2\u0006\u000e\n\u0005\b\u00b3\u0001\u0010)\u001a\u0005\b\u00b2\u0001\u0010\'R\u0019\u0010\u00b4\u0001\u001a\b\u0012\u0004\u0012\u00020\b0-8F\u00a2\u0006\u0007\u001a\u0005\b\u00b5\u0001\u0010/R\u0019\u0010\u00b6\u0001\u001a\b\u0012\u0004\u0012\u00020\n0\u0004\u00a2\u0006\t\n\u0000\u001a\u0005\b\u00b7\u0001\u0010\fR\u000f\u0010\u00b8\u0001\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R6\u0010\u00b9\u0001\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\n0\u000e0$8FX\u0086\u0084\u0002\u00a2\u0006\u000e\n\u0005\b\u00bb\u0001\u0010)\u001a\u0005\b\u00ba\u0001\u0010\'R\u0019\u0010\u00bc\u0001\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\t\n\u0000\u001a\u0005\b\u00bd\u0001\u0010\fR\u0019\u0010\u00be\u0001\u001a\b\u0012\u0004\u0012\u00020\b0\u0004\u00a2\u0006\t\n\u0000\u001a\u0005\b\u00bf\u0001\u0010\fR\u0019\u0010\u00c0\u0001\u001a\b\u0012\u0004\u0012\u00020\b0\u0004\u00a2\u0006\t\n\u0000\u001a\u0005\b\u00c1\u0001\u0010\f\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u00bb\u0002"}, d2 = {"Lcom/contusfly/viewmodels/DashboardViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "_changedPinPosition", "Landroidx/lifecycle/MutableLiveData;", "", "_changedReadUnReadPosition", "_showMessage", "", "addSearchLoader", "", "getAddSearchLoader", "()Landroidx/lifecycle/MutableLiveData;", "archiveChatStatus", "Lkotlin/Triple;", "getArchiveChatStatus", "archiveChatUpdated", "Lkotlin/Pair;", "getArchiveChatUpdated", "archivedSettingsStatus", "getArchivedSettingsStatus", "availableFeatureLiveData", "Lcom/mirrorflysdk/flycommons/Features;", "getAvailableFeatureLiveData", "blockedProfilesLiveData", "", "getBlockedProfilesLiveData", "busySettingsStatus", "getBusySettingsStatus", "callLogDiffResult", "Landroidx/recyclerview/widget/DiffUtil$DiffResult;", "getCallLogDiffResult", "callLogList", "Lcom/mirrorflysdk/flycall/call/database/model/CallLog;", "getCallLogList", "callLogListAdapter", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getCallLogListAdapter", "()Ljava/util/ArrayList;", "callLogListAdapter$delegate", "Lkotlin/Lazy;", "callsSearchKey", "getCallsSearchKey", "changedPinPosition", "Landroidx/lifecycle/LiveData;", "getChangedPinPosition", "()Landroidx/lifecycle/LiveData;", "changedReadUnReadPosition", "getChangedReadUnReadPosition", "chatAdapter", "Ljava/util/LinkedList;", "Lcom/mirrorflysdk/api/models/RecentChat;", "getChatAdapter", "()Ljava/util/LinkedList;", "chatAdapter$delegate", "chatDiffResult", "getChatDiffResult", "chatList", "getChatList", "chatTagDataPinUnpinLoad", "getChatTagDataPinUnpinLoad", "chatTagList", "Lcom/mirrorflysdk/flydatabase/model/ChatTagModel;", "getChatTagList", "chats", "getChats", "clearChatList", "getClearChatList", "clearallCallLog", "getClearallCallLog", "contactSyncNeeded", "getContactSyncNeeded", "currentSearchPage", "exceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "fetchingError", "getFetchingError", "filterArchivedChatList", "getFilterArchivedChatList", "filterContactProfileList", "Lcom/mirrorflysdk/api/contacts/ProfileDetails;", "getFilterContactProfileList", "filterProfileList", "Lcom/contusfly/models/ProfileDetailsShareModel;", "getFilterProfileList", "filterRecentChatList", "getFilterRecentChatList", "groupAdminChangedLiveData", "getGroupAdminChangedLiveData", "groupCreatedLiveData", "getGroupCreatedLiveData", "groupNewUserAddedLiveData", "getGroupNewUserAddedLiveData", "groupUpdatedLiveData", "getGroupUpdatedLiveData", "groupUserRemovedLiveData", "getGroupUserRemovedLiveData", "isArchiveChatTriggered", "()Z", "setArchiveChatTriggered", "(Z)V", "isContactSyncSuccess", "isFetching", "isNeedFetchNextPage", "setNeedFetchNextPage", "isPaginate", "isRefreshing", "isSearchFetching", "isUserBlockedByAdmin", "isUserBlockedUnblockedMe", "launchArchiveactivity", "getLaunchArchiveactivity", "mContactCount", "getMContactCount", "()I", "setMContactCount", "(I)V", "messageList", "Lcom/contusfly/models/RecentSearch;", "getMessageList", "notifyRecentChatInserted", "getNotifyRecentChatInserted", "notifyRecentChatRemoved", "getNotifyRecentChatRemoved", "onTypingStatusGoneUpdate", "getOnTypingStatusGoneUpdate", "paginationLoader", "getPaginationLoader", "pinnedListPosition", "getPinnedListPosition", "privateChatStatus", "getPrivateChatStatus", "profileDetailsList", "getProfileDetailsList", "profileDiffResult", "getProfileDiffResult", "profileListAdapter", "getProfileListAdapter", "profileListAdapter$delegate", "profileUpdatedLiveData", "getProfileUpdatedLiveData", "recentChat", "getRecentChat", "recentChatAdapter", "getRecentChatAdapter", "recentChatAdapter$delegate", "recentChatDiffResult", "getRecentChatDiffResult", "recentChatList", "getRecentChatList", "recentChatListBuilder", "Lcom/mirrorflysdk/api/RecentChatListBuilder;", "recentChatListParams", "Lcom/mirrorflysdk/models/RecentChatListParams;", "recentDeleteChatPosition", "getRecentDeleteChatPosition", "recentPinnedCount", "refreshTheRecentChatList", "getRefreshTheRecentChatList", "removeSearchLoader", "getRemoveSearchLoader", "restartactivityRecentChatListlivedata", "getRestartactivityRecentChatListlivedata", "resultPerPage", "searchKeyLiveData", "getSearchKeyLiveData", "searchList", "", "selectedArchiveChats", "getSelectedArchiveChats", "selectedCallLogs", "getSelectedCallLogs", "selectedCallLogs$delegate", "selectedChats", "getSelectedChats", "selectedChats$delegate", "selectedRecentChats", "getSelectedRecentChats", "selectedRecentChats$delegate", "showMessage", "getShowMessage", "swipeRefreshLoader", "getSwipeRefreshLoader", "totalSearchPage", "typingAndGoneStatus", "getTypingAndGoneStatus", "typingAndGoneStatus$delegate", "unreadChatCountLiveData", "getUnreadChatCountLiveData", "updateLanguageSearch", "getUpdateLanguageSearch", "updateMessageStatus", "getUpdateMessageStatus", "chatHistoryMigration", "", "checkAndUpdateContacts", "checkArchiveChatStatus", "checkContactsUpdate", "clearTypingStatusList", "clearUnreadCount", "item", "itemPos", "createPinShortcutForRecentChat", "context", "Landroid/content/Context;", "failureDataHandle", "data", "Ljava/util/HashMap;", "", "searchKey", "filterContactsList", "jidList", "filterDeviceContactsList", "filterMessageList", "filterSearchList", "userListResult", "footerDataAdd", "getArchiveChatOfUser", "jid", "event", "getArchivePosition", "getArchiveRecentPosition", "recent", "getArchivedChatCount", "archiveChats", "isArchiveSettingsEnable", "getArchivedChatStatus", "callbackFromUpdateArchive", "getArchivedChats", "status", "getArchivedTriggeredStatus", "getChatTagData", "getDiffUtilResult", "diffUtilCallback", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "(Landroidx/recyclerview/widget/DiffUtil$Callback;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getInitialChatList", "recentChatLimit", "getLiveDataForBlockedContacts", "getPaginateBoolean", "getPrivateChatOfUser", "getPrivateChatPosition", "getPrivateChats", "getRecentChatListBasedOnTagData", "getRecentChatListFetching", "getRecentChatOfJid", "getRecentChatOfUser", "getRecentChats", "getRecentPosition", "getRestartActivitygetrecentChatList", "getSearchUserListFetching", "headerDataAdd", "inValidPrivateChatUser", "positionToAdd", "isEmailContact", "isSavedContact", "isSelectedPositionsValidForPin", "launchArchive", "markAsReadPrivateChats", "markAsReadRecentChats", "markAsUnreadPrivateChats", "markAsUnreadRecentChats", "nextDataChecking", "nextSetOfRecentChatList", "onContactSyncFinished", "success", "paginationLoaderShowHide", "isShow", "refreshFetchedRecentChat", "resetSearch", "searchLastPageFetched", "setAdminBlockedStatus", "isAdminBlocked", "setArchiveChatTriggeredStatus", "isTriggered", "setBlockUnBlockJID", "isBlocked", "setClearedMessagesView", "setIsPaginate", "setMessageStatus", "messageId", "setReceivedMsg", "msg", "Lcom/mirrorflysdk/api/models/ChatMessage;", "setRecentChatListFetching", "isfetching", "setSearchUserListFetching", "setSwipeLoader", "isShowStatus", "setTypingStatus", "typingStatus", "updateArchiveChatsList", "selectedJids", "updateArchiveChatsStatus", "toUser", "archiveStatus", "updateArchivedMuteNotification", "type", "updateClearAllCallLogMenu", "updateContacts", "contactCount", "updateFeatureRestriction", "feature", "updateMuteNotification", "updatePaginate", "updatePinnedRecentChats", "updateRecentChats", "updateRecentMessage", "messageIds", "updateSearchLanguage", "updateUnPinnedRecentChats", "updateUnReadChatCount", "validPrivateChatUser", "index", "app_debug"})
public final class DashboardViewModel extends androidx.lifecycle.ViewModel {
    private final kotlinx.coroutines.CoroutineExceptionHandler exceptionHandler = null;
    private boolean isNeedFetchNextPage = false;
    
    /**
     * List to add position of the clicked chats for pinning
     */
    @org.jetbrains.annotations.NotNull
    private final java.util.ArrayList<java.lang.Integer> pinnedListPosition = null;
    private int recentPinnedCount = 0;
    private final androidx.lifecycle.MutableLiveData<java.lang.String> _showMessage = null;
    private boolean isSearchFetching = false;
    private int currentSearchPage = 0;
    private int totalSearchPage = 1;
    private int resultPerPage = 10;
    private boolean isPaginate = false;
    private boolean isFetching = false;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> restartactivityRecentChatListlivedata = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> chatTagDataPinUnpinLoad = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<java.util.LinkedList<com.mirrorflysdk.api.models.RecentChat>> chatList = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<java.util.ArrayList<com.mirrorflysdk.flydatabase.model.ChatTagModel>> chatTagList = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<java.util.LinkedList<com.mirrorflysdk.api.models.RecentChat>> recentChatList = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<java.lang.Integer> notifyRecentChatRemoved = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<kotlin.Pair<java.lang.Integer, java.lang.Integer>> notifyRecentChatInserted = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<kotlin.Triple<java.lang.String, java.lang.Integer, java.lang.Integer>> chats = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<kotlin.Triple<java.lang.String, java.lang.Integer, java.lang.Integer>> recentChat = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<java.lang.Integer> unreadChatCountLiveData = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<java.lang.String> searchKeyLiveData = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<java.lang.String> profileUpdatedLiveData = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<java.util.List<java.lang.String>> blockedProfilesLiveData = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<java.util.ArrayList<java.lang.String>> clearChatList = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<java.lang.Integer> recentDeleteChatPosition = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<kotlin.Triple<java.lang.Boolean, java.lang.Boolean, java.lang.Integer>> archiveChatStatus = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> privateChatStatus = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> archivedSettingsStatus = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> busySettingsStatus = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<kotlin.Pair<java.lang.String, java.lang.Boolean>> archiveChatUpdated = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<java.util.List<java.lang.String>> selectedArchiveChats = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> addSearchLoader = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> removeSearchLoader = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> fetchingError = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<java.lang.String> onTypingStatusGoneUpdate = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<com.mirrorflysdk.flycommons.Features> availableFeatureLiveData = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> clearallCallLog = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> paginationLoader = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> swipeRefreshLoader = null;
    private boolean isArchiveChatTriggered = false;
    private com.mirrorflysdk.models.RecentChatListParams recentChatListParams;
    private com.mirrorflysdk.api.RecentChatListBuilder recentChatListBuilder;
    
    /**
     * Selected recent chats when long press
     */
    @org.jetbrains.annotations.NotNull
    private final kotlin.Lazy selectedChats$delegate = null;
    @org.jetbrains.annotations.NotNull
    private final kotlin.Lazy selectedRecentChats$delegate = null;
    
    /**
     * contacts count from preference
     */
    private int mContactCount = 0;
    
    /**
     * Recent Chat Adapter Value
     */
    @org.jetbrains.annotations.NotNull
    private final kotlin.Lazy chatAdapter$delegate = null;
    @org.jetbrains.annotations.NotNull
    private final kotlin.Lazy recentChatAdapter$delegate = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.mirrorflysdk.api.models.RecentChat>> filterArchivedChatList = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> contactSyncNeeded = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.mirrorflysdk.api.contacts.ProfileDetails>> profileDetailsList = null;
    @org.jetbrains.annotations.NotNull
    private final kotlin.Lazy profileListAdapter$delegate = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<androidx.recyclerview.widget.DiffUtil.DiffResult> profileDiffResult = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> isContactSyncSuccess = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<java.lang.String> callsSearchKey = null;
    @org.jetbrains.annotations.NotNull
    private final kotlin.Lazy typingAndGoneStatus$delegate = null;
    
    /**
     * Recent Chat [DiffUtil.DiffResult]
     */
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<androidx.recyclerview.widget.DiffUtil.DiffResult> chatDiffResult = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<androidx.recyclerview.widget.DiffUtil.DiffResult> recentChatDiffResult = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<java.lang.String> updateMessageStatus = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<java.lang.String> groupCreatedLiveData = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<java.lang.String> groupUpdatedLiveData = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<java.lang.String> groupNewUserAddedLiveData = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<java.lang.String> groupUserRemovedLiveData = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<java.lang.String> groupAdminChangedLiveData = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> refreshTheRecentChatList = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.mirrorflysdk.api.models.RecentChat>> filterRecentChatList = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<kotlin.Pair<java.lang.Integer, java.util.List<com.contusfly.models.RecentSearch>>> messageList = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.mirrorflysdk.api.contacts.ProfileDetails>> filterContactProfileList = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.contusfly.models.ProfileDetailsShareModel>> filterProfileList = null;
    private java.util.List<com.contusfly.models.ProfileDetailsShareModel> searchList;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<kotlin.Pair<java.lang.String, java.lang.Boolean>> isUserBlockedUnblockedMe = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<kotlin.Pair<java.lang.String, java.lang.Boolean>> isUserBlockedByAdmin = null;
    
    /**
     * contact refreshing status
     */
    private boolean isRefreshing = false;
    private final androidx.lifecycle.MutableLiveData<java.lang.Integer> _changedReadUnReadPosition = null;
    private final androidx.lifecycle.MutableLiveData<java.lang.Integer> _changedPinPosition = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.mirrorflysdk.flycall.call.database.model.CallLog>> callLogList = null;
    @org.jetbrains.annotations.NotNull
    private final kotlin.Lazy callLogListAdapter$delegate = null;
    @org.jetbrains.annotations.NotNull
    private final kotlin.Lazy selectedCallLogs$delegate = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<androidx.recyclerview.widget.DiffUtil.DiffResult> callLogDiffResult = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<java.lang.String> updateLanguageSearch = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> launchArchiveactivity = null;
    
    @javax.inject.Inject
    public DashboardViewModel() {
        super();
    }
    
    public final boolean isNeedFetchNextPage() {
        return false;
    }
    
    public final void setNeedFetchNextPage(boolean p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.ArrayList<java.lang.Integer> getPinnedListPosition() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<java.lang.String> getShowMessage() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<java.lang.Boolean> getRestartactivityRecentChatListlivedata() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<java.lang.Boolean> getChatTagDataPinUnpinLoad() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<java.util.LinkedList<com.mirrorflysdk.api.models.RecentChat>> getChatList() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<java.util.ArrayList<com.mirrorflysdk.flydatabase.model.ChatTagModel>> getChatTagList() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<java.util.LinkedList<com.mirrorflysdk.api.models.RecentChat>> getRecentChatList() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<java.lang.Integer> getNotifyRecentChatRemoved() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<kotlin.Pair<java.lang.Integer, java.lang.Integer>> getNotifyRecentChatInserted() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<kotlin.Triple<java.lang.String, java.lang.Integer, java.lang.Integer>> getChats() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<kotlin.Triple<java.lang.String, java.lang.Integer, java.lang.Integer>> getRecentChat() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<java.lang.Integer> getUnreadChatCountLiveData() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<java.lang.String> getSearchKeyLiveData() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<java.lang.String> getProfileUpdatedLiveData() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<java.util.List<java.lang.String>> getBlockedProfilesLiveData() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<java.util.ArrayList<java.lang.String>> getClearChatList() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<java.lang.Integer> getRecentDeleteChatPosition() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<kotlin.Triple<java.lang.Boolean, java.lang.Boolean, java.lang.Integer>> getArchiveChatStatus() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<java.lang.Boolean> getPrivateChatStatus() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<java.lang.Boolean> getArchivedSettingsStatus() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<java.lang.Boolean> getBusySettingsStatus() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<kotlin.Pair<java.lang.String, java.lang.Boolean>> getArchiveChatUpdated() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<java.util.List<java.lang.String>> getSelectedArchiveChats() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<java.lang.Boolean> getAddSearchLoader() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<java.lang.Boolean> getRemoveSearchLoader() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<java.lang.Boolean> getFetchingError() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<java.lang.String> getOnTypingStatusGoneUpdate() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<com.mirrorflysdk.flycommons.Features> getAvailableFeatureLiveData() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<java.lang.Boolean> getClearallCallLog() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<java.lang.Boolean> getPaginationLoader() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<java.lang.Boolean> getSwipeRefreshLoader() {
        return null;
    }
    
    public final boolean isArchiveChatTriggered() {
        return false;
    }
    
    public final void setArchiveChatTriggered(boolean p0) {
    }
    
    /**
     * Selected recent chats when long press
     */
    @org.jetbrains.annotations.NotNull
    public final java.util.ArrayList<com.mirrorflysdk.api.models.RecentChat> getSelectedChats() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.ArrayList<com.mirrorflysdk.api.models.RecentChat> getSelectedRecentChats() {
        return null;
    }
    
    public final int getMContactCount() {
        return 0;
    }
    
    public final void setMContactCount(int p0) {
    }
    
    /**
     * Recent Chat Adapter Value
     */
    @org.jetbrains.annotations.NotNull
    public final java.util.LinkedList<com.mirrorflysdk.api.models.RecentChat> getChatAdapter() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.LinkedList<com.mirrorflysdk.api.models.RecentChat> getRecentChatAdapter() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<java.util.List<com.mirrorflysdk.api.models.RecentChat>> getFilterArchivedChatList() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<java.lang.Boolean> getContactSyncNeeded() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<java.util.List<com.mirrorflysdk.api.contacts.ProfileDetails>> getProfileDetailsList() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.ArrayList<com.mirrorflysdk.api.contacts.ProfileDetails> getProfileListAdapter() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<androidx.recyclerview.widget.DiffUtil.DiffResult> getProfileDiffResult() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<java.lang.Boolean> isContactSyncSuccess() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<java.lang.String> getCallsSearchKey() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.ArrayList<kotlin.Triple<java.lang.String, java.lang.String, java.lang.Boolean>> getTypingAndGoneStatus() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<androidx.recyclerview.widget.DiffUtil.DiffResult> getChatDiffResult() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<androidx.recyclerview.widget.DiffUtil.DiffResult> getRecentChatDiffResult() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<java.lang.String> getUpdateMessageStatus() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<java.lang.String> getGroupCreatedLiveData() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<java.lang.String> getGroupUpdatedLiveData() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<java.lang.String> getGroupNewUserAddedLiveData() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<java.lang.String> getGroupUserRemovedLiveData() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<java.lang.String> getGroupAdminChangedLiveData() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<java.lang.Boolean> getRefreshTheRecentChatList() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<java.util.List<com.mirrorflysdk.api.models.RecentChat>> getFilterRecentChatList() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<kotlin.Pair<java.lang.Integer, java.util.List<com.contusfly.models.RecentSearch>>> getMessageList() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<java.util.List<com.mirrorflysdk.api.contacts.ProfileDetails>> getFilterContactProfileList() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<java.util.List<com.contusfly.models.ProfileDetailsShareModel>> getFilterProfileList() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<kotlin.Pair<java.lang.String, java.lang.Boolean>> isUserBlockedUnblockedMe() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<kotlin.Pair<java.lang.String, java.lang.Boolean>> isUserBlockedByAdmin() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<java.lang.Integer> getChangedReadUnReadPosition() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<java.lang.Integer> getChangedPinPosition() {
        return null;
    }
    
    public final void setBlockUnBlockJID(@org.jetbrains.annotations.NotNull
    java.lang.String jid, boolean isBlocked) {
    }
    
    public final void setAdminBlockedStatus(@org.jetbrains.annotations.NotNull
    java.lang.String jid, boolean isAdminBlocked) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<java.util.List<com.mirrorflysdk.flycall.call.database.model.CallLog>> getCallLogList() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.ArrayList<com.mirrorflysdk.flycall.call.database.model.CallLog> getCallLogListAdapter() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.ArrayList<java.lang.String> getSelectedCallLogs() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<androidx.recyclerview.widget.DiffUtil.DiffResult> getCallLogDiffResult() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<java.lang.String> getUpdateLanguageSearch() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<java.lang.Boolean> getLaunchArchiveactivity() {
        return null;
    }
    
    public final void launchArchive() {
    }
    
    public final void getProfileDetailsList() {
    }
    
    public final void getRecentChats() {
    }
    
    public final void getRestartActivitygetrecentChatList() {
    }
    
    public final void chatHistoryMigration() {
    }
    
    private final void setSwipeLoader(boolean isShowStatus) {
    }
    
    public final void setArchiveChatTriggeredStatus(boolean isTriggered) {
    }
    
    public final boolean getArchivedTriggeredStatus() {
        return false;
    }
    
    private final void setRecentChatListFetching(boolean isfetching) {
    }
    
    public final boolean getRecentChatListFetching() {
        return false;
    }
    
    public final void getInitialChatList(int recentChatLimit) {
    }
    
    private final void nextDataChecking(java.util.HashMap<java.lang.String, java.lang.Object> data) {
    }
    
    private final void headerDataAdd(androidx.lifecycle.MutableLiveData<java.util.LinkedList<com.mirrorflysdk.api.models.RecentChat>> recentChatList) {
    }
    
    private final void footerDataAdd(androidx.lifecycle.MutableLiveData<java.util.LinkedList<com.mirrorflysdk.api.models.RecentChat>> recentChatList) {
    }
    
    private final void failureDataHandle(java.util.HashMap<java.lang.String, java.lang.Object> data) {
    }
    
    private final void checkArchiveChatStatus() {
    }
    
    public final void refreshFetchedRecentChat() {
    }
    
    public final void getChatTagData() {
    }
    
    public final void getRecentChatListBasedOnTagData(@org.jetbrains.annotations.NotNull
    java.util.ArrayList<java.lang.String> jidList) {
    }
    
    public final void nextSetOfRecentChatList() {
    }
    
    private final void updateRecentChats(java.util.HashMap<java.lang.String, java.lang.Object> data) {
    }
    
    private final void paginationLoaderShowHide(boolean isShow) {
    }
    
    public final void setTypingStatus(@org.jetbrains.annotations.NotNull
    kotlin.Triple<java.lang.String, java.lang.String, java.lang.Boolean> typingStatus) {
    }
    
    private final void getProfileDiffResult() {
    }
    
    public final void getChatDiffResult() {
    }
    
    private final void getRecentChatDiffResult() {
    }
    
    private final java.lang.Object getDiffUtilResult(androidx.recyclerview.widget.DiffUtil.Callback diffUtilCallback, kotlin.coroutines.Continuation<? super androidx.recyclerview.widget.DiffUtil.DiffResult> continuation) {
        return null;
    }
    
    public final void filterDeviceContactsList(@org.jetbrains.annotations.NotNull
    java.lang.String searchKey, @org.jetbrains.annotations.NotNull
    java.util.ArrayList<java.lang.String> jidList) {
    }
    
    public final void filterContactsList(@org.jetbrains.annotations.NotNull
    java.lang.String searchKey, @org.jetbrains.annotations.NotNull
    java.util.ArrayList<java.lang.String> jidList) {
    }
    
    private final void updatePaginate() {
    }
    
    private final java.util.List<com.contusfly.models.ProfileDetailsShareModel> filterSearchList(java.util.ArrayList<java.lang.String> jidList, java.util.List<com.mirrorflysdk.api.contacts.ProfileDetails> userListResult) {
        return null;
    }
    
    public final boolean searchLastPageFetched() {
        return false;
    }
    
    public final void resetSearch() {
    }
    
    public final void setSearchUserListFetching(boolean isSearchFetching) {
    }
    
    public final boolean getSearchUserListFetching() {
        return false;
    }
    
    public final void setIsPaginate(boolean isPaginate) {
    }
    
    public final boolean getPaginateBoolean() {
        return false;
    }
    
    public final void getRecentChatOfUser(@org.jetbrains.annotations.NotNull
    java.lang.String jid, @org.jetbrains.annotations.NotNull
    @com.contusfly.interfaces.RecentChatEvent
    java.lang.String event) {
    }
    
    /**
     * This method will return the position of chat
     */
    private final int getRecentPosition(java.lang.String jid, com.mirrorflysdk.api.models.RecentChat recent, @com.contusfly.interfaces.RecentChatEvent
    java.lang.String event) {
        return 0;
    }
    
    private final int getArchiveRecentPosition(com.mirrorflysdk.api.models.RecentChat recent) {
        return 0;
    }
    
    public final void filterRecentChatList(@org.jetbrains.annotations.NotNull
    java.lang.String searchKey) {
    }
    
    private final boolean isEmailContact(com.mirrorflysdk.api.models.RecentChat recentChat, java.lang.String searchKey) {
        return false;
    }
    
    private final boolean isSavedContact(com.mirrorflysdk.api.models.RecentChat recentChat, java.lang.String searchKey) {
        return false;
    }
    
    /**
     * Validating the selected chat count and updating db
     */
    public final boolean updatePinnedRecentChats() {
        return false;
    }
    
    private final boolean isSelectedPositionsValidForPin() {
        return false;
    }
    
    /**
     * Updating db once the pinned chat is unpinned
     */
    public final void updateUnPinnedRecentChats() {
    }
    
    /**
     * Updating db once the recent chat is read
     */
    public final void markAsReadRecentChats(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
    }
    
    public final void markAsUnreadRecentChats() {
    }
    
    /**
     * Updating db once the recent private chat is read
     */
    public final void markAsReadPrivateChats(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
    }
    
    public final void markAsUnreadPrivateChats() {
    }
    
    public final void filterMessageList(@org.jetbrains.annotations.NotNull
    java.lang.String searchKey) {
    }
    
    public final void updateUnReadChatCount() {
    }
    
    public final void setReceivedMsg(@org.jetbrains.annotations.Nullable
    com.mirrorflysdk.api.models.ChatMessage msg) {
    }
    
    public final void setMessageStatus(@org.jetbrains.annotations.NotNull
    java.lang.String messageId) {
    }
    
    public final void setClearedMessagesView(@org.jetbrains.annotations.Nullable
    java.lang.String jid) {
    }
    
    public final void getRecentChatOfJid(@org.jetbrains.annotations.NotNull
    java.lang.String jid, @org.jetbrains.annotations.NotNull
    @com.contusfly.interfaces.RecentChatEvent
    java.lang.String event) {
    }
    
    public final void getLiveDataForBlockedContacts(@org.jetbrains.annotations.NotNull
    java.util.List<java.lang.String> jidList) {
    }
    
    public final void updateRecentMessage(@org.jetbrains.annotations.Nullable
    java.util.ArrayList<java.lang.String> messageIds) {
    }
    
    public final void clearTypingStatusList() {
    }
    
    public final void updateMuteNotification(@org.jetbrains.annotations.NotNull
    java.lang.String type) {
    }
    
    public final void createPinShortcutForRecentChat(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
    }
    
    public final void getArchivedChats() {
    }
    
    public final void getPrivateChatOfUser(@org.jetbrains.annotations.NotNull
    java.lang.String jid, @org.jetbrains.annotations.NotNull
    @com.contusfly.interfaces.RecentChatEvent
    java.lang.String event) {
    }
    
    private final void validPrivateChatUser(int index, int positionToAdd, com.mirrorflysdk.api.models.RecentChat recent) {
    }
    
    private final void inValidPrivateChatUser(int positionToAdd, com.mirrorflysdk.api.models.RecentChat recent) {
    }
    
    /**
     * This method will return the position of chat
     */
    private final int getPrivateChatPosition(java.lang.String jid, @com.contusfly.interfaces.RecentChatEvent
    java.lang.String event) {
        return 0;
    }
    
    public final void getArchiveChatOfUser(@org.jetbrains.annotations.NotNull
    java.lang.String jid, @org.jetbrains.annotations.NotNull
    @com.contusfly.interfaces.RecentChatEvent
    java.lang.String event) {
    }
    
    /**
     * This method will return the position of chat
     */
    private final int getArchivePosition(java.lang.String jid, @com.contusfly.interfaces.RecentChatEvent
    java.lang.String event) {
        return 0;
    }
    
    public final void updateArchivedMuteNotification(@org.jetbrains.annotations.NotNull
    java.lang.String type) {
    }
    
    /**
     * Updating archived chats when search key updated
     */
    public final void filterArchivedChatList(@org.jetbrains.annotations.NotNull
    java.lang.String searchKey) {
    }
    
    public final void clearUnreadCount(@org.jetbrains.annotations.NotNull
    com.mirrorflysdk.api.models.RecentChat item, int itemPos) {
    }
    
    public final void getArchivedChatStatus(boolean callbackFromUpdateArchive) {
    }
    
    public final void getPrivateChatStatus() {
    }
    
    public final void getPrivateChats() {
    }
    
    private final int getArchivedChatCount(java.util.List<com.mirrorflysdk.api.models.RecentChat> archiveChats, boolean isArchiveSettingsEnable) {
        return 0;
    }
    
    public final void getArchivedSettingsStatus(boolean status) {
    }
    
    public final void getBusySettingsStatus(boolean status) {
    }
    
    public final void updateArchiveChatsStatus(@org.jetbrains.annotations.NotNull
    java.lang.String toUser, boolean archiveStatus) {
    }
    
    public final void updateArchiveChatsList(@org.jetbrains.annotations.NotNull
    java.util.List<java.lang.String> selectedJids) {
    }
    
    public final void updateSearchLanguage(@org.jetbrains.annotations.NotNull
    java.lang.String searchKey) {
    }
    
    public final void updateFeatureRestriction(@org.jetbrains.annotations.NotNull
    com.mirrorflysdk.flycommons.Features feature) {
    }
    
    public final void updateClearAllCallLogMenu() {
    }
    
    public final void checkAndUpdateContacts() {
    }
    
    public final void checkContactsUpdate() {
    }
    
    /**
     * sync contact whenever its updated
     *
     * @param contactCount current contact count
     */
    private final void updateContacts(int contactCount) {
    }
    
    public final void onContactSyncFinished(boolean success) {
    }
}