package com.gll.gllandroidstudy.db.model;


import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Generated;

/**
 * 学生
 */
@Entity
public class StudentModel {
    @Id(autoincrement = true)
    private Long id;
    @NotNull
    private Long studentId;
    private String studentName;
    private String studentPhoto;


    @Generated(hash = 1020324676)
    public StudentModel(Long id, @NotNull Long studentId, String studentName,
            String studentPhoto) {
        this.id = id;
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentPhoto = studentPhoto;
    }


    @Generated(hash = 2060229341)
    public StudentModel() {
    }

    public StudentModel(Long studentId) {
        this.studentId = studentId;
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


    public Long getId() {
        return this.id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public Long getStudentId() {
        return this.studentId;
    }


    public void setStudentId(Long studentId) {
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
}
