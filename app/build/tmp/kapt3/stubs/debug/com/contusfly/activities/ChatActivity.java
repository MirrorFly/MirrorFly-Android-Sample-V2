package com.contusfly.activities;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0082\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u0015\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00f6\u00022\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u00072\u00020\b2\u00020\t2\u00020\n2\u00020\u000b2\u00020\f:\u0002\u00f6\u0002B\u0005\u00a2\u0006\u0002\u0010\rJ\b\u0010K\u001a\u00020LH\u0002J\b\u0010M\u001a\u00020LH\u0002J\u0010\u0010N\u001a\u00020L2\u0006\u0010\u0019\u001a\u00020\u000fH\u0002J\b\u0010O\u001a\u00020LH\u0016J\u0010\u0010P\u001a\u00020L2\u0006\u0010Q\u001a\u00020\u0012H\u0002J\b\u0010R\u001a\u00020LH\u0002J\u0010\u0010S\u001a\u00020L2\u0006\u0010T\u001a\u00020UH\u0002J\u0010\u0010V\u001a\u00020L2\u0006\u0010W\u001a\u00020UH\u0002J\u0006\u0010X\u001a\u00020LJ\b\u0010Y\u001a\u00020LH\u0014J\b\u0010Z\u001a\u00020LH\u0002J\b\u0010[\u001a\u00020LH\u0002J\u0010\u0010\\\u001a\u00020L2\u0006\u0010]\u001a\u00020\u000fH\u0016J\u0018\u0010^\u001a\u00020L2\u0006\u0010_\u001a\u00020`2\u0006\u0010T\u001a\u00020UH\u0002J\u0010\u0010a\u001a\u00020L2\u0006\u0010b\u001a\u00020!H\u0002J\u0010\u0010c\u001a\u00020L2\u0006\u0010d\u001a\u00020CH\u0002J\b\u0010e\u001a\u00020LH\u0002J\u0010\u0010f\u001a\u00020\u000f2\u0006\u0010g\u001a\u00020\u000fH\u0002J\b\u0010h\u001a\u00020iH\u0002J\b\u0010j\u001a\u00020\u000fH\u0002J\b\u0010k\u001a\u00020\u0012H\u0002J\u000e\u0010l\u001a\u00020\u000f2\u0006\u0010m\u001a\u00020\u000fJ\u0010\u0010n\u001a\u00020L2\u0006\u0010o\u001a\u00020\u001fH\u0002J\u0010\u0010p\u001a\u00020L2\u0006\u0010b\u001a\u00020!H\u0002J\u0010\u0010q\u001a\u00020L2\u0006\u0010r\u001a\u00020\u0012H\u0002J\u0010\u0010s\u001a\u00020L2\u0006\u0010t\u001a\u00020\u0012H\u0002J\b\u0010u\u001a\u00020LH\u0002J\"\u0010v\u001a\u00020L2\b\u0010w\u001a\u0004\u0018\u00010x2\u0006\u0010_\u001a\u00020`2\u0006\u0010T\u001a\u00020UH\u0002J\b\u0010y\u001a\u00020LH\u0002J\u0010\u0010z\u001a\u00020L2\u0006\u0010w\u001a\u00020xH\u0002J\b\u0010{\u001a\u00020LH\u0002J\b\u0010|\u001a\u00020LH\u0002J\u0018\u0010}\u001a\u00020L2\u0006\u0010T\u001a\u00020U2\u0006\u0010~\u001a\u00020\u000fH\u0002J\u0010\u0010\u007f\u001a\u00020L2\u0006\u0010o\u001a\u00020\u001fH\u0002J\u0011\u0010\u0080\u0001\u001a\u00020L2\u0006\u0010w\u001a\u00020xH\u0002J1\u0010\u0081\u0001\u001a\u00020L2&\u0010\u0082\u0001\u001a!\u0012\u0016\u0012\u00140\u000f\u00a2\u0006\u000f\b\u0084\u0001\u0012\n\b\u0085\u0001\u0012\u0005\b\b(\u0086\u0001\u0012\u0004\u0012\u00020L0\u0083\u0001H\u0002J\t\u0010\u0087\u0001\u001a\u00020LH\u0002J\t\u0010\u0088\u0001\u001a\u00020LH\u0002J\t\u0010\u0089\u0001\u001a\u00020LH\u0002J\t\u0010\u008a\u0001\u001a\u00020LH\u0002J\t\u0010\u008b\u0001\u001a\u00020LH\u0002J\t\u0010\u008c\u0001\u001a\u00020LH\u0002J\t\u0010\u008d\u0001\u001a\u00020LH\u0002J\t\u0010\u008e\u0001\u001a\u00020LH\u0002J$\u0010\u008f\u0001\u001a\u00020L2\u0019\u0010\u0090\u0001\u001a\u0014\u0012\u0004\u0012\u00020!0\u0091\u0001j\t\u0012\u0004\u0012\u00020!`\u0092\u0001H\u0002J\t\u0010\u0093\u0001\u001a\u00020LH\u0002J\t\u0010\u0094\u0001\u001a\u00020\u0012H\u0002J\t\u0010\u0095\u0001\u001a\u00020\u0012H\u0002J\t\u0010\u0096\u0001\u001a\u00020\u0012H\u0002J$\u0010\u0097\u0001\u001a\u00020\u00122\u0019\u0010\u0098\u0001\u001a\u0014\u0012\u0004\u0012\u00020!0\u0091\u0001j\t\u0012\u0004\u0012\u00020!`\u0092\u0001H\u0002J\t\u0010\u0099\u0001\u001a\u00020LH\u0002J\t\u0010\u009a\u0001\u001a\u00020LH\u0002J\t\u0010\u009b\u0001\u001a\u00020LH\u0002J\u0011\u0010\u009c\u0001\u001a\u00020L2\u0006\u0010T\u001a\u00020UH\u0016J\t\u0010\u009d\u0001\u001a\u00020LH\u0002J$\u0010\u009e\u0001\u001a\u00020L2\u0019\u0010\u0098\u0001\u001a\u0014\u0012\u0004\u0012\u00020!0\u0091\u0001j\t\u0012\u0004\u0012\u00020!`\u0092\u0001H\u0002J\t\u0010\u009f\u0001\u001a\u00020LH\u0002J\u0012\u0010\u00a0\u0001\u001a\u00020L2\u0007\u0010\u00a1\u0001\u001a\u00020\u0012H\u0002J\t\u0010\u00a2\u0001\u001a\u00020LH\u0002J\u0011\u0010\u00a3\u0001\u001a\u00020L2\u0006\u0010\u0019\u001a\u00020\u000fH\u0002J*\u0010\u00a4\u0001\u001a\u00020L2\u0006\u0010Q\u001a\u00020\u00122\u0011\b\u0002\u0010\u00a5\u0001\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0015H\u0002\u00a2\u0006\u0003\u0010\u00a6\u0001J\u001b\u0010\u00a7\u0001\u001a\u00020L2\u0007\u0010\u00a8\u0001\u001a\u00020\u000f2\u0007\u0010\u00a9\u0001\u001a\u00020UH\u0002J\t\u0010\u00aa\u0001\u001a\u00020LH\u0016J\u0013\u0010\u00ab\u0001\u001a\u00020L2\b\u0010~\u001a\u0004\u0018\u00010\u000fH\u0002J\t\u0010\u00ac\u0001\u001a\u00020LH\u0002J\u0012\u0010\u00ad\u0001\u001a\u00020L2\u0007\u0010\u00ae\u0001\u001a\u00020\u0012H\u0002J\u001d\u0010\u00af\u0001\u001a\u00020\u00122\b\u0010\u00b0\u0001\u001a\u00030\u00b1\u00012\b\u0010\u00b2\u0001\u001a\u00030\u00b3\u0001H\u0016J\u0012\u0010\u00b4\u0001\u001a\u00020\u00122\u0007\u0010\u00b5\u0001\u001a\u00020UH\u0002J&\u0010\u00b6\u0001\u001a\u00020L2\u0007\u0010\u00a9\u0001\u001a\u00020U2\u0007\u0010\u00b7\u0001\u001a\u00020U2\t\u0010\u00b8\u0001\u001a\u0004\u0018\u00010\u001fH\u0014J#\u0010\u00b9\u0001\u001a\u00020L2\u0006\u0010m\u001a\u00020\u000f2\u0007\u0010\u00ba\u0001\u001a\u00020\u000f2\u0007\u0010\u00bb\u0001\u001a\u00020\u0012H\u0016J\t\u0010\u00bc\u0001\u001a\u00020LH\u0002J\t\u0010\u00bd\u0001\u001a\u00020LH\u0002J\t\u0010\u00be\u0001\u001a\u00020LH\u0016J\t\u0010\u00bf\u0001\u001a\u00020LH\u0016J&\u0010\u00c0\u0001\u001a\u00020L2\u0007\u0010\u00c1\u0001\u001a\u00020\u00122\u0007\u0010\u00c2\u0001\u001a\u00020\u00122\t\b\u0002\u0010\u00c3\u0001\u001a\u00020\u0012H\u0002J\u0011\u0010\u00c4\u0001\u001a\u00020L2\u0006\u0010b\u001a\u00020!H\u0016J\u0011\u0010\u00c5\u0001\u001a\u00020L2\u0006\u0010b\u001a\u00020!H\u0016J\u0013\u0010\u00c6\u0001\u001a\u00020L2\b\u0010\u00c7\u0001\u001a\u00030\u00c8\u0001H\u0016J\t\u0010\u00c9\u0001\u001a\u00020LH\u0016J.\u0010\u00ca\u0001\u001a\u00020L2\u0007\u0010\u00cb\u0001\u001a\u00020!2\u0006\u0010T\u001a\u00020U2\t\u0010\u00cc\u0001\u001a\u0004\u0018\u00010\u000f2\u0007\u0010\u00cd\u0001\u001a\u00020\u0012H\u0016J\u0015\u0010\u00ce\u0001\u001a\u00020L2\n\u0010\u00cf\u0001\u001a\u0005\u0018\u00010\u00d0\u0001H\u0014J\u001d\u0010\u00d1\u0001\u001a\u00020\u00122\b\u0010\u00b0\u0001\u001a\u00030\u00b1\u00012\b\u0010\u00d2\u0001\u001a\u00030\u00d3\u0001H\u0016J\u0013\u0010\u00d4\u0001\u001a\u00020\u00122\b\u0010\u00d2\u0001\u001a\u00030\u00d3\u0001H\u0016J\u0012\u0010\u00d5\u0001\u001a\u00020L2\u0007\u0010\u00d6\u0001\u001a\u00020\u000fH\u0016J\t\u0010\u00d7\u0001\u001a\u00020LH\u0014J\u0013\u0010\u00d8\u0001\u001a\u00020L2\b\u0010\u00b0\u0001\u001a\u00030\u00b1\u0001H\u0016J\u001c\u0010\u00d9\u0001\u001a\u00020L2\b\u0010_\u001a\u0004\u0018\u00010`2\u0007\u0010\u00da\u0001\u001a\u00020\u0012H\u0016J\u0011\u0010\u00db\u0001\u001a\u00020L2\u0006\u0010b\u001a\u00020!H\u0016J\u0015\u0010\u00dc\u0001\u001a\u00020L2\n\u0010\u00c7\u0001\u001a\u0005\u0018\u00010\u00c8\u0001H\u0016J\u0015\u0010\u00dd\u0001\u001a\u00020L2\n\u0010\u00de\u0001\u001a\u0005\u0018\u00010\u00df\u0001H\u0016J\u0011\u0010\u00e0\u0001\u001a\u00020L2\u0006\u0010]\u001a\u00020!H\u0016J\u0012\u0010\u00e1\u0001\u001a\u00020L2\u0007\u0010\u00d6\u0001\u001a\u00020\u000fH\u0016J\u001c\u0010\u00e2\u0001\u001a\u00020L2\t\u0010\u00cb\u0001\u001a\u0004\u0018\u00010!2\u0006\u0010T\u001a\u00020UH\u0016J\u0011\u0010\u00e3\u0001\u001a\u00020L2\u0006\u0010T\u001a\u00020UH\u0002J\u0011\u0010\u00e4\u0001\u001a\u00020L2\u0006\u0010T\u001a\u00020UH\u0002J\u001b\u0010\u00e5\u0001\u001a\u00020L2\u0007\u0010\u00d6\u0001\u001a\u00020\u000f2\u0007\u0010\u00e6\u0001\u001a\u00020\u000fH\u0016J\u0011\u0010\u00e7\u0001\u001a\u00020L2\u0006\u0010]\u001a\u00020!H\u0016J$\u0010\u00e8\u0001\u001a\u00020L2\u0007\u0010\u00d6\u0001\u001a\u00020\u000f2\u0007\u0010\u00e9\u0001\u001a\u00020\u000f2\u0007\u0010\u00ea\u0001\u001a\u00020\u000fH\u0016J$\u0010\u00eb\u0001\u001a\u00020L2\u0007\u0010\u00d6\u0001\u001a\u00020\u000f2\u0007\u0010\u00ec\u0001\u001a\u00020\u000f2\u0007\u0010\u00ed\u0001\u001a\u00020\u000fH\u0016J\u0012\u0010\u00ee\u0001\u001a\u00020L2\u0007\u0010\u00ef\u0001\u001a\u00020!H\u0016J\u0015\u0010\u00f0\u0001\u001a\u00020L2\n\u0010\u00f1\u0001\u001a\u0005\u0018\u00010\u00f2\u0001H\u0007J\u0011\u0010\u00f3\u0001\u001a\u00020L2\u0006\u0010]\u001a\u00020!H\u0016J\u0011\u0010\u00f4\u0001\u001a\u00020L2\u0006\u0010~\u001a\u00020\u000fH\u0016J,\u0010\u00f5\u0001\u001a\u00020L2\u0019\u0010\u00f6\u0001\u001a\u0014\u0012\u0004\u0012\u00020\u000f0\u0091\u0001j\t\u0012\u0004\u0012\u00020\u000f`\u0092\u00012\u0006\u0010m\u001a\u00020\u000fH\u0016J\u0011\u0010\u00f7\u0001\u001a\u00020L2\u0006\u0010o\u001a\u00020\u001fH\u0014J$\u0010\u00f8\u0001\u001a\u00020L2\u0007\u0010\u00d6\u0001\u001a\u00020\u000f2\u0007\u0010\u00f9\u0001\u001a\u00020\u000f2\u0007\u0010\u00fa\u0001\u001a\u00020\u000fH\u0016J\u0013\u0010\u00fb\u0001\u001a\u00020\u00122\b\u0010\u00cb\u0001\u001a\u00030\u00b3\u0001H\u0016J\t\u0010\u00fc\u0001\u001a\u00020LH\u0014J!\u0010\u00fd\u0001\u001a\u00020\u00122\n\u0010\u00b0\u0001\u001a\u0005\u0018\u00010\u00b1\u00012\n\u0010\u00d2\u0001\u001a\u0005\u0018\u00010\u00d3\u0001H\u0016J\u001c\u0010\u00fe\u0001\u001a\u00020L2\t\u0010\u00cb\u0001\u001a\u0004\u0018\u00010!2\u0006\u0010T\u001a\u00020UH\u0016J\u001c\u0010\u00ff\u0001\u001a\u00020L2\t\u0010\u00cb\u0001\u001a\u0004\u0018\u00010!2\u0006\u0010T\u001a\u00020UH\u0016J\t\u0010\u0080\u0002\u001a\u00020LH\u0016J\t\u0010\u0081\u0002\u001a\u00020LH\u0016J\t\u0010\u0082\u0002\u001a\u00020LH\u0016J\t\u0010\u0083\u0002\u001a\u00020LH\u0016J\u0012\u0010\u0084\u0002\u001a\u00020L2\u0007\u0010\u0085\u0002\u001a\u00020\u000fH\u0016J3\u0010\u0086\u0002\u001a\u00020L2\u0007\u0010\u00a9\u0001\u001a\u00020U2\u000f\u0010\u0087\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000f0\u00152\b\u0010\u0088\u0002\u001a\u00030\u0089\u0002H\u0016\u00a2\u0006\u0003\u0010\u008a\u0002J\t\u0010\u008b\u0002\u001a\u00020LH\u0014J\u0014\u0010\u008c\u0002\u001a\u00020L2\t\u0010\u00cb\u0001\u001a\u0004\u0018\u00010!H\u0016J\u001a\u0010\u008d\u0002\u001a\u00020L2\u0007\u0010\u008e\u0002\u001a\u00020!2\u0006\u0010T\u001a\u00020UH\u0002J\u001c\u0010\u008f\u0002\u001a\u00020L2\t\u0010\u00cb\u0001\u001a\u0004\u0018\u00010!2\u0006\u0010T\u001a\u00020UH\u0016J\u001c\u0010\u0090\u0002\u001a\u00020L2\t\u0010\u00cb\u0001\u001a\u0004\u0018\u00010!2\u0006\u0010T\u001a\u00020UH\u0016J\u001a\u0010\u0091\u0002\u001a\u00020L2\u0007\u0010\u00cb\u0001\u001a\u00020!2\u0006\u0010T\u001a\u00020UH\u0016J\t\u0010\u0092\u0002\u001a\u00020LH\u0002J\t\u0010\u0093\u0002\u001a\u00020LH\u0016J\t\u0010\u0094\u0002\u001a\u00020LH\u0016J\u0011\u0010\u0095\u0002\u001a\u00020L2\u0006\u0010d\u001a\u00020\u000fH\u0016J\u001f\u0010\u0096\u0002\u001a\u00020\u00122\b\u0010\u00c7\u0001\u001a\u00030\u00c8\u00012\n\u0010\u00f1\u0001\u001a\u0005\u0018\u00010\u0097\u0002H\u0017J\u001b\u0010\u0098\u0002\u001a\u00020L2\b\u0010_\u001a\u0004\u0018\u00010`2\u0006\u0010T\u001a\u00020UH\u0016J\u001a\u0010\u0099\u0002\u001a\u00020L2\u0006\u0010~\u001a\u00020\u000f2\u0007\u0010\u009a\u0002\u001a\u00020UH\u0016J\u0013\u0010\u009b\u0002\u001a\u00020L2\b\u0010\u009c\u0002\u001a\u00030\u009d\u0002H\u0016J\u0014\u0010\u009e\u0002\u001a\u00020L2\t\b\u0002\u0010\u009f\u0002\u001a\u00020\u0012H\u0002J\t\u0010\u00a0\u0002\u001a\u00020LH\u0002J\u0011\u0010\u00a1\u0002\u001a\u00020L2\u0006\u0010t\u001a\u00020\u0012H\u0002J*\u0010\u00a2\u0002\u001a\u00020L2\u0007\u0010\u00a3\u0002\u001a\u00020\u000f2\u0016\u0010\u00a4\u0002\u001a\u0011\u0012\u0004\u0012\u00020U\u0012\u0006\u0012\u0004\u0018\u00010!0\u00a5\u0002H\u0002J\u0012\u0010\u00a6\u0002\u001a\u00020L2\u0007\u0010\u00ef\u0001\u001a\u00020!H\u0002J*\u0010\u00a7\u0002\u001a\u00020L2\u0007\u0010\u00a3\u0002\u001a\u00020\u000f2\u0016\u0010\u00a4\u0002\u001a\u0011\u0012\u0004\u0012\u00020U\u0012\u0006\u0012\u0004\u0018\u00010!0\u00a5\u0002H\u0002J\t\u0010\u00a8\u0002\u001a\u00020LH\u0002J\t\u0010\u00a9\u0002\u001a\u00020LH\u0002J\t\u0010\u00aa\u0002\u001a\u00020LH\u0002J\u0011\u0010\u00ab\u0002\u001a\u00020L2\u0006\u0010~\u001a\u00020\u000fH\u0002J\t\u0010\u00ac\u0002\u001a\u00020LH\u0014J\t\u0010\u00ad\u0002\u001a\u00020LH\u0002J\t\u0010\u00ae\u0002\u001a\u00020LH\u0002J\u0012\u0010\u00af\u0002\u001a\u00020L2\u0007\u0010\u00b0\u0002\u001a\u00020!H\u0002J\u0012\u0010\u00b1\u0002\u001a\u00020L2\u0007\u0010\u00b2\u0002\u001a\u00020\u000fH\u0002J\t\u0010\u00b3\u0002\u001a\u00020LH\u0002J\t\u0010\u00b4\u0002\u001a\u00020LH\u0002J\u0012\u0010\u00b5\u0002\u001a\u00020L2\u0007\u0010\u00b8\u0001\u001a\u00020\u001fH\u0002J\t\u0010\u00b6\u0002\u001a\u00020LH\u0002J\u0015\u0010\u00b7\u0002\u001a\u00020L2\n\u0010\u00b8\u0002\u001a\u0005\u0018\u00010\u00b9\u0002H\u0002J\u0011\u0010\u00ba\u0002\u001a\u00020L2\u0006\u0010o\u001a\u00020\u001fH\u0002J\u0012\u0010\u00bb\u0002\u001a\u00020L2\u0007\u0010\u00bc\u0002\u001a\u00020\u000fH\u0002J\u0012\u0010\u00bd\u0002\u001a\u00020L2\u0007\u0010\u00b8\u0001\u001a\u00020\u001fH\u0002J\u0013\u0010\u00be\u0002\u001a\u00020L2\b\u0010\u00bf\u0002\u001a\u00030\u00c0\u0002H\u0002J\u0013\u0010\u00c1\u0002\u001a\u00020L2\b\u0010\u00c2\u0002\u001a\u00030\u00c3\u0002H\u0002J\t\u0010\u00c4\u0002\u001a\u00020LH\u0002J\t\u0010\u00c5\u0002\u001a\u00020LH\u0002J\t\u0010\u00c6\u0002\u001a\u00020LH\u0002J\t\u0010\u00c7\u0002\u001a\u00020LH\u0002J\t\u0010\u00c8\u0002\u001a\u00020LH\u0002J\u001b\u0010\u00c9\u0002\u001a\u00020L2\u0007\u0010\u00ca\u0002\u001a\u00020\u000f2\u0007\u0010\u00cb\u0002\u001a\u00020\u000fH\u0002J\t\u0010\u0082\u0001\u001a\u00020LH\u0002J\u0016\u0010\u00cc\u0002\u001a\u00020L2\u000b\b\u0002\u0010\u00cb\u0001\u001a\u0004\u0018\u00010!H\u0002J\t\u0010\u00cd\u0002\u001a\u00020LH\u0002J\t\u0010\u00ce\u0002\u001a\u00020LH\u0002J\t\u0010\u00cf\u0002\u001a\u00020LH\u0002J\t\u0010\u00d0\u0002\u001a\u00020LH\u0002J$\u0010\u00d1\u0002\u001a\u00020L2\u0007\u0010\u00d2\u0002\u001a\u00020\u000f2\u0007\u0010\u00d3\u0002\u001a\u00020\u000f2\u0007\u0010\u00d4\u0002\u001a\u00020\u000fH\u0016J\t\u0010\u00d5\u0002\u001a\u00020LH\u0002J/\u0010\u00d6\u0002\u001a\u00020L2\u0007\u0010\u00d7\u0002\u001a\u00020U2\u001b\b\u0002\u0010\u00d8\u0002\u001a\u0014\u0012\u0004\u0012\u00020!0\u0091\u0001j\t\u0012\u0004\u0012\u00020!`\u0092\u0001H\u0002J\t\u0010\u00d9\u0002\u001a\u00020LH\u0002J\t\u0010\u00da\u0002\u001a\u00020LH\u0002J\t\u0010\u00db\u0002\u001a\u00020LH\u0002J\t\u0010\u00dc\u0002\u001a\u00020LH\u0002J\t\u0010\u00dd\u0002\u001a\u00020LH\u0002J\t\u0010\u00de\u0002\u001a\u00020LH\u0002J\t\u0010\u00df\u0002\u001a\u00020LH\u0002J\t\u0010\u00e0\u0002\u001a\u00020LH\u0002J\t\u0010\u00e1\u0002\u001a\u00020LH\u0002J\t\u0010\u00e2\u0002\u001a\u00020LH\u0002J\u0014\u0010\u00e3\u0002\u001a\u00020L2\t\b\u0002\u0010\u00c3\u0001\u001a\u00020\u0012H\u0002J\t\u0010\u00e4\u0002\u001a\u00020LH\u0002J\u0013\u0010\u00e5\u0002\u001a\u00020L2\b\u0010\u00e6\u0002\u001a\u00030\u00e7\u0002H\u0014J\u0013\u0010\u00e8\u0002\u001a\u00020L2\b\u0010\u00e6\u0002\u001a\u00030\u00e7\u0002H\u0002J\u0013\u0010\u00e9\u0002\u001a\u00020L2\b\u0010\u00d2\u0001\u001a\u00030\u00d3\u0001H\u0003J\u0012\u0010\u00ea\u0002\u001a\u00020L2\u0007\u0010\u00eb\u0002\u001a\u00020\u0012H\u0014J\t\u0010\u00ec\u0002\u001a\u00020LH\u0002J\u0011\u0010\u00ed\u0002\u001a\u00020L2\u0006\u0010m\u001a\u00020\u000fH\u0016J\u0011\u0010\u00ee\u0002\u001a\u00020L2\u0006\u0010m\u001a\u00020\u000fH\u0016J\u0011\u0010\u00ef\u0002\u001a\u00020L2\u0006\u0010m\u001a\u00020\u000fH\u0016J\u0011\u0010\u00f0\u0002\u001a\u00020L2\u0006\u0010m\u001a\u00020\u000fH\u0016J\u0018\u0010\u00f1\u0002\u001a\u00020L2\r\u0010\u00f2\u0002\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0017H\u0016J\u0013\u0010\u00f3\u0002\u001a\u00020L2\b\u0010\u00ef\u0001\u001a\u00030\u00f4\u0002H\u0002J\u0013\u0010\u00f5\u0002\u001a\u00020L2\b\u0010\u00c2\u0002\u001a\u00030\u00c3\u0002H\u0002R\u0016\u0010\u000e\u001a\n \u0010*\u0004\u0018\u00010\u000f0\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u00150\u0014X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u00150\u0014X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u00150\u0014X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u001e\u001a\u0010\u0012\f\u0012\n \u0010*\u0004\u0018\u00010\u001f0\u001f0\u0014X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\'\u001a\u0004\u0018\u00010(X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010)\u001a\u00060*j\u0002`+X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001e\u0010,\u001a\u00020-8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001c\u00102\u001a\u0004\u0018\u000103X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u000e\u00108\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u00109\u001a\b\u0012\u0004\u0012\u00020\u000f0:X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010;\u001a\u0004\u0018\u00010<X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010=\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u00150\u0014X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010>\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u00150\u0014X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020@X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010B\u001a\u0004\u0018\u00010CX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010D\u001a\u0004\u0018\u00010\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010E\u001a\u0004\u0018\u00010\u001cX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010F\u001a\u0010\u0012\f\u0012\n \u0010*\u0004\u0018\u00010\u000f0\u000f0GX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010H\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010I\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010J\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u00150\u0014X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u00f7\u0002"}, d2 = {"Lcom/contusfly/activities/ChatActivity;", "Lcom/contusfly/activities/parent/ChatParent;", "Landroid/view/ActionMode$Callback;", "Landroid/view/View$OnTouchListener;", "Lio/github/rockerhieu/emojicon/EmojiconsFragment$OnEmojiconBackspaceClickedListener;", "Lio/github/rockerhieu/emojicon/EmojiconGridFragment$OnEmojiconClickedListener;", "Lcom/contusfly/interfaces/OnChatItemClickListener;", "Lcom/contusfly/views/CommonAlertDialog$CommonDialogClosedListener;", "Lcom/contusfly/views/CommonAlertDialog$CommonTripleDialogClosedListener;", "Landroid/view/View$OnClickListener;", "Lcom/contusfly/adapters/ReplySuggestionsAdapter$SuggestionClickListener;", "Lcom/contusfly/views/AudioRecordView$RecordingListener;", "Lcom/contusfly/adapters/GroupTagAdapter$UserTagClickListener;", "()V", "TAG", "", "kotlin.jvm.PlatformType", "adminBlockStatus", "", "audioCallPermissionLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "", "callMetaDataList", "", "Lcom/mirrorflysdk/flycommons/models/CallMetaData;", "callType", "contactSavePermissionLauncher", "dateChangedBroadcastReceiver", "Landroid/content/BroadcastReceiver;", "downloadPermissionLauncher", "editMessageCallback", "Landroid/content/Intent;", "forwardClickedItem", "Lcom/mirrorflysdk/api/models/ChatMessage;", "gestureDetector", "Landroid/view/GestureDetector;", "handler", "Landroid/os/Handler;", "isComingFromFilePicker", "keyboardHeightProvider", "Lcom/contusfly/views/KeyboardHeightProvider;", "loadNextRunnable", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "mainApplication", "Landroid/app/Application;", "getMainApplication", "()Landroid/app/Application;", "setMainApplication", "(Landroid/app/Application;)V", "mediaListCaption", "Lcom/contusfly/utils/MediaCaptionMentionList;", "getMediaListCaption", "()Lcom/contusfly/utils/MediaCaptionMentionList;", "setMediaListCaption", "(Lcom/contusfly/utils/MediaCaptionMentionList;)V", "mentionFilterKey", "mentionedUsersIds", "", "myApp", "Lcom/contusfly/constants/MobileApplication;", "notificationMediaPermissionLauncher", "notificationPermissionLauncher", "permissionDeniedListener", "Lcom/contusfly/interfaces/PermissionDialogListener;", "selectedReportMessage", "sendTextMessageWithMentionFormat", "", "smartReply", "telephoneCallReceiver", "uploadDownloadProgressObserver", "Lio/reactivex/subjects/PublishSubject;", "userJid", "userType", "videoCallPermissionLauncher", "addOrBlockLayoutVisibility", "", "blockContact", "callMenuClicked", "chatConnectionErrorResponse", "checkAndCreateAnonymousCall", "isAudioCall", "checkIsGroupAdminBlocked", "checkSelectedMessagesActionModeValidation", "position", "", "checkStoragePermissionAndAllow", "clickedPos", "clear", "clearActionMenu", "clearEditText", "clearNotification", "connectionFailed", "message", "deleteChat", "dialogType", "Lcom/contusfly/views/CommonAlertDialog$DIALOGTYPE;", "dowoanloadMedia", "messageItem", "filterGroupListTag", "text", "forwardMessageAfterDisableBusyStatus", "getChatTypingUserName", "userName", "getKeyboardListener", "Lcom/contusfly/views/KeyboardHeightProvider$KeyboardListener;", "getReporterName", "getUnreadMessageAvailable", "getUserFromJid", "jid", "handleAudioVideoIntentFromGalleryMenu", "intent", "handleCancelClickedOnMediaMessage", "handleClearConversation", "clearChatExceptStarredMessages", "handleCommonDeleteOperation", "isRecalled", "handleCursorAndKeyboardVisibility", "handleDialogResp", "action", "Lcom/contusfly/views/CommonAlertDialog$DialogAction;", "handleDownloadProcess", "handleFailureResponse", "handleListItemClick", "handleMainIntent", "handleMediaMessageClick", "messageId", "handleOnNewIntent", "handleSuccessResponse", "handleVoiceRecording", "sendVoiceMessage", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "mediaPath", "hideEmojiHandlerKeyboard", "hideEmojiKeyboard", "hideGroupMentionMembersList", "highlightGivenMessage", "initChatAdapter", "initClickListeners", "initGroupTag", "initObservers", "initSuggestion", "messageList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "initialization", "isAdminAndUserProfileNotBlocked", "isUnreadMessageAvailableInDb", "isUnreadMessageAvailableInList", "isUnreadMessageAvailableIncomingList", "messagesList", "launchAudioCall", "launchEditMessageActivity", "launchVideoCall", "listOptionSelected", "loadNextData", "loadPreviousMessageChekcingUnreadMessage", "loaderObserver", "loaderShowHide", "isShowStatus", "maintainReplacedMentionUserList", "makeAudioVideoCalls", "makeCallWithCallPermissionUtils", "callMetaDataArray", "(Z[Lcom/mirrorflysdk/flycommons/models/CallMetaData;)V", "mediaClickEvent", "selectedOptionName", "requestCode", "mediaPermissionCheck", "navigateToContactViewPage", "navigateToEditMessageActivityAfterDisableBusyStatus", "notificationPermissionChecking", "isCall", "onActionItemClicked", "mode", "Landroid/view/ActionMode;", "menuItem", "Landroid/view/MenuItem;", "onActionMenuClick", "itemId", "onActivityResult", "resultCode", "data", "onAdminBlockedOtherUser", "type", "status", "onAttachmentClickCallBackAfterDisableBusyStatus", "onAudioClickCallBackAfterDisableBusyStatus", "onAudioPlayed", "onBackPressed", "onBlockUserResponse", "isError", "isBlockedStatus", "isFromEditMessage", "onCancelDownloadClicked", "onCancelUploadClicked", "onClick", "v", "Landroid/view/View;", "onConnected", "onContactClick", "item", "registeredJid", "isSavedContact", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateActionMode", "menu", "Landroid/view/Menu;", "onCreateOptionsMenu", "onDeleteGroup", "groupJid", "onDestroy", "onDestroyActionMode", "onDialogClosed", "isSuccess", "onDownloadClicked", "onEmojiconBackspaceClicked", "onEmojiconClicked", "emojicon", "Lio/github/rockerhieu/emojicon/emoji/Emojicon;", "onGroupNotificationMessage", "onGroupProfileUpdated", "onHandleStarredItemMediaClickToAction", "onItemClick", "onItemLongClick", "onLeftFromGroup", "leftUserJid", "onMediaStatusUpdated", "onMemberMadeAsAdmin", "newAdminMemberJid", "madeByMemberJid", "onMemberRemovedFromGroup", "removedMemberJid", "removedByMemberJid", "onMessageEdited", "editedMessage", "onMessageEvent", "event", "Lcom/contusfly/models/PrivateChatAuthenticationModel;", "onMessageReceived", "onMessageStatusUpdated", "onMessagesClearedOrDeleted", "messageIds", "onNewIntent", "onNewMemberAddedToGroup", "newMemberJid", "addedByMemberJid", "onOptionsItemSelected", "onPause", "onPrepareActionMode", "onReceiverItemClicked", "onReceiverItemLongClick", "onRecordingCanceled", "onRecordingCompleted", "onRecordingLocked", "onRecordingStarted", "onReplyMessageClick", "itemMessageId", "onRequestPermissionsResult", "permissions", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "onRetryClicked", "onSelectItem", "clickedMessage", "onSenderItemClicked", "onSenderItemLongClick", "onSenderMediaForward", "onShowScheduleBottomSheetAfterDisableBusyStatus", "onStart", "onStop", "onSuggestionClick", "onTouch", "Landroid/view/MotionEvent;", "onTripleOptionDialogClosed", "onUploadDownloadProgressChanged", "progressPercentage", "onUserTagClicked", "profileDetails", "Lcom/mirrorflysdk/api/contacts/ProfileDetails;", "pauseAudioRecording", "activityHidden", "recallSelectedMessages", "refreshDeleteOrRecalledMessagesInAdapter", "refreshEditedMessageUpdated", "mid", "messageAndPosition", "Lkotlin/Pair;", "refreshEditedMessages", "refreshMessageStatusUpdated", "registerTelephonyCallListener", "reloadUserChat", "removeUnReadMsgSeparator", "replyParentMessageLoadFromDB", "restoreCompleted", "scheduleFabButtonClickableFunctionality", "scheduleMeetFabButtonClickAndMove", "scrollPosition", "tempMessage", "sendAudioMessage", "audioPath", "sendAudioRecording", "sendChatMessage", "sendContactMessage", "sendDeleteMessageIQRequest", "sendDocumentsMessage", "filePathUri", "Landroid/net/Uri;", "sendImageFromGallery", "sendImageMessage", "imagePath", "sendLocationMessage", "sendMeetMessage", "meetMessageParams", "Lcom/contusfly/models/MeetMessageParams;", "sendMessage", "messageObject", "Lcom/contusfly/models/MessageObject;", "sendQueuedMessageAfterDisableBusyStatus", "sendQueuedUpMessages", "sendSmartReply", "sendSmartReplyMessage", "sendTextMessage", "sendVideoFromGallery", "videoFilePath", "videoCaption", "senderMediaForward", "setMentionPopupBackground", "setMessageCallBack", "setRecyclerViewScrollListener", "setSecureFlag", "setTypingStatus", "singleOrGroupJid", "userId", "composing", "setUpListeners", "showBottomMessage", "messageCount", "nextMessageList", "showGroupBlockedByAdminNotification", "showPausedOngoingRecording", "showReportMessagePopup", "showScheduleBottomSheetFragment", "showSoftKeyboardAfterDisableBusyStatus", "smartReplySuggestionCallback", "startDashboardActivity", "startObserving", "startObservingViewModel", "unRegisterTelephonyCallListener", "unblockContact", "updateDeletedUserMessages", "updateFeatureActions", "features", "Lcom/mirrorflysdk/flycommons/Features;", "updateMenuIcons", "updateMenuItemsClicks", "updateNetworkStateChange", "isConnected", "updateReplyMessageAction", "userBlockedMe", "userDeletedHisProfile", "userUnBlockedMe", "userUpdatedHisProfile", "usersIBlockedListFetched", "jidList", "validateAndSendEditedMessage", "Lcom/contusfly/models/EditMessageParams;", "validateAndSendMessage", "Companion", "app_debug"})
public final class ChatActivity extends com.contusfly.activities.parent.ChatParent implements android.view.ActionMode.Callback, android.view.View.OnTouchListener, io.github.rockerhieu.emojicon.EmojiconsFragment.OnEmojiconBackspaceClickedListener, io.github.rockerhieu.emojicon.EmojiconGridFragment.OnEmojiconClickedListener, com.contusfly.interfaces.OnChatItemClickListener, com.contusfly.views.CommonAlertDialog.CommonDialogClosedListener, com.contusfly.views.CommonAlertDialog.CommonTripleDialogClosedListener, android.view.View.OnClickListener, com.contusfly.adapters.ReplySuggestionsAdapter.SuggestionClickListener, com.contusfly.views.AudioRecordView.RecordingListener, com.contusfly.adapters.GroupTagAdapter.UserTagClickListener {
    private final java.lang.String TAG = null;
    private com.contusfly.views.KeyboardHeightProvider keyboardHeightProvider;
    @org.jetbrains.annotations.NotNull
    public static final com.contusfly.activities.ChatActivity.Companion Companion = null;
    @org.jetbrains.annotations.NotNull
    private static java.util.ArrayList<com.mirrorflysdk.api.contacts.ProfileDetails> unSentMentionedUserIdList;
    private static boolean addMoreMediaClicked = false;
    private com.contusfly.constants.MobileApplication myApp;
    @org.jetbrains.annotations.Nullable
    private com.contusfly.utils.MediaCaptionMentionList mediaListCaption;
    @javax.inject.Inject
    public android.app.Application mainApplication;
    private final io.reactivex.subjects.PublishSubject<java.lang.String> uploadDownloadProgressObserver = null;
    
    /**
     * The receiver to handle the telephony call state.
     */
    private android.content.BroadcastReceiver telephoneCallReceiver;
    private java.lang.String smartReply;
    private com.mirrorflysdk.api.models.ChatMessage forwardClickedItem;
    private java.lang.String selectedReportMessage = "";
    private boolean adminBlockStatus = false;
    private java.lang.String userJid = "";
    private java.lang.String userType = "";
    private android.os.Handler handler;
    private java.lang.String callType = "";
    private java.util.List<java.lang.String> mentionedUsersIds;
    private java.lang.CharSequence sendTextMessageWithMentionFormat;
    private java.lang.String mentionFilterKey;
    private android.view.GestureDetector gestureDetector;
    private java.util.List<com.mirrorflysdk.flycommons.models.CallMetaData> callMetaDataList;
    private boolean isComingFromFilePicker = false;
    private final androidx.activity.result.ActivityResultLauncher<java.lang.String[]> contactSavePermissionLauncher = null;
    private final androidx.activity.result.ActivityResultLauncher<java.lang.String[]> downloadPermissionLauncher = null;
    private final androidx.activity.result.ActivityResultLauncher<java.lang.String[]> audioCallPermissionLauncher = null;
    private final androidx.activity.result.ActivityResultLauncher<java.lang.String[]> notificationPermissionLauncher = null;
    private final androidx.activity.result.ActivityResultLauncher<java.lang.String[]> notificationMediaPermissionLauncher = null;
    private final androidx.activity.result.ActivityResultLauncher<java.lang.String[]> videoCallPermissionLauncher = null;
    private final com.contusfly.interfaces.PermissionDialogListener permissionDeniedListener = null;
    private final java.lang.Runnable loadNextRunnable = null;
    private final androidx.activity.result.ActivityResultLauncher<android.content.Intent> editMessageCallback = null;
    private final android.content.BroadcastReceiver dateChangedBroadcastReceiver = null;
    private java.util.HashMap _$_findViewCache;
    
    public ChatActivity() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.contusfly.utils.MediaCaptionMentionList getMediaListCaption() {
        return null;
    }
    
    public final void setMediaListCaption(@org.jetbrains.annotations.Nullable
    com.contusfly.utils.MediaCaptionMentionList p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final android.app.Application getMainApplication() {
        return null;
    }
    
    public final void setMainApplication(@org.jetbrains.annotations.NotNull
    android.app.Application p0) {
    }
    
    private final void launchAudioCall() {
    }
    
    private final void makeCallWithCallPermissionUtils(boolean isAudioCall, com.mirrorflysdk.flycommons.models.CallMetaData[] callMetaDataArray) {
    }
    
    @java.lang.SuppressWarnings(value = {"kotlin:1144"})
    private final void checkAndCreateAnonymousCall(boolean isAudioCall) {
    }
    
    private final void notificationPermissionChecking(boolean isCall) {
    }
    
    private final void launchVideoCall() {
    }
    
    private final void loadNextData() {
    }
    
    @java.lang.Override
    public void onMessageReceived(@org.jetbrains.annotations.NotNull
    com.mirrorflysdk.api.models.ChatMessage message) {
    }
    
    @java.lang.Override
    public void onMessageEdited(@org.jetbrains.annotations.NotNull
    com.mirrorflysdk.api.models.ChatMessage editedMessage) {
    }
    
    private final void refreshEditedMessages(com.mirrorflysdk.api.models.ChatMessage editedMessage) {
    }
    
    /**
     * Called when the profile update of the logged in user has been completed successfully.
     */
    @java.lang.Override
    public void userUpdatedHisProfile(@org.jetbrains.annotations.NotNull
    java.lang.String jid) {
    }
    
    /**
     * To handle callback of any user's profile deleted
     */
    @java.lang.Override
    public void userDeletedHisProfile(@org.jetbrains.annotations.NotNull
    java.lang.String jid) {
    }
    
    private final void updateDeletedUserMessages() {
    }
    
    /**
     * Update the network state change while user chat with other user.
     */
    @java.lang.Override
    protected void updateNetworkStateChange(boolean isConnected) {
    }
    
    @java.lang.Override
    public void onLeftFromGroup(@org.jetbrains.annotations.NotNull
    java.lang.String groupJid, @org.jetbrains.annotations.NotNull
    java.lang.String leftUserJid) {
    }
    
    /**
     * Handle the upload/download progress changes
     */
    @java.lang.Override
    public void onUploadDownloadProgressChanged(@org.jetbrains.annotations.NotNull
    java.lang.String messageId, int progressPercentage) {
    }
    
    private final void initObservers() {
    }
    
    /**
     * Called when the upload has been completed from the chat view in the async task.
     *
     * @param message Updated message
     */
    @java.lang.Override
    public void onMediaStatusUpdated(@org.jetbrains.annotations.NotNull
    com.mirrorflysdk.api.models.ChatMessage message) {
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final void setSecureFlag() {
    }
    
    private final void setRecyclerViewScrollListener() {
    }
    
    private final void initClickListeners() {
    }
    
    @java.lang.Override
    public void onStart() {
    }
    
    @java.lang.Override
    public void onStop() {
    }
    
    private final void initChatAdapter() {
    }
    
    private final void startObservingViewModel() {
    }
    
    private final void loadPreviousMessageChekcingUnreadMessage(java.util.ArrayList<com.mirrorflysdk.api.models.ChatMessage> messagesList) {
    }
    
    private final boolean isUnreadMessageAvailableIncomingList(java.util.ArrayList<com.mirrorflysdk.api.models.ChatMessage> messagesList) {
        return false;
    }
    
    private final void highlightGivenMessage() {
    }
    
    private final boolean isUnreadMessageAvailableInDb() {
        return false;
    }
    
    private final boolean isUnreadMessageAvailableInList() {
        return false;
    }
    
    private final void startObserving() {
    }
    
    /**
     * Handle the list item click and long click from the recycler view of the chat view.
     */
    private final void handleListItemClick() {
    }
    
    /**
     * Handle On item long click for the options having delete, forward and info. Add into the
     * selected list for the list showing and do the operations
     *
     * @param position Position of the clicked list item
     */
    private final void onItemLongClick(int position) {
    }
    
    /**
     * Handle On item click for the options having delete, forward and info. and remove that from
     * the selected list
     *
     * @param position Position of the item
     */
    private final void onItemClick(int position) {
    }
    
    /**
     * Call back for on item selection
     *
     * @param clickedMessage Selected message item
     */
    private final void onSelectItem(com.mirrorflysdk.api.models.ChatMessage clickedMessage, int position) {
    }
    
    @java.lang.Override
    public void onDeleteGroup(@org.jetbrains.annotations.NotNull
    java.lang.String groupJid) {
    }
    
    private final void startDashboardActivity() {
    }
    
    @java.lang.Override
    public boolean onCreateOptionsMenu(@org.jetbrains.annotations.NotNull
    android.view.Menu menu) {
        return false;
    }
    
    private final void updateMenuIcons(com.mirrorflysdk.flycommons.Features features) {
    }
    
    @android.annotation.SuppressLint(value = {"RestrictedApi"})
    private final void updateMenuItemsClicks(android.view.Menu menu) {
    }
    
    @java.lang.Override
    public boolean onOptionsItemSelected(@org.jetbrains.annotations.NotNull
    android.view.MenuItem item) {
        return false;
    }
    
    private final void callMenuClicked(@com.mirrorflysdk.flycall.webrtc.CallType
    java.lang.String callType) {
    }
    
    private final void makeAudioVideoCalls(java.lang.String callType) {
    }
    
    private final void initialization() {
    }
    
    private final void loaderObserver() {
    }
    
    private final void loaderShowHide(boolean isShowStatus) {
    }
    
    private final void setUpListeners() {
    }
    
    private final void handleMainIntent() {
    }
    
    @android.annotation.SuppressLint(value = {"ClickableViewAccessibility"})
    @java.lang.Override
    public boolean onTouch(@org.jetbrains.annotations.NotNull
    android.view.View v, @org.jetbrains.annotations.Nullable
    android.view.MotionEvent event) {
        return false;
    }
    
    @java.lang.Override
    public void onEmojiconBackspaceClicked(@org.jetbrains.annotations.Nullable
    android.view.View v) {
    }
    
    @java.lang.Override
    public void onEmojiconClicked(@org.jetbrains.annotations.Nullable
    io.github.rockerhieu.emojicon.emoji.Emojicon emojicon) {
    }
    
    /**
     * Update reply message id and user id
     */
    private final void updateReplyMessageAction() {
    }
    
    private final void scheduleMeetFabButtonClickAndMove() {
    }
    
    private final void scheduleFabButtonClickableFunctionality() {
    }
    
    private final void showScheduleBottomSheetFragment() {
    }
    
    private final void hideEmojiHandlerKeyboard() {
    }
    
    private final void addOrBlockLayoutVisibility() {
    }
    
    @java.lang.Override
    public void onClick(@org.jetbrains.annotations.NotNull
    android.view.View v) {
    }
    
    private final void sendChatMessage() {
    }
    
    private final void validateAndSendMessage(com.contusfly.models.MessageObject messageObject) {
    }
    
    private final void validateAndSendEditedMessage(com.contusfly.models.EditMessageParams editedMessage) {
    }
    
    private final void sendTextMessage() {
    }
    
    private final void sendMeetMessage(com.contusfly.models.MeetMessageParams meetMessageParams) {
    }
    
    private final void sendImageMessage(java.lang.String imagePath) {
    }
    
    private final void sendAudioMessage(java.lang.String audioPath) {
    }
    
    private final void sendDocumentsMessage(android.net.Uri filePathUri) {
    }
    
    private final void sendContactMessage(android.content.Intent data) {
    }
    
    private final void sendLocationMessage(android.content.Intent data) {
    }
    
    private final void sendVoiceMessage() {
    }
    
    private final void sendMessage(com.contusfly.models.MessageObject messageObject) {
    }
    
    private final void clearEditText() {
    }
    
    @java.lang.Override
    protected void onDestroy() {
    }
    
    public final void clear() {
    }
    
    /**
     * Called to report a user click on an action button.
     *
     * @param mode The current ActionMode
     * @param menuItem   The item that was clicked
     * @return true if this callback handled the event, false if the standard MenuItem invocation
     * should continue.
     */
    @java.lang.Override
    public boolean onActionItemClicked(@org.jetbrains.annotations.NotNull
    android.view.ActionMode mode, @org.jetbrains.annotations.NotNull
    android.view.MenuItem menuItem) {
        return false;
    }
    
    @java.lang.Override
    public void onMessageStatusUpdated(@org.jetbrains.annotations.NotNull
    java.lang.String messageId) {
    }
    
    private final void refreshMessageStatusUpdated(java.lang.String mid, kotlin.Pair<java.lang.Integer, ? extends com.mirrorflysdk.api.models.ChatMessage> messageAndPosition) {
    }
    
    private final void refreshEditedMessageUpdated(java.lang.String mid, kotlin.Pair<java.lang.Integer, ? extends com.mirrorflysdk.api.models.ChatMessage> messageAndPosition) {
    }
    
    @java.lang.Override
    public boolean onCreateActionMode(@org.jetbrains.annotations.NotNull
    android.view.ActionMode mode, @org.jetbrains.annotations.NotNull
    android.view.Menu menu) {
        return false;
    }
    
    @java.lang.Override
    public boolean onPrepareActionMode(@org.jetbrains.annotations.Nullable
    android.view.ActionMode mode, @org.jetbrains.annotations.Nullable
    android.view.Menu menu) {
        return false;
    }
    
    private final boolean onActionMenuClick(int itemId) {
        return false;
    }
    
    private final boolean isAdminAndUserProfileNotBlocked() {
        return false;
    }
    
    private final void launchEditMessageActivity() {
    }
    
    private final void showReportMessagePopup() {
    }
    
    private final java.lang.String getReporterName() {
        return null;
    }
    
    @java.lang.Override
    public void onDestroyActionMode(@org.jetbrains.annotations.NotNull
    android.view.ActionMode mode) {
    }
    
    @java.lang.Override
    protected void onResume() {
    }
    
    private final void checkIsGroupAdminBlocked() {
    }
    
    private final void removeUnReadMsgSeparator() {
    }
    
    private final void clearNotification() {
    }
    
    private final void handleCursorAndKeyboardVisibility() {
    }
    
    @java.lang.Override
    public void listOptionSelected(int position) {
    }
    
    @java.lang.Override
    public void onDialogClosed(@org.jetbrains.annotations.Nullable
    com.contusfly.views.CommonAlertDialog.DIALOGTYPE dialogType, boolean isSuccess) {
    }
    
    private final void handleSuccessResponse(com.contusfly.views.CommonAlertDialog.DialogAction action) {
    }
    
    private final void onAudioClickCallBackAfterDisableBusyStatus() {
    }
    
    private final void onAttachmentClickCallBackAfterDisableBusyStatus() {
    }
    
    private final void handleFailureResponse(com.contusfly.views.CommonAlertDialog.DialogAction action) {
    }
    
    @java.lang.Override
    public void onTripleOptionDialogClosed(@org.jetbrains.annotations.Nullable
    com.contusfly.views.CommonAlertDialog.DIALOGTYPE dialogType, int position) {
    }
    
    /**
     * here handling the dialog
     *
     * @param action Common Alert Action
     * @param dialogType Dialog type single or dual
     * @param position clicked position
     */
    private final void handleDialogResp(com.contusfly.views.CommonAlertDialog.DialogAction action, com.contusfly.views.CommonAlertDialog.DIALOGTYPE dialogType, int position) {
    }
    
    private final void showSoftKeyboardAfterDisableBusyStatus() {
    }
    
    private final void forwardMessageAfterDisableBusyStatus() {
    }
    
    private final void sendQueuedMessageAfterDisableBusyStatus() {
    }
    
    private final void onShowScheduleBottomSheetAfterDisableBusyStatus() {
    }
    
    private final void navigateToEditMessageActivityAfterDisableBusyStatus() {
    }
    
    private final void deleteChat(com.contusfly.views.CommonAlertDialog.DIALOGTYPE dialogType, int position) {
    }
    
    /**
     * Called when the connection has been failed from the server
     *
     * @param message Connection failed message
     */
    @java.lang.Override
    public void connectionFailed(@org.jetbrains.annotations.NotNull
    java.lang.String message) {
    }
    
    /**
     * Block the Current user
     */
    private final void blockContact() {
    }
    
    /**
     * Block the Current user
     */
    private final void unblockContact(boolean isFromEditMessage) {
    }
    
    @java.lang.Override
    public void usersIBlockedListFetched(@org.jetbrains.annotations.NotNull
    java.util.List<java.lang.String> jidList) {
    }
    
    private final void onBlockUserResponse(boolean isError, boolean isBlockedStatus, boolean isFromEditMessage) {
    }
    
    private final void handleCommonDeleteOperation(boolean isRecalled) {
    }
    
    @java.lang.Override
    public void onReplyMessageClick(@org.jetbrains.annotations.NotNull
    java.lang.String itemMessageId) {
    }
    
    private final void replyParentMessageLoadFromDB(java.lang.String messageId) {
    }
    
    @java.lang.Override
    public void onSenderMediaForward(@org.jetbrains.annotations.NotNull
    com.mirrorflysdk.api.models.ChatMessage item, int position) {
    }
    
    private final void senderMediaForward(com.mirrorflysdk.api.models.ChatMessage item) {
    }
    
    @java.lang.Override
    public void onContactClick(@org.jetbrains.annotations.NotNull
    com.mirrorflysdk.api.models.ChatMessage item, int position, @org.jetbrains.annotations.Nullable
    java.lang.String registeredJid, boolean isSavedContact) {
    }
    
    private final void checkSelectedMessagesActionModeValidation(int position) {
    }
    
    private final void navigateToContactViewPage(java.lang.String messageId) {
    }
    
    @java.lang.Override
    public void onCancelDownloadClicked(@org.jetbrains.annotations.NotNull
    com.mirrorflysdk.api.models.ChatMessage messageItem) {
    }
    
    @java.lang.Override
    public void onReceiverItemClicked(@org.jetbrains.annotations.Nullable
    com.mirrorflysdk.api.models.ChatMessage item, int position) {
    }
    
    @java.lang.Override
    protected void clearActionMenu() {
    }
    
    /**
     * Handle media message item click and long press
     *
     * @param position Position of the item in view
     */
    private final void handleMediaMessageClick(int position, java.lang.String messageId) {
    }
    
    private final void checkStoragePermissionAndAllow(int clickedPos) {
    }
    
    @java.lang.Override
    public void mediaPermissionCheck() {
    }
    
    @java.lang.Override
    public void onDownloadClicked(@org.jetbrains.annotations.NotNull
    com.mirrorflysdk.api.models.ChatMessage messageItem) {
    }
    
    private final void dowoanloadMedia(com.mirrorflysdk.api.models.ChatMessage messageItem) {
    }
    
    @java.lang.Override
    public void onCancelUploadClicked(@org.jetbrains.annotations.NotNull
    com.mirrorflysdk.api.models.ChatMessage messageItem) {
    }
    
    @java.lang.Override
    public void onReceiverItemLongClick(@org.jetbrains.annotations.Nullable
    com.mirrorflysdk.api.models.ChatMessage item, int position) {
    }
    
    @java.lang.Override
    public void onAudioPlayed() {
    }
    
    @java.lang.Override
    public void onSenderItemClicked(@org.jetbrains.annotations.Nullable
    com.mirrorflysdk.api.models.ChatMessage item, int position) {
    }
    
    @java.lang.Override
    public void onHandleStarredItemMediaClickToAction(@org.jetbrains.annotations.Nullable
    com.mirrorflysdk.api.models.ChatMessage item, int position) {
    }
    
    @java.lang.Override
    public void onRetryClicked(@org.jetbrains.annotations.Nullable
    com.mirrorflysdk.api.models.ChatMessage item) {
    }
    
    private final void handleCancelClickedOnMediaMessage(com.mirrorflysdk.api.models.ChatMessage messageItem) {
    }
    
    @java.lang.Override
    public void onSenderItemLongClick(@org.jetbrains.annotations.Nullable
    com.mirrorflysdk.api.models.ChatMessage item, int position) {
    }
    
    /**
     * This is handle the clear the chat
     */
    private final void handleClearConversation(boolean clearChatExceptStarredMessages) {
    }
    
    /**
     * Select Message Status
     *
     * @param isRecalled message is Recalled or Not.
     */
    private final void refreshDeleteOrRecalledMessagesInAdapter(boolean isRecalled) {
    }
    
    private final void sendDeleteMessageIQRequest() {
    }
    
    private final void recallSelectedMessages() {
    }
    
    private final void handleDownloadProcess() {
    }
    
    @java.lang.Override
    protected void onActivityResult(int requestCode, int resultCode, @org.jetbrains.annotations.Nullable
    android.content.Intent data) {
    }
    
    @java.lang.Override
    protected void onNewIntent(@org.jetbrains.annotations.NotNull
    android.content.Intent intent) {
    }
    
    private final void reloadUserChat() {
    }
    
    @java.lang.Override
    public void onRequestPermissionsResult(int requestCode, @org.jetbrains.annotations.NotNull
    java.lang.String[] permissions, @org.jetbrains.annotations.NotNull
    int[] grantResults) {
    }
    
    private final void handleOnNewIntent(android.content.Intent intent) {
    }
    
    private final void sendVideoFromGallery(java.lang.String videoFilePath, java.lang.String videoCaption) {
    }
    
    private final void sendImageFromGallery(android.content.Intent intent) {
    }
    
    private final void handleAudioVideoIntentFromGalleryMenu(android.content.Intent intent) {
    }
    
    /**
     * Scroll to bottom
     */
    private final void showBottomMessage(int messageCount, java.util.ArrayList<com.mirrorflysdk.api.models.ChatMessage> nextMessageList) {
    }
    
    private final void scrollPosition(com.mirrorflysdk.api.models.ChatMessage tempMessage) {
    }
    
    private final boolean getUnreadMessageAvailable() {
        return false;
    }
    
    @java.lang.Override
    public void setTypingStatus(@org.jetbrains.annotations.NotNull
    java.lang.String singleOrGroupJid, @org.jetbrains.annotations.NotNull
    java.lang.String userId, @org.jetbrains.annotations.NotNull
    java.lang.String composing) {
    }
    
    private final java.lang.String getChatTypingUserName(java.lang.String userName) {
        return null;
    }
    
    private final void mediaClickEvent(java.lang.String selectedOptionName, int requestCode) {
    }
    
    /**
     * handling the voice recorder
     */
    private final void handleVoiceRecording(kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> sendVoiceMessage) {
    }
    
    /**
     * Error timeout response for chat connection
     */
    @java.lang.Override
    public void chatConnectionErrorResponse() {
    }
    
    /**
     * Called when the logged in successfully completed for the user.
     */
    @java.lang.Override
    public void onConnected() {
    }
    
    @java.lang.Override
    public void userBlockedMe(@org.jetbrains.annotations.NotNull
    java.lang.String jid) {
    }
    
    @java.lang.Override
    public void userUnBlockedMe(@org.jetbrains.annotations.NotNull
    java.lang.String jid) {
    }
    
    /**
     * Handle the new user added in the group.
     *
     * @param groupJid Group jid
     * @param newMemberJid Jabber id of the User
     * @param addedByMemberJid Jid of user who adds the member
     */
    @java.lang.Override
    public void onNewMemberAddedToGroup(@org.jetbrains.annotations.NotNull
    java.lang.String groupJid, @org.jetbrains.annotations.NotNull
    java.lang.String newMemberJid, @org.jetbrains.annotations.NotNull
    java.lang.String addedByMemberJid) {
    }
    
    /**
     * Handle the user removed from the group
     *
     * @param groupJid Group id
     * @param removedMemberJid Removed member Jid
     * @param removedByMemberJid Made remove member jid
     */
    @java.lang.Override
    public void onMemberRemovedFromGroup(@org.jetbrains.annotations.NotNull
    java.lang.String groupJid, @org.jetbrains.annotations.NotNull
    java.lang.String removedMemberJid, @org.jetbrains.annotations.NotNull
    java.lang.String removedByMemberJid) {
    }
    
    /**
     * Called when the group notification message inserted
     *
     * @param message Notification message
     */
    @java.lang.Override
    public void onGroupNotificationMessage(@org.jetbrains.annotations.NotNull
    com.mirrorflysdk.api.models.ChatMessage message) {
    }
    
    /**
     * Called when the group is updated
     *
     * @param groupJid Group jid
     */
    @java.lang.Override
    public void onGroupProfileUpdated(@org.jetbrains.annotations.NotNull
    java.lang.String groupJid) {
    }
    
    /**
     * Called when the group admin changed the affiliation
     *
     * @param groupJid Group jid
     * @param newAdminMemberJid New admin jid
     * @param madeByMemberJid Made new admin jid
     */
    @java.lang.Override
    public void onMemberMadeAsAdmin(@org.jetbrains.annotations.NotNull
    java.lang.String groupJid, @org.jetbrains.annotations.NotNull
    java.lang.String newAdminMemberJid, @org.jetbrains.annotations.NotNull
    java.lang.String madeByMemberJid) {
    }
    
    /**
     * Called when rosters collected successfully for the user.
     */
    @java.lang.Override
    public void onMessagesClearedOrDeleted(@org.jetbrains.annotations.NotNull
    java.util.ArrayList<java.lang.String> messageIds, @org.jetbrains.annotations.NotNull
    java.lang.String jid) {
    }
    
    @java.lang.Override
    protected void onPause() {
    }
    
    private final void maintainReplacedMentionUserList() {
    }
    
    /**
     * The method which registers the receiver to handle the telephony local broadcast
     */
    private final void registerTelephonyCallListener() {
    }
    
    /**
     * The method which registers the receiver to handle the audio call disconnection.
     */
    private final void unRegisterTelephonyCallListener() {
    }
    
    private final void sendAudioRecording() {
    }
    
    private final void pauseAudioRecording(boolean activityHidden) {
    }
    
    private final void showPausedOngoingRecording() {
    }
    
    private final void sendQueuedUpMessages() {
    }
    
    @java.lang.Override
    public void onBackPressed() {
    }
    
    private final void setMessageCallBack() {
    }
    
    private final void initSuggestion(java.util.ArrayList<com.mirrorflysdk.api.models.ChatMessage> messageList) {
    }
    
    private final void smartReplySuggestionCallback() {
    }
    
    @java.lang.Override
    public void onSuggestionClick(@org.jetbrains.annotations.NotNull
    java.lang.String text) {
    }
    
    private final void sendSmartReplyMessage() {
    }
    
    private final void sendSmartReply() {
    }
    
    @java.lang.Override
    protected void restoreCompleted() {
    }
    
    private final com.contusfly.views.KeyboardHeightProvider.KeyboardListener getKeyboardListener() {
        return null;
    }
    
    @java.lang.Override
    public void onRecordingStarted() {
    }
    
    @java.lang.Override
    public void onRecordingLocked() {
    }
    
    @java.lang.Override
    public void onRecordingCompleted() {
    }
    
    @java.lang.Override
    public void onRecordingCanceled() {
    }
    
    @java.lang.Override
    public void onAdminBlockedOtherUser(@org.jetbrains.annotations.NotNull
    java.lang.String jid, @org.jetbrains.annotations.NotNull
    java.lang.String type, boolean status) {
    }
    
    private final void showGroupBlockedByAdminNotification() {
    }
    
    private final void hideEmojiKeyboard() {
    }
    
    private final void filterGroupListTag(java.lang.CharSequence text) {
    }
    
    private final void initGroupTag() {
    }
    
    private final void setMentionPopupBackground() {
    }
    
    private final void hideGroupMentionMembersList() {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getUserFromJid(@org.jetbrains.annotations.NotNull
    java.lang.String jid) {
        return null;
    }
    
    @java.lang.Override
    protected void updateFeatureActions(@org.jetbrains.annotations.NotNull
    com.mirrorflysdk.flycommons.Features features) {
    }
    
    @java.lang.Override
    public void onUserTagClicked(@org.jetbrains.annotations.NotNull
    com.mirrorflysdk.api.contacts.ProfileDetails profileDetails) {
    }
    
    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public final void onMessageEvent(@org.jetbrains.annotations.Nullable
    com.contusfly.models.PrivateChatAuthenticationModel event) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0010"}, d2 = {"Lcom/contusfly/activities/ChatActivity$Companion;", "", "()V", "addMoreMediaClicked", "", "getAddMoreMediaClicked", "()Z", "setAddMoreMediaClicked", "(Z)V", "unSentMentionedUserIdList", "Ljava/util/ArrayList;", "Lcom/mirrorflysdk/api/contacts/ProfileDetails;", "getUnSentMentionedUserIdList", "()Ljava/util/ArrayList;", "setUnSentMentionedUserIdList", "(Ljava/util/ArrayList;)V", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.util.ArrayList<com.mirrorflysdk.api.contacts.ProfileDetails> getUnSentMentionedUserIdList() {
            return null;
        }
        
        public final void setUnSentMentionedUserIdList(@org.jetbrains.annotations.NotNull
        java.util.ArrayList<com.mirrorflysdk.api.contacts.ProfileDetails> p0) {
        }
        
        public final boolean getAddMoreMediaClicked() {
            return false;
        }
        
        public final void setAddMoreMediaClicked(boolean p0) {
        }
    }
}