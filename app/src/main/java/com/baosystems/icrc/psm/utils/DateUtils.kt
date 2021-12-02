package com.baosystems.icrc.psm.utils

import com.google.android.material.datepicker.CalendarConstraints
import com.google.android.material.datepicker.CompositeDateValidator
import com.google.android.material.datepicker.DateValidatorPointBackward
import com.google.android.material.datepicker.DateValidatorPointForward
import java.time.format.DateTimeFormatter
import java.util.*


class DateUtils {
    companion object {
        @JvmStatic
        fun getDateTimePattern(): DateTimeFormatter = DateTimeFormatter.ofPattern(Constants.DATETIME_FORMAT)

        @JvmStatic
        fun getDatePattern(): DateTimeFormatter = DateTimeFormatter.ofPattern(Constants.DATE_FORMAT)

        @JvmStatic
        fun getMonthStartToNowConstraint(): CalendarConstraints {
            val constraintsBuilderRange = CalendarConstraints.Builder()

            val cal = Calendar.getInstance(TimeZone.getTimeZone("UTC"))
            cal.set(Calendar.HOUR_OF_DAY, 0)
            cal.set(Calendar.MINUTE, 0)
            cal.set(Calendar.SECOND, 0)
            val endTime = cal.timeInMillis

            // Month start
            cal.set(Calendar.DAY_OF_MONTH, 0)
            val startTime = cal.timeInMillis

            val dateValidatorMin = DateValidatorPointForward.from(startTime)
            val dateValidatorMax = DateValidatorPointBackward.before(endTime)
            val validators = CompositeDateValidator.allOf(
                listOf(dateValidatorMin, dateValidatorMax)
            )
            constraintsBuilderRange.setValidator(validators)

            return constraintsBuilderRange.build()
        }
    }
}