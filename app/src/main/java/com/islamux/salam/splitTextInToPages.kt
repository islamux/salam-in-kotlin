package com.islamux.salam

import androidx.compose.runtime.Composable

@Composable
fun splitTextIntoPages(content: String): List<String> {
    // هنا يجب عليك تطبيق منطق تقسيم النص بناءً على حجم الصفحة
    // هذا مجرد مثال مبسط، ستحتاج لتطويره بناءً على المساحة المتاحة

    val maxCharsPerPage = 1000 // مثال، يجب تعديل القيمة بناءً على حجم النص
    val words = content.split(" ")
    val pages = mutableListOf<String>()
    var currentPage = StringBuilder()

    for (word in words) {
        if (currentPage.length + word.length > maxCharsPerPage) {
            pages.add(currentPage.toString())
            currentPage = StringBuilder()
        }
        currentPage.append("$word ")
    }

    if (currentPage.isNotEmpty()) {
        pages.add(currentPage.toString())
    }

    return pages
}
