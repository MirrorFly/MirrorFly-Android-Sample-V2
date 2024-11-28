package com.contusfly.database;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.RoomOpenHelper.ValidationResult;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import com.contusfly.database.dao.ContusContactDao;
import com.contusfly.database.dao.ContusContactDao_Impl;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class MirrorFlyDatabase_Impl extends MirrorFlyDatabase {
  private volatile ContusContactDao _contusContactDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(2) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `ContusContact` (`jid` TEXT NOT NULL, `name` TEXT, `image` TEXT, `mobileNumber` TEXT, `status` TEXT, `email` TEXT, `isMuted` INTEGER, `isBlocked` INTEGER, `isBlockedMe` INTEGER, `isAdminBlocked` INTEGER, PRIMARY KEY(`jid`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'e62decc3fb302b7526d04dfc6c06aa2d')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `ContusContact`");
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onDestructiveMigration(_db);
          }
        }
      }

      @Override
      public void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      public void onPreMigrate(SupportSQLiteDatabase _db) {
        DBUtil.dropFtsSyncTriggers(_db);
      }

      @Override
      public void onPostMigrate(SupportSQLiteDatabase _db) {
      }

      @Override
      public RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsContusContact = new HashMap<String, TableInfo.Column>(10);
        _columnsContusContact.put("jid", new TableInfo.Column("jid", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsContusContact.put("name", new TableInfo.Column("name", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsContusContact.put("image", new TableInfo.Column("image", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsContusContact.put("mobileNumber", new TableInfo.Column("mobileNumber", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsContusContact.put("status", new TableInfo.Column("status", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsContusContact.put("email", new TableInfo.Column("email", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsContusContact.put("isMuted", new TableInfo.Column("isMuted", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsContusContact.put("isBlocked", new TableInfo.Column("isBlocked", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsContusContact.put("isBlockedMe", new TableInfo.Column("isBlockedMe", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsContusContact.put("isAdminBlocked", new TableInfo.Column("isAdminBlocked", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysContusContact = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesContusContact = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoContusContact = new TableInfo("ContusContact", _columnsContusContact, _foreignKeysContusContact, _indicesContusContact);
        final TableInfo _existingContusContact = TableInfo.read(_db, "ContusContact");
        if (! _infoContusContact.equals(_existingContusContact)) {
          return new RoomOpenHelper.ValidationResult(false, "ContusContact(com.contusfly.database.model.ContusContact).\n"
                  + " Expected:\n" + _infoContusContact + "\n"
                  + " Found:\n" + _existingContusContact);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "e62decc3fb302b7526d04dfc6c06aa2d", "d7470d49f410e15517e084a999e8c990");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "ContusContact");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `ContusContact`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(ContusContactDao.class, ContusContactDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  public List<Migration> getAutoMigrations(
      @NonNull Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecsMap) {
    return Arrays.asList();
  }

  @Override
  public ContusContactDao contusContactDao() {
    if (_contusContactDao != null) {
      return _contusContactDao;
    } else {
      synchronized(this) {
        if(_contusContactDao == null) {
          _contusContactDao = new ContusContactDao_Impl(this);
        }
        return _contusContactDao;
      }
    }
  }
}
