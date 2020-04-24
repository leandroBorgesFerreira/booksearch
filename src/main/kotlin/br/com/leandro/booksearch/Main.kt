package br.com.leandro.booksearch

import br.com.leandro.booksearch.book.domain.Book
import br.com.leandro.booksearch.indexing.WordPosition
import br.com.leandro.booksearch.indexing.parseIndexes
import br.com.leandro.booksearch.indexing.toHumanString

fun main() {
    val book: Book = kittyBook()

//    printBookOnConsole(book)

    printPositionsDictionary(parseIndexes(book))
}

private fun printBookOnConsole(book: Book) {
    book.pages.forEach { page ->
        println("--- Page: ${page.number} ---")
        page.linesList.forEach { line ->
            println("Position ${line.position}: ${line.content}")
        }
    }
}

private fun printPositionsDictionary(positionsMap: Map<String, List<WordPosition>>) {
    println("Indexation table")

    positionsMap.forEach { (word, wordPosition) ->
        val positionString = wordPosition.joinToString { it.toHumanString() }
        println("$word: $positionString")
    }
}

