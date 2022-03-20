#!/bin/bash

#shellsearch with options to display user info based on user's shell. 

#I want to practice with unix functions, this seemed like a good time to use them

usageStatement() {
    echo
    echo "Usage: shellsearch [OPTION...]"
    echo
    echo "- a       Display users with all shells. Cannot be used with -s."
    echo "- f FILE  Search in FILE. FILE must be formatted with absolute path"
    echo "- h       Display usage information."
    echo "- s       Display users with SHELL shell. SHELL must be in /etc/shells."
    echo "          Cannot be used with -a."
    echo
    echo
}

unitTest() {
    echo "option a is $a"
    echo "option f is $f"
    echo "option h is $h"
    echo "option s is $s"
    echo "fileInput is $fileInput"
    echo 

}