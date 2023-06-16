package com.contusfly.database;

import java.lang.System;

@androidx.room.Database(entities = {com.contusfly.database.model.ContactModel.class}, version = 1, exportSchema = false)
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\'\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&\u00a8\u0006\u0006"}, d2 = {"Lcom/contusfly/database/UIKitDatabase;", "Landroidx/room/RoomDatabase;", "()V", "contactDao", "Lcom/contusfly/database/dao/ContactDao;", "Companion", "app_debug"})
public abstract class UIKitDatabase extends androidx.room.RoomDatabase {
    @org.jetbrains.annotations.NotNull()
    public static final com.contusfly.database.UIKitDatabase.Companion Companion = null;
    
    /**
     * This is just for singleton pattern
     */
    private static com.contusfly.database.UIKitDatabase INSTANCE;
    
    public UIKitDatabase() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.contusfly.database.dao.ContactDao contactDao();
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/contusfly/database/UIKitDatabase$Companion;", "", "()V", "INSTANCE", "Lcom/contusfly/database/UIKitDatabase;", "getInstance", "initDatabase", "context", "Landroid/content/Context;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.contusfly.database.UIKitDatabase initDatabase(@org.jetbrains.annotations.NotNull()
        android.content.Context context) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.contusfly.database.UIKitDatabase getInstance() {
            return null;
        }
    }
}