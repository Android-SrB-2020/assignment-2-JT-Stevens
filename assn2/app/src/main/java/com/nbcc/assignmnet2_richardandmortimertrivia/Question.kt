package com.nbcc.assignmnet2_richardandmortimertrivia

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Question (var Id: String, var answer:Boolean): Parcelable