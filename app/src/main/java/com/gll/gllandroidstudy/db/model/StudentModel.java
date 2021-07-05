package com.gll.gllandroidstudy.db.model;


import android.os.Parcel;
import android.os.Parcelable;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;

/**
 * 学生
 */
@Entity
public class StudentModel implements Parcelable {
    @Id(autoincrement = true)
    private Long id;
    @NotNull
    private long studentId;
    private String studentName;
    private String studentPhoto;

    @Generated(hash = 1005403856)
    public StudentModel(Long id, long studentId, String studentName,
                        String studentPhoto) {
        this.id = id;
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentPhoto = studentPhoto;
    }

    @Generated(hash = 2060229341)
    public StudentModel() {
    }

    public StudentModel(long studentId) {
        this.studentId = studentId;
    }

    public StudentModel(long studentId, String studentName) {
        this.studentId = studentId;
        this.studentName = studentName;
    }

    protected StudentModel(Parcel in) {
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readLong();
        }
        studentId = in.readLong();
        studentName = in.readString();
        studentPhoto = in.readString();
    }

    public static final Creator<StudentModel> CREATOR = new Creator<StudentModel>() {
        @Override
        public StudentModel createFromParcel(Parcel in) {
            return new StudentModel(in);
        }

        @Override
        public StudentModel[] newArray(int size) {
            return new StudentModel[size];
        }
    };

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getStudentId() {
        return this.studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return this.studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentPhoto() {
        return this.studentPhoto;
    }

    public void setStudentPhoto(String studentPhoto) {
        this.studentPhoto = studentPhoto;
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
        dest.writeLong(studentId);
        dest.writeString(studentName);
        dest.writeString(studentPhoto);
    }


    @Override
    public String toString() {
        return "StudentModel{" +
                "id=" + id +
                ", studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", studentPhoto='" + studentPhoto + '\'' +
                '}';
    }
}
