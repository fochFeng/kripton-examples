package com.abubusoft.kripton.examplea0.data.model;

import com.abubusoft.kripton.android.annotation.BindTable;
import com.abubusoft.kripton.annotation.BindType;

/**
 * Created by xcesco on 21/07/2017.
 */

@BindType
@BindTable
public class Person {

    public long id;

    public String name;

    public int age;
}
