package br.com.leandro.booksearch

import br.com.leandro.booksearch.domain.Book

fun main(args: Array<String>) {
    val book: Book = kittyBook()

    printBookOnConsole(book)

    println("Hello!")
}

fun printBookOnConsole(book: Book) {
    book.pages.forEach { page ->
        println("Page: ${page.number}")
        page.linesList.forEach { line ->
            println("Position ${line.position}: ${line.content}")
        }
    }
}

