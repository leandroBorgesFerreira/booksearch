package br.com.leandro.booksearch.fileio

import br.com.leandro.booksearch.domain.Book
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import java.io.File

private fun writeToFile(json: String, fileName: String) {
    File(fileName).bufferedWriter().use { out -> out.write(json) }
}

fun writeBookToFile(book: Book) {
    writeToFile(getGson().toJson(book), book.title)
}

fun readBookFromFile(fileName: String): Book =
    File(fileName).bufferedReader().use { reader ->
        getGson().fromJson(reader, Book::class.java)
    }

private fun getGson(): Gson = GsonBuilder()
    .setPrettyPrinting()
    .create()