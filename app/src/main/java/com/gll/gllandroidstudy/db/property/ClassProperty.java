package com.gll.gllandroidstudy.db.property;

import com.gll.gllandroidstudy.db.model.ClassModel;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.greenrobot.greendao.converter.PropertyConverter;

import java.util.List;

public class ClassProperty implements PropertyConverter<List<ClassModel>,String> {
    @Override
    public List<ClassModel> convertToEntityProperty(String databaseValue) {
        if (databaseValue == null) {
            return null;
        }
        TypeToken<List<ClassModel>> typeToken = new TypeToken<List<ClassModel>>(){};
        return new Gson().fromJson(databaseValue, typeToken.getType());
    }

    @Override
    public String convertToDatabaseValue(List<ClassModel> arrays) {
        if (arrays == null||arrays.size()==0) {
            return "";
        } else {
            String sb = new Gson().toJson(arrays);
            return sb;
        }
    }
}
