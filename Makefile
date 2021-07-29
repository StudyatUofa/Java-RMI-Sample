ROOT=$(PWD)
BUILD_ROOT=build
SRC=src/au/edu/adelaide/ds

# https://www.cs.swarthmore.edu/~newhall/unixhelp/javamakefiles.html
JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) -cp ${BUILD_ROOT} -d ${BUILD_ROOT} $*.java

CLASSES = \
	${SRC}/WordCounter.java \
	${SRC}/WordCounterImplementation.java \
	${SRC}/WordCounterClient.java \
	${SRC}/WordCounterServer.java

default: classes

classes: $(CLASSES:.java=.class)

clean:
	rm -rf ${BUILD_ROOT}/*

run_server: classes
	echo "Running server ..."
	java -cp ${BUILD_ROOT} au.edu.adelaide.ds.WordCounterServer 

run_client: classes
	echo "Running client ..."
	java -cp ${BUILD_ROOT} au.edu.adelaide.ds.WordCounterClient
