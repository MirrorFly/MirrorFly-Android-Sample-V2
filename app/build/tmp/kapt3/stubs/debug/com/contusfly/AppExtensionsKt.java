package com.contusfly;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 2, d1 = {"\u0000\u0088\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b3\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0006\u0010\t\u001a\u00020\u0001\u001a\u0006\u0010\n\u001a\u00020\u0001\u001a\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u00012\u0006\u0010\f\u001a\u00020\r\u001a\u0010\u0010\u000e\u001a\u00020\u00012\b\b\u0001\u0010\u000f\u001a\u00020\u0010\u001a\u0011\u0010\u0011\u001a\u00020\u0012H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0013\u001a\u001f\u0010\u0014\u001a\u00020\u00152\u0012\u0010\u0016\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00180\u0017\"\u00020\u0018\u00a2\u0006\u0002\u0010\u0019\u001a\u001f\u0010\u001a\u001a\u00020\u00152\u0012\u0010\u001b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u001c0\u0017\"\u00020\u001c\u00a2\u0006\u0002\u0010\u001d\u001aM\u0010\u001e\u001a\u00020\u0015\"\b\b\u0000\u0010\u0006*\u00020\u00022\u0016\u0010\u001f\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u0001H\u00060\u0017\"\u0004\u0018\u0001H\u00062\u0018\u0010 \u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00060\"\u0012\u0004\u0012\u00020\u00150!H\u0086\b\u00f8\u0001\u0001\u00a2\u0006\u0002\u0010#\u001a\u0006\u0010$\u001a\u00020\u0012\u001a\u000e\u0010%\u001a\u00020\u00122\u0006\u0010&\u001a\u00020\'\u001a\u0006\u0010(\u001a\u00020\u0012\u001a\u001f\u0010)\u001a\u00020\u00152\u0012\u0010\u001b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u001c0\u0017\"\u00020\u001c\u00a2\u0006\u0002\u0010\u001d\u001a\u001d\u0010*\u001a\u00020+\"\n\b\u0000\u0010\u0006\u0018\u0001*\u00020\u00022\u0006\u0010&\u001a\u00020\'H\u0086\b\u001a\u000e\u0010,\u001a\u00020\u00122\u0006\u0010-\u001a\u00020\u0001\u001a\"\u0010.\u001a\b\u0012\u0004\u0012\u0002H\u00060\"\"\u0004\b\u0000\u0010\u00062\u000e\u0010/\u001a\n\u0012\u0004\u0012\u0002H\u0006\u0018\u00010\"\u001a\u0014\u00100\u001a\u00020\u00152\f\u00101\u001a\b\u0012\u0004\u0012\u00020\u001502\u001a\u000e\u00100\u001a\u00020\u00152\u0006\u00101\u001a\u000203\u001a\u0016\u00104\u001a\u00020\u00152\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u00020\u0001\u001a\u001f\u00108\u001a\u00020\u00152\u0012\u0010\u0016\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00180\u0017\"\u00020\u0018\u00a2\u0006\u0002\u0010\u0019\u001a\u001f\u00109\u001a\u00020\u00152\u0012\u0010\u001b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u001c0\u0017\"\u00020\u001c\u00a2\u0006\u0002\u0010\u001d\u001a\u001c\u0010:\u001a\b\u0012\u0004\u0012\u00020;0\"2\u000e\u0010<\u001a\n\u0012\u0004\u0012\u00020;\u0018\u00010\"\u001a\u0012\u00101\u001a\u00020\u0015*\u00020\u00182\u0006\u0010=\u001a\u00020\u0010\u001a.\u0010>\u001a\u00020\u0015*\u001e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020?j\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0002`@2\u0006\u0010A\u001a\u00020\u0002\u001a.\u0010B\u001a\u00020\u0015*\u001e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020?j\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0002`@2\u0006\u0010C\u001a\u00020\u0010\u001a.\u0010D\u001a\u00020\u0015*\u001e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020?j\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0002`@2\u0006\u0010E\u001a\u00020\u0001\u001a:\u0010F\u001a\u00020\u0015*\u001e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020?j\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0002`@2\u0006\u0010A\u001a\u00020\u00022\n\b\u0002\u0010G\u001a\u0004\u0018\u00010\u0001\u001a\u0014\u0010H\u001a\u00020\u0015*\u00020I2\b\b\u0001\u0010J\u001a\u00020\u0010\u001a\u0014\u0010K\u001a\u00020\u0015*\u00020I2\b\b\u0001\u0010J\u001a\u00020\u0010\u001a\u0014\u0010L\u001a\u00020\u0015*\u00020I2\b\b\u0001\u0010J\u001a\u00020\u0010\u001a\u0014\u0010M\u001a\u00020\u0015*\u00020I2\b\b\u0001\u0010J\u001a\u00020\u0010\u001a$\u0010N\u001a\b\u0012\u0004\u0012\u0002HP0O\"\b\b\u0000\u0010P*\u00020\u001c*\u00020Q2\b\b\u0001\u0010R\u001a\u00020\u0010\u001a\u0012\u0010S\u001a\u00020\u0001*\u00020T2\u0006\u0010&\u001a\u00020\'\u001a\u0012\u0010S\u001a\u00020\u0001*\u00020U2\u0006\u0010&\u001a\u00020\'\u001a\u0012\u0010V\u001a\u00020\u0010*\u00020\u00012\u0006\u0010W\u001a\u00020\u0001\u001a(\u0010X\u001a\u00020\u0015*\u00020\'2\b\b\u0002\u0010Y\u001a\u00020\u00122\f\u0010Z\u001a\b\u0012\u0004\u0012\u00020\u001502H\u0086\b\u00f8\u0001\u0001\u001a\u0012\u0010J\u001a\u00020\u0010*\u00020\'2\u0006\u0010[\u001a\u00020\u0010\u001a\u0012\u0010\\\u001a\u00020I*\u00020\'2\u0006\u0010\\\u001a\u00020\u0010\u001a\u001e\u0010]\u001a\u00020\u0015*\u00020\'2\b\u0010E\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010^\u001a\u00020\u0012\u001a\u0012\u0010_\u001a\u00020\u0018*\u00020`2\u0006\u0010a\u001a\u00020\u0010\u001a\n\u0010b\u001a\u00020\u0001*\u00020\'\u001a\n\u0010c\u001a\u00020d*\u00020e\u001a\n\u0010f\u001a\u00020g*\u00020e\u001a\n\u0010f\u001a\u00020\u0001*\u00020;\u001a\n\u0010f\u001a\u00020\u0001*\u00020T\u001a\n\u0010f\u001a\u00020\u0001*\u00020h\u001a\n\u0010i\u001a\u00020g*\u00020;\u001a\n\u0010i\u001a\u00020g*\u00020h\u001a\f\u0010j\u001a\u00020\u0010*\u0004\u0018\u00010\u0001\u001a&\u0010k\u001a\u00020\u0002*\u001e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020?j\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0002`@\u001a\u0012\u0010l\u001a\u00020I*\u00020\'2\u0006\u0010m\u001a\u00020\u0001\u001a\u0014\u0010l\u001a\u00020I*\u00020n2\u0006\u0010o\u001a\u00020;H\u0007\u001a\u0014\u0010l\u001a\u00020I*\u00020n2\u0006\u0010p\u001a\u00020hH\u0007\u001a\n\u0010q\u001a\u00020d*\u00020T\u001a\n\u0010r\u001a\u00020\u0001*\u00020;\u001a&\u0010s\u001a\u00020\u0010*\u001e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020?j\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0002`@\u001a\u0012\u0010t\u001a\u00020\u0001*\u00020U2\u0006\u0010&\u001a\u00020\'\u001a&\u0010u\u001a\u00020\u0001*\u001e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020?j\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0002`@\u001a\u0014\u0010v\u001a\u00020I*\u00020n2\u0006\u0010-\u001a\u00020\u0001H\u0007\u001a\n\u0010w\u001a\u00020\u0001*\u00020e\u001a2\u0010x\u001a\u00020\u0002*\u001e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020?j\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0002`@2\n\b\u0002\u0010G\u001a\u0004\u0018\u00010\u0001\u001a\n\u0010y\u001a\u00020\u0001*\u00020T\u001a\n\u0010z\u001a\u00020\u0001*\u00020T\u001a\n\u0010z\u001a\u00020\u0001*\u00020U\u001a\n\u0010{\u001a\u00020\u0001*\u00020e\u001a\n\u0010|\u001a\u00020\u0015*\u00020\u001c\u001a\n\u0010}\u001a\u00020\u0015*\u00020\u0018\u001a\n\u0010}\u001a\u00020\u0015*\u00020\u001c\u001a\'\u0010~\u001a\u00020\u0015*\u00020\u00122\f\u0010\u007f\u001a\b\u0012\u0004\u0012\u00020\u0015022\r\u0010\u0080\u0001\u001a\b\u0012\u0004\u0012\u00020\u001502\u001a\u000b\u0010\u0081\u0001\u001a\u00020\u0012*\u00020T\u001a\u000b\u0010\u0082\u0001\u001a\u00020\u0012*\u00020;\u001a\u000b\u0010\u0082\u0001\u001a\u00020\u0012*\u00020h\u001a\u000b\u0010\u0083\u0001\u001a\u00020\u0012*\u00020T\u001a\u000b\u0010\u0084\u0001\u001a\u00020\u0012*\u00020e\u001a\u000b\u0010\u0085\u0001\u001a\u00020\u0012*\u00020T\u001a\u000b\u0010\u0086\u0001\u001a\u00020\u0012*\u00020T\u001a\u000b\u0010\u0086\u0001\u001a\u00020\u0012*\u00020U\u001a\u000b\u0010\u0087\u0001\u001a\u00020\u0012*\u00020;\u001a\u000b\u0010\u0088\u0001\u001a\u00020\u0012*\u00020T\u001a\u000b\u0010\u0089\u0001\u001a\u00020\u0012*\u00020T\u001a\u000b\u0010\u008a\u0001\u001a\u00020\u0012*\u00020T\u001a\u000b\u0010\u008b\u0001\u001a\u00020\u0012*\u00020T\u001a\u000b\u0010\u008c\u0001\u001a\u00020\u0012*\u00020T\u001a\u000b\u0010\u008d\u0001\u001a\u00020\u0012*\u00020T\u001a\u000b\u0010\u008e\u0001\u001a\u00020\u0012*\u00020T\u001a\u000b\u0010\u008f\u0001\u001a\u00020\u0012*\u00020T\u001a\u000b\u0010\u0090\u0001\u001a\u00020\u0012*\u00020\u0001\u001a\u000b\u0010\u0091\u0001\u001a\u00020\u0012*\u00020T\u001a\u0014\u0010\u0092\u0001\u001a\u00020\u0012*\u00020\'2\u0007\u0010\u0093\u0001\u001a\u00020\u0001\u001a\u0014\u0010\u0094\u0001\u001a\u00020\u0012*\u00020\'2\u0007\u0010\u0093\u0001\u001a\u00020\u0001\u001a&\u0010\u0095\u0001\u001a\u00020\u0012*\u00020\'2\u0013\u0010\u0096\u0001\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0017\"\u00020\u0001\u00a2\u0006\u0003\u0010\u0097\u0001\u001a\u000b\u0010\u0098\u0001\u001a\u00020\u0012*\u00020e\u001a\u000b\u0010\u0098\u0001\u001a\u00020\u0012*\u00020h\u001a\u000b\u0010\u0099\u0001\u001a\u00020\u0012*\u00020T\u001a\u0013\u0010\u009a\u0001\u001a\u00020\u0012*\u0004\u0018\u00010\u0012\u00a2\u0006\u0003\u0010\u009b\u0001\u001a\u000b\u0010\u009c\u0001\u001a\u00020\u0012*\u00020;\u001a\u000b\u0010\u009d\u0001\u001a\u00020\u0012*\u00020\u0010\u001a\u000b\u0010\u009e\u0001\u001a\u00020\u0012*\u00020T\u001a\u0014\u0010\u009f\u0001\u001a\u00020\u0012*\u00020\'2\u0007\u0010\u0093\u0001\u001a\u00020\u0001\u001aH\u0010\u00a0\u0001\u001a\u00020\u0015\"\n\b\u0000\u0010\u0006\u0018\u0001*\u00020\u0002*\u00020\'2\f\b\u0002\u0010\u00a1\u0001\u001a\u0005\u0018\u00010\u00a2\u00012\u001b\b\n\u0010\u00a3\u0001\u001a\u0014\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020\u00150!\u00a2\u0006\u0003\b\u00a4\u0001H\u0086\b\u00f8\u0001\u0001\u001aC\u0010\u00a5\u0001\u001a\u00020\u0015\"\n\b\u0000\u0010\u0006\u0018\u0001*\u00020\u0002*\u0002062\u0007\u0010\u00a6\u0001\u001a\u00020\u00102\u001b\b\n\u0010\u00a3\u0001\u001a\u0014\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020\u00150!\u00a2\u0006\u0003\b\u00a4\u0001H\u0086\b\u00f8\u0001\u0001\u001a\u001c\u0010\u00a7\u0001\u001a\u00020\u0015*\u00030\u00a8\u00012\u0006\u0010&\u001a\u00020\'2\u0006\u0010o\u001a\u00020;\u001a\u001d\u0010\u00a9\u0001\u001a\u00020\u0015*\u00030\u00a8\u00012\u0006\u0010&\u001a\u00020\'2\u0007\u0010\u00aa\u0001\u001a\u00020;\u001a\u001c\u0010\u00a9\u0001\u001a\u00020\u0015*\u00030\u00ab\u00012\u0006\u0010&\u001a\u00020\'2\u0006\u0010p\u001a\u00020h\u001aC\u0010\u00ac\u0001\u001a\u00020\u0015*\u00030\u00ad\u00012/\u0010\u00ae\u0001\u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0005\u0012\u00030\u00b0\u00010\u00af\u00010\u0017\"\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0005\u0012\u00030\u00b0\u00010\u00af\u0001\u00a2\u0006\u0003\u0010\u00b1\u0001\u001a(\u0010\u00b2\u0001\u001a\u00020\u0015*\u00020Q2\f\u0010\u007f\u001a\b\u0012\u0004\u0012\u00020\u0015022\r\u0010\u0080\u0001\u001a\b\u0012\u0004\u0012\u00020\u001502\u001a\r\u0010\u00b3\u0001\u001a\u00020\u0001*\u0004\u0018\u00010\u0001\u001a)\u0010\u00b4\u0001\u001a\u00020\u0015*\u00020\u001c2\u0007\u0010\u00b5\u0001\u001a\u00020\r2\u0013\u0010\u00b6\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00150!\u001a\u0014\u0010\u00b7\u0001\u001a\u00020\u0015*\u00020\u001c2\u0007\u0010\u00b8\u0001\u001a\u00020\u0012\u001a\u001e\u0010\u00b9\u0001\u001a\u00020\u0015*\u00030\u00ba\u00012\u0007\u0010\u00bb\u0001\u001a\u00020\u00102\u0007\u0010\u00bc\u0001\u001a\u00020\u0010\u001a\u001e\u0010\u00b9\u0001\u001a\u00020\u0015*\u00030\u00bd\u00012\u0007\u0010\u00bb\u0001\u001a\u00020\u00102\u0007\u0010\u00bc\u0001\u001a\u00020\u0010\u001a\u000b\u0010\u00be\u0001\u001a\u00020\u0015*\u00020\u0018\u001a\u000b\u0010\u00be\u0001\u001a\u00020\u0015*\u00020\u001c\u001a\u000b\u0010\u00bf\u0001\u001a\u00020\u0015*\u00020\u001c\u001a\u0015\u0010Y\u001a\u00020\u0015*\u00020\'2\t\u0010\u00c0\u0001\u001a\u0004\u0018\u00010\u0001\u001a\u0014\u0010\u00c1\u0001\u001a\u00020\u0012*\u00020\u00012\u0007\u0010\u00c0\u0001\u001a\u00020\u0001\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u001b\u0010\u0005\u001a\u0002H\u0006\"\u0004\b\u0000\u0010\u0006*\u0002H\u00068F\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\b\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b\u009920\u0001\u00a8\u0006\u00c2\u0001"}, d2 = {"TAG", "", "", "getTAG", "(Ljava/lang/Object;)Ljava/lang/String;", "exhaustive", "T", "getExhaustive", "(Ljava/lang/Object;)Ljava/lang/Object;", "emptyString", "emptyStringFE", "getFileSizeInStringFormat", "size", "", "getString", "id", "", "hasActiveInternet", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "hideMenu", "", "menuItems", "", "Landroid/view/MenuItem;", "([Landroid/view/MenuItem;)V", "hideViews", "views", "Landroid/view/View;", "([Landroid/view/View;)V", "ifLet", "elements", "closure", "Lkotlin/Function1;", "", "([Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "isCurrentThreadIsMainThread", "isInternetAvailable", "context", "Landroid/content/Context;", "isOnAnyCall", "makeViewsGone", "newIntent", "Landroid/content/Intent;", "profileNameCharValidation", "name", "returnEmptyListIfNull", "nullableList", "runOnUiThread", "action", "Lkotlin/Function0;", "Ljava/lang/Runnable;", "showAlertDialog", "activity", "Landroid/app/Activity;", "title", "showMenu", "showViews", "sortProfileList", "Lcom/mirrorflysdk/api/contacts/ProfileDetails;", "profilesList", "menuItemAction", "addData", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "data", "addHttpStatusCode", "httpStatusCode", "addMessage", "message", "addParams", "key", "applyDarkenColorFilter", "Landroid/graphics/drawable/Drawable;", "color", "applyMultiplyColorFilter", "applySourceColorFilter", "applySrcInColorFilter", "bindView", "Lkotlin/Lazy;", "ViewT", "Landroidx/appcompat/app/AppCompatActivity;", "idRes", "caption", "Lcom/mirrorflysdk/api/models/ChatMessage;", "Lcom/mirrorflysdk/api/models/ReplyParentChatMessage;", "checkIndexes", "searchedKey", "checkInternetAndExecute", "showToast", "function", "res", "drawable", "flyToast", "shortDuration", "get", "Landroid/view/Menu;", "menuId", "getAppName", "getChatDeleteType", "Lcom/mirrorflysdk/api/DeleteChatType;", "Lcom/contusfly/models/Chat;", "getChatType", "Lcom/mirrorflysdk/flycommons/ChatTypeEnum;", "Lcom/mirrorflysdk/api/models/RecentChat;", "getChatTypeEnum", "getColourCode", "getData", "getDefaultDrawable", "chatType", "Lcom/contusfly/views/CustomDrawable;", "profileDetails", "recentChat", "getDeleteChatType", "getDisplayName", "getHttpStatusCode", "getMediaFileName", "getMessage", "getMoreUsersDrawable", "getMyJid", "getParams", "getSenderJid", "getSenderName", "getUsername", "gone", "hide", "ifElse", "functionOne", "functionTwo", "isAudioMessage", "isDeletedContact", "isFileMessage", "isGroupChat", "isGroupMessage", "isImageMessage", "isLiveContact", "isMediaDownloaded", "isMediaMessage", "isMediaUploadOrDownload", "isMediaUploaded", "isMessageAcknowledged", "isMessageDelivered", "isMessageSeen", "isMessageSent", "isNotNumber", "isNotificationMessage", "isNotificationPermissionAllowed", "permission", "isPermissionAllowed", "isPermissionsAllowed", "permissions", "(Landroid/content/Context;[Ljava/lang/String;)Z", "isSingleChat", "isTextMessage", "isTrue", "(Ljava/lang/Boolean;)Z", "isUnknownContact", "isValidIndex", "isVideoMessage", "isWritePermissionAllowed", "launchActivity", "options", "Landroid/os/Bundle;", "init", "Lkotlin/ExtensionFunctionType;", "launchActivityForResult", "requestCode", "loadUserInfoProfileImage", "Landroid/widget/ImageView;", "loadUserProfileImage", "userProfileDetails", "Landroidx/appcompat/widget/AppCompatImageView;", "makeLinks", "Landroid/widget/TextView;", "links", "Lkotlin/Pair;", "Landroid/view/View$OnClickListener;", "(Landroid/widget/TextView;[Lkotlin/Pair;)V", "netConditionalCall", "returnEmptyIfNull", "setOnClickListener", "debounceInterval", "listenerBlock", "setVisible", "isVisible", "setWidthAndHeight", "Landroid/widget/LinearLayout;", "height", "width", "Landroid/widget/RelativeLayout;", "show", "showSoftKeyboard", "text", "startsWithTextInWords", "app_debug"})
public final class AppExtensionsKt {
    
    /**
     * @author ContusTeam <developers@contus.in>
     * @version 1.0
     */
    public static final void show(@org.jetbrains.annotations.NotNull()
    android.view.View $this$show) {
    }
    
    public static final void hide(@org.jetbrains.annotations.NotNull()
    android.view.View $this$hide) {
    }
    
    public static final void gone(@org.jetbrains.annotations.NotNull()
    android.view.View $this$gone) {
    }
    
    public static final void setWidthAndHeight(@org.jetbrains.annotations.NotNull()
    android.widget.LinearLayout $this$setWidthAndHeight, int height, int width) {
    }
    
    public static final void setWidthAndHeight(@org.jetbrains.annotations.NotNull()
    android.widget.RelativeLayout $this$setWidthAndHeight, int height, int width) {
    }
    
    public static final boolean isValidIndex(int $this$isValidIndex) {
        return false;
    }
    
    public static final boolean isTrue(@org.jetbrains.annotations.Nullable()
    java.lang.Boolean $this$isTrue) {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final <ViewT extends android.view.View>kotlin.Lazy<ViewT> bindView(@org.jetbrains.annotations.NotNull()
    androidx.appcompat.app.AppCompatActivity $this$bindView, @androidx.annotation.IdRes()
    int idRes) {
        return null;
    }
    
    public static final void checkInternetAndExecute(@org.jetbrains.annotations.NotNull()
    android.content.Context $this$checkInternetAndExecute, boolean showToast, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> function) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final android.view.MenuItem get(@org.jetbrains.annotations.NotNull()
    android.view.Menu $this$get, int menuId) {
        return null;
    }
    
    public static final void action(@org.jetbrains.annotations.NotNull()
    android.view.MenuItem $this$action, int menuItemAction) {
    }
    
    public static final void hide(@org.jetbrains.annotations.NotNull()
    android.view.MenuItem $this$hide) {
    }
    
    public static final void show(@org.jetbrains.annotations.NotNull()
    android.view.MenuItem $this$show) {
    }
    
    public static final void hideMenu(@org.jetbrains.annotations.NotNull()
    android.view.MenuItem... menuItems) {
    }
    
    public static final void showMenu(@org.jetbrains.annotations.NotNull()
    android.view.MenuItem... menuItems) {
    }
    
    public static final void showViews(@org.jetbrains.annotations.NotNull()
    android.view.View... views) {
    }
    
    public static final void hideViews(@org.jetbrains.annotations.NotNull()
    android.view.View... views) {
    }
    
    public static final void makeViewsGone(@org.jetbrains.annotations.NotNull()
    android.view.View... views) {
    }
    
    public static final void showToast(@org.jetbrains.annotations.NotNull()
    android.content.Context $this$showToast, @org.jetbrains.annotations.Nullable()
    java.lang.String text) {
    }
    
    public static final boolean isPermissionsAllowed(@org.jetbrains.annotations.NotNull()
    android.content.Context $this$isPermissionsAllowed, @org.jetbrains.annotations.NotNull()
    java.lang.String... permissions) {
        return false;
    }
    
    public static final void showSoftKeyboard(@org.jetbrains.annotations.NotNull()
    android.view.View $this$showSoftKeyboard) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final com.mirrorflysdk.api.DeleteChatType getDeleteChatType(@org.jetbrains.annotations.NotNull()
    com.mirrorflysdk.api.models.ChatMessage $this$getDeleteChatType) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String getChatType(@org.jetbrains.annotations.NotNull()
    com.mirrorflysdk.api.models.ChatMessage $this$getChatType) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String getChatType(@org.jetbrains.annotations.NotNull()
    com.mirrorflysdk.api.models.RecentChat $this$getChatType) {
        return null;
    }
    
    public static final void ifElse(boolean $this$ifElse, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> functionOne, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> functionTwo) {
    }
    
    public static final boolean isDeletedContact(@org.jetbrains.annotations.NotNull()
    com.mirrorflysdk.api.models.RecentChat $this$isDeletedContact) {
        return false;
    }
    
    public static final boolean isSingleChat(@org.jetbrains.annotations.NotNull()
    com.mirrorflysdk.api.models.RecentChat $this$isSingleChat) {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String returnEmptyIfNull(@org.jetbrains.annotations.Nullable()
    java.lang.String $this$returnEmptyIfNull) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final com.mirrorflysdk.flycommons.ChatTypeEnum getChatTypeEnum(@org.jetbrains.annotations.NotNull()
    com.mirrorflysdk.api.models.RecentChat $this$getChatTypeEnum) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final com.mirrorflysdk.flycommons.ChatTypeEnum getChatTypeEnum(@org.jetbrains.annotations.NotNull()
    com.mirrorflysdk.api.contacts.ProfileDetails $this$getChatTypeEnum) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String getTAG(@org.jetbrains.annotations.NotNull()
    java.lang.Object $this$TAG) {
        return null;
    }
    
    public static final void loadUserProfileImage(@org.jetbrains.annotations.NotNull()
    androidx.appcompat.widget.AppCompatImageView $this$loadUserProfileImage, @org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    com.mirrorflysdk.api.models.RecentChat recentChat) {
    }
    
    public static final void loadUserProfileImage(@org.jetbrains.annotations.NotNull()
    android.widget.ImageView $this$loadUserProfileImage, @org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    com.mirrorflysdk.api.contacts.ProfileDetails userProfileDetails) {
    }
    
    public static final void loadUserInfoProfileImage(@org.jetbrains.annotations.NotNull()
    android.widget.ImageView $this$loadUserInfoProfileImage, @org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    com.mirrorflysdk.api.contacts.ProfileDetails profileDetails) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @android.annotation.SuppressLint(value = {"DefaultLocale"})
    public static final android.graphics.drawable.Drawable getDefaultDrawable(@org.jetbrains.annotations.NotNull()
    com.contusfly.views.CustomDrawable $this$getDefaultDrawable, @org.jetbrains.annotations.NotNull()
    com.mirrorflysdk.api.models.RecentChat recentChat) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @android.annotation.SuppressLint(value = {"DefaultLocale"})
    public static final android.graphics.drawable.Drawable getDefaultDrawable(@org.jetbrains.annotations.NotNull()
    com.contusfly.views.CustomDrawable $this$getDefaultDrawable, @org.jetbrains.annotations.NotNull()
    com.mirrorflysdk.api.contacts.ProfileDetails profileDetails) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final android.graphics.drawable.Drawable drawable(@org.jetbrains.annotations.NotNull()
    android.content.Context $this$drawable, int drawable) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final android.graphics.drawable.Drawable getDefaultDrawable(@org.jetbrains.annotations.NotNull()
    android.content.Context $this$getDefaultDrawable, @org.jetbrains.annotations.NotNull()
    java.lang.String chatType) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String emptyString() {
        return null;
    }
    
    public static final boolean isMessageSent(@org.jetbrains.annotations.NotNull()
    com.mirrorflysdk.api.models.ChatMessage $this$isMessageSent) {
        return false;
    }
    
    public static final boolean isMessageAcknowledged(@org.jetbrains.annotations.NotNull()
    com.mirrorflysdk.api.models.ChatMessage $this$isMessageAcknowledged) {
        return false;
    }
    
    public static final boolean isMessageDelivered(@org.jetbrains.annotations.NotNull()
    com.mirrorflysdk.api.models.ChatMessage $this$isMessageDelivered) {
        return false;
    }
    
    public static final boolean isMessageSeen(@org.jetbrains.annotations.NotNull()
    com.mirrorflysdk.api.models.ChatMessage $this$isMessageSeen) {
        return false;
    }
    
    public static final boolean isGroupMessage(@org.jetbrains.annotations.NotNull()
    com.mirrorflysdk.api.models.ChatMessage $this$isGroupMessage) {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String getSenderJid(@org.jetbrains.annotations.NotNull()
    com.mirrorflysdk.api.models.ChatMessage $this$getSenderJid) {
        return null;
    }
    
    public static final boolean isTextMessage(@org.jetbrains.annotations.NotNull()
    com.mirrorflysdk.api.models.ChatMessage $this$isTextMessage) {
        return false;
    }
    
    public static final boolean isAudioMessage(@org.jetbrains.annotations.NotNull()
    com.mirrorflysdk.api.models.ChatMessage $this$isAudioMessage) {
        return false;
    }
    
    public static final boolean isImageMessage(@org.jetbrains.annotations.NotNull()
    com.mirrorflysdk.api.models.ChatMessage $this$isImageMessage) {
        return false;
    }
    
    public static final boolean isVideoMessage(@org.jetbrains.annotations.NotNull()
    com.mirrorflysdk.api.models.ChatMessage $this$isVideoMessage) {
        return false;
    }
    
    public static final boolean isFileMessage(@org.jetbrains.annotations.NotNull()
    com.mirrorflysdk.api.models.ChatMessage $this$isFileMessage) {
        return false;
    }
    
    public static final boolean isNotificationMessage(@org.jetbrains.annotations.NotNull()
    com.mirrorflysdk.api.models.ChatMessage $this$isNotificationMessage) {
        return false;
    }
    
    public static final boolean isMediaMessage(@org.jetbrains.annotations.NotNull()
    com.mirrorflysdk.api.models.ChatMessage $this$isMediaMessage) {
        return false;
    }
    
    public static final boolean isMediaUploaded(@org.jetbrains.annotations.NotNull()
    com.mirrorflysdk.api.models.ChatMessage $this$isMediaUploaded) {
        return false;
    }
    
    public static final boolean isMediaDownloaded(@org.jetbrains.annotations.NotNull()
    com.mirrorflysdk.api.models.ChatMessage $this$isMediaDownloaded) {
        return false;
    }
    
    public static final boolean isMediaUploadOrDownload(@org.jetbrains.annotations.NotNull()
    com.mirrorflysdk.api.models.ChatMessage $this$isMediaUploadOrDownload) {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String getSenderName(@org.jetbrains.annotations.NotNull()
    com.mirrorflysdk.api.models.ChatMessage $this$getSenderName) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String getMyJid(@org.jetbrains.annotations.NotNull()
    com.contusfly.models.Chat $this$getMyJid) {
        return null;
    }
    
    public static final boolean isSingleChat(@org.jetbrains.annotations.NotNull()
    com.contusfly.models.Chat $this$isSingleChat) {
        return false;
    }
    
    public static final boolean isGroupChat(@org.jetbrains.annotations.NotNull()
    com.contusfly.models.Chat $this$isGroupChat) {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final com.mirrorflysdk.flycommons.ChatTypeEnum getChatType(@org.jetbrains.annotations.NotNull()
    com.contusfly.models.Chat $this$getChatType) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final com.mirrorflysdk.api.DeleteChatType getChatDeleteType(@org.jetbrains.annotations.NotNull()
    com.contusfly.models.Chat $this$getChatDeleteType) {
        return null;
    }
    
    public static final void netConditionalCall(@org.jetbrains.annotations.NotNull()
    androidx.appcompat.app.AppCompatActivity $this$netConditionalCall, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> functionOne, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> functionTwo) {
    }
    
    public static final int getColourCode(@org.jetbrains.annotations.Nullable()
    java.lang.String $this$getColourCode) {
        return 0;
    }
    
    public static final boolean startsWithTextInWords(@org.jetbrains.annotations.NotNull()
    java.lang.String $this$startsWithTextInWords, @org.jetbrains.annotations.NotNull()
    java.lang.String text) {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String getAppName(@org.jetbrains.annotations.NotNull()
    android.content.Context $this$getAppName) {
        return null;
    }
    
    public static final int checkIndexes(@org.jetbrains.annotations.NotNull()
    java.lang.String $this$checkIndexes, @org.jetbrains.annotations.NotNull()
    java.lang.String searchedKey) {
        return 0;
    }
    
    public static final int color(@org.jetbrains.annotations.NotNull()
    android.content.Context $this$color, int res) {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String caption(@org.jetbrains.annotations.NotNull()
    com.mirrorflysdk.api.models.ChatMessage $this$caption, @org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String caption(@org.jetbrains.annotations.NotNull()
    com.mirrorflysdk.api.models.ReplyParentChatMessage $this$caption, @org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String getMediaFileName(@org.jetbrains.annotations.NotNull()
    com.mirrorflysdk.api.models.ReplyParentChatMessage $this$getMediaFileName, @org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return null;
    }
    
    public static final boolean isImageMessage(@org.jetbrains.annotations.NotNull()
    com.mirrorflysdk.api.models.ReplyParentChatMessage $this$isImageMessage) {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String getSenderName(@org.jetbrains.annotations.NotNull()
    com.mirrorflysdk.api.models.ReplyParentChatMessage $this$getSenderName) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String getUsername(@org.jetbrains.annotations.NotNull()
    com.contusfly.models.Chat $this$getUsername) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String getDisplayName(@org.jetbrains.annotations.NotNull()
    com.mirrorflysdk.api.contacts.ProfileDetails $this$getDisplayName) {
        return null;
    }
    
    public static final boolean isUnknownContact(@org.jetbrains.annotations.NotNull()
    com.mirrorflysdk.api.contacts.ProfileDetails $this$isUnknownContact) {
        return false;
    }
    
    public static final boolean isDeletedContact(@org.jetbrains.annotations.NotNull()
    com.mirrorflysdk.api.contacts.ProfileDetails $this$isDeletedContact) {
        return false;
    }
    
    public static final boolean isLiveContact(@org.jetbrains.annotations.NotNull()
    com.mirrorflysdk.api.contacts.ProfileDetails $this$isLiveContact) {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String getChatType(@org.jetbrains.annotations.NotNull()
    com.mirrorflysdk.api.contacts.ProfileDetails $this$getChatType) {
        return null;
    }
    
    public static final boolean isNotNumber(@org.jetbrains.annotations.NotNull()
    java.lang.String $this$isNotNumber) {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final java.util.List<com.mirrorflysdk.api.contacts.ProfileDetails> sortProfileList(@org.jetbrains.annotations.Nullable()
    java.util.List<? extends com.mirrorflysdk.api.contacts.ProfileDetails> profilesList) {
        return null;
    }
    
    public static final void applyMultiplyColorFilter(@org.jetbrains.annotations.NotNull()
    android.graphics.drawable.Drawable $this$applyMultiplyColorFilter, @androidx.annotation.ColorInt()
    int color) {
    }
    
    public static final void applySrcInColorFilter(@org.jetbrains.annotations.NotNull()
    android.graphics.drawable.Drawable $this$applySrcInColorFilter, @androidx.annotation.ColorInt()
    int color) {
    }
    
    public static final void applyDarkenColorFilter(@org.jetbrains.annotations.NotNull()
    android.graphics.drawable.Drawable $this$applyDarkenColorFilter, @androidx.annotation.ColorInt()
    int color) {
    }
    
    public static final void applySourceColorFilter(@org.jetbrains.annotations.NotNull()
    android.graphics.drawable.Drawable $this$applySourceColorFilter, @androidx.annotation.ColorInt()
    int color) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @android.annotation.SuppressLint(value = {"DefaultLocale"})
    public static final android.graphics.drawable.Drawable getMoreUsersDrawable(@org.jetbrains.annotations.NotNull()
    com.contusfly.views.CustomDrawable $this$getMoreUsersDrawable, @org.jetbrains.annotations.NotNull()
    java.lang.String name) {
        return null;
    }
    
    public static final void showAlertDialog(@org.jetbrains.annotations.NotNull()
    android.app.Activity activity, @org.jetbrains.annotations.NotNull()
    java.lang.String title) {
    }
    
    public static final boolean isOnAnyCall() {
        return false;
    }
    
    public static final void setOnClickListener(@org.jetbrains.annotations.NotNull()
    android.view.View $this$setOnClickListener, long debounceInterval, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super android.view.View, kotlin.Unit> listenerBlock) {
    }
    
    public static final boolean profileNameCharValidation(@org.jetbrains.annotations.NotNull()
    java.lang.String name) {
        return false;
    }
    
    public static final void setVisible(@org.jetbrains.annotations.NotNull()
    android.view.View $this$setVisible, boolean isVisible) {
    }
    
    public static final void makeLinks(@org.jetbrains.annotations.NotNull()
    android.widget.TextView $this$makeLinks, @org.jetbrains.annotations.NotNull()
    kotlin.Pair<java.lang.String, ? extends android.view.View.OnClickListener>... links) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public static final java.lang.Object hasActiveInternet(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public static final java.lang.String getFileSizeInStringFormat(long size) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String emptyStringFE() {
        return null;
    }
    
    public static final void flyToast(@org.jetbrains.annotations.NotNull()
    android.content.Context $this$flyToast, @org.jetbrains.annotations.Nullable()
    java.lang.String message, boolean shortDuration) {
    }
    
    /**
     * Checks if is net connected.
     *
     * @param context The instance of context
     * @return boolean True if is net connected
     */
    public static final boolean isInternetAvailable(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return false;
    }
    
    public static final void addMessage(@org.jetbrains.annotations.NotNull()
    java.util.HashMap<java.lang.String, java.lang.Object> $this$addMessage, @org.jetbrains.annotations.NotNull()
    java.lang.String message) {
    }
    
    public static final void addData(@org.jetbrains.annotations.NotNull()
    java.util.HashMap<java.lang.String, java.lang.Object> $this$addData, @org.jetbrains.annotations.NotNull()
    java.lang.Object data) {
    }
    
    public static final void addParams(@org.jetbrains.annotations.NotNull()
    java.util.HashMap<java.lang.String, java.lang.Object> $this$addParams, @org.jetbrains.annotations.NotNull()
    java.lang.Object data, @org.jetbrains.annotations.Nullable()
    java.lang.String key) {
    }
    
    public static final void addHttpStatusCode(@org.jetbrains.annotations.NotNull()
    java.util.HashMap<java.lang.String, java.lang.Object> $this$addHttpStatusCode, int httpStatusCode) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String getMessage(@org.jetbrains.annotations.NotNull()
    java.util.HashMap<java.lang.String, java.lang.Object> $this$getMessage) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.Object getData(@org.jetbrains.annotations.NotNull()
    java.util.HashMap<java.lang.String, java.lang.Object> $this$getData) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.Object getParams(@org.jetbrains.annotations.NotNull()
    java.util.HashMap<java.lang.String, java.lang.Object> $this$getParams, @org.jetbrains.annotations.Nullable()
    java.lang.String key) {
        return null;
    }
    
    public static final int getHttpStatusCode(@org.jetbrains.annotations.NotNull()
    java.util.HashMap<java.lang.String, java.lang.Object> $this$getHttpStatusCode) {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final <T extends java.lang.Object>java.util.List<T> returnEmptyListIfNull(@org.jetbrains.annotations.Nullable()
    java.util.List<? extends T> nullableList) {
        return null;
    }
    
    public static final boolean isCurrentThreadIsMainThread() {
        return false;
    }
    
    public static final <T extends java.lang.Object>T getExhaustive(T $this$exhaustive) {
        return null;
    }
    
    public static final <T extends java.lang.Object>void ifLet(@org.jetbrains.annotations.NotNull()
    T[] elements, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.util.List<? extends T>, kotlin.Unit> closure) {
    }
    
    /**
     * Extension method to run block of code on UI Thread.
     */
    public static final void runOnUiThread(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> action) {
    }
    
    /**
     * Extension method to run block of code on UI Thread.
     */
    public static final void runOnUiThread(@org.jetbrains.annotations.NotNull()
    java.lang.Runnable action) {
    }
    
    /**
     * Helper method to get string from xml
     *
     * @param id string resource id
     * @return
     */
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String getString(@androidx.annotation.StringRes()
    int id) {
        return null;
    }
    
    /**
     * Helper method to check permission granted or not
     *
     * @param permission permission to check
     * @return true, if permission is granted else false
     */
    public static final boolean isPermissionAllowed(@org.jetbrains.annotations.NotNull()
    android.content.Context $this$isPermissionAllowed, @org.jetbrains.annotations.NotNull()
    java.lang.String permission) {
        return false;
    }
    
    /**
     * Helper method to check write permission granted or not
     *
     * @param permission permission to check
     * @return true, if permission is granted else false
     */
    public static final boolean isWritePermissionAllowed(@org.jetbrains.annotations.NotNull()
    android.content.Context $this$isWritePermissionAllowed, @org.jetbrains.annotations.NotNull()
    java.lang.String permission) {
        return false;
    }
    
    public static final boolean isNotificationPermissionAllowed(@org.jetbrains.annotations.NotNull()
    android.content.Context $this$isNotificationPermissionAllowed, @org.jetbrains.annotations.NotNull()
    java.lang.String permission) {
        return false;
    }
}