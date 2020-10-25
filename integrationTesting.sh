#!/bin/sh
result=0
kotlinc src/CommonAlgorithm.kt src/InputParser.kt src/ReplacementPosition.kt src/VirtMem.kt src/VirtualMemory.kt -include-runtime -d virtMem.jar
for ((i = 1 ; i <= 10 ; i++)); do
  java -jar virtMem.jar data/test${i}.in > output.txt
  if (diff expectedAnswers/out${i}.in output.txt); then
    echo "$i: passed"
  else
    echo "$i: failed"
    result=1
  fi;
  truncate -s 0 output.txt
done
exit $result

