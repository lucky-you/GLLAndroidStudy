package com.gll.gllandroidstudy.db.utils;

import com.gll.gllandroidstudy.ClassModelDao;
import com.gll.gllandroidstudy.SchoolModelDao;
import com.gll.gllandroidstudy.StudentModelDao;
import com.gll.gllandroidstudy.db.manager.DBManager;
import com.gll.gllandroidstudy.db.model.ClassModel;
import com.gll.gllandroidstudy.db.model.SchoolModel;
import com.gll.gllandroidstudy.db.model.StudentModel;

import java.util.List;

public class DbUtils {


    public static void insertStudent(StudentModel studentModel) {
        StudentModelDao dao = DBManager.getInstance().getStudentModelDao();
        List<StudentModel> list = dao.queryBuilder().list();
        if (list.size() > 0) {
            dao.delete(list.get(0));
        }
        dao.insert(studentModel);
    }

    public static void insertClassModel(ClassModel classModel) {
        ClassModelDao dao = DBManager.getInstance().getClassModelDao();
        List<ClassModel> list = dao.queryBuilder().list();
        if (list.size() > 0) {
            dao.delete(list.get(0));
        }
        dao.insert(classModel);
    }

    public static void insertSchoolModel(SchoolModel schoolModel) {
        SchoolModelDao dao = DBManager.getInstance().getSchoolModelDao();
        List<SchoolModel> list = dao.queryBuilder().list();
        if (list.size() > 0) {
            dao.delete(list.get(0));
        }
        dao.insert(schoolModel);
    }
}
