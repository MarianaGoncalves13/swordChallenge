package com.mariana.swordcatchallenge.core.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.ColumnInfo
import androidx.room.Embedded

@Entity(tableName = "cat_breeds")
data class CatBreed(
    @PrimaryKey
    val id: String,
    val name: String,
    val origin: String,
    val temperament: String,
    val description: String,
    @Embedded
    val image: Image,
    @ColumnInfo("life_span")
    val lifeSpan: String,
) {
    constructor() : this("1", "", "", "", "", Image(), "")
}

data class Image(
    @ColumnInfo(name = "image_id")
    val id: String,
    val height: Long,
    val width: Long,
    val url: String
) {
    constructor() : this("", 0, 0, "")
}
