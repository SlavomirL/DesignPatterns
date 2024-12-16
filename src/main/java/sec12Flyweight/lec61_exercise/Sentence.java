package sec12Flyweight.lec61_exercise;

import java.util.*;

/*
*
*
Flyweight Coding Exercise
You are given a class called Sentence , which takes a string such as "hello world". You need to provide a method called getWord()  that returns a WordToken  which can be used to capitalize a particular word in the sentence.

Typical use would be something like:

var sentence = new Sentence("hello world");
sentence.getWord(1).capitalize = true;
System.out.println(sentence); // writes "hello WORLD"
*
* */


class Sentence
{
    public Sentence(String plainText)
    {
        // todo
    }

    public WordToken getWord(int index)
    {
        // todo
    }

    @Override
    public String toString()
    {
        // todo
    }

    class WordToken
    {
        public boolean capitalize;
    }
}