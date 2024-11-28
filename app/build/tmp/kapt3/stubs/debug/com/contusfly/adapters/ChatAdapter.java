package com.contusfly.adapters;

import java.lang.System;

/**
 * Recycler adapter which used to list the chat view using recycler view
 *
 * @author ContusTeam <developers></developers>@contus.in>
 * @version 2.0
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u00c0\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b6\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001b\u0018\u0000 \u00d4\u00022\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004:\u0002\u00d4\u0002BK\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0006\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\t\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u00a2\u0006\u0002\u0010\u0012J(\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020I2\u000e\u0010J\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u000106H\u0002J8\u0010K\u001a\u00020E2\u0006\u0010L\u001a\u00020\u00072\u0006\u0010M\u001a\u00020\u00022\u0006\u0010N\u001a\u00020O2\u0006\u0010P\u001a\u00020Q2\u0006\u0010R\u001a\u00020S2\u0006\u0010T\u001a\u00020\u000fH\u0002J \u0010U\u001a\u00020E2\u0006\u0010M\u001a\u00020\u00022\u0006\u0010L\u001a\u00020\u00072\u0006\u0010H\u001a\u00020IH\u0002J \u0010V\u001a\u00020E2\u0006\u0010M\u001a\u00020\u00022\u0006\u0010W\u001a\u00020\u00072\u0006\u0010H\u001a\u00020IH\u0002J \u0010X\u001a\u00020E2\u0006\u0010M\u001a\u00020\u00022\u0006\u0010L\u001a\u00020\u00072\u0006\u0010H\u001a\u00020IH\u0002J \u0010Y\u001a\u00020E2\u0006\u0010M\u001a\u00020\u00022\u0006\u0010L\u001a\u00020\u00072\u0006\u0010H\u001a\u00020IH\u0002J \u0010Z\u001a\u00020E2\u0006\u0010M\u001a\u00020\u00022\u0006\u0010L\u001a\u00020\u00072\u0006\u0010H\u001a\u00020IH\u0002J \u0010[\u001a\u00020E2\u0006\u0010M\u001a\u00020\u00022\u0006\u0010W\u001a\u00020\u00072\u0006\u0010H\u001a\u00020IH\u0002J \u0010\\\u001a\u00020E2\u0006\u0010M\u001a\u00020\u00022\u0006\u0010W\u001a\u00020\u00072\u0006\u0010H\u001a\u00020IH\u0002J \u0010]\u001a\u00020E2\u0006\u0010M\u001a\u00020\u00022\u0006\u0010L\u001a\u00020\u00072\u0006\u0010H\u001a\u00020IH\u0002J \u0010^\u001a\u00020E2\u0006\u0010M\u001a\u00020\u00022\u0006\u0010L\u001a\u00020\u00072\u0006\u0010H\u001a\u00020IH\u0002J \u0010_\u001a\u00020E2\u0006\u0010M\u001a\u00020\u00022\u0006\u0010L\u001a\u00020\u00072\u0006\u0010H\u001a\u00020IH\u0002J \u0010`\u001a\u00020E2\u0006\u0010M\u001a\u00020\u00022\u0006\u0010W\u001a\u00020\u00072\u0006\u0010H\u001a\u00020IH\u0002J\u0010\u0010a\u001a\u00020\u000f2\u0006\u0010L\u001a\u00020\u0007H\u0002J\u0010\u0010b\u001a\u00020\u000f2\u0006\u0010L\u001a\u00020\u0007H\u0002J,\u0010c\u001a\u00020E2\u0006\u0010M\u001a\u00020\u00022\u0006\u0010d\u001a\u00020S2\b\u0010e\u001a\u0004\u0018\u00010f2\b\u0010g\u001a\u0004\u0018\u00010hH\u0002J\u0018\u0010i\u001a\u00020E2\u0006\u0010M\u001a\u00020\u00022\u0006\u0010L\u001a\u00020\u0007H\u0002J\u0018\u0010j\u001a\u00020E2\u0006\u0010M\u001a\u00020\u00022\u0006\u0010L\u001a\u00020\u0007H\u0002J<\u0010k\u001a\u00020E2\u0006\u0010M\u001a\u00020\u00022\u0006\u0010L\u001a\u00020\u00072\u0006\u0010H\u001a\u00020I2\u0006\u0010l\u001a\u00020\t2\b\u0010m\u001a\u0004\u0018\u00010\t2\b\u0010n\u001a\u0004\u0018\u00010\tH\u0002J \u0010o\u001a\u00020E2\u0006\u0010H\u001a\u00020I2\u0006\u0010p\u001a\u00020I2\u0006\u0010q\u001a\u00020\tH\u0016J\u0010\u0010r\u001a\u00020E2\u0006\u0010s\u001a\u00020tH\u0002J\u0010\u0010r\u001a\u00020E2\u0006\u0010u\u001a\u00020vH\u0002J\u0010\u0010w\u001a\u00020E2\u0006\u0010x\u001a\u00020yH\u0002J\u0010\u0010w\u001a\u00020E2\u0006\u0010z\u001a\u00020{H\u0002J \u0010|\u001a\u00020E2\u0006\u0010}\u001a\u00020G2\u0006\u0010~\u001a\u00020G2\u0006\u0010W\u001a\u00020\u0007H\u0002J\u001a\u0010\u007f\u001a\u00020E2\b\u0010\u0080\u0001\u001a\u00030\u0081\u00012\u0006\u0010L\u001a\u00020\u0007H\u0002J\u001b\u0010\u0082\u0001\u001a\u00020E2\b\u0010\u0083\u0001\u001a\u00030\u0084\u00012\u0006\u0010L\u001a\u00020\u0007H\u0002J\u001d\u0010\u0085\u0001\u001a\u00020E2\u0007\u0010\u0086\u0001\u001a\u00020\u00072\t\u0010\u0087\u0001\u001a\u0004\u0018\u00010OH\u0002J!\u0010\u0088\u0001\u001a\u00020E2\u0006\u0010M\u001a\u00020\u00022\u0006\u0010L\u001a\u00020\u00072\u0006\u0010H\u001a\u00020IH\u0002J!\u0010\u0089\u0001\u001a\u00020E2\u0006\u0010M\u001a\u00020\u00022\u0006\u0010L\u001a\u00020\u00072\u0006\u0010H\u001a\u00020IH\u0002J!\u0010\u008a\u0001\u001a\u00020E2\u0006\u0010M\u001a\u00020\u00022\u0006\u0010L\u001a\u00020\u00072\u0006\u0010H\u001a\u00020IH\u0002J\u0012\u0010\u008b\u0001\u001a\u00020\t2\u0007\u0010\u0086\u0001\u001a\u00020\tH\u0002J\t\u0010\u008c\u0001\u001a\u00020IH\u0016J\u0011\u0010\u008d\u0001\u001a\u00020\u001d2\u0006\u0010H\u001a\u00020IH\u0016J\u0011\u0010\u008e\u0001\u001a\u00020I2\u0006\u0010H\u001a\u00020IH\u0016J\u0015\u0010\u008f\u0001\u001a\u0004\u0018\u00010\t2\b\u0010\u0090\u0001\u001a\u00030\u0091\u0001H\u0002J\u0007\u0010\u0092\u0001\u001a\u000204J\u0012\u0010\u0093\u0001\u001a\u00020I2\u0007\u0010\u0094\u0001\u001a\u00020\tH\u0002J\u0012\u0010\u0095\u0001\u001a\u00020I2\u0007\u0010\u0094\u0001\u001a\u00020\tH\u0002J\u001c\u0010\u0096\u0001\u001a\u00020E2\u0006\u0010M\u001a\u00020\u00022\t\u0010\u0086\u0001\u001a\u0004\u0018\u00010\u0007H\u0002J\u0014\u0010\u0097\u0001\u001a\u00020\t2\t\u0010\u0086\u0001\u001a\u0004\u0018\u00010\tH\u0002J#\u0010\u0098\u0001\u001a\u00020O2\u0006\u0010L\u001a\u00020\u00072\u0007\u0010\u0099\u0001\u001a\u00020O2\u0007\u0010\u009a\u0001\u001a\u00020OH\u0002J#\u0010\u009b\u0001\u001a\u00020O2\u0006\u0010L\u001a\u00020\u00072\u0007\u0010\u009c\u0001\u001a\u00020O2\u0007\u0010\u009d\u0001\u001a\u00020OH\u0002J\u001c\u0010\u009e\u0001\u001a\u00020E2\b\u0010\u009f\u0001\u001a\u00030\u00a0\u00012\u0007\u0010\u00a1\u0001\u001a\u00020\tH\u0002J\u001f\u0010\u00a2\u0001\u001a\u00020E2\n\u0010\u00a3\u0001\u001a\u0005\u0018\u00010\u00a4\u00012\b\u0010\u00a5\u0001\u001a\u00030\u00a6\u0001H\u0002J\u001b\u0010\u00a7\u0001\u001a\u00020E2\b\u0010\u0080\u0001\u001a\u00030\u0081\u00012\u0006\u0010L\u001a\u00020\u0007H\u0002J+\u0010\u00a8\u0001\u001a\u00020E2\b\u0010\u00a9\u0001\u001a\u00030\u00aa\u00012\u0006\u0010M\u001a\u00020\u00022\u0006\u0010L\u001a\u00020\u00072\u0006\u0010H\u001a\u00020IH\u0002J,\u0010\u00ab\u0001\u001a\u00020E2\u0007\u0010\u00ac\u0001\u001a\u00020\t2\b\u0010\u00ad\u0001\u001a\u00030\u00ae\u00012\u0006\u0010L\u001a\u00020\u00072\u0006\u0010H\u001a\u00020IH\u0002J,\u0010\u00af\u0001\u001a\u00020E2\u0007\u0010\u00ac\u0001\u001a\u00020\t2\b\u0010\u00b0\u0001\u001a\u00030\u00b1\u00012\u0006\u0010L\u001a\u00020\u00072\u0006\u0010H\u001a\u00020IH\u0002J,\u0010\u00b2\u0001\u001a\u00020E2\u0007\u0010\u00ac\u0001\u001a\u00020\t2\b\u0010\u00b3\u0001\u001a\u00030\u00a0\u00012\u0006\u0010L\u001a\u00020\u00072\u0006\u0010H\u001a\u00020IH\u0002J,\u0010\u00b4\u0001\u001a\u00020E2\u0007\u0010\u00ac\u0001\u001a\u00020\t2\b\u0010\u00b5\u0001\u001a\u00030\u00b6\u00012\u0006\u0010L\u001a\u00020\u00072\u0006\u0010H\u001a\u00020IH\u0002J,\u0010\u00b7\u0001\u001a\u00020E2\u0007\u0010\u00ac\u0001\u001a\u00020\t2\b\u0010\u00b8\u0001\u001a\u00030\u00b9\u00012\u0006\u0010L\u001a\u00020\u00072\u0006\u0010H\u001a\u00020IH\u0002J,\u0010\u00ba\u0001\u001a\u00020E2\u0007\u0010\u00ac\u0001\u001a\u00020\t2\b\u0010\u00bb\u0001\u001a\u00030\u00bc\u00012\u0006\u0010L\u001a\u00020\u00072\u0006\u0010H\u001a\u00020IH\u0002J,\u0010\u00bd\u0001\u001a\u00020E2\u0007\u0010\u00ac\u0001\u001a\u00020\t2\b\u0010\u00be\u0001\u001a\u00030\u00bf\u00012\u0006\u0010L\u001a\u00020\u00072\u0006\u0010H\u001a\u00020IH\u0002J,\u0010\u00c0\u0001\u001a\u00020E2\u0007\u0010\u00ac\u0001\u001a\u00020\t2\b\u0010\u0080\u0001\u001a\u00030\u0081\u00012\u0006\u0010L\u001a\u00020\u00072\u0006\u0010H\u001a\u00020IH\u0002J,\u0010\u00c1\u0001\u001a\u00020E2\u0007\u0010\u00ac\u0001\u001a\u00020\t2\b\u0010\u00c2\u0001\u001a\u00030\u00c3\u00012\u0006\u0010L\u001a\u00020\u00072\u0006\u0010H\u001a\u00020IH\u0002J,\u0010\u00c4\u0001\u001a\u00020E2\u0007\u0010\u00ac\u0001\u001a\u00020\t2\b\u0010\u00c5\u0001\u001a\u00030\u00c6\u00012\u0006\u0010L\u001a\u00020\u00072\u0006\u0010H\u001a\u00020IH\u0002J*\u0010\u00c7\u0001\u001a\u00020E2\u0007\u0010\u00ac\u0001\u001a\u00020\t2\u0006\u0010s\u001a\u00020t2\u0006\u0010L\u001a\u00020\u00072\u0006\u0010H\u001a\u00020IH\u0002J*\u0010\u00c8\u0001\u001a\u00020E2\u0007\u0010\u00ac\u0001\u001a\u00020\t2\u0006\u0010x\u001a\u00020y2\u0006\u0010L\u001a\u00020\u00072\u0006\u0010H\u001a\u00020IH\u0002J+\u0010\u00c9\u0001\u001a\u00020E2\u0007\u0010\u00ac\u0001\u001a\u00020\t2\u0007\u0010\u00ca\u0001\u001a\u00020v2\u0006\u0010L\u001a\u00020\u00072\u0006\u0010H\u001a\u00020IH\u0002J+\u0010\u00cb\u0001\u001a\u00020E2\u0007\u0010\u00ac\u0001\u001a\u00020\t2\u0007\u0010\u00cc\u0001\u001a\u00020{2\u0006\u0010L\u001a\u00020\u00072\u0006\u0010H\u001a\u00020IH\u0002J,\u0010\u00cd\u0001\u001a\u00020E2\u0007\u0010\u00ac\u0001\u001a\u00020\t2\b\u0010\u00ce\u0001\u001a\u00030\u00cf\u00012\u0006\u0010L\u001a\u00020\u00072\u0006\u0010H\u001a\u00020IH\u0002J,\u0010\u00d0\u0001\u001a\u00020E2\u0007\u0010\u00ac\u0001\u001a\u00020\t2\b\u0010\u0083\u0001\u001a\u00030\u0084\u00012\u0006\u0010L\u001a\u00020\u00072\u0006\u0010H\u001a\u00020IH\u0002J\u0019\u0010\u00d1\u0001\u001a\u00020E2\u0006\u0010L\u001a\u00020\u00072\u0006\u0010s\u001a\u00020tH\u0002J\u001a\u0010\u00d2\u0001\u001a\u00020E2\u0006\u0010L\u001a\u00020\u00072\u0007\u0010\u00d3\u0001\u001a\u00020vH\u0002J\u001b\u0010\u00d4\u0001\u001a\u00020E2\b\u0010\u00a3\u0001\u001a\u00030\u00a4\u00012\u0006\u0010M\u001a\u00020tH\u0002J\u001b\u0010\u00d4\u0001\u001a\u00020E2\b\u0010\u00a3\u0001\u001a\u00030\u00a4\u00012\u0006\u0010M\u001a\u00020vH\u0002J%\u0010\u00d5\u0001\u001a\u00020E2\b\u0010\u00a3\u0001\u001a\u00030\u00a4\u00012\u0006\u0010M\u001a\u00020v2\b\u0010\u00d6\u0001\u001a\u00030\u00d7\u0001H\u0002J\u001b\u0010\u00d8\u0001\u001a\u00020E2\b\u0010\u00a3\u0001\u001a\u00030\u00a4\u00012\u0006\u0010M\u001a\u00020yH\u0002J\u001b\u0010\u00d8\u0001\u001a\u00020E2\b\u0010\u00a3\u0001\u001a\u00030\u00a4\u00012\u0006\u0010M\u001a\u00020{H\u0002J%\u0010\u00d9\u0001\u001a\u00020E2\b\u0010\u00a3\u0001\u001a\u00030\u00a4\u00012\u0006\u0010M\u001a\u00020{2\b\u0010\u00d6\u0001\u001a\u00030\u00d7\u0001H\u0002J\u001b\u0010\u00da\u0001\u001a\u00020E2\b\u0010\u0083\u0001\u001a\u00030\u0084\u00012\u0006\u0010L\u001a\u00020\u0007H\u0002J\u001e\u0010\u00db\u0001\u001a\u00020E2\t\u0010\u00dc\u0001\u001a\u0004\u0018\u00010S2\b\u0010}\u001a\u0004\u0018\u00010GH\u0002J\u001b\u0010\u00dd\u0001\u001a\u00020E2\u0006\u0010L\u001a\u00020\u00072\b\u0010\u00c5\u0001\u001a\u00030\u00c6\u0001H\u0002J\u0019\u0010\u00de\u0001\u001a\u00020E2\u0006\u0010M\u001a\u00020\u00022\u0006\u0010H\u001a\u00020IH\u0016J*\u0010\u00de\u0001\u001a\u00020E2\u0006\u0010M\u001a\u00020\u00022\u0006\u0010H\u001a\u00020I2\u000f\u0010\u00df\u0001\u001a\n\u0012\u0005\u0012\u00030\u00e1\u00010\u00e0\u0001H\u0016J\u001c\u0010\u00e2\u0001\u001a\u00020\u00022\b\u0010\u00e3\u0001\u001a\u00030\u00e4\u00012\u0007\u0010\u00e5\u0001\u001a\u00020IH\u0016J\u0019\u0010\u00e6\u0001\u001a\u00020E2\u0006\u0010L\u001a\u00020\u00072\u0006\u0010H\u001a\u00020IH\u0002J\u0007\u0010\u00e7\u0001\u001a\u00020EJ*\u0010\u00e8\u0001\u001a\u00020E2\u0006\u0010}\u001a\u00020G2\u0007\u0010\u00e9\u0001\u001a\u00020G2\u0006\u0010~\u001a\u00020G2\u0006\u0010W\u001a\u00020\u0007H\u0002J\"\u0010\u00ea\u0001\u001a\u00020E2\u0006\u0010M\u001a\u00020\u00022\u0007\u0010\u00eb\u0001\u001a\u00020G2\u0006\u0010W\u001a\u00020\u0007H\u0002J*\u0010\u00ec\u0001\u001a\u00020E2\r\u0010\u00ed\u0001\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010H\u001a\u00020I2\b\u0010\u00ee\u0001\u001a\u00030\u00ef\u0001H\u0002J \u0010\u00f0\u0001\u001a\u00020E2\r\u0010\u00ed\u0001\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010u\u001a\u00020vH\u0002J\u0018\u0010\u00f1\u0001\u001a\u00020E2\u0006\u0010H\u001a\u00020I2\u0007\u0010\u0086\u0001\u001a\u00020\u0007J\u0018\u0010\u00f2\u0001\u001a\u00020E2\u0006\u0010H\u001a\u00020I2\u0007\u0010\u0086\u0001\u001a\u00020\u0007J,\u0010\u00f3\u0001\u001a\u00020E2\u0007\u0010\u00e9\u0001\u001a\u00020G2\u0007\u0010\u00f4\u0001\u001a\u00020G2\u0006\u0010W\u001a\u00020\u00072\u0007\u0010\u00f5\u0001\u001a\u00020GH\u0002J\"\u0010\u00f6\u0001\u001a\u00020E2\u0006\u0010M\u001a\u00020\u00022\u0007\u0010\u00f7\u0001\u001a\u00020G2\u0006\u0010W\u001a\u00020\u0007H\u0002J\u001b\u0010\u00f8\u0001\u001a\u00020E2\u0006\u0010L\u001a\u00020\u00072\b\u0010\u00b0\u0001\u001a\u00030\u00b1\u0001H\u0002J1\u0010\u00f9\u0001\u001a\u00020E2\u0006\u0010L\u001a\u00020\u00072\u0006\u0010M\u001a\u00020\u00022\u0006\u0010N\u001a\u00020O2\u0006\u0010P\u001a\u00020Q2\u0006\u0010R\u001a\u00020SH\u0002J\u001e\u0010\u00fa\u0001\u001a\u00020E2\b\u0010L\u001a\u0004\u0018\u00010\u00072\t\u0010\u00fb\u0001\u001a\u0004\u0018\u00010OH\u0016J\u001a\u0010\u00fc\u0001\u001a\u00020E2\u0007\u0010\u00fd\u0001\u001a\u00020S2\u0006\u0010s\u001a\u00020tH\u0002J\u001a\u0010\u00fc\u0001\u001a\u00020E2\u0007\u0010\u00fd\u0001\u001a\u00020S2\u0006\u0010x\u001a\u00020yH\u0002J\u001b\u0010\u00fe\u0001\u001a\u00020E2\b\u0010\u00fb\u0001\u001a\u00030\u00b9\u00012\u0006\u0010L\u001a\u00020\u0007H\u0002J\u001b\u0010\u00ff\u0001\u001a\u00020E2\b\u0010\u0080\u0002\u001a\u00030\u00bc\u00012\u0006\u0010L\u001a\u00020\u0007H\u0002J%\u0010\u0081\u0002\u001a\u00020E2\b\u0010\u0080\u0002\u001a\u00030\u00bc\u00012\u0006\u0010L\u001a\u00020\u00072\b\u0010n\u001a\u0004\u0018\u00010\tH\u0002J*\u0010\u0082\u0002\u001a\u00020E2\t\u0010\u0083\u0002\u001a\u0004\u0018\u00010\t2\t\u0010\u0084\u0002\u001a\u0004\u0018\u00010G2\t\u0010\u0085\u0002\u001a\u0004\u0018\u00010SH\u0016J5\u0010\u0086\u0002\u001a\u00020E2\u0006\u0010\r\u001a\u00020\t2\u0007\u0010\u0087\u0002\u001a\u00020S2\u0007\u0010\u0088\u0002\u001a\u00020h2\u0007\u0010\u0089\u0002\u001a\u00020O2\u0007\u0010\u008a\u0002\u001a\u00020\tH\u0002J\u001b\u0010\u008b\u0002\u001a\u00020E2\b\u0010\u008c\u0002\u001a\u00030\u00b1\u00012\u0006\u0010L\u001a\u00020\u0007H\u0002J%\u0010\u008d\u0002\u001a\u00020E2\b\u0010\u008e\u0002\u001a\u00030\u00b6\u00012\u0006\u0010L\u001a\u00020\u00072\b\u0010m\u001a\u0004\u0018\u00010\tH\u0002J%\u0010\u008f\u0002\u001a\u00020E2\b\u0010\u008e\u0002\u001a\u00030\u00a0\u00012\u0006\u0010L\u001a\u00020\u00072\b\u0010m\u001a\u0004\u0018\u00010\tH\u0002J\u001b\u0010\u0090\u0002\u001a\u00020E2\b\u0010\u0080\u0002\u001a\u00030\u00b9\u00012\u0006\u0010L\u001a\u00020\u0007H\u0002J\u001b\u0010\u0091\u0002\u001a\u00020E2\b\u0010\u00ad\u0001\u001a\u00030\u00ae\u00012\u0006\u0010L\u001a\u00020\u0007H\u0002J\u001b\u0010\u0092\u0002\u001a\u00020E2\b\u0010\u0093\u0002\u001a\u00030\u00bf\u00012\u0006\u0010L\u001a\u00020\u0007H\u0002J\u001b\u0010\u0094\u0002\u001a\u00020E2\b\u0010\u0095\u0002\u001a\u00030\u00c3\u00012\u0006\u0010L\u001a\u00020\u0007H\u0002J\u0019\u0010\u0096\u0002\u001a\u00020E2\u0006\u0010s\u001a\u00020t2\u0006\u0010L\u001a\u00020\u0007H\u0002J\u0019\u0010\u0097\u0002\u001a\u00020E2\u0006\u0010u\u001a\u00020v2\u0006\u0010L\u001a\u00020\u0007H\u0002J\u001b\u0010\u0098\u0002\u001a\u00020E2\b\u0010\u0099\u0002\u001a\u00030\u00cf\u00012\u0006\u0010L\u001a\u00020\u0007H\u0002J\u001b\u0010\u009a\u0002\u001a\u00020E2\b\u0010\u0093\u0002\u001a\u00030\u0081\u00012\u0006\u0010L\u001a\u00020\u0007H\u0002J\u001b\u0010\u009b\u0002\u001a\u00020E2\b\u0010\u0095\u0002\u001a\u00030\u00c6\u00012\u0006\u0010L\u001a\u00020\u0007H\u0002J\u0019\u0010\u009c\u0002\u001a\u00020E2\u0006\u0010x\u001a\u00020y2\u0006\u0010L\u001a\u00020\u0007H\u0002J\u0019\u0010\u009d\u0002\u001a\u00020E2\u0006\u0010z\u001a\u00020{2\u0006\u0010L\u001a\u00020\u0007H\u0002J\u001b\u0010\u009e\u0002\u001a\u00020E2\b\u0010\u009f\u0002\u001a\u00030\u0084\u00012\u0006\u0010L\u001a\u00020\u0007H\u0002J\u001b\u0010\u00a0\u0002\u001a\u00020E2\b\u0010\u0080\u0002\u001a\u00030\u00bc\u00012\u0006\u0010L\u001a\u00020\u0007H\u0002J\u001b\u0010\u00a1\u0002\u001a\u00020E2\u0007\u0010\u00a2\u0002\u001a\u00020O2\u0007\u0010\u00a3\u0002\u001a\u00020\u000fH\u0002J\u0013\u0010\u00a4\u0002\u001a\u00020E2\b\u0010\u00a5\u0002\u001a\u00030\u00a6\u0002H\u0016J2\u0010\u00a7\u0002\u001a\u00020E2\t\u0010\u00a8\u0002\u001a\u0004\u0018\u00010S2\u0007\u0010\u00a9\u0002\u001a\u00020I2\b\u0010W\u001a\u0004\u0018\u00010\u00072\t\u0010\u00aa\u0002\u001a\u0004\u0018\u00010OH\u0016J\u0013\u0010\u00ab\u0002\u001a\u00020E2\b\u0010\u00ac\u0002\u001a\u00030\u00ad\u0002H\u0016J,\u0010\u00ae\u0002\u001a\u00020E2\u0006\u0010\r\u001a\u00020\t2\u0007\u0010\u0087\u0002\u001a\u00020S2\u0007\u0010\u00af\u0002\u001a\u00020h2\u0007\u0010\u00b0\u0002\u001a\u00020OH\u0002J\u0011\u0010\u00b1\u0002\u001a\u00020E2\b\u0010/\u001a\u0004\u0018\u000100J \u0010\u00b2\u0002\u001a\u00020E2\t\u0010\u00fb\u0001\u001a\u0004\u0018\u00010O2\n\u0010\u00b3\u0002\u001a\u0005\u0018\u00010\u00b4\u0002H\u0016J\u0018\u0010\u00b5\u0002\u001a\u00020E2\u0007\u0010\u00b6\u0002\u001a\u00020\u000f2\u0006\u0010<\u001a\u00020\tJ\u001d\u0010\u00b7\u0002\u001a\u00020E2\b\u0010\u00a5\u0001\u001a\u00030\u00b8\u00022\b\u0010\u00b9\u0002\u001a\u00030\u00ba\u0002H\u0002J\u001b\u0010\u00bb\u0002\u001a\u00020E2\u0007\u0010\u00bc\u0002\u001a\u00020G2\u0007\u0010\u0086\u0001\u001a\u00020\u0007H\u0002J\"\u0010\u00bd\u0002\u001a\u00020E2\u0006\u0010L\u001a\u00020\u00072\u0007\u0010\u00fd\u0001\u001a\u00020S2\u0006\u0010M\u001a\u00020yH\u0002J\"\u0010\u00be\u0002\u001a\u00020E2\u0006\u0010L\u001a\u00020\u00072\u0007\u0010\u00fd\u0001\u001a\u00020S2\u0006\u0010M\u001a\u00020{H\u0002J\u001b\u0010\u00bf\u0002\u001a\u00020E2\u0007\u0010\u00c0\u0002\u001a\u00020\u000f2\u0007\u0010\u00c1\u0002\u001a\u00020OH\u0016J\u001b\u0010\u00c2\u0002\u001a\u00020E2\u0007\u0010\u00c0\u0002\u001a\u00020\u000f2\u0007\u0010\u00c1\u0002\u001a\u00020OH\u0016J\u001e\u0010\u00c3\u0002\u001a\u00020E2\b\u0010L\u001a\u0004\u0018\u00010\u00072\t\u0010\u00c4\u0002\u001a\u0004\u0018\u00010OH\u0016J!\u0010\u00c5\u0002\u001a\u00020E2\u0006\u0010M\u001a\u00020\u00022\u0006\u0010L\u001a\u00020\u00072\u0006\u0010H\u001a\u00020IH\u0002J!\u0010\u00c6\u0002\u001a\u00020E2\u0006\u0010M\u001a\u00020\u00022\u0006\u0010L\u001a\u00020\u00072\u0006\u0010H\u001a\u00020IH\u0002J\u0007\u0010\u00c7\u0002\u001a\u00020EJB\u0010\u00c8\u0002\u001a\u00020E2\u0006\u0010M\u001a\u00020\u00022\u0006\u0010N\u001a\u00020O2\u0006\u0010R\u001a\u00020S2\u0006\u0010p\u001a\u00020I2\u0007\u0010\u00c9\u0002\u001a\u00020\u000f2\u0006\u0010P\u001a\u00020Q2\u0006\u0010L\u001a\u00020\u0007H\u0002J.\u0010\u00ca\u0002\u001a\u00020E2\u0007\u0010\u00e9\u0001\u001a\u00020G2\t\u0010\u00cb\u0002\u001a\u0004\u0018\u00010G2\u0007\u0010\u00f4\u0001\u001a\u00020G2\u0006\u0010W\u001a\u00020\u0007H\u0002J!\u0010\u00cc\u0002\u001a\u00020I2\u0006\u0010H\u001a\u00020I2\u0007\u0010\u0094\u0001\u001a\u00020\t2\u0007\u0010\u00cd\u0002\u001a\u00020\u000fJ#\u0010\u00ce\u0002\u001a\u00020I2\u0006\u0010H\u001a\u00020I2\u0007\u0010\u0086\u0001\u001a\u00020\u00072\u0007\u0010\u00cd\u0002\u001a\u00020\u000fH\u0002J0\u0010\u00cf\u0002\u001a\u00020E2\t\u0010\u00d0\u0002\u001a\u0004\u0018\u00010\t2\u0007\u0010\u00d1\u0002\u001a\u00020\t2\u0007\u0010\u00d2\u0002\u001a\u00020G2\b\u0010\u00d3\u0002\u001a\u00030\u00b8\u0002H\u0002R\u0011\u0010\u000b\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u000e\u001a\u00020\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010#R\u001a\u0010$\u001a\u00020\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b$\u0010#\"\u0004\b%\u0010&R\u000e\u0010\'\u001a\u00020\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u001dX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020,X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0010\u001a\u00020\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0010\u0010/\u001a\u0004\u0018\u000100X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u00101\u001a\u000202X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u00103\u001a\u000204X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u00105\u001a\b\u0012\u0004\u0012\u00020\u0007068F\u00a2\u0006\u0006\u001a\u0004\b7\u00108R\u000e\u00109\u001a\u00020:X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010>\u001a\u0004\u0018\u00010?X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\r\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b@\u0010AR\u000e\u0010B\u001a\u00020CX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u00d5\u0002"}, d2 = {"Lcom/contusfly/adapters/ChatAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/contusfly/interfaces/MessageItemListener;", "Lcom/contusfly/interfaces/AudioPlayItemViewSetListener;", "mainList", "Ljava/util/ArrayList;", "Lcom/mirrorflysdk/api/models/ChatMessage;", "selectedMessages", "", "chatType", "activity", "Landroid/content/Context;", "userJid", "isFromEditScreen", "", "listChats", "Landroidx/recyclerview/widget/RecyclerView;", "(Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/lang/String;Landroid/content/Context;Ljava/lang/String;ZLandroidx/recyclerview/widget/RecyclerView;)V", "getActivity", "()Landroid/content/Context;", "audioItemView", "Lcom/contusfly/adapters/viewhelpers/AudioItemView;", "chatAdapterHelper", "Lcom/contusfly/adapters/ChatAdapterHelper;", "chatMsgTime", "Lcom/contusfly/utils/ChatMsgTime;", "context", "doublePRESSINTERVAL", "", "fileItemView", "Lcom/contusfly/adapters/viewhelpers/FileItemView;", "googleTranslatedKey", "imageItemViewHelper", "Lcom/contusfly/adapters/viewhelpers/ImageItemViewHelper;", "()Z", "isLinkLongClick", "setLinkLongClick", "(Z)V", "isTranslationChecked", "lastPressTime", "linkButtonClickStatusListener", "Lcom/contusfly/utils/ModifiedlinkMovementMethod$OnLinkClickStatusListener;", "linkClickListener", "Lcom/contusfly/utils/ModifiedlinkMovementMethod$OnLinkClickListener;", "getListChats", "()Landroidx/recyclerview/widget/RecyclerView;", "listener", "Lcom/contusfly/interfaces/OnChatItemClickListener;", "longClickListener", "Lcom/contusfly/utils/ModifiedlinkMovementMethod$OnLinkLongClickListener;", "mediaController", "Lcom/contusfly/chat/MediaController;", "messages", "", "getMessages", "()Ljava/util/List;", "replyViewUtils", "Lcom/contusfly/chat/reply/ReplyViewUtils;", "searchEnabled", "searchKey", "selectedLanguage", "setDrawable", "Lcom/contusfly/views/SetDrawable;", "getUserJid", "()Ljava/lang/String;", "videoItemViewHelper", "Lcom/contusfly/adapters/viewhelpers/VideoItemViewHelper;", "adjustPadding", "", "space", "Landroid/view/View;", "position", "", "messageList", "audioPlayClick", "item", "holder", "playImage", "Landroid/widget/ImageView;", "mirrorFlySeekBar", "Lcom/contusfly/views/MirrorFlySeekBar;", "durationView", "Landroid/widget/TextView;", "doesSentMessage", "bindMediaViews", "bindReceiverImageView", "messageItem", "bindReceiverLocationView", "bindReceiverMeetView", "bindReceiverTextView", "bindReceiverVideoView", "bindSenderImageView", "bindSenderLocationView", "bindSenderMeetView", "bindSenderTextView", "bindSenderVideoView", "canShowForwardImg", "canShowForwardMeet", "checkAndTranslateMessage", "txtRevChatCaption", "txtTranslatedText", "Landroidx/emoji/widget/EmojiAppCompatTextView;", "translatedLinearLayout", "Landroid/widget/LinearLayout;", "checkUserFromReceiver", "checkUserFromSender", "contactSentView", "contactName", "registeredJid", "time", "currentlyPlayItem", "progress", "playduration", "displayRecallInfoForReceiver", "meetReceivedViewHolder", "Lcom/contusfly/adapters/holders/MeetReceivedViewHolder;", "txtReceiverViewHolder", "Lcom/contusfly/adapters/holders/TextReceivedViewHolder;", "displayRecallInfoForSender", "meetSentViewHolder", "Lcom/contusfly/adapters/holders/MeetSentViewHolder;", "txtSenderViewHolder", "Lcom/contusfly/adapters/holders/TextSentViewHolder;", "downloadClick", "download", "cancelDownload", "forwardImgVisibilityForSentImageItem", "imageSentViewHolder", "Lcom/contusfly/adapters/holders/ImageSentViewHolder;", "forwardImgVisibilityForSentVideoItem", "videoSentViewHolder", "Lcom/contusfly/adapters/holders/VideoSentViewHolder;", "getAudioMediaStatus", "message", "sentAudioForwardImage", "getAudioView", "getContactView", "getFileView", "getHtmlChatMessageText", "getItemCount", "getItemId", "getItemViewType", "getJidFromSharedContact", "contactMessage", "Lcom/mirrorflysdk/api/models/ContactChatMessage;", "getMediaController", "getMessageAudioPosition", "messageId", "getMessagePosition", "getNotificationView", "getSpannedText", "getStarIcon", "imgStarred", "imgStarredCaption", "getStatusIcon", "imgStatus", "imgStatusCaption", "handleContactView", "contactReceiverViewHolder", "Lcom/contusfly/adapters/holders/ContactReceivedViewHolder;", "jID", "handleFileTextSearch", "htmlText", "", "txtSendName", "Landroidx/appcompat/widget/AppCompatTextView;", "handleImageMediaStatusChanged", "handlePayloads", "bundle", "Landroid/os/Bundle;", "handlePayloadsAudioReceived", "key", "audioReceiverViewHolder", "Lcom/contusfly/adapters/holders/AudioReceivedViewHolder;", "handlePayloadsAudioSent", "audioSentViewHolder", "Lcom/contusfly/adapters/holders/AudioSentViewHolder;", "handlePayloadsContactReceived", "contactReceivedViewHolder", "handlePayloadsContactSent", "contactSentViewHolder", "Lcom/contusfly/adapters/holders/ContactSentViewHolder;", "handlePayloadsFileReceived", "fileReceivedViewHolder", "Lcom/contusfly/adapters/holders/FileReceivedViewHolder;", "handlePayloadsFileSent", "fileSentViewHolder", "Lcom/contusfly/adapters/holders/FileSentViewHolder;", "handlePayloadsImageReceived", "imageReceivedViewHolder", "Lcom/contusfly/adapters/holders/ImageReceivedViewHolder;", "handlePayloadsImageSent", "handlePayloadsLocationReceived", "locationReceivedViewHolder", "Lcom/contusfly/adapters/holders/LocationReceivedViewHolder;", "handlePayloadsLocationSent", "locationSentViewHolder", "Lcom/contusfly/adapters/holders/LocationSentViewHolder;", "handlePayloadsScheduleMeetReceived", "handlePayloadsScheduleMeetSent", "handlePayloadsTextReceived", "textReceivedViewHolder", "handlePayloadsTextSender", "textSentViewHolder", "handlePayloadsVideoReceived", "videoReceivedViewHolder", "Lcom/contusfly/adapters/holders/VideoReceivedViewHolder;", "handlePayloadsVideoSent", "handleRecallForReceivedMeetMessage", "handleRecallForReceivedTextMessage", "textViewHolder", "handleReceiverTextSearch", "handleReceiverTextSearchMention", "mentionedUserName", "Landroid/text/SpannableStringBuilder;", "handleSenderTextSearch", "handleSenderTextSearchMention", "handleVideoMediaStatusChanged", "hideMediaOption", "txtRetry", "imgForwardLocationVisibility", "onBindViewHolder", "payloads", "", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onReplyViewClicked", "pauseMediaPlayer", "receiverDownloadClick", "retry", "receiverItemClick", "receiverItem", "receiverItemTranslate", "mainChatList", "receiverViewHolder", "Lcom/contusfly/adapters/holders/BaseReceivedViewHolder;", "receiverTextTranslation", "refreshMessage", "refreshMessageAtPosition", "senderDownloadClick", "cancelUpload", "carbonDownloadView", "senderItemClick", "senderItem", "sentAudioForwardImgVisibility", "setAudioSeekBarListener", "setChatStatus", "viewHolder", "setDeviceFontSizeChangesEffectOnTextView", "txtChatSender", "setFileMediaStatusReceiverView", "setFileMediaStatusSenderView", "fileViewHolder", "setFileSenderView", "setImageViewSize", "fileSize", "downloadView", "fileSizeView", "setJoinLinkView", "txtChat", "joinLinkView", "joinLinkLogo", "originalMsg", "setListenersForAudioMessages", "audioViewHolder", "setListenersForContactMessages", "contactHolder", "setListenersForReceivedContactMessages", "setListenersForReceivedFileMessages", "setListenersForReceiverAudioMessages", "setListenersForReceiverImageMessages", "imgViewHolder", "setListenersForReceiverLocationMessages", "locationHolder", "setListenersForReceiverMeetMessages", "setListenersForReceiverTextMessages", "setListenersForReceiverVideoMessages", "videoReceiverViewHolder", "setListenersForSenderImageMessages", "setListenersForSenderLocationMessages", "setListenersForSenderMeetMessages", "setListenersForSenderTextMessages", "setListenersForSenderVideoMessages", "videoSenderViewHolder", "setListenersForSentFileMessages", "setLoginUserContactProfilePicture", "txtSendImg", "isSender", "setMediaCaption", "mediStatus", "Lcom/contusfly/models/MediaCaption;", "setMediaDuration", "txtSendDuration", "fileStatus", "imgChatType", "setMediaStatus", "mediaStatus", "Lcom/contusfly/models/MediaStatus;", "setMeetLinkView", "scheduledMeetLinkView", "scheduledMeetLinkLogo", "setOnDownloadClickListener", "setRecentChatStatus", "status", "Lcom/mirrorflysdk/api/MessageStatus;", "setSearch", "isSearchEnabled", "setSearchContactText", "Lcom/contusfly/views/CustomTextView;", "fromHtml", "Landroid/text/Spanned;", "setSelectedChatItem", "view", "setSenderMeetText", "setSenderText", "setStaredStatus", "isStarred", "imageView", "setStarredCaptionStatus", "setStatus", "imgChatStatus", "showHideSenderName", "showSenderNameIfGroupChat", "stopMediaPlayer", "updateSeekbarChanges", "fromUser", "uploadClick", "carbonRetry", "validateAndRefreshMessagePosition", "findAgain", "validateMessagePosition", "viewContactSaveMessageItem", "senderUserJid", "receivedNumber", "viewSeparator", "contactActionText", "Companion", "app_debug"})
public final class ChatAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<androidx.recyclerview.widget.RecyclerView.ViewHolder> implements com.contusfly.interfaces.MessageItemListener, com.contusfly.interfaces.AudioPlayItemViewSetListener {
    private final java.util.ArrayList<com.mirrorflysdk.api.models.ChatMessage> mainList = null;
    private java.util.ArrayList<java.lang.String> selectedMessages;
    private final java.lang.String chatType = null;
    @org.jetbrains.annotations.NotNull
    private final android.content.Context activity = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String userJid = null;
    private final boolean isFromEditScreen = false;
    @org.jetbrains.annotations.NotNull
    private final androidx.recyclerview.widget.RecyclerView listChats = null;
    private boolean isLinkLongClick = false;
    
    /**
     * The listener instance of OnChatItemClickListener
     */
    private com.contusfly.interfaces.OnChatItemClickListener listener;
    
    /**
     * The startupActivityContext of the list view activity
     */
    private final android.content.Context context = null;
    
    /**
     * The chat msg time which used to display the chat received and send time
     */
    private final com.contusfly.utils.ChatMsgTime chatMsgTime = null;
    
    /**
     * Helper for the Adapter
     */
    private final com.contusfly.adapters.ChatAdapterHelper chatAdapterHelper = null;
    
    /**
     * Image item view helper
     */
    private final com.contusfly.adapters.viewhelpers.ImageItemViewHelper imageItemViewHelper = null;
    
    /**
     * Video item view helper
     */
    private final com.contusfly.adapters.viewhelpers.VideoItemViewHelper videoItemViewHelper = null;
    
    /**
     * Audio item view
     */
    private final com.contusfly.adapters.viewhelpers.AudioItemView audioItemView = null;
    
    /**
     * Audio item view
     */
    private final com.contusfly.adapters.viewhelpers.FileItemView fileItemView = null;
    
    /**
     * The media controller which used to play the audio in the chat view
     */
    private final com.contusfly.chat.MediaController mediaController = null;
    
    /**
     * Selected translated language
     */
    private final java.lang.String selectedLanguage = null;
    
    /**
     * google translation key
     */
    private final java.lang.String googleTranslatedKey = null;
    private final long doublePRESSINTERVAL = 0L;
    private long lastPressTime = 0L;
    
    /**
     * This boolean help to identify the translation field was enable or not
     */
    private final boolean isTranslationChecked = false;
    
    /**
     * This is a kotlin ReplyView utils class
     */
    private final com.contusfly.chat.reply.ReplyViewUtils replyViewUtils = null;
    private com.contusfly.views.SetDrawable setDrawable;
    private boolean searchEnabled = false;
    private java.lang.String searchKey;
    @org.jetbrains.annotations.NotNull
    public static final com.contusfly.adapters.ChatAdapter.Companion Companion = null;
    
    /**
     * Type of Text chat sender
     */
    public static final int TYPE_TEXT_SENDER = 1;
    
    /**
     * Type of Text chat Receiver
     */
    public static final int TYPE_TEXT_RECEIVER = 10;
    
    /**
     * The type image and video sender.
     */
    public static final int TYPE_IMAGE_SENDER = 2;
    
    /**
     * The type image and video receiver.
     */
    public static final int TYPE_IMAGE_RECEIVER = 20;
    
    /**
     * The type image and video sender.
     */
    public static final int TYPE_VIDEO_SENDER = 3;
    
    /**
     * The type image and video receiver.
     */
    public static final int TYPE_VIDEO_RECEIVER = 30;
    
    /**
     * Type of location chat sender
     */
    public static final int TYPE_LOCATION_SENDER = 4;
    
    /**
     * Type of location chat receiver
     */
    public static final int TYPE_LOCATION_RECEIVER = 40;
    
    /**
     * Type of audio chat sender
     */
    public static final int TYPE_AUDIO_SENDER = 5;
    
    /**
     * Type of audio chat receiver
     */
    public static final int TYPE_AUDIO_RECEIVER = 50;
    
    /**
     * Type of contact chat sender
     */
    public static final int TYPE_CONTACT_SENDER = 6;
    
    /**
     * Type of contact chat receiver
     */
    public static final int TYPE_CONTACT_RECEIVER = 60;
    
    /**
     * Type of file chat sender
     */
    public static final int TYPE_FILE_SENDER = 7;
    
    /**
     * Type of file chat receiver
     */
    public static final int TYPE_FILE_RECEIVER = 70;
    
    /**
     * Type of the message date
     */
    public static final int TYPE_MSG_NOTIFICATION = 8;
    
    /**
     * type of the meet chat sender
     */
    public static final int TYPE_MEET_SENDER = 9;
    
    /**
     * type of the meet chat receiver
     */
    public static final int TYPE_MEET_RECEIVER = 80;
    private final com.contusfly.utils.ModifiedlinkMovementMethod.OnLinkLongClickListener longClickListener = null;
    private final com.contusfly.utils.ModifiedlinkMovementMethod.OnLinkClickListener linkClickListener = null;
    private final com.contusfly.utils.ModifiedlinkMovementMethod.OnLinkClickStatusListener linkButtonClickStatusListener = null;
    
    public ChatAdapter(@org.jetbrains.annotations.NotNull
    java.util.ArrayList<com.mirrorflysdk.api.models.ChatMessage> mainList, @org.jetbrains.annotations.NotNull
    java.util.ArrayList<java.lang.String> selectedMessages, @org.jetbrains.annotations.NotNull
    java.lang.String chatType, @org.jetbrains.annotations.NotNull
    android.content.Context activity, @org.jetbrains.annotations.NotNull
    java.lang.String userJid, boolean isFromEditScreen, @org.jetbrains.annotations.NotNull
    androidx.recyclerview.widget.RecyclerView listChats) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final android.content.Context getActivity() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getUserJid() {
        return null;
    }
    
    public final boolean isFromEditScreen() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.recyclerview.widget.RecyclerView getListChats() {
        return null;
    }
    
    public final boolean isLinkLongClick() {
        return false;
    }
    
    public final void setLinkLongClick(boolean p0) {
    }
    
    /**
     * Sets the on download click listener.
     *
     * @param listener The listener when the chat item download clicked
     */
    public final void setOnDownloadClickListener(@org.jetbrains.annotations.Nullable
    com.contusfly.interfaces.OnChatItemClickListener listener) {
    }
    
    public final void setSearch(boolean isSearchEnabled, @org.jetbrains.annotations.NotNull
    java.lang.String searchKey) {
    }
    
    /**
     * This method calls to create a new [RecyclerView.ViewHolder] and initializes some
     * private fields to be used by RecyclerView.
     *
     * @see .onCreateViewHolder
     */
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public androidx.recyclerview.widget.RecyclerView.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull
    androidx.recyclerview.widget.RecyclerView.ViewHolder holder, int position, @org.jetbrains.annotations.NotNull
    java.util.List<java.lang.Object> payloads) {
    }
    
    private final void handlePayloads(android.os.Bundle bundle, androidx.recyclerview.widget.RecyclerView.ViewHolder holder, com.mirrorflysdk.api.models.ChatMessage item, int position) {
    }
    
    private final void handlePayloadsTextSender(java.lang.String key, com.contusfly.adapters.holders.TextSentViewHolder textSentViewHolder, com.mirrorflysdk.api.models.ChatMessage item, int position) {
    }
    
    private final void handlePayloadsTextReceived(java.lang.String key, com.contusfly.adapters.holders.TextReceivedViewHolder textReceivedViewHolder, com.mirrorflysdk.api.models.ChatMessage item, int position) {
    }
    
    private final void handlePayloadsLocationSent(java.lang.String key, com.contusfly.adapters.holders.LocationSentViewHolder locationSentViewHolder, com.mirrorflysdk.api.models.ChatMessage item, int position) {
    }
    
    private final void imgForwardLocationVisibility(com.mirrorflysdk.api.models.ChatMessage item, com.contusfly.adapters.holders.LocationSentViewHolder locationSentViewHolder) {
    }
    
    private final void handlePayloadsLocationReceived(java.lang.String key, com.contusfly.adapters.holders.LocationReceivedViewHolder locationReceivedViewHolder, com.mirrorflysdk.api.models.ChatMessage item, int position) {
    }
    
    private final void handlePayloadsScheduleMeetSent(java.lang.String key, com.contusfly.adapters.holders.MeetSentViewHolder meetSentViewHolder, com.mirrorflysdk.api.models.ChatMessage item, int position) {
    }
    
    private final boolean canShowForwardMeet(com.mirrorflysdk.api.models.ChatMessage item) {
        return false;
    }
    
    private final void handlePayloadsScheduleMeetReceived(java.lang.String key, com.contusfly.adapters.holders.MeetReceivedViewHolder meetReceivedViewHolder, com.mirrorflysdk.api.models.ChatMessage item, int position) {
    }
    
    private final void handlePayloadsFileSent(java.lang.String key, com.contusfly.adapters.holders.FileSentViewHolder fileSentViewHolder, com.mirrorflysdk.api.models.ChatMessage item, int position) {
    }
    
    private final void handlePayloadsFileReceived(java.lang.String key, com.contusfly.adapters.holders.FileReceivedViewHolder fileReceivedViewHolder, com.mirrorflysdk.api.models.ChatMessage item, int position) {
    }
    
    private final void handlePayloadsAudioSent(java.lang.String key, com.contusfly.adapters.holders.AudioSentViewHolder audioSentViewHolder, com.mirrorflysdk.api.models.ChatMessage item, int position) {
    }
    
    private final void getAudioMediaStatus(com.mirrorflysdk.api.models.ChatMessage message, android.widget.ImageView sentAudioForwardImage) {
    }
    
    private final void handlePayloadsAudioReceived(java.lang.String key, com.contusfly.adapters.holders.AudioReceivedViewHolder audioReceiverViewHolder, com.mirrorflysdk.api.models.ChatMessage item, int position) {
    }
    
    private final void handlePayloadsImageSent(java.lang.String key, com.contusfly.adapters.holders.ImageSentViewHolder imageSentViewHolder, com.mirrorflysdk.api.models.ChatMessage item, int position) {
    }
    
    private final void forwardImgVisibilityForSentImageItem(com.contusfly.adapters.holders.ImageSentViewHolder imageSentViewHolder, com.mirrorflysdk.api.models.ChatMessage item) {
    }
    
    private final void handleImageMediaStatusChanged(com.contusfly.adapters.holders.ImageSentViewHolder imageSentViewHolder, com.mirrorflysdk.api.models.ChatMessage item) {
    }
    
    private final void handlePayloadsImageReceived(java.lang.String key, com.contusfly.adapters.holders.ImageReceivedViewHolder imageReceivedViewHolder, com.mirrorflysdk.api.models.ChatMessage item, int position) {
    }
    
    private final void handlePayloadsVideoSent(java.lang.String key, com.contusfly.adapters.holders.VideoSentViewHolder videoSentViewHolder, com.mirrorflysdk.api.models.ChatMessage item, int position) {
    }
    
    private final void forwardImgVisibilityForSentVideoItem(com.contusfly.adapters.holders.VideoSentViewHolder videoSentViewHolder, com.mirrorflysdk.api.models.ChatMessage item) {
    }
    
    private final boolean canShowForwardImg(com.mirrorflysdk.api.models.ChatMessage item) {
        return false;
    }
    
    private final void handleVideoMediaStatusChanged(com.contusfly.adapters.holders.VideoSentViewHolder videoSentViewHolder, com.mirrorflysdk.api.models.ChatMessage item) {
    }
    
    private final void handlePayloadsVideoReceived(java.lang.String key, com.contusfly.adapters.holders.VideoReceivedViewHolder videoReceivedViewHolder, com.mirrorflysdk.api.models.ChatMessage item, int position) {
    }
    
    private final void handlePayloadsContactSent(java.lang.String key, com.contusfly.adapters.holders.ContactSentViewHolder contactSentViewHolder, com.mirrorflysdk.api.models.ChatMessage item, int position) {
    }
    
    private final void handlePayloadsContactReceived(java.lang.String key, com.contusfly.adapters.holders.ContactReceivedViewHolder contactReceivedViewHolder, com.mirrorflysdk.api.models.ChatMessage item, int position) {
    }
    
    private final android.widget.ImageView getStatusIcon(com.mirrorflysdk.api.models.ChatMessage item, android.widget.ImageView imgStatus, android.widget.ImageView imgStatusCaption) {
        return null;
    }
    
    private final android.widget.ImageView getStarIcon(com.mirrorflysdk.api.models.ChatMessage item, android.widget.ImageView imgStarred, android.widget.ImageView imgStarredCaption) {
        return null;
    }
    
    /**
     * This method internally calls [.onBindViewHolder] to
     * update the [RecyclerView.ViewHolder] contents with the item at the given position and
     * also sets up some private fields to be used by RecyclerView.
     *
     * @see .onBindViewHolder
     */
    @java.lang.Override
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull
    androidx.recyclerview.widget.RecyclerView.ViewHolder holder, int position) {
    }
    
    /**
     * Return the view type of the item at `position` for the purposes of view
     * recycling.
     *
     *
     *
     * The default implementation of this method returns 0, making the assumption of
     * a single view type for the adapter. Unlike ListView adapters, types need not be contiguous.
     * Consider using id resources to uniquely identify item view types.
     *
     * @param position position to query
     * @return integer value identifying the type of the view needed to represent the item at
     * `position`. Type codes need not be contiguous.
     */
    @java.lang.Override
    public int getItemViewType(int position) {
        return 0;
    }
    
    /**
     * Return the stable ID for the item at `position`. If [.hasStableIds] would
     * return false this method should return -1. The default implementation of this method returns
     * -1.
     *
     * @param position Adapter position to query
     * @return the stable ID of the item at position
     */
    @java.lang.Override
    public long getItemId(int position) {
        return 0L;
    }
    
    /**
     * Returns the total number of items in the data set held by the adapter. Added Null handling so
     * as to prevent null pointer exception
     *
     * @return The total number of items in this adapter.
     */
    @java.lang.Override
    public int getItemCount() {
        return 0;
    }
    
    /**
     * Show/Hides sender name if the chat is group chat
     *
     * @param holder   view holder of the item
     * @param item     message item of the view
     * @param position position of the item
     */
    private final void showSenderNameIfGroupChat(androidx.recyclerview.widget.RecyclerView.ViewHolder holder, com.mirrorflysdk.api.models.ChatMessage item, int position) {
    }
    
    /**
     * This method will bind the data to the sender text view.
     *
     * @param holder   Holder of the text view
     * @param item     Instance of the Message
     * @param position Position of the list item
     */
    private final void bindSenderTextView(androidx.recyclerview.widget.RecyclerView.ViewHolder holder, com.mirrorflysdk.api.models.ChatMessage item, int position) {
    }
    
    private final void setSenderText(com.mirrorflysdk.api.models.ChatMessage item, android.widget.TextView txtChatSender, com.contusfly.adapters.holders.TextSentViewHolder holder) {
    }
    
    private final void setSenderMeetText(com.mirrorflysdk.api.models.ChatMessage item, android.widget.TextView txtChatSender, com.contusfly.adapters.holders.MeetSentViewHolder holder) {
    }
    
    private final void setMeetLinkView(java.lang.String userJid, android.widget.TextView txtChat, android.widget.LinearLayout scheduledMeetLinkView, android.widget.ImageView scheduledMeetLinkLogo) {
    }
    
    private final void setJoinLinkView(java.lang.String userJid, android.widget.TextView txtChat, android.widget.LinearLayout joinLinkView, android.widget.ImageView joinLinkLogo, java.lang.String originalMsg) {
    }
    
    private final void setDeviceFontSizeChangesEffectOnTextView(android.widget.TextView txtChatSender, com.contusfly.adapters.holders.MeetSentViewHolder meetSentViewHolder) {
    }
    
    private final void setDeviceFontSizeChangesEffectOnTextView(android.widget.TextView txtChatSender, com.contusfly.adapters.holders.MeetReceivedViewHolder meetReceivedViewHolder) {
    }
    
    private final void handleSenderTextSearch(java.lang.CharSequence htmlText, com.contusfly.adapters.holders.TextSentViewHolder holder) {
    }
    
    private final void handleSenderTextSearch(java.lang.CharSequence htmlText, com.contusfly.adapters.holders.MeetSentViewHolder holder) {
    }
    
    private final void handleSenderTextSearchMention(java.lang.CharSequence htmlText, com.contusfly.adapters.holders.TextSentViewHolder holder, android.text.SpannableStringBuilder mentionedUserName) {
    }
    
    private final void handleFileTextSearch(java.lang.CharSequence htmlText, androidx.appcompat.widget.AppCompatTextView txtSendName) {
    }
    
    private final void setSearchContactText(com.contusfly.views.CustomTextView txtSendName, android.text.Spanned fromHtml) {
    }
    
    /**
     * This method will bind the data to receiver text view.
     *
     * @param holder   Holder of the text view
     * @param item     Instance of the ChatMessage
     * @param position Position of the list item
     */
    private final void bindReceiverTextView(androidx.recyclerview.widget.RecyclerView.ViewHolder holder, com.mirrorflysdk.api.models.ChatMessage item, int position) {
    }
    
    private final void receiverTextTranslation(java.util.ArrayList<com.mirrorflysdk.api.models.ChatMessage> mainChatList, com.contusfly.adapters.holders.TextReceivedViewHolder txtReceiverViewHolder) {
    }
    
    private final void handleRecallForReceivedTextMessage(com.mirrorflysdk.api.models.ChatMessage item, com.contusfly.adapters.holders.TextReceivedViewHolder textViewHolder) {
    }
    
    private final void handleRecallForReceivedMeetMessage(com.mirrorflysdk.api.models.ChatMessage item, com.contusfly.adapters.holders.MeetReceivedViewHolder meetReceivedViewHolder) {
    }
    
    private final void handleReceiverTextSearchMention(java.lang.CharSequence htmlText, com.contusfly.adapters.holders.TextReceivedViewHolder holder, android.text.SpannableStringBuilder mentionedUserName) {
    }
    
    private final void handleReceiverTextSearch(java.lang.CharSequence htmlText, com.contusfly.adapters.holders.MeetReceivedViewHolder holder) {
    }
    
    private final void handleReceiverTextSearch(java.lang.CharSequence htmlText, com.contusfly.adapters.holders.TextReceivedViewHolder holder) {
    }
    
    /**
     * Converts message to a valid spanned text
     *
     * @param message message date which is sent/received
     */
    private final java.lang.String getSpannedText(java.lang.String message) {
        return null;
    }
    
    /**
     * Displays the recall information when the message was deleted.
     *
     * @param txtReceiverViewHolder A ViewHolder which describes the text item view.
     */
    private final void displayRecallInfoForReceiver(com.contusfly.adapters.holders.TextReceivedViewHolder txtReceiverViewHolder) {
    }
    
    /**
     * Displays the recall information when the message was deleted.
     *
     * @param txtSenderViewHolder A ViewHolder which describes the text item view.
     */
    private final void displayRecallInfoForSender(com.contusfly.adapters.holders.TextSentViewHolder txtSenderViewHolder) {
    }
    
    private final void displayRecallInfoForSender(com.contusfly.adapters.holders.MeetSentViewHolder meetSentViewHolder) {
    }
    
    private final void displayRecallInfoForReceiver(com.contusfly.adapters.holders.MeetReceivedViewHolder meetReceivedViewHolder) {
    }
    
    /**
     * This method will bind the data to the sender Image view.
     *
     * @param holder      Holder of the recycler view
     * @param messageItem ChatMessage item contains message data
     * @param position    List item position
     */
    private final void bindSenderImageView(androidx.recyclerview.widget.RecyclerView.ViewHolder holder, com.mirrorflysdk.api.models.ChatMessage messageItem, int position) {
    }
    
    /**
     * This method will bind the data to the receiver text view.
     *
     * @param holder      Holder of the recycler view
     * @param messageItem ChatMessage item contains message data
     * @param position    List item position
     */
    private final void bindReceiverImageView(androidx.recyclerview.widget.RecyclerView.ViewHolder holder, com.mirrorflysdk.api.models.ChatMessage messageItem, int position) {
    }
    
    /**
     * This method will bind the data to the sender Image view.
     *
     * @param holder      Holder of the recycler view
     * @param messageItem ChatMessage item contains message data
     * @param position    List item position
     */
    private final void bindSenderVideoView(androidx.recyclerview.widget.RecyclerView.ViewHolder holder, com.mirrorflysdk.api.models.ChatMessage messageItem, int position) {
    }
    
    /**
     * This method will bind the data to the receiver text view.
     *
     * @param holder      Holder of the recycler view
     * @param messageItem ChatMessage item contains message data
     * @param position    List item position
     */
    private final void bindReceiverVideoView(androidx.recyclerview.widget.RecyclerView.ViewHolder holder, com.mirrorflysdk.api.models.ChatMessage messageItem, int position) {
    }
    
    private final void receiverItemTranslate(java.util.ArrayList<com.mirrorflysdk.api.models.ChatMessage> mainChatList, int position, com.contusfly.adapters.holders.BaseReceivedViewHolder receiverViewHolder) {
    }
    
    private final void checkAndTranslateMessage(androidx.recyclerview.widget.RecyclerView.ViewHolder holder, android.widget.TextView txtRevChatCaption, androidx.emoji.widget.EmojiAppCompatTextView txtTranslatedText, android.widget.LinearLayout translatedLinearLayout) {
    }
    
    /**
     * Create the audio view based on the Message data
     *
     * @param holder   Holder of the recycler view
     * @param item     ChatMessage item contains message data
     * @param position List item position
     */
    private final void getAudioView(androidx.recyclerview.widget.RecyclerView.ViewHolder holder, com.mirrorflysdk.api.models.ChatMessage item, int position) {
    }
    
    private final void sentAudioForwardImgVisibility(com.mirrorflysdk.api.models.ChatMessage item, com.contusfly.adapters.holders.AudioSentViewHolder audioSentViewHolder) {
    }
    
    /**
     * Gets the location view to display the map
     *
     * @param holder        Holder of the recycler view
     * @param item          ChatMessage item contains message data
     * @param position      List item position
     */
    private final void bindSenderLocationView(androidx.recyclerview.widget.RecyclerView.ViewHolder holder, com.mirrorflysdk.api.models.ChatMessage item, int position) {
    }
    
    /**
     * Gets the receiver location view to display the map
     *
     * @param holder        Holder of the recycler view
     * @param item          Message item contains message data
     * @param position      List item position
     */
    private final void bindReceiverLocationView(androidx.recyclerview.widget.RecyclerView.ViewHolder holder, com.mirrorflysdk.api.models.ChatMessage item, int position) {
    }
    
    /**
     * This method will bind the data to the sender text view.
     *
     * @param holder   Holder of the text view
     * @param item     Instance of the Message
     * @param position Position of the list item
     */
    private final void bindSenderMeetView(androidx.recyclerview.widget.RecyclerView.ViewHolder holder, com.mirrorflysdk.api.models.ChatMessage item, int position) {
    }
    
    /**
     * This method will bind the data to the receiver scheduledMeet text view.
     *
     * @param holder        Holder of the recycler view
     * @param item          Message item contains message data
     * @param position      List item position
     */
    private final void bindReceiverMeetView(androidx.recyclerview.widget.RecyclerView.ViewHolder holder, com.mirrorflysdk.api.models.ChatMessage item, int position) {
    }
    
    /**
     * Sets the background color for the selected message from the multi select in chat window
     *
     * @param view             Recycler view row item
     * @param message          ChatMessage instance
     */
    private final void setSelectedChatItem(android.view.View view, com.mirrorflysdk.api.models.ChatMessage message) {
    }
    
    /**
     * Register a callback to be invoked when this view is clicked. If this view is not
     * clickable, it becomes clickable.
     *
     * @param retry        The retry view placed in the ViewHolder.
     * @param cancelUpload The cancel upload view placed in the ViewHolder.
     * @param messageItem  The message object which possess the data rendered in the
     * ViewHolder.
     */
    private final void uploadClick(android.view.View retry, android.view.View carbonRetry, android.view.View cancelUpload, com.mirrorflysdk.api.models.ChatMessage messageItem) {
    }
    
    /**
     * Register a callback to be invoked when this view is clicked. If this view is not
     * clickable, it becomes clickable.
     *
     * @param download       The download view placed in the ViewHolder.
     * @param cancelDownload The cancel download view placed in the ViewHolder.
     * @param messageItem    The message object which possess the data rendered in the
     * ViewHolder.
     */
    private final void downloadClick(android.view.View download, android.view.View cancelDownload, com.mirrorflysdk.api.models.ChatMessage messageItem) {
    }
    
    /**
     * Handle the file view to display the file on sender view or receiver view with type of
     * file in the chat view.
     *
     * @param holder   Holder of the recycler view
     * @param item     ChatMessage item contains message data
     * @param position List item position
     */
    private final void getFileView(androidx.recyclerview.widget.RecyclerView.ViewHolder holder, com.mirrorflysdk.api.models.ChatMessage item, int position) {
    }
    
    private final void setFileMediaStatusReceiverView(com.contusfly.adapters.holders.FileReceivedViewHolder viewHolder, com.mirrorflysdk.api.models.ChatMessage item) {
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
    
    private final void setFileMediaStatusSenderView(com.contusfly.adapters.holders.FileSentViewHolder fileViewHolder, com.mirrorflysdk.api.models.ChatMessage item) {
    }
    
    /**
     * Create the contact view based on the Message data
     *
     * @param holder        Holder of the recycler view
     * @param item          ChatMessage item contains message data
     * @param position      List item position
     */
    private final void getContactView(androidx.recyclerview.widget.RecyclerView.ViewHolder holder, com.mirrorflysdk.api.models.ChatMessage item, int position) {
    }
    
    private final void contactSentView(androidx.recyclerview.widget.RecyclerView.ViewHolder holder, com.mirrorflysdk.api.models.ChatMessage item, int position, java.lang.String contactName, java.lang.String registeredJid, java.lang.String time) {
    }
    
    /**
     * Checking user to send contact from receiver side
     *
     * @param holder Holder of the recycler view
     * @param item
     */
    private final void checkUserFromReceiver(androidx.recyclerview.widget.RecyclerView.ViewHolder holder, com.mirrorflysdk.api.models.ChatMessage item) {
    }
    
    private final void handleContactView(com.contusfly.adapters.holders.ContactReceivedViewHolder contactReceiverViewHolder, java.lang.String jID) {
    }
    
    private final void viewContactSaveMessageItem(java.lang.String senderUserJid, java.lang.String receivedNumber, android.view.View viewSeparator, com.contusfly.views.CustomTextView contactActionText) {
    }
    
    private final void setLoginUserContactProfilePicture(android.widget.ImageView txtSendImg, boolean isSender) {
    }
    
    /**
     * Checking user to send contact from sender side
     *
     * @param holder        Holder of the recycler view
     */
    private final void checkUserFromSender(androidx.recyclerview.widget.RecyclerView.ViewHolder holder, com.mirrorflysdk.api.models.ChatMessage item) {
    }
    
    /**
     * Determines the jid of the shared contact if the number is registered with the application.
     *
     * @param contactMessage The contact message shared in the chat conversation window.
     * @return The jabber id of the shared phone number if it's registered with the application.
     */
    private final java.lang.String getJidFromSharedContact(com.mirrorflysdk.api.models.ContactChatMessage contactMessage) {
        return null;
    }
    
    /**
     * @param holder   view holder instance
     * @param item     message instance
     * @param position row position
     */
    private final void bindMediaViews(androidx.recyclerview.widget.RecyclerView.ViewHolder holder, com.mirrorflysdk.api.models.ChatMessage item, int position) {
    }
    
    /**
     * Show/Hides sender name in group chat based on the chat sender.
     *
     * @param holder   view holder of the item
     * @param item     message item of the view
     * @param position position of the item
     */
    private final void showHideSenderName(androidx.recyclerview.widget.RecyclerView.ViewHolder holder, com.mirrorflysdk.api.models.ChatMessage item, int position) {
    }
    
    /**
     * Adjust the view space by show/hiding space view
     *
     * @param space    Space to adjust by show/hiding
     * @param position Current position
     */
    private final void adjustPadding(android.view.View space, int position, java.util.List<? extends com.mirrorflysdk.api.models.ChatMessage> messageList) {
    }
    
    /**
     * Returns Spanned string by adding HTML empty text to avoid overlap with time view in
     * FrameLayout
     *
     * @param message Message content
     * @return Spanned Result spanned text with space
     */
    private final java.lang.String getHtmlChatMessageText(java.lang.String message) {
        return null;
    }
    
    /**
     * Sets the listener to the child views present in the parent view.
     *
     * @param txtSenderViewHolder The view holding the child items.
     * @param item                The data set used to render the content of child views.
     */
    private final void setListenersForSenderTextMessages(com.contusfly.adapters.holders.TextSentViewHolder txtSenderViewHolder, com.mirrorflysdk.api.models.ChatMessage item) {
    }
    
    private final void setListenersForSenderMeetMessages(com.contusfly.adapters.holders.MeetSentViewHolder meetSentViewHolder, com.mirrorflysdk.api.models.ChatMessage item) {
    }
    
    /**
     * Sets the listener to the child views present in the parent view.
     *
     * @param txtReceiverViewHolder The view holding the child items.
     * @param item                  The data set used to render the content of child views.
     */
    private final void setListenersForReceiverTextMessages(com.contusfly.adapters.holders.TextReceivedViewHolder txtReceiverViewHolder, com.mirrorflysdk.api.models.ChatMessage item) {
    }
    
    private final void setListenersForReceiverMeetMessages(com.contusfly.adapters.holders.MeetReceivedViewHolder meetReceivedViewHolder, com.mirrorflysdk.api.models.ChatMessage item) {
    }
    
    /**
     * Sets the listener to the child views present in the parent view.
     *
     * @param imgViewHolder The view holding the child items.
     * @param item          The data set used to render the content of child views.
     */
    private final void setListenersForSenderImageMessages(com.contusfly.adapters.holders.ImageSentViewHolder imgViewHolder, com.mirrorflysdk.api.models.ChatMessage item) {
    }
    
    /**
     * Sets the listener to the child views present in the parent view.
     *
     * @param imgViewHolder The view holding the child items.
     * @param item          The data set used to render the content of child views.
     */
    private final void setListenersForReceiverImageMessages(com.contusfly.adapters.holders.ImageReceivedViewHolder imgViewHolder, com.mirrorflysdk.api.models.ChatMessage item) {
    }
    
    /**
     * Sets the listener to the child views present in the parent view.
     *
     * @param videoSenderViewHolder The view holding the child items.
     * @param item                  The data set used to render the content of child views.
     */
    private final void setListenersForSenderVideoMessages(com.contusfly.adapters.holders.VideoSentViewHolder videoSenderViewHolder, com.mirrorflysdk.api.models.ChatMessage item) {
    }
    
    /**
     * Sets the listener to the child views present in the parent view.
     *
     * @param videoReceiverViewHolder The view holding the child items.
     * @param item                    The data set used to render the content of child views.
     */
    private final void setListenersForReceiverVideoMessages(com.contusfly.adapters.holders.VideoReceivedViewHolder videoReceiverViewHolder, com.mirrorflysdk.api.models.ChatMessage item) {
    }
    
    /**
     * Register a callback to be invoked when this view is clicked. If this view is not
     * clickable, it becomes clickable.
     *
     * @param holder    View holder of current view in adapter
     * @param senderItem  The view which renders the contents of the item.
     * @param messageItem The message object which possess the data rendered in the ViewHolder.
     */
    private final void senderItemClick(androidx.recyclerview.widget.RecyclerView.ViewHolder holder, android.view.View senderItem, com.mirrorflysdk.api.models.ChatMessage messageItem) {
    }
    
    /**
     * Register a callback to be invoked when this view is clicked. If this view is not
     * clickable, it becomes clickable.
     *
     * @param holder    View holder of current view in adapter
     * @param receiverItem The view which renders the contents of the item.
     * @param messageItem  The message object which possess the data rendered in the ViewHolder.
     */
    private final void receiverItemClick(androidx.recyclerview.widget.RecyclerView.ViewHolder holder, android.view.View receiverItem, com.mirrorflysdk.api.models.ChatMessage messageItem) {
    }
    
    /**
     * Register a callback to be invoked when this view is clicked. If this view is not clickable,
     * it becomes clickable.
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
     * Register a callback to be invoked when this view is clicked. If this view is not
     * clickable, it becomes clickable.
     *
     * @param download       The download view placed in the ViewHolder.
     * @param retry          The retry view placed in the ViewHolder.
     * @param cancelDownload The cancel download view placed in the ViewHolder.
     * @param messageItem    The message object which possess the data rendered in the ViewHolder.
     */
    private final void receiverDownloadClick(android.view.View download, android.view.View retry, android.view.View cancelDownload, com.mirrorflysdk.api.models.ChatMessage messageItem) {
    }
    
    /**
     * Sets the listener to the child views present in the parent view.
     *
     * @param locationHolder The view holding the child items.
     * @param item           The data set used to render the content of child views.
     */
    private final void setListenersForSenderLocationMessages(com.contusfly.adapters.holders.LocationSentViewHolder locationHolder, com.mirrorflysdk.api.models.ChatMessage item) {
    }
    
    /**
     * Sets the listener to the child views present in the parent view.
     *
     * @param locationHolder The view holding the child items.
     * @param item           The data set used to render the content of child views.
     */
    private final void setListenersForReceiverLocationMessages(com.contusfly.adapters.holders.LocationReceivedViewHolder locationHolder, com.mirrorflysdk.api.models.ChatMessage item) {
    }
    
    /**
     * Handle the audio play click
     *
     * @param item            Message Item data
     * @param holder          View holder of current view in adapter
     * @param playImage       Play button of the audio view
     * @param mirrorFlySeekBar         Seek bar of the audio
     * @param durationView    Duration text view
     * @param doesSentMessage Boolean to identify whether the audio message is posted in the
     * chat activity.
     */
    private final void audioPlayClick(com.mirrorflysdk.api.models.ChatMessage item, androidx.recyclerview.widget.RecyclerView.ViewHolder holder, android.widget.ImageView playImage, com.contusfly.views.MirrorFlySeekBar mirrorFlySeekBar, android.widget.TextView durationView, boolean doesSentMessage) {
    }
    
    /**
     * Handle the audio seekbar click
     *
     * @param item            Message Item data
     * @param holder          View holder of current view in adapter
     * @param playImage       Play button of the audio view
     * @param mirrorFlySeekBar         Seek bar of the audio
     * @param durationView duration view text view
     * chat activity.
     */
    private final void setAudioSeekBarListener(com.mirrorflysdk.api.models.ChatMessage item, androidx.recyclerview.widget.RecyclerView.ViewHolder holder, android.widget.ImageView playImage, com.contusfly.views.MirrorFlySeekBar mirrorFlySeekBar, android.widget.TextView durationView) {
    }
    
    private final void updateSeekbarChanges(androidx.recyclerview.widget.RecyclerView.ViewHolder holder, android.widget.ImageView playImage, android.widget.TextView durationView, int progress, boolean fromUser, com.contusfly.views.MirrorFlySeekBar mirrorFlySeekBar, com.mirrorflysdk.api.models.ChatMessage item) {
    }
    
    /**
     * Sets the listener to the child views present in the parent view.
     *
     * @param audioViewHolder The view holding the child items.
     * @param item            The data set used to render the content of child views.
     */
    private final void setListenersForAudioMessages(com.contusfly.adapters.holders.AudioSentViewHolder audioViewHolder, com.mirrorflysdk.api.models.ChatMessage item) {
    }
    
    /**
     * Sets the listener to the child views present in the parent view.
     *
     * @param audioReceiverViewHolder The view holding the child items.
     * @param item                    The data set used to render the content of child views.
     */
    private final void setListenersForReceiverAudioMessages(com.contusfly.adapters.holders.AudioReceivedViewHolder audioReceiverViewHolder, com.mirrorflysdk.api.models.ChatMessage item) {
    }
    
    /**
     * Sets the listener to the child views present in the parent view.
     *
     * @param fileViewHolder The view holding the child items.
     * @param item           The data set used to render the content of child views.
     */
    private final void setListenersForSentFileMessages(com.contusfly.adapters.holders.FileSentViewHolder fileViewHolder, com.mirrorflysdk.api.models.ChatMessage item) {
    }
    
    /**
     * Sets the listener to the child views present in the parent view.
     *
     * @param fileViewHolder The view holding the child items.
     * @param item           The data set used to render the content of child views.
     */
    private final void setListenersForReceivedFileMessages(com.contusfly.adapters.holders.FileReceivedViewHolder fileViewHolder, com.mirrorflysdk.api.models.ChatMessage item) {
    }
    
    /**
     * when user click reply view this method get called
     *
     * @param item     Message object
     * @param position of the item clicked
     */
    private final void onReplyViewClicked(com.mirrorflysdk.api.models.ChatMessage item, int position) {
    }
    
    /**
     * Sets the listener to the child views present in the parent view.
     *
     * @param contactHolder  The view holding the child items.
     * @param item           The data set used to render the content of child views.
     * @param registeredJid  The jid of the shared contact to open the particular chat window
     */
    private final void setListenersForContactMessages(com.contusfly.adapters.holders.ContactSentViewHolder contactHolder, com.mirrorflysdk.api.models.ChatMessage item, java.lang.String registeredJid) {
    }
    
    /**
     * Sets the listener to the child views present in the parent view.
     *
     * @param contactHolder The view holding the child items.
     * @param item          The data set used to render the content of child views.
     * @param registeredJid  Register jid of the received contact
     * if the message button is clicked.
     */
    private final void setListenersForReceivedContactMessages(com.contusfly.adapters.holders.ContactReceivedViewHolder contactHolder, com.mirrorflysdk.api.models.ChatMessage item, java.lang.String registeredJid) {
    }
    
    /**
     * Gets the group notification view
     *
     * @param holder        View holder of the item
     * @param message       Instance of Message
     */
    private final void getNotificationView(androidx.recyclerview.widget.RecyclerView.ViewHolder holder, com.mirrorflysdk.api.models.ChatMessage message) {
    }
    
    /**
     * Hides the media upload/download option.
     *
     * @param txtRetry Text view to display the retry
     * @param download The download view of the media
     */
    private final void hideMediaOption(android.widget.TextView txtRetry, android.view.View download) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.mirrorflysdk.api.models.ChatMessage> getMessages() {
        return null;
    }
    
    /**
     * Stop the player of the Media player.
     */
    public final void stopMediaPlayer() {
    }
    
    /**
     * Stop the player of the Media player.
     */
    public final void pauseMediaPlayer() {
    }
    
    public final void refreshMessageAtPosition(int position, @org.jetbrains.annotations.NotNull
    com.mirrorflysdk.api.models.ChatMessage message) {
    }
    
    private final int validateMessagePosition(int position, com.mirrorflysdk.api.models.ChatMessage message, boolean findAgain) {
        return 0;
    }
    
    public final void refreshMessage(int position, @org.jetbrains.annotations.NotNull
    com.mirrorflysdk.api.models.ChatMessage message) {
    }
    
    public final int validateAndRefreshMessagePosition(int position, @org.jetbrains.annotations.NotNull
    java.lang.String messageId, boolean findAgain) {
        return 0;
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
    public void setStaredStatus(boolean isStarred, @org.jetbrains.annotations.NotNull
    android.widget.ImageView imageView) {
    }
    
    @java.lang.Override
    public void setStarredCaptionStatus(boolean isStarred, @org.jetbrains.annotations.NotNull
    android.widget.ImageView imageView) {
    }
    
    /**
     * Sets the media status related to the media messages.
     *
     * @param mediaStatus        Media status of the message
     */
    @java.lang.Override
    public void setMediaStatus(@org.jetbrains.annotations.NotNull
    com.contusfly.models.MediaStatus mediaStatus) {
    }
    
    @java.lang.Override
    public void setMediaCaption(@org.jetbrains.annotations.NotNull
    com.contusfly.models.MediaCaption mediStatus) {
    }
    
    /**
     * Set the media duration for downloaded/uploaded video/audio file
     *
     * @param txtSendDuration Duration of an audio/video file
     * @param fileStatus      Status of file
     * @param messageItem     Details of the message
     * @param imgChatType     Chat type image for video
     */
    @java.lang.Override
    public void setMediaDuration(@org.jetbrains.annotations.Nullable
    android.widget.TextView txtSendDuration, int fileStatus, @org.jetbrains.annotations.Nullable
    com.mirrorflysdk.api.models.ChatMessage messageItem, @org.jetbrains.annotations.Nullable
    android.widget.ImageView imgChatType) {
    }
    
    /**
     * setImageViewSize Set the image view size KB or MB in size
     *
     * @param fileSize     File size
     * @param downloadView View of download item
     * @param fileSizeView Text view to show file size
     */
    @java.lang.Override
    public void setImageViewSize(@org.jetbrains.annotations.Nullable
    java.lang.String fileSize, @org.jetbrains.annotations.Nullable
    android.view.View downloadView, @org.jetbrains.annotations.Nullable
    android.widget.TextView fileSizeView) {
    }
    
    /**
     * Sets the status of the particular message item.
     *
     * @param item          Message item contains message data
     * @param imgChatStatus Image view status
     */
    @java.lang.Override
    public void setStatus(@org.jetbrains.annotations.Nullable
    com.mirrorflysdk.api.models.ChatMessage item, @org.jetbrains.annotations.Nullable
    android.widget.ImageView imgChatStatus) {
    }
    
    private final int getMessagePosition(java.lang.String messageId) {
        return 0;
    }
    
    private final int getMessageAudioPosition(java.lang.String messageId) {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.contusfly.chat.MediaController getMediaController() {
        return null;
    }
    
    @java.lang.Override
    public void currentlyPlayItem(int position, int progress, @org.jetbrains.annotations.NotNull
    java.lang.String playduration) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0011\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/contusfly/adapters/ChatAdapter$Companion;", "", "()V", "TYPE_AUDIO_RECEIVER", "", "TYPE_AUDIO_SENDER", "TYPE_CONTACT_RECEIVER", "TYPE_CONTACT_SENDER", "TYPE_FILE_RECEIVER", "TYPE_FILE_SENDER", "TYPE_IMAGE_RECEIVER", "TYPE_IMAGE_SENDER", "TYPE_LOCATION_RECEIVER", "TYPE_LOCATION_SENDER", "TYPE_MEET_RECEIVER", "TYPE_MEET_SENDER", "TYPE_MSG_NOTIFICATION", "TYPE_TEXT_RECEIVER", "TYPE_TEXT_SENDER", "TYPE_VIDEO_RECEIVER", "TYPE_VIDEO_SENDER", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}