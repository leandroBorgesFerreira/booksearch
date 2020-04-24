package br.com.leandro.booksearch.indexing

import br.com.leandro.booksearch.book.domain.Book


//Problem: Everything is allocated in memory here - InputStream would solve this problem
private fun parseBook(book: Book): List<Pair<String, WordPosition>> =
    book.pages.mapIndexed { pageNumber, page ->
        page.linesList.mapIndexed { lineNumber, line ->
            line.content.mapIndexed { positionNumber, word ->
                word to WordPosition(pageNumber, lineNumber, positionNumber)
            }
        }
    }
        .flatten()
        .flatten()

//Instead of book, a InputStream would be the correct parameters
fun parseIndexes(book: Book): Map<String, List<WordPosition>> {
    val wordMap: MutableMap<String, MutableList<WordPosition>> = hashMapOf()

    parseBook(book).forEach { (word, position) ->
        wordMap[word] = wordMap[word]?.apply { add(position) } ?: listOf(position).toMutableList()
    }

    return wordMap
}