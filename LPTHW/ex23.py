#strings, bytes, character incoding


#import from system
import sys

#looks like a new way to get and unpack argv

script, encoding, error = sys.argv

#defines a fx with 3 arguments
#im thinking that .readline moves the read head forward to the /n line, and then
#stops, which allows it to keep iterating?

#language_file is a file object

def main(language_file, encoding, errors):
    line = language_file.readline()

#if read.line returns something, if line returns True, if it hits end of document
#and returns nothing, then it defaults to false, code no longer runs.

    if line:
        #defined below
        print_line(line, encoding, errors)
        #calls fx inside of itself, setting up a loop. will run whole if line is True
        return main(language_file, encoding, errors)

def print_line(line, encoding, errors):
    #acts like trim() in excel without arguments, removes whitespaces
    next_lang = line.strip()
    raw_bytes = next_lang.encode(encoding, errors=errors)
    cooked_string = raw_bytes.decode(encoding,errors=errors)
    print(raw_bytes, "<===>", cooked_string)


languages = open("ex22_sample.txt",encoding="utf-8")

main(languages, encoding, error)
