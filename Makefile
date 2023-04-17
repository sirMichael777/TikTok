# binary search program makefile
# Hussein Suleman
# 27 March 2017

.SUFFIXES: .java .class
SRCDIR=src
BINDIR=bin
JAVA=/usr/bin/java
JAVAC=/usr/bin/javac

$(BINDIR)/%.class: $(SRCDIR)/%.java
	$(JAVAC) -d $(BINDIR)/ -cp $(BINDIR) $<

CLASSES2=Node.class BinaryTree.class Post.class Account.class TokTikTree.class Validating.class Menu.class TokTik.class

CLASSES=$(CLASSES2:%.class=$(BINDIR)/%.class)

default: $(CLASSES)

run: $(CLASSES)
	$(JAVA) -cp $(BINDIR) TokTik

clean:
	rm $(BINDIR)/*.class

docs:
	javadoc -d doc/ src/*.java