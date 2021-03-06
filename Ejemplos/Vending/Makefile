#!/usr/bin/make -f
# -*- mode:makefile -*-

DIRBIN := bin/
DIRGEN := generated/
DIRLIB := lib/
DIRSRC := src/

PARENT_PACKAGE := moomaui

MOOMA_GENERATED_PACKAGE = $(PARENT_PACKAGE).domain
MOOMA_FILE := main.py
MOOMA_OPTIONS := -p $(MOOMA_GENERATED_PACKAGE) -o $(DIRGEN)$(PARENT_PACKAGE)/domain

MOOMA_AUTOMATON_FILE := $(DIRSRC)Vending.moo

JC := javac
JVM := java
PY3 := py -3

ifeq ($(OS),Windows_NT)
    PATH_SEPARATOR := ;
else
    PATH_SEPARATOR := :
endif

all: folders compile_automaton copy_files compile_program run_program

compile_automaton:
	$(PY3) $(DIRLIB)$(MOOMA_FILE) $(MOOMA_AUTOMATON_FILE) $(MOOMA_OPTIONS)

copy_files:
	cp -r $(DIRSRC)moomaui $(DIRGEN)

compile_program:
	$(JC) $(DIRGEN)$(PARENT_PACKAGE)/domain/*.java $(DIRGEN)$(PARENT_PACKAGE)/presentation/*.java $(DIRGEN)$(PARENT_PACKAGE)/presentation/drawing/*.java -d $(DIRBIN)

run_program:
	$(JVM) -cp bin moomaui.presentation.MainWindow

folders:
	mkdir -p $(DIRBIN)
	mkdir -p $(DIRGEN)
	mkdir -p $(DIRGEN)$(PARENT_PACKAGE)/domain

clean: 
	rm -rf $(DIRBIN)
	rm -rf $(DIRGEN)

.PHONY: all, copy_files, compile_automaton, run_program, folders, clean
