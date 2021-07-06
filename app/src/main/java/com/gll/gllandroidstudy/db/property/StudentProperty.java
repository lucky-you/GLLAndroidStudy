package com.gll.gllandroidstudy.db.property;

import com.gll.gllandroidstudy.db.model.ClassModel;
import com.gll.gllandroidstudy.db.model.StudentModel;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.greenrobot.greendao.converter.PropertyConverter;

import java.util.List;

public class StudentProperty implements PropertyConverter<List<StudentModel>,String> {
    @Override
    public List<StudentModel> convertToEntityProperty(String databaseValue) {
        if (databaseValue == null) {
            return null;
        }
        // 先得获得这个，然后再typeToken.getType()，否则会异常
        TypeToken<List<StudentModel>> typeToken = new TypeToken<List<StudentModel>>(){};
        return new Gson().fromJson(databaseValue, typeToken.getType());
    }

    @Override
    public String convertToDatabaseValue(List<StudentModel> arrays) {
        if (arrays == null||arrays.size()==0) {
            return "";
        } else {
            String sb = new Gson().toJson(arrays);
            return sb;
        }
    }
}
