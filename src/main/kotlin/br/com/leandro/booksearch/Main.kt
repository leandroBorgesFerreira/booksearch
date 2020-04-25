package br.com.leandro.booksearch

import br.com.leandro.booksearch.book.domain.Book
import br.com.leandro.booksearch.datageneration.kittyBook
import br.com.leandro.booksearch.indexing.WordPosition
import br.com.leandro.booksearch.indexing.parseIndexes
import br.com.leandro.booksearch.indexing.toHumanString
import br.com.leandro.booksearch.search.findFirstSentence
import br.com.leandro.booksearch.search.findSentence

//Type the sentence you wanna search here!!
private const val SEARCH_SENTENCE = "Are you looking for"

fun main() {
    val book: Book = kittyBook()
    val indexes: Map<String, List<WordPosition>> = parseIndexes(book)
//    printBookOnConsole(book)
//    printPositionsDictionary(indexes)

//    val findResult: List<List<WordPosition>> = findSentence(SEARCH_SENTENCE, indexes)
//
//    if (findResult.isEmpty()) {
//        println("No results found!")
//    } else {
//        printResults(findResult)
//    }

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
    val page = wordPositions.first().page
    val line = wordPositions.first().line

    val firstPosition = wordPositions.first().position
    val lastPosition = wordPositions.last().position

    return "Page - $page, Line: $line, from position: $firstPosition to $lastPosition"
}