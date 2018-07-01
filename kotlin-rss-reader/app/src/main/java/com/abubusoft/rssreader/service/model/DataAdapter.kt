package com.abubusoft.rssreader.service.model

import com.abubusoft.kripton.TypeAdapter
import java.text.DateFormat
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

class DateAdapter : TypeAdapter<Date, String> {

    private var formatter: DateFormat = SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz", Locale.ENGLISH);

    override fun toJava(dataValue: String?): Date? {
        if (dataValue == null) return null
        return try {
            formatter.parse(dataValue)
        } catch (e: ParseException) {
            e.printStackTrace();
            null
        }
    }

    override fun toData(javaValue: Date): String? {
        // we don't need to implement for the moment
        return null
    }

}