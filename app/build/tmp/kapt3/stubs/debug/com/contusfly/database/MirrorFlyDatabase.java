package com.contusfly.database;

import java.lang.System;

@androidx.room.Database(entities = {com.contusfly.database.model.ContusContact.class}, version = 2, exportSchema = false)
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\'\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&\u00a8\u0006\u0006"}, d2 = {"Lcom/contusfly/database/MirrorFlyDatabase;", "Landroidx/room/RoomDatabase;", "()V", "contusContactDao", "Lcom/contusfly/database/dao/ContusContactDao;", "Companion", "app_debug"})
public abstract class MirrorFlyDatabase extends androidx.room.RoomDatabase {
    @org.jetbrains.annotations.NotNull
    public static final com.contusfly.database.MirrorFlyDatabase.Companion Companion = null;
    
    /**
     * This is just for singleton pattern
     */
    private static com.contusfly.database.MirrorFlyDatabase INSTANCE;
    private static final androidx.room.migration.Migration MIGRATION_1_2 = null;
    
    public MirrorFlyDatabase() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public abstract com.contusfly.database.dao.ContusContactDao contusContactDao();
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\u0004J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/contusfly/database/MirrorFlyDatabase$Companion;", "", "()V", "INSTANCE", "Lcom/contusfly/database/MirrorFlyDatabase;", "MIGRATION_1_2", "Landroidx/room/migration/Migration;", "getInstance", "initDatabase", "context", "Landroid/content/Context;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.contusfly.database.MirrorFlyDatabase initDatabase(@org.jetbrains.annotations.NotNull
        android.content.Context context) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.contusfly.database.MirrorFlyDatabase getInstance() {
            return null;
        }
    }
}