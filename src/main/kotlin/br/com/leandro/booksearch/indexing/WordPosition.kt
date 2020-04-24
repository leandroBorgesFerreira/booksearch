package br.com.leandro.booksearch.indexing

data class WordPosition(val page: Int, val line: Int, val position: Int)

fun WordPosition.toHumanString() = "|p:$page,l:$line,p:$position| "