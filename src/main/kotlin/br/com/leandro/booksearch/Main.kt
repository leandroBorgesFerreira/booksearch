package br.com.leandro.booksearch

import br.com.leandro.booksearch.book.domain.Book
import br.com.leandro.booksearch.datageneration.kittyBook
import br.com.leandro.booksearch.fileio.readBookFromFile
import br.com.leandro.booksearch.fileio.writeBookToFile
import br.com.leandro.booksearch.indexing.WordPosition
import br.com.leandro.booksearch.indexing.parseIndexes
import br.com.leandro.booksearch.indexing.toHumanString
import br.com.leandro.booksearch.search.findFirstSentence
import br.com.leandro.booksearch.search.findSentence

//Type the sentence you wanna search here!!
private const val SEARCH_SENTENCE = "Are you looking for"

fun main() {
    val book: Book = readBookFromFile("Kitty, the cat")
    val indexes: Map<String, List<WordPosition>> = parseIndexes(book)

    findFirstSentence(SEARCH_SENTENCE, indexes)
        .let(::parseAnswer)
        .let { answer ->
            println("--- Answer ---")
            println(answer)
        }
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

private fun printResults(findResult: List<List<WordPosition>>) {
    findResult.map { positions ->
        println(positions.joinToString { it.toHumanString() })
    }
}

private fun parseAnswer(wordPositions: List<WordPosition>) : String {
    val page: Int? = wordPositions.firstOrNull()?.page
    val line: Int? = wordPositions.firstOrNull()?.line

    val firstPosition: Int? = wordPositions.firstOrNull()?.position
    val lastPosition : Int? = wordPositions.lastOrNull()?.position

    return if (firstPosition != null && lastPosition != null) {
        "Page - $page, Line: $line, from position: $firstPosition to $lastPosition"
    } else {
        "Not found"
    }
}