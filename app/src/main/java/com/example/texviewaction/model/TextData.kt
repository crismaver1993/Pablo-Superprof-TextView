package com.example.texviewaction.model

class TextData(
    val boldText: String,
    val color: Int,
    val linkType: Int,
    val count: Int,
    val normalText: String
) {
    override fun toString(): String {
        return "-> TextData(boldText='$boldText', color=$color, linkType=$linkType, count=$count, normalText='$normalText')"
    }
}