package com.gll.gllandroidstudy.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.gll.gllandroidstudy.ClassModelDao;
import com.gll.gllandroidstudy.R;
import com.gll.gllandroidstudy.base.BaseActivity;
import com.gll.gllandroidstudy.db.manager.DBManager;
import com.gll.gllandroidstudy.db.model.ClassModel;
import com.gll.gllandroidstudy.db.model.SchoolModel;
import com.gll.gllandroidstudy.db.model.StudentModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GreenDaoActivity extends BaseActivity {


    @Override
    protected void loadViewLayout() {
        setContentView(R.layout.activity_green_dao);
    }

    private EditText editSchoolID, editSchoolName, editClassOneID, editClassOneName, editClassOneStudentOne,
            editClassOneStudentTwo, editClassOneStudentThree, editClassTwoID, editClassTwoName,
            editClassTwoStudentOne, editClassTwoStudentTwo, editClassTwoStudentThree, editClassTwoStudentFour;


    @Override
    protected void bindViews() {
        initTitle("GreenDao的使用");
        get(R.id.btnSaveData).setOnClickListener(this::onClick);
        get(R.id.btnDeleteData).setOnClickListener(this::onClick);
        get(R.id.btnQueryData).setOnClickListener(this::onClick);
    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {
        editSchoolID = get(R.id.editSchoolID);
        editSchoolName = get(R.id.editSchoolName);

        editClassOneID = get(R.id.editClassOneID);
        editClassOneName = get(R.id.editClassOneName);

        editClassOneStudentOne = get(R.id.editClassOneStudentOne);
        editClassOneStudentTwo = get(R.id.editClassOneStudentTwo);
        editClassOneStudentThree = get(R.id.editClassOneStudentThree);

        editClassTwoID = get(R.id.editClassTwoID);
        editClassTwoName = get(R.id.editClassTwoName);

        editClassTwoStudentOne = get(R.id.editClassTwoStudentOne);
        editClassTwoStudentTwo = get(R.id.editClassTwoStudentTwo);
        editClassTwoStudentThree = get(R.id.editClassTwoStudentThree);
        editClassTwoStudentFour = get(R.id.editClassTwoStudentFour);


    }

    @Override
    protected void setListener() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnSaveData:
                //保存数据
                showCusDialog(true);
                break;
            case R.id.btnDeleteData:
                //删除数据
                showCusDialog(false);
                break;
            case R.id.btnQueryData:
                //查询数据
                List<SchoolModel> schoolModelList = DBManager.getInstance().getSchoolModelDao().queryBuilder().build().list();
//                List<ClassModel> classModelList = DBManager.getInstance().getClassModelDao().queryBuilder().build().list();
//                List<StudentModel> studentModelList = DBManager.getInstance().getStudentModelDao().queryBuilder().build().list();
//                Log.e("xy", "schoolModelList:" + schoolModelList + "\n classModelList:" + classModelList + "\nstudentModelList:" + studentModelList);
                if (schoolModelList != null && !schoolModelList.isEmpty()) {
                    Long schoolId = schoolModelList.get(0).getId();
                    List<ClassModel> classModelList = DBManager.getInstance().getClassModelDao().queryBuilder().where(ClassModelDao.Properties.ClassId.eq(schoolId)).build().list();

                    if (classModelList != null && !classModelList.isEmpty()) {
                        for (int i = 0; i < classModelList.size(); i++) {
                            Log.e("xy", "classLongId:" + classModelList.get(i).getId() + "---className:" + classModelList.get(i).getClassName());
                        }
                    }
                }


                break;

        }
    }

    private void saveData() {

        /*  *//*班级1的学生*//*
        List<StudentModel> studentModelOneList = new ArrayList<>();

        StudentModel classOneStudentOne = new StudentModel(Long.parseLong(editClassOneStudentOne.getText().toString().trim()));
        StudentModel classOneStudentTwo = new StudentModel(Long.parseLong(editClassOneStudentTwo.getText().toString().trim()));
        StudentModel classOneStudentThree = new StudentModel(Long.parseLong(editClassOneStudentThree.getText().toString().trim()));

        studentModelOneList.add(classOneStudentOne);
        studentModelOneList.add(classOneStudentTwo);
        studentModelOneList.add(classOneStudentThree);

        *//*班级2的学生*//*
        List<StudentModel> studentModelTwoList = new ArrayList<>();

        StudentModel classTwoStudentOne = new StudentModel(Long.parseLong(editClassTwoStudentOne.getText().toString().trim()));
        StudentModel classTwoStudentTwo = new StudentModel(Long.parseLong(editClassTwoStudentTwo.getText().toString().trim()));
        StudentModel classTwoStudentThree = new StudentModel(Long.parseLong(editClassTwoStudentThree.getText().toString().trim()));
        StudentModel classTwoStudentFour = new StudentModel(Long.parseLong(editClassTwoStudentFour.getText().toString().trim()));

        studentModelTwoList.add(classTwoStudentOne);
        studentModelTwoList.add(classTwoStudentTwo);
        studentModelTwoList.add(classTwoStudentThree);
        studentModelTwoList.add(classTwoStudentFour);

        *//*班级1*//*
        List<ClassModel> classModelOneList = new ArrayList<>();
        ClassModel classModelOne = new ClassModel();
        classModelOne.setClassId(Long.parseLong(editClassOneID.getText().toString().trim()));
        classModelOne.setClassName(editClassOneName.getText().toString().trim());
        classModelOneList.add(classModelOne);


        *//*班级2*//*
        List<ClassModel> classModelTwoList = new ArrayList<>();
        ClassModel classModelTwo = new ClassModel();
        classModelTwo.setClassId(Long.parseLong(editClassTwoID.getText().toString().trim()));
        classModelTwo.setClassName(editClassTwoName.getText().toString().trim());
        classModelTwoList.add(classModelTwo);

        *//*学校*//*
        SchoolModel schoolModel = new SchoolModel();
        schoolModel.setSchoolId(Integer.parseInt(editSchoolID.getText().toString().trim()));
        schoolModel.setSchoolName(editSchoolName.getText().toString().trim());
*/
        SchoolModel schoolModel = new SchoolModel();
        schoolModel.setSchoolName("田家炳小学");
        schoolModel.setSchoolId(new Random(1).nextInt(100));
        long schoolTagId = DBManager.getInstance().getSchoolModelDao().insert(schoolModel);


        for (int i = 0; i < 3; i++) {
            ClassModel classModelCus = new ClassModel();
            classModelCus.setClassId(schoolTagId);
            classModelCus.setClassName("田家炳小学班级" + i);

            long classTagId = DBManager.getInstance().getClassModelDao().insert(classModelCus);
            List<StudentModel> studentModelList = new ArrayList<>();
            for (int j = 0; j < 5; j++) {
                StudentModel studentModelCus = new StudentModel();
                studentModelCus.setStudentId(classTagId);
                studentModelCus.setStudentName("学生" + j);
                studentModelCus.setStudentPhoto("http://www.baidu.com");
                studentModelList.add(studentModelCus);
            }
            DBManager.getInstance().getStudentModelDao().insertInTx(studentModelList);

        }


    }

    private void deleteData() {
        DBManager.getInstance().getSchoolModelDao().deleteAll();
        DBManager.getInstance().getClassModelDao().deleteAll();
        DBManager.getInstance().getStudentModelDao().deleteAll();
    }

    private void showCusDialog(boolean isSaveData) {
        AlertDialog alertDialog = new AlertDialog.Builder(mContext).create();
        alertDialog.setMessage(isSaveData ? "确定保存数据？" : "确定删除数据？");
        alertDialog.setCancelable(false);
        alertDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        alertDialog.setButton(DialogInterface.BUTTON_POSITIVE, "确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (isSaveData) {
                    saveData();
                } else {
                    deleteData();
                }
                dialog.dismiss();
            }
        });
        alertDialog.show();
    }
}
