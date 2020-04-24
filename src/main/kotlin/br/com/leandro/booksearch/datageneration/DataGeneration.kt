package br.com.leandro.booksearch.datageneration

import br.com.leandro.booksearch.book.domain.Book
import br.com.leandro.booksearch.book.domain.Line
import br.com.leandro.booksearch.book.domain.Page

//reference: https://kitty-ipsum.com/
private fun kittyIpsum(): List<String> = "Miav meogre miaou mjá miáú. Miav miav miauw miauw niaou. Miyav nyā mi'au νιάου mňau miav miáú".split(" ")

private fun kittyContent(): List<Line> =
    listOf(
        Line(1, kittyIpsum()),
        Line(2, kittyIpsum()),
        Line(3, kittyIpsum()),
        Line(4, kittyIpsum())
    )

private fun relevantContent(): List<String> = "Are you looking for me??".split(" ")

private fun kittyPage(page: Int) = Page(page, kittyContent())

private fun relevantPage(page: Int): Page =
    Page(page,
        listOf(
            Line(1, kittyIpsum()),
            Line(2, kittyIpsum()),
            Line(3, kittyIpsum()),
            Line(4, kittyIpsum()),
            Line(5, relevantContent()),
            Line(6, kittyIpsum()),
            Line(7, kittyIpsum()),
            Line(8, kittyIpsum())
        )
    )

fun kittyBook(): Book =
    Book(
        "Kitty, the cat",
        listOf(
            kittyPage(1),
            kittyPage(2),
            kittyPage(3),
            kittyPage(4),
            kittyPage(5),
            relevantPage(6)
        )
    )