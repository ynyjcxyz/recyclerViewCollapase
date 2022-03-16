package com.codixlab.collapsingrecyclerview.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import com.codixlab.collapsingrecyclerview.R;
import com.codixlab.collapsingrecyclerview.model.Person;
import com.codixlab.collapsingrecyclerview.model.PersonModel;

import java.util.ArrayList;
import java.util.List;

public class Data {
    public static List<PersonModel> getPersonsData(Context context) {
        List<PersonModel> people = new ArrayList<>();
        String[] persons = context.getResources().getStringArray(R.array.people);
        TypedArray images = context.getResources().obtainTypedArray(R.array.images);
        for (int i = 0; i < persons.length; i++) {
            Person person = new Person(persons[i], images.getResourceId(i, -1));
            people.add(new PersonModel(person, false));
        }
        images.recycle();
        return people;
    }

}
