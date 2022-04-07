#!/bin/bash

# Chapt 14 Handling User Input Project
# shellsearch with options to display user info based on user's shell, searches an /etc/passwd-like file.


usageStatement () {
	echo
	echo " Usage: shellsearch [OPTION...] "
	echo
	echo " - a          Display users with all shells. Cannot be used with -s."
	echo " - f FILE     Search in FILE. FILE must be formatted with absolute path."
	echo " - h          Display usage information."
	echo " - s SHELL    Display users with SHELL shell. SHELL must be in /etc/shells."
	echo "              Cannot be used with -a"
	echo
	echo
}

unitTesting() {
	echo "a is $choicea"
	echo "f is $choicef"
	echo "h is $choiceh"
	echo "s is $choices"
	echo "fileInput is $fileInput"
	echo "shellInput is $shellInput"
}

# parses a /etc/passwd like file. Used per discussion

parseFile() {
	while IFS=: read -r uName pw uID gID fullName homeDir cmdShell
	do
		echo -e "Username: ""$uName""\t\tFull Name: ""$fullName""\tShell: ""$cmdShell"
	done < "$passwdPath"

}

#define default filePath

passwdPath=/home/faculty/dkitchin/examples/chapter14/project_passwd

# unpack option/param stream and create switchboard for choice logic. Will flip to 1 if option is found in userInput

choicea=0
choicef=0
choiceh=0
choices=0
shellInput=""

#note: for the -s -a error, this defaults to the no param provided to -s if -s has no param"

# if no options used, display usage statement

if [ $# -eq 0 ]
then
	usageStatement
	exit 1
fi

#having a hard time with f having an optional argument. decided to make in non-mandatory here, and check for it in the first list of params after the shift OPTIND-1

while getopts :ahfs: opt
do
	case "$opt" in
		a) choicea=1;;
		f) choicef=1;;
		h) choiceh=1
		   usageStatement;;
		s) choices=1
		   shellInput=$OPTARG;;
		\:) echo "argument missing from $OPTARG"
		    usageStatement
		    exit 1;; # Documentation GNU Manual
		*) echo "Error: Option Error: $OPTARG"
		   usageStatement;;
	esac

done

shift $[ $OPTIND - 1 ]


# check if -a and -s are used together, error out if so.

if [[ $choicea -eq 1 && $choices -eq 1 ]]
then
	echo
	echo "Error: -a and -s flags cannot be used together"
	exit 1
fi

# implement -a option per discussion. imported from dkitchin/examples

if [ $choicea -eq 1 ]
then
	echo "Displaying users in $passwdPath"
	parseFile
fi


# implement -s option. Display users with SHELL. Shell must be in /etc/shells.

if [ $choices -eq 1 ]
then
	if grep -w "$shellInput" /etc/shells > /dev/null
	then
		parseFile | grep $shellInput
	else
		echo "$shellInput was not found in /etc/shells. Please try again"
		exit 1
	fi

fi






# implement -f option. if no param, defaults to predefined passwdPath. if given param, will try that file.


if [ $choicef -eq 1 ]
then
	if [ -n "$1" ]
	then
		if [ -f "$1" ]
		then
			passwdPath=$1
		else
			echo "$1 is not a valid / accessible path"
			exit 1
		fi
	fi

	echo "Displaying users in $passwdPath"
	parseFile
fi







[rdanie12@ats-cis bin]$