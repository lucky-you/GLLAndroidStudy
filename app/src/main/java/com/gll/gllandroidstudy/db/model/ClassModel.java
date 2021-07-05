package com.gll.gllandroidstudy.db.model;


import android.os.Parcel;
import android.os.Parcelable;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.ToMany;

import java.util.List;

import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;

import com.gll.gllandroidstudy.DaoSession;
import com.gll.gllandroidstudy.StudentModelDao;
import com.gll.gllandroidstudy.ClassModelDao;

/**
 * 班级
 */
@Entity
public class ClassModel implements Parcelable {
    @Id(autoincrement = true)
    private Long id;
    private long classId;
    private String className;
    @ToMany(referencedJoinProperty = "studentId")
    private List<StudentModel> studentList;
    /**
     * Used to resolve relations
     */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;
    /**
     * Used for active entity operations.
     */
    @Generated(hash = 953521382)
    private transient ClassModelDao myDao;

    @Generated(hash = 227031575)
    public ClassModel(Long id, long classId, String className) {
        this.id = id;
        this.classId = classId;
        this.className = className;
    }

    @Generated(hash = 2146849485)
    public ClassModel() {
    }

    protected ClassModel(Parcel in) {
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readLong();
        }
        classId = in.readLong();
        className = in.readString();
    }

    public static final Creator<ClassModel> CREATOR = new Creator<ClassModel>() {
        @Override
        public ClassModel createFromParcel(Parcel in) {
            return new ClassModel(in);
        }

        @Override
        public ClassModel[] newArray(int size) {
            return new ClassModel[size];
        }
    };

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getClassId() {
        return this.classId;
    }

    public void setClassId(long classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return this.className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 812470494)
    public List<StudentModel> getStudentList() {
        if (studentList == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            StudentModelDao targetDao = daoSession.getStudentModelDao();
            List<StudentModel> studentListNew = targetDao
                    ._queryClassModel_StudentList(id);
            synchronized (this) {
                if (studentList == null) {
                    studentList = studentListNew;
                }
            }
        }
        return studentList;
    }

    /**
     * Resets a to-many relationship, making the next get call to query for a fresh result.
     */
    @Generated(hash = 1628625923)
    public synchronized void resetStudentList() {
        studentList = null;
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 128553479)
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 1942392019)
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 713229351)
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }

    /**
     * called by internal mechanisms, do not call yourself.
     */
    @Generated(hash = 574607210)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getClassModelDao() : null;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (id == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(id);
        }
        dest.writeLong(classId);
        dest.writeString(className);
    }

    @Override
    public String toString() {
        return "ClassModel{" +
                "id=" + id +
                ", classId=" + classId +
                ", className='" + className + '\'' +
                ", studentList=" + studentList +
                ", daoSession=" + daoSession +
                ", myDao=" + myDao +
                '}';
    }
}
