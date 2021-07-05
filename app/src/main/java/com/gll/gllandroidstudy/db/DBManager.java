package com.gll.gllandroidstudy.db;


import com.gll.gllandroidstudy.ClassModelDao;
import com.gll.gllandroidstudy.DaoMaster;
import com.gll.gllandroidstudy.DaoSession;
import com.gll.gllandroidstudy.GoodMessageDao;
import com.gll.gllandroidstudy.SchoolModelDao;
import com.gll.gllandroidstudy.StudentModelDao;
import com.gll.gllandroidstudy.base.BaseApplication;

public class DBManager {

    private static final String DB_NAME = "Android_GLL.db";
    private static DBManager instance;
    private static DaoMaster daoMaster;
    private static DaoSession daoSession;

    public static void initDao() {
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(BaseApplication.getInstance(), DB_NAME, null);
        daoMaster = new DaoMaster(devOpenHelper.getWritableDatabase()); //可写数据库
        daoSession = daoMaster.newSession();
    }

    public static DBManager getInstance() {
        if (instance == null) {
            synchronized (DBManager.class) {
                if (instance == null) {
                    instance = new DBManager();
                }
            }
        }
        return instance;
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }

    public GoodMessageDao getGoodMessageDao() {
        return getDaoSession().getGoodMessageDao();
    }

    public SchoolModelDao getSchoolModelDao() {
        return getDaoSession().getSchoolModelDao();
    }

    public ClassModelDao getClassModelDao() {
        return getDaoSession().getClassModelDao();
    }

    public StudentModelDao getStudentModelDao() {
        return getDaoSession().getStudentModelDao();
    }
}
