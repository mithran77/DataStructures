javac -cp src test/DoublyLinkedListTest.java -d build
java -cp build DoublyLinkedListTest

javac -cp src test/PrintParenthesizedExpression.java -d build
java -cp build PrintParenthesizedExpression

javac -cp src test/QueueTest.java -d bin
java -cp bin QueueTest

javac -cp src test/TreeTest.java -d build
java -cp build TreeTest

javac -cp src test/VectorTest.java -d build
java -cp build VectorTest


rm -rf ./build/*.class
