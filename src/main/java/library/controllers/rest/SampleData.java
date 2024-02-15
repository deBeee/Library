package library.controllers.rest;

import library.model.Book;

import java.util.List;

public interface SampleData {
    List<Book> sampleBooksData = List.of(
            new Book("Czysty kod", "Robert C. Martin", "978-83-832-2344-5", 3),
            new Book("Ścieżka testera", "Rafał Podraza", "978-83-283-9802-3", 8),
            new Book("Certyfikowany tester ISTQB", "Adam Roman, Lucjan Stapp", "978-83-832-2185-4", 5),
            new Book("Podstawy matematyki w data science", "Thomas Nield", "978-83-832-2013-0", 7),
            new Book("Złożone zagadnienia architektury oprogramowania", "Neal Ford, Mark Richards", "978-83-283-9527-5", 2),
            new Book("C++ Zbiór zadań z rozwiązaniami", "Tomasz Jaśniewski", "978-83-832-2202-8", 6),
            new Book("Praktyczne wprowadzenie do hakingu", "Daniel Graham", "978-83-283-9419-3", 4),
            new Book("Sztuczna inteligencja. Nowe spojrzenie", "Stuart Russell, Peter Norvig", "978-83-283-7608-3", 9),
            new Book("Python. Instrukcje dla programisty", "Eric Matthes", "978-83-283-6360-1", 1),
            new Book("Pragmatyczny programista", "David Thomas, Andrew Hunt", "978-83-283-7139-2", 10),
            new Book("Tworzenie gier 2D w Unity 2022", "Arkadiusz Brzegowy", "978-83-832-2117-5", 2),
            new Book("SQL dla analityków danych", "Renée M. P. Teate", "978-83-283-9744-6", 8),
            new Book("SQL w mgnieniu oka", "Ben Forta", "978-83-283-9490-2", 6),
            new Book("Architektura oprogramowania bez tajemnic", "Adrian Ostrowski, Piotr Gaczkowski", "978-83-283-8666-2", 5),
            new Book("Opus magnum C++. Misja w nadprzestrzeń C++14/17", "Jerzy Grębosz", "978-83-832-2582-1", 7),
            new Book("Programowanie. Teoria i praktyka z wykorzystaniem C++", "Bjarne Stroustrup", "978-83-283-6312-0", 3)
    );
}
