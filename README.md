# Booksearch

This project is a solution to search strings in a long text (for example, a book or book collection).

## Introduction

This project contains a conceptual solution for search problems in long texts. Although this solution performs weel and doesn't use much resources, further improvements can be done in this solution. The focus here is to make something easy to read and understand.

## The problem

We need to find a string inside a very big text (a book or a collection of books). Linear search wouldn't work as it would take a lot of time to complete, so a better solution is needed.

## Algoritm/Data structure adopted

One way to search for sentences inside a book is to create a dictionary (a hash map) containing the words position. By searching the map and picking the positions is easy to evaluate if there's a sentence in the book, as the example:

For the hipotetical book:

`My car is blue. My house is blue.`

We create the following dictionary:

```
My -> positions: 1, 5
car -> positions: 2
is: -> positions: 3, 7
blue: -> positions: 4, 8
house: -> positions: 6
```

Searching the sentence: `My house`. We get: `My -> 1, 5` and `House -> 6`. As we have **5** and **6**, sequential numbers, then **we can conclude that this sentence exists in the book** as the words are in sequence. The sentence is located from the 5th to the 6th position.

If we look for: `car blue`. We get `car -> 2` and `blue -> 4, 8`, we see that **2** and **4** are **not sequential**, so **this setence is not in the book**.

The complexity of the solution is related to the amount of repeated words in the book (or book collection), and not the amount of words. So this solution would still be viable for really big book collections.

The keys can be saved in a database and only ones of the words being searched can be brought to memory, so this solution is also viable to sistems of low memory.

## Solution

This solution has some packages:

#### br.com.leandro.domain
This package contains the classes that model that problem, to help to reason about it.

#### br.com.leandro.datageneration
Helper functions to generate a simple book. Usefull for debug purposes.

#### br.com.leandro.fileio
Helper functions to write and read files. Usefull to read the book from a file.

#### br.com.leandro.indexing
Functions to index a book. Those are the functions that creates the position dictionary form a book.

#### br.com.leandro.search
Functions that seaches in the position dictionary for the desired sentence.

### Comments

This solution finds only the first occurence in the book, not all of then. The same concept can be easily expanded to find all of the occurences, but this is not done here as this project have only study/demonstration purposes.

The first try to solve the problem was to use some kind of graph solution. This approach didn't work, as the size of the graph would be huge and the graph structure would be very complex, not being this data structured the best one for this problem. 
