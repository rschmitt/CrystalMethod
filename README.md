CrystalMethod
=============

CrystalMethod brings Clojure-style multimethods to Java 8.

# Features

* **Fully type-safe.** Through advanced use of Java generics, all multimethod definitions and calls are completely type-safe. No downcasting is required; no `ClassCastExceptions` are possible.
* **Completely general.** CrystalMethod allows you to dispatch calls any way you want. You can dispatch based on the types, values, and attributes of any number of arguments.
* **Zero dependencies.** Builds out of box; runs on any platform that supports Java 8.
* **A straightforward implementation.** CrystalMethod is implemented entirely with Java's built-in reflection capabilities. This means it doesn't break every time Oracle releases a JVM security update.
* **Concise.** Thanks to Java 8 features like method references, creating and using multimethods requires surprisingly little code.
* **Injectible.** Multimethods can be globally defined, but they can also be instantiated and injected like any other dependency.

# Theory

Runtime polymorphism allows developers to separate *what* from *how*. To Java developers, this is generally achieved through the use of subtype polymorphism, usually through interfaces. Interfaces have some excellent properties:

* They *completely* separate interface from implementation: unlike concrete derivation (e.g. extending an abstract base class), interfaces don't mix in implementation details like fields
* They are open: developing new implementations of an interface does not require modifications to the interface or to any code that depends on it
* They are concise: as Stuart Halloway observed, interfaces are the least bureaucratic construct in Java; every word of an interface is meaningful and serves a purpose

However, subtype polymorphism is very limited in how it can actually dispatch. It can only dispatch based on the type of the object the method is invoking on. It can't dispatch according to values instead of types, and it can't dispatch based on any properties of the arguments. Method implementations can inspect those things of course, but that sacrifices openness: if your "dispatch" consists of a switch statement that looks at the value of a string to decide which function to call, you can't install new methods without actually modifying the code of the dispatch routine in order to associate new methods with their respective dispatch values. The traditional OO replacement for multiple dispatch is the visitor pattern, which is possibly the most complex of all the classic GoF design patterns.

With CrystalMethod, truly à la carte polymorphism is possible, independent of type hierarchies and without the need to specify a privileged first argument, such as the `cake` in `cake.bake(oven)`. One can simply call a function, `bake(cake, oven)`, that can dispatch according to any properties of any of its arguments. As new cakes and ovens are developed, the `bake` multimethod remains flexible and adaptable; it does not need to be modified to accommodate change.

# Practice

In CrystalMethod, a multimethod is declared as an interface. (This is what makes it possible to have *type-safe* multimethods.) The general form of a multimethod declaration is:

```java
interface MultimethodName extends MultimethodN<DispatchType, ArgTypes..., ReturnType>;
```

Note that there are several `Multimethod` types; one for each arity. A multimethod that takes six arguments will extend `Multimethod6`. A multimethod that takes only one argument will just extend `Multimethod`. To create a multimethod that returns nothing, supply a return type of `java.lang.Void`.

There are two ways to define a multimethod. The first way is to simply define it globally, using the static methods on the `CrystalMethod` class:

```java
// first define a multimethod that takes a double, returns an int, and dispatches on a string
interface GlobalMethod extends Multimethod<String, Double, Integer> {}

// create a new method with this::dispatch as the dispatch method;
// the compiler will check that dispatch is a function from double to string
CrystalMethod.defMulti(this::dispatch, GlobalMethod.class);

// Associate the dispatch value "3" with this::m1;
// m1 must be a function from double to int for this to compile
CrystalMethod.addMethod("3", this::m1, GlobalMethod.class);

// call the multimethod (this is also type safe; the second argument must be a double)
CrystalMethod.invoke(GlobalMethod.class, 3.1);
```

The second way is to actually instantiate the multimethod type:

```java
enum Letter { A, B }
interface LetterMethod extends Multimethod<Letter, Integer, String> {}

// create a map listing all the dispatch values and associated functions
Map<Letter, Function<Integer, String>> dictionary = new HashMap<>();
dictionary.put(Letter.A, this::letterA);
dictionary.put(Letter.B, this::letterB);

// call buildMultimethod to instantiate the multimethod
LetterMethod letterMethod = CrystalMethod.buildMultimethod(this::dispatch, dictionary, LetterMethod.class);

// call the multimethod exactly like any lambda expression
letterMethod.apply(0)
```

# Implementation notes

Java has no support for variadic generics, so the CrystalMethod source code is actually generated by a Perl script. Currently, multimethods with up to nine parameters are supported.
