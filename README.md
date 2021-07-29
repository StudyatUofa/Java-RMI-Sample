# Java-RMI-Sample
Java RMI example for Distributed Systems course

# How to use this repo

## Requirements
1. Java (JDK) is required. The code was tested on Java 11, but the version of Java doesn't matter. Any version should works.
2. Intellij IDEA is optional but it will make Java development easier. And it is free for tertiary students.

## Download the code
If you are not familiar with `git`, you can just download the code from this [link](https://github.com/StudyatUofa/Java-RMI-Sample/archive/refs/heads/main.zip).
Then uncompress it and import it into Intellij IDEA.

## Clone the repo to your computer

```bash
git clone https://github.com/StudyatUofa/Java-RMI-Sample.git Java-RMI
```
And then use Intellij IDEA to build and run it.

## Compile and run with Makefile
If there is no Intellij IDEA on your computer, you can use Makefile to build and run programs.
### Build programs
Enter the directory where the code is in, run `make` to build programs.
```
make
```
### Run server
```
make run_server
```

### Run client
```
make run_client
```
