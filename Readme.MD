HomeWork 9. 


Вырезка из статьи https://habr.com/en/articles/551902/
Конструктор по умолчанию
JPA требует включения в классы сущностей конструкторов по умолчанию:
    The entity class must have a no-arg constructor.
    — JSR 338: JavaTM Persistence API; Version 2.2; "2.1 The Entity Class", https://github.com/javaee/jpa-spec/blob/master/jsr338-MR/JavaPersistence.pdf

При этом конструкторы по умолчанию являются анти-паттерном и бомбой замедленного действия - они позволяют создавать объекты, нарушающие инварианты, и создают временную связанность. 
Эту проблему можно частично обойти, сделав конструктор по умолчанию package private и пометив его @Deprecated. 
